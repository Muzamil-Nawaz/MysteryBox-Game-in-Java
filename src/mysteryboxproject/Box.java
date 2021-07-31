/* 
Class Name :Box
Decription : It represents a single mystery box in game having label and value.
Unit :NIT2112 Object Oriented Programming
Assignment Name : Mystery Box Game
Name : Ahmed
Student Id :4581835
*/
package mysteryboxproject;
public class Box {
    int label;
    int value;
    // constructor for initializing box with its value and label.
    Box(int label , int value){
        this.label = label;
        this.value = value;
    }
    // method to print info about box.
    public String toString(){
        return "[Box Number :"+this.label+",Box Value :"+this.value+"]";
    }
    
}
