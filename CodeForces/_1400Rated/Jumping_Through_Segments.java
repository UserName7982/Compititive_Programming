// package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Jumping_Through_Segments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int ans = 0;
            int low = 0;

            int[][] arr = new int[n][2];
            int max = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][1]);
            }
            int high = max;

            while (low <= high) {
                int mid = low +(high - low) / 2;
                if (can(mid, arr)) {
                    high = mid - 1;
                    ans=mid;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean can(int k, int[][] arr) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int l = arr[i][0];
            int r = arr[i][1];

            // Positions reachable after jumping at most k
            min = Math.max(l, min - k);
            max = Math.min(r, max + k);

            // No overlap with current segment
            if (min > max) {
                return false;
            }
        }

        return true;
    }
}
