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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Controller {
    private int leben = 5;

    // Dieses Objekt kommt aus der FXML-Datei
    // @FXML
    // private ImageView frog;
    private Avatar frog;
    @FXML
    private Pane game;

    private int punkte = 999999;
    @FXML
    private Text text = new Text("999999");

    private ImageView carR, carR2, carR3;
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
    private Path path5 = new Path();
    private PathTransition pathTransition5 = new PathTransition();

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
    private void initialize() {

        frog = new Avatar("image/frog_50_38_lila.png");
        carR = new ImageView("image/car_green_40_r.png");
        carL = new ImageView("image/car_red_40.png");
        carR2 = new ImageView("image/car_green_40_r.png");
        carL2 = new ImageView("image/car_red_40.png");
        carR3 = new ImageView("image/car_green_40_r.png");
        log1 = new ImageView("image/woodlog.png");
        log2 = new ImageView("image/woodlog2.png");
        log3 = new ImageView("image/woodlog.png");
        log4 = new ImageView("image/woodlog2.png");
        log5 = new ImageView("image/woodlog.png");
        heart1 = new ImageView("image/heart.png");
        heart2 = new ImageView("image/heart.png");
        heart3 = new ImageView("image/heart.png");
        heart4 = new ImageView("image/heart.png");
        heart5 = new ImageView("image/heart.png");

        game.getChildren().add(text);
        text.setFont(Font.loadFont("file:C:/Users/Administrator/IdeaProjects/JavaFX/src/font/pixelFont.TTF", 35));
        text.setFill(Color.WHITE);
        text.setX(570);
        text.setY(42);

        game.getChildren().add(heart1);
        game.getChildren().add(heart2);
        game.getChildren().add(heart3);
        game.getChildren().add(heart4);
        game.getChildren().add(heart5);
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
        game.getChildren().add(carR3);

        //Wasserrechteck platzieren
        rectangle.setX(-10);
        rectangle.setY(120);
        rectangle.setWidth(900);
        rectangle.setHeight(260);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.rgb(0, 0, 0, 0));
        rectangle.setStrokeWidth(0);

        heart1.setX(10);
        heart2.setX(70);
        heart3.setX(130);
        heart4.setX(190);
        heart5.setX(250);

        objectTransition(-50,690,900,690,path,pathTransition,1235,carR);
        objectTransition(-50,575,900,575,path3,pathTransition3,1500,carR2);
        objectTransition(-50,460,900,460,path5,pathTransition5,1100,carR3);
        objectTransition(900,625,-50,625,path2,pathTransition2,2132,carL);
        objectTransition(900,515,-50,515,path4,pathTransition4,1500,carL2);

        objectTransition(900,360,-50,360,logPath1,logPathTransition1,3100,log1);
        objectTransition(-300,305,1050,305,logPath2,logPathTransition2,3500,log2);
        objectTransition(900,250,-50,250,logPath3,logPathTransition3,3900, log3);
        objectTransition(-300,195,1050,195,logPath4,logPathTransition4,4800,log4);
        objectTransition(900,140,-50,140,logPath5,logPathTransition5,2700,log5);

        System.out.println(frog.getX());
        System.out.println(frog.getY());


        frog.setFocusTraversable(true);

        carL.translateXProperty().addListener(checkIntersection2);
        carL.translateYProperty().addListener(checkIntersection2);

        carR.translateXProperty().addListener(checkIntersection);
        carR.translateYProperty().addListener(checkIntersection);

        carR2.translateYProperty().addListener(checkIntersection3);
        carR2.translateXProperty().addListener(checkIntersection3);

        carR3.translateYProperty().addListener(checkIntersection5);
        carR3.translateXProperty().addListener(checkIntersection5);

        carL2.translateYProperty().addListener(checkIntersection4);
        carL2.translateXProperty().addListener(checkIntersection4);

        log1.translateYProperty().addListener(checkIntersectionBaum);
        log1.translateXProperty().addListener(checkIntersectionBaum);
        log2.translateYProperty().addListener(checkIntersectionBaum2);
        log2.translateXProperty().addListener(checkIntersectionBaum2);
        log3.translateYProperty().addListener(checkIntersectionBaum3);
        log3.translateXProperty().addListener(checkIntersectionBaum3);
        log4.translateYProperty().addListener(checkIntersectionBaum4);
        log4.translateXProperty().addListener(checkIntersectionBaum4);
        log5.translateYProperty().addListener(checkIntersectionBaum5);
        log5.translateXProperty().addListener(checkIntersectionBaum5);

//        frog.translateYProperty().addListener(checkIntersectionRect);
//        frog.translateXProperty().addListener(checkIntersectionRect);


        // Eventhandler
        frog.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    frog.moveUp();
                    punkteTimer();
                    abfrageBaumUndWasser();
                    break;
                case DOWN:
                    frog.moveDown();
                    punkteTimer();
                    abfrageBaumUndWasser();
                    break;
                case RIGHT:
                    frog.moveRight();
                    punkteTimer();
                    abfrageBaumUndWasser();
                    break;
                case LEFT:
                    frog.moveLeft();
                    punkteTimer();
//                    if (frog.intersects(rectangle.getBoundsInParent()) ) {
//                        endgame();
//                    }
                    abfrageBaumUndWasser();
                    break;
                default:
                    System.out.println("Falsche Eingabe");
            }
        });

    }

    private void abfrageBaumUndWasser() {
        if ((!frog.intersects(log5.getBoundsInParent()) || !frog.intersects(log4.getBoundsInParent()) || !frog.intersects(log3.getBoundsInParent()) ||
                !frog.intersects(log1.getBoundsInParent()) || !frog.intersects(log2.getBoundsInParent())) && frog.intersects(rectangle.getBoundsInParent())) {
            System.out.println("##########################################");
            // endgame();
        }
    }

    private void punkteTimer() {

        punkte -= 321;
        text.setText(String.valueOf(punkte));
//        while (punkte != 0){
//            punkte -= 1;
//            text.setText(String.valueOf(punkte));
//        }
    }

//    public void collision() {
//
//        System.out.println("WASSER ----------------- getroffen");
//    }

    public void objectTransition(int moveToX, int moveToY, int lineToX, int lineToY, Path path, PathTransition pathTransition, int millis, ImageView imageView){
        MoveTo moveTo = new MoveTo(moveToX, moveToY);
        LineTo line1 = new LineTo(lineToX, lineToY);
        path.getElements().add(moveTo);
        path.getElements().add(line1);
        pathTransition.setDuration(Duration.millis(millis));
        pathTransition.setNode(imageView);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.setPath(path);
        pathTransition.play();
    }

    // Prüft ob Frosch mit Stamm kollidiert und bewegt Frosch mit
    private final ChangeListener<Number> checkIntersectionBaum = (ob, n, n1) -> {
        if (log1.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            System.out.println("BAUM1 TRIFFT");
            if (frog.getX() > 50) {
                frog.setX(frog.getX() - 6.4);
            }
            System.out.println("Nach Links durch BAUM -> y = " + frog.getY());
        }
    };
    private final ChangeListener<Number> checkIntersectionBaum2 = (ob, n, n1) -> {
        if (log2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            System.out.println("BAUM2 TRIFFT");
            if (frog.getX() < 700) {
                frog.setX(frog.getX() + 7.8);
            }
            System.out.println("Nach Rechts durch BAUM -> y = " + frog.getY());
        }
    };
    private final ChangeListener<Number> checkIntersectionBaum3 = (ob, n, n1) -> {
        if (log3.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            System.out.println("BAUM3 TRIFFT");
            if (frog.getX() > 50) {
                frog.setX(frog.getX() - 5);
            }
            System.out.println("Nach Links durch BAUM -> y = " + frog.getY());
        }
    };
    private final ChangeListener<Number> checkIntersectionBaum4 = (ob, n, n1) -> {
        if (log4.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            System.out.println("BAUM4 TRIFFT");
            if (frog.getX() < 700) {
                frog.setX(frog.getX() + 6);
            }
            System.out.println("Nach Rechts durch BAUM -> y = " + frog.getY());
        }
    };
    private final ChangeListener<Number> checkIntersectionBaum5 = (ob, n, n1) -> {
        if (log5.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            System.out.println("BAUM5 TRIFFT");
            if (frog.getX() > 50) {
                frog.setX(frog.getX() - 7.4);
            }
            System.out.println("Nach Links durch BAUM -> y = " + frog.getY());
        }
    };
    // Prüft ob Autos mit Frosch kollidieren
    private final ChangeListener<Number> checkIntersection = (ob, n, n1) -> {
        if (carR.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            endgame();
        }
    };

    private final ChangeListener<Number> checkIntersection2 = (ob, n, n1) -> {
        if (carL.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            endgame();

        }
    };
    private final ChangeListener<Number> checkIntersection3 = (ob, n, n1) -> {
        if (carR2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            endgame();
        }
    };

    private final ChangeListener<Number> checkIntersection4 = (ob, n, n1) -> {
        if (carL2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            endgame();

        }
    };
    private final ChangeListener<Number> checkIntersection5 = (ob, n, n1) -> {
        if (carR3.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            endgame();

        }
    };

    // Prüft ob Frosch mit Rechteck kollidiert
//    private final ChangeListener<Number> checkIntersectionRect = (ob,n,n1)->{
//        if (frog.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
//            System.out.println("Trifft Rechteck");
//            endgame();
//
//        }
//    };

    private void endgame() {
        System.out.println("Ein Leben Verloren");
        frog.setX(385);
        frog.setY(725);
        leben -= 1;
        if (leben == 4) {
            game.getChildren().remove(heart5);
        }
        if (leben == 3) {
            game.getChildren().remove(heart4);
        }
        if (leben == 2) {
            game.getChildren().remove(heart3);
        }
        if (leben == 1) {
            game.getChildren().remove(heart2);
        }
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

