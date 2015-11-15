package fx;

import backend.Strategy;
import backend.card.Suit;
import backend.data.PayoutTable;
import backend.card.Card;
import backend.card.HandOfCards;
import backend.controller.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by Ryan on 10/26/2015.
 */
public class View {
    //Controller
    Controller controller = new Controller();

    //VIEWS
    @FXML private Label expected_payout;
    @FXML private TextField royal_flush_text_field;
    @FXML private TextField straight_flush_text_field;
    @FXML private TextField four_of_a_kind_aces_text_field;
    @FXML private TextField full_house_text_field;
    @FXML private TextField flush_text_field;
    @FXML private TextField straight_text_field;
    @FXML private TextField three_of_a_kind_text_field;
    @FXML private TextField two_pair_text_field;
    @FXML private TextField pair_jacks_or_better_text_field;

    @FXML public Label card_1_value;
    @FXML public Label card_1_value_copy;
    @FXML public ImageView card_1_main_suite;
    @FXML public ImageView card_1_suit;
    @FXML public ImageView card_1_suit_copy;

    @FXML public Label card_2_value;
    @FXML public Label card_2_value_copy;
    @FXML public ImageView card_2_suite_main;
    @FXML public ImageView card_2_suite;
    @FXML public ImageView card_2_suite_copy;

    @FXML public Label card_3_value;
    @FXML public Label card_3_value_copy;
    @FXML public ImageView card_3_suite_main;
    @FXML public ImageView card_3_suite;
    @FXML public ImageView card_3_suite_copy;

    @FXML public Label card_4_value;
    @FXML public Label card_4_value_copy;
    @FXML public ImageView card_4_suite_main;
    @FXML public ImageView card_4_suit;
    @FXML public ImageView card_4_suite_copy;

    @FXML public Label card_5_value;
    @FXML public Label card_5_value_copy;
    @FXML public ImageView card_5_suite_main;
    @FXML public ImageView card_5_suite;
    @FXML public ImageView card_5_suite_copy;

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
    private HandOfCards currentHand;
    private ArrayList<Card> cards = new ArrayList<>(5);



    @FXML
    protected void determineExpectedPayoutButtonClick(MouseEvent me){
        determineExpectedPayout();
    }

    @FXML
    protected void drawNewCardsButtonClick(MouseEvent event) {
        getNewHand();
    }

    /**
     * Determines expected payout, updates UI
     */
    private void determineExpectedPayout() {
        PayoutTable payoutTable = createPayoutTable();
        Strategy optimalStrategy = controller.determineExpectedPayout(payoutTable);
        applyOptimalStrategy(optimalStrategy);
        expected_payout.setText("" + optimalStrategy.getExpectedPayout());
    }

    /**
     * This method will take the optimal strategy and apply it to the gui
     */
    private void applyOptimalStrategy(Strategy optimalStrategy) {
        //These are the cards to hold onto
        ArrayList cardsToHold = optimalStrategy.getCardsToHoldOnto();
        for(int i = 0; i < cardsToHold.size(); i++){
            //if the index contains true, make that card have the bullet hole through it
            if(cardsToHold.get(i) == true){
                holdCard(i);
            }
        }

    }

    /**
     * This will add the bullet hold to the card at the corresponding index to represent it is meant to be held
     * @param i - the card to be held
     */
    private void holdCard(int i) {
        Image image = new Image(getClass().getResource("bullethole.png").toExternalForm());
        i++;// 1-5
        if(i == 1){
            card_1_main_suite.setImage(image);
        } else if(i == 2){
            card_2_suite_main.setImage(image);
        } else if(i ==3){
            card_3_suite_main.setImage(image);
        } else if(i == 4){
            card_4_suite_main.setImage(image);
        } else if(i==5){
            card_5_suite_main.setImage(image);
        }
         else{
            log("error, holdCard method received an in-valid integer");
        }
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
    private void getNewHand() {
        HandOfCards handOfCards = controller.getNewHandOfCards();
        currentHand = handOfCards;
        cards.clear();
        log("updateCurrentHand has been called");
        for(int i = 0; i < currentHand.getHandOfCards().size(); i++){
            Card currentCard = currentHand.getCard(i);
            cards.add(currentCard);
            log("Card " + (i + 1) + " suite: " + currentCard.getSuit() + " Value: " + currentCard.getValue() );
        }
        drawNewHand();
    }

    /**
     * Set's up the hand to be drawn
     */
    private void drawNewHand() {
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);
        Card card4 = cards.get(3);
        Card card5 = cards.get(4);

        drawCard(1, card1);
        drawCard(2, card2);
        drawCard(3, card3);
        drawCard(4, card4);
        drawCard(5, card5);

    }

    /**
     * Draws a card
     * @param position - the position of the card in the hand
     * @param card - the card to be drawn
     */
    private void drawCard(int position, Card card) {
        Image image = new Image(getClass().getResource(card.getSuit().toString() + ".png").toExternalForm());
        String value = "" + card.getValue();
        if(value.equals("10"))
            value = "J";
        if(value.equals("11"))
            value = "Q";
        if(value.equals("12"))
            value = "K";
        if(value.equals("0"))
            value = "A";

        if(position == 1){
            card1 = card;
            card_1_main_suite.setImage(image);
            card_1_suit.setImage(image);
            card_1_suit_copy.setImage(image);
            card_1_value.setText(value);
            card_1_value_copy.setText(value);
        }

        if(position == 2){
            card2 = card;
            card_2_suite_main.setImage(image);
            card_2_suite.setImage(image);
            card_2_suite_copy.setImage(image);
            card_2_value.setText(value);
            card_2_value_copy.setText(value);
        }

        if(position == 3){
            card3 = card;
            card_3_suite_main.setImage(image);
            card_3_suite.setImage(image);
            card_3_suite_copy.setImage(image);
            card_3_value.setText(value);
            card_3_value_copy.setText(value);
        }

        if(position == 4){
            card4 = card;
            card_4_suite_main.setImage(image);
            card_4_suit.setImage(image);
            card_4_suite_copy.setImage(image);
            card_4_value.setText(value);
            card_4_value_copy.setText(value);
        }

        if(position == 5){
            card5 = card;
            card_5_suite_main.setImage(image);
            card_5_suite.setImage(image);
            card_5_suite_copy.setImage(image);
            card_5_value.setText(value);
            card_5_value_copy.setText(value);
        }
    }

    private static void log(String message){
        System.out.println("VIEW: " + message);
    }

}

