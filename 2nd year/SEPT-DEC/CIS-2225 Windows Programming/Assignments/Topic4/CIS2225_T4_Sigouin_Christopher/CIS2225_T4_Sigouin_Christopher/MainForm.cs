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
    public partial class MainForm : Form
    {
        // For debugging purposes only.  Permits console output strings
        public const bool DEBUG = true;
        public const string DEFAULT_MSG = "Welcome to \" Da Big Slice \"";
        // Array of 'Orders'. For purpose of this application, index '0' will be the order
        private static List<Order> orders = new List<Order>();
        private static Customer customer;

        private bool orderComplete;
        private bool customerInfoComplete;

        internal static List<Order> Orders
        {
            get { return MainForm.orders; }
            set { MainForm.orders = value; }
        }

        public bool OrderComplete
        {
            set { customerInfoButton.Enabled = value; }
        }

        public bool CustomerComplete
        {
            set { deliveryOptions.Enabled = value; }
        }

        public bool ResetButtonEnable
        {
            get { return resetOrderButton.Enabled; }
            set { resetOrderButton.Enabled = value; }
        }

        public static Customer Customer
        {
            get { return MainForm.customer; }
            set { MainForm.customer = value; }
        }

        // CONSTRUCTOR
        public MainForm()
        {
            InitializeComponent();
        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void aboutDaBigSliceToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AboutForm aboutForm = new AboutForm();
            aboutForm.ShowDialog();
        }

        private void quickHelpToolStripMenuItem_Click(object sender, EventArgs e)
        {
            QuickHelpForm quickHelpForm = new QuickHelpForm();
            quickHelpForm.ShowDialog();
        }

        private void customerInfoButton_Click(object sender, EventArgs e)
        {
            CustomerInfoForm customerInfoForm = new CustomerInfoForm();
            customerInfoForm.ShowDialog();    
        }

        private void placeOrderButton_Click(object sender, EventArgs e)
        {
            OrderForm orderForm = new OrderForm();
           /* if (orderForm.NewOrder != null)
            {
                Order order = orderForm.NewOrder;
                foreach (Product product in order.OrderList)
                {
                    orderForm.orderList.Items.Add(product);
                }
            } */
            orderForm.ShowDialog();
        }

        private void resetOrderButton_Click(object sender, EventArgs e)
        {
            orders.Clear();
            MessageBox.Show("You have cleared the order");
            mainDisplayArea.Text = DEFAULT_MSG;

            // Disable the 'Customer Info,'Delivery Options', and this button
            customerInfoButton.Enabled = false;
            deliveryOptions.Enabled = false;
            yesRadioButton.Checked = false;
            noRadioButton.Checked = false;
            resetOrderButton.Enabled = false;
            displayDetailsButton.Enabled = false;
        }




        private void displayDetailsButton_Click(object sender, EventArgs e)
        {
            Pizza pizza;

            // Check the delivery options
            Order.DeliveryAdded = (yesRadioButton.Checked) ? true : false;

            orders[0].calculateCosts();

            mainDisplayArea.Text = " ===== ORDER READY ===== ";

            for (int i = 0; i < orders[0].OrderList.Count; ++i)
            {
                if (orders[0].OrderList[i].GetType().Name == "Pizza")
                {
                    // Cast the product to his child form
                    pizza = (Pizza)orders[0].OrderList[i];
                    // Output the details of the pizza
                    mainDisplayArea.Text += pizza.displayDetails(pizza._PizzaToppings);
                }
                else
                {
                    mainDisplayArea.Text += orders[0].OrderList[i].ToString();
                }
            } // END: foreach

            // Display customer information
            mainDisplayArea.Text += customer.ToString();
            // Display order information
            mainDisplayArea.Text += orders[0].ToString();

        }

        private void deliveryOptions_Enter(object sender, EventArgs e)
        {
            displayDetailsButton.Enabled = true;
        }

        private void printToolStripMenuItem_Click(object sender, EventArgs e)
        {
            printDialog1.ShowDialog();
        }





    }
}
