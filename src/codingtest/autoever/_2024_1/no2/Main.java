package codingtest.autoever._2024_1.no2;

import java.util.Scanner;

public class Main {

    // 2. 컨베이어 벨트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] item = new int[6];
        int[] originItem = new int[6];
        for (int i = 1; i < 6; i++) {
            originItem[i] = sc.nextInt();
            item[i] = originItem[i];
        }

        int n = sc.nextInt();
        int[] belt = new int[n];
        int[] originBelt = new int[n];
        for (int i = 0; i < n; i++) {
            originBelt[i] = sc.nextInt();
            belt[i] = originBelt[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                item[j] = originItem[j];
            }

            for (int j = 0; j < n; j++) {
                belt[j] = originBelt[j];
            }
            int res = checkItem(i, item, belt);
            ans = Math.min(res, ans);
        }

        for (int i = 0; i < item.length; i++) {
            if (item[i] > 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }

    static int checkItem(int start, int[] item, int[] belt) {
        int cnt = 0;
        int n = belt.length;
        for (int i = start; i < start + n; i++) {
            if (isValid(item)) {
                break;
            }

            cnt++;
            for (int j = 0; j < item.length; j++) {
                if (item[j] > 0 && belt[i % n] == j) {
                    item[j]--;
                    break;
                }
            }
        }
        return cnt;
    }

    static boolean isValid(int[] item) {
        for (int i = 0; i < item.length; i++) {
            if (item[i] > 0) return false;
        }

        return true;
    }
}
