/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 17-Feb-2015
 * PROJECT NAME: Assignment 4
 * DEPENDENCIES: Login.java, Menu.java
 */


public class Assignment4 {
 
    private final static String TEXT_LOGIN_MENU = "(1)Load\n(2)Login\n(3)Show\n(4)Exit\nPlease enter your choice: ";
    private final static int QUIT_VALUE = 4;
    private static Menu loginMenu = new Menu("console", TEXT_LOGIN_MENU );
    static String[] userNameArray = {"John", "Steve", "Bonnie", "Kylie", "Logan", "Robert"};
    static String[] passwordArray = {"1111", "2222", "3333", "4444", "5555", "6666"};
    
    public static void main(String[] args){
        
        Login aLogin = new Login();
        int menuChoice = 0;
        
        do {
            menuChoice = Integer.parseInt(loginMenu.runMenu());
            
            switch( menuChoice ) {
                
                case 1: // Load
                    aLogin.loadCredentials(userNameArray, passwordArray);
                    break;
                case 2: // Login
                    aLogin.login();
                    break;
                case 3: // Show
                    aLogin.displayLoginAttempts();
                    break;
                case 4: // Exit
                    System.out.println("You will now exit the program!");
                    break;
                default: // Anything else
                    System.out.println("Invalid option. Please re-enter");
                    break;
            }
            
        } while( menuChoice != QUIT_VALUE );
 
    }
}

//**************************************************************************************
        // Create a class called Login which contains a HashMap as a private attribute.  
        // It should also have an instance method called loadCredentials which acccepts 
        // the two arrays.  It will load the HashMap values based on the two arrays above.  
        // The userNames should be the keys and the passwords the values.  
        //**************************************************************************************
        
        //**************************************************************************************
        // Create a login method in the Login class.  This method will prompt the user
        // for a username and password. It will then display "Successful login"  or "Login failed".
        //
        // In the Login class, create an ArrayList instance attribute called loginAttempts.  
        // Each time the user attempts to login.  Add a new entry to the loginAttempts.  This entry 
        // should be a String which contains the username+"/"+password+"/"+ either true or false 
        // based on whether or not the login was successful.
        //**************************************************************************************
        
        //**************************************************************************************
        //Create a main menu in this main method. The menu should prompt the user to enter 
        //Load:   load the users which will invoke the loadCredentials method.
        //Login:  Invoke the login method created above. 
        //Show:   Invoke all login attempts from the ArrayList in the Login class
        //Exit:   Exit the program
        //**************************************************************************************