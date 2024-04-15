package baekjoon.no2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Building> list = new ArrayList<>();

        int maxIdx = -1;
        int maxHeight = -1;
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            int height = sc.nextInt();

            list.add(new Building(idx, height));

            if (maxHeight < height) {
                maxIdx = idx;
                maxHeight = height;
            }
        }

        list.sort((o1, o2) -> o1.idx - o2.idx);


        int pivot = 0;
        for (Building building : list) {
            if (building.idx == maxIdx) {
                break;
            }
            pivot++;
        }

        int res = 0;

        int idx = 0;
        int h = 0;
        for (int i = 0; i <= pivot; i++) {
            Building building = list.get(i);

            if (building.height > h) {
                res += (building.idx - idx) * h;
                idx = building.idx;
                h = building.height;
            }
        }


        Building high = list.get(list.size() - 1);
        for (int i = pivot; i < list.size(); i++) {
            Building building = list.get(i);

            if (building.height > high.height) {
                res += (high.idx - building.idx) * high.height;
                high = building;
            }
        }

        res += maxHeight;
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
