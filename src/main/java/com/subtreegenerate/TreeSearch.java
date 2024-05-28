package com.subtreegenerate;

public class TreeSearch {

    // Método principal para encontrar a subárvore
    public TreeNode findSubTree(TreeNode root, String term) {
        // Busca o nó contendo o termo
        TreeNode targetNode = findNode(root, term);
        if (targetNode != null) {
            // Constrói e retorna a subárvore
            return buildSubTree(targetNode);
        } else {
            return null;
        }
    }

    // Método para buscar o nó que contém o termo
    private TreeNode findNode(TreeNode currentNode, String term) {
        if (currentNode == null) {
            return null;
        }

        if (currentNode.name.equals(term)) {
            return currentNode; // Nó encontrado
        }

        for (TreeNode child : currentNode.children) {
            TreeNode result = findNode(child, term);
            if (result != null) {
                return result; // Nó encontrado no subcaminho
            }
        }

        return null; // Nó não encontrado
    }

    // Método para construir a subárvore a partir do nó encontrado
    private TreeNode buildSubTree(TreeNode targetNode) {
        TreeNode childrenSubtree = getChildrensSubtree(targetNode);
        // Cria a nova raiz da subárvore
        TreeNode root = new TreeNode(targetNode.id, targetNode.name);
        TreeNode current = root;
        current.children = childrenSubtree.children;

        // Sobe pela árvore até a raiz, adicionando os nós ao caminho
        while (targetNode.parent != null) {
            targetNode = targetNode.parent;
            TreeNode parentClone = new TreeNode(targetNode.id, targetNode.name);
            parentClone.addChild(current);
            current = parentClone;
        }

        return current;
    }

    public TreeNode getChildrensSubtree(TreeNode node) {
        TreeNode subtreeCopy = new TreeNode(node.id, node.name); // Cria uma cópia do nó atual

        // Copia recursivamente os filhos
        for (TreeNode child : node.children) {
            subtreeCopy.addChild(getChildrensSubtree(child));
        }

        return subtreeCopy;
    }

    public void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println("Node ID: " + node.id + ", Name: " + node.name);

        for (TreeNode child : node.children) {
            printTree(child, level + 1);
        }
    }
}
