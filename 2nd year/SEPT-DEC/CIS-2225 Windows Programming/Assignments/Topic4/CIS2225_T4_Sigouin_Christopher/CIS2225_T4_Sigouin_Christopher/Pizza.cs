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
    /**
     * Represents a single pizza product
     * 
     */
    class Pizza : Product
    {
        // Pricing
        public const decimal PRICE_BASE_SMALL = 10.0m;
        public const decimal PRICE_BASE_MEDIUM = 15.0m;
        public const decimal PRICE_BASE_LARGE = 20.0m;
        public const decimal PRICE_TOPPING = 0.50m;

        // Various elements that can be applied to a pizza
        public enum PizzaTypes { Supreme, Veggie, Meats, Custom };
        public enum SauceTypes { Tomato, Pesto, None };
        public enum CrustTypes { White, WholeWheat, Garlic };
        public enum PizzaToppings { Bacon, Mushroom, GreenPepper, Onions, Pepperoni, Salami, Hamburger, Sardines };
        public enum PizzaSizes { Small, Medium, Large };

        // Field attributes
        private PizzaTypes pizzaType;
        private SauceTypes sauceType;
        private CrustTypes crustType;
        private PizzaToppings[] pizzaToppings; // Should be an array
        private PizzaSizes pizzaSize;

        private string test = "test";

        public string Test
        {
            get { return test; }
            set { test = value; }
        }


        public Pizza(PizzaTypes pizzaType, SauceTypes sauceType, CrustTypes crustType,
                      PizzaToppings[] pizzaToppings, PizzaSizes pizzaSize) : base(pizzaType.ToString())
        {
            this.pizzaType = pizzaType;
            this.sauceType = sauceType;
            this.crustType = crustType;
            this.pizzaToppings = pizzaToppings;
            this.pizzaSize = pizzaSize;

            setPricing();
        }

        public override String ToString()
        {
            return "Pizza: " + ProductType;
        }

        // Properties
        public PizzaTypes PizzaType
        {
            get { return pizzaType; }
            set { pizzaType = value; }
        }

        public SauceTypes SauceType
        {
            get { return sauceType; }
            set {sauceType = value; }
        }

        public CrustTypes CrustType
        {
            get { return crustType; }
            set { crustType = value; }
        }

        public PizzaToppings[] _PizzaToppings
        {
            get { return pizzaToppings; }
            set { pizzaToppings = value; }
        }

        public PizzaSizes PizzaSize
        {
            get { return pizzaSize; }
            set { pizzaSize = value; }
        }

        public override decimal Price
        {
            get { return price; }
            set { price = value; }
        }

        public String displayDetails(PizzaToppings[] pizzaToppings)
        {
            string pizzaDetails = "\nPizza Type: " + pizzaType + "\n" +
                           "Pizza Size: " + pizzaSize + "\n" +
                           "Sauce Type: " + sauceType + "\n" +
                           "Crust Type: " + crustType + "\n" +
                           "Toppings: ";

            var count = 1;
            foreach(Pizza.PizzaToppings topping in pizzaToppings) 
            { 
                pizzaDetails += topping.ToString();
                if (count != pizzaToppings.Length)
                {
                    pizzaDetails += ",";
                }
                ++count;
            }

            pizzaDetails += "\n";
            return pizzaDetails;
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
            switch (pizzaSize)
            {
                case PizzaSizes.Small:
                    Price = PRICE_BASE_SMALL + (pizzaToppings.Length * PRICE_TOPPING);
                    break;
                case PizzaSizes.Medium:
                    Price = PRICE_BASE_MEDIUM + (pizzaToppings.Length * PRICE_TOPPING);
                    break;
                case PizzaSizes.Large:
                    Price = PRICE_BASE_LARGE + (pizzaToppings.Length * PRICE_TOPPING);
                    break;
            }
        }

    }
}
