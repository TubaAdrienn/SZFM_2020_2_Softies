# System Design

## System Goals
One of our goals regarding the system is to keep it 7/24 available. Regarding the display we will use friendly and bright design to make it appealing to the children. One purpose is to inform users about their current score, highest score and the possibilities they have with the buttons, so in order to make an easy to use and understand application we seek clear design too. One of the basic features of the system is the ability to react to users' activity, like clicking on the fields or using direction keys while playing with the chosen game. Other desired ability is to switch between games in case the user changed its mind by having the opportunity to go back to the page where all games are listed. Among other features the user has the chance to go back to the previous page to check the game's description and its rules in case something is not clear while playing, and the opportunity to choose the type of the player the user wants to play with. Regarding the rules of the games we plan to use MySQL to retrieve each game's rules from a database and load it into the chosen game's description page. High scores will be stored in a database too and displayed on the game's page during playing to inform players about the highest score reached so far. 

## Not System Goals
* Administration of users
* Enable registration
* Enable log in
* Enable user to delete or modify data
* Need of high system requirements
* Displaying videos and musics
* Displaying advertisements
* Logging activities
* Responsive design

## Project Plan

#### Positions:

* Adrienn Tuba - Tic-Tac-Toe
* Csaba Szilágyi - Mastermind
* Mátyás Fenyvesi - 2048
* Egyed Anna - Snake

#### Schedule:

**2020.10.05. \- 2020.10.11.**
* **2020.10.05.**
	* Meeting with the customer and discussing the specifications and the requirements of the system.
	* I. Team meeting discussing the new system order.
* **2020.10.08.**
	* II. Team meeting discussing the functional specification.
	* Start working on the functional specification of the system.
* **2020.10.11.**
	* Deadline of requirement specification.
	* Deadline of functional specification.

**2020.10.12. \- 2020.10.18.**
* **2020.10.12.**
	* Meeting with the customer to clarify the requirement and functional specification.
* **2020.10.15.**
	* III. Team meeting discussing the system design.
	* Planning the system's structure.
* **2020.10.18.**
	* Deadline of system design.
	* IV. Team meeting discussing the process so far and the next moves.

**2020.10.19. \- 2020.10.25.**
* **2020.10.19.**
	* Meeting with the customer to clarify system design.
	* Start first sprint section - Development I.
	* 16:00 - Daily Stand Up Meeting
		* Discussing the improvement from the previous day.
		* Discussing the arising problems.
		* Discussing the plan to the next day.
* **2020.10.20.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.21.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.22.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.23.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.24.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.25.**
	* V. Team meeting discussing the overall process so far, closing down the first sprint section.

**2020.10.26. \- 2020.11.01.**
* **2020.10.26.**
	* Meeting with the customer. Clarify the development so far.
	* Start second sprint section: Development II.
* **2020.10.27.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.28.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.29.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.30.**
	* 16:00 - Daily Stand Up Meeting
* **2020.10.31.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.01.**
	* VI. Team meeting discussing the overall process so far, closing down the second sprint section.

**2020.11.02. \- 2020.11.08.**
* **2020.11.02.**
	* Meeting with the customer. Clarify the development so far.
	* Show the demo of the software.
	* Show demo of the system.
	* Start third sprint section - Development III., Demo
* **2020.11.03.**
	* 16:00 - Daily Stand Up Meeting.
* **2020.11.04.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.05.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.06.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.07.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.08.**
	* VII. Team meeting discussing the overall process so far, closing down the third sprint section.

**2020.11.09. \- 2020.11.15**
* **2020.11.09.**
	* Meeting with the customer. Clarify the development so far.
	* Start fourth sprint section - Development IV - Testing I
* **2020.11.10.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.11.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.12.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.13.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.14.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.15.**
	* VIII. Team meeting discussing the overall process so far, closing down the fourth sprint section.

**2020.11.16. \- 2020.11.23**
* **2020.11.16.**
	* Meeting with customer. Clarify development so far.
	* Start fifth sprint section - Testing II.
* **2020.11.17.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.18.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.19.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.20.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.21.**
	* 16:00 - Daily Stand Up Meeting
* **2020.11.22.**
	* IX. Team meeting discussing the overall process so far, closing down the fourth sprint section.
* **2020.11.23.**
	* Meeting with the customer and hand over the system.

## Business Process Model
Opening the Game in the Main page you can see the four games(Tic-Tac-Toe, Snake, Master Mind, 2048) with a wonderful background. By opening a game, you will be navigated to the Game Rule page, where you can see a short description for how to play the game. You can find here the Play button and you can write your name for the Scoreboard. With the Play button, you can start the game. If you bored the game, just press Back button and play another one.

## Requirements
* R01 - Easy to operate
* R02 - Child-friendly display
* R03 - Save scores to database (MySQL)
* R04 - Retrieve data from database
* R05 - Contains 4 games - 2048, Snake, Tic-Tac-Toe, Mastermind
* R06 - Tic-Tac-Toe has an TicTacToe or a 2 people version

## Functional Design

* Main page:
    * Title: Games Arcade Caption as a title.

    * Games: 4 games with little clickable child friendly picture.

    * Exit button: Clicking this button, the user will exits the application.

* Rules page:
    * Name bar: Add name option, where users are able to type their playername.

    * Rules display place: Rules about the games.

    * Little pictures: Literally little pictures.

* 2048: 
    * 4x4 place: Display the current gameplay.

    * Best score: Display the score from data base, which is the best score in all time.

    * Current score: Display the score from currently on going game.

    * New game button: Clicking this button, the user start a new game.
    
    * Back to menu button: Clicking this button, the user will direct back to main page.

* Snake:
    * Snake display palce: Display the snake and the apple, as well the snake moving space.

    * Best score: Display the score from data base, which is the best score in all time.

    * Current score: Display the score from currently on going game.

    * Back to menu button: Clicking this button, the user will direct back to main page.

* Tic-Tac-Toe:
    * Vs TicTacToe button: Clicking this button, the user will play against Artificial Intelligence.
    
    * 1v1 button: Clicking this button, the user will play against an another player.

    * 3x3 display place: Display the current gameplay.

    * Back to menu button: Clicking this button, the user will direct back to main page. 

* Mastermind:
    * Color buttons: Clicking these buttons, add given color which is on the button.

    * Back to menu button: Clicking this button, the user will direct back to main page.

    * Back button: Function button, delete last guessed color (if we don't click on submit yet in this line).
     
    * Submit button: Function button, which is submitted the player guess.
    
    * New game button: Clicking this button, the user start a new game.

    * Guessed colors: Display of guessed colors.

    * High score: Display the score from data base, which is the best score in all time.

    * Current score: Display the score from currently on going game.
    
    * Info box: Display warnings, infos for player.

## Physical Environment
* Operating System:
	* Windows 10
	* Ubuntu
* Development environment:
	* Visual Studio Code
	* IntelliJ IDEA
* Software platform:
	* JavaFx

## Abstract Domain Model
### Main components of the design
The application will follow the MVC pattern which is a software design pattern that is very commonly used to create application where the related program logic is diveded into three categories.
#### Model 
* The model part is the central part of the application. This is the part where the main logic business logic happens and it is the dynamic data structure. It should be independent of the user interface.
* The models data will be managed by a database handling class (DAO - Data Accessing Object)
* In our the model part will represent the:
	* Highscores of the games
	* The rules of the games
	* Business logics of the games
#### View
* The view is representation of the application. This is the user interface, the part where the visual design is the most important to create the most satisfying user experience. It should be independent of the model part.
* Each game will have its own view as well as the rules page and the main page.
#### Controller
* The controller is the connecting element. It accepts user input and creates a response fit for that input by asking for data trough the model and displaying it on the view.
* In our application each view will have its own controller.
#### Util
* Util classes are usually classes that implement some kind of business logic that can be reused in more than one application such as DAO classes for example.
* In our application these will be the DAO classes, the TicTacToe classes and other independent reusable classes.

![alt text](img/adm.jpg "Abstract Domain Model")

## Architectural Design
* As mentioned in the Abstract Domain Model the application will implement the MVC pattern and its elements which means that it is going to be a three level application. These levels:
  * Model - Data structures, business logic
  * View - FXML files, visual design implementations
  * Controller - Connecting element of the model and the view that hangles user inputs and requests
* Since the model's main goal is to separate these elements from each other for greater extensibility it is easier to add new components to these applications if the need arises. If there's a request to add more games to the application or change one it can be easily done by adding new model, view and controller elements to the project without deeply changing any other.
## Database Design
Our database system will be implemented using MySQL which is an open-source relational database management system that can be easily used in different kind of Java applications. To use MySQL databases from Java projects a MySQL server is needed so we can create a connection to that and there it is possible to create new tables. It can be achieved by using JDBC.

Our application will require two of these tables, since we are using a HighScore and a Rules class which will represent and manage the queried data from these tables.

As one can see the Rules table will have three attributes: an ID, a Game and a Rule attribute. The ID will be the primary key, the Game attribute will display which game the rule belongs to and then the rule itself that describes the game.

![alt text](img/rules.png "Rules")

The second table will contain four attributes: an ID, a Game attribute, a Name attribute and a Score. The ID is obviously the primary key, the Game attribute represents what game the score belongs to, the name will be the name of the player who created that score and then the score itself is also stored.

![alt text](img/db1.png "Games")

## Implementation design
* Persistence classes:
	* DAO.java - using JDBC (probably)
	* Highscore.java
	* Rules.java
* Business logic classes:
	* Controller classes:
		* One for each game
		* One for the main page
		* One for the rules page
	* Other util or game managing classes
	* TicTacToe classes
* Client-side classes:
	* FXML files:
		* One for each game
		* One for main page
		* One for rules page

## Test Design
The reason we need test design is that noone can write perfect programs, so we need automated and manual tests both to make sure no bugs find their way into our programs. We are testing the followings:
* If every button and controller element work well
* If the game gets into an infinite loop or throws some unexpected exception
* Calculations and business logic work perfectly
* Player names and scores are saved to database
* Player names and scores are retrieved from database
* Game content appears as it should be

The tests should be run on both Windows Operating System and Ubuntu since we thrive to create platfrom independent applications. 
Test should both be:
* Manual
* Automated - JUnit in this case

After these tests we should give it to friends or acquaintances to test the application because we would be biased about the result and thus the final result of the test would not be appropriate.
After the tests are executed the results should be written down on a report and bugs should be reported to the senior project leader so they can decide what steps should take place in case of fixing the arising bug.

## Installation Design
The application should be easy to install and to use. But a child needs parent's or teacher's support to execute installation.
Requirements:
* Have an electrical device (PC, Laptop) that is capable of accessing the Internet as it should be required to access the database server.
* Purchase the application
* Access to Internet
* Run the application

## Maintenance Design
With the constant development of IT, we want to keep ourselves up-to-date with technologies, and thus we consider it important to maintain our application.
* List of maintance tasks:
    * Bug fixes
    * Improving game experience based on feedback
    * Add more games if needed