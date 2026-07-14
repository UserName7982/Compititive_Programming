// package CodeForces._1000Rated;

import java.util.Scanner;

public class Black_and_White_Stripe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            String s=sc.next();
            int i=0;
            int j=0;
            int ans=Integer.MAX_VALUE;
            int count_b=0;
            int count_w=0;
            while(i<n&&j<n){
                if(s.charAt(j)=='B'){
                    count_b++;
                }else{
                    count_w++;
                }
                if(j-i+1>=k){
                    ans=Math.min(ans,count_w);
                    if (s.charAt(i)=='W') {
                        count_w--;
                    }else{
                        count_b--;
                    }
                    i++;
                }
                j++;
            }
            System.out.println(ans);
        }
    }
}
