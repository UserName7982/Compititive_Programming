// package CodeForces._1000Rated;

import java.util.Scanner;

public class RedVersusBlue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); 
		while (t-- > 0) {
			int n = scanner.nextInt(); 
			int r = scanner.nextInt(); 
			int b = scanner.nextInt(); 
			StringBuilder s = new StringBuilder(); 

			int length_of_red = r / (b + 1);
			int extra_red = r % (b + 1);

			for (int times = 1; times <= b + 1; times++) {
				for (int i = 0; i < length_of_red; i++) {
					s.append('R');
				}

				if (extra_red > 0) {
					s.append('R');
					extra_red--;
				}

				if (times != b + 1) {
					s.append('B');
				}
			}

			System.out.println(s.toString());
		}
		scanner.close();
	}
}
