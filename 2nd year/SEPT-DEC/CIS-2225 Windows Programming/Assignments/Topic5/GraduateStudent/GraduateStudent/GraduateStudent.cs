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

namespace GraduateStudentNamespace
{
    public class GraduateStudent : Student
    {
        public enum DegreeType { BA, BS }
        private DegreeType awardedDegreeType;
        private string awardedDegreeLocation;

        public GraduateStudent(string firstName, string lastName, int age, int id, DegreeType awardedDegreeType, string awardedDegreeLocation) : base(firstName, lastName, age, id)
        {
            this.awardedDegreeType = awardedDegreeType;
            this.awardedDegreeLocation = awardedDegreeLocation;
        }

        public override string ToString()
        {
            return string.Format("{0}, AwardedDegreeType: {1}, AwardedDegreeLocation: {2}", base.ToString(), awardedDegreeType, awardedDegreeLocation);
        }

        public DegreeType AwardedDegreeType
        {
            get { return awardedDegreeType; }
            set { awardedDegreeType = value; }
        }

        public string AwardedDegreeLocation
        {
            get { return awardedDegreeLocation; }
            set { awardedDegreeLocation = value; }
        }
    }
}
