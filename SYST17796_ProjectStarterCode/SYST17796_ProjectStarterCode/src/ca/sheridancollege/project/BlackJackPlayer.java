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
public class BlackJackPlayer extends Player {
    private Hand hand;

    public BlackJackPlayer(String name) {
        super(name);
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    @Override
    public void play() {
        // The logic for the player's turn will be handled in the BlackJackGame class
    }
}


