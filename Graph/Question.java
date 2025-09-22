package Graph;

import java.util.Scanner;

public class Question {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] graph = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextLong();
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() - 1; 
        }

        long[] ans = new long[n];
        boolean[] added = new boolean[n];

        for (int k = n - 1; k >= 0; k--) {
            int v = arr[k];
            added[v] = true;

            // update shortest paths using v as intermediate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][v] + graph[v][j]);
                }
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (!added[i]) continue;
                for (int j = 0; j < n; j++) {
                    if (!added[j]) continue;
                    sum += graph[i][j];
                }
            }
            ans[k] = sum;
        }

        for (long x : ans) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
