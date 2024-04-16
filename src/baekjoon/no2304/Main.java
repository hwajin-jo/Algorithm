package baekjoon.no2304;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Building> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            int height = sc.nextInt();

            list.add(new Building(idx, height));
        }

        list.sort(Comparator.comparingInt(o -> o.idx));

        int maxIdx = -1;
        int maxHeight = -1;
        int maxPos = -1;
        for (int i = 0; i < list.size(); i++) {
            Building building = list.get(i);
            if (maxHeight < building.height) {
                maxIdx = i;
                maxHeight = building.height;
                maxPos = building.idx;
            }
        }

        int res = 0;

        int move = 0;
        int h = 0;
        for (int i = 0; i <= maxIdx; i++) {
            Building building = list.get(i);

            if (h < building.height) {
                res += (building.idx - move) * h;
                move = building.idx;
                h = building.height;
            }
        }

        res += maxHeight;

        int idx = 0;
        move = 0; h = 0;
        for (int i = list.size() - 1; i >= maxIdx; i--) {
            Building building = list.get(i);

            if (h < building.height) {
                res += (move - building.idx) * h;
                move = building.idx;
                h = building.height;
                idx = building.idx;
            }
        }
        res += (idx - maxPos) * maxHeight;

        System.out.println(res);
    }
}

class Building {
    int idx;
    int height;

    public Building(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}
