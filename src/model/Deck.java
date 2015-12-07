package model;

import model.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck composed of 52 cards
 */
public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<>(52);
    private int currentCardPosition;

    /**
     * Creates a new deck of cards
     */
    public Deck(){
        createDeck();
    }

    /**
     * Returns the next card in the deck
     * @return - the next card in the deck
     */
    public Card getCard(){
        if(currentCardPosition >= 52) {
            shuffleDeck();
            currentCardPosition = 0;
        }
        Card card = deckOfCards.get(currentCardPosition);
        currentCardPosition++;

        return card;
    }

    /**
     * Gets an array list of the cards in the deck
     * @return - the cards that compose the deck
     */
    public ArrayList<Card> getCards(){
        return deckOfCards;
    }

    /**
     * Sets the card in the deck, useful to remove a hand from the deck
     * @param cards - the new cards that will compose the deck
     */
    public void setDeckOfCards(ArrayList<Card> cards){
        deckOfCards = cards;
    }

    private void createDeck(){
        deckOfCards = generateDeck();
        shuffleDeck();
    }

    /**
     * Shuffles the cards within the deck
     */
    private void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    /**
     * Creates a deck of cards
     * @return - a un-shuffled set of cards
     */
    private ArrayList<Card> generateDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            for(int j = 2; j <= 14; j++){
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
}
