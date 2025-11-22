package Prime;

import java.util.ArrayList;
import java.util.List;

public class primeFactors {

    public List<Integer> PrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        if (n > 1) {
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        primeFactors p = new primeFactors();
        System.out.println(p.PrimeFactors(89));
        for (int i = 1; i < 100; i++) {
            List<Integer> list = p.PrimeFactors(i);
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            if (i % 2 != 0 && sum == i) {
                System.out.println(i);
                // break;
            }
        }
    }
}
