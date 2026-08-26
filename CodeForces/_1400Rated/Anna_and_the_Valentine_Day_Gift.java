package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Anna_and_the_Valentine_Day_Gift {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st1.nextToken());
            }
            List<Integer> zero = new ArrayList<>();
            int totalDigits=0;
            for (int i = 0; i < n; i++) {
                String num = String.valueOf(arr[i]);
                totalDigits+=num.length();
                int zeros=0;
                for (int j = num.length() - 1; j >= 0; j--) {
                    if (num.charAt(j) == '0') {
                        zeros++;
                    }else break;
                }
                zero.add(zeros);
            }
            zero.sort((o1, o2) -> o2 - o1);
            for (int i = 0; i < zero.size(); i++) {
                if(i%2==0){
                    totalDigits-=zero.get(i);
                }
            }
            sb.append(totalDigits>=m+1?"Sasha":"Anna").append("\n");
        }
        System.out.println(sb.toString());
    }
}
