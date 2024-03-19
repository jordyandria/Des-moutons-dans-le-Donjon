import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Terrain {

    protected int hauteur, largeur;
    protected Case[][] carte;

    /* Initialisation d'un terrain à partir de la description donnée par
       un fichier texte. Format du fichier de description :
       - hauteur et largeur sur la première ligne
       - puis dessin du terrain (un caractère == une case) avec le codage
         suivant
         '#' pour un mur
         ' ' (espace) pour une case libre
         'o' pour une sortie
         '@' pour une case libre contenant un obstacle
         '^', 'v', '>', '<' pour une case libre contenant un personnage
         'm', 'w', '»', '«' pour une case libre contenant un monstre
    */
    public Terrain(String file) {
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            this.hauteur = sc.nextInt();
            this.largeur = sc.nextInt();
            int resistanceJoueur = sc.nextInt();
            sc.nextLine();
            this.carte = new Case[hauteur][largeur];
            for (int l=0; l<hauteur; l++) {
                String line = sc.nextLine();
                for (int c=0; c<largeur; c++) {
                    Case cc;
                    Character ch = line.charAt(c);
                    switch (ch) {
                        case '#': cc = new CaseIntraversable(l, c); break;
                        case ' ': cc = new CaseLibre(l, c); break;
                        case 'o': cc = new Sortie(l, c); break;
                        case '@': cc = new CaseLibre(l, c, new Obstacle()); break;
                        case '^': case '>': case 'v': case '<':
                            cc = new CaseLibre(l, c, new Mouton(Direction.ofChar(ch)));
                            break;
                        case 'm': case 'c': case 'w': case '=':
                            cc = new CaseLibre(l, c, new Loup(Direction.ofChar(ch)));
                            break;
                        case 'H': 
                            cc = new CaseLibre(l, c, new Joueur(resistanceJoueur));
                            Joueur.positionH = l;
                            Joueur.positionL = c;
                            break;
                        default:  cc = null; break;
                    }
                    carte[l][c] = cc;
                }
            }
            sc.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public int getHauteur(){
        return this.hauteur;
    }

    public int getLargeur(){
        return this.largeur;
    }

    public String print(){
        String s = "";
        for(int i = 0; i < this.hauteur; i++){
            for(int j = 0; j < this.largeur; j++){
                s += carte[i][j].toString();
            }
            s += ("\n");
        }
        return s;
    }

}
