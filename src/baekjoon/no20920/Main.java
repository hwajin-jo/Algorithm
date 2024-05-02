package baekjoon.no20920;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String data = br.readLine();

            if (data.length() < m) continue;
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);

        for (Word word : list) {
            bw.write(word.data + "\n");
        }

        bw.flush();
        bw.close();
    }
}

class Word implements Comparable<Word> {
    String data;
    int cnt;

    public Word(String data, int cnt) {
        this.data = data;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Word o) {
        if (this.cnt == o.cnt) {
            if (this.data.length() == o.data.length()) {
                return this.data.compareTo(o.data);
            }

            return o.data.length() - this.data.length();
        }
        return o.cnt - this.cnt;
    }
}
