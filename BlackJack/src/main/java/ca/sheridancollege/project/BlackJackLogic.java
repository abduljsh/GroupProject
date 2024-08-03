/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.List;

/**
 *
 * @author shahn
 */
public class BlackJackLogic {

    public boolean isPlayerWinner(List<PlayingCard> playerHand, List<PlayingCard> dealerHand) {
        int playerTotal = calculateTotal(playerHand);
        int dealerTotal = calculateTotal(dealerHand);
        return playerTotal > dealerTotal && playerTotal <= 21;
    }

  
    public boolean isDealerWinner(List<PlayingCard> playerHand, List<PlayingCard> dealerHand) {
        int playerTotal = calculateTotal(playerHand);
        int dealerTotal = calculateTotal(dealerHand);
        return dealerTotal > playerTotal && dealerTotal <= 21;
    }


    public boolean checkDraw(List<PlayingCard> playerHand, List<PlayingCard> dealerHand) {
        int playerTotal = calculateTotal(playerHand);
        int dealerTotal = calculateTotal(dealerHand);
        return playerTotal == dealerTotal && playerTotal <= 21;
    }

    private int calculateTotal(List<PlayingCard> hand) {
        int total = 0;
        int aces = 0;

        for (PlayingCard card : hand) {
            String rank = card.getRank();
            switch (rank) {
                case "J":
                case "Q":
                case "K":
                    total += 10;
                    break;
                case "A":
                    aces++;
                    total += 11;
                    break;
                default:
                    total += Integer.parseInt(rank); 
                    break;
            }
        }
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }
}