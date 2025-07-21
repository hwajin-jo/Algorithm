package programmers.lv1.no20;

import java.util.HashSet;

// 포켓몬
public class Main {

    public int solution(int[] nums) {
        int answer = 0;
        HashSet set = new HashSet<>();

        int max = nums.length / 2;

        for (int num : nums)
        {
            if (set.size() >= max)
                break;

            set.add(num);
        }

        return set.size();
    }
}
