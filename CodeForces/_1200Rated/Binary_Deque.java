package CodeForces._1200Rated;

import java.io.*;
import java.util.*;

public class Binary_Deque {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            int count1 = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                count1 += arr[i];
            }

            // Not enough 1s
            if (count1 < m) {
                sb.append(-1).append('\n');
                continue;
            }

            // Already exactly m ones
            if (count1 == m) {
                sb.append(0).append('\n');
                continue;
            }

            // Find longest subarray having exactly m ones
            int left = 0;
            int ones = 0;
            int maxLen = 0;

            for (int right = 0; right < n; right++) {

                ones += arr[right];

                while (ones > m) {
                    ones -= arr[left];
                    left++;
                }

                if (ones == m) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }

            sb.append(n - maxLen).append('\n');
        }

        System.out.print(sb);
    }
}