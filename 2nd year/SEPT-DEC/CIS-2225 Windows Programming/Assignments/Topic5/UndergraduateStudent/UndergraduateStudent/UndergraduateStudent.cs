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
using StudentNamespace;

namespace UndergraduateStudentNamespace
{
    public class UndergraduateStudent : Student
    {
        public enum Classification { Freshman, Sophomore }
        private Classification classification;
        private string guardianFirstName;
        private string guardianLastName;
        private string guardianAddress;

        public UndergraduateStudent(string firstName, string lastName, int age, int id, Classification classification, string guardianFirstName, string guardianLastName, string guardianAddress) : base(firstName, lastName, age, id)
        {
            this.classification = classification;
            this.guardianFirstName = guardianFirstName;
            this.guardianLastName = guardianLastName;
            this.guardianAddress = guardianAddress;
        }

        public override string ToString()
        {
            return string.Format("{0}, Classification: {1}, GuardianFirstName: {2}, GuardianLastName: {3}, GuardianAddress: {4}", base.ToString(), classification, guardianFirstName, guardianLastName, guardianAddress);
        }

        public Classification p_Classification
        {
            get { return classification; }
            set { classification = value; }
        }

        public string GuardianFirstName
        {
            get { return guardianFirstName; }
            set { guardianFirstName = value; }
        }

        public string GuardianLastName
        {
            get { return guardianLastName; }
            set { guardianLastName = value; }
        }

        public string GuardianAddress
        {
            get { return guardianAddress; }
            set { guardianAddress = value; }
        }    
    }
}
