import java.io.*;
import java.util.*;

public class Bracket_Coloring {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		int t = Integer.parseInt(br.readLine().trim()); // number of test cases
		for (int caseNum = 0; caseNum < t; caseNum++) {
			int n = Integer.parseInt(br.readLine().trim()); // length of the bracket string
			String s = br.readLine().trim(); // bracket string

			int[] bal = new int[n]; // bal[i] = prefix balance up to i ('(' = +1, ')' = -1)
			bal[0] = (s.charAt(0) == '(' ? 1 : -1); // initial balance
			for (int i = 1; i < n; i++) {
				bal[i] = bal[i - 1] + (s.charAt(i) == '(' ? 1 : -1); // accumulate balance
			}

			if (bal[n - 1] != 0) { 
				out.append("-1\n");
				continue;
			}

			int minBal = bal[0], maxBal = bal[0]; 
			for (int i = 1; i < n; i++) {
				if (bal[i] < minBal) minBal = bal[i];
				if (bal[i] > maxBal) maxBal = bal[i];
			}

			if (minBal == 0 || maxBal == 0) { 
				out.append("1\n");
				for (int i = 0; i < n; i++) {
					out.append("1"); 
					if (i + 1 < n) out.append(' ');
				}
				out.append('\n');
			} else {
				int[] ans = new int[n]; // colors per position
				for (int i = 0; i < n; i++) {
					if (bal[i] > 0) ans[i] = 1; // positive side -> color 1
					else if (bal[i] < 0) ans[i] = 2; // negative side -> color 2
					else ans[i] = (bal[i - 1] > 0 ? 1 : 2); // at zero, continue the side we were on
				}
				out.append("2\n"); // two colors are needed and sufficient
				for (int i = 0; i < n; i++) {
					out.append(ans[i]);
					if (i + 1 < n) out.append(' ');
				}
				out.append('\n');
			}
		}

		System.out.print(out.toString());
	}
}

