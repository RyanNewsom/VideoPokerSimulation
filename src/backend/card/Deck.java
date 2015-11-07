package backend.card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of cards
 */
public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<>(10);
    private int currentCardPosition;

    public Deck(){
        createDeck();
    }

    public void createDeck(){
        deckOfCards = generateDeck();
    }

    public Card getCard(){
        if(currentCardPosition >= 52) {
            shuffleDeck();
            currentCardPosition = 0;
        }
        Card card = deckOfCards.get(currentCardPosition);
        currentCardPosition++;

        return card;
    }

    private ArrayList<Card> generateDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                if(i == 0) {
                    Card newCard = new Card(Suit.HEARTS, j);
                    newDeck.add(newCard);
                }
                else if(i == 1){
                    Card newCard = new Card(Suit.CLUBS, j);
                    newDeck.add(newCard);
                }
                else if(i == 2){
                    Card newCard = new Card(Suit.DIAMOND, j);
                    newDeck.add(newCard);
                }
                else if(i ==3){
                    Card newCard = new Card(Suit.SPADES, j);
                    newDeck.add(newCard);
                }
            }
        }

        return newDeck;
    }

    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }


}
