package CodeForces.Contest_DIV_2;

import java.util.Arrays;
import java.util.Scanner;

public class Another_Puzzlefrom_Papyrus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int c=sc.nextInt();

            int[] a=new int[n];
   
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int[] b=new int[n];
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            long ans1=0;
            long max=(int)1e9;
            for(int i=0; i<n; i++){
                if(a[i]<b[i]){
                    ans1=max;
                    break;
                }else{
                    ans1+=a[i]-b[i];
                }
            }  
            Arrays.sort(a);
            Arrays.sort(b);
            long ans2=0;
            for(int i=0; i<n; i++){
                if(a[i]<b[i]){
                    ans2=max;
                    break;
                }
                    ans2+=a[i]-b[i];
            }   
            
            if(ans1==max && ans2==max){
                System.out.println(-1);
            }else if(ans1==max){
                System.out.println(ans2+=c);
            }else if(ans2==max){
                System.out.println(ans1);
            }else{
                System.out.println(Math.min(ans1, ans2+=c));
            }
        }
    }
}
