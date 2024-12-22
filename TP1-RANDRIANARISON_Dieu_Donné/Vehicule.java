public class Vehicule {
    int vitesse;
    int nbrPassager;

    public Vehicule(int vitesse, int nbrPassager) {
        this.vitesse = vitesse;
        this.nbrPassager = nbrPassager;
    }

    public void afficherInfo() {
        System.out.println("Vitesse: " + vitesse + " km/h");
        System.out.println("Nombre de passagers: " + nbrPassager);
    }
}

class Avion extends Vehicule {
    public Avion(int vitesse, int nbrPassager) {
        super(vitesse, nbrPassager);
    }

    public void voler() {
        System.out.println("L'avion vole à une vitesse de " + vitesse + " km/h.");
    }
}