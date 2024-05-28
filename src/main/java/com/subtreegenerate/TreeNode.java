package com.subtreegenerate;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int id;
    String name;
    List<TreeNode> children;
    TreeNode parent; // Referência para o nó pai

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
        this.children = new ArrayList<>();
        this.parent = null;
    }

    public void addChild(TreeNode child) {
        child.parent = this;
        this.children.add(child);
    }
}
