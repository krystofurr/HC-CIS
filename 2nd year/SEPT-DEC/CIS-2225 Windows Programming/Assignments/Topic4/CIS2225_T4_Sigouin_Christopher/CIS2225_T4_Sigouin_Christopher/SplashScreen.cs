using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CIS2225_T4_Sigouin_Christopher
{
    public partial class SplashScreen : Form
    {
        public SplashScreen()
        {
            InitializeComponent();
        }

        // Splash Screen Timer
        private void timer1_Tick(object sender, EventArgs e)
        {
            this.Close();
        }

    }
}
