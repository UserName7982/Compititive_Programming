package CodeForces._900Rated;

import java.util.HashMap;
import java.util.Scanner;

public class Array_Cloning_Technique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            
            int n=sc.nextInt();
            int[] a=new int[n];
            HashMap<Integer, Integer> map=new HashMap<>();
            for(int i=0;i<n;i++) {
                a[i]=sc.nextInt();
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            int maxFreq=0;
            for(int freq: map.values()) {
                maxFreq=Math.max(maxFreq, freq);
            }
            int operations=0;
            while (maxFreq<n) {
                operations+=Math.min(n-maxFreq, maxFreq)+1;
                maxFreq*=2; 
            }
            System.out.println(operations);
        }
        sc.close();
    }
}
