import java.util.ArrayList;

public class Prime {

    public ArrayList<Integer> primes = new ArrayList<>();

    public void isPrime(int n) {
        if (n < 2) return;
        for (int i = 2; i * i <= n; i++) {
            if (primes.contains(i)) {
                continue;
            }
            if (n % i == 0) {
                return;
            }
        }
        primes.add(n);
    }

    public void upToPrime(int n) {
        for (int i = 2; i <= n; i++) {
            isPrime(i);
        }
    }
}

