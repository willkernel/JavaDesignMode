package com.willkernel.app.javadesignmode.utils;

import com.willkernel.app.javadesignmode.controller.Sender;

/**
 * Created by willkernel on 2017/1/16.
 * mail:willkerneljc@gmail.com
 */

public class MailSender implements Sender {
    @Override
    public String send(String msg) {
        return "Mail:" + msg;
    }
}