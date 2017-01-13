package cn.fanslin.controller;

import cn.fanslin.entity.Entry;
import cn.fanslin.service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fanslin on 16/12/1.
 */
@Controller
public class LoginController {
    private static final String LOGGED_IN = "logged_in";

    @Autowired
    private EntriesService entriesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        List<Entry> entries = entriesService.queryEntry();
        model.addAttribute("entries", entries);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@RequestParam("title") String title,
                         @RequestParam("text") String text) {
        entriesService.createEntries(title,text);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpSession session) {
        if (session.getAttribute(LOGGED_IN) != null) {
            return "redirect:/";
        }
        return "login";
    }

    private boolean verify(String username, String password) {
        return "admin".equals(username) && "password".equals(password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        if (session.getAttribute(LOGGED_IN) != null) {
            return "redirect:/";
        }

        if (!verify(username, password)) {
            return "login";
        }

        session.setAttribute(LOGGED_IN, true);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session) {
        session.removeAttribute(LOGGED_IN);
        return "redirect:/";
    }
}
