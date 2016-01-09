/*
             _____           _         ___       _            _                                  _   
            |_   _|__  _ __ (_) ___   ( _ )     / \   ___ ___(_) __ _ _ __  _ __ ___   ___ _ __ | |_ 
              | |/ _ \| '_ \| |/ __|  / _ \    / _ \ / __/ __| |/ _` | '_ \| '_ ` _ \ / _ \ '_ \| __|
              | | (_) | |_) | | (__  | (_) |  / ___ \\__ \__ \ | (_| | | | | | | | | |  __/ | | | |_ 
              |_|\___/| .__/|_|\___|  \___/  /_/   \_\___/___/_|\__, |_| |_|_| |_| |_|\___|_| |_|\__|
                      |_|                                       |___/                          

    Program name: Simple Text Editor
    Author: Christopher Sigouin
    Version: 1
    Description:  Simple text editor to open and save plain text documents
    Dependencies: N/A
    Database file: N/A
    Change History: 2015.12.06 Original version by CJS

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

namespace CIS2225_T8_Sigouin_Christopher
{
    public partial class DateTimePickerForm : Form
    {
        // Instance of the active TextEditorForm
        TextEditorForm textEditor;

        public DateTimePickerForm(TextEditorForm textEditor)
        {
			// Instance of the focused textEditor
            this.textEditor = textEditor;
            InitializeComponent();
        }

		/*
            Function name: okButton_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Allows user to save the date selected in the focused child form
            Inputs:
            Outputs:
            Return value: N/A
            Change History: 2015.12.04 Original version by CJS
        */
        private void okButton_Click(object sender, EventArgs e)
        {
            textEditor.DateChosen = dateTimePicker1.Value.ToString();
            Console.Write("[ Date Time Picker Form ] You chose => " + textEditor.DateChosen + Environment.NewLine);
            Console.Write("[ Date Time Picker Form ] File affected => " + textEditor.FileName + Environment.NewLine);
            Close();
        }

		/*
            Function name: cancelButton_Click
            Version: 1
            Author: Christopher Sigouin
            Description: Allows user to cancel and close the form
            Inputs:
            Outputs:
            Return value: N/A
            Change History: 2015.12.04 Original version by CJS
        */
        private void cancelButton_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
