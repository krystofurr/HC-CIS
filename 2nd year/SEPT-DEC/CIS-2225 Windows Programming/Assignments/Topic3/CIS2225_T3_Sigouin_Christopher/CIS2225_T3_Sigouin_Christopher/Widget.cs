/*
    Program name: Widget Production Payment Calculator ( Topic 3 Assignment 3 )
    Author: Christopher Sigouin
    Version: 1
    Description: Calculates individual and total workers payroll based on a number of widgets produced.
    Dependencies: N/A
    Database file: N/A
    Change History: 2015.10.02 Original version by CJS

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CIS2225_T3_Sigouin_Christopher
{
    /*
     * Widget class represents a single widget
     * 
     */
    class Widget
    {

        // ATTRIBUTES
        public const decimal PRICE_POOR = .50m; // 1..100 inclusive
        public const decimal PRICE_LOW = .55m; // 101..399 inclusive
        public const decimal PRICE_MED = .60m; // 400..599 inclusive
        public const decimal PRICE_HIGH = .65m; // 600+ 
        private decimal price;
        private int quantity;

        // PROPERTIES
        public decimal Price
        {
            get
            {
                return price;
            }
        }

        public int Quantity
        {
            get
            {
                return quantity;
            }
            set
            {
                quantity = value;
                // Determine the price of the widget once the quantity is set
                determineWidgetPrice(quantity);
            }
        }

        /*
            Function name: determineWidgetPrice()
            Version: 1
            Author: Christopher Sigouin
            Description: Determines the correct price based on the quantity set by the user
            Inputs: Int
            Outputs: n/a
            Return value: n/a
            Change History: 2015.10.02 Original version by CJS

        */
        public void determineWidgetPrice(int quantity)
        {
            // Boolean flags for readability
            bool pricePoor = (quantity >= 1 && quantity <= 100);
            bool priceLow = (quantity >= 101 && quantity <= 399);
            bool priceMed = (quantity >= 400 && quantity <= 599);
            bool priceHigh = (quantity >= 600);

            if (pricePoor)
            {
                price = PRICE_POOR;    
            }
            else if (priceLow)
            {
                price = PRICE_LOW;
            }
            else if (priceMed)
            {
                price = PRICE_MED;
            }
            else if (priceHigh)
            {
                price = PRICE_HIGH;
            }

        }
    }
}
