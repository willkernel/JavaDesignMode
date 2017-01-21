package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityTemplateMethodBinding;

import java.util.ArrayList;
import java.util.List;

/**解释一下模板方法模式，就是指：一个抽象类中，有一个主方法，再定义1...n个方法，
 * 可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用*/
public class TemplateMethodActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTemplateMethodBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_template_method);
        List<String> list=new ArrayList<>();
        AbstractCalculator calculator=new Multiply();
        list.add(String.valueOf(calculator.calculate("6*6","\\*")));
        binding.setList(list);
    }

    public abstract class AbstractCalculator {

        /*主方法，实现对本类其它方法的调用*/
        public final int calculate(String exp,String opt){
            int array[] = split(exp,opt);
            return calculate(array[0],array[1]);
        }

        /*被子类重写的方法*/
        abstract public int calculate(int num1,int num2);

        public int[] split(String exp,String opt){
            String array[] = exp.split(opt);
            int arrayInt[] = new int[2];
            arrayInt[0] = Integer.parseInt(array[0]);
            arrayInt[1] = Integer.parseInt(array[1]);
            return arrayInt;
        }
    }

    public class Multiply extends AbstractCalculator {

        @Override
        public int calculate(int num1,int num2) {
            return num1 * num2;
        }
    }
}
