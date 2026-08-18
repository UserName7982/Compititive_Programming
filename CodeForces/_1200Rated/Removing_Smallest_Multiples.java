// package CodeForces._1200Rated;

import java.io.*;

public class Removing_Smallest_Multiples {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            boolean[] removed = new boolean[n + 1];

            long ans = 0;

            for (int x = 1; x <= n; x++) {

                if (s.charAt(x - 1) == '1') {
                    continue;
                }

                for (int j = x; j <= n; j += x) {

                   
                    if (s.charAt(j - 1) == '1') {
                        break;
                    }

                    if (removed[j]) {
                        continue;
                    }

                    removed[j] = true;
                    ans += x;
                }
            }

            System.out.println(ans);
        }
    }
}