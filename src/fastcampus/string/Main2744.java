package fastcampus.string;

import java.util.Scanner;

public class Main2744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        char[] chArr = input.toCharArray();

        String result = "";
        for (int i = 0; i < chArr.length; i++) {
            char ch = input.charAt(i);
            if (chArr[i] >= 65 && chArr[i] <= 90) {
                result += (char) (chArr[i] + 32);
            } else {
                result += (char) (chArr[i] - 32);
            }
        }

        System.out.println(result);
    }
}
