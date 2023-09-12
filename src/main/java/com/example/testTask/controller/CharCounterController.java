package com.example.testTask.controller;

import com.example.testTask.model.CharCounter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
public class CharCounterController {
    @PostMapping
    public String str(@RequestBody String str) {
        CharCounter charCounter = new CharCounter();
        if(charCounter.checkString(str)) {
            charCounter.sort();
            return charCounter.toString();
        } else return "vvedite stroku iz bukv";
    }
}
