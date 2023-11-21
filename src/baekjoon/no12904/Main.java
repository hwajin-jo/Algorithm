package baekjoon.no12904;

import java.util.Scanner;

public class Main {
    // 백트래킹으로 풀려고 하면 시간초과 발생
    // target에서 origin을 도출하며 거꾸러 연산하는 방법으로도 풀 수 있음
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String origin = sc.next();
        String target = sc.next();

        StringBuilder sb = new StringBuilder(target);
        while (true) {
            if (origin.length() == sb.length()) {
                if (origin.equals(sb.toString()))
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            }

            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }


//        solve(sb, target);

    }

//    static void solve(StringBuilder sb, String target) {
//        if (sb.length() == target.length()) {
//            if (sb.toString().equals(target)) {
//                System.out.println(1);
//                System.exit(0);
//            }
//            return;
//        }
//
//        sb.append("A");
//        solve(sb, target);
//        sb.deleteCharAt(sb.length() - 1);
//
//        sb.reverse();
//        sb.append("B");
//        solve(sb, target);
//        sb.deleteCharAt(sb.length() - 1);
//        sb.reverse();
//    }
}
