package com.example.hunterxhunterprofilemanagement;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Profile {

    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty givenName = new SimpleStringProperty();
    private final StringProperty middleName = new SimpleStringProperty();
    private final StringProperty nenType = new SimpleStringProperty();
    private final StringProperty rank = new SimpleStringProperty();
    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();

    public Profile(String ln, String gn, String mn, String nen, String rank, Image img) {
        lastName.set(ln);
        givenName.set(gn);
        middleName.set(mn);
        nenType.set(nen);
        this.rank.set(rank);
        image.set(img);
    }

    public void update(String ln, String gn, String mn, String nen, String rank, Image img) {
        lastName.set(ln);
        givenName.set(gn);
        middleName.set(mn);
        nenType.set(nen);
        this.rank.set(rank);
        image.set(img);
    }

    public StringProperty lastNameProperty() { return lastName; }
    public StringProperty givenNameProperty() { return givenName; }
    public StringProperty middleNameProperty() { return middleName; }
    public StringProperty nenTypeProperty() { return nenType; }
    public StringProperty rankProperty() { return rank; }
    public ObjectProperty<Image> imageProperty() { return image; }

    public String getLastName() { return lastName.get(); }
    public String getGivenName() { return givenName.get(); }
    public String getMiddleName() { return middleName.get(); }
    public String getNenType() { return nenType.get(); }
    public String getRank() { return rank.get(); }
    public Image getImage() { return image.get(); }
}
