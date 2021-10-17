package sample;

// all Imports
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
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
    private int life = 5;


    private Avatar frog;
    @FXML
    private Pane game;

    private int points = 999999;
    @FXML
    private final Text text = new Text("999999");

    private ImageView carR, carR2, carR3;
    private ImageView carL, carL2;
    private ImageView log1, log2, log3, log4, log5;
    private ImageView blood, blood2, blood3, blood4,blood5;
    private ImageView bubbles, bubbles2, bubbles3, bubbles4, bubbles5;
    private ImageView heart1, heart2, heart3, heart4, heart5;

    private boolean isBloodSet, isBlood2Set, isBlood3Set, isBlood4Set, isBlood5Set;
    private boolean isBubbleSet, isBubble2Set, isBubble3Set, isBubble4Set, isBubble5Set;

    private boolean needRotation;

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


    // Waterrec.
    private Rectangle rectangle = new Rectangle();
    // Goalrec.
    private Rectangle rectangleGOAL = new Rectangle();

    @FXML
    private void initialize() {

        // set the PNG
        frog = new Avatar("image/frog_50_38_lila.png");
        carR = new ImageView("image/car_green_40_r.png");
        carL = new ImageView("image/car_red_40.png");
        carR2 = new ImageView("image/car_green_40_r.png");
        carL2 = new ImageView("image/car_red_40.png");
        carR3 = new ImageView("image/car_green_40_r.png");
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
        blood = new ImageView("image/blood.png");
        blood2 = new ImageView("image/blood.png");
        blood3 = new ImageView("image/blood.png");
        blood4 = new ImageView("image/blood.png");
        blood5 = new ImageView("image/blood.png");
        bubbles = new ImageView("image/bubbles.png");
        bubbles2 = new ImageView("image/bubbles.png");
        bubbles3 = new ImageView("image/bubbles.png");
        bubbles4 = new ImageView("image/bubbles.png");
        bubbles5 = new ImageView("image/bubbles.png");


        //set the points counter
        game.getChildren().add(text);
        text.setFont(Font.loadFont(Main.class.getClassLoader().getResourceAsStream("font/pixelFont.TTF"), 35));
        text.setFill(Color.WHITE);
        text.setX(570);
        text.setY(42);

        // add all "children" to the game
        game.getChildren().add(heart1);
        game.getChildren().add(heart2);
        game.getChildren().add(heart3);
        game.getChildren().add(heart4);
        game.getChildren().add(heart5);
        game.getChildren().add(rectangle);
        game.getChildren().add(rectangleGOAL);
        game.getChildren().add(blood);
        game.getChildren().add(blood2);
        game.getChildren().add(blood3);
        game.getChildren().add(blood4);
        game.getChildren().add(blood5);
        game.getChildren().add(bubbles);
        game.getChildren().add(bubbles2);
        game.getChildren().add(bubbles3);
        game.getChildren().add(bubbles4);
        game.getChildren().add(bubbles5);
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

        //place waterrec.
        rectangle.setX(-10);
        rectangle.setY(120);
        rectangle.setWidth(900);
        rectangle.setHeight(260);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.rgb(0, 0, 0, 0));
        rectangle.setStrokeWidth(0);

        //place goalrec.
        rectangleGOAL.setX(-10);
        rectangleGOAL.setY(0);
        rectangleGOAL.setWidth(900);
        rectangleGOAL.setHeight(100);
        rectangleGOAL.setStroke(Color.BLACK);
        rectangleGOAL.setFill(Color.rgb(0, 0, 0, 0));
        rectangleGOAL.setStrokeWidth(0);

        //place hearts
        heart1.setX(10);
        heart2.setX(70);
        heart3.setX(130);
        heart4.setX(190);
        heart5.setX(250);

        //place blood out of the frame
        blood.setY(-100);
        blood2.setY(-100);
        blood3.setY(-100);
        blood4.setY(-100);
        blood5.setY(-100);

        //put the bubbles out of the frame and set the opacity
        bubbles.setY(-100);
        bubbles.setOpacity(0.4);
        bubbles2.setY(-100);
        bubbles2.setOpacity(0.4);
        bubbles3.setY(-100);
        bubbles3.setOpacity(0.4);
        bubbles4.setY(-100);
        bubbles4.setOpacity(0.4);
        bubbles5.setY(-100);
        bubbles5.setOpacity(0.4);

        //set the objectTransition
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

        //give the X and Y of the frog
        System.out.println(frog.getX());
        System.out.println(frog.getY());


        frog.setFocusTraversable(true);

        //listener for cars and logs
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

        log1.translateYProperty().addListener(checkIntersectionLog);
        log1.translateXProperty().addListener(checkIntersectionLog);
        log2.translateYProperty().addListener(checkIntersectionLog2);
        log2.translateXProperty().addListener(checkIntersectionLog2);
        log3.translateYProperty().addListener(checkIntersectionLog3);
        log3.translateXProperty().addListener(checkIntersectionLog3);
        log4.translateYProperty().addListener(checkIntersectionLog4);
        log4.translateXProperty().addListener(checkIntersectionLog4);
        log5.translateYProperty().addListener(checkIntersectionLog5);
        log5.translateXProperty().addListener(checkIntersectionLog5);


        // Eventhandler
        frog.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    frog.moveUp();
                    pointsCounter();
                    collisionLogAndWater();
                    goal();
                    break;
                case DOWN:
                    frog.moveDown();
                    pointsCounter();
                    collisionLogAndWater();
                    break;
                case RIGHT:
                    frog.moveRight();
                    pointsCounter();
                    collisionLogAndWater();
                    break;
                case LEFT:
                    frog.moveLeft();
                    pointsCounter();
                    collisionLogAndWater();
                    break;
                default:
            }
        });

    }

    //function for checking if frog gets in to water
    private void collisionLogAndWater() {
        if(frog.intersects(rectangle.getBoundsInParent())){
            if(!frog.intersects(log5.getBoundsInParent()) && !frog.intersects(log4.getBoundsInParent()) && !frog.intersects(log3.getBoundsInParent()) &&
               !frog.intersects(log1.getBoundsInParent()) && !frog.intersects(log2.getBoundsInParent())){
                bubblesShow();
                endgame();
            }
        }
    }

    //points counter
    private void pointsCounter() {

        points -= 321;
        text.setText(String.valueOf(points));
    }

    //function for empty objectTransition
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

    //checking if frog collides with log and takes him with it
    private final ChangeListener<Number> checkIntersectionLog = (ob, n, n1) -> {
        if (log1.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            if (frog.getX() > 50) {
                frog.setX(log1.getBoundsInParent().getCenterX());
            }else{
                bubblesShow();
                endgame();
            }
        }
    };
    private final ChangeListener<Number> checkIntersectionLog2 = (ob, n, n1) -> {
        if (log2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            if (frog.getX() < 700) {
                frog.setX(log2.getBoundsInParent().getCenterX());
            }else{
                bubblesShow();
                endgame();
            }
        }
    };
    private final ChangeListener<Number> checkIntersectionLog3 = (ob, n, n1) -> {
        if (log3.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            if (frog.getX() > 50) {
                frog.setX(log3.getBoundsInParent().getCenterX());
            }else{
                bubblesShow();
                endgame();
            }
        }
    };
    private final ChangeListener<Number> checkIntersectionLog4 = (ob, n, n1) -> {
        if (log4.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            if (frog.getX() < 700) {
                frog.setX(log4.getBoundsInParent().getCenterX());
            }else{
                bubblesShow();
                endgame();
            }
        }
    };
    private final ChangeListener<Number> checkIntersectionLog5 = (ob, n, n1) -> {
        if (log5.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            if (frog.getX() > 50) {
                frog.setX(log5.getBoundsInParent().getCenterX());
            }else{
                bubblesShow();
                endgame();
            }
        }
    };


    // check if frog collides with car
    private final ChangeListener<Number> checkIntersection = (ob, n, n1) -> {
        if (carR.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            needRotation = false;
            bloodpool();
            endgame();
        }
    };

    private final ChangeListener<Number> checkIntersection2 = (ob, n, n1) -> {
        if (carL.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            needRotation = true;
            bloodpool();
            endgame();
        }
    };
    private final ChangeListener<Number> checkIntersection3 = (ob, n, n1) -> {
        if (carR2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            needRotation = false;
            bloodpool();
            endgame();
        }
    };

    private final ChangeListener<Number> checkIntersection4 = (ob, n, n1) -> {
        if (carL2.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            needRotation = true;
            bloodpool();
            endgame();

        }
    };
    private final ChangeListener<Number> checkIntersection5 = (ob, n, n1) -> {
        if (carR3.getBoundsInParent().intersects(frog.getBoundsInParent())) {
            needRotation = false;
            bloodpool();
            endgame();

        }
    };

    //let the bubble show if frog drowns in water
    private void bubblesShow(){
        if(!isBubbleSet){
            bubbles.setX(frog.getX());
            bubbles.setY(frog.getY());
            isBubbleSet = true;
        }else if(!isBubble2Set){
            bubbles2.setX(frog.getX());
            bubbles2.setY(frog.getY());
            isBubble2Set = true;
        }else if(!isBubble3Set){
            bubbles3.setX(frog.getX());
            bubbles3.setY(frog.getY());
            isBubble3Set = true;
        }else if(!isBubble4Set){
            bubbles4.setX(frog.getX());
            bubbles4.setY(frog.getY());
            isBubble4Set = true;
        }else if(!isBubble5Set){
            bubbles5.setX(frog.getX());
            bubbles5.setY(frog.getY());
            isBubble5Set = true;
        }
    }

    //let the blood appear if car hits the frog
    private void bloodpool(){
       if(!needRotation){
        if(!isBloodSet){
            blood.setX(frog.getX());
            blood.setY(frog.getY());
            isBloodSet = true;
        }else if(!isBlood2Set){
            blood2.setX(frog.getX());
            blood2.setY(frog.getY());
            isBlood2Set = true;
        }else if(!isBlood3Set){
            blood3.setX(frog.getX());
            blood3.setY(frog.getY());
            isBlood3Set = true;
        }else if(!isBlood4Set){
            blood4.setX(frog.getX());
            blood4.setY(frog.getY());
            isBlood4Set = true;
        }else if(!isBlood5Set){
            blood5.setX(frog.getX());
            blood5.setY(frog.getY());
            isBlood5Set = true;
        }
       }
       if(needRotation){
           if(!isBloodSet){
               blood.setX(frog.getX());
               blood.setY(frog.getY());
               blood.setRotate(180);
               isBloodSet = true;
           }else if(!isBlood2Set){
               blood2.setX(frog.getX());
               blood2.setY(frog.getY());
               blood2.setRotate(180);
               isBlood2Set = true;
           }else if(!isBlood3Set){
               blood3.setX(frog.getX());
               blood3.setY(frog.getY());
               blood3.setRotate(180);
               isBlood3Set = true;
           }else if(!isBlood4Set){
               blood4.setX(frog.getX());
               blood4.setY(frog.getY());
               blood4.setRotate(180);
               isBlood4Set = true;
           }else if(!isBlood5Set){
               blood5.setX(frog.getX());
               blood5.setY(frog.getY());
               blood5.setRotate(180);
               isBlood5Set = true;
           }
       }
    }

    //function for taking hearts away and give a massage
    private void endgame() {
        frog.setX(385);
        frog.setY(725);
        life -= 1;
        if (life == 4) {
            game.getChildren().remove(heart5);
        }
        if (life == 3) {
            game.getChildren().remove(heart4);
        }
        if (life == 2) {
            game.getChildren().remove(heart3);
        }
        if (life == 1) {
            game.getChildren().remove(heart2);
        }
        if (life == 0) {
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

    //function for completing the game and a massage with points
    private void goal() {
        if(frog.intersects(rectangleGOAL.getBoundsInParent())){
            int heart = 0;
            if (life == 4) {heart=4;}
            if (life == 3) {heart=3;}
            if (life == 2) {heart=2;}
            if (life == 1) {heart=1;}
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("GOAL");
            alert.setHeaderText("You reched the goal");
            alert.setContentText("You have "+ heart +" hearts left and got " + points + " points");
            pathTransition.stop();
            pathTransition2.stop();
            alert.setOnHidden(evt -> Platform.exit());

            alert.show();
        }
    }
}

