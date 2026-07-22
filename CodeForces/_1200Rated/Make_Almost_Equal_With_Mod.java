// package CodeForces._1200Rated;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Make_Almost_Equal_With_Mod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long[] arr=new long[n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextLong();
            }
            long power2=0;
            
            for(int i=1; i<=60; i++){
                Set<Long> set=new HashSet<>();
                power2=(1L<<i);
                for(int j=0; j<n; j++){
                    set.add((arr[j]%power2));
                }
                if(set.size()==2){
                    break;
                }
            }
              System.out.println(power2);
        }
    }
}
