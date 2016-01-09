
import java.util.ArrayList;
import java.util.HashMap;

/*
 *  *** CIS-1232 Intermediate OOP ***
 * 
 * NAME: Christopher Sigouin
 * DATE: 20-Feb-2015
 * PROJECT NAME: Assignment 4
 * DEPENDENCIES: Menu.java, Util.java
 */

/**
 *
 *  Login class holds attributes and methods pertaining to the functionality
 *  of a basic login system
 *
 * @author Christopher Sigouin
 * @since 20-Feb-2015
 */
public class Login {

    public final static String TAB = "\t";
    private ArrayList<String> loginAttempts;
    private HashMap<String, String> aHashMap;
    private Menu userMenu, passwordMenu;
    private boolean validLogin;
    
    
    public Login() {
        userMenu = new Menu("console", "Please enter your username: ");
        passwordMenu = new Menu("console", "Please enter your password: ");
        loginAttempts = new ArrayList<>();
        aHashMap = new HashMap<>();
    }
    
    public void loadCredentials(String[] usernames, String[] passwords ) {
        for(int i = 0; i < usernames.length; ++i ) {
            aHashMap.put(usernames[i], passwords[i]);
        }
        System.out.println("Called loadCredentials()");
        
    }
    
    public void login() {
        String usernameChoice, passwordChoice;
        
        if(Util.DEBUG) {
            for(String key : aHashMap.keySet()) {
                System.out.print("key: " + key + " value: " + aHashMap.get(key));
                System.out.print(System.lineSeparator());
            }
        } 
        
        // Check to see if the HashMap has even been loaded, otherwise you will be stuck here for awhile
        if( aHashMap.isEmpty() )
            System.out.println("You need to load the credentials first! Please choose option 1");
        else {
            do {

                validLogin = false;
                usernameChoice = userMenu.runMenu();
                passwordChoice = passwordMenu.runMenu();

                for(String key : aHashMap.keySet()) {
                    if( key.equals(usernameChoice)) {
                        if( aHashMap.get(key).equals(passwordChoice)) {
                            validLogin = true;
                            System.out.println("Congrads! Your logged in!");
                            break;
                        }
                    }
                }

                // The system should not state whether the username or password is invalid.  Security risk.  Just give error.
                if( !validLogin ) {
                    System.out.println("Failed to login.  Invalid Username and/or Password");
                }

                // Add entry to loginAttempts
                loginAttempts.add("USERNAME: " + usernameChoice + " PASSWORD: " + passwordChoice + " VALID LOGIN: " + validLogin);

            } while ( !validLogin );
        } // END: if( aHashMap.isEmpty() ) 
        
    } // END: login()
    
    public void displayLoginAttempts() {
        System.out.println("Login Attempts:");
        for(String attempt : loginAttempts) {
            System.out.println(attempt);
        }
    }

}

