public class Mouton extends EntiteMobile{

    public Mouton(int resistance){
        super(resistance);
    }

    public Mouton(Direction direction){
        super(direction);
        this.resistance = 5;
    }
    
    public String toString(String background){
        switch (this.direction){
            case nord : return background.charAt(0) + "^" + background.charAt(2);
            case sud : return background.charAt(0) + "v" + background.charAt(2);
            case est : return background.charAt(0) + ">" + background.charAt(2);
            case ouest : return background.charAt(0) + "<" + background.charAt(2);
        }
        return null;
    }

    public void action(Case courante, Case cible){
        if(!(cible instanceof CaseIntraversable)){
            if(((CaseTraversable) courante) instanceof Sortie){//si le perso est sur une sortie
                ((CaseTraversable) courante).vide();
                Jeu.sortis++;
            }
            if(cible.estLibre()){
                ((CaseTraversable) cible).entre(((CaseTraversable) courante).getContenu());
                ((CaseTraversable) courante).vide();
            }
            if((((CaseTraversable) cible).getContenu() instanceof Obstacle)){
                ((CaseTraversable) cible).decremente();
            }
            if((((CaseTraversable) cible).getContenu() instanceof Joueur)) {
                this.direction = Direction.random();
            }
        }
        else{
            this.direction = Direction.random();
        }
    }
}
