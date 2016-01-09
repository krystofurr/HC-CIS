namespace CIS2225_T4_Sigouin_Christopher
{
    partial class OrderForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.orderFormMessageArea = new System.Windows.Forms.Label();
            this.saveOrderButton = new System.Windows.Forms.Button();
            this.addOrderButton = new System.Windows.Forms.Button();
            this.orderList = new System.Windows.Forms.ListBox();
            this.label11 = new System.Windows.Forms.Label();
            this.orderListBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.orderBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.orderListBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.beverageTab = new System.Windows.Forms.TabPage();
            this.label7 = new System.Windows.Forms.Label();
            this.beverageTypes = new System.Windows.Forms.ListBox();
            this.label9 = new System.Windows.Forms.Label();
            this.otherTab = new System.Windows.Forms.TabPage();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.chickenstripTypes = new System.Windows.Forms.ComboBox();
            this.breadstickTypes = new System.Windows.Forms.ComboBox();
            this.wingTypes = new System.Windows.Forms.ComboBox();
            this.pizzaTab = new System.Windows.Forms.TabPage();
            this.pizzaSizeArea = new System.Windows.Forms.GroupBox();
            this.pizzaSizes = new System.Windows.Forms.ComboBox();
            this.pizzaTypeArea = new System.Windows.Forms.GroupBox();
            this.pizzaTypes = new System.Windows.Forms.ComboBox();
            this.customPizzaArea = new System.Windows.Forms.GroupBox();
            this.crustTypes = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.sauceTypes = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.toppingsList = new System.Windows.Forms.CheckedListBox();
            this.tabControl = new System.Windows.Forms.TabControl();
            ((System.ComponentModel.ISupportInitialize)(this.orderListBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.orderBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.orderListBindingSource1)).BeginInit();
            this.beverageTab.SuspendLayout();
            this.otherTab.SuspendLayout();
            this.pizzaTab.SuspendLayout();
            this.pizzaSizeArea.SuspendLayout();
            this.pizzaTypeArea.SuspendLayout();
            this.customPizzaArea.SuspendLayout();
            this.tabControl.SuspendLayout();
            this.SuspendLayout();
            // 
            // orderFormMessageArea
            // 
            this.orderFormMessageArea.Location = new System.Drawing.Point(201, 314);
            this.orderFormMessageArea.Name = "orderFormMessageArea";
            this.orderFormMessageArea.Size = new System.Drawing.Size(293, 37);
            this.orderFormMessageArea.TabIndex = 2;
            this.orderFormMessageArea.Text = "Message Area";
            // 
            // saveOrderButton
            // 
            this.saveOrderButton.Enabled = false;
            this.saveOrderButton.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.saveOrderButton.Location = new System.Drawing.Point(615, 322);
            this.saveOrderButton.Name = "saveOrderButton";
            this.saveOrderButton.Size = new System.Drawing.Size(134, 26);
            this.saveOrderButton.TabIndex = 1;
            this.saveOrderButton.Text = "Save Order";
            this.saveOrderButton.UseVisualStyleBackColor = true;
            this.saveOrderButton.Click += new System.EventHandler(this.saveOrderButton_Click);
            // 
            // addOrderButton
            // 
            this.addOrderButton.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.addOrderButton.Location = new System.Drawing.Point(15, 252);
            this.addOrderButton.Name = "addOrderButton";
            this.addOrderButton.Size = new System.Drawing.Size(166, 26);
            this.addOrderButton.TabIndex = 2;
            this.addOrderButton.Text = "Add";
            this.addOrderButton.UseVisualStyleBackColor = true;
            this.addOrderButton.Click += new System.EventHandler(this.addOrderButton_Click);
            // 
            // orderList
            // 
            this.orderList.BackColor = System.Drawing.SystemColors.Window;
            this.orderList.Font = new System.Drawing.Font("Comic Sans MS", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.orderList.FormattingEnabled = true;
            this.orderList.ItemHeight = 19;
            this.orderList.Location = new System.Drawing.Point(15, 34);
            this.orderList.Name = "orderList";
            this.orderList.Size = new System.Drawing.Size(166, 194);
            this.orderList.TabIndex = 3;
            this.orderList.Click += new System.EventHandler(this.orderList_SingleClick);
            this.orderList.DoubleClick += new System.EventHandler(this.orderList_DoubleClick);
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(12, 18);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(52, 13);
            this.label11.TabIndex = 4;
            this.label11.Text = "Order List";
            // 
            // beverageTab
            // 
            this.beverageTab.BackColor = System.Drawing.Color.Tomato;
            this.beverageTab.Controls.Add(this.label7);
            this.beverageTab.Controls.Add(this.beverageTypes);
            this.beverageTab.Controls.Add(this.label9);
            this.beverageTab.Location = new System.Drawing.Point(4, 22);
            this.beverageTab.Name = "beverageTab";
            this.beverageTab.Padding = new System.Windows.Forms.Padding(3);
            this.beverageTab.Size = new System.Drawing.Size(545, 270);
            this.beverageTab.TabIndex = 4;
            this.beverageTab.Text = "Beverages";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(67, 58);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(85, 13);
            this.label7.TabIndex = 2;
            this.label7.Text = "Beverage Types";
            // 
            // beverageTypes
            // 
            this.beverageTypes.FormattingEnabled = true;
            this.beverageTypes.Location = new System.Drawing.Point(70, 74);
            this.beverageTypes.Name = "beverageTypes";
            this.beverageTypes.Size = new System.Drawing.Size(131, 95);
            this.beverageTypes.TabIndex = 1;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(119, 72);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(0, 13);
            this.label9.TabIndex = 0;
            // 
            // otherTab
            // 
            this.otherTab.BackColor = System.Drawing.Color.Tomato;
            this.otherTab.Controls.Add(this.label6);
            this.otherTab.Controls.Add(this.label5);
            this.otherTab.Controls.Add(this.label4);
            this.otherTab.Controls.Add(this.chickenstripTypes);
            this.otherTab.Controls.Add(this.breadstickTypes);
            this.otherTab.Controls.Add(this.wingTypes);
            this.otherTab.Location = new System.Drawing.Point(4, 22);
            this.otherTab.Name = "otherTab";
            this.otherTab.Padding = new System.Windows.Forms.Padding(3);
            this.otherTab.Size = new System.Drawing.Size(545, 270);
            this.otherTab.TabIndex = 1;
            this.otherTab.Text = "Other";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(28, 78);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(70, 13);
            this.label6.TabIndex = 6;
            this.label6.Text = "Chickenstrips";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(28, 145);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(62, 13);
            this.label5.TabIndex = 5;
            this.label5.Text = "Breadsticks";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(28, 20);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(37, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Wings";
            // 
            // chickenstripTypes
            // 
            this.chickenstripTypes.FormattingEnabled = true;
            this.chickenstripTypes.Location = new System.Drawing.Point(31, 94);
            this.chickenstripTypes.Name = "chickenstripTypes";
            this.chickenstripTypes.Size = new System.Drawing.Size(155, 21);
            this.chickenstripTypes.TabIndex = 2;
            // 
            // breadstickTypes
            // 
            this.breadstickTypes.FormattingEnabled = true;
            this.breadstickTypes.Location = new System.Drawing.Point(31, 161);
            this.breadstickTypes.Name = "breadstickTypes";
            this.breadstickTypes.Size = new System.Drawing.Size(155, 21);
            this.breadstickTypes.TabIndex = 1;
            // 
            // wingTypes
            // 
            this.wingTypes.FormattingEnabled = true;
            this.wingTypes.Location = new System.Drawing.Point(31, 36);
            this.wingTypes.Name = "wingTypes";
            this.wingTypes.Size = new System.Drawing.Size(155, 21);
            this.wingTypes.TabIndex = 0;
            // 
            // pizzaTab
            // 
            this.pizzaTab.BackColor = System.Drawing.Color.Tomato;
            this.pizzaTab.Controls.Add(this.pizzaSizeArea);
            this.pizzaTab.Controls.Add(this.pizzaTypeArea);
            this.pizzaTab.Controls.Add(this.customPizzaArea);
            this.pizzaTab.Location = new System.Drawing.Point(4, 22);
            this.pizzaTab.Name = "pizzaTab";
            this.pizzaTab.Padding = new System.Windows.Forms.Padding(3);
            this.pizzaTab.Size = new System.Drawing.Size(545, 270);
            this.pizzaTab.TabIndex = 0;
            this.pizzaTab.Text = "Pizza";
            // 
            // pizzaSizeArea
            // 
            this.pizzaSizeArea.Controls.Add(this.pizzaSizes);
            this.pizzaSizeArea.Location = new System.Drawing.Point(19, 131);
            this.pizzaSizeArea.Name = "pizzaSizeArea";
            this.pizzaSizeArea.Size = new System.Drawing.Size(186, 100);
            this.pizzaSizeArea.TabIndex = 11;
            this.pizzaSizeArea.TabStop = false;
            this.pizzaSizeArea.Text = "Pizza Sizes";
            // 
            // pizzaSizes
            // 
            this.pizzaSizes.FormattingEnabled = true;
            this.pizzaSizes.Location = new System.Drawing.Point(39, 40);
            this.pizzaSizes.Name = "pizzaSizes";
            this.pizzaSizes.Size = new System.Drawing.Size(121, 21);
            this.pizzaSizes.TabIndex = 9;
            this.pizzaSizes.SelectedIndexChanged += new System.EventHandler(this.pizzaSizes_SelectedIndexChanged);
            // 
            // pizzaTypeArea
            // 
            this.pizzaTypeArea.Controls.Add(this.pizzaTypes);
            this.pizzaTypeArea.Location = new System.Drawing.Point(19, 25);
            this.pizzaTypeArea.Name = "pizzaTypeArea";
            this.pizzaTypeArea.Size = new System.Drawing.Size(186, 100);
            this.pizzaTypeArea.TabIndex = 10;
            this.pizzaTypeArea.TabStop = false;
            this.pizzaTypeArea.Text = "Pizza Types";
            // 
            // pizzaTypes
            // 
            this.pizzaTypes.FormattingEnabled = true;
            this.pizzaTypes.Location = new System.Drawing.Point(39, 40);
            this.pizzaTypes.Name = "pizzaTypes";
            this.pizzaTypes.Size = new System.Drawing.Size(121, 21);
            this.pizzaTypes.TabIndex = 9;
            this.pizzaTypes.SelectionChangeCommitted += new System.EventHandler(this.pizzaTypes_SelectionChangeCommitted);
            // 
            // customPizzaArea
            // 
            this.customPizzaArea.Controls.Add(this.crustTypes);
            this.customPizzaArea.Controls.Add(this.label3);
            this.customPizzaArea.Controls.Add(this.sauceTypes);
            this.customPizzaArea.Controls.Add(this.label1);
            this.customPizzaArea.Controls.Add(this.label2);
            this.customPizzaArea.Controls.Add(this.toppingsList);
            this.customPizzaArea.Location = new System.Drawing.Point(223, 6);
            this.customPizzaArea.Name = "customPizzaArea";
            this.customPizzaArea.Size = new System.Drawing.Size(292, 215);
            this.customPizzaArea.TabIndex = 8;
            this.customPizzaArea.TabStop = false;
            this.customPizzaArea.Text = "Custom Pizza";
            // 
            // crustTypes
            // 
            this.crustTypes.FormattingEnabled = true;
            this.crustTypes.Location = new System.Drawing.Point(14, 158);
            this.crustTypes.Name = "crustTypes";
            this.crustTypes.Size = new System.Drawing.Size(121, 21);
            this.crustTypes.TabIndex = 11;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(11, 59);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(70, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Sauce Types";
            // 
            // sauceTypes
            // 
            this.sauceTypes.FormattingEnabled = true;
            this.sauceTypes.Location = new System.Drawing.Point(14, 75);
            this.sauceTypes.Name = "sauceTypes";
            this.sauceTypes.Size = new System.Drawing.Size(121, 21);
            this.sauceTypes.TabIndex = 10;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(151, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(79, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Pizza Toppings";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(11, 142);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Crust Types";
            // 
            // toppingsList
            // 
            this.toppingsList.FormattingEnabled = true;
            this.toppingsList.Location = new System.Drawing.Point(154, 35);
            this.toppingsList.Name = "toppingsList";
            this.toppingsList.Size = new System.Drawing.Size(132, 169);
            this.toppingsList.TabIndex = 0;
            // 
            // tabControl
            // 
            this.tabControl.Controls.Add(this.pizzaTab);
            this.tabControl.Controls.Add(this.otherTab);
            this.tabControl.Controls.Add(this.beverageTab);
            this.tabControl.Location = new System.Drawing.Point(196, 12);
            this.tabControl.Name = "tabControl";
            this.tabControl.SelectedIndex = 0;
            this.tabControl.Size = new System.Drawing.Size(553, 296);
            this.tabControl.TabIndex = 0;
            // 
            // OrderForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(765, 360);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.orderFormMessageArea);
            this.Controls.Add(this.orderList);
            this.Controls.Add(this.addOrderButton);
            this.Controls.Add(this.saveOrderButton);
            this.Controls.Add(this.tabControl);
            this.Name = "OrderForm";
            this.Text = "OrderForm";
            ((System.ComponentModel.ISupportInitialize)(this.orderListBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.orderBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.orderListBindingSource1)).EndInit();
            this.beverageTab.ResumeLayout(false);
            this.beverageTab.PerformLayout();
            this.otherTab.ResumeLayout(false);
            this.otherTab.PerformLayout();
            this.pizzaTab.ResumeLayout(false);
            this.pizzaSizeArea.ResumeLayout(false);
            this.pizzaTypeArea.ResumeLayout(false);
            this.customPizzaArea.ResumeLayout(false);
            this.customPizzaArea.PerformLayout();
            this.tabControl.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button saveOrderButton;
        private System.Windows.Forms.Label orderFormMessageArea;
        private System.Windows.Forms.Button addOrderButton;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.BindingSource orderListBindingSource;
        private System.Windows.Forms.BindingSource orderBindingSource;
        private System.Windows.Forms.BindingSource orderListBindingSource1;
        private System.Windows.Forms.TabPage beverageTab;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.ListBox beverageTypes;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.TabPage otherTab;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox chickenstripTypes;
        private System.Windows.Forms.ComboBox breadstickTypes;
        private System.Windows.Forms.ComboBox wingTypes;
        private System.Windows.Forms.TabPage pizzaTab;
        private System.Windows.Forms.GroupBox pizzaSizeArea;
        private System.Windows.Forms.ComboBox pizzaSizes;
        private System.Windows.Forms.GroupBox pizzaTypeArea;
        private System.Windows.Forms.ComboBox pizzaTypes;
        private System.Windows.Forms.GroupBox customPizzaArea;
        private System.Windows.Forms.ComboBox crustTypes;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox sauceTypes;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.CheckedListBox toppingsList;
        private System.Windows.Forms.TabControl tabControl;
        public System.Windows.Forms.ListBox orderList;


    }
}