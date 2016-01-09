namespace CIS2225_Topic6_SigouinChristopher
{
    partial class RnrBooks
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
            this.addButton = new System.Windows.Forms.Button();
            this.bookTitleComboBox = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.isbnTextBox = new System.Windows.Forms.TextBox();
            this.bookDetailsGroupBox = new System.Windows.Forms.GroupBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.shelfTextBox = new System.Windows.Forms.TextBox();
            this.titleTextBox = new System.Windows.Forms.TextBox();
            this.authorTextBox = new System.Windows.Forms.TextBox();
            this.subjectTextBox = new System.Windows.Forms.TextBox();
            this.publisherTextBox = new System.Windows.Forms.TextBox();
            this.editButton = new System.Windows.Forms.Button();
            this.deleteButton = new System.Windows.Forms.Button();
            this.saveButton = new System.Windows.Forms.Button();
            this.fictionCheckBox = new System.Windows.Forms.CheckBox();
            this.bookDetailsGroupBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // addButton
            // 
            this.addButton.Location = new System.Drawing.Point(128, 102);
            this.addButton.Name = "addButton";
            this.addButton.Size = new System.Drawing.Size(75, 23);
            this.addButton.TabIndex = 0;
            this.addButton.Text = "Add";
            this.addButton.UseVisualStyleBackColor = true;
            this.addButton.Click += new System.EventHandler(this.addButton_Click);
            // 
            // bookTitleComboBox
            // 
            this.bookTitleComboBox.FormattingEnabled = true;
            this.bookTitleComboBox.Location = new System.Drawing.Point(43, 45);
            this.bookTitleComboBox.Name = "bookTitleComboBox";
            this.bookTitleComboBox.Size = new System.Drawing.Size(251, 21);
            this.bookTitleComboBox.TabIndex = 1;
            this.bookTitleComboBox.SelectedIndexChanged += new System.EventHandler(this.bookTitleComboBox_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(22, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(32, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "ISBN";
            // 
            // isbnTextBox
            // 
            this.isbnTextBox.Enabled = false;
            this.isbnTextBox.Location = new System.Drawing.Point(97, 19);
            this.isbnTextBox.Name = "isbnTextBox";
            this.isbnTextBox.Size = new System.Drawing.Size(140, 20);
            this.isbnTextBox.TabIndex = 3;
            // 
            // bookDetailsGroupBox
            // 
            this.bookDetailsGroupBox.Controls.Add(this.fictionCheckBox);
            this.bookDetailsGroupBox.Controls.Add(this.label7);
            this.bookDetailsGroupBox.Controls.Add(this.label6);
            this.bookDetailsGroupBox.Controls.Add(this.label5);
            this.bookDetailsGroupBox.Controls.Add(this.label4);
            this.bookDetailsGroupBox.Controls.Add(this.label3);
            this.bookDetailsGroupBox.Controls.Add(this.label2);
            this.bookDetailsGroupBox.Controls.Add(this.shelfTextBox);
            this.bookDetailsGroupBox.Controls.Add(this.titleTextBox);
            this.bookDetailsGroupBox.Controls.Add(this.authorTextBox);
            this.bookDetailsGroupBox.Controls.Add(this.subjectTextBox);
            this.bookDetailsGroupBox.Controls.Add(this.publisherTextBox);
            this.bookDetailsGroupBox.Controls.Add(this.isbnTextBox);
            this.bookDetailsGroupBox.Controls.Add(this.label1);
            this.bookDetailsGroupBox.Location = new System.Drawing.Point(337, 12);
            this.bookDetailsGroupBox.Name = "bookDetailsGroupBox";
            this.bookDetailsGroupBox.Size = new System.Drawing.Size(243, 221);
            this.bookDetailsGroupBox.TabIndex = 4;
            this.bookDetailsGroupBox.TabStop = false;
            this.bookDetailsGroupBox.Text = "Book Details";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(22, 178);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(38, 13);
            this.label7.TabIndex = 15;
            this.label7.Text = "Fiction";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(22, 100);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(50, 13);
            this.label6.TabIndex = 14;
            this.label6.Text = "Publisher";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(16, 152);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(75, 13);
            this.label5.TabIndex = 13;
            this.label5.Text = "Shelf Location";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 126);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(71, 13);
            this.label4.TabIndex = 12;
            this.label4.Text = "Subject Code";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(22, 74);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(38, 13);
            this.label3.TabIndex = 11;
            this.label3.Text = "Author";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(22, 48);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(27, 13);
            this.label2.TabIndex = 10;
            this.label2.Text = "Title";
            // 
            // shelfTextBox
            // 
            this.shelfTextBox.Enabled = false;
            this.shelfTextBox.Location = new System.Drawing.Point(97, 149);
            this.shelfTextBox.Name = "shelfTextBox";
            this.shelfTextBox.Size = new System.Drawing.Size(140, 20);
            this.shelfTextBox.TabIndex = 9;
            // 
            // titleTextBox
            // 
            this.titleTextBox.Enabled = false;
            this.titleTextBox.Location = new System.Drawing.Point(97, 45);
            this.titleTextBox.Name = "titleTextBox";
            this.titleTextBox.Size = new System.Drawing.Size(140, 20);
            this.titleTextBox.TabIndex = 8;
            // 
            // authorTextBox
            // 
            this.authorTextBox.Enabled = false;
            this.authorTextBox.Location = new System.Drawing.Point(97, 71);
            this.authorTextBox.Name = "authorTextBox";
            this.authorTextBox.Size = new System.Drawing.Size(140, 20);
            this.authorTextBox.TabIndex = 7;
            // 
            // subjectTextBox
            // 
            this.subjectTextBox.Enabled = false;
            this.subjectTextBox.Location = new System.Drawing.Point(97, 123);
            this.subjectTextBox.Name = "subjectTextBox";
            this.subjectTextBox.Size = new System.Drawing.Size(140, 20);
            this.subjectTextBox.TabIndex = 6;
            // 
            // publisherTextBox
            // 
            this.publisherTextBox.Enabled = false;
            this.publisherTextBox.Location = new System.Drawing.Point(97, 97);
            this.publisherTextBox.Name = "publisherTextBox";
            this.publisherTextBox.Size = new System.Drawing.Size(140, 20);
            this.publisherTextBox.TabIndex = 4;
            // 
            // editButton
            // 
            this.editButton.Location = new System.Drawing.Point(128, 131);
            this.editButton.Name = "editButton";
            this.editButton.Size = new System.Drawing.Size(75, 23);
            this.editButton.TabIndex = 5;
            this.editButton.Text = "Edit";
            this.editButton.UseVisualStyleBackColor = true;
            this.editButton.Click += new System.EventHandler(this.editButton_Click);
            // 
            // deleteButton
            // 
            this.deleteButton.Location = new System.Drawing.Point(128, 160);
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.Size = new System.Drawing.Size(75, 23);
            this.deleteButton.TabIndex = 6;
            this.deleteButton.Text = "Delete";
            this.deleteButton.UseVisualStyleBackColor = true;
            this.deleteButton.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // saveButton
            // 
            this.saveButton.Location = new System.Drawing.Point(395, 239);
            this.saveButton.Name = "saveButton";
            this.saveButton.Size = new System.Drawing.Size(140, 23);
            this.saveButton.TabIndex = 7;
            this.saveButton.Text = "Save";
            this.saveButton.UseVisualStyleBackColor = true;
            this.saveButton.Click += new System.EventHandler(this.saveButton_Click);
            // 
            // fictionCheckBox
            // 
            this.fictionCheckBox.AutoSize = true;
            this.fictionCheckBox.Location = new System.Drawing.Point(97, 178);
            this.fictionCheckBox.Name = "fictionCheckBox";
            this.fictionCheckBox.Size = new System.Drawing.Size(15, 14);
            this.fictionCheckBox.TabIndex = 16;
            this.fictionCheckBox.UseVisualStyleBackColor = true;
            // 
            // RnrBooks
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(603, 283);
            this.Controls.Add(this.saveButton);
            this.Controls.Add(this.deleteButton);
            this.Controls.Add(this.editButton);
            this.Controls.Add(this.bookDetailsGroupBox);
            this.Controls.Add(this.bookTitleComboBox);
            this.Controls.Add(this.addButton);
            this.Name = "RnrBooks";
            this.Text = "RNR Book Manager";
            this.bookDetailsGroupBox.ResumeLayout(false);
            this.bookDetailsGroupBox.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button addButton;
        private System.Windows.Forms.ComboBox bookTitleComboBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox isbnTextBox;
        private System.Windows.Forms.GroupBox bookDetailsGroupBox;
        private System.Windows.Forms.TextBox shelfTextBox;
        private System.Windows.Forms.TextBox titleTextBox;
        private System.Windows.Forms.TextBox authorTextBox;
        private System.Windows.Forms.TextBox subjectTextBox;
        private System.Windows.Forms.TextBox publisherTextBox;
        private System.Windows.Forms.Button editButton;
        private System.Windows.Forms.Button deleteButton;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button saveButton;
        private System.Windows.Forms.CheckBox fictionCheckBox;
    }
}

