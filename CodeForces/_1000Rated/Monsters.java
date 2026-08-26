package CodeForces._1000Rated;

import java.util.*;

/**
 * Monsters
 */
public class Monsters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();

            PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->{
                if(a[1]==b[1]){
                    return Long.compare(a[0],b[0]);
                }
                return Long.compare(b[1],a[1]);
            });

            for(int i=0; i<n; i++){
                int x=sc.nextInt();
                int num=x%k;
                if(num==0) num=k;
                pq.add((new long[]{i+1,num}));
            }
            int[] ans=new int[n];
            int i=0;
            while(!pq.isEmpty()){
                long[] temp=pq.poll();
                ans[i++]= (int) temp[0];
               
            }
            for(int j=0; j<n; j++){
                System.out.print(ans[j]+" ");
            }
            System.out.println();
        }
    }
}