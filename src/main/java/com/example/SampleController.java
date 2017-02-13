package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vit Herain
 */
@RestController
public class SampleController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/hello")
    public List<Message> getHello() {
        return Arrays.asList(messageService.getMessage(), messageService.getMessage());
    }
}
