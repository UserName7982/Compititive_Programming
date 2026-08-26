package CodeForces._1200Rated;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pleasant_Pairs {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());


        while (t-->0) {
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[][] arr=new int[n][2];
            for(int i=0; i<n; i++){
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=i+1;
            }
            Arrays.sort(arr,(a,b)->a[0]-b[0]);
            int ans=0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    if((1L*arr[i][0]*arr[j][0])>2*n) break;
                    if((1L*arr[i][0]*arr[j][0])==(1L*arr[i][1]+arr[j][1])){
                        ans++;
                    }
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
