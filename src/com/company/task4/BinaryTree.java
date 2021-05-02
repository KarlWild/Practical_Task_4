package com.company.task4;

import java.util.Stack;

public class BinaryTree {
    private Node rootNode; // корневой узел

    public BinaryTree() { // Пустое дерево
        rootNode = null;
    }

    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;
                if(value == currentNode.getValue()) {
                    return;
                }
                else  if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }


    /**
     * центрированный обход
     * используется тогда, когда нам надо проверить вначале детей
     * и только потом подыматься к родительским узлам.
     * @param node - узел, который щас смотрим
     */
    public void inOrder(Node node){
        if(node == null) return;
        inOrder(node.getLeftChild());
        System.out.print(node.getValue()+" ");
        inOrder(node.getRightChild());
    }
    /**
     * прямой обход
     * проверяет каждый лист дерева, начиная с левого
     * @param node - узел, который щас смотрим
     */
    public void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.getValue()+" ");
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
    }
    /**
     * Обратный обход
     * мы рассматриваем дерево снизу вверх, т.е вначале проверяем листья и поднимаемся к корневому узлу
     */
    public void postOrder(Node node){
        if(node == null) return;
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getValue()+" ");
    }
}
