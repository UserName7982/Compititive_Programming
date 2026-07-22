package CodeForces._1200Rated;

import java.util.*;

public class Plus_Minus_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long common = n/lcm(x, y);
            long count1 = (n / x) - (common);
            long count2 = (n / y) - (common);
            System.out.println(sum(n - count1+1, n) - sum(1L, count2));

        }
    }

    public static long sum(long start, long end) {
        long sum = ((start + end) * (end - start + 1)) / 2;
        return sum;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
