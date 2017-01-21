package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityBridgeModeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。
 * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，
 * JDBC进行连接数据库的时候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，
 * 原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了
 */
public class BridgeModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBridgeModeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bridge_mode);
        List<String> list = new ArrayList<>();
        Bridge bridge = new MyBridge();
        Sourceable s1 = new SourceSub1();
        bridge.setSource(s1);
        list.add(bridge.method());

        Sourceable s2 = new SourceSub2();
        bridge.setSource(s2);
        list.add(bridge.method());

        binding.setList(list);
    }

    public interface Sourceable {
        String method();
    }

    public class SourceSub1 implements Sourceable {

        @Override
        public String method() {
            return "this is the first sub!";
        }
    }

    public class SourceSub2 implements Sourceable {

        @Override
        public String method() {
            return "this is the second sub!";
        }
    }

    /**
     * 定义一个桥，持有Sourceable的一个实例：
     */
    public abstract class Bridge {
        private Sourceable source;

        //执行的操作
        public abstract String method();

        //获得数据源
        public Sourceable getSource() {
            return source;
        }
        //切换数据源
        public void setSource(Sourceable source) {
            this.source = source;
        }
    }

    public class MyBridge extends Bridge {
        //实现抽象方法
        public String method() {
            return getSource().method();
//            return getSource().method();
        }
    }
}