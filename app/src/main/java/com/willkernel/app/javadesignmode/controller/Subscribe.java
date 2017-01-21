package com.willkernel.app.javadesignmode.controller;

import java.util.Observer;

/**
 * Created by willkernel on 2017/1/21.
 * mail:willkerneljc@gmail.com
 */

public interface Subscribe {
    /**增加观察者*/
    String add(Observer observer);

    /**删除观察者*/
    void remove(Observer observer);

    /**通知所有观察者*/
    void notifyObservers();

    /**自身的操作*/
    void operation();
}