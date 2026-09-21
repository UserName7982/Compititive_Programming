// package CodeForces._1500Rated;
import java.io.*;
import java.util.*;

public class Eastern_Exhibition {

	static long solve(long[] a) {
		Arrays.sort(a);
		int n = a.length;
		return a[n / 2] - a[(n - 1) / 2] + 1; 
	}

	public static void main(String[] args) throws Exception {
		FastScanner fs = new FastScanner(System.in);
		int t = fs.nextInt();
		StringBuilder out = new StringBuilder();
		while (t-- > 0) {
			int n = fs.nextInt();
			long[] xs = new long[n];
			long[] ys = new long[n];
			for (int i = 0; i < n; i++) {
				xs[i] = fs.nextLong();
				ys[i] = fs.nextLong();
			}
			long ans = solve(xs) * solve(ys);
			out.append(ans).append('\n');
		}
		System.out.print(out.toString());
	}

	static class FastScanner {
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

		private int skip() throws IOException {
			int c;
			while ((c = read()) != -1 && c <= ' ') {}
			return c;
		}

		int nextInt() throws IOException {
			int c = skip();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int x = 0;
			while (c > ' ') {
				x = x * 10 + c - '0';
				c = read();
			}
			return x * sgn;
		}

		long nextLong() throws IOException {
			int c = skip();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long x = 0L;
			while (c > ' ') {
				x = x * 10L + (c - '0');
				c = read();
			}
			return x * sgn;
		}
	}
}
