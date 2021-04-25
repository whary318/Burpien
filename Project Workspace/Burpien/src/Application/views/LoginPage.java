package Application.views;


import Application.controller.Controller;
import Application.modules.User;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPage {

	private static Button clockinbtn;
	private static Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	private static TextField textfield1;
	private Stage stage;

	public LoginPage(Stage stage) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
		start(stage);
	}

	public void start(Stage primaryStage) {
		//prep for Page
		initializeButtons();
		setOnActionsForButtons();

		//page setup
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		HBox hboxtitles = new HBox(spacer, clockinbtn);

		GridPane gridpane1 = new GridPane();
		gridpane1.setPadding(new Insets(10));
		gridpane1.setHgap(10);
		gridpane1.setVgap(10);
		gridpane1.setAlignment(Pos.CENTER);
		gridpane1.setGridLinesVisible(false);
		
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(btn7, btn8, btn9);
		HBox.setMargin(btn7, new Insets(2));
		HBox.setMargin(btn8, new Insets(2));
		HBox.setMargin(btn9, new Insets(2));

		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(btn4, btn5, btn6);
		HBox.setMargin(btn4, new Insets(2));
		HBox.setMargin(btn5, new Insets(2));
		HBox.setMargin(btn6, new Insets(2));

		HBox hbox3 = new HBox();
		hbox3.getChildren().addAll(btn1, btn2, btn3);
		HBox.setMargin(btn1, new Insets(2));
		HBox.setMargin(btn2, new Insets(2));
		HBox.setMargin(btn3, new Insets(2));

		HBox hbox4 = new HBox();
		hbox4.getChildren().addAll(btn0);
		HBox.setMargin(btn0, new Insets(2));

		gridpane1.add(hbox1, 0, 2);
		gridpane1.add(hbox2, 0, 3);
		gridpane1.add(hbox3, 0, 4);
		gridpane1.add(hbox4, 0, 5);

		VBox vbox1 = new VBox(hboxtitles, textfield1, gridpane1);
		vbox1.setPadding(new Insets(10));

		BorderPane bp = new BorderPane();
		bp.setCenter(vbox1);
		bp.setPadding(new Insets(10));
		
		
		//Scene setup
		Scene scene = new Scene(bp, 290, 350);
		primaryStage.setMinHeight(350);
		primaryStage.setMinWidth(290);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Burpien - Login Form");
		primaryStage.show();

	}

	private void initializeButtons() {
		// first create labels
		clockinbtn = new Button("Clock In");

		// now create text fields
		textfield1 = new TextField();
		textfield1.setEditable(false);

		// now create the buttons
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		btn6 = new Button("6");
		btn7 = new Button("7");
		btn8 = new Button("8");
		btn9 = new Button("9");
		btn0 = new Button("0");
	}

	private void setOnActionsForButtons() {
		clockinbtn.setOnAction(e -> handleButtonClicks(e));

		btn1.setOnAction(e -> handleButtonClicks(e));
		btn2.setOnAction(e -> handleButtonClicks(e));
		btn3.setOnAction(e -> handleButtonClicks(e));
		btn4.setOnAction(e -> handleButtonClicks(e));
		btn5.setOnAction(e -> handleButtonClicks(e));
		btn6.setOnAction(e -> handleButtonClicks(e));
		btn7.setOnAction(e -> handleButtonClicks(e));
		btn8.setOnAction(e -> handleButtonClicks(e));
		btn9.setOnAction(e -> handleButtonClicks(e));
		btn0.setOnAction(e -> handleButtonClicks(e));
		
	}

	private void handleButtonClicks(ActionEvent e) {
		//handle clock-in action
		if (e.getSource() == clockinbtn) {
			if (!textfield1.getText().equals("")) {
				int id = Integer.parseInt(textfield1.getText()); // this will cause the program to overflow when entering a huge number. -- fix this
				textfield1.setText("");
				
				for(User user: Controller.getUsers())
					if (user.getUserId() == id) {
						Controller.setCurrentUser(user);
						Controller.switchToMainPage();
					}
			}
		}
		
		//handling the number pad
		else if (e.getSource() == btn1)
			textfield1.setText(textfield1.getText() + "1");
		else if (e.getSource() == btn2)
			textfield1.setText(textfield1.getText() + "2");
		else if (e.getSource() == btn3)
			textfield1.setText(textfield1.getText() + "3");
		else if (e.getSource() == btn4)
			textfield1.setText(textfield1.getText() + "4");
		else if (e.getSource() == btn5)
			textfield1.setText(textfield1.getText() + "5");
		else if (e.getSource() == btn6)
			textfield1.setText(textfield1.getText() + "6");
		else if (e.getSource() == btn7)
			textfield1.setText(textfield1.getText() + "7");
		else if (e.getSource() == btn8)
			textfield1.setText(textfield1.getText() + "8");
		else if (e.getSource() == btn9)
			textfield1.setText(textfield1.getText() + "9");
		else if (e.getSource() == btn0)
			textfield1.setText(textfield1.getText() + "0");
		
	}

}
