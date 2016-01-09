/*     ____          ____  _         ____  _ _          
    |  _ \  __ _  | __ )(_) __ _  / ___|| (_) ___ ___ 
    | | | |/ _` | |  _ \| |/ _` | \___ \| | |/ __/ _ \
    | |_| | (_| | | |_) | | (_| |  ___) | | | (_|  __/
    |____/ \__,_| |____/|_|\__, | |____/|_|_|\___\___|
                           |___/                     
    Program name: CIS-2225 T4 Sigouin Christopher ( Topic 4 Assignment 4 )    Author: Christopher Sigouin    Version: 1    Description: An application for a Pizza Delivery Company    Dependencies: N/A    Database file: N/A    Change History: 2015.10.25 Original version by CJS
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel; // Required for BindingList

namespace CIS2225_T4_Sigouin_Christopher
{
    class Order
    {
        public const decimal PRICE_DELIVERY = 5.00m;
        public const double TAX_PERCENTAGE = .14;

        private int orderID;
        private decimal subTotalPrice;
        private static bool deliveryAdded;
        protected decimal tax;
        protected decimal totalPrice;

        // Required to use with the 'OrderList' listbox.  Any items added will update it
        private BindingList<Product> orderList = new BindingList<Product>();

        public Order() 
        {
            // Just increment the ID for now
            ++orderID;
        }

        public override string ToString()
        {
            string output = "\n\nORDER DETAILS:\n" +
                     "OrderID: " + orderID + "\n" +
                     "SubTotal: $" + subTotalPrice + "\n" +
                     "Tax Amount: $" + tax + "\n" +
                     "Total Cost: $" + totalPrice + "\n";

            return output;
        }

        public BindingList<Product> OrderList
        {
            get { return orderList; }
            set { orderList = value; }
        }


        public static bool DeliveryAdded
        {
            get { return deliveryAdded; }
            set { deliveryAdded = value; }
        }
                
        public int OrderID
        {
            get { return orderID; }
            set { orderID = value; }
        }

        public decimal SubTotalPrice
        {
            get { return subTotalPrice; }
            set { subTotalPrice = value; }
        }

        /*
                       _            _       _        ____          _       
              ___ __ _| | ___ _   _| | __ _| |_ ___ / ___|___  ___| |_ ___ 
             / __/ _` | |/ __| | | | |/ _` | __/ _ \ |   / _ \/ __| __/ __|
            | (_| (_| | | (__| |_| | | (_| | ||  __/ |__| (_) \__ \ |_\__ \
             \___\__,_|_|\___|\__,_|_|\__,_|\__\___|\____\___/|___/\__|___/


            Function name: calculateCosts()            Version: 1            Author: Christopher Sigouin            Description: Calculates the total cost for all products within the order list            Inputs: n/a            Outputs: n/a            Return value: n/a            Change History: 2015.10.25 Original version by CJS
        */
        public void calculateCosts()
        { 
            // Clear the counters
            subTotalPrice = tax = totalPrice = 0;

            // Assign the subTotalPrice
            foreach (Product product in orderList)
            {
                subTotalPrice += product.Price;
            }

            // Get the tax amount
            tax = decimal.Round(subTotalPrice * (decimal)TAX_PERCENTAGE, 2);

            // Add cost for delivery if there is any cost
            subTotalPrice += (deliveryAdded) ? PRICE_DELIVERY : 0;

            decimal.Round(subTotalPrice, 2);

            // Calculate the totalCost
            totalPrice = decimal.Round(subTotalPrice + tax, 2);
        }

    

    }
}
