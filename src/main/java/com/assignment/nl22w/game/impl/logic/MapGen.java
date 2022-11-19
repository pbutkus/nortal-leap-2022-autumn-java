package com.assignment.nl22w.game.impl.logic;

public class MapGen {

    public int[][] generate(int y, int x) {
        int[][] map = new int[y][];

        for (int i = 0; i < y; i++) {
            map[i] = new int[x];
            for (int j = 0; j < x; j++) {
                if (i == 0 || i == y - 1) {
                    map[i][j] = 1;

                    if (i == x - 1 && j == y - 2) {
                        map[i][j] = 3;
                    }
                } else {
                    map[i][j] = 0;

                    if (j == 0 || j == x - 1) {
                        map[i][j] = 1;
                    }

                    if (j == 1 && i == 1) {
                        map[i][j] = 2;
                    }
                }
            }
        }

        return map;
    }

}
