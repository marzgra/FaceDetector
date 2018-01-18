package controller;

import app.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Datastore;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProcessPreviewScreen implements Initializable, ControlledScreen {

    private ScreensController myController;

    @FXML
    private Button koniec;

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void onClickKoniec() {
        koniec.setOnAction(e -> Platform.exit());
    }

    public void onClickOtworzFolder() {
        try {
            Desktop.getDesktop().open(new File(Datastore.getInstance().getDirectoryPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickWgrajNowe() {
        myController.setScreen(Main.chooseFileScreen);
    }
}
