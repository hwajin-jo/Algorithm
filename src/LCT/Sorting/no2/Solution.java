package LCT.Sorting.no2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }


    // 점수가 낮은 순서대로 정렬
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

// 성적이 낮은 순서로 학생 출력하기
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            list.add(new Student(name, score));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getName() + " ");
        }
    }
}
