namespace CIS2225_T8_Sigouin_Christopher
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
            this.menuStripParent = new System.Windows.Forms.MenuStrip();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.openToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.statusStripParent = new System.Windows.Forms.StatusStrip();
            this.statusStripLabelParent = new System.Windows.Forms.ToolStripStatusLabel();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.toolStripParent = new System.Windows.Forms.ToolStrip();
            this.tbOpenButton = new System.Windows.Forms.ToolStripButton();
            this.toolsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.dateTimePickerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStripParent.SuspendLayout();
            this.statusStripParent.SuspendLayout();
            this.toolStripParent.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStripParent
            // 
            this.menuStripParent.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem1,
            this.toolsToolStripMenuItem});
            this.menuStripParent.Location = new System.Drawing.Point(0, 0);
            this.menuStripParent.Name = "menuStripParent";
            this.menuStripParent.Size = new System.Drawing.Size(556, 24);
            this.menuStripParent.TabIndex = 0;
            this.menuStripParent.Text = "menuStrip1";
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.openToolStripMenuItem});
            this.toolStripMenuItem1.MergeAction = System.Windows.Forms.MergeAction.MatchOnly;
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(37, 20);
            this.toolStripMenuItem1.Text = "&File";
            // 
            // openToolStripMenuItem
            // 
            this.openToolStripMenuItem.MergeAction = System.Windows.Forms.MergeAction.Insert;
            this.openToolStripMenuItem.MergeIndex = 1;
            this.openToolStripMenuItem.Name = "openToolStripMenuItem";
            this.openToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.openToolStripMenuItem.Text = "&Open";
            this.openToolStripMenuItem.Click += new System.EventHandler(this.openToolStripMenuItem_Click);
            // 
            // statusStripParent
            // 
            this.statusStripParent.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.statusStripLabelParent});
            this.statusStripParent.Location = new System.Drawing.Point(0, 267);
            this.statusStripParent.Name = "statusStripParent";
            this.statusStripParent.Size = new System.Drawing.Size(556, 22);
            this.statusStripParent.TabIndex = 1;
            this.statusStripParent.Text = "statusStrip1";
            // 
            // statusStripLabelParent
            // 
            this.statusStripLabelParent.Name = "statusStripLabelParent";
            this.statusStripLabelParent.Size = new System.Drawing.Size(57, 17);
            this.statusStripLabelParent.Text = "Welcome";
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // toolStripParent
            // 
            this.toolStripParent.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tbOpenButton});
            this.toolStripParent.Location = new System.Drawing.Point(0, 24);
            this.toolStripParent.Name = "toolStripParent";
            this.toolStripParent.Size = new System.Drawing.Size(556, 25);
            this.toolStripParent.TabIndex = 3;
            this.toolStripParent.Text = "toolStrip1";
            // 
            // tbOpenButton
            // 
            this.tbOpenButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tbOpenButton.Image = ((System.Drawing.Image)(resources.GetObject("tbOpenButton.Image")));
            this.tbOpenButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tbOpenButton.MergeIndex = 1;
            this.tbOpenButton.Name = "tbOpenButton";
            this.tbOpenButton.Size = new System.Drawing.Size(23, 22);
            this.tbOpenButton.Text = "Open";
            this.tbOpenButton.Click += new System.EventHandler(this.tbOpenButton_Click);
            // 
            // toolsToolStripMenuItem
            // 
            this.toolsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.dateTimePickerToolStripMenuItem});
            this.toolsToolStripMenuItem.Name = "toolsToolStripMenuItem";
            this.toolsToolStripMenuItem.Size = new System.Drawing.Size(48, 20);
            this.toolsToolStripMenuItem.Text = "Tools";
            // 
            // dateTimePickerToolStripMenuItem
            // 
            this.dateTimePickerToolStripMenuItem.Name = "dateTimePickerToolStripMenuItem";
            this.dateTimePickerToolStripMenuItem.Size = new System.Drawing.Size(163, 22);
            this.dateTimePickerToolStripMenuItem.Text = "Date Time Picker";
            this.dateTimePickerToolStripMenuItem.Click += new System.EventHandler(this.dateTimePickerToolStripMenuItem_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(556, 289);
            this.Controls.Add(this.toolStripParent);
            this.Controls.Add(this.statusStripParent);
            this.Controls.Add(this.menuStripParent);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStripParent;
            this.Name = "MainForm";
            this.Text = "Simple Text Editor";
            this.MdiChildActivate += new System.EventHandler(this.MainForm_MdiChildActivate);
            this.menuStripParent.ResumeLayout(false);
            this.menuStripParent.PerformLayout();
            this.statusStripParent.ResumeLayout(false);
            this.statusStripParent.PerformLayout();
            this.toolStripParent.ResumeLayout(false);
            this.toolStripParent.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStripParent;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem openToolStripMenuItem;
        private System.Windows.Forms.StatusStrip statusStripParent;
        private System.Windows.Forms.ToolStripStatusLabel statusStripLabelParent;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.ToolStrip toolStripParent;
        private System.Windows.Forms.ToolStripButton tbOpenButton;
        private System.Windows.Forms.ToolStripMenuItem toolsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem dateTimePickerToolStripMenuItem;
    }
}

