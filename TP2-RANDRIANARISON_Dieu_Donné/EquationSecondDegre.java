import java.awt.*;
import java.awt.event.*;

public class EquationSecondDegre extends Frame implements ActionListener {
    Label equationLabel, labelA, labelB, labelC, labelResult;
    TextField textA, textB, textC;
    Button resoudreButton, supprimeButton;
    TextArea resultArea;

    public EquationSecondDegre() {
        setTitle("Résolution d'Équation du Second Degré");
        setSize(400, 250);
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
        labelResult = new Label("Résultats :");
        resultArea = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
        resultArea.setEditable(false);

        resultPanel.add(labelResult, BorderLayout.NORTH);
        resultPanel.add(resultArea, BorderLayout.CENTER);

        add(resultPanel, BorderLayout.SOUTH);

        resoudreButton.addActionListener(this);
        supprimeButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resoudreButton) {
            try {
                double a = Double.parseDouble(textA.getText());
                double b = Double.parseDouble(textB.getText());
                double c = Double.parseDouble(textC.getText());

                double discriminant = b * b - 4 * a * c;

                if (discriminant > 0) {
                    double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    resultArea.setText("Deux solutions :\n");
                    resultArea.append("x1 = " + x1 + "\n");
                    resultArea.append("x2 = " + x2);
                } else if (discriminant == 0) {
                    double x = -b / (2 * a);
                    resultArea.setText("Une solution unique :\n");
                    resultArea.append("x = " + x);
                } else {
                    resultArea.setText("Pas de solution réelle.\n");
                }
            } catch (NumberFormatException ex) {
                resultArea.setText("Veuillez entrer des coefficients valides.");
            }
        } else if (e.getSource() == supprimeButton) {
            textA.setText("");
            textB.setText("");
            textC.setText("");
            resultArea.setText("");
        }
    }

    public static void main(String[] args) {
        new EquationSecondDegre();
    }
}