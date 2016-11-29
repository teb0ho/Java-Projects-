September 16, 2016 - Lottery Program v0.2
------------------------------------------------------------------------
A simple java console program that generates 6 lottery numbers at execution

To ensure that this program executes hassle free execute the following commands from the root directory.

```
javac -d bin src/Lottery.java

java -cp bin Lottery

```
If the ```javac ``` command does not work on your CLI you might need set environment variables for your JDK.


*** Fixed bugs *** 
* 0s are now excluded from the output.
* Duplicate numbers are excluded from the output.

*** Improvements ***
* Ability to choose Lotto or PowerBall numbers
* Results are now saved in the res/results.txt file 
