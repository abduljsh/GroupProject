/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
* @author shahaana
 * @author drishya
 * @author alvy
 * @author aarushi
 */
public class Deck extends GroupOfCards {
    public Deck() {
        super(52);
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new BlackJackCard(suit, rank));
            }
        }
        shuffle();
    }

    public BlackJackCard dealCard() {
        return (BlackJackCard) cards.remove(cards.size() - 1);
    }
}
