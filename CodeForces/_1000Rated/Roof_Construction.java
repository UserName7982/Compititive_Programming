package CodeForces._1000Rated;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Roof_Construction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            n--;
            long power=(long)(Math.log(n)/Math.log(2));
            List<Long> ans=new ArrayList<>();
            long crpos=(long)Math.pow(2, power)-1;
            long num=crpos;
            while (num>=0) {
                ans.add(num);
                num--;
            }
            num=crpos+1;
            while (num<=n) {
                ans.add(num);
                num++;
            }
            for (int i = 0; i <=n; i++) {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
