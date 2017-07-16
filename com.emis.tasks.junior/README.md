# Junior Developer Tasks

Java was used for the implementation of both tasks.

## Task 1 - Create a console application that generates an Excel file containing 100
rows of randomly generated data.

 * The Apache POI project is used for performing the required actions
 * The code was written inside the following classes:
	- Person - representing a person who has a name, an age and scores
	- WorkbookCreator - containing methods for creating and modifying the MS Excel workbook with all the data


## Task 2 - Create a console application that calculates Factorials in the range of 0 - 10.

The following approach was initially used for implementing the task:
 * Two nested for-loops were used for calculation. The outer one is executed 1000 times and the inner one - 10 times
 (for the numbers from 0 to 10)
 * The Factorial of n is calculated by multiplying the numbers from 2 to n.

Then the code was optimized by using memoization.

 