module com.example.hunterxhunterprofilemanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.hunterxhunterprofilemanagement to javafx.fxml;
    exports com.example.hunterxhunterprofilemanagement;
}
