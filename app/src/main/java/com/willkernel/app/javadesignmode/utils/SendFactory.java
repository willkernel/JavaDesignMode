package com.willkernel.app.javadesignmode.utils;

import com.willkernel.app.javadesignmode.controller.Sender;

/**
 * Created by willkernel on 2017/1/13.
 * mail:willkerneljc@gmail.com
 */

public class SendFactory {
    public static final int MAIL = 1;
    public static final int SMS = 2;

    /**
     * 普通工厂模式
     */
    public Sender getSender(int type) {
        switch (type) {
            case MAIL:
                return new MailSender();
            case SMS:
                return new SMSSender();
        }
        return null;
    }

    /**
     * 多个工厂方法模式
     */
    public Sender getMailSender() {
        return new MailSender();
    }

    public Sender getSMSSender() {
        return new SMSSender();
    }

    /**
     * 静态工厂方法模式
     */
    public static Sender mailSender() {
        return new MailSender();
    }

    public static Sender smsSender() {
        return new SMSSender();
    }
}