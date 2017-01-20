package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityFacadeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 外观模式是为了解决类与类之家的依赖关系的，像spring一样，
 * 可以将类和类之间的关系配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中，
 * 降低了类类之间的耦合度，该模式中没有涉及到接口
 * <p>
 * 一个计算机的启动过程为例
 * 如果我们没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，
 * 产生关系，这样会造成严重的依赖，修改一个类，可能会带来其他类的修改，这不是我们想要看到的，
 * 有了Computer类，他们之间的关系被放在了Computer类里，这样就起到了解耦的作用，
 * 这，就是外观模式！
 */
public class FacadeModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFacadeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_facade);
        List<String> list = new ArrayList<>();
        Computer computer = new Computer();
        list.add(computer.startup());
        list.add(computer.shutdown());
        binding.setList(list);
    }

    public class CPU {

        public String startup() {
            return "CPU startup!";
        }

        public String shutdown() {
            return "CPU shutdown!";
        }
    }

    public class Memory {

        public String startup() {
            return "Memory startup!";
        }

        public String shutdown() {
            return "Memory shutdown!";
        }
    }

    public class Disk {

        public String startup() {
            return "Disk startup!";
        }

        public String shutdown() {
            return "Disk shutdown!";
        }
    }

    public class Computer {
        private CPU cpu;
        private Memory memory;
        private Disk disk;

        public Computer() {
            cpu = new CPU();
            memory = new Memory();
            disk = new Disk();
        }

        public String startup() {
            return cpu.startup() + memory.startup() + disk.startup();
        }

        public String shutdown() {
            return cpu.shutdown() + memory.shutdown() + disk.shutdown();
        }
    }
}