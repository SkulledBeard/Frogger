package sample;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Controller {

    // Dieses Objekt kommt aus der FXML-Datei
    // @FXML
    // private ImageView frog;
    private Avatar frog;
    @FXML
    private Pane game;

    private ImageView carR;

    @FXML
    private void initialize(){
        frog = new Avatar("image/frog_50_38_lila.png");
        carR = new ImageView("image/car_green_40_r.png");

        game.getChildren().add(frog);
        game.getChildren().add(carR);
        carR.setX(450);
        carR.setY(500);


        System.out.println(frog.getX());
        System.out.println(frog.getY());

        frog.setFocusTraversable(true);
        // Eventhandler
        frog.addEventHandler(KeyEvent.KEY_PRESSED,keyEvent ->{
            switch(keyEvent.getCode()){
                case UP:

                   frog.moveUp();
                   if (frog.intersects(carR.getBoundsInLocal())) {
                    System.out.println("GAME OVER");
                   }
                    break;
                case DOWN:
                    frog.moveDown();
                    if (frog.intersects(carR.getBoundsInLocal())) {
                        System.out.println("GAME OVER");
                    }
                    break;
                case RIGHT:
                    frog.moveRight();
                    if (frog.intersects(carR.getBoundsInLocal())) {
                        System.out.println("GAME OVER");
                    }
                    break;
                case LEFT:
                    frog.moveLeft();
                    if (frog.intersects(carR.getBoundsInLocal())) {
                        System.out.println("GAME OVER");
                    }
                    break;
                default:
                    System.out.println("Falsche Eingabe");
            }
        } );
    }

    public boolean collision() {

        System.out.println("getroffen");
        return false;
    }

}
