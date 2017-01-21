package com.willkernel.app.javadesignmode.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.willkernel.app.javadesignmode.R;
import com.willkernel.app.javadesignmode.databinding.ActivityCompositeModeBinding;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 组合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 * 使用场景：将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，数等。
 */
public class CompositeModeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompositeModeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_composite_mode);
        List<String> list = new ArrayList<>();
        Tree tree = new Tree("A");
        TreeNode node1 = new TreeNode("B");
        TreeNode node2 = new TreeNode("C");
        node1.addNode(node2);
        tree.root.addNode(node1);
        list.add(tree.getNodes());
        binding.setList(list);
    }

    public class TreeNode {
        private String name;
        private TreeNode parent;
        private Vector<TreeNode> children = new Vector<TreeNode>();

        public TreeNode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public void addNode(TreeNode node) {
            children.add(node);
        }

        public void removeNode(TreeNode node) {
            children.remove(node);
        }

        public Enumeration<TreeNode> getChildren() {
            return children.elements();
        }
    }

    public class Tree {
        TreeNode root = null;

        public Tree(String name) {
            root = new TreeNode(name);
        }

        public String getNodes() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(root.getName()).append("-->");
            Enumeration<TreeNode> enumer = root.getChildren();
            while (enumer.hasMoreElements()) {
                TreeNode node = enumer.nextElement();
                stringBuilder.append(node.getName());
                enumer = node.getChildren();
            }
            return stringBuilder.toString();
        }
    }
}