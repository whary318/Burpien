package Application.views;

import Application.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.application.Application;
import javafx.stage.Stage;

public class SettingsPageMenuBarView {

	private HBox menubar;
	private Button donebtn, loadbtn, cancelbtn;
	private Label userlbl;

	public SettingsPageMenuBarView() {

		donebtn = new Button("Done");
		donebtn.setOnAction(e -> handleButtonClick(e));
		//loadbtn = new Button("Load");
		//cancelbtn = new Button("Cancel");

		userlbl = new Label("User id: " + Controller.getCurrentUser().getUserId() + " - "
				+ Controller.getCurrentUser().getUserName());


		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		Separator separatorMenuBar = new Separator();
		separatorMenuBar.setOrientation(Orientation.VERTICAL);

		menubar = new HBox(donebtn, spacer, userlbl, separatorMenuBar);

		HBox.setMargin(donebtn, new Insets(5));
		//HBox.setMargin(loadbtn, new Insets(5));
		//HBox.setMargin(cancelbtn, new Insets(5));
		HBox.setMargin(userlbl, new Insets(15, 10, 10, 10));
	}


	public HBox getView() {
		return menubar;
	}

	private void handleButtonClick(ActionEvent e) {
		if (e.getSource() == donebtn)
			Controller.switchToMainPage();
	}

}
