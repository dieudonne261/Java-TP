import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer le texte chiffré (lettres uniquement) :");
        String ciphertext = scanner.nextLine().replaceAll("[^A-Z]", "").toUpperCase();

        if (ciphertext.isEmpty()) {
            System.out.println("Erreur : Le texte chiffré est vide ou invalide. Veuillez entrer un texte valide");
            return;
        }

        try {
            System.out.println("\nPhase 1 : Trouver la longueur de la clé");
            int keyLength = findKeyLength(ciphertext);
            if (keyLength == -1) {
                System.out.println("Impossible de déterminer la longueur de la clé. Vérifiez que votre texte est assez long et qu'il contient des répétitions.");
                return;
            }
            System.out.println("Longueur probable de la clé : " + keyLength);

            System.out.println("\nPhase 2 : Déterminer la clé probable");
            String key = findKey(ciphertext, keyLength);
            System.out.println("Mot clé trouvé : " + key);

            System.out.println("\nPhase 3 : Déchiffrer le texte");
            String plaintext = decrypt(ciphertext, key);
            System.out.println("Texte déchiffré :\n" + plaintext);
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int findKeyLength(String text) {
        Map<String, List<Integer>> repeatedSequences = new HashMap<>();
        int textLength = text.length();

        for (int i = 0; i < textLength - 3; i++) {
            String sequence = text.substring(i, i + 3);
            for (int j = i + 3; j < textLength - 3; j++) {
                if (text.substring(j, j + 3).equals(sequence)) {
                    repeatedSequences.putIfAbsent(sequence, new ArrayList<>());
                    repeatedSequences.get(sequence).add(j - i);
                }
            }
        }

        if (repeatedSequences.isEmpty()) {
            return -1;
        }

        List<Integer> factors = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : repeatedSequences.entrySet()) {
            for (int distance : entry.getValue()) {
                factors.addAll(findFactors(distance));
            }
        }

        if (factors.isEmpty()) {
            return -1;
        }
        Map<Integer, Integer> factorCounts = new HashMap<>();
        for (int factor : factors) {
            factorCounts.put(factor, factorCounts.getOrDefault(factor, 0) + 1);
        }

        if (factorCounts.isEmpty()) {
            return -1;
        }

        return Collections.max(factorCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private static String findKey(String text, int keyLength) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < keyLength; i++) {
            String subText = extractSubText(text, i, keyLength);
            char mostFrequentChar = findMostFrequentChar(subText);
            char keyChar = (char) ((mostFrequentChar - 'E' + 26) % 26 + 'A');
            key.append(keyChar);
        }
        return key.toString();
    }

    private static String extractSubText(String text, int start, int step) {
        StringBuilder subText = new StringBuilder();
        for (int i = start; i < text.length(); i += step) {
            subText.append(text.charAt(i));
        }
        return subText.toString();
    }

    private static char findMostFrequentChar(String text) {
        int[] frequencies = new int[26];
        for (char c : text.toCharArray()) {
            frequencies[c - 'A']++;
        }
        int maxFrequency = 0;
        char mostFrequentChar = 'A';
        for (int i = 0; i < 26; i++) {
            if (frequencies[i] > maxFrequency) {
                maxFrequency = frequencies[i];
                mostFrequentChar = (char) (i + 'A');
            }
        }
        return mostFrequentChar;
    }

    private static String decrypt(String text, String key) {
        StringBuilder plaintext = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char keyChar = key.charAt(i % keyLength);
            char decryptedChar = (char) ((c - keyChar + 26) % 26 + 'A');
            plaintext.append(decryptedChar);
        }
        return plaintext.toString();
    }
}