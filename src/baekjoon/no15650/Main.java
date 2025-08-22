package baekjoon.no15650;
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
        visited = new boolean[N];
        temp = new int[M];

        for (int i = 0; i < N; i++)
        {
            arr[i] = i + 1;
        }

        backtracking(0, 0);
    }

    public static void backtracking(int depth, int now){
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = now; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                backtracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}

