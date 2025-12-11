package com.example.hunterxhunterprofilemanagement;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;

public class HxhController {

    @FXML private ImageView imagePreview;
    @FXML private Button uploadBtn, saveBtn, clearBtn, deleteBtn, addUserBtn;
    @FXML private TextField lastNameField, givenNameField, middleNameField, rankField;
    @FXML private ComboBox<String> nenTypeBox;
    @FXML private TableView<Profile> tableView;

    @FXML private TableColumn<Profile, Image> imageCol;
    @FXML private TableColumn<Profile, String> lastNameCol;
    @FXML private TableColumn<Profile, String> givenNameCol;
    @FXML private TableColumn<Profile, String> middleNameCol;
    @FXML private TableColumn<Profile, String> nenTypeCol;
    @FXML private TableColumn<Profile, String> rankCol;

    private Profile editing = null;

    @FXML
    public void initialize() {
        nenTypeBox.getItems().addAll("Enhancer", "Transmuter", "Conjurer",
                "Emitter", "Manipulator", "Specialist");

        imageCol.setCellValueFactory(c -> c.getValue().imageProperty());
        imageCol.setCellFactory(col -> new ProfileImageCell());

        lastNameCol.setCellValueFactory(c -> c.getValue().lastNameProperty());
        givenNameCol.setCellValueFactory(c -> c.getValue().givenNameProperty());
        middleNameCol.setCellValueFactory(c -> c.getValue().middleNameProperty());
        nenTypeCol.setCellValueFactory(c -> c.getValue().nenTypeProperty());
        rankCol.setCellValueFactory(c -> c.getValue().rankProperty());

        tableView.setOnMouseClicked(e -> {
            if (tableView.getSelectionModel().getSelectedItem() != null)
                loadToForm(tableView.getSelectionModel().getSelectedItem());
        });

        uploadBtn.setOnAction(e -> chooseImage());
        saveBtn.setOnAction(e -> saveProfile());
        clearBtn.setOnAction(e -> clearForm());
        deleteBtn.setOnAction(e -> deleteProfile());
    }

    private void chooseImage() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg")
        );
        File file = fc.showOpenDialog(null);
        if (file != null) {
            try {
                imagePreview.setImage(new Image(new FileInputStream(file)));
            } catch (Exception ignored) {}
        }
    }

    private void saveProfile() {
        if (editing == null) {
            Profile p = new Profile(
                    lastNameField.getText(),
                    givenNameField.getText(),
                    middleNameField.getText(),
                    nenTypeBox.getValue(),
                    rankField.getText(),
                    imagePreview.getImage()
            );
            tableView.getItems().add(p);
        } else {
            editing.update(
                    lastNameField.getText(),
                    givenNameField.getText(),
                    middleNameField.getText(),
                    nenTypeBox.getValue(),
                    rankField.getText(),
                    imagePreview.getImage()
            );
        }
        clearForm();
    }

    private void deleteProfile() {
        Profile sel = tableView.getSelectionModel().getSelectedItem();
        if (sel != null)
            tableView.getItems().remove(sel);

        clearForm();
    }

    private void loadToForm(Profile p) {
        editing = p;
        lastNameField.setText(p.getLastName());
        givenNameField.setText(p.getGivenName());
        middleNameField.setText(p.getMiddleName());
        nenTypeBox.setValue(p.getNenType());
        rankField.setText(p.getRank());
        imagePreview.setImage(p.getImage());
    }

    private void clearForm() {
        editing = null;
        lastNameField.clear();
        givenNameField.clear();
        middleNameField.clear();
        nenTypeBox.setValue(null);
        rankField.clear();
        imagePreview.setImage(null);
        tableView.getSelectionModel().clearSelection();
    }
}
