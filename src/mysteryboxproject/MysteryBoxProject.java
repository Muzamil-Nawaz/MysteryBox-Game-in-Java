/* 
Class Name :MysteryBoxProject
Decription : It is main class in part 1 of game which is responsible for runtime of game and gets input from user and print winner too.
Unit :NIT2112 Object Oriented Programming
Assignment Name : Mystery Box Game
Name : Ahmed
Student Id :4581835
*/
package mysteryboxproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class MysteryBoxProject {
    // a list for storing boxes.
    public static ArrayList<Box> boxlist;
    Player p;
    // constructor to initialize list and to play the game.
    MysteryBoxProject(){
        boxlist = new ArrayList<>();
        //loading instances of boxes in list.
        loadBoxes();
        Scanner sc = new Scanner(System.in);
        p = new Player();
        System.out.println("******* Welcome to Mystery Box Game *******)");
        System.out.print("Please select a box :");
        int choice = sc.nextInt();
        if(choice >4)
            choice =4;
        p.setPickedBox(boxlist.get(choice-1));
        System.out.println("\nPlayer has chosen box "+choice+" with value "+p.getBoxValue());
        System.out.println();
        int remainingAmount = printBankerSum(choice);
        if(remainingAmount>p.getBoxValue()){
            System.out.println("\nThe banker wins the game. ");
        }
        else if(remainingAmount<p.getBoxValue())
            System.out.println("\nPlayer wins the game.");
        
    }
    public static void main(String[] args) {
        // Initailazing class to run the constructor
        MysteryBoxProject demo = new MysteryBoxProject();
    
    }
    // method for loading boxes in boxlist with random values every time.
    public void loadBoxes(){
        int [] values = {20,50,100,200};
        String s="";
        Random r = new Random();
        for (int j = 0; j < 4; j++) {
            int ind = r.nextInt(4);
            while(s.contains(Integer.toString(ind))){
                ind = r.nextInt(4);
            }
            s+=Integer.toString(ind);
            Box b= new Box(j+1,values[ind]);
            boxlist.add(b);
        }
    }
    // method for getting choice of playaer as argument and retuning sum of amount banker has within other remaining boxes.
    public static int printBankerSum(int a){
        int sum=0;
        for (int i = 0; i < boxlist.size(); i++) {
            // performing with a-1 because boxes are numbered 1-4 whether they are present in list at 0-3 indexes.
            if(i!=(a-1)){
                sum+=boxlist.get(i).value;
            }
        }
        System.out.println("The Banker has "+sum);
        for (int i = 0; i < boxlist.size(); i++) {
            if(i!=(a-1)){
                System.out.println("Box "+(i+1)+" has value "+boxlist.get(i).value);
            }
        }
        return sum;
    }
}
