package baekjoon.no10158;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//
//        // 격자 공간
//        int w = sc.nextInt();
//        int h = sc.nextInt();
//
//        // 초기 위치
//        int p = sc.nextInt();
//        int q = sc.nextInt();
//
//        // 시간
//        int t = sc.nextInt();

        // t에 비례해서 풀면 시간초과
        // 1초에 대략 1억의 연산
        // t의 범위는 1 < t < 200,000,000 임
        // 문제에서 주어진 시간은 0.15초임, 하지만 최대 걸리는 시간은 2초임 -> 시간초과 발생
//        int dx = 1;
//        int dy = 1;

//        for (int i = 0; i < t; i++) {
//            // p, q가 경계면 일 때, 이동 동선이 반사됨
//            if (p == w || p == 0) {
//                if (dx == 1)
//                    dx = -1;
//                else
//                    dx = 1;
//            }
//
//            if (q == h || q == 0) {
//                if (dy == 1)
//                    dy = -1;
//                else
//                    dy = 1;
//            }
//
//            p = p + dx;
//            q = q + dy;
//        }
//
//        System.out.println(p + " " + q);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);

        if (p > w) {
            p = 2 * w - p;
        }

        if (q > h) {
            q = 2 * h - q;
        }

        bw.write(p + " " + q + "\n");

        bw.flush();
        bw.close();
    }
}
