package com.flag.flagapp.controller;

import com.flag.flagapp.dto.CodesFromUser;
import com.flag.flagapp.service.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UiController {
    final FlagService flagService;

    public UiController(
        @Autowired FlagService flagService
    ) {
        this.flagService = flagService;
    }

    @RequestMapping()
    public String showMainPage(final Model countriesCodesModel) {
        CodesFromUser codesFromUser = new CodesFromUser();
        countriesCodesModel.addAttribute("countriesCodes", codesFromUser);
        return "main";
    }

    @RequestMapping("/result")
    public String showResultPage(@ModelAttribute("countriesCodes") final CodesFromUser codesFromUser) {
        flagService.saveFlags(codesFromUser.getCodes());
        return "result";
    }
}
