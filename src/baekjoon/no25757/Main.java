package baekjoon.no25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char type = st.nextToken().charAt(0);

        Set<String> set = new HashSet<>();

        int needs = 0;

        if (type == 'Y') {
            needs = 1;
        } else if (type == 'F') {
            needs = 2;
        } else {
            needs = 3;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }

        int ans = set.size() / needs;

        System.out.println(ans);
    }
}
