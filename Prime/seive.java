package Prime;

public class seive {
    boolean[] primes;

    seive(boolean primes[]) {
        this.primes = primes;
    }

    public void Seive(int n) {
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        boolean primes[] = new boolean[n + 1];
        seive s = new seive(primes);
        s.Seive(n);
        for (int i = 2; i <= n; i++) {
            if (s.primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
