package baekjoon.no12891;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        char[] arr = input.toCharArray();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int ans = 0;
        int aCnt = 0, cCnt = 0, gCnt = 0, tCnt = 0;
        int left = 0;
        int right = 0;

        while (right < S) {
            if (right - left < P) {
                if (arr[right] == 'A') {
                    aCnt++;
                    right++;
                } else if (arr[right] == 'C') {
                    cCnt++;
                    right++;
                } else if (arr[right] == 'G') {
                    gCnt++;
                    right++;
                } else if (arr[right] == 'T') {
                    tCnt++;
                    right++;
                }
            } else if (right - left == P) {
                if (arr[left] == 'A') aCnt--;
                else if (arr[left] == 'C') cCnt--;
                else if (arr[left] == 'G') gCnt--;
                else if (arr[left] == 'T') tCnt--;
                left++;
            }

            if (aCnt >= a && cCnt >= c && gCnt >= g && tCnt >= t && right - left == P) ans++;
        }


        System.out.println(ans);
    }
}
