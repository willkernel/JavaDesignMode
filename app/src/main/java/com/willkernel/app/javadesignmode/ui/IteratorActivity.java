package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityIteratorBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 顾名思义，迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较熟悉的话，理解本模式会十分轻松。
 * 这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问
 *
 * 此处我们貌似模拟了一个集合类的过程，感觉是不是很爽？其实JDK中各个类也都是这些基本的东西，
 * 加一些设计模式，再加一些优化放到一起的，只要我们把这些东西学会了，
 * 掌握好了，我们也可以写出自己的集合类，甚至框架！
 */
public class IteratorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIteratorBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_iterator);
        List<String> list = new ArrayList<>();
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            list.add(it.next());
        }
        binding.setList(list);
    }

    public interface Collection {

        Iterator iterator();

        /*取得集合元素*/
        String get(int i);

        /*取得集合大小*/
        int size();
    }

    public interface Iterator {
        //前移
        String previous();

        //后移
        String next();

        boolean hasNext();

        //取得第一个元素
        Object first();
    }

    public class MyCollection implements Collection {

        public String string[] = {"A", "B", "C", "D", "E"};

        @Override
        public Iterator iterator() {
            return new MyIterator(this);
        }

        @Override
        public String get(int i) {
            return string[i];
        }

        @Override
        public int size() {
            return string.length;
        }
    }

    public class MyIterator implements Iterator {

        private Collection collection;
        private int pos = -1;

        public MyIterator(Collection collection) {
            this.collection = collection;
        }

        @Override
        public String previous() {
            if (pos > 0) {
                pos--;
            }
            return collection.get(pos);
        }

        @Override
        public String next() {
            if (pos < collection.size() - 1) {
                pos++;
            }
            return collection.get(pos);
        }

        @Override
        public boolean hasNext() {
            if (pos < collection.size() - 1) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String first() {
            pos = 0;
            return collection.get(pos);
        }
    }
}