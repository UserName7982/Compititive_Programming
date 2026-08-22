import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prinzessin_der_Verurteilung {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            String mex = "";
            for (char i = 'a'; i <= 'z'; i++) {
                if (mex.equals("")  && !find(s, (i + ""))) {
                    mex = i + "";
                    break;
                }
            }
            
            for (char i = 'a'; i <= 'z'; i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    String temp=""+i+j+"";
                    if (mex.equals("") && !find(s, temp)) {
                        mex=temp;
                    }
                }   
            }
              for (char i = 'a'; i <= 'z'; i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    for (char k = 'a'; k < 'z'; k++) {
                        String temp=""+i+j+k+"";
                        if (mex.equals("")  && !find(s, temp)) {
                            mex=temp;
                        }
                    }
                }   
            }
            sb.append(mex+"\n");
        }
        System.out.println(sb.toString());
    }

    static boolean find(String s, String pattern) {
        int n = pattern.length();
        for (int i = 0; i <= s.length() - n; i++) {
            // System.out.println(pattern+" "+i+"->"+n);
            if (s.substring(i, n+i).equals(pattern))
                return true;
        }
        return false;
    }
}
