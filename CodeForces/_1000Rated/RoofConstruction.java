// package CodeForces._1000Rated;
import java.util.*;

public class RoofConstruction {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Read the number of test cases
		while (t-- > 0) {
			long n = scanner.nextLong(); // Read the number of pillars
			n--; // Decrement n to work with zero-based index
			long msb = (long) (Math.log(n) / Math.log(2)); // Find the most significant bit position of n
			List<Long> ans = new ArrayList<>(); // List to store the sequence of pillar heights
			long num = (long) Math.pow(2, msb) - 1; // Calculate the largest number with all bits set below msb
			while (num >= 0) { // Fill the list with numbers from num to 0
				ans.add(num);
				num--;
			}
			num = (long) Math.pow(2, msb); // Start from the next power of 2
			while (num <= n) { // Fill the list with numbers from num to n
				ans.add(num);
				num++;
			}

			for (long height : ans) { // Output the sequence of pillar heights
				System.out.print(height + " ");
			}
			System.out.println();
		}
		scanner.close();
	}
}

// Time Complexity (TC): O(n) = O(2*10^5)
// Space Complexity (SC): O(n) = O(2*10^5)

