abstract class Entite {
    protected int resistance;
    protected Direction direction;

    public Entite(int resistance){
        this.resistance = resistance;
    }

    public Entite(){
    }

    public abstract String toString(String background);

}
