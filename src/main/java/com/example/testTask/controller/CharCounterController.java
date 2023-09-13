package com.example.testTask.controller;

import com.example.testTask.service.CharCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("message")
public class CharCounterController {
    final CharCounterService charCounterService;

    @Autowired
    public CharCounterController(CharCounterService charCounterService) {
        this.charCounterService = charCounterService;
    }

    /**
     * Post метод запроса.
     *
     * @param inputStr Входная строка
     * @return Результат выполнения подсчета символов.
     */
    @PostMapping
    public String inputStr(@RequestBody String inputStr) {
        String result = charCounterService.charCounter(inputStr);
        if (!result.isBlank())
            return result;
        return "Неверный формат входных данных";
    }
}
