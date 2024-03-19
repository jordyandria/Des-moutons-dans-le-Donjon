public class Sortie extends CaseTraversable{
    public Sortie(int lig, int col, Entite contenu){
        super(lig, col, contenu);
    }

    public Sortie(int lig, int col){
        super(lig, col, null);
    }

    public String toString(){
        if(this.getContenu() != null){
            return this.getContenu().toString("( )");
        }
        return "( )";
    }
}
