package practice;
//package com.Practice.Project;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreateManyObjects extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Button bn = new Button("ok");
//        Scene sc = new Scene(bn, 200, 200);
//
//        primaryStage.setTitle("Primary stage");
//        primaryStage.setScene(sc);
//        primaryStage.show();


        Pane pane = new Pane();
        Button bt = new Button("create");
        pane.getChildren().addAll(bt);
//        bt.setOnAction(e -> {
//            Text text = new Text(20, 20, "Programming in JAVA is fun");
//            pane.getChildren().addAll(text);
//            text.setOnMouseDragged(e2 -> {
//                text.setX(e2.getX());
//                text.setY(e2.getY());
//                System.out.println("done");
//            });
//            System.out.println(text);
//        });

        bt.setOnAction(e -> {

            Text btt = new Text("something");
            pane.getChildren().addAll(btt);
            btt.setOnMouseDragged(e2 -> {
                btt.setX(e2.getX());
                btt.setY(e2.getY());
                System.out.println("done");
            });
        });

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("creation Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
