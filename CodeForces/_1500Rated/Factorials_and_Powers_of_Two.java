package CodeForces._1500Rated;
import java.io.*;
import java.util.*;

public class Factorials_and_Powers_of_Two {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        ArrayList<Long> fact = new ArrayList<>();

        long f = 1;
        for (int i = 1; ; i++) {
            f *= i;

            if (f > 1_000_000_000_000L)
                break;

            if (i >= 3)
                fact.add(f);
        }

        while (t-- > 0) {

            long n = sc.nextLong();

            int m=fact.size();

            long ans = Long.bitCount(n);

            for(int mask=0; mask<(1<<m); mask++){
                long sum=0;
                int cnt=0;
                for(int i=0;i<m;i++){
                    if((mask&(1<<i))!=0){
                        sum+=fact.get(i);
                        cnt++;
                    }
                }
                if(sum>n) continue;
                cnt+=Long.bitCount(n-sum);
                ans=Math.min(ans,cnt);
            }

            System.out.println(ans);
        }
    }
}