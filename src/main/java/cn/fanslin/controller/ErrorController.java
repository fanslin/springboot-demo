package cn.fanslin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fanslin on 16/11/29.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("/404")
    public String notFound() {
        return "error/404";
    }
}
