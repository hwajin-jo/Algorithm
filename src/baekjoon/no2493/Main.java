package baekjoon.no2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] ans = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Top> stack = new Stack<>();

        stack.push(new Top(0, arr[0]));

        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty()) {
                if (arr[i] <= stack.peek().num) {
                    ans[i] = stack.peek().idx + 1;
                    break;
                } else {
                    stack.pop();
                }
            }

            stack.push(new Top(i, arr[i]));
        }

        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}

class Top {
    int idx;
    int num;

    public Top(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}
