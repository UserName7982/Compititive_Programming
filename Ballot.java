import java.io.*;
import java.util.*;

public class Ballot {

    static final long MOD = 1_000_000_007L;
    static final int DEN = 1_000_000;

    static long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] =
                            (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    static long[] multiplyVector(long[] v, long[][] M) {
        int n = v.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            if (v[i] == 0) continue;

            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) continue;

                res[j] =
                        (res[j] + v[i] * M[i][j]) % MOD;
            }
        }

        return res;
    }

    static long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return res;
    }

    static long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    static long solve(long N, int K, long B, long R) {

        int S = K + 1;

        /*
         * Probability of choosing blue:
         *      B / 10^6
         *
         * Probability of choosing red:
         *      R / 10^6
         */

        long invMillion = modInverse(DEN);

        long pBlue = B * invMillion % MOD;
        long pRed = R * invMillion % MOD;

        /*
         * M[i][j] =
         * probability of moving from state i to state j
         */
        long[][] M = new long[S][S];

        for (int i = 0; i <= K; i++) {

            // Blue: balance + 1
            if (i + 1 <= K) {
                M[i][i + 1] = pBlue;
            }

            // Red: balance - 1
            if (i - 1 >= 0) {
                M[i][i - 1] = pRed;
            }
        }

        /*
         * Initial state:
         *
         * balance = 0
         *
         * vector = [1, 0, 0, ..., 0]
         */
        long[] vector = new long[S];
        vector[0] = 1;

        /*
         * We need:
         *
         * vector * M^N
         *
         * Binary exponentiation.
         */
        while (N > 0) {

            if ((N & 1) == 1) {
                vector = multiplyVector(vector, M);
            }

            N >>= 1;

            if (N > 0) {
                M = multiply(M, M);
            }
        }

        /*
         * We can finish at ANY balance from 0 to K.
         *
         * Therefore sum all states.
         */
        long answer = 0;

        for (long x : vector) {
            answer += x;

            if (answer >= MOD) {
                answer -= MOD;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        long B = Long.parseLong(br.readLine().trim());
        long R = Long.parseLong(br.readLine().trim());

        System.out.println(solve(N, K, B, R));
    }
}