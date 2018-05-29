using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;

namespace testApp
{
    public class Program
    {
        public static void Main(string[] args)
        {
           // var timeResults = new double[7, 100];
           // var memResults = new double[7, 100];

            //Command line argument "true" after "dotnet run" for debug messages
            var verbose = false || args.Any() && args.First() == "true";

            //Addition for 1C to run only one test at a time
            //-1 is default (all tests)
            // var testNum = -1;
            // if (args.Count() >= 2) testNum = int.Parse(args[1]);

            try
            {
                //Console.WriteLine("Waylon Hudson - Ass01");
                //Stores each current line piped into program
                string input;

                //Get universe size and initialize array
                input = Console.ReadLine();

                if (verbose) Console.WriteLine(input);

                var universe = int.Parse(input);
            
                //Program logic uses a flat list of keyvaluepairs for x and y values
                var cordsAsList = new List<KeyValuePair<int, int>>();

                //Read in each set of coordinate pairs
                while ((input = Console.ReadLine()) != null)
                {
                    if (verbose) Console.WriteLine(input);

                    var cords = input.Split(" ", StringSplitOptions.RemoveEmptyEntries);

                    if (cords.Length != 2)
                    {
                        throw new ApplicationException("Error: input did not consist of a coordinate pair where expected!");
                    }
                
                    cordsAsList.Add(new KeyValuePair<int, int>(int.Parse(cords[0]), int.Parse(cords[1])));
                }

                for (var testNum = 0; testNum < 7; testNum++) {
                    for (var inc = 0; inc < 1; inc++) {
                            var startTime = DateTime.Now;
                            var endTime = new DateTime();
                            var endMemory = (long)0;
                            //Test if the relation is one to one
                            var isOneToOne = true;
                            if (testNum == -1 || testNum == 0) {
                                //Group distinct coordinate pairs on y values, check that there is not more than 1 corresponding x value
                                cordsAsList.Distinct().GroupBy(g => new {g.Key, g.Value})
                                    .Select(g => g.First())
                                    .GroupBy(gr => gr.Value)
                                    .ToList().ForEach(e =>
                                    {
                                        if (e.ToList().Distinct().Count() != 1) isOneToOne = false;
                                    });
                            
                                //Group distinct pairs on x values, check that there is not more than 1 corresponding y value
                                cordsAsList.Distinct().GroupBy(g => new {g.Key, g.Value})
                                    .Select(g => g.First())
                                    .GroupBy(c => c.Key)
                                    .ToList().ForEach(e =>
                                    {
                                        if (e.ToList().Distinct().Count() != 1) isOneToOne = false;
                                    });

                                Console.WriteLine("<1> Is one-to-one: " + isOneToOne);
                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");
                            }
                        
                            //Test if the relation is onto
                            var isOnto = true;
                            if (testNum == -1 || testNum == 1) {
                                //For each i up to the universe size make sure there is a coordinate pair with y = i
                                for (var i = 1; i <= universe; i++)
                                {
                                    if (!cordsAsList.Any(c => c.Value == i)) isOnto = false;
                                }

                                Console.WriteLine("<2> Is onto: " + isOnto);
                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");
                            }

                            //Test if the relation is reflexive
                            var isReflexive = true;
                            if (testNum == -1 || testNum == 2) {       
                                //For each i up to the universe size make sure there is a coordinate pair with x = i and y = i
                                for (var i = 1; i <= universe; i++)
                                {
                                    if (!cordsAsList.Any(c => c.Key == i && c.Value == i)) isReflexive = false;
                                }
                            
                                Console.WriteLine("<3> Is reflexive: " + isReflexive);
                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");
                            }


                            //Test if the relation is symmetric
                            var isSymmetric = false;
                            if (testNum == -1 || testNum == 3) {
                                //Check that the list contains a pair (b, a)  for each  pair (a, b) given
                                isSymmetric = cordsAsList.All(
                                    pair => cordsAsList.Contains(new KeyValuePair<int, int>(pair.Value, pair.Key))
                                );
                            
                                Console.WriteLine("<4> Is symmetric: " + isSymmetric);
                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");
                            }

                            //Test if the relation is transitive
                            var isTransitive = true;
                            if (testNum == -1 || testNum == 4) {                
                                for (var i = 1; i <= universe; i++)
                                {
                                    //Get list of y values for the given x value
                                    var values = cordsAsList.Where(c => c.Key == i)
                                        .Select(pair => pair.Value).ToList();
                                
                                    var values2 = new List<int>();
                                    //Get list of y values for the coordinate pairs where x is in the previous list
                                    values.ForEach(value =>
                                    {
                                        values2.AddRange(cordsAsList.Where(c => c.Key == value).Select(c => c.Value));
                                    });
                                
                                    //Check that all values in the second list are in the first list
                                    if (!values2.All(val => values.Contains(val))) isTransitive = false;
                                }
                            
                                Console.WriteLine("<5> Is transitive: " + isTransitive);
                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");
                            }
                        

                            //Test if the relation is a function
                            var isFunction = true;
                            if (testNum == -1 || testNum == 5) {
                                //Group distinct pairs on x value and confirm there is only 1 pair (1 y value)
                                cordsAsList.Distinct()
                                    .GroupBy(g => new {g.Key, g.Value})
                                    .Select(g => g.First())
                                    .GroupBy(c => c.Key).ToList().ForEach(g =>
                                    {
                                        if (g.ToList().Distinct().Count() != 1) isFunction = false;
                                    });
                            
                                Console.WriteLine("<6> Is a function: " + isFunction);
                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");

                                if (isFunction)
                                {
                                    Console.WriteLine("<6a> Is an onto function: " + isOnto);
                                    Console.WriteLine("<6b> Is a one-to-one function: " + isOneToOne);
                                }
                            }

                            if (testNum == -1 || testNum == 6) {
                                //Arbitrarily decided max number of partitions to display
                                var maxShown = 100;
                            
                                var valUsed = new bool[universe];
                                var partitions = new List<List<int>>();
                            
                                cordsAsList.OrderBy(c => c.Key)
                                    .GroupBy(c => c.Key).ToList()
                                    .ForEach(g =>
                                    {
                                        if (valUsed[g.Key - 1] == false)
                                        {
                                            valUsed[g.Key - 1] = true;
                                            var vals = new List<int>();
                                            g.ToList().ForEach(e =>
                                            {
                                                vals.Add(e.Value);
                                                valUsed[e.Value - 1] = true;
                                            });
                                            partitions.Add(vals);
                                        }
                                    });

                                if (partitions.Count > maxShown)
                                {
                                    Console.WriteLine($"Number of partitions: {partitions.Count}");
                                    Console.WriteLine("Done.");
                                    return;
                                }
                            
                                Console.WriteLine("Partitions:");
                                partitions.ForEach(p =>
                                {
                                    Console.WriteLine($"[ {string.Join(" ", p)} ]");
                                });

                                endTime = DateTime.Now;
                                endMemory = GC.GetTotalMemory(true);
                                //timeResults[testNum, inc] = (endTime - startTime).TotalMilliseconds;
                                //memResults[testNum, inc] = endMemory;
                                Console.WriteLine("Time used: " + (endTime - startTime).TotalMilliseconds + " milliseconds");
                                Console.WriteLine("Memory allocated: " + (endMemory) + " bytes");
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine(ex.Message);
                Console.ForegroundColor = ConsoleColor.White;
            }

            Console.WriteLine("Done.");
           // File.WriteAllLines("./timeResults.csv", ToCsv(timeResults));
           // File.WriteAllLines("./memResults.csv", ToCsv(memResults));
        }

        //From https://stackoverflow.com/a/39792689
        private static IEnumerable<String> ToCsv<T>(T[,] data, string separator = ",") {
            for (int i = 0; i < data.GetLength(0); ++i)
                yield return string.Join(separator, Enumerable
                .Range(0, data.GetLength(1))
                .Select(j => data[i, j])); // simplest, we don't expect ',' and '"' in the items
            }
        }
}