package com.willkernel.app.javadesignmode.biz;

import com.willkernel.app.javadesignmode.controller.Targetable;
import com.willkernel.app.javadesignmode.utils.Source;

/**
 * 类的适配器模式
 * 核心思想就是：有一个Source类，拥有一个方法，待适配，
 * 目标接口是Targetable，通过Adapter类，将Source的功能扩展到Targetable里
 * Targetable接口的实现类就具有了Source类的功能。
 */
public class ClassAdapter extends Source implements Targetable{
    @Override
    public String method2() {
        return "method 2";
    }
}