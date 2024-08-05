package ca.sheridancollege.project;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author shahn 
 * @author shaarush
 */



public class BlackJackLogicTest {
    
    public BlackJackLogicTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isPlayerWinner method, of class BlackJackLogic.
     */
     @org.junit.jupiter.api.Test
    public void testIsPlayerWinnerGood() {
        System.out.println("Player is Winner");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "10"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "9"), new PlayingCard("Clubs", "10"));
        boolean expResult = true; // Player = 20, Dealer = 19 -> Player wins!
        boolean result = instance.isPlayerWinner(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testIsPlayerWinnerBad() {
        System.out.println("Player is not Winner");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "10"), new PlayingCard("Diamonds", "2"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "9"), new PlayingCard("Clubs", "10"));
        boolean expResult = false; // Player = 22, Dealer = 19 -> Dealer wins!
        boolean result = instance.isPlayerWinner(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testIsPlayerWinnerBoundary() {
        System.out.println("It's a tie");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "A"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "10"), new PlayingCard("Clubs", "A"));
        boolean expResult = false; // Player = 21, Dealer = 21 ->Draw Game => Player will not win
        boolean result = instance.isPlayerWinner(playerHand, dealerHand);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDealerWinner method, of class BlackJackLogic.
     */
    @org.junit.jupiter.api.Test
    public void testIsDealerWinnerGood() {
        System.out.println("Dealer is Winner");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "9"), new PlayingCard("Spades", "10"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "10"), new PlayingCard("Clubs", "10"));
        boolean expResult = true;   // Dealer = 20, Player = 19 -> Dealer wins!
        boolean result = instance.isDealerWinner(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testIsDealerWinnerBad() {
        System.out.println("Dealer is not Winner");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "9"), new PlayingCard("Spades", "10"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "10"), new PlayingCard("Clubs", "10"), new PlayingCard("Hearts", "2"));
        boolean expResult = false;  // Dealer = 22, Player = 19 -> Player wins!
        boolean result = instance.isDealerWinner(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testIsDealerWinnerBoundary() {
        System.out.println("It's a tie");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "A"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "10"), new PlayingCard("Clubs", "A"));
        boolean expResult = false;  // Dealer = 21, Player = 21 -> Draw Game => Dealer will not win
        boolean result = instance.isDealerWinner(playerHand, dealerHand);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDraw method, of class BlackJackLogic.
     */
     @org.junit.jupiter.api.Test
    public void testCheckDrawGood() {
        System.out.println("It's a tie");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "A"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "10"), new PlayingCard("Clubs", "A"));
        boolean expResult = true; // Dealer = 21, Player = 21
        boolean result = instance.checkDraw(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testCheckDrawBad() {
        System.out.println("Dealer wins");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "10"), new PlayingCard("Diamonds", "2"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "10"), new PlayingCard("Clubs", "A"));
        boolean expResult = false; // Dealer = 21, Player = 22 -> Dealer will win the game
        boolean result = instance.checkDraw(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
    
     @org.junit.jupiter.api.Test
    public void testCheckDrawBoundary() {
        System.out.println("Player wins");
        BlackJackLogic instance = new BlackJackLogic();
        List<PlayingCard> playerHand = Arrays.asList(new PlayingCard("Hearts", "10"), new PlayingCard("Spades", "10"));
        List<PlayingCard> dealerHand = Arrays.asList(new PlayingCard("Diamonds", "9"), new PlayingCard("Clubs", "10"));
        boolean expResult = false; // Dealer = 19, Player = 20 -> Player will win the game
        boolean result = instance.checkDraw(playerHand, dealerHand);
        assertEquals(expResult, result);
    }
}
