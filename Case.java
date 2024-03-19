abstract class Case {
    protected final int lig, col;
    protected Entite contenu;

    public Case(int lig, int col){
        this.lig = lig;
        this.col = col;
    }

    public abstract boolean estLibre();

    public Entite getContenu(){
        return this.contenu;
    }
}
