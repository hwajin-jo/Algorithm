package programmers.lv1.no18;


class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            if (!invalidCheck(babbling[i])) {
                babbling[i] = babbling[i].replace(word[0],"");
                babbling[i] = babbling[i].replace(word[1],"");
                babbling[i] = babbling[i].replace(word[2],"");
                babbling[i] = babbling[i].replace(word[3],"");

                if (babbling[i].isEmpty())
                    answer++;
            }
        }

        return answer;
    }

    public boolean invalidCheck(String check) {
        String[] notspeak = {
                "yeye", "yeyeye", "yeyeyeye",
                "ayaaya", "ayaayaaya", "ayaayaayaaya",
                "woowoo", "woowoowoo", "woowoowoowoo",
                "mama", "mamama", "mamamama" };

        for (int j = 0; j < notspeak.length; j++) {
            check = check.replace(notspeak[j], "");
            if (check.isEmpty()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] babbling = {"ayayeayaye", "yewooye", "yeye"};
        System.out.println(solution.solution(babbling));
    }
}
