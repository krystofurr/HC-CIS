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

/* Books Table - Data Constraints
 * 
 * ISBN - Short Text - 13
 * Title - Short Text - 50
 * Author - Short Text - 30
 * Publisher - Short Text - 30
 * Subject Code - Short Text - 3
 * Shelf Location - Short Text - 7
 * Fiction - Yes/No
 * 
 */ 
namespace CIS2225_Topic6_SigouinChristopher
{
    class BookDAO
    {

        private static OleDbConnection Conn;


        private const string ConnStr =
            "Provider=Microsoft.ACE.OLEDB.12.0;" +
            "Data Source = c:\\RnrBooks.mdb";

        // Used for SQL commands.  Query Builder
        private static string strTable = "";
        private static string strFields = "";
        private static string strValues = "";
        private static string insertStr = "";

        // Not case sensitive for the Windows Database table.  Strings are the actual field names.
        private const string booksTable = "Books";
        private const string isbn = "ISBN";
        private const string title = "Title";
        private const string author = "Author";
        private const string publisher = "Publisher";
        private const string subjectCode = "Subject_Code";
        private const string shelfLocation = "Shelf_Location";
        private const string fiction = "Fiction";


        // Don't need default constructor

        /*
           Function name: OpenConn
           Version: 1
           Author: Christopher Sigouin
           Description: Open a database connection
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        private static void OpenConn()
        {
            try
            {
                String connStr = ConnStr;
                Conn = new OleDbConnection(connStr);
                Conn.Open();
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - OpenConn - Message:\n" + ex.Message);
            }
        }

        /*
           Function name: Add
           Version: 1
           Author: Christopher Sigouin
           Description: Completes the functionality of adding a record to the database
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        public static void Add(Book book)
        {
            try
            {
                String Str = BuildAddQuery(book);
                OpenConn();

                // Str is the SQL. Conn is the connection
                OleDbCommand cmd = new OleDbCommand(Str, Conn);

                cmd.ExecuteNonQuery();

                CloseConn();
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - Add - Message:\n" + ex.Message);
            }
        }

        /*
           Function name: Delete
           Version: 1
           Author: Christopher Sigouin
           Description: Completes the functionality of deleting a record from the database
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        public static void Delete(String isbn)
        {
            try
            {
                String Str = BuildDeleteQuery(isbn);
                OpenConn();

                OleDbCommand cmd = new OleDbCommand(Str, Conn);

                cmd.ExecuteNonQuery();

                CloseConn();
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - Delete - Message:\n" + ex.Message);
            }
        }

        /*
           Function name: Update
           Version: 1
           Author: Christopher Sigouin
           Description: Completes the functionality of updating a record in the database
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        public static void Update(Book book)
        {
            try
            {
                String Str = BuildUpdateQuery(book);
                OpenConn();

                OleDbCommand cmd = new OleDbCommand(Str, Conn);

                cmd.ExecuteNonQuery();
                CloseConn();
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - Update - Message:\n" + ex.Message);
            }

        }

        /*
           Function name: CloseConn
           Version: 1
           Author: Christopher Sigouin
           Description: Handles the closing of a database connection
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        private static void CloseConn()
        {
            try
            {
                Conn.Close();
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - closeConn - Message:\n" + ex.Message);
            }
        }

        /*
           Function name: BuildUpdateQuery
           Version: 1
           Author: Christopher Sigouin
           Description: Builds the query for an UPDATE SQL statement
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        private static String BuildUpdateQuery(Book book)
        {
       

            strTable = "\nUpdate " + booksTable;
            strFields = " Set " + 
                        title + "=" + "'" + book.Title + "'" + "," +
                        author + "=" + "'" + book.Author + "'" + "," +
                        publisher + "=" + "'" + book.Publisher + "'" + "," +
                        subjectCode + "=" + "'" + book.SubjectCode + "'" + "," +
                        shelfLocation + "=" + "'" + book.ShelfLocation + "'" + "," +
                        fiction + "=" + "" + book.Fiction + "" +
                        " Where (" + isbn +
                        "='" + book.Isbn + "');\n";

            insertStr = strTable + strFields;

            Console.Write("BuildUpdateQuery SQL => " + insertStr);
            return insertStr;

        }

        /*
           Function name: BuildDeleteQuery
           Version: 1
           Author: Christopher Sigouin
           Description: Builds the query for an DELETE SQL statement
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        private static String BuildDeleteQuery(String isbn)
        {
            strTable = "\nDelete From " + booksTable;
            strFields = " Where (" + BookDAO.isbn +
                        "=" + " '" + isbn + " ')\n";

            insertStr = strTable + strFields;

            Console.Write("BuildDeleteQuery SQL => " + insertStr);
            return insertStr;

        }

        /*
           Function name: BuildAddQuery
           Version: 1
           Author: Christopher Sigouin
           Description: Builds the query for an ADD SQL statement
           Inputs: 
           Outputs: 
           Return value: N/A
           Change History: 2015.11.23 Original version by CJS

         */
        private static String BuildAddQuery(Book book)
        {
            strTable = "\nInsert into " + booksTable;
            strFields = " (" + isbn +
                        "," + title +
                        "," + author +
                        "," + publisher +
                        "," + subjectCode +
                        "," + shelfLocation +
                        "," + fiction + ")";
            strValues = " Values ( '" + book.Isbn +
                        "' , '" + book.Title +
                        "' , '" + book.Author +
                        "' , '" + book.Publisher +
                        "' , '" + book.SubjectCode +
                        "' , '" + book.ShelfLocation +
                        "' , " + book.Fiction + " )\n";

            insertStr = strTable + strFields + strValues;
            Console.Write("BuildAddQuery SQL => " + insertStr);
            return insertStr;


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
        public static List<ComboBoxItem> initializeComboBox(ComboBox comboBox)
        {
            List<ComboBoxItem> items = new List<ComboBoxItem>();

            try
            {
                OpenConn();
                string query = "select isbn, title from " + booksTable;

                OleDbCommand cmd = new OleDbCommand(query, Conn);
                OleDbDataReader reader = cmd.ExecuteReader();

                // Add each item to an array of type 'ComboBoxItem'
                
                while (reader.Read())
                {
                    ComboBoxItem item = new ComboBoxItem();
                    item.Value = reader.GetString(0);
                    item.Text = reader.GetString(1);
                    items.Add(item);
                }

                // Close connections
                reader.Close();
                Conn.Close();

                
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - initializeComboBox - Message:\n" + ex.Message);
            }

            return items;
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
        public static Book showBookDetails(String isbn)
        {
            Book book = new Book();

            try
            {
                OpenConn();
                string query = "select * from " + booksTable +
                               " where " + BookDAO.isbn + " = " + "'" + isbn + "'";

                OleDbCommand cmd = new OleDbCommand(query, Conn);
                OleDbDataReader reader = cmd.ExecuteReader();

                // Add each item to an array of type 'ComboBoxItem'
                Console.Write(query);

                while (reader.Read())
                {
                    book.Isbn = reader.GetString(0);
                    book.Title = reader.GetString(1);
                    book.Author = reader.GetString(2);
                    book.Publisher = reader.GetString(3);
                    book.SubjectCode = reader.GetString(4);
                    book.ShelfLocation = reader.GetString(5);
                    book.Fiction = reader.GetBoolean(6);
                }

                // Close connections
                reader.Close();
                Conn.Close();

                
            }
            catch (Exception ex)
            {
                Console.Write("\nBookDAO Exception - showBookDetails - Message:\n" + ex.Message);
            }

            return book;

        }

    } // END: BOOKDAO CLASS
}
