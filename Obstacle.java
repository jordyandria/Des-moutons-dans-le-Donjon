public class Obstacle extends Entite{
    public Obstacle(int resistance){
        super(resistance);
    }

    public Obstacle(){
        super(3);
    }

    public String toString(String background){
        if(this.resistance >= 3){
            return "@@@";
        }
        if(this.resistance == 1){
            return background.charAt(0) + "@" + background.charAt(2);
        }
        if(this.resistance == 2){
            return "@" + "@" + background.charAt(2);
        }
        else{
            return null;
        }
    }
    
}
