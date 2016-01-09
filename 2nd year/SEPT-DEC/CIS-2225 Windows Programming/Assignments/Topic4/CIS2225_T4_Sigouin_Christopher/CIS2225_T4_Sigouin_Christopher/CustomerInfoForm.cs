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
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS2225_T4_Sigouin_Christopher
{

    

    public partial class CustomerInfoForm : Form
    {
        public MainForm mainForm;
        public static Customer customer;

        public CustomerInfoForm()
        {
            InitializeComponent();

            mainForm = (MainForm)Application.OpenForms["MainForm"];
        }

        private void CustomerInfoForm_Load(object sender, EventArgs e)
        {

        }

        //                    _   ____        _   _              
        // _ __ ___  ___  ___| |_| __ ) _   _| |_| |_ ___  _ __  
        //| '__/ _ \/ __|/ _ \ __|  _ \| | | | __| __/ _ \| '_ \ 
        //| | |  __/\__ \  __/ |_| |_) | |_| | |_| || (_) | | | |
        //|_|  \___||___/\___|\__|____/ \__,_|\__|\__\___/|_| |_|

        private void resetButton_Click(object sender, EventArgs e)
        {
            nameTextBox.Clear();
            addressTextBox.Clear();
            phoneTextBox.Clear();
            emailTextBox.Clear();

        }

        //                     ____        _   _              
        // ___  __ ___   _____| __ ) _   _| |_| |_ ___  _ __  
        /// __|/ _` \ \ / / _ \  _ \| | | | __| __/ _ \| '_ \ 
        //\__ \ (_| |\ V /  __/ |_) | |_| | |_| || (_) | | | |
        //|___/\__,_| \_/ \___|____/ \__,_|\__|\__\___/|_| |_|

        private void saveButton_Click(object sender, EventArgs e)
        {
            if (nameTextBox.Text == "" || addressTextBox.Text == "" ||
                phoneTextBox.Text == "" || emailTextBox.Text == "")
            {
                MessageBox.Show("You must fill all information first");
            }
            else
            {
                // Pull and assign all values

                customer = new Customer(nameTextBox.Text, addressTextBox.Text,
                                        phoneTextBox.Text, emailTextBox.Text);

                // Assign the customer
                MainForm.Customer = customer;
                if (MainForm.DEBUG) { Console.Write(customer.ToString()); }

                // Enable the Delivery Options
                mainForm.CustomerComplete = true;
                // Close this form
                this.Close();

            }
        }


    }
}
