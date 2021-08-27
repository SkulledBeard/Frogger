package sample;

import javafx.scene.image.ImageView;

public class Avatar extends ImageView {

    private double startx = 385;
    private double starty = 725;

    Avatar(String url){
        super(url);
        super.setX(startx);
        super.setY(starty);
    }

    public double getStartx() {
        return startx;
    }

    public double getStarty() {
        return starty;
    }

    public void moveUp(){
        if(this.getY() > 10){
            this.setY(this.getY()-50);}
        System.out.println("Nach Oben");
    }
    public void moveDown(){
        if(this.getY() < 700){
        this.setY(this.getY()+50);}
        System.out.println("Nach Unten");
    }
    public void moveLeft(){
        if(this.getX() > 50){
        this.setX(this.getX()-50);}
        System.out.println("Nach Links");
    }
    public void moveRight(){
        if(this.getX() < 700){
        this.setX(this.getX()+50);}
        System.out.println("Nach Rechts");
    }
}
