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
         Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
         and 39 return true, but 40 returns false.
         (Hint: Think "mod".)
         Less20(18) → true
         Less20(19) → true
         Less20(20) → false
         */
        public bool Less20(int n)
        {
            bool oneLessThanMultipleOf20 = (n % 20 == 19);
            bool twoLessThanMultipleOf20 = (n % 20 == 18);

            return oneLessThanMultipleOf20 || twoLessThanMultipleOf20;
        }

    }
}
