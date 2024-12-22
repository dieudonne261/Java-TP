import java.awt.Color;
import java.awt.Label;
import java.awt.Frame;
import java.awt.Panel;

class PremierLabel {
    Frame f;
    Label l1, l2;
    Panel p;

    public void lunchFrame() {
        f = new Frame("Premier Label");
        l1 = new Label("C'est un label");
        l2 = new Label("Un autre label");
        p = new Panel();
        f.setSize(200, 200);
        p.add(l1);
        l1.setBackground(Color.blue);
        p.add(l2);
        l2.setBackground(Color.yellow);
        f.add(p);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        PremierLabel pr = new PremierLabel();
        pr.lunchFrame();
    }
}