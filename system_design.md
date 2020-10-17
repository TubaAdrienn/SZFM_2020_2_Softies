# System Design

## System Goals
One of our goals regarding the system is to keep it 7/24 available. Regarding the display we will use friendly and bright design to make it appealing to the children. One purpose is to inform users about their current score, highest score and the possibilities they have with the buttons, so in order to make an easy to use and understand application we seek clear design too. One of the basic features of the system is the ability to react to users' activity, like clicking on the fields or using direction keys while playing with the chosen game. Other desired ability is to switch between games in case the user changed its mind by having the opportunity to go back to the page where all games are listed. Among other features the user has the chance to go back to the previous page to check the game's description and its rules in case something is not clear while playing, and the opportunity to choose the type of the player the user wants to play with. Regarding the rules of the games we plan to use MySQL to retrieve each game's rules from a database and load it into the chosen game's description page. High scores will be stored in a database too and displayed on the game's page during playing to inform players about the highest score reached so far. 

## Not System Goals
* Administration of users
* Enable registration
* Enable log in
* Network dependence
* Enable user to delete or modify data
* Need of high system requirements
* Displaying videos and musics
* Displaying advertisements
* Storing users' data
* Logging activities
* User authentication
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

## Requirements
* R01 - Easy to operate
* R02 - Child-friendly display
* R03 - Save scores to database (MySQL)
* R04 - Retrieve data from database
* R05 - Contains 4 games - 2048, Snake, Tic-Tac-Toe, Mastermind
* R06 - Tic-Tac-Toe has an AI or a 2 people version

## Functional Design
* Main page: 4 games, Game Arcade Caption, Exit.
* Rules page: Add name option, Rules about the games, Little pictures.
* 2048: 4x4 display place; Best score; Current score; New game button; Back to menu.
* Snake: Snakey display; Best score; Current score; Back to menu button.
* Tic-Tac-Toe: Vs AI, 1v1 option buttons; 3x3 display place; Back to menu button.
* Mastermind: Color buttons; Back to menu button; Back, Submit, Finish function buttons; Display of guessed colors; High score; Current score.

## Physical Environment

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
* In our application these will be the DAO classes, the AI classes and other independent reusable classes.

## Architectural Design

## Database Design

## Implementation design

## Test Design

## Installation Design

## Maintenance Design