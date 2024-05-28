package com.subtreegenerate;

public class Main {
    public static void main(String[] args) {

        TreeSearch treeSearch = new TreeSearch();
        // Cria a árvore de exemplo
        TreeNode root = new TreeNode(1, "root");
        TreeNode child1 = new TreeNode(2, "child1");
        TreeNode child2 = new TreeNode(3, "child2");
        TreeNode child1_1 = new TreeNode(4, "child1_1");
        TreeNode child1_2 = new TreeNode(5, "child1_2");
        TreeNode child1_2_1 = new TreeNode(5, "child1_2_1");

        root.addChild(child1);
        root.addChild(child2);
        child1_2.addChild(child1_2_1);
        child1.addChild(child1_1);
        child1.addChild(child1_2);

        // Termo a ser buscado
        String term = "child1";

        // Busca a subárvore até o termo
        TreeNode subTreeRoot = treeSearch.findSubTree(root, term);

        // Imprime a subárvore encontrada
        if (subTreeRoot != null) {
            treeSearch.printTree(subTreeRoot, 0);
        } else {
            System.out.println("Term not found.");
        }
    }
}