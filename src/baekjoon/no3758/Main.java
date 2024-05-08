package baekjoon.no3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());




        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수


            HashMap<Integer, Team> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, new Team(i, 0, 0, 0, 0));
                for (int j = 1; j <= k; j++) {
                    Team team = map.get(i);
                    team.scoreMap.put(j, 0);
                }
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()); // 팀의 번호
                int j = Integer.parseInt(st.nextToken()); // 문제 번호
                int s = Integer.parseInt(st.nextToken()); // 획득한 점수
                Team team = map.get(idx);
                int score = team.scoreMap.get(j);
                if (s > score) {
                    team.scoreMap.put(j, s);
                    team.totalScore = team.totalScore - score + s;
                }
                team.lastSubmit = i;
                team.cnt++;
            }

            List<Team> teamList = new ArrayList<>();
            for (Map.Entry<Integer, Team> entry : map.entrySet()) {
                teamList.add(map.get(entry.getKey()));
            }

            Collections.sort(teamList);

            teamList.get(0).rank = 1;
            for (int i = 1; i < teamList.size(); i++) {
                Team prev = teamList.get(i - 1);
                Team cur = teamList.get(i);

                if (prev.totalScore == cur.totalScore &&
                    prev.cnt == cur.cnt &&
                    prev.lastSubmit == cur.lastSubmit) {
                    cur.rank = prev.rank;
                } else {
                    cur.rank = i + 1;
                }
            }

            for (Team team : teamList) {
                if (team.idx == t) {
                    System.out.println(team.rank);
                    break;
                }
            }
        }
    }
}

class Team implements Comparable<Team> {
    int idx;
    int totalScore;
    int cnt;
    int lastSubmit;
    int rank;
    Map<Integer, Integer> scoreMap = new HashMap<>();

    public Team (int idx, int totalScore, int cnt, int lastSubmit, int rank) {
        this.idx = idx;
        this.totalScore = totalScore;
        this.cnt = cnt;
        this.lastSubmit = lastSubmit;
        this.rank = rank;
    }

    @Override
    public int compareTo(Team o) {
        if (this.totalScore == o.totalScore) {
            if (this.cnt == o.cnt) {
                return this.lastSubmit - o.lastSubmit;
            }
            return this.cnt - o.cnt;
        }
        return o.totalScore - this.totalScore;
    }
}
