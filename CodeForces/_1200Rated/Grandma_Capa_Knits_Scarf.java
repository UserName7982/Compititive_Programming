import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grandma_Capa_Knits_Scarf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int ans = Integer.MAX_VALUE;
            char a = '~';
            char b = '~';
            int i = 0;
            int j = n - 1;

            while (i <= j && s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            if (i > j) {
                sb.append(0 + "\n");
                continue;
            }

            a = s.charAt(i);
            b = s.charAt(j);
            ans = Math.min(palindrome(s, a), palindrome(s, b));
            sb.append((ans == Integer.MAX_VALUE ? -1 : ans) + "\n");
        }
        System.out.println(sb.toString());
    }

    static int palindrome(String s, char a) {
        int ans = 0;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i) == a) {
                    i++;
                    ans++;
                } else if (s.charAt(j) == a) {
                    j--;
                    ans++;
                } else {
                    ans = Integer.MAX_VALUE;
                    break;
                }
            } else {
                i++;
                j--;
            }
        }
        return ans;
    }
}
