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
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using StudentNamespace;
using GraduateStudentNamespace;
using UndergraduateStudentNamespace;

namespace StudentDisplayForm
{
    public partial class studentDisplayForm : Form
    {
        Student student;
        GraduateStudent graduateStudent;
        UndergraduateStudent undergraduateStudent;

        public Student Student
        {
            get { return student; }
            set { student = value; }
        }

        public GraduateStudent GraduateStudent
        {
            get { return graduateStudent; }
            set { graduateStudent = value; }
        }

        public UndergraduateStudent UndergraduateStudent
        {
            get { return undergraduateStudent; }
            set { undergraduateStudent = value; }
        }

        public studentDisplayForm()
        {
            InitializeComponent();
            student = new Student("Billy", "Blue", 20, 2);
            graduateStudent = new GraduateStudent("John", "Jenkins", 34, 8, GraduateStudent.DegreeType.BA , "University of Waterloo" );
            undergraduateStudent = new UndergraduateStudent("Sam", "Smith", 45, 4, UndergraduateStudent.Classification.Freshman, "Morris", "Morlock", "123 Elm Street");
 
        }


        private void resetButton_Click(object sender, EventArgs e)
        {
            displayBox.Clear();
        }

        private void displayStudentButton_Click(object sender, EventArgs e)
        {
            displayBox.Text = student.ToString();
        }

        private void displayGraduateButton_Click(object sender, EventArgs e)
        {
            displayBox.Text = graduateStudent.ToString();
        }

        private void displayUndergraduateButton_Click(object sender, EventArgs e)
        {
            displayBox.Text = undergraduateStudent.ToString();
        }
    }
}
