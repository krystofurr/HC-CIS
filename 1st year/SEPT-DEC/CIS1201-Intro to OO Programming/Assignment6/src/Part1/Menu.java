package Part1;



/*
 * CIS1201: INTRO TO OBJECT ORIENTED PROGRAMMING
 * *************************************************
 * AUTHOR: Christopher Sigouin
 * DATE: Nov 19, 2014
 * PURPOSE:
 * DEPENDENCIES: 
 */





import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * Class to generate a GUI based menu.  Each option entered will be provided a
 * integer value starting at '1' so all choices are integer based only.
 * Once the option is picked by the user, the class
 * can determine what the return value is by the menuReturnValues. 
 * 
 * @author Christopher Sigouin
 * @since 1-Nov-2014
 */
public class Menu {

    /*
           ==========   ATTRIBUTES / FIELDS   ==========
    */
    public final static int INPUT_TYPE_STRING = 0;
    public final static int INPUT_TYPE_INT = 1;
    
    private int menuType; // Type of Menu [ 0 - CONSOLE , 1 - GUI ]
    private String menuHeading; // Menu Heading or Title
    private int numberOfOptions; // The number of options in the menu
    private String[] menuOptions; // The array that holds the options in String format
    private String[] menuReturnValues; // The array that holds the return values of the options
    private String returnType; // Determines whether return values are int based [ false ] or String based [ true ]
    Scanner input;
    
    private int inputType;
    private String menuOption;
    private String simpleMenuChoice;
    
    /**
    * 
    * Creates a simple menu object taking into account the following:
    * 
    *   menuType  - 0 = Console Based, 1 = GUI Based
    *   inputType - 0 = Expect String Input, 1 = Expect Integer Input
    *   menuOption - String to show in the menu option
    *   
    *   Make sure to run 'runSimpleMenu()' when using this constructor for the instance
    * 
    * @param menuType
    * @author Christopher Sigouin
    * @param inputType
    * @param menuOption
    * @since 1-Nov-2014
    */
    public Menu( int menuType, int inputType, String menuOption ) {
        
        this.menuType = menuType;
        this.inputType = inputType;
        this.menuOption = menuOption;
        
    }
    
    public String runSimpleMenu() {
      
        if( menuType == 0 ) {
            input = new Scanner(System.in);
            System.out.print(menuOption);
            if( inputType == INPUT_TYPE_STRING ) {
                simpleMenuChoice = input.next();
                return simpleMenuChoice;
            } else if ( inputType == INPUT_TYPE_INT ) {
                simpleMenuChoice = "" + input.nextInt();
                return simpleMenuChoice;
            } else {
                System.out.println("MENU CLASS / Constructor Simple CONSOLE : ERROR");
                return "" + 0;
            }
                
        } else if( menuType == 1 ) {
            simpleMenuChoice = JOptionPane.showInputDialog(menuOption);
            return simpleMenuChoice;
        } else {
            System.out.println("MENU CLASS / Constructor Simple : ERROR");
            return "" + 0;
        }
    }
    /**
    * 
    * Creates a " NUMBERED " menu object taking into account the following:
    * 
    *   menuType  - 0 = Console Based, 1 = GUI Based
    *   menuHeading - Single String
    *   menuOptions - Array of Strings
    *   returnType = "string" means return values are STRING based. "int" means return values are INTEGER based
    *   ( NOTE:  you will still have to parse the return value to integer if you need it as INT )
    * 
    * @param menuType
    * @author Christopher Sigouin
    * @param menuHeading
    * @param menuOptions
    * @param returnType
    * @since 1-Nov-2014
    */
    public Menu(int menuType, String menuHeading, String[] menuOptions, String returnType) {
	   
	this.menuType = menuType; // Set the menu type to be console or GUI
        this.menuHeading = menuHeading; // Set the Menu Heading
        numberOfOptions = menuOptions.length; // Set the number of menu options
        setMenuOptions(menuOptions); // Set the options into the menu
        
        menuReturnValues = new String[numberOfOptions];

        this.returnType = returnType;
        if( returnType.equals("string") )
            setMenuReturnValues(menuOptions);
        else if( returnType.equals("int") )
            setMenuReturnValuesInt(menuOptions);
        else
            System.out.println("MENU CLASS / Constructor [ Simple Menu ] : ERROR");
        
    }
    
    
   
    /*
            ==========   METHODS   ==========
    */
    

    /**
     * 
     * Puts together a menu based on the attribute values and returns a string for
     * the menu output to use.
     *   
     * @since 11012014
     * @author Christopher Sigouin
     */
    
    public String createSimpleMenu() {
    
        String menuText = menuOption + System.lineSeparator();
        return "";
        
    }
    
//    public String runSimpleMenu() {
//        
//        // If the menuType is CONSOLE based
//	if( menuType == TextBasedGame.CONSOLE_VERSION ) {
//            
//            input = new Scanner(System.in);
//            System.out.print(createMenu() + System.lineSeparator() + "Your choice?: ");
//            
//            menuReturnValues[0] = input.next();
//            return menuReturnValues[0];
//          
//          
//        // If the menuType is GUI based
//        } else if( menuType == TextBasedGame.GUI_VERSION ) {
//            int choice = Integer.parseInt(JOptionPane.showInputDialog(createMenu()));
// 
//            return menuReturnValues[(choice-1)];
//            
//        // If there is another value entered in error
//        } else {
//            System.out.println("No menu generated.  There was an invalid option");
//            return "" + 0;
//        }
//        
//    }
    
    public String createMenu() {
        
        String menuText = "" + menuHeading + System.lineSeparator();
        
        for(int i = 0; i < numberOfOptions; i++) {
            
            menuText += "(" + (i+1) + ") - " + menuOptions[i] + System.lineSeparator();
                        
        }
        
        return menuText;
    }
    
    /**
     * 
     * Generates a GUI Menu based on the attribute values provided in the object
     * created
     *  
     * @return 
     * @since 11012014
     * @author Christopher Sigouin
     */
    public String runMenu() {
    
        // If the menuType is CONSOLE based
	if( menuType == 0 ) {
            
            input = new Scanner(System.in);
            System.out.print(createMenu() + System.lineSeparator() + "Your choice?: ");
            
            int choice = input.nextInt();
            return menuReturnValues[(choice-1)];
          
          
        // If the menuType is GUI based
        } else if( menuType == 1 ) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(createMenu()));
 
            return menuReturnValues[(choice-1)];
            
        // If there is another value entered in error
        } else {
            System.out.println("No menu generated.  There was an invalid option");
            return "" + 0;
        }	
    }
    
    public String getMenuHeading() {
        return menuHeading;
    }

    public void setMenuHeading(String menuHeading) {
        this.menuHeading = menuHeading;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public void setNumberOfOptions(int numberOfOptions) {
        this.numberOfOptions = numberOfOptions;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String[] getMenuReturnValues() {
        return menuReturnValues;
    }

    public void setMenuReturnValues(String[] menuReturnValues) {
        this.menuReturnValues = menuReturnValues;
    }
    
    public void setMenuReturnValuesInt(String[] menuReturnValues) {
   
        for( int i = 0; i < menuReturnValues.length; i++ ) {
            this.menuReturnValues[i] = "" + (i + 1);
        }
        
    }
    
}
