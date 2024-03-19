public class CaseTraversable extends Case{

    public CaseTraversable(int lig, int col, Entite contenu){
        super(lig, col);
        this.contenu = contenu;
    }

    public void vide(){
        this.contenu = null;
    }

    public void entre(Entite e){
        this.contenu = e;
    }

    public boolean estLibre(){
        return (this.contenu == null);
    }

    public void decremente(){
        this.contenu.resistance--;
        if(this.getContenu().resistance == 0){
            this.vide();
        }
    }
}
