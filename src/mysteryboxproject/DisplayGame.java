/* 
Class Name :DisplayGame
Decription : It is main for Part 2 of game which contains a instance of GamePanel class and a JFrame to display all gui components.
Unit :NIT2112 Object Oriented Programming
Assignment Name : Mystery Box Game
Name : Ahmed
Student Id :4581835
*/
package mysteryboxproject;

import javax.swing.*;
public class DisplayGame {
    public static JFrame w1;
    public static GamePanel myGamePanel;
    public static void main(String[] args){
        w1 = new JFrame("Mystery Box Game");
        myGamePanel = new GamePanel( );
        w1.add (myGamePanel);
        w1.setSize(275, 280);
        w1.setVisible(true);
        w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } //end main
} //end class
