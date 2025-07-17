import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {
    public long getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public long getFibonacciPD(int n) {
        Map<Long, Long> caching = new HashMap<>();
        return getFibonacciPDHelper(n, caching);
    }

    public long getFibonacciPDHelper(long n, Map<Long, Long> caching) {
        if (n <= 1) {
            caching.put(n, n);
            return n;
        }
        if (caching.containsKey(n)) {
            return caching.get(n);
        }
        long resultado = getFibonacciPDHelper(n - 1, caching) + getFibonacciPDHelper(n - 2, caching);
        caching.put(n, resultado);
        return resultado;

    }
}