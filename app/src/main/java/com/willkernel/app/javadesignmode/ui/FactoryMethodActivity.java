package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.controller.Sender;
import com.willkernel.app.javadesignmode.databinding.ActivityFactoryMethodBinding;
import com.willkernel.app.javadesignmode.utils.SendFactory;

import java.util.ArrayList;

/**
 * 总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，
 * 所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 */
public class FactoryMethodActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFactoryMethodBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_factory_method);
        ArrayList<String> list = new ArrayList<>();
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.getSender(SendFactory.MAIL);
        list.add(sender.send("MailSender"));
        list.add(sendFactory.getMailSender().send("MailSender"));
        list.add(sendFactory.getSMSSender().send("SMSSender"));
        list.add(SendFactory.mailSender().send("MailSender"));
        list.add(SendFactory.smsSender().send("SMSSender"));
        binding.setList(list);
    }
}