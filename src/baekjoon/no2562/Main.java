package baekjoon.no2562;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Number> numberList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numberList.add(new Number(i, sc.nextInt()));
        }

        Collections.sort(numberList);

        System.out.println(numberList.get(numberList.size() - 1).data);
        System.out.println(numberList.get(numberList.size() - 1).idx);
    }
}

class Number implements Comparable<Number> {
    int idx;
    int data;

    public Number (int idx, int data) {
        this.idx = idx;
        this.data = data;
    }

    @Override
    public int compareTo(Number o) {
        return this.data - o.data;
    }
}
