package com.gmail.velikiydan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int s = sc.nextInt() - 1;
        int f = sc.nextInt() - 1;
        int g[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        int distance[] = new int[n];
        boolean used[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s] = 0;
        fire(s, g, distance, used);
        int out = (distance[f] == Integer.MAX_VALUE) ? (-1) : (distance[f]);
        System.out.println(out);
        sc.close();

    }

    private static void fire(int s, int[][] g, int[] distance, boolean[] used) {
        for (int i = 0; i < g.length; i++) {
            if (g[s][i] == 0 || g[s][i] == -1 || used[i])
                continue;
            int actual = distance[s] + g[s][i];
            if (actual < distance[i]) {
                distance[i] = actual;
            }
        }
        used[s] = true;

        int temp = Integer.MAX_VALUE;
        int next = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!used[i] && temp > distance[i]) {
                temp = distance[i];
                next = i;
            }
        }
        if (next != -1)
            fire(next, g, distance, used);

    }
}
