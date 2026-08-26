package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Stone_Age_Problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map=new HashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st2.nextToken());
        int q=Integer.parseInt(st2.nextToken());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        long sum=0;
        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(st1.nextToken());
            map.put(i+1,val);
            sum+=val;
        }
        int prev=-1;
        while (q-->0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int type=Integer.parseInt(st.nextToken());
            if (type==1) {
                int indx=Integer.parseInt(st.nextToken());
                int val=Integer.parseInt(st.nextToken());
                int preval=(prev==-1?map.get(indx):(map.get(indx)==null?prev:map.get(indx)));
                sum=sum-1L*preval+val;
                map.put(indx, val);
            }else{
                int val=Integer.parseInt(st.nextToken());
                sum=1L*n*val;
                prev=val;
                map=new HashMap<>();
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }
}
