/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
/**
 *
 * @author shahn
 */
import java.util.Scanner;

public class BlackJackGame extends Game {
    private GroupOfCards deck;
    private Dealer dealer;
    private BlackJackPlayer player;

    public BlackJackGame(String name) {
        super(name);
        this.deck = new GroupOfCards(52);
        this.deck.shuffle();
        this.dealer = new Dealer("Dealer");
    }

    @Override
    public void play() {
        System.out.println("Starting the game...");
        player = (BlackJackPlayer) getPlayers().get(0);
        Scanner scanner = new Scanner(System.in);
        
        // Deal initial cards
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        System.out.println("Player's Hand: " + player.getHand());
        System.out.println("Dealer's Hand: " + dealer.getHand().getCards().get(0) + " [Hidden]");
        
        // Player's turn
        while (true) {
            System.out.println("Player's Hand: " + player.getHand());
            System.out.println("Hit or stand? (h/s)");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("h")) {
                player.addCard(deck.drawCard());
                if (player.getHand().calculateTotal() > 21) {
                    System.out.println("Player busts! Dealer wins.");
                    return;
                }
            } else {
                break;
            }
        }
        
        // Dealer's turn
        while (dealer.getHand().calculateTotal() < 17) {
            dealer.addCard(deck.drawCard());
        }
        
        System.out.println("Dealer's Hand: " + dealer.getHand());
        
        // Determine winner
        int playerTotal = player.getHand().calculateTotal();
        int dealerTotal = dealer.getHand().calculateTotal();
        
        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("Player wins!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

   @Override
    public void declareWinner() {
        int playerTotal = player.getHand().calculateTotal();
        int dealerTotal = dealer.getHand().calculateTotal();

        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("Player wins!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}