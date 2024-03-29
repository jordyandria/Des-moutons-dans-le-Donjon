import javax.swing.Timer;

public class Donjon {
    public static void main(String[] args) {
        int tempo = 50;
        Jeu jeu = new Jeu("laby2.txt");
        FenetreJeu graphic = new FenetreJeu(jeu.terrain);
        Timer timer = new Timer(tempo, e -> {
            jeu.tour();
            graphic.repaint();
            if (jeu.partieFinie()) { graphic.ecranFinal(Jeu.sortis); }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
