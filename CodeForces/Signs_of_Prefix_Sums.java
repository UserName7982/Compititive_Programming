package CodeForces;
import java.io.*;
import java.util.*;

public class Signs_of_Prefix_Sums {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            // 00 is impossible because p[i-1] = p[i] = 0
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println(-1);
                continue;
            }

            int answer = 1;

            int i = 0;

            while (i < n) {

                // Skip zero
                if (s.charAt(i) == '0') {
                    i++;
                    continue;
                }

                int start = i;
                char sign = s.charAt(i);

                // Find this sign run
                while (i < n && s.charAt(i) == sign) {
                    i++;
                }

                int len = i - start;

                // A run of length > 1 means cost 1 is impossible
                if (len > 1) {
                    answer = 2;
                }

                /*
                 * Check whether this run is:
                 *
                 * opposite sign ... current run ... opposite sign
                 *
                 * and has even length.
                 *
                 * In that case cost 3 is unavoidable.
                 */
                if (len % 2 == 0) {

                    boolean leftOpposite = false;
                    boolean rightOpposite = false;

                    if (start > 0 && s.charAt(start - 1) != '0') {
                        leftOpposite = s.charAt(start - 1) != sign;
                    }

                    if (i < n && s.charAt(i) != '0') {
                        rightOpposite = s.charAt(i) != sign;
                    }

                    if (leftOpposite && rightOpposite) {
                        answer = 3;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}