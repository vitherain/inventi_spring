package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vit Herain
 */
@RestController
public class DruhyController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/hello-again")
    public Message getHello() {
        return messageService.getMessage();
    }
}
