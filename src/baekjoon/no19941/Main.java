package baekjoon.no19941;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] input = sc.next().toCharArray();
        boolean[] visited = new boolean[input.length];

        int cnt = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == 'P')
            {
                int start = i - K;
                int end = i + K;

                for (int j = start; j <= end; j++)
                {
                    if (j < 0 || j >= N) continue;
                    if (input[j] == 'H' && !visited[j])
                    {
                        cnt++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
