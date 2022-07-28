package com.flag.flagapp.controller;

import com.flag.flagapp.service.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    final FlagService flagService;

    public MainController(
        @Autowired FlagService flagService
    ) {
        this.flagService = flagService;
    }

    @GetMapping()
    public String getFlags() {
        final String string = "ru,us,ca,ge,";
        flagService.saveFlags(string);
        return "result";
    }
}
