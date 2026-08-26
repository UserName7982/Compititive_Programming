package CodeForces._1200Rated;
// package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Friends_and_the_Restaurant {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0){
            int n=Integer.parseInt(br.readLine()); 
            StringTokenizer st1=new StringTokenizer(br.readLine());
            StringTokenizer st2=new StringTokenizer(br.readLine());

            int[] x=new int[n];
            for(int i=0; i<n; i++){
                x[i]=Integer.parseInt(st1.nextToken());
            }
            int[] y=new int[n];
            for(int i=0; i<n; i++){
                y[i]=Integer.parseInt(st2.nextToken());
            }
            int[] diff=new int[n];
            for(int i=0; i<n; i++){
                diff[i]=y[i]-x[i];
            }
            Arrays.sort(diff);
            int i=0;
            int j=n-1;
            int ans=0;
            while (i<j) {
                if(1L*diff[i]+diff[j]>=0){
                    j--;
                    ans++;
                }
                i++;
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
