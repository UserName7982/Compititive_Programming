package Prime;

import java.util.*;

public class Question {

    static int max = 1000001;
    static int[] hp = new int[max];
    static int[] hsh = new int[max];
    static int[] canremove = new int[max];

    // Precompute smallest prime factor for every number
    public static void lprime(int n) {
        for (int i = 2; i <= n; i++) {
            if (hp[i] == 0) { // i is prime
                for (int j = i; j <= n; j += i) {
                    if (hp[j] == 0) hp[j] = i; // set SPF
                }
            }
        }
    }

    // Return distinct prime factors of n
    public static List<Integer> Distinct_PrimeF(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            int p = hp[n];
            list.add(p);
            while (n % p == 0) {
                n /= p;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lprime(max - 1);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            hsh[arr[i]]++;
        }

        // mark multiples of present numbers
        for (int i = 2; i < max; i++) {
            if (hsh[i] > 0) {
                for (int j = i; j < max; j *= i) {
                    canremove[j] = 1;
                }
            }
        }

        // process queries
        while (k-- > 0) {
            int x = sc.nextInt();
            List<Integer> list = Distinct_PrimeF(x);

            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i; j < list.size(); j++) {
                    int product = list.get(i) * list.get(j);
                    if (x % product == 0 && canremove[x / product] == 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }

            System.out.println(flag ? "YES" : "NO");
        }
        sc.close();
    }
}
