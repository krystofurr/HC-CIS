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
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        /*
            Function name: openToolStripMenuItem_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Open functionality to allow a user to open a previously saved file
            Inputs:
            Outputs:
            Return value: N/A
            Change History: 2015.12.04 Original version by CJS
        */
        private void openToolStripMenuItem_Click(object sender, EventArgs e)
            string info;

            // Change the status strip text

            try
            {
                // Get the result of the openFileDialog to check for "Open" or "Cancel"
                DialogResult openFileResult = openFileDialog1.ShowDialog();
                    // Change the status strip text
                    statusStripLabelParent.Text = "Done";
                    using (StreamReader getInfo = new StreamReader(openFileDialog1.FileName))
                    {

                        // Create a new form
                        textEditor = new TextEditorForm();
                        textEditor.MdiParent = this;
                        textEditor.Text = textEditor.FileName = openFileDialog1.SafeFileName;
                        textEditor.SaveToolStripMenuItem.Text = "Save ( " + openFileDialog1.SafeFileName + " )";

                        // Better to use EOF when possible!!!
                        while ((info = getInfo.ReadLine()) != null)
                        {

                            textEditor.TextArea.Text += info;

                        } // END: WHILE
                    } // END : USING

                    // Get the data size for error checking
                    textEditor.FileSize = textEditor.TextArea.TextLength;
                    Console.Write("Filesize of [" + openFileDialog1.SafeFileName + "] => " + textEditor.FileSize + Environment.NewLine);

                    textEditor.Show();

                    // Change the status strip text
                    statusStripLabelParent.Text = "Done";
            }
            catch (Exception ex)
            {
                Console.Write(ex.Message);   
            }

            
        }

        // REF: http://www.codeproject.com/Questions/183070/Mdi-Application-Toolstrip-Merging
		/*
        private void MainForm_MdiChildActivate(object sender, EventArgs e)
        {

            ToolStripManager.RevertMerge(toolStripParent);
 
            TextEditorForm textEditor = ActiveMdiChild as TextEditorForm;
                ToolStripManager.Merge(textEditor.ToolStripChild, toolStripParent);

        private void tbOpenButton_Click(object sender, EventArgs e)

        private void dateTimePickerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // Check to see if there are any child forms open to apply the date
                // Change the status strip text
                statusStripLabelParent.Text = "No child text editor forms to apply the date with.  Exiting...";

            


    }
}