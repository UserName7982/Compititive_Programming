package BitManipulation;
import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        int L = Integer.toBinaryString(c).length();
        int a = (1 << (L - 1)) - 1; // all 1’s below top bit
        int b = a ^ c;              // force XOR = c

        System.out.println((long)a * b);
        sc.close();
    }
}
