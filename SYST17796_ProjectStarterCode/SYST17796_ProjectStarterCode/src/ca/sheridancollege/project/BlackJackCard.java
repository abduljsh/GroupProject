/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author shahn
 */
public class BlackJackCard extends Card {
    private String suit;
    private String rank;

    public BlackJackCard(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int getValue() {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": case "J": case "Q": case "K": return 10;
            case "A": return 11; // Value of Ace can be 1 or 11, handled in game logic
            default: throw new IllegalArgumentException("Unknown card rank: " + rank);
        }
    }
}
