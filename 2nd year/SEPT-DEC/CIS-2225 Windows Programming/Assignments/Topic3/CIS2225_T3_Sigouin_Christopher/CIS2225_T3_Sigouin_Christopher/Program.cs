/*
    Program name: Widget Production Payment Calculator ( Topic 3 Assignment 3 )
    Author: Christopher Sigouin
    Version: 1
    Description: Calculates individual and total workers payroll based on a number of widgets produced.
    Dependencies: N/A
    Database file: N/A
    Change History: 2015.10.02 Original version by CJS

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS2225_T3_Sigouin_Christopher
{
    /**
     * Main Program
     * 
     */
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new WPPC());
        }
    }
}
