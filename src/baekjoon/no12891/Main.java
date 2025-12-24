package baekjoon.no12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] DNA = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        int aCnt = Integer.parseInt(st.nextToken());
        int cCnt = Integer.parseInt(st.nextToken());
        int gCnt = Integer.parseInt(st.nextToken());
        int tCnt = Integer.parseInt(st.nextToken());

        int ans = 0;

        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        int left = 0;
        int right = 0;

        while (right < S) {
            if (right - left < P) {
                if (DNA[right] == 'A') {
                    a++;
                    right++;
                } else if (DNA[right] == 'C') {
                    c++;
                    right++;
                } else if (DNA[right] == 'G') {
                    g++;
                    right++;
                } else if (DNA[right] == 'T') {
                    t++;
                    right++;
                }

            } else if (right - left == P) {
                if (DNA[left] == 'A') {
                    a--;
                } else if (DNA[left] == 'C') {
                    c--;
                } else if (DNA[left] == 'G') {
                    g--;
                } else if (DNA[left] == 'T') {
                    t--;
                }
                left++;
            }

            if (aCnt >= a && cCnt >= c && gCnt >= g && tCnt >= t) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
