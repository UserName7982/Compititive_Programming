// package CodeForces._1500Rated;
import java.io.*;

public class Line_Empire {
	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);
		StringBuilder out = new StringBuilder();
		int t = (int) fs.nextLong();
		while (t-- > 0) {
			int n = (int) fs.nextLong();
			long a = fs.nextLong();
			long b = fs.nextLong();
			long[] x = new long[n + 2]; 
			for (int i = 1; i <= n; i++) x[i] = fs.nextLong();

			long[] suf = new long[n + 3]; 
			for (int i = n; i >= 1; i--) {
				suf[i] = suf[i + 1] + x[i]; 
			}

			long ans = Long.MAX_VALUE; 
			for (int i = 0; i <= n; i++) {
				long xi = x[i]; 
				long leftCost = xi * (a + b); 
				long rightTail = suf[i + 1] - (long) (n - i) * xi; 
				long rightCost = rightTail * b; 
				long c = leftCost + rightCost;
				if (c < ans) ans = c;
			}
			out.append(ans).append('\n');
		}
		System.out.print(out.toString());
	}

	static final class FastScanner {
		private final InputStream in;
		private final byte[] buffer = new byte[1 << 16];
		private int ptr = 0, len = 0;

		FastScanner(InputStream is) {
			this.in = is;
		}

		private int read() throws IOException {
			if (ptr >= len) {
				len = in.read(buffer);
				ptr = 0;
				if (len <= 0) return -1;
			}
			return buffer[ptr++];
		}

		long nextLong() throws IOException {
			int c;
			do {
				c = read();
			} while (c <= ' ');
			int sign = 1;
			if (c == '-') {
				sign = -1;
				c = read();
			}
			long val = 0;
			while (c > ' ') {
				val = val * 10 + (c - '0');
				c = read();
			}
			return val * sign;
		}
	}
}
