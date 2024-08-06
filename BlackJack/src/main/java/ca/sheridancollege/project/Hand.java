/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
* @author shahaana
 * @author drishya
 * @author alvy
 * @author aarushi
 */
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int calculateTotal() {
        int total = 0;
        int aces = 0;
        for (Card card : cards) {
            String rank = ((PlayingCard) card).getRank();
            switch (rank) {
                case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "10":
                    total += Integer.parseInt(rank);
                    break;
                case "Jack": case "Queen": case "King":
                    total += 10;
                    break;
                case "Ace":
                    aces++;
                    total += 11;
                    break;
            }
        }
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
