package programmers.lv3.no5;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        int res = solution(jobs);

        System.out.println(res);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.duration == o2.duration) {
                        if (o1.reqTime == o2.reqTime) {
                            return o1.idx - o2.idx;
                        }
                        return o1.reqTime - o2.reqTime;
                    }
                    return o1.duration - o2.duration;
                }
        );

        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(i, jobs[i][0], jobs[i][1]));
        }


        while (!pq.isEmpty()) {
            Job job = pq.poll();
            answer += job.duration + (job.duration - job.reqTime);
        }

        return answer / jobs.length;
    }
}

class Job {
    int idx;
    int reqTime;
    int duration;

    public Job (int idx, int reqTime, int duration) {
        this.idx = idx;
        this. reqTime = reqTime;
        this.duration = duration;
    }
}
