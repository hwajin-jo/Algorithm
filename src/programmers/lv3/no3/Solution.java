package programmers.lv3.no3;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Music> list = new ArrayList<>();


        for (int i = 0; i < genres.length; i++) {
            list.add(new Music(i, genres[i], plays[i]));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.genres.equals(o2.genres)) {
                return o2.play - o1.play;
            } else
                return o1.genres.compareTo(o2.genres);
        });


        Map<String, Integer> map = new TreeMap<>();

        for (Music music : list) {
            String gen = music.genres;
            int play = music.play;
            map.put(gen, map.getOrDefault(gen, 0) + play);

        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        List<Integer> ansList = new ArrayList<>();

        for (String gen : keySet) {
            int cnt = 0;
            for (Music music : list) {
                if (music.genres.equals(gen) && cnt < 2) {
                    ansList.add(music.id);
                    cnt++;
                }
            }
        }

        int[] answer = new int[ansList.size()];

        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}

class Music {
    int id;
    String genres;
    int play;

    public Music(int id, String genres, int play) {
        this.id = id;
        this.genres = genres;
        this.play = play;
    }
}