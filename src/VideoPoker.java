/**
 * Created by Ryan on 10/26/2015.
 * The Driver for running the Video Poker game using the GUI
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VideoPoker extends Application {
    public static void main(String [] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Video Poker");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(VideoPoker.class.getResource("VideoPoker.css").toExternalForm());
        primaryStage.show();
    }
}
