package com.willkernel.app.javadesignmode.controller;

/**
 * Created by willkernel on 2017/1/21.
 * mail:willkerneljc@gmail.com
 */

public class MySubscribe extends AbstractSubscribe {
    @Override
    public void operation() {
        notifyObservers();
    }
}
