package controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import model.Datastore;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChooseFileScreen implements Initializable, ControlledScreen {


    ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onClickDalej(ActionEvent actionEvent) {
        myController.setScreen(Main.processPreviewScreenID);
    }

    public void onClickWybierzPliki(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz zdjęcia");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Pliki Obrazów", "*.png", "*.jpg"));

        List<File> files = fileChooser.showOpenMultipleDialog(null);
        for (File file : files) {
            System.out.println(file.getPath());
        }

        Datastore.getInstance().setFiles(files);
    }

    public void onClickWybierzMiejsceZapisu(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Wybierz miejsce do zapisu");
        File outputFolder = directoryChooser.showDialog(null);

        System.out.println(outputFolder.getAbsolutePath());

        Datastore.getInstance().setDirectoryPath(outputFolder.getAbsolutePath());

    }
}
