package CodeForces;

import java.util.Scanner;

public class Eating_Game {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            int max=-1;
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
                max=Math.max(max, arr[i]);
            }
            int ans=0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==max) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
