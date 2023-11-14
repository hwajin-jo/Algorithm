package baekjoon.no16987;

import java.util.Scanner;

public class Main {

    static int N;
    static Egg[] egg;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        egg = new Egg[N];

        for (int i = 0; i < N; i++) {
            egg[i] = new Egg(sc.nextInt(), sc.nextInt());
        }

        solve(0);

        System.out.println(ans);
    }

    static void solve(int pick) {
        if (pick == N) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (egg[i].durability <= 0) {
                    count++;
                }
            }

            ans = Math.max(ans, count);
            return;
        }

        if (egg[pick].durability > 0) {
            boolean targetExist = false;

            for (int target = 0; target < N; target++) {
                if (pick == target) continue;
                if (egg[target].durability > 0) {
                    targetExist = true;
                    egg[pick].fight(egg[target]);
                    solve(pick + 1);
                    egg[pick].restore(egg[target]);
                }
            }

            if (!targetExist)
                solve(pick + 1);
        } else {
            solve(pick + 1);
        }
    }
}

class Egg {
    int durability;
    int weight;

    public Egg(int d, int w) {
        durability = d;
        weight = w;
    }

    public void fight(Egg other) {
        durability -= other.weight;
        other.durability -= weight;
    }

    public void restore(Egg other) {
        durability += other.weight;
        other.durability += weight;
    }
}
