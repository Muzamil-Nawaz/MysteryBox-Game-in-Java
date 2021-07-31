/* 
Class Name :Gamepanel
Decription : It is class extending a JPanel to represent and initialize the components of GUI part of Game.
Unit :NIT2112 Object Oriented Programming
Assignment Name : Mystery Box Game
Name : Ahmed
Student Id :4581835
*/
package mysteryboxproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GamePanel extends JPanel{
    // button representing mystery boxes
    public static JButton box1,box2,box3,box4;
    public static JLabel label;
    public static JTextArea area;
    public static ArrayList<Box> boxlist;
    public Player p;
    GamePanel(){
        //setting panel layout as null becaue we will use set bounds method manually for our components.
        setLayout(null);
        // Initializing Buttons and Label and TextArea for the Panel.
        box1 = new JButton("Mystery Box 1");
        box2 = new JButton("Mystery Box 2");
        box3 = new JButton("Mystery Box 3");
        box4 = new JButton("Mystery Box 4");
        label = new JLabel("Click any box to commence play");
        area = new JTextArea();
        
        // Setting bounds for components of the game manually.
        box1.setBounds(05,10,120,25);
        box2.setBounds(130,10,120,25);
        box3.setBounds(05,40,120,25);
        box4.setBounds(130,40,120,25);
        label.setBounds(35,70,200,20);
        area.setBounds(25,95,230,130);
        
        // initializing player to play the game and chose the box
        p = new Player();
        // initialzing list for boxes.
        boxlist = new ArrayList<>();
        // loading boxes in box lists.
        loadBoxes();
        // adding actionListeners to mystery box1 button and performing operation as player choose box1.
        box1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // passing index for box 1 as 0.
            p.setPickedBox(boxlist.get(0));
            System.out.println("\nPlayer has chosen box 1 with value "+p.getBoxValue());
            area.setText("Player has chosen box 1 with value "+p.getBoxValue()+"\n");
            System.out.println();
            int remainingAmount = printBankerSum(0);
            if(remainingAmount>p.getBoxValue()){
            System.out.println("\nThe banker wins the game. ");
            area.setText(area.getText()+"\nThe banker wins the game.");
            }
            else if(remainingAmount<p.getBoxValue()){
            System.out.println("\nPlayer wins the game.");
            area.setText(area.getText()+"\nPlayer wins the game.");
            }
            
        }
    });
        // adding actionListeners to mystery box2 button and performing operation as player choose box2.
        box2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // passing index for box 2 as 1.
            p.setPickedBox(boxlist.get(1));
            System.out.println("\nPlayer has chosen box 1 with value "+p.getBoxValue());
            area.setText("Player has chosen box 1 with value "+p.getBoxValue()+"\n");
            System.out.println();
            int remainingAmount = printBankerSum(1);
            if(remainingAmount>p.getBoxValue()){
            System.out.println("\nThe banker wins the game. ");
            area.setText(area.getText()+"\nThe banker wins the game.");
            }
            else if(remainingAmount<p.getBoxValue()){
            System.out.println("\nPlayer wins the game.");
            area.setText(area.getText()+"\nPlayer wins the game.");
            }
            
        }
    });
        // adding actionListeners to mystery box3 button and performing operation as player choose box3.
        box3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // passing index for box 3 as 2.
            p.setPickedBox(boxlist.get(2));
            System.out.println("\nPlayer has chosen box 1 with value "+p.getBoxValue());
            area.setText("Player has chosen box 1 with value "+p.getBoxValue()+"\n");
            System.out.println();
            int remainingAmount = printBankerSum(2);
            if(remainingAmount>p.getBoxValue()){
            System.out.println("\nThe banker wins the game. ");
            area.setText(area.getText()+"\nThe banker wins the game.");
            }
            else if(remainingAmount<p.getBoxValue()){
            System.out.println("\nPlayer wins the game.");
            area.setText(area.getText()+"\nPlayer wins the game.");
            }
            
        }
    });
        // adding actionListeners to mystery box4 button and performing operation as player choose box4.
        box4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            // passing index for box 4 as 3.
            p.setPickedBox(boxlist.get(3));
            System.out.println("\nPlayer has chosen box 1 with value "+p.getBoxValue());
            area.setText("Player has chosen box 1 with value "+p.getBoxValue()+"\n");
            System.out.println();
            int remainingAmount = printBankerSum(3);
            if(remainingAmount>p.getBoxValue()){
            System.out.println("\nThe banker wins the game. ");
            area.setText(area.getText()+"\nThe banker wins the game.");
            }
            else if(remainingAmount<p.getBoxValue()){
            System.out.println("\nPlayer wins the game.");
            area.setText(area.getText()+"\nPlayer wins the game.");
            }
            
        }
    });
        
        // adding comonents to game panel.
        add(box1);
        add(box2);
        add(box3);
        add(box4);
        add(label);
        add(area);
    }
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
    public static int printBankerSum(int a){
        int sum=0;
        
        for (int i = 0; i < boxlist.size(); i++) {
            if(i!=(a)){
                sum+=boxlist.get(i).value;
            }
        }
        System.out.println("The Banker has "+sum);
        area.setText(area.getText()+"\nThe banker has "+sum+"\n");
        for (int i = 0; i < boxlist.size(); i++) {
            if(i!=(a)){
                System.out.println("Box "+(i+1)+" has value "+boxlist.get(i).value);
                area.setText(area.getText()+"Box "+(i+1)+" has value "+boxlist.get(i).value+"\n");
                
            }
        }
        return sum;
    }
    
}
