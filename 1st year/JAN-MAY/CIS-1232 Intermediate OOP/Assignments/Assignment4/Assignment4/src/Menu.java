/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 11-Feb-2015
 * PROJECT NAME: Practical 1
 * DEPENDENCIES:
 */




import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 *  // MENU CLASS
 *
 * @author Christopher Sigouin
 * @since 6-Feb-2015
 */
public class Menu {
    
    public final static String MENU_CONSOLE = "console";
    public final static String MENU_GUI = "gui";
    Scanner input;
    String menuType;
    String menuText;
    
    public Menu(String menuType, String menuText) {
 
        if( menuType.equalsIgnoreCase(MENU_CONSOLE)) {
            input = new Scanner(System.in);
        }
        
        this.menuType = menuType;
        this.menuText = menuText;
    }
    
    public String runMenu() {
        String choice = "";
        
        if( menuType.equalsIgnoreCase(MENU_GUI)) {
            choice = JOptionPane.showInputDialog(menuText);
        
        } else if( menuType.equalsIgnoreCase(MENU_CONSOLE)) {   
            System.out.print(menuText);
            choice = input.nextLine();
        } else {
            choice = "Wrong menu type.  Please check your menu type";
        }
        
        return choice;
    }
    
    

    public String getMenuType() {
        return menuType;
    }

    public String getMenuText() {
        return menuText;
    }
    
    

}
