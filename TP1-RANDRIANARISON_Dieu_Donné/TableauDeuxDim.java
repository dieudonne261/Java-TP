public class TableauDeuxDim {
    public static void main(String[] args) {
        int[][] tab = new int[2][3];

        System.out.println("Longueur du tableau: " + tab.length);

        for (int ligne = 0; ligne < 2; ligne++) {
            for (int col = 0; col < 3; col++) {
                System.out.println("tab[" + ligne + "," + col + "]=" + tab[ligne][col]);
            }
        }

        System.out.println("---");

        for (int ligne = 0; ligne < 2; ligne++) {
            for (int col = 0; col < 3; col++) {
                tab[ligne][col] = (ligne + 1) * (col + 1);
            }
        }

        for (int ligne = 0; ligne < 2; ligne++) {
            for (int col = 0; col < 3; col++) {
                System.out.println("tab[" + ligne + "," + col + "]=" + tab[ligne][col]);
            }
        }
    }
}