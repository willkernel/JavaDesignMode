package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.controller.MySubscribe;
import com.willkernel.app.javadesignmode.controller.Observer1;
import com.willkernel.app.javadesignmode.controller.Observer2;
import com.willkernel.app.javadesignmode.databinding.ActivityObserverBinding;
import com.willkernel.app.javadesignmode.utils.LogWK;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 包括这个模式在内的接下来的四个模式，都是类和类之间的关系，不涉及到继承，学的时候应该 记得归纳，
 * 记得本文最开始的那个图。观察者模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki时，
 * 经常会看到RSS图标，就这的意思是，当你订阅了该文章，如果后续有更新，会及时通知你。
 * 其实，简单来讲就一句话：当一个对象变化时，其它依赖该对象的对象都会收到通知，
 * 并且随着变化！对象之间是一种一对多的关系
 */
public class ObserverActivity extends BaseActivity {

    private MySubscribe subscribe;
    private List<String> list;
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityObserverBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observer);
        list = new ArrayList<>();
        subscribe = new MySubscribe();
        list.add(subscribe.add(new Observer1()));
        list.add(subscribe.add(new Observer2()));
        binding.setList(list);
        LogWK.show(TAG, String.valueOf(Calendar.getInstance().get(Calendar.SECOND)));
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add(subscribe.add(new Observer2()));
                subscribe.operation();
            }
        }, 2000);
    }
}