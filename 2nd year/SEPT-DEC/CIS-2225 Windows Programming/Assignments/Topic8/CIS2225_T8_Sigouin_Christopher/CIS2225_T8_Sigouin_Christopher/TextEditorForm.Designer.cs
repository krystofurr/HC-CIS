namespace CIS2225_T8_Sigouin_Christopher
{
    partial class TextEditorForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TextEditorForm));
            this.textArea = new System.Windows.Forms.RichTextBox();
            this.menuStripChild = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
            this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
            this.statusStripChild = new System.Windows.Forms.StatusStrip();
            this.statusStripLabelChild = new System.Windows.Forms.ToolStripStatusLabel();
            this.toolStripChild = new System.Windows.Forms.ToolStrip();
            this.tbSaveButton = new System.Windows.Forms.ToolStripButton();
            this.tbCloseButton = new System.Windows.Forms.ToolStripButton();
            this.menuStripChild.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
            this.statusStripChild.SuspendLayout();
            this.toolStripChild.SuspendLayout();
            this.SuspendLayout();
            // 
            // textArea
            // 
            this.textArea.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textArea.Location = new System.Drawing.Point(0, 32);
            this.textArea.Name = "textArea";
            this.textArea.Size = new System.Drawing.Size(501, 230);
            this.textArea.TabIndex = 0;
            this.textArea.Text = "";
            this.textArea.Validating += new System.ComponentModel.CancelEventHandler(this.textArea_Validating);
            // 
            // menuStripChild
            // 
            this.menuStripChild.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem});
            this.menuStripChild.Location = new System.Drawing.Point(0, 0);
            this.menuStripChild.Name = "menuStripChild";
            this.menuStripChild.Size = new System.Drawing.Size(501, 24);
            this.menuStripChild.TabIndex = 1;
            this.menuStripChild.Text = "menuStrip1";
            this.menuStripChild.Visible = false;
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.saveToolStripMenuItem});
            this.fileToolStripMenuItem.MergeAction = System.Windows.Forms.MergeAction.MatchOnly;
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "&File";
            // 
            // saveToolStripMenuItem
            // 
            this.saveToolStripMenuItem.MergeAction = System.Windows.Forms.MergeAction.Insert;
            this.saveToolStripMenuItem.MergeIndex = 2;
            this.saveToolStripMenuItem.Name = "saveToolStripMenuItem";
            this.saveToolStripMenuItem.Size = new System.Drawing.Size(98, 22);
            this.saveToolStripMenuItem.Text = "Save";
            this.saveToolStripMenuItem.Click += new System.EventHandler(this.saveToolStripMenuItem_Click);
            // 
            // errorProvider1
            // 
            this.errorProvider1.ContainerControl = this;
            // 
            // statusStripChild
            // 
            this.statusStripChild.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.statusStripLabelChild});
            this.statusStripChild.Location = new System.Drawing.Point(0, 240);
            this.statusStripChild.Name = "statusStripChild";
            this.statusStripChild.Size = new System.Drawing.Size(501, 22);
            this.statusStripChild.TabIndex = 2;
            this.statusStripChild.Text = "statusStrip1";
            // 
            // statusStripLabelChild
            // 
            this.statusStripLabelChild.Name = "statusStripLabelChild";
            this.statusStripLabelChild.Size = new System.Drawing.Size(35, 17);
            this.statusStripLabelChild.Text = "Done";
            // 
            // toolStripChild
            // 
            this.toolStripChild.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tbSaveButton,
            this.tbCloseButton});
            this.toolStripChild.Location = new System.Drawing.Point(0, 0);
            this.toolStripChild.Name = "toolStripChild";
            this.toolStripChild.Size = new System.Drawing.Size(501, 25);
            this.toolStripChild.TabIndex = 3;
            this.toolStripChild.Text = "toolStrip1";
            this.toolStripChild.Visible = false;
            // 
            // tbSaveButton
            // 
            this.tbSaveButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tbSaveButton.Image = ((System.Drawing.Image)(resources.GetObject("tbSaveButton.Image")));
            this.tbSaveButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tbSaveButton.MergeAction = System.Windows.Forms.MergeAction.Insert;
            this.tbSaveButton.MergeIndex = 2;
            this.tbSaveButton.Name = "tbSaveButton";
            this.tbSaveButton.Size = new System.Drawing.Size(23, 22);
            this.tbSaveButton.Text = "Save";
            this.tbSaveButton.TextDirection = System.Windows.Forms.ToolStripTextDirection.Horizontal;
            this.tbSaveButton.Click += new System.EventHandler(this.tbSaveButton_Click);
            // 
            // tbCloseButton
            // 
            this.tbCloseButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tbCloseButton.Image = ((System.Drawing.Image)(resources.GetObject("tbCloseButton.Image")));
            this.tbCloseButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.tbCloseButton.MergeAction = System.Windows.Forms.MergeAction.Insert;
            this.tbCloseButton.MergeIndex = 3;
            this.tbCloseButton.Name = "tbCloseButton";
            this.tbCloseButton.Size = new System.Drawing.Size(23, 22);
            this.tbCloseButton.Text = "Close";
            this.tbCloseButton.Click += new System.EventHandler(this.tbCloseButton_Click);
            // 
            // TextEditorForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(501, 262);
            this.Controls.Add(this.toolStripChild);
            this.Controls.Add(this.statusStripChild);
            this.Controls.Add(this.textArea);
            this.Controls.Add(this.menuStripChild);
            this.MainMenuStrip = this.menuStripChild;
            this.Name = "TextEditorForm";
            this.Text = "TextEditorForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.TextEditorForm_FormClosing);
            this.menuStripChild.ResumeLayout(false);
            this.menuStripChild.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
            this.statusStripChild.ResumeLayout(false);
            this.statusStripChild.PerformLayout();
            this.toolStripChild.ResumeLayout(false);
            this.toolStripChild.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RichTextBox textArea;
        private System.Windows.Forms.MenuStrip menuStripChild;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem saveToolStripMenuItem;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
        private System.Windows.Forms.ErrorProvider errorProvider1;
        private System.Windows.Forms.StatusStrip statusStripChild;
        private System.Windows.Forms.ToolStrip toolStripChild;
        private System.Windows.Forms.ToolStripButton tbSaveButton;
        private System.Windows.Forms.ToolStripButton tbCloseButton;
        private System.Windows.Forms.ToolStripStatusLabel statusStripLabelChild;
    }
}