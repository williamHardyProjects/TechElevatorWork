﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public partial class Exercises
    {

        /*
         Given three ints, a b c, return true if they are in strict increasing order, such as 2 5 11,
         or 5 6 7, but not 6 5 7 or 5 5 7. However, with the exception that if "equalOk" is true, equality
         is allowed, such as 5 5 7 or 5 5 5.
         InOrderEqual(2, 5, 11, false) → true
         InOrderEqual(5, 7, 6, false) → false
         InOrderEqual(5, 5, 7, true) → true
         */
        public bool InOrderEqual(int a, int b, int c, bool equalOk)
        {
            bool result = false;

            if (equalOk)
            {
                result = a <= b && b <= c;
            }
            else
            {
                result = a < b && b < c;
            }

            return result;
        }

    }
}
