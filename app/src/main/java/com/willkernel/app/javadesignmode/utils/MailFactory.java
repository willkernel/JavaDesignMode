package com.willkernel.app.javadesignmode.utils;

import com.willkernel.app.javadesignmode.controller.Provider;
import com.willkernel.app.javadesignmode.controller.Sender;

/**
 * Created by willkernel on 2017/1/16.
 * mail:willkerneljc@gmail.com
 */

public class MailFactory implements Provider {
    @Override
    public Sender provider() {
        return new MailSender();
    }
}
