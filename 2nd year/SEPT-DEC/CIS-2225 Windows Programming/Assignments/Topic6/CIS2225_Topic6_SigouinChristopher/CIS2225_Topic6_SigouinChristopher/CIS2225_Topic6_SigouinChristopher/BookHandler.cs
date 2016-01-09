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
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS2225_Topic6_SigouinChristopher
{
    class BookHandler
    {
        // These represent the state of the application depending on button choice
        public enum Modes { AddMode, EditMode, DeleteMode, SelectMode }
        // Current state of application
        Modes mode;

        public Modes Mode
        {
            get { return mode; }
            set { mode = value; }
        }

        public BookHandler()
        {
            mode = Modes.SelectMode;

        }

        /*
           Function name: initializeComboBox
           Version: 1
           Author: Christopher Sigouin
           Description: Autofills the combobox values with the title from the Books table within the database
           Inputs: Combobox combobox
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        public void initializeComboBox(ComboBox comboBox)
        {
            List<ComboBoxItem> items = BookDAO.initializeComboBox(comboBox);

            // Setup the ComboBox
            for(int i = 0; i < items.Count; ++i)
            {
                comboBox.Items.Add(items[i]);
            }





        }

        /*
           Function name: showBookDetails
           Version: 1
           Author: Christopher Sigouin
           Description: Pulls the details of the selected book
           Inputs: String isbn
           Outputs: Book
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        public Book showBookDetails(String isbn)
        {
            Book book = BookDAO.showBookDetails(isbn);
            return book;

        }

        public void Add(Book book)
        {

            BookDAO.Add(book);
        }

        public void Delete(String isbn)
        {

            BookDAO.Delete(isbn);
        }

        public void Update(Book book)
        {

            BookDAO.Update(book);
        }



    }
}
