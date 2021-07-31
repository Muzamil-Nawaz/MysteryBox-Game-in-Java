/* 
Class Name :Player
Decription : It represents a Player in game having option to chose a box for him.
Unit :NIT2112 Object Oriented Programming
Assignment Name : Mystery Box Game
Name : Ahmed
Student Id :4581835
*/
package mysteryboxproject;
public class Player {
    private static  Box pickedBox;
    public Player(){
        
    }
    // method for initializing value for box picked by player.
    public  void setPickedBox(Box b){
        pickedBox = b;
    }
    // method for getting value of box picked by player.
    public int getBoxValue(){
        return this.pickedBox.value;
    }
    
}
