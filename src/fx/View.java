package fx;

import backend.data.PayoutTable;
import backend.card.Card;
import backend.card.HandOfCards;
import backend.controller.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;


/**
 * Created by Ryan on 10/26/2015.
 */
public class View {
    //Controller
    Controller controller = new Controller();

    //VIEWS
    @FXML private TextField royal_flush_text_field;
    @FXML private TextField straight_flush_text_field;
    @FXML private TextField four_of_a_kind_aces_text_field;
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
    private long fullHouse;
    private long flush;
    private long straight;
    private long threeOfAKind;
    private long twoPair;
    private long pairJacksOrBetter;

    //Objects
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private static HandOfCards currentHand;

    /**
     * Will update the objects and UI for the current hand
     * @param handOfCards
     */
    public static void updateCurrentHand(HandOfCards handOfCards){
        currentHand = handOfCards;
        log("updateCurrentHand has been called");
    }

    @FXML
    protected void determineExpectedPayoutButtonClick(MouseEvent me){
        determineExpectedPayout();
    }

    @FXML
    protected void drawNewCardsButtonClick(MouseEvent event) {
        drawNewHand();
    }

    private void determineExpectedPayout() {
        PayoutTable payoutTable = createPayoutTable();
    }

    private PayoutTable createPayoutTable() {
        try {
            royalFlush = Long.parseLong(royal_flush_text_field.getText());
            straightFlush = Long.parseLong(straight_flush_text_field.getText());
            fourOfAKindAces = Long.parseLong(four_of_a_kind_aces_text_field.getText());
            fullHouse = Long.parseLong(full_house_text_field.getText());
            flush = Long.parseLong(flush_text_field.getText());
            straight = Long.parseLong(straight_text_field.getText());
            threeOfAKind = Long.parseLong(three_of_a_kind_text_field.getText());
            twoPair = Long.parseLong(two_pair_text_field.getText());
            pairJacksOrBetter = Long.parseLong(pair_jacks_or_better_text_field.getText());

        } catch (NumberFormatException e){
            //Show a dialog stating the user must enter integers only
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("Sorry partner, you can only enter integers into the payout table\n")).
                    alignment(Pos.CENTER).padding(new Insets(5)).build()));
            dialogStage.show();
        }

        return new PayoutTable(royalFlush, straightFlush, fourOfAKindAces, fullHouse, flush, straight, threeOfAKind, twoPair, pairJacksOrBetter);
    }

    /**
     * Notifies the controller that the View needs a new hand
     */
    private void drawNewHand() {
        controller.getNewHandOfCards();
    }

    private static void log(String message){
        System.out.println("VIEW: " + message);
    }

}

