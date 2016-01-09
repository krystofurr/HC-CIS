namespace CIS2225_T4_Sigouin_Christopher
{
    partial class MainForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
            this.placeOrderButton = new System.Windows.Forms.Button();
            this.deliveryOptions = new System.Windows.Forms.GroupBox();
            this.yesRadioButton = new System.Windows.Forms.RadioButton();
            this.noRadioButton = new System.Windows.Forms.RadioButton();
            this.mainDisplayArea = new System.Windows.Forms.RichTextBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.quickHelpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutDaBigSliceToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.customerInfoButton = new System.Windows.Forms.Button();
            this.resetOrderButton = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.displayDetailsButton = new System.Windows.Forms.Button();
            this.printDialog1 = new System.Windows.Forms.PrintDialog();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.printToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.deliveryOptions.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // placeOrderButton
            // 
            this.placeOrderButton.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.placeOrderButton.Location = new System.Drawing.Point(113, 37);
            this.placeOrderButton.Margin = new System.Windows.Forms.Padding(6, 5, 6, 5);
            this.placeOrderButton.Name = "placeOrderButton";
            this.placeOrderButton.Size = new System.Drawing.Size(200, 39);
            this.placeOrderButton.TabIndex = 2;
            this.placeOrderButton.Text = "Place Order";
            this.placeOrderButton.UseVisualStyleBackColor = true;
            this.placeOrderButton.Click += new System.EventHandler(this.placeOrderButton_Click);
            // 
            // deliveryOptions
            // 
            this.deliveryOptions.Controls.Add(this.yesRadioButton);
            this.deliveryOptions.Controls.Add(this.noRadioButton);
            this.deliveryOptions.Enabled = false;
            this.deliveryOptions.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.deliveryOptions.Location = new System.Drawing.Point(231, 241);
            this.deliveryOptions.Margin = new System.Windows.Forms.Padding(6, 5, 6, 5);
            this.deliveryOptions.Name = "deliveryOptions";
            this.deliveryOptions.Padding = new System.Windows.Forms.Padding(6, 5, 6, 5);
            this.deliveryOptions.Size = new System.Drawing.Size(180, 78);
            this.deliveryOptions.TabIndex = 5;
            this.deliveryOptions.TabStop = false;
            this.deliveryOptions.Text = "Delivery Options";
            this.deliveryOptions.Enter += new System.EventHandler(this.deliveryOptions_Enter);
            // 
            // yesRadioButton
            // 
            this.yesRadioButton.AutoSize = true;
            this.yesRadioButton.Location = new System.Drawing.Point(12, 32);
            this.yesRadioButton.Margin = new System.Windows.Forms.Padding(6, 5, 6, 5);
            this.yesRadioButton.Name = "yesRadioButton";
            this.yesRadioButton.Size = new System.Drawing.Size(65, 26);
            this.yesRadioButton.TabIndex = 1;
            this.yesRadioButton.TabStop = true;
            this.yesRadioButton.Text = "YES";
            this.yesRadioButton.UseVisualStyleBackColor = true;
            // 
            // noRadioButton
            // 
            this.noRadioButton.AutoSize = true;
            this.noRadioButton.Location = new System.Drawing.Point(107, 32);
            this.noRadioButton.Margin = new System.Windows.Forms.Padding(6, 5, 6, 5);
            this.noRadioButton.Name = "noRadioButton";
            this.noRadioButton.Size = new System.Drawing.Size(57, 26);
            this.noRadioButton.TabIndex = 0;
            this.noRadioButton.TabStop = true;
            this.noRadioButton.Text = "NO";
            this.noRadioButton.UseVisualStyleBackColor = true;
            // 
            // mainDisplayArea
            // 
            this.mainDisplayArea.BackColor = System.Drawing.Color.Tomato;
            this.mainDisplayArea.Font = new System.Drawing.Font("Comic Sans MS", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.mainDisplayArea.Location = new System.Drawing.Point(420, 39);
            this.mainDisplayArea.Name = "mainDisplayArea";
            this.mainDisplayArea.ReadOnly = true;
            this.mainDisplayArea.Size = new System.Drawing.Size(334, 280);
            this.mainDisplayArea.TabIndex = 6;
            this.mainDisplayArea.Text = "Welcome to \"Da Big Slice\"";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.helpToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(766, 24);
            this.menuStrip1.TabIndex = 7;
            this.menuStrip1.Text = "menuStrip1";
            this.menuStrip1.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.menuStrip1_ItemClicked);
            // 
            // helpToolStripMenuItem
            // 
            this.helpToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.quickHelpToolStripMenuItem,
            this.aboutDaBigSliceToolStripMenuItem});
            this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
            this.helpToolStripMenuItem.Size = new System.Drawing.Size(44, 20);
            this.helpToolStripMenuItem.Text = "Help";
            // 
            // quickHelpToolStripMenuItem
            // 
            this.quickHelpToolStripMenuItem.Name = "quickHelpToolStripMenuItem";
            this.quickHelpToolStripMenuItem.Size = new System.Drawing.Size(171, 22);
            this.quickHelpToolStripMenuItem.Text = "Quick Help";
            this.quickHelpToolStripMenuItem.Click += new System.EventHandler(this.quickHelpToolStripMenuItem_Click);
            // 
            // aboutDaBigSliceToolStripMenuItem
            // 
            this.aboutDaBigSliceToolStripMenuItem.Name = "aboutDaBigSliceToolStripMenuItem";
            this.aboutDaBigSliceToolStripMenuItem.Size = new System.Drawing.Size(171, 22);
            this.aboutDaBigSliceToolStripMenuItem.Text = "About Da Big Slice";
            this.aboutDaBigSliceToolStripMenuItem.Click += new System.EventHandler(this.aboutDaBigSliceToolStripMenuItem_Click);
            // 
            // customerInfoButton
            // 
            this.customerInfoButton.Enabled = false;
            this.customerInfoButton.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.customerInfoButton.Location = new System.Drawing.Point(113, 86);
            this.customerInfoButton.Margin = new System.Windows.Forms.Padding(6, 5, 6, 5);
            this.customerInfoButton.Name = "customerInfoButton";
            this.customerInfoButton.Size = new System.Drawing.Size(200, 39);
            this.customerInfoButton.TabIndex = 8;
            this.customerInfoButton.Text = "Customer Info";
            this.customerInfoButton.UseVisualStyleBackColor = true;
            this.customerInfoButton.Click += new System.EventHandler(this.customerInfoButton_Click);
            // 
            // resetOrderButton
            // 
            this.resetOrderButton.Enabled = false;
            this.resetOrderButton.Font = new System.Drawing.Font("Times New Roman", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.resetOrderButton.Location = new System.Drawing.Point(617, 325);
            this.resetOrderButton.Name = "resetOrderButton";
            this.resetOrderButton.Size = new System.Drawing.Size(90, 23);
            this.resetOrderButton.TabIndex = 9;
            this.resetOrderButton.Text = "Reset Order";
            this.resetOrderButton.UseVisualStyleBackColor = true;
            this.resetOrderButton.Click += new System.EventHandler(this.resetOrderButton_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(0, 165);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(222, 200);
            this.pictureBox1.TabIndex = 10;
            this.pictureBox1.TabStop = false;
            // 
            // displayDetailsButton
            // 
            this.displayDetailsButton.Enabled = false;
            this.displayDetailsButton.Font = new System.Drawing.Font("Times New Roman", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.displayDetailsButton.Location = new System.Drawing.Point(481, 325);
            this.displayDetailsButton.Name = "displayDetailsButton";
            this.displayDetailsButton.Size = new System.Drawing.Size(103, 23);
            this.displayDetailsButton.TabIndex = 11;
            this.displayDetailsButton.Text = "Display Details";
            this.displayDetailsButton.UseVisualStyleBackColor = true;
            this.displayDetailsButton.Click += new System.EventHandler(this.displayDetailsButton_Click);
            // 
            // printDialog1
            // 
            this.printDialog1.UseEXDialog = true;
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.printToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // printToolStripMenuItem
            // 
            this.printToolStripMenuItem.Name = "printToolStripMenuItem";
            this.printToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.printToolStripMenuItem.Text = "Print";
            this.printToolStripMenuItem.Click += new System.EventHandler(this.printToolStripMenuItem_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(766, 364);
            this.Controls.Add(this.displayDetailsButton);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.resetOrderButton);
            this.Controls.Add(this.customerInfoButton);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.mainDisplayArea);
            this.Controls.Add(this.deliveryOptions);
            this.Controls.Add(this.placeOrderButton);
            this.Name = "MainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Da Big Slice";
            this.deliveryOptions.ResumeLayout(false);
            this.deliveryOptions.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button placeOrderButton;
        private System.Windows.Forms.GroupBox deliveryOptions;
        private System.Windows.Forms.RadioButton yesRadioButton;
        private System.Windows.Forms.RadioButton noRadioButton;
        private System.Windows.Forms.RichTextBox mainDisplayArea;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem quickHelpToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aboutDaBigSliceToolStripMenuItem;
        private System.Windows.Forms.Button customerInfoButton;
        private System.Windows.Forms.Button resetOrderButton;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button displayDetailsButton;
        private System.Windows.Forms.PrintDialog printDialog1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem printToolStripMenuItem;

    }
}