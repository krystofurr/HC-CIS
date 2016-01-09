namespace StudentDisplayForm
{
    partial class studentDisplayForm
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
            this.displayBox = new System.Windows.Forms.RichTextBox();
            this.displayStudentButton = new System.Windows.Forms.Button();
            this.resetButton = new System.Windows.Forms.Button();
            this.displayGraduateButton = new System.Windows.Forms.Button();
            this.displayUndergraduateButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // displayBox
            // 
            this.displayBox.Location = new System.Drawing.Point(12, 12);
            this.displayBox.Name = "displayBox";
            this.displayBox.ReadOnly = true;
            this.displayBox.Size = new System.Drawing.Size(721, 127);
            this.displayBox.TabIndex = 0;
            this.displayBox.Text = "";
            // 
            // displayStudentButton
            // 
            this.displayStudentButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.displayStudentButton.Location = new System.Drawing.Point(12, 145);
            this.displayStudentButton.Name = "displayStudentButton";
            this.displayStudentButton.Size = new System.Drawing.Size(145, 32);
            this.displayStudentButton.TabIndex = 1;
            this.displayStudentButton.Text = "Display Student";
            this.displayStudentButton.UseVisualStyleBackColor = true;
            this.displayStudentButton.Click += new System.EventHandler(this.displayStudentButton_Click);
            // 
            // resetButton
            // 
            this.resetButton.Location = new System.Drawing.Point(616, 227);
            this.resetButton.Name = "resetButton";
            this.resetButton.Size = new System.Drawing.Size(98, 23);
            this.resetButton.TabIndex = 2;
            this.resetButton.Text = "Reset Display";
            this.resetButton.UseVisualStyleBackColor = true;
            this.resetButton.Click += new System.EventHandler(this.resetButton_Click);
            // 
            // displayGraduateButton
            // 
            this.displayGraduateButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.displayGraduateButton.Location = new System.Drawing.Point(199, 145);
            this.displayGraduateButton.Name = "displayGraduateButton";
            this.displayGraduateButton.Size = new System.Drawing.Size(228, 32);
            this.displayGraduateButton.TabIndex = 3;
            this.displayGraduateButton.Text = "Display Graduate Student";
            this.displayGraduateButton.UseVisualStyleBackColor = true;
            this.displayGraduateButton.Click += new System.EventHandler(this.displayGraduateButton_Click);
            // 
            // displayUndergraduateButton
            // 
            this.displayUndergraduateButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.displayUndergraduateButton.Location = new System.Drawing.Point(463, 145);
            this.displayUndergraduateButton.Name = "displayUndergraduateButton";
            this.displayUndergraduateButton.Size = new System.Drawing.Size(270, 32);
            this.displayUndergraduateButton.TabIndex = 4;
            this.displayUndergraduateButton.Text = "Display Undergraduate Student";
            this.displayUndergraduateButton.UseVisualStyleBackColor = true;
            this.displayUndergraduateButton.Click += new System.EventHandler(this.displayUndergraduateButton_Click);
            // 
            // studentDisplayForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(745, 262);
            this.Controls.Add(this.displayUndergraduateButton);
            this.Controls.Add(this.displayGraduateButton);
            this.Controls.Add(this.resetButton);
            this.Controls.Add(this.displayStudentButton);
            this.Controls.Add(this.displayBox);
            this.Name = "studentDisplayForm";
            this.Text = "Student Display Form";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.RichTextBox displayBox;
        private System.Windows.Forms.Button displayStudentButton;
        private System.Windows.Forms.Button resetButton;
        private System.Windows.Forms.Button displayGraduateButton;
        private System.Windows.Forms.Button displayUndergraduateButton;
    }
}

