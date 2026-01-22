package String;
import java.util.Scanner;

public class NewYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean contain2025=false;
            boolean contain2026=false;
            for (int i = 0; i <= n - 4; i++) {
                String sub = s.substring(i, i + 4);
                if (sub.equals("2025")) {
                    contain2025 = true;
                }
                if (sub.equals("2026")) {
                    contain2026 = true;
                }
            }
            if (contain2025 && !contain2026) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
