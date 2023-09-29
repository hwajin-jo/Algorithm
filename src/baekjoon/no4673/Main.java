package baekjoon.no4673;

import java.util.ArrayList;

// 셀프 넘버
public class Main {

    private static int result = 0;
    private static ArrayList<Integer> selfnum_list = new ArrayList<>();
    public static void main(String[] args) {
        int[] total = new int[10001];

        // 10000까지 데이터 입력
        for (int i = 0; i < 10000; i++) {
            total[i] = i+1;
        }

        // 각 숫자들이 셀프 넘버 리스트에 담기
        for (int i = 1; i <= 10000; i++) {
            if (!selfnum_list.contains(i))
                check_self_num(i);
        }

        // 생성자가 없는 숫자 출력
        for (int i = 0; i < 10000; i++) {
            if (!selfnum_list.contains(total[i])) {
                System.out.println(total[i]);
            }
        }
    }

    public static int check_self_num(int n) {
        if (n > 10000)
            return 0;

        String temp = String.valueOf(n);
        result = n;
        for (int i = 0; i < temp.length(); i++) {
            result += temp.charAt(i) - '0';
        }

        if (!selfnum_list.contains(result)) selfnum_list.add(result);

        return check_self_num(result);
    }
}
