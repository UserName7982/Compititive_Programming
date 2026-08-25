import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_Dances_Easy_version {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] c = new long[n];
            c[0] = 1; 

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                c[i] = Long.parseLong(st.nextToken());
            }

            long[] b = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(c);
            Arrays.sort(b);

            int i = 0, matches = 0;
            for (int j = 0; j < n; j++) {
                if (i < n && c[i] < b[j]) {
                    matches++;
                    i++;
                }
            }

            int ans = n - matches;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}