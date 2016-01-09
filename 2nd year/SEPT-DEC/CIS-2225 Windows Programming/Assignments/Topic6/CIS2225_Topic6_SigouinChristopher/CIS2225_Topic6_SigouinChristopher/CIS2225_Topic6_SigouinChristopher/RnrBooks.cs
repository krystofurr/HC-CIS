/*
 _____           _         __     ____             ____              _        
|_   _|__  _ __ (_) ___   / /_   |  _ \ _ __  _ __| __ )  ___   ___ | | _____ 
  | |/ _ \| '_ \| |/ __| | '_ \  | |_) | '_ \| '__|  _ \ / _ \ / _ \| |/ / __|
  | | (_) | |_) | | (__  | (_) | |  _ <| | | | |  | |_) | (_) | (_) |   <\__ \
  |_|\___/| .__/|_|\___|  \___/  |_| \_\_| |_|_|  |____/ \___/ \___/|_|\_\___/
          |_|    

    Program name: RnrBooks Database Management Application
    Author: Christopher Sigouin
    Version: 1
    Description: An application that interfaces with a local datatbase applying CRUD functionalities
    Dependencies: N/A
    Database file: N/A
    Change History: 2015.11.23 Original version by CJS

 
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

namespace CIS2225_Topic6_SigouinChristopher
{
    public partial class RnrBooks : Form
    {
        public const string SAVE_BUTTON_TEXT_DEFAULT = "Save";
        public const string SAVE_BUTTON_TEXT_ADD_MODE = "Save ( Add Mode )";
        public const string SAVE_BUTTON_TEXT_EDIT_MODE = "Save ( Edit Mode )";

        BookHandler bookHandler;
        

        public ComboBox BookTitleComboBox
        {
            get { return bookTitleComboBox; }
            set { bookTitleComboBox = value; }
        }

        public TextBox IsbnTextBox
        {
            get { return isbnTextBox; }
            set { isbnTextBox = value; }
        }

        public TextBox ShelfTextBox
        {
            get { return shelfTextBox; }
            set { shelfTextBox = value; }
        }

        public TextBox TitleTextBox
        {
            get { return titleTextBox; }
            set { titleTextBox = value; }
        }

        public TextBox AuthorTextBox
        {
            get { return authorTextBox; }
            set { authorTextBox = value; }
        }

        public TextBox SubjectTextBox
        {
            get { return subjectTextBox; }
            set { subjectTextBox = value; }
        }

        public CheckBox FictionCheckBox
        {
            get { return fictionCheckBox; }
            set { fictionCheckBox = value; }
        }

        public TextBox PublisherTextBox
        {
            get { return publisherTextBox; }
            set { publisherTextBox = value; }
        }

        /*
           Function name: Custom Constructor RnrBooks
           Version: 1
           Author: Christopher Sigouin
           Description: Initializes the form
           Inputs:
           Outputs:
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        public RnrBooks()
        {
            InitializeComponent();
            bookHandler = new BookHandler();
            bookHandler.initializeComboBox(bookTitleComboBox);
            // Console check for current mode
            Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");

        }

 
        /*
           Function name: addButton_Click
           Version: 1
           Author: Christopher Sigouin
           Description: 
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.17 Original version by CJS

         */
        private void addButton_Click(object sender, EventArgs e)
        {
            
            // Clear all fields if they are not cleared
            clearFields(true);
            // Enable all fields
            setControlsEnabledStatus(true, true);
            // Change 'Save' button text to 'Save (Add Mode)'
            bookHandler.Mode = BookHandler.Modes.AddMode;
            saveButton.Text = SAVE_BUTTON_TEXT_ADD_MODE;

            // Console check for current mode
            Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");
        }

        /*
           Function name: editButton_Click
           Version: 1
           Author: Christopher Sigouin
           Description:
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.17 Original version by CJS

         */
        private void editButton_Click(object sender, EventArgs e)
        {
            // Enable all fields
            setControlsEnabledStatus(true, false);
            // Change 'Save' button text to 'Save (Add Mode)'
            bookHandler.Mode = BookHandler.Modes.EditMode;
            saveButton.Text = SAVE_BUTTON_TEXT_EDIT_MODE;

            // Console check for current mode
            Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");
        }

        /*
           Function name: addButton_Click
           Version: 1
           Author: Christopher Sigouin
           Description:
           Inputs: 
           Outputs:
           Return value: N/A
           Change History: 2015.11.17 Original version by CJS

         */
        private void deleteButton_Click(object sender, EventArgs e)
        {
            if (isbnTextBox.Text != "")
            {
                DialogResult result =
                    MessageBox.Show("Do you wish to proceed with the deletion of " + titleTextBox.Text + "?", "DELETE",
                        MessageBoxButtons.OKCancel, MessageBoxIcon.Hand);


                if (result == DialogResult.OK)
                {
                    bookHandler.Delete(isbnTextBox.Text);
                }

                // After 'Delete' occurs, reset to default state
                resetToSelectMode();
                // Reload the ComboBox
                bookTitleComboBox.Items.Clear();
                bookHandler.initializeComboBox(bookTitleComboBox);
            }
            else
            {
                MessageBox.Show("You cannot delete a blank record");
            }

            // Console check for current mode
            Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");
        }

        /*
           Function name: bookTitleComboBox_SelectedIndexChanged
           Version: 1
           Author: Christopher Sigouin
           Description:
           Inputs: 
           Outputs:
           Return value: N/A
           Change History: 2015.11.17 Original version by CJS

         */
        private void bookTitleComboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

            // Set the mode to 'SelectMode' and ensure save button is reset ( incase user decided to select a different item )
            bookHandler.Mode = BookHandler.Modes.SelectMode;
            saveButton.Text = SAVE_BUTTON_TEXT_DEFAULT;
            // Pass the unique 'ISBN' code to pull the details
            Book book = bookHandler.showBookDetails((bookTitleComboBox.SelectedItem as ComboBoxItem).Value.ToString());


            // Set the text fields
            isbnTextBox.Text = book.Isbn;
            titleTextBox.Text = book.Title;
            authorTextBox.Text = book.Author;
            publisherTextBox.Text = book.Publisher;
            subjectTextBox.Text = book.SubjectCode;
            shelfTextBox.Text = book.ShelfLocation;
            fictionCheckBox.Checked = book.Fiction;

            // Ensure that all fields are disabled
            setControlsEnabledStatus(false, true);

            // Console check for current mode
            Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");

        }

        /*
           Function name: saveButton_Click
           Version: 1
           Author: Christopher Sigouin
           Description:
           Inputs: 
           Outputs:
           Return value: N/A
           Change History: 2015.11.17 Original version by CJS

         */
        private void saveButton_Click(object sender, EventArgs e)
        {
            // Check to see if there is an ISBN listed to complete the save
            if (isbnTextBox.Text == "")
            {
                MessageBox.Show("There is nothing to save.  Reverting to 'Select Mode'");
                
            }
            // Create 'Book' object and grab data
            Book book = new Book();
            book.Isbn = isbnTextBox.Text;
            book.Title = titleTextBox.Text;
            book.Author = authorTextBox.Text;
            book.Publisher = publisherTextBox.Text;
            book.SubjectCode = subjectTextBox.Text;
            book.ShelfLocation = shelfTextBox.Text;
            book.Fiction = fictionCheckBox.Checked;

            Console.Write(bookHandler.Mode);
            // Change save type based on state of the application
            switch (bookHandler.Mode)
            {
                case BookHandler.Modes.AddMode:
                    Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");
                    bookHandler.Add(book);
                    break;
                case BookHandler.Modes.EditMode:
                    Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");
                    bookHandler.Update(book);
                    break;

            }

            // Reload the ComboBox
            bookTitleComboBox.Items.Clear();
            bookHandler.initializeComboBox(bookTitleComboBox);
            // Set to default state
            resetToSelectMode();

            // Console check for current mode
            Console.Write("\nCurrent Mode: " + bookHandler.Mode + "\n");
        }

        /*
           Function name: Helper function - clearFields
           Version: 1
           Author: Christopher Sigouin
           Description: Clears fields specified
           Inputs: bool IsIsbnCleared
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        private void clearFields(bool IsIsbnCleared)
        {
            // Clear the text fields and reset the comboBox
            if (IsIsbnCleared)
            {
                isbnTextBox.Text = "";
            }

            titleTextBox.Text = "";
            authorTextBox.Text = "";
            publisherTextBox.Text = "";
            subjectTextBox.Text = "";
            shelfTextBox.Text = "";
            fictionCheckBox.Checked = false;

            bookTitleComboBox.ResetText();
        }

        /*
            Function name: resetToSelectMode
            Version: 1
            Author: Christopher Sigouin
            Description: Helper method to reset the form back to a default state.  Prevents repeditive code
         
            Inputs: Parameters - object sender, EventArgs e / Text box field 'numberOfItems'
            Outputs: Text box field ' txBxShippingCharges ' shows dollar amount after calculation
            Return value: N/A
            Change History: 2015.09.18 Original version by CJS

        */
        private void resetToSelectMode()
        {
            bookHandler.Mode = BookHandler.Modes.SelectMode;
            saveButton.Text = SAVE_BUTTON_TEXT_DEFAULT;
            clearFields(true);
            setControlsEnabledStatus(false, true);
        }

        /*
           Function name: setControlEnableStatus
           Version: 1
           Author: Christopher Sigouin
           Description: Quickly enable or disable all form controls within the group box.
           Inputs: 
           Outputs:
           Return value: N/A
           Change History: 2015.11.17 Original version by CJS

         */ 
        private void setControlsEnabledStatus(bool enabledStatus, bool IsIsbnIncluded)
        {
 
            // Enable ISBN
            if (IsIsbnIncluded)
            {
                // Enable all controls except for 'ISBN'
                foreach (Control c in bookDetailsGroupBox.Controls)
                {
                    // Do not change status on 'Labels'
                    if (!(c is Label))
                    {
                        c.Enabled = enabledStatus;    
                    }
                        
                }
            }
            else
            {
                // Enable all controls except for 'ISBN'
                foreach (Control c in bookDetailsGroupBox.Controls)
                {
                    if (!(c.Name == "isbnTextBox"))
                    {
                        // Do not change status on 'Labels'
                        if (!(c is Label))
                        {
                            c.Enabled = enabledStatus;
                        }
                    }
                }    
            }

        } // END 
    }
}
