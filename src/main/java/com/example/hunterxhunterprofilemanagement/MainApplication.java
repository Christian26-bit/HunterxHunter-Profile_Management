package com.example.hunterxhunterprofilemanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(
                "/com/example/hunterxhunterprofilemanagement/hxhView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 620);
        stage.setTitle("Hunter x Hunter Profile Management");
        stage.setScene(scene);
        stage.show();
    }
}
