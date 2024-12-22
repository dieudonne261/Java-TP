public class TestException {
    public static void main(String[] args) {
        int j = 20, i = 0;
        try {
            System.out.println(j / i);
        } catch (ArithmeticException e) {
            System.out.println("Division par zéro !");
        }
        System.out.println("coucou toi !");
    }
}