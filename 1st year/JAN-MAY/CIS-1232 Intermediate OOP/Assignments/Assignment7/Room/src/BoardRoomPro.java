
import java.util.Scanner;


/**
 *
 * @author Ryan
 * @since March 23, 2014
 * 
 * This class extends the board room class by adding a few new features such as a 
 * coffee maker and a lazy boy option.
 */
public class BoardRoomPro extends BoardRoom{
    private boolean hasLazyBoy;
    private int numOfLazyBoy = 0;
    private boolean hasCoffee;
    public BoardRoomPro(int roomNumber) {
        super(roomNumber);
    }
    public String toString() {
        return super.toString() + "\nNumber of Recliners: " + numOfLazyBoy +
                "\nHas a coffee maker: " + hasCoffee;
    }
    
     /**
     * Get the details from the user about this class.  This will invoke the super method to get the 
     * base class attributes.
     */

    public void getRoomDetailsFromUser() {
        super.getRoomDetailsFromUser();
        Scanner input = new Scanner(System.in);
        System.out.println("does this room have a coffe maker? (y/n)");
        hasCoffee = input.nextLine().equalsIgnoreCase("y");
        System.out.print("Does this room have a lazy boy recliner? (y/n) ");
        hasLazyBoy = input.nextLine().equalsIgnoreCase("y");
        if(hasLazyBoy){
           System.out.println("How many Lazy Boy Recliners does it have?");
           numOfLazyBoy = input.nextInt();
        }
        
    }
    
}
