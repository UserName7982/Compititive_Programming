// package CodeForces._1000Rated;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Luke_Foodie {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int x=sc.nextInt();

            long arr[]=new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextLong();
            }
            List<long[]> list=new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(new long[]{arr[i]-x,arr[i]+x});
            }
            long l=list.get(0)[0];
            long r=list.get(0)[1];
            int ans=0;
            int i=0;
            for (long[] num: list){
                if ((i==0)) {
                    i++;
                    continue;
                }
                l=Math.max(l, num[0]);
                r=Math.min(r,num[1]);
                if(l>r){
                    ans++;
                    l=num[0];
                    r=num[1];
                }
            }
            System.out.println(ans);
        }
    }
}
