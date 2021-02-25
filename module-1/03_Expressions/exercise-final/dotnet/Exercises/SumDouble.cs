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
         Given two int values, return their sum. Unless the two values are the same, then return double their sum.
         SumDouble(1, 2) → 3
         SumDouble(3, 2) → 5
         SumDouble(2, 2) → 8
         */
        public int SumDouble(int a, int b)
        {
            int result = a + b;

            if (a == b)
            {
                result = 2 * (a + b);
            }

            return result;
        }
    }
}
