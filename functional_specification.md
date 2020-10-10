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
* Tic-Tac-Toe: Two player on one with AI options.

## Not System Goals
* User registration
* Displaying animations or any kind of videos
* Responsive design

## Current Situation Description
We are a group of teacher from the nearby elementary school who would like to give some modernization to our playtime with the children. Our school is, aided by the government, for children living in a low quality environment. For the children under 5th grade, afterschool activity is obligatory. During this time we help them to concentrate on solving their homework and refreshing the content they learnt that day. After they finished with their studies we usually reward our children with some playtime to relax and lift the mood. Either the whole class plays together or the class is separated in little groups playing with different games. Under games we mean mastermind, tic-tac-toe, guess who i am, career charades and a lot more. The problem is that the school is on low budget. Our game boards are broken by the children, the chalks and paper are running out because of using them while playing. Every classroom contains a computer available for teachers. We want to reward our hard working children with some computer games too.

## Desired System Description
We want to give our children modern games they can play with on any computer. We want to develop their logic skills and also their social interacions. For example, with Tic-Tac-Toe they can play with new classmates, they have never played or never talked before. Nevertheless if they are playing alone because no classmates are nearby, they can play with our latest Artificial Intelligence technology. With the classic Snake game, children can experience what the first computer games were like. 2048 helps them to make friends with numbers and get closer to math. However, we can mention these games are color blind friendly, so everyone can play. With these four wonderful games we want our children to enjoy the boring everyday of school. With these simple games we want to help them cope with the problems of everyday adult life. In the future we want to expand our game set with more classic games, and help more children.

## Requested Business Process Model
    //Csabi

## List of Requirements
    //Matyi

## Usage Instances
    //Adrienn

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
    //Csabi

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
		* The user is able to choose wether it wants to play against AI or another player.
			* After the mode is chosen, the user is able to start playing the game.
		* The score of the player should be displayed while playing the rounds.
		* The winner should be displayed at the end of the rounds.
		* The winner should be displayed after the overall match has ended.
		* By clicking on the "Back" button the user is able to go back to the description of the game's rules.

## Function - Requirement Compliance
    //Matyi

## Glossary
    //Anna