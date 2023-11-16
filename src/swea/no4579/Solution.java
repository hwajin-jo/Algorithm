package swea.no4579;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();

            if (isExist(str)) System.out.println("#" + test_case + " " + "Exist");
            else System.out.println("#" + test_case + " " + "Not exist");
        }
    }

    static boolean isExist(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            char front = str.charAt(i);
            char back = str.charAt(str.length() - i - 1);
            if(front == '*') return true;
            if(back == '*') return true;
            if (front != back) return false;
        }

        return true;
    }
}