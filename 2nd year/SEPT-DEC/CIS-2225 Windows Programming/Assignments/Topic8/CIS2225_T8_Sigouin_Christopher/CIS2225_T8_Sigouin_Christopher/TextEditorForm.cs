﻿/*
            |_   _|__  _ __ (_) ___   ( _ )     / \   ___ ___(_) __ _ _ __  _ __ ___   ___ _ __ | |_ 
              | |/ _ \| '_ \| |/ __|  / _ \    / _ \ / __/ __| |/ _` | '_ \| '_ ` _ \ / _ \ '_ \| __|
              | | (_) | |_) | | (__  | (_) |  / ___ \\__ \__ \ | (_| | | | | | | | | |  __/ | | | |_ 
              |_|\___/| .__/|_|\___|  \___/  /_/   \_\___/___/_|\__, |_| |_|_| |_| |_|\___|_| |_|\__|
                      |_|                                       |___/                          
    Program name: Simple Text Editor
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
    public partial class TextEditorForm : Form
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
            // Check if string is empty
                    {

                    DialogResult saveFileResult = saveFileDialog1.ShowDialog();
                        // true meaning " append mode "
                        using (StreamWriter storeInfo = new StreamWriter(saveFileDialog1.FileName))
                        {
                            if( !String.IsNullOrEmpty(dateChosen) ) { textArea.Text += " [ Date Written: " + dateChosen + " ]"; }
                            storeInfo.WriteLine(textArea.Text);
                            // Reset " dateChosen "

                    // Change the status strip text
                    statusStripLabelChild.Text = "Done";

                }
                catch (Exception ex)
                {

                }

            
        }


		/*
        private void tbSaveButton_Click(object sender, EventArgs e)
        {
            // Just call the same " Save " functionality within the child form's menustrip
            saveToolStripMenuItem_Click(sender, e);
        }

        private void tbCloseButton_Click(object sender, EventArgs e)
        {
            // Close this form

        private void textArea_Validating(object sender, CancelEventArgs e)
        {
      
            // Cancel the event
            e.Cancel = true;
            // Display our error
            errorProvider1.SetError(textArea, "You must alter the file in order to save it!");

        private void TextEditorForm_FormClosing(object sender, FormClosingEventArgs e)



    }
}