import java.util.Scanner;

public class Voiture {
    private int id;
    private String marque;
    private String type;

    public Voiture(int id, String marque, String type) {
        this.id = id;
        this.marque = marque;
        this.type = type;
    }

    public void afficherVoiture() {
        System.out.println("ID: " + id);
        System.out.println("Marque: " + marque);
        System.out.println("Type: " + type);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez l'ID de la voiture: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez la marque de la voiture: ");
        String marque = scanner.nextLine();

        System.out.print("Entrez le type de la voiture: ");
        String type = scanner.nextLine();

        Voiture voiture = new Voiture(id, marque, type);
        System.out.println("\nInformations de la voiture saisie:");
        voiture.afficherVoiture();
    }
}
