package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityBuildModeBinding;
import com.willkernel.app.javadesignmode.utils.SenderBuilder;

import java.util.List;

public class BuildModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBuildModeBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_build_mode);
        List<String> list=new SenderBuilder().setContent("Build Mode").build();
        binding.setList(list);
    }
}