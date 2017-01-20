package com.willkernel.app.javadesignmode.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
    }

    public View.OnClickListener jump2Factory = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(FactoryMethodActivity.class);
        }
    };

    public View.OnClickListener jump2AbstractFactory = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(AbstractFactoryActivity.class);
        }
    };

    public View.OnClickListener jump2Build = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(BuildModeActivity.class);
        }
    };

    public View.OnClickListener jump2Prototype = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(PrototypeActivity.class);
        }
    };

    public View.OnClickListener jump2Adapter = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(AdapterModeActivity.class);
        }
    };

    public View.OnClickListener jump2Decorator = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(DecoratorModeActivity.class);
        }
    };

    public View.OnClickListener jump2ProxyMode = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(ProxyModeActivity.class);
        }
    };

    public View.OnClickListener jump2FacadeMode = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            jump2Aty(FacadeModeActivity.class);
        }
    };

    private void jump2Aty(Class cls) {
        startActivity(new Intent(this, cls));
    }
}