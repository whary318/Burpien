package Application.views;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SettingsPageView {
    private static VBox topAndBottomOfMain;
    private static HBox bottomRightAndLeftSide;

    private static BorderPane itemsAndCatview;
    private static VBox itemsCreatorView;
    private static HBox menubarView;

    private static Separator separatorTopButton, separatorButtomParts;

    public static void start(Stage primaryStage) {
        // The general layout of the program
        topAndBottomOfMain = new VBox();
        bottomRightAndLeftSide = new HBox();
        //-----------------------------------


        // the elements of the page
        itemsAndCatview = new CatAndItemsView().getItemsAndCatView();
        itemsCreatorView = new ItemsCreatorAndModifierView().getView();
        menubarView = new SettingsPageMenuBarView().getView();
        //-----------------------------------


        // add all together
        separatorTopButton = new Separator();
        separatorButtomParts = new Separator();
        separatorButtomParts.setOrientation(Orientation.VERTICAL);

        HBox.setHgrow(itemsAndCatview, Priority.ALWAYS);

        bottomRightAndLeftSide.getChildren().addAll(itemsAndCatview, separatorButtomParts, itemsCreatorView);
        topAndBottomOfMain.getChildren().addAll(menubarView, separatorTopButton, bottomRightAndLeftSide);
        //----------------------------------


        // Display it all
        Scene scene = new Scene(topAndBottomOfMain, 1050, 700);
        primaryStage.setMinWidth(720);
        primaryStage.setMinHeight(500);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Burpien - Settings Page");
        primaryStage.show();
        //----------------------------------
    }
    public static void updateUI(){
        itemsAndCatview = new CatAndItemsView().getItemsAndCatView();

        bottomRightAndLeftSide.getChildren().clear();
        topAndBottomOfMain.getChildren().clear();

        bottomRightAndLeftSide.getChildren().addAll(itemsAndCatview, separatorButtomParts, itemsCreatorView);
        topAndBottomOfMain.getChildren().addAll(menubarView, separatorTopButton, bottomRightAndLeftSide);
    }
}
