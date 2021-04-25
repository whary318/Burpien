package Application.views;

import Application.controller.Controller;
import Application.modules.Category;
import Application.modules.PriceType;
import Application.modules.Privilage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ItemsCreatorAndModifierView {
    private static VBox itemCreatorView;
    private static HBox topButtonsHBox, itemTypeHBox, categoriesHBox, priceHBox, barcodeHBox, createButtonHBox, saveDeleteHBox, itemNameHBox;
    private static Label infollbl,typelbl,namelbl,catlbl,prclbl, bylbl, barcodelbl;
    private static Button newbtn, infobtn, createbtn, savebtn,delbtn;
    private static ChoiceBox itemTypeChoiceBox, categoriesChoiceBox, itemPriceTypeChoiceBox;
    private static TextField nameTextField, priceTextField, barcodeTextField;
    private static ArrayList<Category> categories;

    public ItemsCreatorAndModifierView() {
        initializeClassObjectsOnce();

        itemsCreatorPart1();
        //itemsCreatorPart2();
        //itemsCreatorButtons();
        //itemsModifierButtons();
    }

    private void initializeClassObjectsOnce(){
        infollbl = new Label("Items List and Information");
        newbtn = new Button("New");
        infobtn = new Button("Info");
        typelbl = new Label("Type: ");
        namelbl= new Label("Name: ");
        createbtn = new Button("Create");

        catlbl = new Label("Category: ");
        prclbl = new Label("Price: ");
        bylbl = new Label("By: ");
        barcodelbl = new Label("Barcode ID: ");

        nameTextField = new TextField();
        nameTextField.setPrefWidth(220);
        priceTextField = new TextField();
        priceTextField.setMaxWidth(90);
        barcodeTextField = new TextField();
        barcodeTextField.setPrefWidth(200);

        savebtn = new Button("Save");
        delbtn = new Button("Delete");

        categories = Controller.getCategories();

        newbtn.setOnAction(e -> handleButtonClicks(e));
        infobtn.setOnAction(e -> handleButtonClicks(e));
        createbtn.setOnAction(e -> handleButtonClicks(e));
        savebtn.setOnAction(e -> handleButtonClicks(e));
        delbtn.setOnAction(e -> handleButtonClicks(e));

        itemCreatorView = new VBox(20);
        itemCreatorView.setPadding(new Insets(20));
        //basketView.setAlignment(Pos.TOP_RIGHT);
        itemCreatorView.setPrefHeight(2000);
        itemCreatorView.setMinWidth(330);
        itemCreatorView.setMaxWidth(330);

        topButtonsHBox = new HBox();
        HBox.setMargin(infollbl, new Insets(5));
        HBox.setMargin(newbtn, new Insets(5));
        HBox.setMargin(infobtn, new Insets(5));
        topButtonsHBox.getChildren().addAll(newbtn/*, infobtn*/);

        itemTypeChoiceBox = new ChoiceBox();
        //itemTypeChoiceBox.setItems(FXCollections.observableArrayList("Category", /*new Separator(),*/ "Item"));
        itemTypeChoiceBox.getItems().addAll("Category", /*new Separator(),*/ "Item");
        itemTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, number, number2) -> {
                    //System.out.println(itemTypeChoiceBox.getItems().get((Integer) number2));
                    handleChangeInCategory((Integer) number2 );
                }
        );

        itemTypeHBox = new HBox();
        HBox.setMargin(typelbl, new Insets(5));
        HBox.setMargin(itemTypeChoiceBox, new Insets(5));
        itemTypeHBox.getChildren().addAll(typelbl, itemTypeChoiceBox);

        itemNameHBox = new HBox();
        HBox.setMargin(namelbl, new Insets(5));
        HBox.setMargin(nameTextField, new Insets(5));
        itemNameHBox.getChildren().addAll(namelbl, nameTextField);

        categoriesChoiceBox = new ChoiceBox();
        categoriesChoiceBox.setPrefWidth(200);
        //categoriesChoiceBox.setItems(FXCollections.observableArrayList("Cat 1", /*new Separator(),*/ "Cat 2", /*new Separator(),*/ "Etc"));
        for (Category cat: categories)
            categoriesChoiceBox.getItems().add(cat.getName());

        categoriesHBox = new HBox();
        HBox.setMargin(catlbl, new Insets(5));
        HBox.setMargin(categoriesChoiceBox, new Insets(5));
        categoriesHBox.getChildren().addAll(catlbl, categoriesChoiceBox);

        itemPriceTypeChoiceBox = new ChoiceBox();
        itemPriceTypeChoiceBox.setItems(FXCollections.observableArrayList("Unit", /*new Separator(),*/ "Weight (1 lb)"));

        priceHBox = new HBox();
        HBox.setMargin(prclbl, new Insets(5));
        HBox.setMargin(priceTextField, new Insets(5));
        HBox.setMargin(bylbl, new Insets(5));
        HBox.setMargin(itemPriceTypeChoiceBox, new Insets(5));
        priceHBox.getChildren().addAll(prclbl, priceTextField,bylbl, itemPriceTypeChoiceBox);

        barcodeHBox = new HBox();
        HBox.setMargin(barcodelbl, new Insets(5));
        HBox.setMargin(barcodeTextField, new Insets(5));
        barcodeHBox.getChildren().addAll(barcodelbl, barcodeTextField);

        createButtonHBox = new HBox();
        HBox.setHgrow(createbtn, Priority.ALWAYS);
        createbtn.setMaxWidth(Double.MAX_VALUE);
        HBox.setMargin(createbtn, new Insets(5));
        createButtonHBox.getChildren().addAll(createbtn);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        saveDeleteHBox = new HBox();
        HBox.setMargin(savebtn, new Insets(10));
        HBox.setMargin(delbtn, new Insets(10));
        saveDeleteHBox.getChildren().addAll(savebtn, spacer, delbtn);
    }

    private void itemsCreatorPart1(){
        itemCreatorView.getChildren().clear();
        itemCreatorView.getChildren().addAll(infollbl, topButtonsHBox, itemTypeHBox);
    }
    private void itemsCreatorPart2(){
        itemCreatorView.getChildren().addAll(itemNameHBox);
    }
    private void itemsCreatorPart3(){
        itemCreatorView.getChildren().addAll(categoriesHBox, priceHBox, barcodeHBox);
    }
    private void itemsCreatorButtons(){
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        itemCreatorView.getChildren().addAll(spacer, createButtonHBox);
    }
    private void itemsModifierButtons(){
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        itemCreatorView.getChildren().addAll(spacer, saveDeleteHBox);
    }

    private void handleButtonClicks(ActionEvent e) {
        if (e.getSource() == newbtn){
            itemsCreatorPart1();
            //itemsCreatorPart2();
            //itemsCreatorButtons();
        }
        else if (e.getSource() == infobtn){
            itemsCreatorPart1();
            //itemsCreatorPart2();
            itemsModifierButtons();
        }
        else if (e.getSource() == createbtn){
            createItem();
        }
        else if (e.getSource() == savebtn){

        }
        else if (e.getSource() == delbtn){

        }
    }
    private void handleChangeInCategory(int i) {
        if (i == 0){
            itemsCreatorPart1();
            itemsCreatorPart2();
            itemsCreatorButtons();
        }
        else if (i == 1){
            itemsCreatorPart1();
            itemsCreatorPart2();
            itemsCreatorPart3();
            itemsCreatorButtons();
        }
    }

    private void createItem(){
        if (itemTypeChoiceBox.getSelectionModel().getSelectedIndex() == 0){
            if (!nameTextField.getText().isEmpty()) {
                categories.add( new Category(nameTextField.getText()));
                nameTextField.setText("");

                Controller.switchToSettingsPage();
                //SettingsPageView.updateUI();
                System.out.println("new category created");
            }
        }
        else if (itemTypeChoiceBox.getSelectionModel().getSelectedIndex() == 1){
            if (!nameTextField.getText().isEmpty() &&
                    !priceTextField.getText().isEmpty() &&
                    !barcodeTextField.getText().isEmpty() &&
                    categoriesChoiceBox.getSelectionModel().getSelectedIndex() != -1 &&
                    itemPriceTypeChoiceBox.getSelectionModel().getSelectedIndex() != -1) {

                PriceType pt;
                if (itemPriceTypeChoiceBox.getSelectionModel().getSelectedIndex() == 0)
                    pt = PriceType.Unit;
                else
                    pt = PriceType.Weight;

                categories.get(categoriesChoiceBox.getSelectionModel().getSelectedIndex()).additem(nameTextField.getText(), Double.parseDouble(priceTextField.getText()), pt , Integer.parseInt(barcodeTextField.getText()));

                Controller.switchToSettingsPage();
                //SettingsPageView.updateUI();

                System.out.println("new item created");
                // reset all
                nameTextField.setText("");
                priceTextField.setText("");
                barcodeTextField.setText("");
                categoriesChoiceBox.getSelectionModel().clearSelection();
                itemPriceTypeChoiceBox.getSelectionModel().clearSelection();
            }
        }
    }
    private void modifyItem() {}
    private void deleteItem() {}

    public static VBox getView(){
        return itemCreatorView;
    }

}
