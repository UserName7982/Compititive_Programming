package CodeForces;

import java.util.Scanner;

public class Passing_the_Ball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            String s=sc.next();
            int ans=0;
            for(int i=0; i<n; i++){
                if(s.charAt(i)=='L'){
                    ans=i+1;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}