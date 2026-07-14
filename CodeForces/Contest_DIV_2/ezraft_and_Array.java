import java.util.*;
import java.io.*;

public class ezraft_and_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            if (n == 1) {
                sb.append(1).append('\n');
            } else if (n == 2) {
                sb.append(-1).append('\n');
            } else {
                long[] arr = new long[n];
                arr[0] = 1;
                arr[1] = 2;
                arr[2] = 3;
                long s = 6L; // sum of first 3 elements

                for (int i = 3; i < n; i++) {
                    arr[i] = s;
                    s *= 2;
                }

                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]);
                    if (i != n - 1) sb.append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}