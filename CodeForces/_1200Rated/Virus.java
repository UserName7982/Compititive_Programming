// package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int[] infected = new int[m];
            for (int i = 0; i < m; i++) {
                infected[i] = Integer.parseInt(st1.nextToken());
            }
            Arrays.sort(infected);
            List<Integer> size = new ArrayList<>();
            size.add((infected[0] - 1) + (n - infected[m - 1]));

            for (int i = 0; i < m - 1; i++) {
                size.add(infected[i + 1] - infected[i] - 1);
            }
            Collections.sort(size, (a, b) -> b - a);
            int num = 0;
            long protect = 0;
            for (int i = 0; i < size.size(); i++) {
                int g = size.get(i) - num;
                if (g > 1) {
                    protect += g - 1;
                } else if (g == 1) {
                    protect += 1;
                    break; // no later gap can contribute after this
                } else {
                    break;
                }
                num += 4;
            }
            sb.append(n - protect).append("\n");
        }
        System.out.println(sb.toString());
    }
}
