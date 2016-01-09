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
    public partial class OrderForm : Form
    {

        private Order newOrder;
        private Pizza pizza;
        private Wings wings;
        private Breadsticks breadsticks;
        private Chickenstrips chickenstrips;
        private Beverage beverages;
        private MainForm mainForm;

        private bool editMode = false;

        // Properties
        internal Order NewOrder
        {
            get { return newOrder; }
            set { newOrder = value; }
        }

        public OrderForm()
        {
            InitializeComponent();

            // This application will only work with one order at a time.  Only create if there is no order present
            if (MainForm.Orders.Count == 0)
            {
                // Create a new 'Order' object
                newOrder = new Order();
                // Add the order to the main form 'Order' array to reuse
                MainForm.Orders.Add(newOrder);

 
            }
            else
            {
                newOrder = MainForm.Orders.ElementAt(0);
            }

            // Loads all listed items based on enumerations within class types
            loadOrderFormLists();

            // Bind the order list to the 'Order List' form listbox
            orderList.DataSource = newOrder.OrderList;
            //orderList.DisplayMember = "ProductType";

            // Get an instance of the 'MainForm' to coordinate with enabling / disabling controls
            mainForm = (MainForm)Application.OpenForms["MainForm"];

            // Ensure the 'Save Button' is enabled if an order has been created ( User re-opening form )
            if (newOrder.OrderList.Count > 0 ) { saveOrderButton.Enabled = true; }
        }

        /**
         * REF: http://stackoverflow.com/questions/105372/enumerate-an-enum
         * 
         * Products contained in the 'Order' are datasourced to the 'orderList' listbox.  No need
         * to load those.  They will autofill.
         * 
         */
        public void loadOrderFormLists()
        {

            // Pizza Toppings
            foreach (Pizza.PizzaToppings pizzaTopping in Enum.GetValues(typeof(Pizza.PizzaToppings)))
            {
                toppingsList.Items.Add(pizzaTopping);
            }

            // Pizza Types
            foreach (Pizza.PizzaTypes pizzaType in Enum.GetValues(typeof(Pizza.PizzaTypes)))
            {
                pizzaTypes.Items.Add(pizzaType);
            }

            // Sauce Types
            foreach (Pizza.SauceTypes sauceType in Enum.GetValues(typeof(Pizza.SauceTypes)))
            {
                sauceTypes.Items.Add(sauceType);
            }

            // Crust Types
            foreach (Pizza.CrustTypes crustType in Enum.GetValues(typeof(Pizza.CrustTypes)))
            {
                crustTypes.Items.Add(crustType);
            }

            // Pizza Sizes
            foreach (Pizza.PizzaSizes pizzaSize in Enum.GetValues(typeof(Pizza.PizzaSizes)))
            {
                pizzaSizes.Items.Add(pizzaSize);
            }

            // Wings
            foreach (Wings.WingTypes wingType in Enum.GetValues(typeof(Wings.WingTypes)))
            {
                wingTypes.Items.Add(wingType);
            }

            // Breadsticks
            foreach (Breadsticks.BreadstickTypes breadstickType in Enum.GetValues(typeof(Breadsticks.BreadstickTypes)))
            {
                breadstickTypes.Items.Add(breadstickType);
            }

            // Chickenstrips
            foreach (Chickenstrips.ChickenstripTypes chickenstripType in Enum.GetValues(typeof(Chickenstrips.ChickenstripTypes)))
            {
                chickenstripTypes.Items.Add(chickenstripType);
            }

            // Beverages
            foreach (Beverage.BeverageTypes beverageType in Enum.GetValues(typeof(Beverage.BeverageTypes)))
            {
                beverageTypes.Items.Add(beverageType);
            }
        } // END

        private void pizzaSizes_SelectedIndexChanged(object sender, EventArgs e)
        {

        }


        // PIZZA TYPES COMBO BOX
        private void pizzaTypes_SelectionChangeCommitted(object sender, EventArgs e)
        {
            /*** RUN PRESETS ***/

            // Clear the previous values first

            sauceTypes.SelectedItem = null;
            crustTypes.SelectedItem = null;
            clearToppingsList();

            switch ((Pizza.PizzaTypes)pizzaTypes.SelectedItem)
            {
                case Pizza.PizzaTypes.Custom:
                    sauceTypes.SelectedIndex = sauceTypes.FindString(Pizza.SauceTypes.None.ToString());
                    crustTypes.SelectedIndex = crustTypes.FindString(Pizza.CrustTypes.White.ToString());
                    setToppingsList(new string[] { Pizza.PizzaToppings.Pepperoni.ToString() } );
                    break;

                case Pizza.PizzaTypes.Veggie:
                    sauceTypes.SelectedIndex = sauceTypes.FindString(Pizza.SauceTypes.Pesto.ToString());
                    crustTypes.SelectedIndex = crustTypes.FindString(Pizza.CrustTypes.WholeWheat.ToString());
                    setToppingsList(new string[] { Pizza.PizzaToppings.GreenPepper.ToString(),
                                                   Pizza.PizzaToppings.Mushroom.ToString(),
                                                   Pizza.PizzaToppings.Onions.ToString() });
                    break;
                case Pizza.PizzaTypes.Meats:
                    sauceTypes.SelectedIndex = sauceTypes.FindString(Pizza.SauceTypes.Tomato.ToString());
                    crustTypes.SelectedIndex = crustTypes.FindString(Pizza.CrustTypes.White.ToString());
                    setToppingsList(new string[] { Pizza.PizzaToppings.Hamburger.ToString(),
                                                   Pizza.PizzaToppings.Pepperoni.ToString(),
                                                   Pizza.PizzaToppings.Salami.ToString() });
                    break;
                case Pizza.PizzaTypes.Supreme:
                    sauceTypes.SelectedIndex = sauceTypes.FindString(Pizza.SauceTypes.Tomato.ToString());
                    crustTypes.SelectedIndex = crustTypes.FindString(Pizza.CrustTypes.Garlic.ToString());
                    setToppingsList(new string[] { Pizza.PizzaToppings.Bacon.ToString(),
                                                   Pizza.PizzaToppings.Mushroom.ToString(),
                                                   Pizza.PizzaToppings.Onions.ToString(),
                                                   Pizza.PizzaToppings.Sardines.ToString() });
                    break;
            }

        }

        // To use with orderList_SingleClick()
        private void setToppingsList(Pizza.PizzaToppings[] toppings)
        {
            foreach (Pizza.PizzaToppings topping in toppings)
            {
                toppingsList.SetItemChecked(toppingsList.FindString(topping.ToString()), true);
            }
        }

        private void setToppingsList(string[] toppings)
        {
            foreach(string topping in toppings) 
            {
                toppingsList.SetItemChecked(toppingsList.FindString(topping), true);
            }
        }

        /*
                       _     _  ___          _           ____        _   _              
              __ _  __| | __| |/ _ \ _ __ __| | ___ _ __| __ ) _   _| |_| |_ ___  _ __  
             / _` |/ _` |/ _` | | | | '__/ _` |/ _ \ '__|  _ \| | | | __| __/ _ \| '_ \ 
            | (_| | (_| | (_| | |_| | | | (_| |  __/ |  | |_) | |_| | |_| || (_) | | | |
             \__,_|\__,_|\__,_|\___/|_|  \__,_|\___|_|  |____/ \__,_|\__|\__\___/|_| |_|

        */
        private void addOrderButton_Click(object sender, EventArgs e)
        {
            
            /*
                       _     _ __  __           _      
              __ _  __| | __| |  \/  | ___   __| | ___ 
             / _` |/ _` |/ _` | |\/| |/ _ \ / _` |/ _ \
            | (_| | (_| | (_| | |  | | (_) | (_| |  __/
             \__,_|\__,_|\__,_|_|  |_|\___/ \__,_|\___|
 
            */
            if (!editMode)
            {

                /*** VALIDATE SOME CONTRAINTS ***/

                if (tabControl.SelectedTab == tabControl.TabPages["pizzaTab"])
                {
                    // User selected a 'Type' but did not select a 'Size'
                    if (pizzaTypes.SelectedItem == null)
                    {
                        orderFormMessageArea.Text = "ERROR: Please choose a ' Pizza Type '";
                    }

                    else if (pizzaSizes.SelectedItem == null)
                    {
                        orderFormMessageArea.Text = "ERROR: Please choose a ' Pizza Size '";

                    }

                    else
                    {

                        /*** PULL ALL VALUES ***/

                        // Pizza Tab - Temp variables to use when creating the pizza instance
                        Pizza.PizzaTypes pizzaType = (Pizza.PizzaTypes)pizzaTypes.SelectedItem;
                        Pizza.PizzaSizes pizzaSize = (Pizza.PizzaSizes)pizzaSizes.SelectedItem;
                        Pizza.SauceTypes sauceType = (Pizza.SauceTypes)sauceTypes.SelectedItem;
                        Pizza.CrustTypes crustType = (Pizza.CrustTypes)crustTypes.SelectedItem;
                        Pizza.PizzaToppings[] toppingsList = new Pizza.PizzaToppings[this.toppingsList.CheckedItems.Count];
                        int index = 0;
                        // REF: https://social.msdn.microsoft.com/Forums/windows/en-US/1c93a1c0-ebbb-4053-b544-210ced41270f/how-to-iterate-through-checkedlistbox-selecteditems-and-storing-it-in-a-string-array?forum=winforms
                        foreach (object item in this.toppingsList.CheckedItems)
                        {
                            toppingsList[index] = (Pizza.PizzaToppings)item;
                            ++index;
                        }


                        pizza = new Pizza(pizzaType, sauceType, crustType, toppingsList, pizzaSize);
                        //pizza.ProductType.Insert(0, "Pizza: ");
                        newOrder.OrderList.Add(pizza);
                        clearAllFields();
                        
                        // Enable the 'Save Order' Button
                        if (!saveOrderButton.Enabled) { saveOrderButton.Enabled = true; }
                        // Enable the 'Reset Order' Button on the 'MainForm'
                        if (!mainForm.ResetButtonEnable) { mainForm.ResetButtonEnable = true; }

                        if (MainForm.DEBUG) { Console.Write(pizza.displayDetails(toppingsList)); }

                    }
                }
                else if (tabControl.SelectedTab == tabControl.TabPages["otherTab"])
                {
                    if (wingTypes.SelectedItem == null && breadstickTypes.SelectedItem == null && chickenstripTypes.SelectedItem == null)
                    {
                        orderFormMessageArea.Text = "ERROR: Please select an option before adding";
                    }
                    // Other Tab
                    if (wingTypes.SelectedItem != null)
                    {
                        // Pull the value
                        Wings.WingTypes wingType = (Wings.WingTypes)wingTypes.SelectedItem;
                        // Create the instance
                        wings = new Wings(wingType);
                        // Store it in the 'Product' array
                        NewOrder.OrderList.Add(wings);
                        clearAllFields();
                        // Enable the 'Save Order' Button
                        if (!saveOrderButton.Enabled) { saveOrderButton.Enabled = true; }
                        // Enable the 'Reset Order' Button on the 'MainForm'
                        if (!mainForm.ResetButtonEnable) { mainForm.ResetButtonEnable = true; }
                    }
                    if (breadstickTypes.SelectedItem != null)
                    {
                        Breadsticks.BreadstickTypes breadstickType = (Breadsticks.BreadstickTypes)breadstickTypes.SelectedItem;
                        breadsticks = new Breadsticks(breadstickType);
                        NewOrder.OrderList.Add(breadsticks);
                        clearAllFields();
                        // Enable the 'Save Order' Button
                        if (!saveOrderButton.Enabled) { saveOrderButton.Enabled = true; }
                        // Enable the 'Reset Order' Button on the 'MainForm'
                        if (!mainForm.ResetButtonEnable) { mainForm.ResetButtonEnable = true; }

                    }
                    if (chickenstripTypes.SelectedItem != null)
                    {
                        Chickenstrips.ChickenstripTypes chickenstripType = (Chickenstrips.ChickenstripTypes)chickenstripTypes.SelectedItem;
                        chickenstrips = new Chickenstrips(chickenstripType);
                        NewOrder.OrderList.Add(chickenstrips);
                        clearAllFields();
                        // Enable the 'Save Order' Button
                        if (!saveOrderButton.Enabled) { saveOrderButton.Enabled = true; }
                        // Enable the 'Reset Order' Button on the 'MainForm'
                        if (!mainForm.ResetButtonEnable) { mainForm.ResetButtonEnable = true; }
                    }


                }
                else if (tabControl.SelectedTab == tabControl.TabPages["beverageTab"])
                {

                    if (beverageTypes.SelectedItem != null)
                    {
                        Beverage.BeverageTypes beverageType = (Beverage.BeverageTypes)beverageTypes.SelectedItem;
                        beverages = new Beverage(beverageType);
                        NewOrder.OrderList.Add(beverages);
                        orderFormMessageArea.Text = "SUCCESS: Your order has been added!";
                        clearAllFields();
                        // Enable the 'Save Order' Button
                        if (!saveOrderButton.Enabled) { saveOrderButton.Enabled = true; }
                        // Enable the 'Reset Order' Button on the 'MainForm'
                        if (!mainForm.ResetButtonEnable) { mainForm.ResetButtonEnable = true; }
                    }
                    else
                    {
                        orderFormMessageArea.Text = "ERROR: Please select a beverage before adding";
                    }
                }

                /*** CLEAR ALL FIELDS ***/

                


            } // END: Add mode


            /*
                          _ _ _   __  __           _      
                  ___  __| (_) |_|  \/  | ___   __| | ___ 
                 / _ \/ _` | | __| |\/| |/ _ \ / _` |/ _ \
                |  __/ (_| | | |_| |  | | (_) | (_| |  __/
                 \___|\__,_|_|\__|_|  |_|\___/ \__,_|\___|

            */
            else
            {
                if (tabControl.TabPages.Contains(pizzaTab))
                {
                    // Pull and assign the new values
                    pizza.ProductType = pizzaTypes.SelectedItem.ToString();
                    pizza.PizzaType = (Pizza.PizzaTypes)pizzaTypes.SelectedItem;
                    pizza.PizzaSize = (Pizza.PizzaSizes)pizzaSizes.SelectedItem;
                    pizza.SauceType = (Pizza.SauceTypes)sauceTypes.SelectedItem;
                    pizza.CrustType = (Pizza.CrustTypes)crustTypes.SelectedItem;

                    // Create and assign the 'toppingList' variable.  It was set to 'null' in orderList_SingleClick()
                    Pizza.PizzaToppings[] toppingsList = new Pizza.PizzaToppings[this.toppingsList.CheckedItems.Count];
                    pizza._PizzaToppings = toppingsList;

                    int index = 0;
                    foreach (object item in this.toppingsList.CheckedItems)
                    {
                        toppingsList[index] = (Pizza.PizzaToppings)item;
                        ++index;
                    }

                    // Store index, remove previous object and insert new object
                    int productIndex = orderList.SelectedIndex;
                    NewOrder.OrderList.RemoveAt(orderList.SelectedIndex);
                    NewOrder.OrderList.Insert(productIndex, pizza);

                    // Re-enable the tabs
                    tabControl.TabPages.Add(otherTab);
                    tabControl.TabPages.Add(beverageTab);

                    orderFormMessageArea.Text = "SUCCESS: Update complete";
                    if (MainForm.DEBUG) { Console.Write(pizza.displayDetails(toppingsList)); }
                }
                else if (tabControl.TabPages.Contains(otherTab))
                {
                    if (wingTypes.SelectedItem != null)
                    {
                        wings.ProductType = wingTypes.SelectedItem.ToString();
                        //newOrder.OrderList.SetItem(orderList.SelectedIndex, wings);

                        // Store index, remove previous object and insert new object
                        int productIndex = orderList.SelectedIndex;
                        NewOrder.OrderList.RemoveAt(orderList.SelectedIndex);
                        NewOrder.OrderList.Insert(productIndex, wings);
                    }
                    if (breadstickTypes.SelectedItem != null)
                    {
                        // Pull the new value
                        breadsticks.ProductType = breadstickTypes.SelectedItem.ToString();

                        // Store index, remove previous object and insert new object
                        int productIndex = orderList.SelectedIndex;
                        NewOrder.OrderList.RemoveAt(orderList.SelectedIndex);
                        NewOrder.OrderList.Insert(productIndex, breadsticks);
                    }
                    if (chickenstripTypes.SelectedItem != null)
                    {
                        // Pull the new value
                        chickenstrips.ProductType = chickenstripTypes.SelectedItem.ToString();

                        // Store index, remove previous object and insert new object
                        int productIndex = orderList.SelectedIndex;
                        NewOrder.OrderList.RemoveAt(orderList.SelectedIndex);
                        NewOrder.OrderList.Insert(productIndex, chickenstrips);
                    }

                    // Re-enable the tabs
                    tabControl.TabPages.Remove(otherTab);
                    // Had to do this to get the right order
                    tabControl.TabPages.Add(pizzaTab);
                    tabControl.TabPages.Add(otherTab);
                    tabControl.TabPages.Add(beverageTab);

                    orderFormMessageArea.Text = "SUCCESS: Update complete";
                }
                else if (tabControl.TabPages.Contains(beverageTab))
                {
                    // Pull the new value
                    beverages.ProductType = beverageTypes.SelectedItem.ToString();

                    // Store index, remove previous object and insert new object
                    int productIndex = orderList.SelectedIndex;
                    NewOrder.OrderList.RemoveAt(orderList.SelectedIndex);
                    NewOrder.OrderList.Insert(productIndex, beverages);

                    // Re-enable the tabs
                    tabControl.TabPages.Remove(beverageTab);
                    // Had to do this to get the right order
                    tabControl.TabPages.Add(pizzaTab);
                    tabControl.TabPages.Add(otherTab);
                    tabControl.TabPages.Add(beverageTab);

                    orderFormMessageArea.Text = "SUCCESS: Update complete";
                }

                // If ' Edit Mode ' was enabled, it can be disabled. Change button text back as well
                editMode = false;
                addOrderButton.Text = "Add";
            } // END: Edit Mode

        } // END: ADD ORDER BUTTON


        //      _                _____                 _                 _     _     _   
        //  ___| | ___  __ _ _ _|_   _|__  _ __  _ __ (_)_ __   __ _ ___| |   (_)___| |_ 
        // / __| |/ _ \/ _` | '__|| |/ _ \| '_ \| '_ \| | '_ \ / _` / __| |   | / __| __|
        //| (__| |  __/ (_| | |   | | (_) | |_) | |_) | | | | | (_| \__ \ |___| \__ \ |_ 
        // \___|_|\___|\__,_|_|   |_|\___/| .__/| .__/|_|_| |_|\__, |___/_____|_|___/\__|
        //                                |_|   |_|            |___/   

        private void clearToppingsList()
        {
            for (int i = 0; i < toppingsList.Items.Count; i++)
            {
                toppingsList.SetItemChecked(i, false);
            }
        }

        //      _                  _    _ _ _____ _      _     _     
        //  ___| | ___  __ _ _ __ / \  | | |  ___(_) ___| | __| |___ 
        // / __| |/ _ \/ _` | '__/ _ \ | | | |_  | |/ _ \ |/ _` / __|
        //| (__| |  __/ (_| | | / ___ \| | |  _| | |  __/ | (_| \__ \
        // \___|_|\___|\__,_|_|/_/   \_\_|_|_|   |_|\___|_|\__,_|___/

        private void clearAllFields()
        {
            // Pizza Tab
            pizzaTypes.SelectedItem = null;
            pizzaSizes.SelectedItem = null;
            sauceTypes.SelectedItem = null;
            crustTypes.SelectedItem = null;
            clearToppingsList();

            // Other Tab
            wingTypes.SelectedItem = null;
            breadstickTypes.SelectedItem = null;
            chickenstripTypes.SelectedItem = null;

            // Beverage Tab
            beverageTypes.ClearSelected();

        }

        /* ORDER LIST ( SINGLE CLICK EVENT )
         * 
         * Loads an object from the ' OrderList ' based on the index value.  This will
         * repopulate the form with the values contained within the object.  The user
         * can change the values on the form and then resubmit them into the array.
         * 
                           _           _     _     _   
              ___  _ __ __| | ___ _ __| |   (_)___| |_ 
             / _ \| '__/ _` |/ _ \ '__| |   | / __| __|
            | (_) | | | (_| |  __/ |  | |___| \__ \ |_ 
             \___/|_|  \__,_|\___|_|  |_____|_|___/\__|

             ____  _             _         ____ _ _      _    
            / ___|(_)_ __   __ _| | ___   / ___| (_) ___| | __
            \___ \| | '_ \ / _` | |/ _ \ | |   | | |/ __| |/ /
             ___) | | | | | (_| | |  __/ | |___| | | (__|   < 
            |____/|_|_| |_|\__, |_|\___|  \____|_|_|\___|_|\_\

        */
        private void orderList_SingleClick(object sender, EventArgs e)
        {
            
            // Check validity on the selected item
            if (orderList.SelectedItem != null)
            {
                editMode = true;
                addOrderButton.Text = "Add ( Edit Mode )";

                // Get the name of the class that is contained within the ' OrderList ' list array by index
                string className = NewOrder.OrderList[orderList.SelectedIndex].GetType().Name;

                // To manipulate the object, convert it back into a child class object
                switch (className)
                {
                    case "Pizza":
                        pizza = (Pizza)orderList.SelectedItem;
                        // Disable unneeded tabs
                        tabControl.TabPages.Remove(otherTab);
                        tabControl.TabPages.Remove(beverageTab);
                        // Populate the form with the values from the object in the orderList
                        pizzaTypes.SelectedIndex = pizzaTypes.FindString(pizza.PizzaType.ToString());
                        pizzaSizes.SelectedIndex = pizzaSizes.FindString(pizza.PizzaSize.ToString());
                        crustTypes.SelectedIndex = crustTypes.FindString(pizza.CrustType.ToString());
                        sauceTypes.SelectedIndex = sauceTypes.FindString(pizza.SauceType.ToString());
                        setToppingsList(pizza._PizzaToppings);
                        // Clear the topping array to ensure it's empty. Other variables will overwrite
                        pizza._PizzaToppings = null;

                        break;
                    case "Wings":
                        wings = (Wings)orderList.SelectedItem;
                        // Disable unneeded tabs
                        tabControl.TabPages.Remove(pizzaTab);
                        tabControl.TabPages.Remove(beverageTab);
                        // Populate the form
                        wingTypes.SelectedIndex = wingTypes.FindString(wings.WingType.ToString());
                        break;
                    case "Chickenstrips":
                        chickenstrips = (Chickenstrips)orderList.SelectedItem;
                        // Disable unneeded tabs
                        tabControl.TabPages.Remove(pizzaTab);
                        tabControl.TabPages.Remove(beverageTab);
                        // Populate the form
                        chickenstripTypes.SelectedIndex = chickenstripTypes.FindString(chickenstrips.ChickenstripType.ToString());
                        break;
                    case "Breadsticks":
                        breadsticks = (Breadsticks)orderList.SelectedItem;
                        // Disable unneeded tabs
                        tabControl.TabPages.Remove(pizzaTab);
                        tabControl.TabPages.Remove(beverageTab);
                        // Populate the form
                        breadstickTypes.SelectedIndex = breadstickTypes.FindString(breadsticks.BreadStickType.ToString());
                        break;
                    case "Beverage":
                        beverages = (Beverage)orderList.SelectedItem;
                        // Disable unneeded tabs
                        tabControl.TabPages.Remove(pizzaTab);
                        tabControl.TabPages.Remove(otherTab);
                        // Populate the form
                        beverageTypes.SelectedIndex = beverageTypes.FindString(beverages.BeverageType.ToString());
                        break;
                }



            }
        }

        /*                 _           _     _     _   
              ___  _ __ __| | ___ _ __| |   (_)___| |_ 
             / _ \| '__/ _` |/ _ \ '__| |   | / __| __|
            | (_) | | | (_| |  __/ |  | |___| \__ \ |_ 
             \___/|_|  \__,_|\___|_|  |_____|_|___/\__|

             ____              _     _         ____ _ _      _    
            |  _ \  ___  _   _| |__ | | ___   / ___| (_) ___| | __
            | | | |/ _ \| | | | '_ \| |/ _ \ | |   | | |/ __| |/ /
            | |_| | (_) | |_| | |_) | |  __/ | |___| | | (__|   < 
            |____/ \___/ \__,_|_.__/|_|\___|  \____|_|_|\___|_|\_\
        
        */

        private void orderList_DoubleClick(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Delete " + orderList.SelectedValue + "?", "REMOVE PRODUCT", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);

            // Did the user click ' OK '
            if (result == DialogResult.OK)
            {
                // Is the item the user clicked on valid
                if (orderList.SelectedItem.GetType().Name != null)
                {
                    string className = orderList.SelectedItem.GetType().Name;

                    switch (className)
                    {
                        case "Pizza":
                            MessageBox.Show("Pizza was hit");
                            Pizza pizza = (Pizza)orderList.SelectedItem;
                            MessageBox.Show("" + pizza.CrustType);
                            break;

                    }

                    /*newOrder.OrderList.Clear();
                    foreach (Product product in newOrder.OrderList)
                    {
                        if (product.ProductType == orderList.SelectedItem)
                        {
                            newOrder.OrderList.Clear();
                        }
                    }*/
                }

            }
        }

        //          _ _ _    ____                     _ ____        _   _              
        //  ___  __| (_) |_ / ___|__ _ _ __   ___ ___| | __ ) _   _| |_| |_ ___  _ __  
        // / _ \/ _` | | __| |   / _` | '_ \ / __/ _ \ |  _ \| | | | __| __/ _ \| '_ \ 
        //|  __/ (_| | | |_| |__| (_| | | | | (_|  __/ | |_) | |_| | |_| || (_) | | | |
        // \___|\__,_|_|\__|\____\__,_|_| |_|\___\___|_|____/ \__,_|\__|\__\___/|_| |_|

        private void editCancelButton_Click(object sender, EventArgs e)
        {
            if (tabControl.TabPages.Contains(pizzaTab))
            {
                tabControl.TabPages.Add(otherTab);
                tabControl.TabPages.Add(beverageTab);
            }
            else if (tabControl.TabPages.Contains(otherTab))
            {
                tabControl.TabPages.Add(pizzaTab);
                tabControl.TabPages.Add(beverageTab);
            }
            else if (tabControl.TabPages.Contains(beverageTab))
            {
                tabControl.TabPages.Add(pizzaTab);
                tabControl.TabPages.Add(otherTab);
            }
                
        }

        //                      ___          _           ____        _   _              
        // ___  __ ___   _____ / _ \ _ __ __| | ___ _ __| __ ) _   _| |_| |_ ___  _ __  
        /// __|/ _` \ \ / / _ \ | | | '__/ _` |/ _ \ '__|  _ \| | | | __| __/ _ \| '_ \ 
        //\__ \ (_| |\ V /  __/ |_| | | | (_| |  __/ |  | |_) | |_| | |_| || (_) | | | |
        //|___/\__,_| \_/ \___|\___/|_|  \__,_|\___|_|  |____/ \__,_|\__|\__\___/|_| |_|

        private void saveOrderButton_Click(object sender, EventArgs e)
        {
            // Calculate the pricing on the order
            newOrder.calculateCosts();

            // Set the 'Customer Info' button in the 'Main Form' to enabled
            mainForm.OrderComplete = true;

            // Close this form
            this.Close();

        }





    } // END CLASS

} // END NAMESPACE
