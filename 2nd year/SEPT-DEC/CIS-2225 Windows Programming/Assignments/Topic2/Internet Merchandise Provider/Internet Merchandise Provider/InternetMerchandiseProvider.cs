/*
    Program name: Internet Merchandise Provider ( Chapter 5 Exercise #5 )
    Author: Christopher Sigouin
    Version: 1
    Description: To calcuate shipping costs based on the number of items entered
    Dependencies: N/A
    Database file: N/A
    Change History: 2015.09.18 Original version by CJS

*/

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/**
 *
 * 
    TOPIC 2 ASSIGNMENT - EXERCISE #5

    Large Internet merchandise provider determines its shipping charges based on
    the number of items purchased. As the number increases, the shipping charges
    proportionally decrease. This is done to encourage more purchases. If a single
    item is purchased the shipping charge is $2.99. When customers purchase
    between 2 and 5 items, they are charged the initial $2.99 for the first item and
    then $1.99 per item for the remaining items. For customers who purchase more
    than 5 items but less than 15, they are charged the initial $2.99 for the first item,
    $1.99 per item for items 2 through 5, and $1.49 per item for the remaining items.
    If they purchase 15 or more items, they are charged the initial $2.99 for the first
    item, $1.99 per item for items 2 through 5, and $1.49 per item for items 6
    through 14 and then just $0.99 per item for the remaining items. Allow the user
    to enter the number of items purchased. Display the shipping charges.
 
    TEST DATA

    one item = 2.99
    5 items = 2.99 + ( 1.99 * 4 ) = 10.95
    10 items = 2.99 + ( 1.99 * 4 ) + ( 1.49 * 5 ) = 18.4
    20 items = 2.99 + ( 1.99 * 4 ) + ( 1.49 * 9 ) + ( .99 * 6) = 30.3
 * 
 * 
*/
namespace Internet_Merchandise_Provider
{
    public partial class InternetMerchandiseProvider : Form
    {

        // CONSTANTS USED
        const decimal SHIPPING_CHARGE_SINGLE = 2.99m;
        const decimal SHIPPING_CHARGE_2_TO_5 = 1.99m;
        const decimal SHIPPING_CHARGE_6_TO_15 = 1.49m;
        const decimal SHIPPING_CHARGE_MORE_THAN_15 = .99m;
        const decimal SHIPPING_CHARGE_2_TO_5_MAX = SHIPPING_CHARGE_2_TO_5 * 4;
        const decimal SHIPPING_CHARGE_6_TO_15_MAX = SHIPPING_CHARGE_6_TO_15 * 9;

        // VARIABLES
        private int numberOfItems;
        private decimal totalShippingCharge;
        private bool items_one, items_2_to_5, items_6_to_14, items_more_than_15 = false;
 
        public InternetMerchandiseProvider()
        {
 
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        /*
            Function name: buttonCalculate_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Captures the number of items entered.  Utilizes that value with some decision 
                         logic to calculate the correct shipping charges based on the number of items.
            Inputs: Parameters - object sender, EventArgs e / Text box field 'numberOfItems'
            Outputs: Text box field ' txBxShippingCharges ' shows dollar amount after calculation
            Return value: N/A
            Change History: 2015.09.18 Original version by CJS

        */
        private void buttonCalculate_Click(object sender, EventArgs e)
        {
            // Capture the number of items entered into the form
            try
            {
                numberOfItems = Int32.Parse(txBxNumberOfItems.Text);
           

            // Setup boolean values based on number of items.
            items_one = (numberOfItems == 1);
            items_2_to_5 = (numberOfItems >= 2 && numberOfItems <= 5); 
            items_6_to_14 = (numberOfItems >= 6 && numberOfItems <= 14); 
            items_more_than_15 = (numberOfItems >= 15);

            // Decision logic to determine shipping cost
            if (items_one)
            {
                totalShippingCharge = SHIPPING_CHARGE_SINGLE;
            }
            else if (items_2_to_5)
            {
                totalShippingCharge = SHIPPING_CHARGE_SINGLE + (findRemainingItems(numberOfItems) * SHIPPING_CHARGE_2_TO_5);
            }
            else if (items_6_to_14)
            {
                totalShippingCharge = SHIPPING_CHARGE_SINGLE + SHIPPING_CHARGE_2_TO_5_MAX +
                       (findRemainingItems(numberOfItems) * SHIPPING_CHARGE_6_TO_15);
            }
            else if (items_more_than_15)
            {
                totalShippingCharge = SHIPPING_CHARGE_SINGLE + SHIPPING_CHARGE_2_TO_5_MAX +
                       SHIPPING_CHARGE_6_TO_15_MAX + (findRemainingItems(numberOfItems) * SHIPPING_CHARGE_MORE_THAN_15);
            }
            else
            {
                totalShippingCharge = 0;
            }

            // Output the totalShippingCharge to txBxShippingCharges as a dollar amount
            txBxShippingCharges.Text = totalShippingCharge.ToString("C");

            }
            catch
            {
                MessageBox.Show("Please enter a valid integer");
            }
        }

        /*
           Function name: findRemainingItems
           Version: 1
           Author: Christopher Sigouin
           Description: Accepts the number of items.  Based on that value and decision logic, the 
                        function will return the correct number of items left over with a set range
           Inputs: numberOfItems
           Outputs: returnValue
           Return value: INT
           Change History: 2015.09.18 Original version by CJS

       */
        private int findRemainingItems(int numberOfItems)
        {
            int returnValue;

            if (items_one) {
		        returnValue = numberOfItems;
	        } else if (items_2_to_5) {
		        returnValue = numberOfItems - 1;
	        } else if (items_6_to_14) {
		        returnValue = numberOfItems - 5;
	        } else if (items_more_than_15) {
		        returnValue = numberOfItems - 14;
            } else {
                returnValue = 0;
            }

            return returnValue;
        }

        /*
           Function name: buttonClear_Click
           Version: 1
           Author: Christopher Sigouin
           Description: Allows a button to clear both text fields ( txBxNumberOfItems, txBxShippingCharges )
           Inputs: object sender, EventArgs e
           Outputs: N/A
           Return value: N/A
           Change History: 2015.09.18 Original version by CJS

       */
        private void buttonClear_Click(object sender, EventArgs e)
        {
            txBxNumberOfItems.Clear();
            txBxShippingCharges.Clear();
        }
    }
}
