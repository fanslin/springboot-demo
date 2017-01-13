package cn.fanslin.controller;

import cn.fanslin.entity.Entry;
import cn.fanslin.repository.EntriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fanslin on 16/11/25.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Value("${application.message:Hello World}")
    private String message = "Hi";

    @Autowired
    private EntriesRepository entriesRepository;

    @RequestMapping("/rest")
    public String rest() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return message+", Greetings from Spring Boot!";
    }

    @RequestMapping("/entries")
    @ResponseBody
    public List<Entry> findEntries(){
        List<Entry> entries = entriesRepository.findAll();
        for (Entry entry : entries) {
            logger.info("this is info log {}", entry.toString());
        }
        return entries;
    }


}
