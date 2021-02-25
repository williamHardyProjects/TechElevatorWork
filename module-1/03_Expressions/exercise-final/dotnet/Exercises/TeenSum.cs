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
         Given 2 ints, a and b, return their sum. However, "teen" values in the range 13..19 inclusive, are
         extra lucky. So if either value is a teen, just return 19.
         TeenSum(3, 4) → 7
         TeenSum(10, 13) → 19
         TeenSum(13, 2) → 19
         */
        public int TeenSum(int a, int b)
        {
            int result = a + b;

            if ((a >= 13 && a <= 19) || (b >= 13 && b <= 19))
            {
                result = 19;
            }

            return result;
        }
    }
}
