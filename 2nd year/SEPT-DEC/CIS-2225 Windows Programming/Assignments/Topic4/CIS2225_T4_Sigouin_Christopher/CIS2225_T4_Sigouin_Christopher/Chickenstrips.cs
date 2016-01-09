﻿/*
    |  _ \  __ _  | __ )(_) __ _  / ___|| (_) ___ ___ 
    | | | |/ _` | |  _ \| |/ _` | \___ \| | |/ __/ _ \
    | |_| | (_| | | |_) | | (_| |  ___) | | | (_|  __/
    |____/ \__,_| |____/|_|\__, | |____/|_|_|\___\___|
                           |___/                     
    Program name: CIS-2225 T4 Sigouin Christopher ( Topic 4 Assignment 4 )
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CIS2225_T4_Sigouin_Christopher
{
    class Chickenstrips : Product
    {
        public const decimal PRICE_CHICKENSTRIPS_WHITE = 8.0m;
        public const decimal PRICE_CHICKENSTRIPS_DARK = 7.0m;

        public enum ChickenstripTypes { WhiteMeat, DarkMeat };

        private ChickenstripTypes chickenstripType;

       

        public Chickenstrips(ChickenstripTypes chickenstripType) : base(chickenstripType.ToString()) 
        {
            this.chickenstripType = chickenstripType;
            setPricing();
        }

        public override string ToString()
        {
            return "\nChickenstrips: " + ProductType + "\n";
        }

        public ChickenstripTypes ChickenstripType
        {
            get { return chickenstripType; }
            set { chickenstripType = value; }
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

            Function name: setPricing()
        */
        public override void setPricing()
        {
            switch (chickenstripType)
            {
                case ChickenstripTypes.DarkMeat:
                    Price = PRICE_CHICKENSTRIPS_DARK;
                    break;
                case ChickenstripTypes.WhiteMeat:
                    Price = PRICE_CHICKENSTRIPS_WHITE;
                    break;

            }
        }
    }
}