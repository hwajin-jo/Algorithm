package programmers.lv3.no4;

import java.util.*;

// 베스트 앨범
public class Main {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        List<Music> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            treeMap.put(genre, treeMap.getOrDefault(genre, 0) + play);
            list.add(new Music(i, genre, play));
        }

        list.sort((o1, o2) ->
        {
            if (o1.genre.equals(o2.genre)) {
                if (o1.play == o2.play) {
                    return o1.idx - o2.idx;
                }
                return o2.play - o1.play;
            }

            return o1.genre.compareTo(o2.genre);
        });

        List<String> sortList = new ArrayList<>(treeMap.keySet());

        sortList.sort((o1, o2) -> treeMap.get(o2) - treeMap.get(o1));


        List<Integer> idxList = new ArrayList<>();

        for (String sort : sortList) {
            int max = 0;
            for (Music music : list) {
                int idx = music.idx;
                String genre = music.genre;
                int play = music.play;

                // System.out.println("idx : " + idx + " genre : " + genre + " play : " + play);

                if (sort.equals(genre)) {
                    idxList.add(idx);
                    max++;
                }

                if (max == 2)
                    break;
            }
        }

        answer = new int[idxList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = idxList.get(i);
        }

        return answer;
    }


    class Music {

        int idx;
        String genre;
        int play;

        public Music(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
    }
}
