import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_Game_easy_version {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            sb.append("BOB"+"\n");
        }
        System.out.println(sb.toString());
    }
}
