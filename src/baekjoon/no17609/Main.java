package baekjoon.no17609;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        String[] checkList = new String[T];

        for (int i = 0; i < checkList.length; i++) {
            checkList[i] = sc.next();
        }

        // 회문 0, 유사회문 1 , 그 외 2
        for (String checkData : checkList) {
            if (isPalindrome(checkData)) {
                System.out.println(0);
            } else if (isPossiblePalindrome(checkData)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    private static boolean isPossiblePalindrome(String checkData) {
        char[] chars = checkData.toCharArray();
        int left = 0;
        int right = checkData.length() - 1;

        boolean flag = false;
        while (left < right) {
            if (chars[left] != chars[right]) {
                if (!flag) {
                    flag = true;

                    if (chars[left + 1] == chars[right])
                        left++;
                    else if (chars[left] == chars[right-1])
                        right--;
                    else
                        return false;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String checkData) {
        char[] chars = checkData.toCharArray();
        int left = 0;
        int right = checkData.length() - 1;
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
