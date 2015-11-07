package tests;

import backend.Deck;
import backend.HandOfCards;
import backend.PokerMachine;
import backend.PossibleOrderingFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by Ryan on 11/4/2015.
 */
public class PossibleOrderingFactoryTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllPossibleOrderings() throws Exception {
        Deck deck = new Deck();
        deck.shuffleDeck();
//        PokerMachine machine = new PokerMachine()
//        PossibleOrderingFactory factory = new PossibleOrderingFactory()

    }
}