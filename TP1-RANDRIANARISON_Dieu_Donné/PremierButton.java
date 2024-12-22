import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

class PremierButton {
    Frame f;
    Panel p;
    Button b1, b2;

    public void lunchFrame() {
        f = new Frame("Premier Button");
        b1 = new Button("Button 1");
        b2 = new Button("Button 2");
        p = new Panel();
        f.setSize(200, 200);
        p.add(b1);
        b1.setBackground(Color.gray);
        p.add(b2);
        b2.setBackground(Color.cyan);
        f.add(p);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        PremierButton pr = new PremierButton();
        pr.lunchFrame();
    }
}