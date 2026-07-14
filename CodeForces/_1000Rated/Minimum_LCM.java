import java.util.Scanner;

public class Minimum_LCM {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long t = scanner.nextLong(); 
		while (t-- > 0) {
			long n = scanner.nextLong();  

			long ans_a = 1;
			long ans_b = n - 1;

			for (long fac = 2; fac * fac <= n; fac++) {
				if (n % fac == 0) {
					ans_a = n / fac;
					ans_b = n - ans_a;
					break;
				}
			}

			System.out.println(ans_a + " " + ans_b);
		}
		scanner.close();
	}
}
