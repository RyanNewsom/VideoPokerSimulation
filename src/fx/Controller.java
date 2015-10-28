package fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


/**
 * Created by Ryan on 10/26/2015.
 */
public class Controller {

    @FXML private Label expectedPayoutPrint;

    @FXML
    protected void handleSubmitButtonAction(MouseEvent me){
        expectedPayoutPrint.setText("You lose money");
    }

}

