package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.bean.Prototype;
import com.willkernel.app.javadesignmode.databinding.ActivityPrototypeBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrototypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPrototypeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_prototype);
        List<String> list = new ArrayList<>();
        Prototype p1 = new Prototype();
        p1.setString("P1");
        try {
            Prototype p2 = p1.clone();
            list.add(p2.getString());
            Prototype p3 = (Prototype) p1.deepClone();
            list.add(p2.getString());
            list.add(p3.getString());
            binding.setList(list);
        } catch (CloneNotSupportedException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}