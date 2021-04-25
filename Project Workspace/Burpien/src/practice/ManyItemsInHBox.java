package practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManyItemsInHBox extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) {
		Button btn1 = new Button("Button");
		Button btn2 = new Button("Button");
		Button btn3 = new Button("Button");
		Button btn4 = new Button("Button");
		Button btn5 = new Button("Button");
		
		FlowPane box = new FlowPane(btn1, btn2, btn3, btn4, btn5);
		box.setPadding(new Insets(10));
		box.setVgap(10);
		box.setHgap(20);
		
		Scene s = new Scene(box, 200, 200);
		ps.setScene(s);
		ps.show();
		

	}

}
