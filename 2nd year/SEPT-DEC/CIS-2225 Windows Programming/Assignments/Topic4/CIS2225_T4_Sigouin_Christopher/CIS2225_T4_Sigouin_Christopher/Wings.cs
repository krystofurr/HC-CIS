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
    class Wings : Product
    {
        public const decimal PRICE_WINGS_BBQ = 9.0m;
        public const decimal PRICE_WINGS_HONEYGARLIC = 10.0m;
        public const decimal PRICE_WINGS_SUICIDE = 9.5m;

        public enum WingTypes { BBQ, HoneyGarlic, Suicide }

        private WingTypes wingType;

        public Wings(WingTypes wingType) : base(wingType.ToString()) 
        {
            this.wingType = wingType;
            setPricing();
        }

        public override String ToString()
        {
            return "\nWings: " + ProductType + "\n";
        }

        public WingTypes WingType
        {
            get { return wingType; }
            set { wingType = value; }
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
            switch (wingType)
            {
                case WingTypes.BBQ:
                    Price = PRICE_WINGS_BBQ;
                    break;
                case WingTypes.HoneyGarlic:
                    Price = PRICE_WINGS_HONEYGARLIC;
                    break;
                case WingTypes.Suicide:
                    Price = PRICE_WINGS_SUICIDE;
                    break;
            }
        }

    }

    
}