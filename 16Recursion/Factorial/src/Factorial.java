public class Factorial {

    public static int factorialValueRecursive(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Neexistuje záporný factoriál!");
        }
        if (a >= 1) {
            return a * factorialValueRecursive(a - 1);
        } else {
            return 1;
        }

    }

    public static int factorialValueIterative(int a) {
        int temp = 0;
        if (a < 0) {
            throw new IllegalArgumentException("Neexistuje záporný factoriál!");
        }
        if (a >= 1) {

            for (int i = 1; i < a; i++) {
                temp = i * i + 1;
            }
            return temp;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorialValueRecursive(5));
        System.out.println(factorialValueRecursive(5));

    }

}
