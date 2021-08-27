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

    @FXML
    private void initialize(){
        frog = new Avatar("image/frog_50_38_lila.png");
        game.getChildren().add(frog);
        System.out.println(frog.getX());
        System.out.println(frog.getY());

        frog.setFocusTraversable(true);
        // Eventhandler
        frog.addEventHandler(KeyEvent.KEY_PRESSED,keyEvent ->{
            switch(keyEvent.getCode()){
                case UP:
                   frog.moveUp();
                    break;
                case DOWN:
                    frog.moveDown();
                    break;
                case RIGHT:
                    frog.moveRight();
                    break;
                case LEFT:
                    frog.moveLeft();
                    break;
                default:
                    System.out.println("Falsche Eingabe");
            }
        } );
    }


}
