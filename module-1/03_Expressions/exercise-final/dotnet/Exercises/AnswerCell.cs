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
         Your cell phone rings. Return true if you should answer it. Normally you answer, except in the morning
         you only answer if it is your mom calling. In all cases, if you are asleep, you do not answer.
         AnswerCell(false, false, false) → true
         AnswerCell(false, false, true) → false
         AnswerCell(true, false, false) → false
         */
        public bool AnswerCell(bool isMorning, bool isMom, bool isAsleep)
        {
            bool result = false;

            if (!isAsleep)
            {
                result = isMom || (!isMorning);
            }

            return result;
        }
    }
}
