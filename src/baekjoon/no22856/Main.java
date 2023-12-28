package baekjoon.no22856;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] tree;
    static int last;
    static int cnt;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        tree = new List[n + 1];

        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[data].add(new Node(left, right));
        }

        inOrder(1);
        similarInOrder(1);
        System.out.println(cnt);
    }

    static void similarInOrder(int data) {
        for (Node node : tree[data]) {
            if (node.left != -1) {
                cnt++;
                similarInOrder(node.left);
                if (flag) cnt++;
            }

            if (node.right != -1) {
                cnt++;
                similarInOrder(node.right);
                if (flag) cnt++;
            }

            if (data == last) {
                flag = false;
                return;
            }
        }
    }

    static void inOrder(int data) {
        for (Node node : tree[data]) {
            if (node.left != -1) {
                inOrder(node.left);
            }
            last = data;
            if (node.right != -1) {
                inOrder(node.right);
            }

        }
    }
}

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
