/*             _____           _         ___       _            _                                  _   
            |_   _|__  _ __ (_) ___   ( _ )     / \   ___ ___(_) __ _ _ __  _ __ ___   ___ _ __ | |_ 
              | |/ _ \| '_ \| |/ __|  / _ \    / _ \ / __/ __| |/ _` | '_ \| '_ ` _ \ / _ \ '_ \| __|
              | | (_) | |_) | | (__  | (_) |  / ___ \\__ \__ \ | (_| | | | | | | | | |  __/ | | | |_ 
              |_|\___/| .__/|_|\___|  \___/  /_/   \_\___/___/_|\__, |_| |_|_| |_| |_|\___|_| |_|\__|
                      |_|                                       |___/                          
    Program name: Simple Text Editor    Author: Christopher Sigouin    Version: 1    Description:  Simple text editor to open and save plain text documents    Dependencies: N/A    Database file: N/A    Change History: 2015.12.06 Original version by CJS
*/

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS2225_T8_Sigouin_Christopher
{
    public partial class TextEditorForm : Form    {        private int fileSize;        private string fileName;        private string dateChosen = "";        public string FileName        {            get { return fileName; }            set { fileName = value; }        }        public string DateChosen        {            get { return dateChosen; }            set { dateChosen = value; }        }        public ToolStrip ToolStripChild        {            get { return toolStripChild; }            set { toolStripChild = value; }        }        public int FileSize        {            get { return fileSize; }            set { fileSize = value; }        }        public RichTextBox TextArea        {            get { return textArea; }            set { textArea = value; }        }        public ToolStripMenuItem SaveToolStripMenuItem        {            get { return saveToolStripMenuItem; }            set { saveToolStripMenuItem = value; }        }        public TextEditorForm()
        {
            InitializeComponent();

            // Set to maximized by default
            //this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
        }

        /*
            Function name: saveToolStripMenuItem_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Save functionality for each child menu that holds a text file
            Inputs:
            Outputs:
            Return value: N/A
            Change History: 2015.12.04 Original version by CJS
        */
        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // Change the status strip text
            statusStripLabelChild.Text = "Saving...";

            // Clear previous error messages
            errorProvider1.SetError(textArea, string.Empty);
            // Check if string is empty            if (textArea.TextLength == fileSize)            {                CancelEventArgs cancelEvent = new CancelEventArgs();                textArea_Validating(sender, cancelEvent);            }            else            {                            try
                    {

                    DialogResult saveFileResult = saveFileDialog1.ShowDialog();                    if (saveFileResult == DialogResult.OK)                    {
                        // true meaning " append mode "
                        using (StreamWriter storeInfo = new StreamWriter(saveFileDialog1.FileName))
                        {
                            if( !String.IsNullOrEmpty(dateChosen) ) { textArea.Text += " [ Date Written: " + dateChosen + " ]"; }
                            storeInfo.WriteLine(textArea.Text);
                            // Reset " dateChosen "                            dateChosen = "";                        } // END: USING                                            }

                    // Change the status strip text
                    statusStripLabelChild.Text = "Done";

                }
                catch (Exception ex)
                {

                }                            }

            
        }


		/*            Function name: tbSaveButton_Click            Version: 1            Author: Christopher Sigouin            Description: Save functionality for each child menu that holds a text file ( Toolbar )            Inputs:            Outputs:            Return value: N/A            Change History: 2015.12.04 Original version by CJS        */
        private void tbSaveButton_Click(object sender, EventArgs e)
        {
            // Just call the same " Save " functionality within the child form's menustrip
            saveToolStripMenuItem_Click(sender, e);
        }
		/*            Function name: tbCloseButton_Click            Version: 1            Author: Christopher Sigouin            Description: Close functionality for each child menu that holds a text file ( Toolbar )            Inputs:            Outputs:            Return value: N/A            Change History: 2015.12.04 Original version by CJS        */
        private void tbCloseButton_Click(object sender, EventArgs e)
        {
            // Close this form            this.Close();        }
		/*            Function name: textArea_Validating            Version: 1            Author: Christopher Sigouin            Description: Validating event for each rich text field in every child menu            Inputs:            Outputs:            Return value: N/A            Change History: 2015.12.04 Original version by CJS        */
        private void textArea_Validating(object sender, CancelEventArgs e)
        {
      
            // Cancel the event
            e.Cancel = true;
            // Display our error
            errorProvider1.SetError(textArea, "You must alter the file in order to save it!");            statusStripLabelChild.Text = errorProvider1.GetError(textArea);        }
		/*            Function name: TextEditorForm_FormClosing            Version: 1            Author: Christopher Sigouin            Description: Allows the form to still be closed regardless if there is an error found            Inputs:            Outputs:            Return value: N/A            Change History: 2015.12.04 Original version by CJS        */
        private void TextEditorForm_FormClosing(object sender, FormClosingEventArgs e)        {            e.Cancel = false;        }



    }
}
