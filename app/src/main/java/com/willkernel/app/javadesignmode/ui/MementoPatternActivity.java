package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityMementoPatternBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，
 * 个人觉得叫备份模式更形象些，通俗的讲下：假设有原始类A，A中有各种属性，
 * A可以决定需要备份的属性，备忘录类B是用来存储A的一些内部状态，
 * 类C呢，就是一个用来存储备忘录的，且只能存储，不能修改等操作
 *
 * Original类是原始类，里面有需要保存的属性value及创建一个备忘录类，用来保存value值。
 * Memento类是备忘录类，Storage类是存储备忘录的类，持有Memento类的实例，该模式很好理解
 *
 * 新建原始类时，value被初始化为egg，后经过修改，将value的值置为niu，
 * 最后倒数第二行进行恢复状态，结果成功恢复了。其实我觉得这个模式叫“备份-恢复”模式最形象。
 */
public class MementoPatternActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMementoPatternBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_memento_pattern);
        List<String> list=new ArrayList<>();
        Original original=new Original("original");
        Storage storage=new Storage(original.createMemento());
        original.setValue("memento");
        original.restoreMemento(storage.getMemento());
        list.add(original.getValue());
        binding.setList(list);
    }

    public class Original {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Original(String value) {
            this.value = value;
        }

        public Memento createMemento(){
            return new Memento(value);
        }

        public void restoreMemento(Memento memento){
            this.value = memento.getValue();
        }
    }

    public class Memento {

        private String value;

        public Memento(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public class Storage {

        private Memento memento;

        public Storage(Memento memento) {
            this.memento = memento;
        }

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }
}