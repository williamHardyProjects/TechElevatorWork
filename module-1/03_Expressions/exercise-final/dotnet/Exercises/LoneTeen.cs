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
        We'll say that a number is "teen" if it is in the range 13..19 inclusive. Given 2 int values,
        return true if one or the other is teen, but not both.
        LoneTeen(13, 99) → true
        LoneTeen(21, 19) → true
        LoneTeen(13, 13) → false
        */
        public bool LoneTeen(int a, int b)
        {
            bool LoneTeen = (a >= 13 && a <= 19) ^ (b >= 13 && b <= 19);
            return LoneTeen;
        }

    }
}
