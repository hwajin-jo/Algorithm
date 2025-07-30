package programmers.lv1.no26;

import java.util.*;

// 최소직사각형
public class Main {

    public int solution(int[][] sizes) {
        int answer = 0;

        List<Rectangle> list = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++)
        {
            int w = sizes[i][0];
            int h = sizes[i][1];

            if (w >= h)
                list.add(new Rectangle(w, h));
            else
                list.add(new Rectangle(h, w));
        }

        int maxW = 0;
        int maxH = 0;
        for (Rectangle rec : list)
        {
            maxW = Math.max(maxW, rec.w);
            maxH = Math.max(maxH, rec.h);
        }

        answer = maxW * maxH;

        return answer;
    }
}

class Rectangle
{
    int w;
    int h;

    public Rectangle (int w, int h)
    {
        this.w = w;
        this.h = h;
    }
}

