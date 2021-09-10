package sample;


import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Timer;


public class Controller {
    private int leben = 5;

    // Dieses Objekt kommt aus der FXML-Datei
    // @FXML
    // private ImageView frog;
    private Avatar frog;
    @FXML
    private Pane game;

    private Timer timer;

    private ImageView carR, carR2;
    private ImageView carL, carL2;
    private ImageView log1, log2, log3, log4, log5;

    private ImageView heart1, heart2, heart3, heart4, heart5;

    // car transition
    private Path path = new Path();
    private PathTransition pathTransition = new PathTransition();
    private Path path2 = new Path();
    private PathTransition pathTransition2 = new PathTransition();
    private Path path3 = new Path();
    private PathTransition pathTransition3 = new PathTransition();
    private Path path4 = new Path();
    private PathTransition pathTransition4 = new PathTransition();

    // log transition
    private Path logPath1 = new Path();
    private PathTransition logPathTransition1 = new PathTransition();
    private Path logPath2 = new Path();
    private PathTransition logPathTransition2 = new PathTransition();
    private Path logPath3 = new Path();
    private PathTransition logPathTransition3 = new PathTransition();
    private Path logPath4 = new Path();
    private PathTransition logPathTransition4 = new PathTransition();
    private Path logPath5 = new Path();
    private PathTransition logPathTransition5 = new PathTransition();


    // Wasserrechteck erstellen
    private Rectangle rectangle = new Rectangle();

    @FXML
    private void initialize(){

        frog = new Avatar("image/frog_50_38_lila.png");
        carR = new ImageView("image/car_green_40_r.png");
        carL = new ImageView("image/car_red_40.png");
        carR2 = new ImageView("image/car_green_40_r.png");
        carL2 = new ImageView("image/car_red_40.png");
        log1 = new ImageView("image/woodlog.png");
        log2 = new ImageView("image/woodlog.png");
        log3 = new ImageView("image/woodlog.png");
        log4 = new ImageView("image/woodlog.png");
        log5 = new ImageView("image/woodlog.png");
        heart1 = new ImageView("image/heart.png");
        heart2 = new ImageView("image/heart.png");
        heart3 = new ImageView("image/heart.png");
        heart4 = new ImageView("image/heart.png");
        heart5 = new ImageView("image/heart.png");

        game.getChildren().add(rectangle);
        game.getChildren().add(log1);
        game.getChildren().add(log2);
        game.getChildren().add(log3);
        game.getChildren().add(log4);
        game.getChildren().add(log5);
        game.getChildren().add(frog);
        game.getChildren().add(carR);
        game.getChildren().add(carL);
        game.getChildren().add(carR2);
        game.getChildren().add(carL2);
        game.getChildren().add(heart1);
        game.getChildren().add(heart2);
        game.getChildren().add(heart3);
        game.getChildren().add(heart4);
        game.getChildren().add(heart5);

        //Wasserrechteck platzieren
        rectangle.setX(-10);
        rectangle.setY(120);
        rectangle.setWidth(900);
        rectangle.setHeight(260);
        //rectangle.setStroke(Color.BLACK);

        heart1.setX(10);
        heart2.setX(70);
        heart3.setX(130);
        heart4.setX(190);
        heart5.setX(250);

        carRTransition();
        carLTransition();
        carR2Transition();
        carL2Transition();

        log1Transition();
        log2Transition();
        log3Transition();
        log4Transition();
        log5Transition();

        System.out.println(frog.getX());
        System.out.println(frog.getY());



        frog.setFocusTraversable(true);

        carL.translateXProperty().addListener(checkIntersection2);
        carL.translateYProperty().addListener(checkIntersection2);

        carR.translateXProperty().addListener(checkIntersection);
        carR.translateYProperty().addListener(checkIntersection);


        frog.translateYProperty().addListener(checkIntersection3);
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

    public void collision() {

        System.out.println("getroffen");
    }

    public void carRTransition() {

        MoveTo moveTo = new MoveTo(-50, 680);
        LineTo line1 = new LineTo(900, 680);
        path.getElements().add(moveTo);
        path.getElements().add(line1);
        pathTransition.setDuration(Duration.millis(1235));
        pathTransition.setNode(carR);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.setPath(path);
        pathTransition.play();

    }
    public void carR2Transition() {

        MoveTo moveTo = new MoveTo(-50, 525);
        LineTo line1 = new LineTo(900, 525);
        path3.getElements().add(moveTo);
        path3.getElements().add(line1);
        pathTransition3.setDuration(Duration.millis(1500));
        pathTransition3.setNode(carR2);
        pathTransition3.setCycleCount(PathTransition.INDEFINITE);
        pathTransition3.setAutoReverse(false);
        pathTransition3.setPath(path3);
        pathTransition3.play();

    }
    public void carLTransition() {

        MoveTo moveTo = new MoveTo(900, 640);
        LineTo line1 = new LineTo(-50, 640);
        path2.getElements().add(moveTo);
        path2.getElements().add(line1);
        pathTransition2.setDuration(Duration.millis(2132));
        pathTransition2.setNode(carL);
        pathTransition2.setCycleCount(PathTransition.INDEFINITE);
        pathTransition2.setAutoReverse(false);
        pathTransition2.setPath(path2);
        pathTransition2.play();

    }
    public void carL2Transition() {

        MoveTo moveTo = new MoveTo(900, 475);
        LineTo line1 = new LineTo(-50, 475);
        path4.getElements().add(moveTo);
        path4.getElements().add(line1);
        pathTransition4.setDuration(Duration.millis(1500));
        pathTransition4.setNode(carL2);
        pathTransition4.setCycleCount(PathTransition.INDEFINITE);
        pathTransition4.setAutoReverse(false);
        pathTransition4.setPath(path4);
        pathTransition4.play();

    }

    public void log1Transition() {

        MoveTo moveTo = new MoveTo(900, 360);
        LineTo line1 = new LineTo(-50, 360);
        logPath1.getElements().add(moveTo);
        logPath1.getElements().add(line1);
        logPathTransition1.setDuration(Duration.millis(3000));
        logPathTransition1.setNode(log1);
        logPathTransition1.setCycleCount(PathTransition.INDEFINITE);
        logPathTransition1.setAutoReverse(false);
        logPathTransition1.setPath(logPath1);
        logPathTransition1.play();

    }
    public void log2Transition() {

        MoveTo moveTo = new MoveTo(-50, 305);
        LineTo line1 = new LineTo(900, 305);
        logPath2.getElements().add(moveTo);
        logPath2.getElements().add(line1);
        logPathTransition2.setDuration(Duration.millis(3200));
        logPathTransition2.setNode(log2);
        logPathTransition2.setCycleCount(PathTransition.INDEFINITE);
        logPathTransition2.setAutoReverse(false);
        logPathTransition2.setPath(logPath2);
        logPathTransition2.play();

    }
    public void log3Transition() {

        MoveTo moveTo = new MoveTo(900, 250);
        LineTo line1 = new LineTo(-50, 250);
        logPath3.getElements().add(moveTo);
        logPath3.getElements().add(line1);
        logPathTransition3.setDuration(Duration.millis(2800));
        logPathTransition3.setNode(log3);
        logPathTransition3.setCycleCount(PathTransition.INDEFINITE);
        logPathTransition3.setAutoReverse(false);
        logPathTransition3.setPath(logPath3);
        logPathTransition3.play();

    }
    public void log4Transition() {

        MoveTo moveTo = new MoveTo(-50, 195);
        LineTo line1 = new LineTo(900, 195);
        logPath4.getElements().add(moveTo);
        logPath4.getElements().add(line1);
        logPathTransition4.setDuration(Duration.millis(3500));
        logPathTransition4.setNode(log4);
        logPathTransition4.setCycleCount(PathTransition.INDEFINITE);
        logPathTransition4.setAutoReverse(false);
        logPathTransition4.setPath(logPath4);
        logPathTransition4.play();

    }
    public void log5Transition() {

        MoveTo moveTo = new MoveTo(900, 140);
        LineTo line1 = new LineTo(-50, 140);
        logPath5.getElements().add(moveTo);
        logPath5.getElements().add(line1);
        logPathTransition5.setDuration(Duration.millis(2900));
        logPathTransition5.setNode(log5);
        logPathTransition5.setCycleCount(PathTransition.INDEFINITE);
        logPathTransition5.setAutoReverse(false);
        logPathTransition5.setPath(logPath5);
        logPathTransition5.play();

    }

    // Prüft ob Autos mit Frosch kollidieren
    private final ChangeListener<Number> checkIntersection = (ob,n,n1)->{
        if (carR.getBoundsInParent().intersects(frog.getBoundsInParent())){
            endgame();
        }
    };

    private final ChangeListener<Number> checkIntersection2 = (ob,n,n1)->{
        if (carL.getBoundsInParent().intersects(frog.getBoundsInParent())){
            endgame();

        }
    };

    private final ChangeListener<Number> checkIntersection3 = (ob,n,n1)->{
        if (frog.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
            endgame();

        }
    };

    private void endgame() {
        System.out.println("Ein Leben Verloren");
        frog.setX(385);
        frog.setY(725);
        leben -= 1;            if (leben == 4) {game.getChildren().remove(heart5);}
        if (leben == 3) {game.getChildren().remove(heart4);}
        if (leben == 2) {game.getChildren().remove(heart3);}
        if (leben == 1) {game.getChildren().remove(heart2);}
        if (leben == 0) {
            game.getChildren().remove(heart1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Game Over!");
            alert.setContentText("You have 0 hearts left");
            pathTransition.stop();
            pathTransition2.stop();
            alert.setOnHidden(evt -> Platform.exit());

            alert.show();
        }
    }
}

