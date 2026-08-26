package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome_Game_easy_version {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            boolean allone=true;
            int count1=0;
            int count0=0;
            for(char ch: s.toCharArray()){
                if(ch=='0'){
                    count0++;
                    allone=false;
                }else{
                    count1++;
                }
            }
            if (allone) {
                sb.append("DRAW"+"\n");
                continue;
            }
            if(n%2==0){
                sb.append("BOB"+"\n");
            }else{
                if(s.charAt(n/2)=='1' || count0==1){
                    sb.append("BOB"+"\n");
                }else{
                    sb.append("ALICE"+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
