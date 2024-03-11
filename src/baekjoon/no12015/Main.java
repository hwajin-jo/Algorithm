package baekjoon.no12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] seq = new int[n];
        int[] LIS = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int lengthOfLTS = 1;

        for (int i = 1; i < n; i++) {
            int key = seq[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            if (LIS[lengthOfLTS - 1] < key) {
                lengthOfLTS++;
                LIS[lengthOfLTS - 1] = key;
            } else {
                // Lower Bound 이분탐색을 진행한다.
                int left = 0;
                int right = lengthOfLTS;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (LIS[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                /*
                    left가 LIS에서 대치 될 원소가 될 것이고
                    해당 위치에 key값으로 원소를 바꿔준다.
                 */
                LIS[left] = key;
            }
        }

        System.out.println(lengthOfLTS);
    }
}
