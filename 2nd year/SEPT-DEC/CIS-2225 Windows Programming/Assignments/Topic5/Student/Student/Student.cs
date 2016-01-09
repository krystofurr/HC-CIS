/* _____           _        ____       _            _                                  _   
|_   _|__  _ __ (_) ___  | ___|     / \   ___ ___(_) __ _ _ __  _ __ ___   ___ _ __ | |_ 
  | |/ _ \| '_ \| |/ __| |___ \    / _ \ / __/ __| |/ _` | '_ \| '_ ` _ \ / _ \ '_ \| __|
  | | (_) | |_) | | (__   ___) |  / ___ \\__ \__ \ | (_| | | | | | | | | |  __/ | | | |_ 
  |_|\___/| .__/|_|\___| |____/  /_/   \_\___/___/_|\__, |_| |_|_| |_| |_|\___|_| |_|\__|
          |_|                                       |___/                        
    Program name: CIS-2225 T5 Sigouin Christopher ( Topic 5 Assignment 5 )    Author: Christopher Sigouin    Version: 1    Description: Chapter 11 Exercise 9    Dependencies: N/A    Database file: N/A    Change History: 2015.11.06 Original version by CJS
*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentNamespace
{
    public class Student
    {

        private string firstName;
        private string lastName;
        private int age;
        private int id;

        public Student(string firstName, string lastName, int age, int id)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.id = id;
        }

        public override string ToString()
        {
            return string.Format("FirstName: {0}, LastName: {1}, Age: {2}, Id: {3}", firstName, lastName, age, id);
        }

        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }

        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }

        public int Age
        {
            get { return age; }
            set { age = value; }
        }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }


    }


}
