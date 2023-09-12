package com.example.testTask.controller;

import com.example.testTask.service.CharCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("message")
public class CharCounterController {
    final CharCounterService charCounterService;

    @Autowired
    public CharCounterController(CharCounterService charCounterService) {
        this.charCounterService = charCounterService;
    }

    @GetMapping
    public String inputStr() {
        return "vvedite stroku iz bukv";
    }

    @PostMapping
    public String inputStr(@RequestBody String inputStr) {
        if (charCounterService.checkString(inputStr)) {
            charCounterService.sort();
            return charCounterService.toString();
        } else return "vvedite stroku iz bukv";
    }
}
