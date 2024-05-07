package baekjoon.no8979;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Country> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Country(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), 1));
        }

        list.sort((o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                }
                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        for (int i = 1; i < list.size(); i++) {
            Country prev = list.get(i - 1);
            Country now = list.get(i);

            if (prev.gold == now.gold &&
                prev.silver == now.silver &&
                prev.bronze == now.bronze) {
                now.rank = prev.rank;
            } else {
                now.rank = i + 1;
            }
        }

        list.stream()
                .filter(t -> t.idx == k)
                .map(t -> t.rank)
                .forEach(System.out::println);
    }
}

class Country {
    int idx;
    int gold;
    int silver;
    int bronze;
    int rank;

    public Country(int idx, int gold, int silver, int bronze, int rank) {
        this.idx = idx;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = rank;
    }
}