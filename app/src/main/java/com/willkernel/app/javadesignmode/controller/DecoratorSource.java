package com.willkernel.app.javadesignmode.controller;

/**
 * Created by willkernel on 2017/1/20.
 * mail:willkerneljc@gmail.com
 */

public class DecoratorSource implements Sourceable{
    private String TAG=getClass().getSimpleName();
    @Override
    public String function1(String s) {
        return " function1 "+s;
    }

    @Override
    public String function2(String s) {
        return  " function2 "+s;
    }
}