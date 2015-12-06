
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ryan on 11/2/2015.
 */
public class DeckTest {
    Deck testDeck;

    @Before
    public void setUp() throws Exception {
        testDeck = new Deck();
    }

    @After
    public void tearDown() throws Exception {
        testDeck = null;
    }

    @Test
    public void testCreateDeck() throws Exception {
//        ArrayList<Card> cards = testDeck.getDeck();
//        assertEquals(52, cards.size());
    }

    @Test
    public void testGetCard() throws Exception {
        Card testCard = testDeck.getCard();
        assertNotNull(testCard);
    }
}