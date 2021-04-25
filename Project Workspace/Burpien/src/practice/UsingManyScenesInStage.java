package practice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UsingManyScenesInStage extends Application {
    static Button scene1Button;
    static Button scene2Button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();

        scene1Button = new Button("scene1");
        scene2Button = new Button("scene2");

        pane.setTop(scene1Button);
        pane.setRight(scene2Button);

        scene1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene1(primaryStage);
            }
        });
        scene2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene2(primaryStage);
            }
        });

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("creation Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void scene1(Stage primaryStage){
        Pane pane = new Pane();


        Text btt = new Text("something");
        pane.getChildren().addAll(scene2Button, btt);
        btt.setOnMouseDragged(e2 -> {
            btt.setX(e2.getX());
            btt.setY(e2.getY());
            System.out.println("done");
        });
        //pane.setPadding(new Insets(15));

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        //primaryStage.show();
    }
    public static void scene2(Stage primaryStage){
        BorderPane pane = new BorderPane();

        Text btt = new Text("Hello there");
        Button btt2 = new Button("Submit");

        pane.setTop(btt);
        pane.setRight(btt2);
        pane.setBottom(scene1Button);

        pane.setAlignment(btt, Pos.CENTER);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setScene(scene);
        //primaryStage.show();
    }
}
