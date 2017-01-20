package com.willkernel.app.javadesignmode.biz;

import com.willkernel.app.javadesignmode.controller.Targetable;
import com.willkernel.app.javadesignmode.utils.Source;

/**
 * 对象的适配器模式
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，
 * 而是持有Source类的实例，以达到解决兼容性的问题。
 */

public class ObjectAdapter implements Targetable{
    private Source source;

    public ObjectAdapter(Source source) {
        this.source = source;
    }

    @Override
    public String method1() {
        return source.method1();
    }

    @Override
    public String method2() {
        return "method 2";
    }
}