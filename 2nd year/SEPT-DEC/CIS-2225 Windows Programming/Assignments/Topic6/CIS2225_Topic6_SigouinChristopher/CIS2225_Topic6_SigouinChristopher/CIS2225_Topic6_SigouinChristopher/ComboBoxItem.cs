

// REF: http://stackoverflow.com/questions/3063320/combobox-adding-text-and-value-to-an-item-no-binding-source

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CIS2225_Topic6_SigouinChristopher
{
    class ComboBoxItem
    {
     
        public string Text { get; set; }
        public object Value { get; set; }

        public override string ToString()
        {
            return Text;
        }
    
    }
}
