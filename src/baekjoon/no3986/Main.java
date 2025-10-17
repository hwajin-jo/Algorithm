package baekjoon.no3986;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int good = 0;
        while (N -- > 0) {
            Stack<Character> stack = new Stack<>();
            char[] word = sc.next().toCharArray();
            for (int i = 0; i < word.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(word[i]);
                } else {
                    if (stack.peek() == word[i]) {
                        stack.pop();
                    } else {
                        stack.push(word[i]);
                    }
                }
            }

            if (stack.isEmpty())
                good++;
        }

        System.out.println(good);
    }
}
