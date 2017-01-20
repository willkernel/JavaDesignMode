package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.controller.Provider;
import com.willkernel.app.javadesignmode.databinding.ActivityAbstractFactoryBinding;
import com.willkernel.app.javadesignmode.utils.SMSFactory;

import java.util.ArrayList;

/**
 * 抽象工厂模式（Abstract Factory）
 * 其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，
 * 则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。
 * 这样做，拓展性较好！
 */
public class AbstractFactoryActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAbstractFactoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_abstract_factory);
        ArrayList<String> list = new ArrayList<>();
        Provider smsProvider = new SMSFactory();
        list.add(smsProvider.provider().send("AbstractFactoryActivity"));
        binding.setList(list);
    }
}