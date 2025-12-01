package baekjoon.no10171;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] cat = new String[4][8];

        for (int i = 0; i < cat.length; i++) {

            Arrays.fill(cat[i], " ");
        }
        cat[0][0] = "\\";
        cat[0][5] = "/";
        cat[0][6] = "\\";

        cat[1][1] = ")";
        cat[1][4] = "(";
        cat[1][6] = "'";
        cat[1][7] = ")";

        cat[2][0] = "(";
        cat[2][3] = "/";
        cat[2][6] = ")";

        cat[3][1] = "\\";
        cat[3][2] = "(";
        cat[3][3] = "_";
        cat[3][4] = "_";
        cat[3][5] = ")";
        cat[3][6] = "|";

        for (int i = 0; i < cat.length; i++) {

            for (int j = 0; j < cat[i].length; j++) {
                System.out.print(cat[i][j]);
            }
            System.out.println();
        }
    }
}
