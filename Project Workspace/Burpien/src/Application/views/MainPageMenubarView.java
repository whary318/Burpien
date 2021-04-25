package Application.views;

import Application.controller.Controller;
import Application.modules.Privilage;
import Application.modules.User;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class MainPageMenubarView {

	private HBox menubar;
	private Button settingsbtn, logbtn;
	private Label userlbl;
	private Button leftarrowbtn, neworderbtn,rightarrowbtn,cancelbtn;

	public MainPageMenubarView() {

		settingsbtn = new Button("Settings");
		logbtn = new Button("Log out");

		logbtn.setOnAction(e -> setOnActionsForButtons(e));
		settingsbtn.setOnAction(e -> setOnActionsForButtons(e));

		userlbl = new Label("User id: " + Controller.getCurrentUser().getUserId() + " - " + Controller.getCurrentUser().getUserName());

		leftarrowbtn = new Button("<--");
		neworderbtn = new Button("New Order");
		rightarrowbtn = new Button("-->");
		cancelbtn = new Button("Cancel");

		leftarrowbtn.setOnAction(e -> setOnActionsForButtons(e));
		neworderbtn.setOnAction(e -> setOnActionsForButtons(e));
		rightarrowbtn.setOnAction(e -> setOnActionsForButtons(e));
		cancelbtn.setOnAction(e -> setOnActionsForButtons(e));


		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		Separator separatorMenuBar = new Separator();
		separatorMenuBar.setOrientation(Orientation.VERTICAL);

		menubar = new HBox(settingsbtn, logbtn, spacer, userlbl, separatorMenuBar, leftarrowbtn, neworderbtn, rightarrowbtn, cancelbtn);

		HBox.setMargin(settingsbtn, new Insets(10));
		HBox.setMargin(logbtn, new Insets(10));
		HBox.setMargin(userlbl, new Insets(15, 10, 10, 10));

		HBox.setMargin(leftarrowbtn, new Insets(10, 2, 10, 2));
		HBox.setMargin(neworderbtn, new Insets(10, 0, 10, 0));
		HBox.setMargin(rightarrowbtn, new Insets(10, 2, 10, 2));

		HBox.setMargin(cancelbtn, new Insets(10));

	}
	private void setOnActionsForButtons(ActionEvent e) {
		//handle the menubar buttons
		if (e.getSource() == settingsbtn){
			//System.out.println(Controller.getCurrentUser().getPrivilage().compareTo(Privilage.SuperVisor));
			if (Controller.getCurrentUser().getPrivilage().compareTo(Privilage.SuperVisor) < 1 ) {
				Controller.switchToSettingsPage();
			}
		}

		else if (e.getSource() == logbtn)
			Controller.logout();

		//handle order buttons
		else if (e.getSource() == leftarrowbtn)
			BasketView.prevBasket();
		else if (e.getSource() == neworderbtn)
			BasketView.newOrderToBasket();
		else if (e.getSource() == rightarrowbtn)
			BasketView.nextBasket();
		else if (e.getSource() == cancelbtn)
			BasketView.cancelCurrentOrder();
	}

	public HBox getMenuBar() {
		return menubar;
	}

}
