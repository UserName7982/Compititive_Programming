package CodeForces._900Rated;

import java.util.Scanner;

public class Comparison_String {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            String s=sc.next();
            int count=1;
            int ans=1;
            char prev=s.charAt(0);
            for (int i = 1; i < n; i++) {
                char c=s.charAt(i);
                if (c==prev) {
                    count++;
                }else {
                    count=1;
                }
                prev=c;
                ans=Math.max(ans,count);
            }
            System.out.println(ans+1);
        }
    }    
}
