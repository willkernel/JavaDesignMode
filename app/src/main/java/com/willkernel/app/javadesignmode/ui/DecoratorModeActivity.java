package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.controller.Decorator;
import com.willkernel.app.javadesignmode.controller.DecoratorSource;
import com.willkernel.app.javadesignmode.controller.Sourceable;
import com.willkernel.app.javadesignmode.databinding.ActivityDecoratorModeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，
 * 要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 * <p>
 * 装饰器模式的应用场景：
 * 1、需要扩展一个类的功能。
 * 2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
 * 缺点：产生过多相似的对象，不易排错！
 *
 * 有点类似，类的适配器设计模式
 */
public class DecoratorModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDecoratorModeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_decorator_mode);
        Sourceable decoratorSource = new DecoratorSource();
        Sourceable decorator=new Decorator(decoratorSource);
        List<String> list = new ArrayList<>();
        list.add(decorator.function1("Source"));
        list.add(decorator.function2("Decorator"));
        binding.setList(list);
    }
}