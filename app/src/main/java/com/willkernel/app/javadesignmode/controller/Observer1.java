package com.willkernel.app.javadesignmode.controller;

import com.willkernel.app.javadesignmode.utils.LogWK;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by willkernel on 2017/1/21.
 * mail:willkerneljc@gmail.com
 */

public class Observer1 implements Observer {
    private String TAG=getClass().getSimpleName();

    @Override
    public void update(Observable observable, Object data) {
        LogWK.show(TAG, "observable=" + observable + "\ndata=" + data);
    }
}