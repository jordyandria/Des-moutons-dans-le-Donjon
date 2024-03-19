import java.util.Random;
public class Jeu {

    Terrain terrain;
    protected static int sortis;

    /* Initialisation d'un jeu avec le terrain initial décrit dans
       le fichier [f] donné en paramètre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        Jeu.sortis = 0;
    }

    public void tour(){
        Random rnd = new Random();
        int x = rnd.nextInt(this.terrain.getHauteur());
        int y = rnd.nextInt(this.terrain.getLargeur());
        while(!(((Case) this.terrain.carte[x][y]).getContenu() instanceof EntiteMobile)){
            x = rnd.nextInt(this.terrain.getHauteur());
            y = rnd.nextInt(this.terrain.getLargeur());
        }
        switch(((CaseTraversable) this.terrain.carte[x][y]).getContenu().direction){
            case nord : ((EntiteMobile) this.terrain.carte[x][y].contenu).action(this.terrain.carte[x][y], this.terrain.carte[x - 1][y]); break;
            case est: ((EntiteMobile) this.terrain.carte[x][y].contenu).action(this.terrain.carte[x][y], this.terrain.carte[x][y + 1]); break;
            case ouest: ((EntiteMobile) this.terrain.carte[x][y].contenu).action(this.terrain.carte[x][y], this.terrain.carte[x][y - 1]); break;
            case sud: ((EntiteMobile) this.terrain.carte[x][y].contenu).action(this.terrain.carte[x][y], this.terrain.carte[x + 1][y]); break;
        }
    }

    public boolean partieFinie(){
        if(!Joueur.enJeu){
            return true;
        }
        if((Entite) this.terrain.carte[Joueur.positionH][Joueur.positionL].getContenu() == null){
            return true;
        }
        return false;
    }

    
}
