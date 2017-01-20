package com.willkernel.app.javadesignmode.controller;

/**
 * Created by willkernel on 2017/1/20.
 * mail:willkerneljc@gmail.com
 */

public class Decorator implements Sourceable {
    private Sourceable source;
    private String TAG = getClass().getSimpleName();

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public String function1(String s) {
        return TAG + source.function1(s);
    }

    @Override
    public String function2(String s) {
        return TAG + source.function2(s);
    }
}