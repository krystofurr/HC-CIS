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
    class Beverage : Product
    {
        public const decimal PRICE_POP = 1.0m;
        public const decimal PRICE_WATER = .50m;

        public enum BeverageTypes { Pepsi, Sprite, Orange, Water };

        private BeverageTypes beverageType;

        

        public Beverage(BeverageTypes beverageType ) : base(beverageType.ToString())
        {
            this.beverageType = beverageType;
            setPricing();
        }

        public override string ToString()
        {
            return "\nBeverage: " + ProductType + "\n";
        }
        
        public BeverageTypes BeverageType
        {
            get { return beverageType; }
            set { beverageType = value; }
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
            switch (beverageType)
            {
                case BeverageTypes.Orange:
                    Price = PRICE_POP;
                    break;
                case BeverageTypes.Pepsi:
                    Price = PRICE_POP;
                    break;
                case BeverageTypes.Sprite:
                    Price = PRICE_POP;
                    break;
                case BeverageTypes.Water:
                    Price = PRICE_WATER;
                    break;

            }
        }
    }
}
