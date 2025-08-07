package baekjoon.no15654;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;

    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        temp = new int[M];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        permutation(0);
    }

    static void permutation(int deppth)
    {
        if (deppth == M)
        {
            for (int i = 0; i < M; i++)
            {
                System.out.print(temp[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < N; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                temp[deppth] = arr[i];
                permutation(deppth + 1);
                visited[i] = false;
            }
        }
    }
}
