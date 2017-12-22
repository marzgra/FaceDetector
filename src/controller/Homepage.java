package controller;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Homepage implements ControlledScreen {

    ScreensController myController;
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    public void onClickDalej(ActionEvent actionEvent) {
        myController.setScreen(Main.chooseFileScreenID);
    }
}
