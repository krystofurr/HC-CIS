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

namespace CIS2225_T4_Sigouin_Christopher
{
    class Breadsticks : Product
    {
        public const decimal PRICE_BREADSTICK_PLAIN = 3.0m;
        public const decimal PRICE_BREADSTICK_CHEESE = 4.0m;
        public const decimal PRICE_BREADSTICK_WHOLEWHEAT = 3.0m;

        public enum BreadstickTypes { Plain, Cheese, WholeWheat };

        private BreadstickTypes breadStickType;

        

        public Breadsticks(BreadstickTypes breadstickType) : base(breadstickType.ToString()) 
        {
            this.breadStickType = breadstickType;
            setPricing();
        }

        public override string ToString()
        {
            return "\nBreadsticks: " + ProductType + "\n";
        }

        public BreadstickTypes BreadStickType
        {
            get { return breadStickType; }
            set { breadStickType = value; }
        }

        public override decimal Price
        {
            get { return price; }
            set { price = value; }
        }

        /*
                      _   ____       _      _             
             ___  ___| |_|  _ \ _ __(_) ___(_)_ __   __ _ 
            / __|/ _ \ __| |_) | '__| |/ __| | '_ \ / _` |
            \__ \  __/ |_|  __/| |  | | (__| | | | | (_| |
            |___/\___|\__|_|   |_|  |_|\___|_|_| |_|\__, |
                                                    |___/ 

            Function name: setPricing()            Version: 1            Author: Christopher Sigouin            Description: Determines the correct price based on the type of product            Inputs: n/a            Outputs: n/a            Return value: n/a            Change History: 2015.10.25 Original version by CJS
        */
        public override void setPricing()
        {
            switch (breadStickType)
            {
                case BreadstickTypes.Cheese:
                    Price = PRICE_BREADSTICK_CHEESE;
                    break;
                case BreadstickTypes.Plain:
                    Price = PRICE_BREADSTICK_PLAIN;
                    break;
                case BreadstickTypes.WholeWheat:
                    Price = PRICE_BREADSTICK_WHOLEWHEAT;
                    break;
  
            }
        }
    }
}
