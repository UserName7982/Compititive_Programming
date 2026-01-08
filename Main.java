import java.util.Scanner;

public class Main {


    static int simulate(long white, long dark, boolean topWhite) {
        long size = 1;
        boolean useWhite = topWhite;
        int layers = 0;
        while (true) {
            if (useWhite) {
                if (white >= size) {
                    white -= size;
                } else break;
            } else {
                if (dark >= size) {
                    dark -= size;
                } else break;
            }
            layers++;
            size <<= 1;           
            useWhite = !useWhite; 
        }
        return layers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong(); 
            long b = sc.nextLong(); 
            int ans = Math.max(simulate(a, b, true), simulate(a, b, false));
            System.out.println(ans);
        }
        sc.close();
    }
}
