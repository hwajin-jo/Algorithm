package programmers.lv1.no25;

import java.util.*;

// 모의고사
public class Main {

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Student s1 = new Student(1, 0);
        Student s2 = new Student(2, 0);
        Student s3 = new Student(3, 0);

        for (int i = 0; i < answers.length; i++)
        {
            if (person1[i%person1.length] == answers[i])
                s1.cnt++;

            if (person2[i%person2.length] == answers[i])
                s2.cnt++;

            if (person3[i%person3.length] == answers[i])
                s3.cnt++;
        }

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.sort((o1, o2) -> {
            if (o1.cnt == o2.cnt)
                return o1.idx - o2.idx;
            return o2.cnt - o1.cnt;
        });

        int idx1 = list.get(0).idx;
        int cnt1 = list.get(0).cnt;

        String s = idx1 + ",";

        for (int i = 1; i < 3; i++)
        {
            int idx = list.get(i).idx;
            int cnt = list.get(i).cnt;

            if (cnt1 == cnt)
                s += idx + ",";
        }

        String[] str = s.split(",");

        answer = new int[str.length];

        for (int i = 0; i < str.length; i++)
        {
            answer[i] = Integer.parseInt(str[i]);
        }

        return answer;
    }
}

class Student
{
    int idx;
    int cnt;

    public Student(int idx, int cnt)
    {
        this.idx = idx;
        this.cnt = cnt;
    }
}

