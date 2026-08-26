package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class differential_Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] arr=new int[n];
            for(int i=0; i<n; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            if(arr[n-1]<arr[n-2]) {
                sb.append(-1+"\n");
                continue;
            }
            if(arr[n-1]>=0){
                sb.append(n-2+"\n");
                for(int i=1; i<=n-2; i++){
                    sb.append(i+" "+(n-1)+" "+(n)+"\n");
                }
            }else{
                int[] temp=Arrays.copyOf(arr,n);
                Arrays.sort(temp);
                if (Arrays.equals(arr, temp)) {
                    sb.append(0+"\n");
                }else{
                    sb.append(-1+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}
