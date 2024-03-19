public class Joueur extends Entite{
    static int positionH;
    static int positionL;//positions du Joueur
    static boolean enJeu;//si le joueur est en jeu

    public Joueur(int resistance){
        super(resistance);
        Joueur.enJeu = true;
    }

    public String toString(String background) {
        return background.charAt(0) + "H" + background.charAt(2);
    }

    public void action(Case courante, Case cible){
        if(cible.estLibre()){
            ((CaseTraversable) cible).entre(((CaseTraversable) courante).getContenu());
            ((CaseTraversable) courante).vide();
            Joueur.positionH = cible.lig;
            Joueur.positionL = cible.col;
        }
    }
}
