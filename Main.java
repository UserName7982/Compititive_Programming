import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        char[] A = br.readLine().trim().toCharArray();
        char[] B = br.readLine().trim().toCharArray();
        char[] C = br.readLine().trim().toCharArray();

        int len = 2 * n;
        int[] posA = new int[n], posB = new int[n], posC = new int[n];
        collectOnes(A, posA);
        collectOnes(B, posB);
        collectOnes(C, posC);

        char[] result = new char[len];
        Arrays.fill(result, '0');
        long total = 0;

        for (int i = 0; i < n; i++) {
            int a = posA[i], b = posB[i], c = posC[i];
            int mx = Math.max(a, Math.max(b, c));
            int mn = Math.min(a, Math.min(b, c));
            int median = a + b + c - mx - mn; 
            total += (mx - mn);
            result[median] = '1';
        }

        StringBuilder sb = new StringBuilder();
        sb.append(total).append('\n');
        sb.append(new String(result)).append('\n');
        System.out.print(sb);
    }

    static void collectOnes(char[] s, int[] pos) {
        int k = 0;
        for (int idx = 0; idx < s.length; idx++) {
            if (s[idx] == '1') {
                pos[k++] = idx;
            }
        }
    }
}