package fx;
/**
 * Created by Ryan on 10/26/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VideoPoker extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Video Poker Simulation");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(VideoPoker.class.getResource("VideoPoker.css").toExternalForm());
        primaryStage.show();
    }
}
