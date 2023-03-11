package baekjoon.no14;

import java.util.Scanner;
import java.util.Stack;

// 17413 - 단어 뒤집기 2
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (c == '<') { // <를 만나면 여태껏 저장해둔 문자열을 거꾸로 출력
                flag = true;
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(str.charAt(i));
            } else if (c == '>') { // <>사이 문자열 출력 멈추고 >를 출력
                flag = false;
                System.out.print(str.charAt(i));
            } else if (flag) { // <>사이에 있는 문자열을 출력
                System.out.print(str.charAt(i));
            } else {
                if (str.charAt(i) == ' ') { // 공백을 만날때는 stack에 쌓아둔 문자열을 모두 출력
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(str.charAt(i)); // 공백 출력
                } else { // 공백이 아닐때는 스택에 문자열 값 추가
                    stack.push(str.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
