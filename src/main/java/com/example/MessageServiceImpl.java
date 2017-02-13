package com.example;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @author Vit Herain
 */
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MessageServiceImpl implements MessageService {

    private static int COUNT = 0;

    private int kolikata;

    public MessageServiceImpl() {
        COUNT++;
        this.kolikata = COUNT;
    }

    @Override
    public Message getMessage() {
        return new Message("jsem tolikata instance: " + kolikata);
    }
}
