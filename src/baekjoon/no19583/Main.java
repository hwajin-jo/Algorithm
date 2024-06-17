package baekjoon.no19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String start = st.nextToken();
        String end = st.nextToken();
        String exit = st.nextToken();

        Set<String> set = new HashSet<>();
        Set<String> ansSet = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);

            String time = st.nextToken();
            String nickname = st.nextToken();

            if (time.compareTo(start) <= 0) { // 입력 시간이 시작 시간 이전이면 출석 체크
                set.add(nickname);
            }

            if (time.compareTo(end) >= 0 && time.compareTo(exit) <= 0) { // 입력 시간이 퇴장 시간 이후이면서 종료 시간 이전 일 때, 출석 체크에 존재하면 카운트
                if (set.contains(nickname))
                    ansSet.add(nickname);
            }
        }

        System.out.println(ansSet.size());
    }
}
