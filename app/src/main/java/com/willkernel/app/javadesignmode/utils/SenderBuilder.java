package com.willkernel.app.javadesignmode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willkernel on 2017/1/16.
 * mail:willkerneljc@gmail.com
 */

public class SenderBuilder {
    private List<String> senders;

    public SenderBuilder setContent(String content) {
        senders = new ArrayList<String>();
        MailSender mailSender = new MailSender();
        SMSSender smsSender = new SMSSender();
        senders.add(mailSender.send(content));
        senders.add(smsSender.send(content));
        senders.add(mailSender.send(content + "A"));
        senders.add(smsSender.send(content + "B"));
        senders.add(smsSender.send(content + "C"));
        return this;
    }

    public List<String> build() {
        return senders;
    }
}