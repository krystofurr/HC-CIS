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
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS2225_T3_Sigouin_Christopher
{
    /**
     *  Form class
     *  
     *  TEST DATA:
     *  
     *  1st entry - 150 widgets ( 150 * .55 =  82.5)
     *  2nd entry - 450 widgets ( 450 * .60 = 270 )
     *  3rd entry - 40 widgets ( 40 * .50 = 20 )
     *  4th entry - 620 widgets ( 620 * .65 = 403 )
     *  
     *  Summary: Total Pay - 775.5
     *           Average Pay - ( 775.5 / 4 = 193.875 )
     */
    public partial class WPPC : Form
    {
        WidgetWorker widgetWorker;
        Widget widget;
        private decimal averagePay, totalWorkerPay;
        private int workerCount, totalWorkerWidgets;

        public WPPC()
        {
           
            InitializeComponent();
            // Initially set the summary button to false until a valid entry has been made
            summaryButton.Enabled = false;

        }

        /*
            Function name: calculateButton_Click()
            Version: 1
            Author: Christopher Sigouin
            Description: Calculates the widgets workers total pay and displays a message to the user
            Inputs: object sender, EventArgs e
            Outputs: Messagebox
            Return value: N/A
            Change History: 2015.10.02 Original version by CJS
        */
        private void calculateButton_Click(object sender, EventArgs e)
        {
            // Check for valid data entries
            if (IsValidInput())
            {
                // Make a new worker object
                widgetWorker = new WidgetWorker();
                // Make a new widget
                widget = new Widget();

                try
                {
                    // Pull the data from the fields and assign to the proper attributes
                    widgetWorker.Name = nameTextBox.Text;
                    widget.Quantity = Convert.ToInt32(widgetTextBox.Text);
 
                    // Calculate the workers pay based on the price and quantity of the widget(s)
                    widgetWorker.calculateWorkerPay(widget);

                    // Enable the summary button for usage now
                    if (summaryButton.Enabled != true)
                    {
                        summaryButton.Enabled = true;
                    }
                    // Calculate the average pay now with the entered data
                    calculateAverageWorkerPay();
                
                    MessageBox.Show("Workers Pay: " + widgetWorker.TotalPay.ToString("C"));
                }
                catch (Exception)
                {
                    MessageBox.Show("You entered invalid data.  Please retry", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    nameTextBox.Clear();
                    widgetTextBox.Clear();
                }

            }
            else
            {
                MessageBox.Show("You have fields that are empty.  Please verify and try again");
            }

        }

        /*
            Function name: summaryButton_Click()
            Version: 1
            Author: Christopher Sigouin
            Description: Provides a summary of all entries made by users
            Inputs: object sender, EventArgs e
            Outputs: Messagebox
            Return value: N/A
            Change History: 2015.10.02 Original version by CJS
        */
        private void summaryButton_Click(object sender, EventArgs e)
        {
            string summary = "Total Number of Widgets: " + totalWorkerWidgets.ToString("C") + "\n" +
                             "Total Worker Pay: " + totalWorkerPay.ToString("C") + "\n\n" +
                             "Average Pay: " + averagePay.ToString("C");

            MessageBox.Show(summary,"Summary Display");
        }

        /*
            Function name: clearButton_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Clears current values and leaves any summary values untouched
            Inputs: object sender, EventArgs e
            Outputs: n/a
            Return value: N/A
            Change History: 2015.10.02 Original version by CJS
        */
        private void clearButton_Click(object sender, EventArgs e)
        {
            nameTextBox.Clear();
            widgetTextBox.Clear();
            widgetWorker = null;
            widget = null;
        }

        /*
            Function name: clearAllButton_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Requests the user to click OK or CANCEL to clear all values used in the application
            Inputs: object sender, EventArgs e
            Outputs: n/a
            Return value: N/A
            Change History: 2015.10.02 Original version by CJS
        */
        private void clearAllButton_Click(object sender, EventArgs e)
        {
            // Confirm with the user before clearing anything
            DialogResult result = MessageBox.Show("Do you want to clear all data in the system?", "CLEAR ALL DATA", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);

            if(result == DialogResult.OK) 
            {
                nameTextBox.Clear();
                widgetTextBox.Clear();
                widgetWorker = null;
                widget = null;

                averagePay = totalWorkerPay = 0.0m;
                workerCount = totalWorkerWidgets = 0;

                // Disable the summary button again.  No data present
                if (summaryButton.Enabled != false)
                {
                    summaryButton.Enabled = false;
                }

                MessageBox.Show("All data has been cleared!");
            }
        }

        // Helper methods

        /*
            Function name: IsValidInput()
            Version: 1
            Author: Christopher Sigouin
            Description: Helper method to determine if there is any data provided
            Inputs: n/a
            Outputs: n/a
            Return value: N/A
            Change History: 2015.10.02 Original version by CJS
        */
        private bool IsValidInput()
        {
            bool validation = true;

            if(String.IsNullOrEmpty(nameTextBox.Text) || String.IsNullOrEmpty(widgetTextBox.Text))
            {
                validation = false;    
            }

            // Will return validation as true if condition does not exist
            return validation;
        }

        /*
            Function name: calculateAverageWorkerPay()
            Version: 1
            Author: Christopher Sigouin
            Description: Calculates the average pay and provides a display to the user for other total pay of all workers and total widgets produced
                         by all workers.
            Inputs: n/a
            Outputs: n/a
            Return value: N/A
            Change History: 2015.10.02 Original version by CJS
        */
        private void calculateAverageWorkerPay()
        {
            // Add a new worker to the count
            ++workerCount;
            // Add to the total counters
            totalWorkerPay += widgetWorker.TotalPay;
            totalWorkerWidgets += widget.Quantity;

            // Find the average
            averagePay = totalWorkerPay / workerCount;

        }
    }
}
