---
layout: homework
title: Homework 1
---

# Homework 1

## Introduction

This homework will cover basic Java control structures, 1-D arrays, file I/O, and string manipulation.

### Downloadables

- [grades.csv](grades.csv)

## Problem Description

You are a Georgia Tech professor teaching a class. It is the end of the semester and you want to visualize the distribution of your students' grades.

## Solution Description

Write a single Java class that, when run as a console program in a directory containing a properly formatted grades file (more below), prints a histogram of the grade distribution to STDOUT (the console). Name your class `Histogram` and save its source code in an appropriately named file.

A histogram is a graphical representation of a sequence of "bins" which represent ranges of values. Each bin contains a number which represents the number of occurences of data points that lie within the range of values represented by the bin. Your program will take two inputs (more later): the name of a data file and the number of bins to create in the histogram. You will represent these bins as elements of an array and your program will count the number of occurrences of values from the data file that lie within the ranges represented by each bin. The data values will lie in the range [[0, 100]](https://en.wikipedia.org/wiki/Bracket_(mathematics)#Intervals). For example, if we had a data file with these contents:

```
Dead Starks, 6
Dead Lannisters, 3
Luftballons, 99
```

and you create a histogram with two bins, the array to represent the bins would contain `[2, 1]`, where the first element of the array contains the count of values in the interval [0, 50] and the second element contains the count of values in [51, 100].

After counting the number of grades in each bin, your program will print a horizontal histogram. You must also label the range of each bin, which can be derived from the number of bins and the range of data values. Each bin should have the same sized range except if the number of bins does not divide 101 evenly, the extra should be included in the lowest bin.

The Histogram should look something like this:

```
100 - 91 | [][][][][][][][][][][][][]
 90 - 81 | [][][][][][][][][][][][][][][][][][][][][][][][][][]
 80 - 71 | [][][][][][][][][][][][][][]
 70 - 61 | [][][][][][][][][][][][][][][][]
 60 - 51 | [][][][][][][][]
 50 - 41 | [][][][][]
 40 - 31 | [][][][][][][]
 30 - 21 | [][]
 20 - 11 |
 10 -  0 | [][]
```

The above histogram has 10 bins. Because there are 101 different possible grades (0-100) and 101 is not divisible by 10, we make the smallest bin include the extra. The class had 2 grades in the range 10-0, 0 grades in the range 11-20, 2 grades in the range 21-30, etc.

### Grades File

We have provided you with a CSV file that has a list of students and their grades. A CSV file is just a text file with data partitioned by commas and (in this case) newlines. **Note that there may be any number of spaces surrounding the comma.**

These grades are not sorted but they are **integers** bound between 0 and 100 (inclusive). For example, the file may look like:

```
Glenn Hollingsworth,91
Chris Simpkins, 100
Thomas Shields, 89
Bob,55
Alice,   95
Eve, 87
```

**Your program may read through the file only once.** Do not scan through the contents of the file multiple times.

The file we provide is just an example of what the file could be. You should test your code with other grades files and other bin sizes.

### Input

You will use command-line arguments to inform your program the location of the grades file - _see [Expected Output](#expected-output) for how to pass the file name in when running the program_.

You must allow the user to specify the number of bins in the two following ways:

1. Firstly, the number of bins may be specified as an additional command line arg, e.g. `java Histogram grades.csv 5`
2. If the second command line arg is not present, your program must ask the user for the number of bins at the beginning.

## Expected Output

Running the program should look like this:

> **Note:** `$` is the command prompt on Unix. On Windows it will look like `C:>`

- Without the additional command line argument

  ```sh
  $ java Histogram grades.csv
  How many bins would you like?
  10
  100 - 91 | [][][][][][][][][][][][][]
   90 - 81 | [][][][][][][][][][][][][][][][][][][][][][][][][][]
   80 - 71 | [][][][][][][][][][][][][][]
   70 - 61 | [][][][][][][][][][][][][][][][]
   60 - 51 | [][][][][][][][]
   50 - 41 | [][][][][]
   40 - 31 | [][][][][][][]
   30 - 21 | [][]
   20 - 11 |
   10 -  0 | [][]
  ```

- With the additional command line argument

  ```sh
  $ java Histogram grades.csv 20
  100 - 96 | [][][][][][][]
   95 - 91 | [][][][][][]
   90 - 86 | [][][][][][][][][][][][][][][][]
   85 - 81 | [][][][][][][][][][]
   80 - 76 | [][][][][][][][][][][]
   75 - 71 | [][][]
   70 - 66 | [][][][][][][][][][]
   65 - 61 | [][][][][][]
   60 - 56 | [][][][][][]
   55 - 51 | [][]
   50 - 46 | [][]
   45 - 41 | [][][]
   40 - 36 | [][][]
   35 - 31 | [][][][]
   30 - 26 | []
   25 - 21 | []
   20 - 16 |
   15 - 11 |
   10 -  6 | []
    5 -  0 | []
  ```

**IMPORTANT:** The spacing here is very important. You must use the same spacing scheme as our examples or you will lose points. Also make sure the prompt for the number of bins is the same as our example.

## Allowed imports
You are allowed to import the following classes and only the following classes:
* java.util.Scanner;
* java.io.File;
* Any Exception

## Tips

1. You may assume that you always get valid input.
2. You may assume the text file has valid numbers.
3. 101 is a prime number.
4. Try using 101 as the number of bins before you submit.
5. Try using printf.
6. An array is a fixed size data structure; you need to know ahead of time how big it needs to be. How do we do this?
7. You can give interpretations to the indices and contents of an array to arrive at creative solutions to problems. Code smart, not hard.
8. Creating a `Scanner` object with a file will throw a checked exception. Don't worry about what this means --- for now, just append `throws Exception` to the end of the `main` method signature wherein the file is opened.

## Grading

- (10 points) Scans through the entire file given by the first command line argument once
- (20 points) Correct number of bins
- (20 points) Correct number of grades in each bin
- (20 points) Ranges are correct for each bin
- (10 points) Prompts number of bins only when the second command line argument isn't given
- (20 points) Output has correct phrases and spacing
