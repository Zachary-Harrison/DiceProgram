# DiceProgram

This program calculates the mean and standard deviation of various dice rolls and displays this information to the user's console. It allows users to specify the number of dice, the number of sides on each die, and the number of the lowest and highest rolls to drop.

## Usage

> $\color{red} \text{Disclaimer}$: This program uses a brute-force algorithm if you are dropping dice, which can result in very long wait times. If you're determined to get such results, I recommend looking to the [Similar Projects](#similar-projects) section.

### Building and Running as an IntelliJ Project

To use the WordHunt Solver, follow these steps:

1. Clone this repo using:
    ```bash
    git clone https://github.com/Zachary-Harrison/DiceProgram.git
    ```
2. Open the project in IntelliJ IDEA.
3. Click on `File` > `Open`, navigate to the project directory, and click `OK`.
4. Once the project has loaded, click on Select a Run/Debug Configuration or make a new one.

### Running the Java Executable from Command Line

1. Download the [Main](/src/Main.java) and [DynamicCounter](/src/DynamicCounter.java) java files and put them in the same directory.
2. Open a terminal, navigating to the directory with the above downloaded files.
3. Run the following command to compile the java files into bytecode:
    ```bash
    javac Main.java DynamicCounter.java
    ```
    > $\color{lightblue} \text{Note}$: You will only need to do this once, unless you modify the source code.
4. Run the following command to execute the program, replacing appropriate bracketed parameters:
    ```bash
    java -cp . Main [numOfDice]d[numOfSides] [dropLowest] [dropHighest]
    ```
    > $\color{lightblue} \text{Note}$: dropLowest and dropHighest are optional parameters with default values of 0.


### Running the Precompiled JAR File

1. Download the [DiceProgram.jar](/out/artifacts/DiceProgram_jar/DiceProgram.jar) jar file.
2. Open a terminal, navigating to the directory with the above downloaded file.
3. Run the following command to execute the program, replacing appropriate bracketed parameters:
    ```bash
    java -jar DiceProgram.jar [numOfDice]d[numOfSides] [dropLowest] [dropHighest]
    ```
    > $\color{lightblue} \text{Note}$: dropLowest and dropHighest are optional parameters with default values of 0.


## Similar projects

This project is by no means the most efficient algorithm out there. I made this before I knew others had done it before, but it's a new method (as far as I know) that perhaps others could expand on. 

For reference, here are the other projects, in chronological order:
- [Troll](http://hjemmesider.diku.dk/~torbenm/Troll/) by Torben Ægidius Mogensen
- [AnyDice](https://anydice.com/) by Jasper Flick
- [SnakeEyes](https://snake-eyes.io/) by Noe Falzon
- [dice_roll.py](https://gist.github.com/vyznev/8f5e62c91ce4d8ca7841974c87271e2f) by Ilmari Karonen
- [`dyce`](https://github.com/posita/dyce) by Matt Bogosian
- [`icepool`](https://github.com/HighDiceRoller/icepool) by Albert Julius Liu


Special thanks to Albert Julius Liu and his team's amazing documentation for [`icepool`](https://github.com/HighDiceRoller/icepool). It was a huge help compiling the above list of projects and gaining a better understanding of order statistics. 
