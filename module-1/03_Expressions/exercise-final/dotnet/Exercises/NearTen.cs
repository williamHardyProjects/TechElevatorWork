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
         Given a non-negative number "num", return true if num is within 2 of a multiple of 10. Note: (a % b)
         is the remainder of dividing a by b, so (7 % 5) is 2.
         NearTen(12) → true
         NearTen(17) → false
         NearTen(19) → true
         */
        public bool NearTen(int num)
        {
            return (num % 10 <= 2) || (num % 10 >= 8);
        }
    }
}
