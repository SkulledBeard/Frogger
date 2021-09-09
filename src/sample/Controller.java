package sample;


import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public class Controller {

    // Dieses Objekt kommt aus der FXML-Datei
    // @FXML
    // private ImageView frog;
    private Avatar frog;
    @FXML
    private Pane game;

    private ImageView carR;
    private ImageView carL;

    private Path path = new Path();
    private PathTransition pathTransition = new PathTransition();
    private Path path2 = new Path();
    private PathTransition pathTransition2 = new PathTransition();

    @FXML
    private void initialize(){
        frog = new Avatar("image/frog_50_38_lila.png");
        carR = new ImageView("image/car_green_40_r.png");
        carL = new ImageView("image/car_red_40.png");

        game.getChildren().add(frog);
        game.getChildren().add(carR);
        game.getChildren().add(carL);

        carRTransition();
        carLTransition();

        System.out.println(frog.getX());
        System.out.println(frog.getY());



        frog.setFocusTraversable(true);
        if (carR.intersects(frog.getBoundsInParent()) || carL.intersects(frog.getBoundsInParent())) {
            collision();
        }

        // Eventhandler
        frog.addEventHandler(KeyEvent.KEY_PRESSED,keyEvent ->{
            switch(keyEvent.getCode()){
                case UP:
                   frog.moveUp();
                   if (frog.intersects(carR.getBoundsInParent()) || frog.intersects(carL.getBoundsInParent()) ) {
                       collision();
                   }
                    break;
                case DOWN:
                    frog.moveDown();
                    if (frog.intersects(carR.getBoundsInParent()) || frog.intersects(carL.getBoundsInParent()) ) {
                        collision();
                    }
                    break;
                case RIGHT:
                    frog.moveRight();
                    if (frog.intersects(carR.getBoundsInParent()) || frog.intersects(carL.getBoundsInParent()) ) {
                        collision();
                    }
                    break;
                case LEFT:
                    frog.moveLeft();
                    if (frog.intersects(carR.getBoundsInParent()) || frog.intersects(carL.getBoundsInParent()) ) {
                        collision();
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

    public void carRTransition() {

        MoveTo moveTo = new MoveTo(-50, 525);
        LineTo line1 = new LineTo(900, 525);
        path.getElements().add(moveTo);
        path.getElements().add(line1);
        pathTransition.setDuration(Duration.millis(1500));
        pathTransition.setNode(carR);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.setPath(path);
        pathTransition.play();
    }

    public void carLTransition() {

        MoveTo moveTo = new MoveTo(900, 640);
        LineTo line1 = new LineTo(-50, 640);
        path2.getElements().add(moveTo);
        path2.getElements().add(line1);
        pathTransition2.setDuration(Duration.millis(1500));
        pathTransition2.setNode(carL);
        pathTransition2.setCycleCount(PathTransition.INDEFINITE);
        pathTransition2.setAutoReverse(false);
        pathTransition2.setPath(path2);
        pathTransition2.play();
    }
}
