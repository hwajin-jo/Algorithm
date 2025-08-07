package programmers.lv2.no21;

import java.util.*;

// 소수찾기
public class Main {

    static Set<Integer> numberSet = new HashSet<>();
    public static void main(String[] args) {
        solution("011");
    }


    public static int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);

        return numberSet.size();
    }

    static public boolean isPrime(int n)
    {
        if (n < 2) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n%i == 0)
                return false;
        }


        return true;
    }

    // 숫자 조합을 만드는 재귀함수
    static void recursive(String comb, String other) {
        if (!comb.equals("")) {
            if (isPrime(Integer.parseInt(comb)))
                numberSet.add(Integer.parseInt(comb));
        }

        for (int i = 0 ; i < other.length() ; i++) {
            recursive(comb + other.charAt(i), other.substring(0,i) + other.substring(i+1));
        }
    }
}
