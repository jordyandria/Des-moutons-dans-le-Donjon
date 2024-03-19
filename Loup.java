public class Loup extends EntiteMobile{

    public Loup(Direction direction){
        super(direction);
    }

    public String toString(String background) {
        switch (this.direction){
            case nord : return background.charAt(0) + "m" + background.charAt(2);
            case sud : return background.charAt(0) + "w" + background.charAt(2);
            case est : return background.charAt(0) + "=" + background.charAt(2);
            case ouest : return background.charAt(0) + "c" + background.charAt(2);
        }
        return null;
    }

    public void action(Case courante, Case cible){
        if(!(cible instanceof CaseIntraversable)){
            if((((CaseTraversable) cible).getContenu() instanceof Obstacle) || (((CaseTraversable) cible).getContenu() instanceof Mouton) || 
                (((CaseTraversable) cible).getContenu() instanceof Joueur)){
                ((CaseTraversable) cible).decremente();
            }
            if(cible.estLibre()){
                ((CaseTraversable) cible).entre(((CaseTraversable) courante).getContenu());
                ((CaseTraversable) courante).vide();
            }
            if(((CaseTraversable) cible).getContenu() instanceof Loup){
                this.direction = Direction.random();
            }
        }
        else{
            this.direction = Direction.random();
        }
    }
}