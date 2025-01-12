import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EquationSecondDegre extends Frame implements ActionListener {
    Label equationLabel, labelA, labelB, labelC, labelResult;
    TextField textA, textB, textC;
    Button resoudreButton, supprimeButton;
    java.awt.List resultList;
    String historiqueFile = "historique.txt";

    public EquationSecondDegre() {
        setTitle("Résolution d'Équation du Second Degré");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setVisible(true);

        equationLabel = new Label("Equation : ax² + bx + c", Label.CENTER);
        equationLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(equationLabel, BorderLayout.NORTH);

        Panel inputPanel = new Panel();
        inputPanel.setLayout(new GridLayout(2, 1));
        Panel coefficientsPanel = new Panel(new FlowLayout());

        labelA = new Label("a :");
        textA = new TextField(5);

        labelB = new Label("b :");
        textB = new TextField(5);

        labelC = new Label("c :");
        textC = new TextField(5);

        coefficientsPanel.add(labelA);
        coefficientsPanel.add(textA);
        coefficientsPanel.add(labelB);
        coefficientsPanel.add(textB);
        coefficientsPanel.add(labelC);
        coefficientsPanel.add(textC);

        inputPanel.add(coefficientsPanel);

        Panel buttonPanel = new Panel(new FlowLayout());
        resoudreButton = new Button("Résoudre");
        supprimeButton = new Button("Effacer");
        buttonPanel.add(resoudreButton);
        buttonPanel.add(supprimeButton);

        inputPanel.add(buttonPanel);
        add(inputPanel, BorderLayout.CENTER);

        Panel resultPanel = new Panel(new BorderLayout());
        labelResult = new Label("Historique :");
        resultList = new java.awt.List(6, false);

        resultPanel.add(labelResult, BorderLayout.NORTH);
        resultPanel.add(resultList, BorderLayout.CENTER);

        add(resultPanel, BorderLayout.SOUTH);

        resoudreButton.addActionListener(this);
        supprimeButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        loadHistorique();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resoudreButton) {
            try {
                double a = Double.parseDouble(textA.getText());
                double b = Double.parseDouble(textB.getText());
                double c = Double.parseDouble(textC.getText());

                double discriminant = b * b - 4 * a * c;
                String equation = a + "x² + " + b + "x + " + c;

                if (discriminant > 0) {
                    double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    String result = "Equation : " + equation + ", x1 : " + x1 + " ,x2 : " + x2;
                    resultList.add(result);
                    saveToHistorique(result);
                } else if (discriminant == 0) {
                    double x = -b / (2 * a);
                    String result = "Equation : " + equation + ", x : " + x;
                    resultList.add(result);
                    saveToHistorique(result);
                } else {
                    String result = "Equation : " + equation + ", Pas de solution réelle.";
                    resultList.add(result);
                    saveToHistorique(result);
                }
            } catch (NumberFormatException ex) {
                resultList.add("Veuillez entrer des coefficients valides.");
            }
        } else if (e.getSource() == supprimeButton) {
            textA.setText("");
            textB.setText("");
            textC.setText("");
            resultList.removeAll();
            clearHistorique();
        }
    }

    private void saveToHistorique(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(historiqueFile, true))) {
            writer.write(result);
            writer.newLine();
        } catch (IOException e) {
            resultList.add("Erreur : Impossible d'enregistrer l'équation.");
        }
    }

    private void loadHistorique() {
        try (BufferedReader reader = new BufferedReader(new FileReader(historiqueFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }
        } catch (IOException e) {
            resultList.add("Erreur : Impossible de charger l'historique.");
        }
    }

    private void clearHistorique() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(historiqueFile))) {
        } catch (IOException e) {
            resultList.add("Erreur : Impossible de supprimer l'historique.");
        }
    }

    public static void main(String[] args) {
        new EquationSecondDegre();
    }
}