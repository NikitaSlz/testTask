package com.example.testTask.controller;

import com.example.testTask.service.CharCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("message")
public class CharCounterController {
    final CharCounterService charCounterService;

    @Autowired
    public CharCounterController(CharCounterService charCounterService) {
        this.charCounterService = charCounterService;
    }


    @PostMapping
    public String inputStr(@RequestBody String inputStr) {
        String result = charCounterService.charCounter(inputStr);
        if (!result.isBlank())
            return result;
        return "Неверный формат входных данных";
    }
}
