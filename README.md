# Anagram
In this project we create the anagrams of a given word.

## Sections 
+ [Overview](https://github.com/vipul-khatana/Anagram#overview) 
+ [Methodology](https://github.com/vipul-khatana/Anagram#methodology)
+ [File Format](https://github.com/vipul-khatana/Anagram#file-format)
+ [How to run](https://github.com/vipul-khatana/Anagram#how-to-run)
+ [Author](https://github.com/vipul-khatana/Anagram#author)
+ [Contributing](https://github.com/vipul-khatana/Anagram#contributing)

## Overview 
 
We are given a vocabulary V of (lowercase) English words, which uses letters of English alphabet (a-z), digits (0-9), and the apostrophe symbol ('). No other characters are used in the vocabulary V. Our goal is to print out all valid [anagrams](https://en.wikipedia.org/wiki/Anagram) of an input string. The input string will be a sequence of at most 12 characters.

## Methodology 

Given a vocabulary V, we first of all create a hashmap for all the words in vocabulary. The hashmap was implemented using an array of linked lists. For every position of array we have a corresponding linked list. The hashing function that I have used is based on the Horner's rule. 

If we have a string say c1c2c3...cN where ci's are characters of the string can be though of as a number with value 

cN + 38.cN-1 + (38)^2.cN-2 ........ + (38)^N-1.c1 

Here I chose the number 38 because the input string that is given can consists of maximum 38 distinct character. Once we have the number representation of every string, then it's key k is computed by computing it's modulo with respect to the table size(which is the size of the array). The string is stored in the linked list associated with the index k in the array. 

Once we have the hashtable for the dictionary, we find out the possible permutations of a word and search whether it is present in the dictionary or not and accordingly give the ouptut. 

## File Format 

+ **Vocabulary file** The vocabulary file must be stored as  vocabulary.txt format. The first line of the file will indicate the number of lines in the vocabulary followed by the words in every file. For eg. 

     6

     a

     it

     bit

     bat 

     tab 

     i

+ **Input file** The input file (input.txt) The first line will have the number (K) of input strings. This will be followed by K lines, with one string per line. It will have only lowercase letters, digits, and apostrophe. It will not have a space. A sample input.txt is given as under

    2

    bait

    bb

+ **Output file** The output file produces all valid anagrams of each input string and output -1 after finishing with one input and moving onto the next. The output for a particular string will be in **lexicographic order**. For example, for the input file above output will be:

    a bit

    bat i

    bit a

    i bat

    i tab

    tab i

    -1

    -1

## How to run 

Compile using `javac Anagram.java`

Run as `java Anagram`

## Author 

+ [Vipul Khatana](https://github.com/vipul-khatana)

Course Project under [**Prof Mausam**](http://www.cse.iitd.ac.in/~mausam/)

## Contributing 

1) Fork it (https://github.com/vipul-khatana/Anagram/fork)
2) Create your feature branch git checkout -b feature/fooBar
3) Commit your changes git commit -am 'Add some fooBar'
4) Push to the branch git push origin feature/fooBar
5) Create a new pull request`




