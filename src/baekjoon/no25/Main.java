package baekjoon.no25;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String search = sc.nextLine();

        int startIndex = 0;
        int cnt = 0;

        while (true) {
            int findIndex = document.indexOf(search, startIndex);
            if (findIndex < 0)
                break;
            startIndex = findIndex + search.length();
            cnt++;
        }

        System.out.println(cnt);
    }
}
