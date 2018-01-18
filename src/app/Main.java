package app;
import controller.ScreensController;
import org.opencv.core.Core;
import server.Server;

import java.io.*;
import java.net.ServerSocket;


public class Main {

    public static String homepage = "homepage";
    private static String homepageFile = "/view/Homepage.fxml";
    public static String chooseFileScreen = "chooseFileScreen";
    private static String chooseFileScreenFile = "/view/ChooseFileScreen.fxml";
    public static String processPreviewScreen = "ProcessPreviewScreen";
    private static String processPreviewScreenFile = "/view/ProcessPreviewScreen.fxml";


    public static void main(String[] args) {
        System.out.println("Hello, OpenCV");

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Main.homepage, Main.homepageFile);
        mainContainer.loadScreen(Main.chooseFileScreen, Main.chooseFileScreenFile);
        mainContainer.loadScreen(Main.processPreviewScreen, Main.processPreviewScreenFile);

        // Load the native library.
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int port = 9090;
        try (ServerSocket serverSocket = new ServerSocket(port)){

            while(true) {
                new Server(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}



