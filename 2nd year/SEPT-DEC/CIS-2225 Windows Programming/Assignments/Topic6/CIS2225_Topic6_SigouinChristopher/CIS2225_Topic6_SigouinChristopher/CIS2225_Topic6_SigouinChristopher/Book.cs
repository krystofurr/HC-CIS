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
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CIS2225_Topic6_SigouinChristopher
{
    class Book
    {
        // Attributes of a book
        private string isbn;
        private string title;
        private string author;
        private string publisher;
        private string subjectCode;
        private string shelfLocation;
        private bool fiction;



        // Properties
        public string Isbn
        {
            get { return isbn; }
            set { isbn = value; }
        }

        public string Title
        {
            get { return title; }
            set { title = value; }
        }

        public string Author
        {
            get { return author; }
            set { author = value; }
        }

        public string Publisher
        {
            get { return publisher; }
            set { publisher = value; }
        }

        public string SubjectCode
        {
            get { return subjectCode; }
            set { subjectCode = value; }
        }

        public string ShelfLocation
        {
            get { return shelfLocation; }
            set { shelfLocation = value; }
        }

        public bool Fiction
        {
            get { return fiction; }
            set { fiction = value; }
        }
    }
}
