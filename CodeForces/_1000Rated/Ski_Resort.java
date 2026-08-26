package CodeForces._1000Rated;

import java.util.*;

public class Ski_Resort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int q=sc.nextInt();
            int[] temp=new int[n];
            for(int i=0;i<n;i++){
                temp[i]=sc.nextInt();
            }
            int i=0,j=0;
            long ans=0;
            while(i<n&& j<n){
                if(temp[j]<=q && j-i+1>=k){
                    ans+=(j-i+1)-k+1;
                }
                if(temp[j]>q){
                    i=j+1;
                }
                j++;
            }
            System.out.println(ans);
        }
    }
}
