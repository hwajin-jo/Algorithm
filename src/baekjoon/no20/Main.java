package baekjoon.no20;

import java.util.Scanner;

// 11725 - 트리의 부모 찾기
public class Main {

    public static Node<Integer> head = new Node<>(1, null, null);
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N-1; i++) {
            Integer root = sc.nextInt();
            Integer child = sc.nextInt();

            insertTree(head, root, child);
        }


        for (int i = 2; i <= N; i++) {
            printParentTree(head, i);
        }
    }

    public static void printParentTree(Node<Integer> root,  int data) {
        if (root == null) {
            return;
        }
        if (root.leftNode != null && root.leftNode.data == data) {
            System.out.println(root.data);
            data++;
        } else if (root.rightNode != null && root.rightNode.data == data) {
            System.out.println(root.data);
            data++;
        } else {
            printParentTree(root.leftNode, data);
            printParentTree(root.rightNode, data);
        }
    }

    public static void insertTree(Node<Integer> temp, Integer root, Integer child) {
        if (temp.data == root || temp.data == child) {
            if (temp.leftNode == null && temp.data != child) {
                temp.leftNode = new Node<>(child, null, null);
            } else {
                temp.rightNode = new Node<>(root, null, null);
            }
        } else {
            if (temp.leftNode != null) {
                insertTree(temp.leftNode, root, child);
            }
            if (temp.rightNode != null) {
                insertTree(temp.rightNode, root, child);
            }
        }
    }

    static class Node<Integer> {
        Integer data;
        Node<Integer> leftNode;
        Node<Integer> rightNode;

        public Node(Integer data, Node<Integer> leftNode, Node<Integer> rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
