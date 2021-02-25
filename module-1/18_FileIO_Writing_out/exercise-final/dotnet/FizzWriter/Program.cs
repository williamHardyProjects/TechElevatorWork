﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace FizzWriter
{
    class Program
    {
        static void Main(string[] args)
        {
            string outputFile = "FizzBuzz.txt";

            try
            {
                using (StreamWriter sw = new StreamWriter(outputFile))
                {
                    for(int i = 1; i <= 300; i++)
                    {
                        if (DivisibleBy15(i))
                        {
                            sw.WriteLine("FizzBuzz");
                        }
                        else if (DivisibleBy5OrContains5(i))
                        {
                            sw.WriteLine("Buzz");
                        }
                        else if (DivisibleBy3OrContains3(i))
                        {
                            sw.WriteLine("Fizz");
                        }
                        else
                        {
                            sw.WriteLine(i);
                        }
                    }
                }
            }
            catch (IOException e)
            {
                Console.WriteLine(e.Message);
            }

            Console.WriteLine($"{outputFile} has been created.");
        }

        private static bool DivisibleBy3OrContains3(int i)
        {
            return (i % 3 == 0) || i.ToString().Contains("3");
        }

        private static bool DivisibleBy5OrContains5(int i)
        {
            return (i % 5 == 0) || i.ToString().Contains("5");
        }

        private static bool DivisibleBy15(int i)
        {
            return (i % 3 == 0) && (i % 5 == 0);
        }
    }
}
