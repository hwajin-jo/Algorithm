package baekjoon.no26;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.nextLine();
        String target = sc.nextLine();

        String[] nowData = now.split(":");
        int hour = Integer.parseInt(nowData[0]);
        int minutes = Integer.parseInt(nowData[1]);
        int seconds = Integer.parseInt(nowData[2]);

        int total_now = hour * 3600 + minutes * 60 + seconds;

        String[] targetData = target.split(":");
        hour = Integer.parseInt(targetData[0]);
        minutes = Integer.parseInt(targetData[1]);
        seconds = Integer.parseInt(targetData[2]);
        int total_target = hour * 3600 + minutes * 60 + seconds;

        int result = total_target - total_now;

        if (result <= 0) result += 24 * 3600;

        hour = result / 3600;
        result = result % 3600;
        minutes = result % 3600 / 60;
        seconds = result % 60;

        System.out.printf("%02d:%02d:%02d\n", hour, minutes, seconds);

    }
}
