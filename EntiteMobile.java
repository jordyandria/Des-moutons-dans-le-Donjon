abstract class EntiteMobile extends Entite{

    public EntiteMobile(int resistance){
        super(resistance);
    }

    public EntiteMobile(Direction direction){
        this.direction = direction;
    }

    abstract void action(Case case1, Case case2);
}
