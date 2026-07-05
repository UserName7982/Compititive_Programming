package CodeForces._1000Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Array_merging {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static HashMap<Integer, Integer> longestRuns(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 1;
        map.put(a[0], 1);

        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1])
                cnt++;
            else
                cnt = 1;

            map.put(a[i], Math.max(map.getOrDefault(a[i], 0), cnt));
        }

        return map;
    }

    public static void main(String[] args) {
        try {
            int t = nextInt();
            while (t-- > 0) {
                int n = nextInt();
                int[] arr = new int[n];
                int[] brr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextInt();
                }
                for (int i = 0; i < n; i++) {
                    brr[i] = nextInt();
                }

                HashMap<Integer, Integer> map = longestRuns(arr);
                HashMap<Integer, Integer> map1 = longestRuns(brr);

                int answer = 0;

                for (int x : map.keySet()) {
                    answer = Math.max(answer,
                            map.get(x) + map1.getOrDefault(x, 0));
                }

                for (int x : map1.keySet()) {
                    answer = Math.max(answer,
                            map1.get(x) + map.getOrDefault(x, 0));
                }

                System.out.println(answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
