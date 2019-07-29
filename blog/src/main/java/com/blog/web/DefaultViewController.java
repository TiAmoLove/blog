package com.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultViewController {
	
	
	@RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/{page}")
    public String allPage(@PathVariable("page") String page){

        return page;
    }
	
	

}
