package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Make_Them_Equal {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char cand = st.nextToken().charAt(0);
            String s = br.readLine();

            boolean equal = true;
            boolean divequal = true;
            int last = -1;

            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == cand) {
                    last = i + 1;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != cand) {
                    equal = false;
                }
            }

            if (equal) {
                sb.append(0).append("\n");
                continue;
            }

            if (last == 1) {
                sb.append(2).append("\n");
                sb.append(n).append(" ").append(n - 1).append("\n");
                continue;
            }

            if (last == -1) {
                divequal = false;
            } else {
                for (int i = last; i <= n; i += last) {
                    if (s.charAt(i - 1) != cand) {
                        divequal = false;
                        break;
                    }
                }
            }

            if (!divequal) {
                sb.append(2).append("\n");
                sb.append(n).append(" ").append(n - 1).append("\n");
            } else {
                sb.append(1).append("\n").append(last).append("\n");
            }
        }
        System.out.print(sb);
    }
}