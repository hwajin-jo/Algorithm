package baekjoon.no13022;

import java.util.*;

public class Main {
    static int count[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        if (s.length() < 4) {
            System.out.println(0);
        } else {
            count = new int[4];
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('w', 0);
            map.put('o', 1);
            map.put('l', 2);
            map.put('f', 3);
            boolean flag = true;
            count[map.get(s.charAt(0))] = 1;
            for (int i = 1; i < s.length(); i++) {
                int pre = map.get(s.charAt(i - 1));
                int cur = map.get(s.charAt(i));
                int dif = cur - pre;
                if (dif == -3) {
                    if(check()) {
                        count = new int[4];
                        count[0]=1;
                    }else {
                        flag=false;
                        break;
                    }
                } else {
                    if (dif == 1 || dif == 0) {
                        count[cur]++;
                    } else {
                        flag=false;
                        break;
                    }
                }
            }
            if(!check()) {
                flag=false;
            }
            if(flag) {
                System.out.println(1);
            }else
                System.out.println(0);
        }
    }

    static boolean check() {
        if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) {
            return true;
        }else
            return false;
    }
}
