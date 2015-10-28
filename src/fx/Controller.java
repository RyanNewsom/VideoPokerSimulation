package fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * Created by Ryan on 10/26/2015.
 */
public class Controller {
    //VIEWS
    @FXML private Label expectedPayoutPrint;
    @FXML private TextField multiplier_text_field;
    @FXML private TextField royal_flush_text_field;
    @FXML private TextField straight_flush_text_field;
    @FXML private TextField four_of_a_kind_aces_text_field;
    @FXML private TextField four_of_a_kind_234_text_field;
    @FXML private TextField four_of_a_kind_5_to_king_text_field;
    @FXML private TextField full_house_text_field;
    @FXML private TextField flush_text_field;
    @FXML private TextField straight_text_field;
    @FXML private TextField three_of_a_kind_text_field;
    @FXML private TextField two_pair_text_field;
    @FXML private TextField pair_jacks_or_better_text_field;

    //DATA
    private long multiplier;
    private long royalFlush;
    private long straightFlush;
    private long fourOfAKindAces;
    private long fourOfAKind234;
    private long fourOfAKind5ToKing;
    private long fullHouse;
    private long flush;
    private long straight;
    private long threeOfAKind;
    private long twoPair;
    private long pairJacksOrBetter;


    @FXML
    protected void handleSubmitButtonAction(MouseEvent me){
        expectedPayoutPrint.setText("You lose money");
        updateData();
    }

    private void updateData() {
        try {
            multiplier = Long.parseLong(multiplier_text_field.getText());
            royalFlush = Long.parseLong(royal_flush_text_field.getText());
            straightFlush = Long.parseLong(straight_flush_text_field.getText());
            fourOfAKindAces = Long.parseLong(four_of_a_kind_aces_text_field.getText());
            fourOfAKind234 = Long.parseLong(four_of_a_kind_234_text_field.getText());
            fourOfAKind5ToKing = Long.parseLong(four_of_a_kind_5_to_king_text_field.getText());
            fullHouse = Long.parseLong(full_house_text_field.getText());
            flush = Long.parseLong(flush_text_field.getText());
            straight = Long.parseLong(straight_flush_text_field.getText());
            threeOfAKind = Long.parseLong(three_of_a_kind_text_field.getText());
            twoPair = Long.parseLong(two_pair_text_field.getText());
            pairJacksOrBetter = Long.parseLong(pair_jacks_or_better_text_field.getText());
        } catch (NumberFormatException e){
            //Show a dialog stating the user must enter integers only
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("Error, you can only enter integers \n")).
                    alignment(Pos.CENTER).padding(new Insets(5)).build()));
            dialogStage.show();
        }

    }


}

