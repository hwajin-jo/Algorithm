package baekjoon.no16165;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            String name = sc.next();
            int size = sc.nextInt();

            List<String> girls = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                girls.add(sc.next());
            }

            map.put(name, girls);
        }

        for (int i = 0; i < m; i++) {
            String target = sc.next();
            int type = sc.nextInt();

            if (type == 0) {
                List<String> girls = map.get(target);
                Collections.sort(girls);
                for (String name : girls) {
                    System.out.println(name);
                }
            } else {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    List<String> girls = entry.getValue();
                    if (girls.contains(target)) {
                        System.out.println(entry.getKey());
                        break;
                    }
                }
            }
        }
    }
}
