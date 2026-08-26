package CodeForces._900Rated;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Simons_and_Cakes_for_Success {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            Set<Integer> ls=PrimeFactors(n);
            int ans=1;
            for(int num: ls){
                ans*=num;
            }
            System.out.println(ans);
        }
    }
    public static Set<Integer> PrimeFactors(int n) {
        Set<Integer> list = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        if (n > 1) {
            list.add(n);
        }
        return list;
    }
}
