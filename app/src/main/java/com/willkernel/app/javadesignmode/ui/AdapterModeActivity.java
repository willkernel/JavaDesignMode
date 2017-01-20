package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.biz.ClassAdapter;
import com.willkernel.app.javadesignmode.biz.ObjectAdapter;
import com.willkernel.app.javadesignmode.controller.Targetable;
import com.willkernel.app.javadesignmode.databinding.ActivityAdapterModeBinding;
import com.willkernel.app.javadesignmode.utils.Source;
import com.willkernel.app.javadesignmode.utils.SourceSub1;
import com.willkernel.app.javadesignmode.utils.SourceSub2;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 * 三种适配器模式的应用场景：
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，
 * 创建一个新类，继承原有的类，实现新的接口即可。
 *
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，
 * 持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
 *
 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，
 * 实现所有方法，我们写别的类的时候，继承抽象类即可。
 */
public class AdapterModeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAdapterModeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter_mode);
        Targetable targetable1 = new ClassAdapter();
        List<String> list = new ArrayList<>();
        list.add(targetable1.method1());
        list.add(targetable1.method2());
        Targetable targetable2=new ObjectAdapter(new Source());
        list.add(targetable2.method1());
        list.add(targetable2.method2());
        SourceSub1 sourceSub1=new SourceSub1();
        SourceSub2 sourceSub2=new SourceSub2();
        list.add(sourceSub1.function1("sourceSub1"));
        list.add(sourceSub2.function1("sourceSub2"));
        list.add(sourceSub1.function2("sourceSub1"));
        list.add(sourceSub2.function2("sourceSub2"));
        binding.setList(list);
    }
}