/*
 *     NAME: Christopher Sigouin
 *     DATE: 30-Oct-2014
 *     PURPOSE: Assignment 4
 *     DEPENDENCIES: FurnitureTest3.java , Menu.java
 *     
 *     This code is copyright by Christopher Sigouin.  
 *     If you use it, be prepared to lose it! Mwahahahah ;)
 */

package menuObjectTest;

/**
 *
 * @author Christopher Sigouin
 * @since 30-Oct-2014
 */
public class Order2 {

    /*
           ==========   ATTRIBUTES / FIELDS   ==========
    */

    
    public final static float PINE_TABLE_COST = 100.0f;
    public final static float OAK_TABLE_COST = 225.0f;
    public final static float MAHOGANY_TABLE_COST = 310.0f;
    public final static float LARGE_TABLE_EXTRA_COST = 35.0f;
    public final static float SMALL_TABLE_EXTRA_COST = 0.0f;
    
    private String woodType; // Material used to make furniture
    private float price; // Cost of furniture
    private String size = ""; // Size of the Furniture
    

    /**
    * Default Constructor
    *
    * @param woodType
    * @author Christopher Sigouin
    * @since 30-Oct-2014
    */
    public Order2(String woodType) {
        this.woodType = woodType;
    }

    /*
            ==========   METHODS   ==========
    */

    /**
     * 
     * 
     * 
     * @since 10312014
     * @author Christopher Sigouin
     */
    @Override
    public String toString () {
        return "ORDER PLACED" + System.lineSeparator() +
               "========================" + System.lineSeparator() +
               "WoodType: " + woodType + System.lineSeparator() +
               "Price: $" + price;
    } 
    
    /**
     * 
     *  Sets the price of the order based on the woodtype if set.
     *  Also determines if a size was chosen.  If there was a large
     *  size then it will add the additional large cost. If there is 
     *  no woodType set, then there is no order and the price is set
     *  to 0.
     *  
     * 
     * @since 10312014
     * @author Christopher Sigouin
     */
    public void setPriceNewOrder() {
        
        if( woodType.equals("Pine") ) {
            price = PINE_TABLE_COST;
            if ( size.equals("large") ) {
                System.out.println("pine added");
                price += LARGE_TABLE_EXTRA_COST;
            } else {
                price += SMALL_TABLE_EXTRA_COST;
            }
        }
            
        else if ( woodType.equals("Oak") ) {
            price = OAK_TABLE_COST;
            if ( size.equals("large") ) {
                System.out.println("oak added");
                price += LARGE_TABLE_EXTRA_COST;
            } else {
                price += SMALL_TABLE_EXTRA_COST;
            }
        }
            
        else if ( woodType.equals("Mahogany") ) {
            price = MAHOGANY_TABLE_COST;
            if ( size.equals("large") ) {
                System.out.println("mahog added");
                price += LARGE_TABLE_EXTRA_COST;
            } else {
                price += SMALL_TABLE_EXTRA_COST;
            }
            
        } else
            price = 0;
    }
    
  
    /**
     * 
     * GETTERS AND SETTERS BELOW
     * 
     * @since 10312014
     * @author Christopher Sigouin
     */
    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public void setPrice(float price) {
  
        this.price = price;
    }
    
    public String getWoodType() {
        return woodType;
    }

    public float getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    
    
}
