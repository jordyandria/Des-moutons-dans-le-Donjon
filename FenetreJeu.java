import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FenetreJeu extends JPanel implements KeyListener{
    private Terrain terrain;
    private int tailleCase = 24;
    private int hauteur, largeur;
    private JFrame frame;

    public FenetreJeu(Terrain t) {
        this.hauteur = t.getHauteur();
        this.largeur = t.getLargeur();
        this.terrain = t;

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        JFrame frame = new JFrame("Donjon");
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.addKeyListener(this);
        frame.setVisible(true);
    }

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                ((Joueur) this.terrain.carte[Joueur.positionH][Joueur.positionL].contenu).
                action(this.terrain.carte[Joueur.positionH][Joueur.positionL], this.terrain.carte[Joueur.positionH + 1][Joueur.positionL]);
                break;
            case KeyEvent.VK_DOWN : 
                ((Joueur) this.terrain.carte[Joueur.positionH][Joueur.positionL].contenu).
                action(this.terrain.carte[Joueur.positionH][Joueur.positionL], this.terrain.carte[Joueur.positionH - 1][Joueur.positionL]);
                break;
            case KeyEvent.VK_LEFT :
                ((Joueur) this.terrain.carte[Joueur.positionH][Joueur.positionL].contenu).
                action(this.terrain.carte[Joueur.positionH][Joueur.positionL], this.terrain.carte[Joueur.positionH][Joueur.positionL - 1]);
                break;
            case KeyEvent.VK_RIGHT :
                ((Joueur) this.terrain.carte[Joueur.positionH][Joueur.positionL].contenu).
                action(this.terrain.carte[Joueur.positionH][Joueur.positionL], this.terrain.carte[Joueur.positionH][Joueur.positionL + 1]);
                break;
            case KeyEvent.VK_SPACE :
                if((CaseTraversable) this.terrain.carte[Joueur.positionH][Joueur.positionL] instanceof Sortie){
                    ((CaseTraversable) this.terrain.carte[Joueur.positionH][Joueur.positionL]).vide();
                    Joueur.enJeu = false;
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* À compléter */
        
        for(int i = 0; i<hauteur; i++){
            for(int j = 0; j<largeur; j++){
                Case c = terrain.carte[i][j];
                if(c instanceof CaseIntraversable){ g.setColor(Color.black); }
                else if(c instanceof Sortie){ g.setColor(Color.yellow); }
                else if(c instanceof CaseLibre && ((CaseTraversable)c).getContenu() instanceof Mouton){g.setColor(Color.white);}
                else if(c instanceof CaseLibre && ((CaseTraversable)c).getContenu() instanceof Loup){g.setColor(Color.gray);}
                else if(c instanceof CaseLibre && ((CaseTraversable)c).getContenu() instanceof Joueur){g.setColor(Color.pink);}
                else if(c instanceof CaseLibre && ((CaseTraversable)c).getContenu() == null){g.setColor(Color.green);}
                else if(c instanceof CaseLibre && ((CaseTraversable)c).getContenu() instanceof Obstacle){g.setColor(Color.black);}
                g.fillRect(tailleCase*j, tailleCase*i,tailleCase*(j+1),tailleCase*(i+1));
            }
        }
    }

    public void ecranFinal(int n) {
        frame.remove(this);
        JLabel label = new JLabel("Score " + n);
        label.setFont(new Font("Verdana", 1, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setSize(this.getSize());
        frame.getContentPane().add(label);
        frame.repaint();
    }
}
