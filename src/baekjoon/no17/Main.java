package baekjoon.no17;

import java.util.Objects;
import java.util.Scanner;

// 1991 - 트리 순회
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Character root = sc.next().charAt(0);
            Character left = sc.next().charAt(0);
            Character right = sc.next().charAt(0);

            addNode(root, left, right);
        }
    }

    public static void addNode(Character root, Character left, Character right) {
        Node<Character> leftNode = new Node<>(null, null, null);
        Node<Character> rightNode = new Node<>(null, null, null);
        if (left != '.') {
            leftNode = new Node<>(left, null, null);
        }
        if (right != '.') {
            rightNode = new Node<>(right, null, null);
        }

        Node<Character> newNode = new Node<>(root, leftNode, rightNode);
    }
     static class Node<Character> {
        private Character root;
        private Node<Character> leftNode;
        private Node<Character> rightNode;

        public Node (Character root, Node<Character> leftNode, Node<Character> rightNode ) {
            this.root = root;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
