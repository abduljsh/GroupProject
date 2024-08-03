/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author shahn
 */
public class BlackJack {
    public static void main(String[] args) {
        System.out.println("Starting BlackJack Game...");
        
        BlackJackGame game = new BlackJackGame("BlackJack");
        BlackJackPlayer player1 = new BlackJackPlayer("Player 1");
        game.getPlayers().add(player1);
        
        System.out.println("Added Player 1 to the game.");
        game.play();
        
        System.out.println("Game play finished.");
    }
}
