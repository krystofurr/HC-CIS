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
     * WidgetWorker class represents a single Widget worker
     */ 
    class WidgetWorker
    {
        // ATTRIBUTES
        private string name;
        private decimal totalPay;

        // PROPERTIES
        public decimal TotalPay
        {
            get
            {
                return totalPay;
            }
            set
            {
                totalPay = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }

        /*
            Function name: ToString()
            Version: 1
            Author: Christopher Sigouin
            Description: Displays a custom message for the WidgetWorker object
            Inputs: n/a
            Outputs: String
            Return value: String
            Change History: 2015.10.02 Original version by CJS

        */
        public override String ToString()
        {
            return "Name: " + name + "\n" +
                   "Total Pay: " + totalPay.ToString("C");
        }

        /*
            Function name: calculateWorkerPay()
            Version: 1
            Author: Christopher Sigouin
            Description: Calculates the total pay for a single widget worker based on the number of widgets produced
            Inputs: Widget object
            Outputs: n/a
            Return value: Decimal
            Change History: 2015.10.02 Original version by CJS

        */
        public decimal calculateWorkerPay(Widget widget)
        {
            totalPay = widget.Quantity * widget.Price;
            return totalPay;
        }
    }
}
