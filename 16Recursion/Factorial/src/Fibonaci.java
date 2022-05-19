public class Fibonaci {
    public static int fibonacciRecursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else {
            int fib = 1;
            int prevFib = 1;

            for (int i = 2; i < n; i++) {
                int temp = fib;
                fib += prevFib;
                prevFib = temp;
            }
            return fib;
        }

    }

    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(7));
        System.out.println(fibonacciRecursive(7));

    }
}
