package com.example.hunterxhunterprofilemanagement;

import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProfileImageCell extends TableCell<Profile, Image> {

    private final ImageView img = new ImageView();

    public ProfileImageCell() {
        img.setFitWidth(80);
        img.setFitHeight(80);
        img.setPreserveRatio(true);
    }

    @Override
    protected void updateItem(Image image, boolean empty) {
        super.updateItem(image, empty);

        if (empty || image == null) {
            setGraphic(null);
        } else {
            img.setImage(image);
            setGraphic(img);
        }
    }
}
