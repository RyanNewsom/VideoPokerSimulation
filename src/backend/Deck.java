package backend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<>(10);

    public Deck(){
        createDeck();
    }

    public void createDeck(){
        deckOfCards = generateDeck();
    }

    public ArrayList<Card> getDeck(){
        return deckOfCards;
    }

    public Card getCard(){
        Card card = deckOfCards.get(0);
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
