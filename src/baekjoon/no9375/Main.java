package baekjoon.no9375;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int ans = 1;
            Map<String, Integer> map = new HashMap<>();
            while (N-- > 0) {
                sc.next();
                String category = sc.next();

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                ans *= (entry.getValue() + 1);
            }


            System.out.println(ans - 1);
        }
    }
}
