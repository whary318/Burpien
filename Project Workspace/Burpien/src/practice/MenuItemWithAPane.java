package practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class MenuItemWithAPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //create the menubar
        MenuBar menuBar = new MenuBar();

        //create the file menu and its sub menus
        Menu fileMenu = new Menu("File");

        Region spacer = new Region();
        HBox hbox = new HBox();
        Button btt1 = new Button("back");
        Button btt2 = new Button("front");
        hbox.getChildren().addAll(btt1, btt2);

        CustomMenuItem paneMenuItem = new CustomMenuItem(hbox);
        //CustomMenuItem paneMenuItem = new CustomMenuItem(spacer);


        // add all the menus created to the menubar
        //menuBar.getMenus().add(fileMenu, paneMenuItem);


        // add the menubar to the layout
        BorderPane bp = new BorderPane();
        bp.setTop(menuBar);

        //display
        Scene scene = new Scene(bp, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
