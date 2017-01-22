package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityStatePatternBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 核心思想就是：当对象的状态改变时，同时改变其行为，很好理解！
 * 就拿QQ来说，有几种状态，在线、隐身、忙碌等，每个状态对应不同的操作，而且你的好友也能看到你的状态，
 * 所以，状态模式就两点：1、可以通过改变状态来获得不同的行为。2、你的好友能同时看到你的变化
 */
public class StatePatternActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStatePatternBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_state_pattern);
        List<String> list = new ArrayList<>();
        State state = new State();
        Context context = new Context(state);

        //设置第一种状态
        state.setValue("state1");
        list.add(context.method());

        //设置第二种状态
        state.setValue("state2");
        list.add(context.method());
        binding.setList(list);
    }

    public class State {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String method1() {
            return "execute the first opt!";
        }

        public String method2() {
            return "execute the second opt!";
        }
    }

    public class Context {

        private State state;

        public Context(State state) {
            this.state = state;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public String method() {
            if (state.getValue().equals("state1")) {
                return state.method1();
            } else if (state.getValue().equals("state2")) {
                return state.method2();
            }
            return null;
        }
    }
}