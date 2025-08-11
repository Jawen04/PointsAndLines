# PointsAndLines


## Description
A very basic drawing tool for placing dots and lines connecting the dots, using Gradle.

# Starting the program

## Using Gradle
make sure you are in the root directory and run the gradle wrapper script

```bash
./gradlew run
```

or if you have gradle installed on your machine you can run
```bash 
gradle run
```

## Starting everything manually (tidious)

cd to the directory where the main class is stored
```bash 
cd src/main/java
```
make sure you have java installed and compile the main class
```bash 
javac Main.java
```

now run the compiled program
```bash 
java Main
```

# Usage

## Controls
The controls and options are pretty straight forward, you can find almost anything in the menu bar on the top of the screen.
However the program includes three options:
- pressing L toggles line visibility 
- pressing D toggles dot visibility
- pressing C clears all lines and dots

## Opening files
The program comes prepared with a .csv file to draw dots and lines from.
The format for drawing a dot is: Dot <\x-position\> <\y-position\> <\diameter\>
The format for drawing a line is: Line <\starting x-position\> <\starting y-position\> <\ending x-position\> <\ending y-position\>

Feel free to customize the data.csv file found in the root directory!



