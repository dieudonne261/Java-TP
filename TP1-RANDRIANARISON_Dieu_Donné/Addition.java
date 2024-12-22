import java.util.Scanner;

public class Addition {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n1, n2, somme;
        System.out.print("Donner le premier entier :");
        n1 = input.nextInt();
        System.out.print("Donner un deuxième entier : ");
        n2 = input.nextInt();
        somme = n1 + n2;
        System.out.printf("La somme est : %d\n", somme);
    }
}