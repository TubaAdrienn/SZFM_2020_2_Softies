# Functional Specification

## System Goals
* Desktop application for kids between the ages of 6-10 that contains 4 mini games:
    * First game: 2048 game
    * Second game: Classic Snake
    * Third game: Tic-Tac-Toe
    * Fourth game: Mastermind
* Saving and querying high scores for each game.
* Saving highscores by adding name at the end of the game
* Showing game rules.
* Tic-Tac-Toe: Two player on one with TicTacToe options.

## Not System Goals
* User registration
* Displaying animations or any kind of videos
* Responsive design

## Current Situation Description
We are a group of teacher from the nearby elementary school who would like to give some modernization to our playtime with the children. Our school is, aided by the government, for children living in a low quality environment. For the children under 5th grade, afterschool activity is obligatory. During this time we help them to concentrate on solving their homework and refreshing the content they learnt that day. After they finished with their studies we usually reward our children with some playtime to relax and lift the mood. Either the whole class plays together or the class is separated in little groups playing with different games. Under games we mean mastermind, tic-tac-toe, guess who i am, career charades and a lot more. The problem is that the school is on low budget. Our game boards are broken by the children, the chalks and paper are running out because of using them while playing. Every classroom contains a computer available for teachers. We want to reward our hard working children with some computer games too.

## Desired System Description
We want to give our children modern games they can play with on any computer. We want to develop their logic skills and also their social interacions. For example, with Tic-Tac-Toe they can play with new classmates, they have never played or never talked before. Nevertheless if they are playing alone because no classmates are nearby, they can play with our latest Artificial Intelligence technology. With the classic Snake game, children can experience what the first computer games were like. 2048 helps them to make friends with numbers and get closer to math. However, we can mention these games are color blind friendly, so everyone can play. With these four wonderful games we want our children to enjoy the boring everyday of school. With these simple games we want to help them cope with the problems of everyday adult life. In the future we want to expand our game set with more classic games, and help more children.

## Requested Business Process Model
* Desktop Application ⟶ MVN, Java, JavaFX.
* 2048 game ⟶ Button to chose the game, game implementation.
* Snake game ⟶ Button to chose the game, game implementation.
* Tic-Tac-Toe game ⟶ Button to chose the game, game implementation.
* Mastermind game ⟶ Button to chose the game, game implementation.
* Showing rules for the game ⟶ Display the rules after chosing a game but before starting it.
* Displaying High Score ⟶ Saving and querying highscores to MySQL Database.
* Tic-Tac-Toe TicTacToe ⟶ Option to chose between versus TicTacToe or 2 player mode.
* Child friendly display ⟶ Happy, warm colors, no scary pictures and no harmful content.
* Low system requirements ⟶ Should run fast on a microwave too.

## List of Requirements
* R01 - Easy to operate
* R02 - Child-friendly display
* R03 - Save scores to database (MySQL)
* R04 - Retrieve data from database
* R05 - Contains 4 games - 2048, Snake, Tic-Tac-Toe, Mastermind
* R06 - Tic-Tac-Toe has an TicTacToe or a 2 people version

## Usage Instances
   <img src="img/Usage Instances.png"
     alt="Usage Instances UML"
     style="float: left; margin-right: 10px;" />
     
   <img src="img/Usage Instances2.png"
     alt="Usage Instances UML"
     style="float: left; margin-right: 10px;" />     

## Compliance - How the usage instances satisfy the requirements
* Home Page: The main page will contain the option to choose between the games. Also it will be displayed in a way that a child might find it entertaining, vibrant and lively colors will be used with no unsettling images. It will be quite easy to operate between games as they will be displayed in a fashion that they can be distinguished from each other.
* Rules Page: By choosing the one of games the player will automatically be redirected to another page where the game rules will be displayed. Depending on the game the option to add one or two player name will generate one or two places to add player names.
	* Scores will also be displayed on this page so later it can be tracked down who have been the best players so far.
	* Pressing Play on either game should result in the actual gameplay. Each game will have a separate page and unique design so the user entertainment would he maximal. 
* Playing With The Game: Four games should be implemented in a way that they satisfy their rules. These games are: 2048, Tic-tac-toe, Mastermind and Snake.
	* Tic-Tac-Toe implementation will also contain buttons to choose from 1v1 mode or 1vAI mode.
* Saving Score: After each game the score should be saved in an external database if the game ended in success. Mostly name of the winner should be stored in the database and a timestamp that displays the time spent on playing with the game. Only the best 5 should be displayed later.
* After saving the score there is an option to exit the game entirely or to go back to home page and start playing with another game.

## Visual Design

* Visual design for Main page:

   <img src="img/main_page.png"
     alt="Main page visual design"
     style="float: left; margin-right: 10px;" />
     
* Visual design for Rule page:

   <img src="img/rule_page.png"
     alt="Rule page visual design"
     style="float: left; margin-right: 10px;" />     
          
* Visual design for 2048:

   <img src="img/2048.png"
     alt="2048 visual design"
     style="float: left; margin-right: 10px;" />
     
* Visual design for Snake:

   <img src="img/snake.png"
     alt="Snake visual design"
     style="float: left; margin-right: 10px;" />
     
* Visual design for Tic-Tac-Toe:

   <img src="img/tic-tac-toe.png"
     alt="Tic-Tac-Toe visual design"
     style="float: left; margin-right: 10px;" />
     
* Visual design for Mastermind:

   <img src="img/mastermind.png"
     alt="Mastermind visual design"
     style="float: left; margin-right: 10px;" />        

## Scenarios

 Opening the game portal should result in the greeting page displaying. This page should contain 4 games' images that the user could choose from.
* By clicking on Snake:
	* The user is redirected to a new page, which contains a description of the game's rules.
	* By clicking on the "Back" button, the user is able to go back to the greeting page to choose from another game.
	* By clicking on the "Play" button:
		* The user is able to start playing the game.
		* The actual score of the game should be displayed while playing.
		* The highest score should be diplayed while playing the game and saved at the end of the round.
		* By clicking on the "Back" button the user is able to go back to the description of the game's rules.

* By clicking on 2048:
	* The user is redirected to a new page, which contains a description of the game's rules.
	* By clicking on the "Back" button, the user is able to go back to the greeting page to choose from another game.
	* By clicking on the "Play" button:
		* The user is able to start playing the game.
		* The actual score of the game should be displayed while playing.
		* The highest score should be diplayed while playing the game and saved at the end of the round.
		* By clicking on the "Back" button the user is able to go back to the description of the game's rules.

* By clicking on Mastermind:
	* The user is redirected to a new page, which contains a description of the game's rules.
	* By clicking on the "Back" button, the user is able to go back to the greeting page to choose from another game.
	* By clicking on the "Play" button:
		* The user is able to start playing the game.
		* The actual score of the game should be displayed while playing.
		* The highest score should be diplayed while playing the game and saved at the end of the round.
		* By clicking on the "Back" button the user is able to go back to the description of the game's rules.

* By clicking on Tic-Tac-Toe:
	* The user is redirected to a new page, which contains a description of the game's rules.
	* By clicking on the "Back" button, the user is able to go back to the greeting page to choose from another game.
	* By clicking on the "Play" button:
		* The user is able to choose wether it wants to play against TicTacToe or another player.
			* After the mode is chosen, the user is able to start playing the game.
		* The score of the player should be displayed while playing the rounds.
		* The winner should be displayed at the end of the rounds.
		* The winner should be displayed after the overall match has ended.
		* By clicking on the "Back" button the user is able to go back to the description of the game's rules.

## Function - Requirement Compliance
The requirements are written in the Requirement Specification. The games should work properly with no lags, no crashing. Every children should easy to operate with the games with the child-friendly display. The scores should save to the database. The platform should contain four games: 2048, Snake, Tic-Tac-Toe, Mastermind. The Tic-Tac-Toe should contain a two-player version and an TicTacToe version. All four games should show the rules for the games.

## Glossary
* Desktop game: It is a type of video game played on personal computers rather than on video game consoles or arcade machine.
* Website based origin: The video game is played via the World Wibe Web using a web browser.
* Application based origin: The game is played on mobile phone, tablet, smartwatch or any portable media player.
* Java: A general purpose programming language developed by Sun Microsystems.
* Java JDK 11: An update of Java released on September 25, 2018.
* Maven: A software that helps in managing software projects and automatization of processes.
* GUI: Stands for graphical user interface that allows interaction between users and electronic devices by clicking on icons or through text navigation.
* JavaFx: A software platform for creating desktop applications' GUI.
* RDBMS: Relational Database Management System is a software that allows users to define, create, maintain, or control access to the database.
* TicTacToe: Artificial intelligence is "intelligence" demonstrated by machines. Any device that observes its environment and takes actions that maximize the chance of achieving its goals successfully.
* jpeg: A compression used in image file formats. Compression is lossy.
* png: Stands for Portable Network Graphics. Image file format that supports lossless data compression.