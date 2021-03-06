# Requirement Specification

## Current Situation
We are a group of teacher from the nearby elementary school who would like to give some modernization to our playtime with the children. Our school is, aided by the government, for children living in a low quality environment. For the children under 5th grade, afterschool activity is obligatory. During this time we help them to concentrate on solving their homework and refreshing the content they learnt that day. After they finished with their studies we usually reward our children with some playtime to relax and lift the mood. Either the whole class plays together or the class is separated in little groups playing with different games. Under games we mean mastermind, tic-tac-toe, guess who i am, career charades and a lot more. The problem is that the school is on low budget. Our game boards are broken by the children, the chalks and paper are running out because of using them while playing. Every classroom contains a computer available for teachers. We want to reward our hard working children with some computer games too.

## Desired System
We want to give our children modern games they can play with on any computer. We want to develop their logic skills and also their social interacions. For example, with Tic-Tac-Toe they can play with new classmates, they have never played or never talked before. Nevertheless if they are playing alone because no classmates are nearby, they can play with our latest Artificial Intelligence technology. With the classic Snake game, children can experience what the first computer games were like. 2048 helps them to make friends with numbers and get closer to math. However, we can mention these games are color blind friendly, so everyone can play. With these four wonderful games we want our children to enjoy the boring everyday of school. With these simple games we want to help them cope with the problems of everyday adult life. In the future we want to expand our game set with more classic games, and help more children.

## Current Business Processes
* Currently there is no business process for playing 2048 game since it has a website based origin.
* Currently there is no business process for playing snake since it has a mobile phone application based origin.
* Business process for Mastermind:
    * One child sets the hidden colors
    * Other child guesses the colors each round
    * First child puts the black and white pins based on the rightness of the guesses
    * Second child wins if they guess the hidden colors
    * Pins should be cleaned after the game
* Business process for Tic-Tac-Toe:
    * Grids are drawn on a paper
    * Two children puts X or O on the paper each round
    * The one who puts 3 in a row wins.

## Business Process Model
* Desktop application
* 2048 game
* Snake game
* Tic-Tac-Toe game
* Mastermind game
* Saving students scores, querying by highscore
* Child-friendly display
* Tic-Tac-Toe with TicTacToe
* Low system requirements
* Showing rules for the game

## Rules For The System
* The application should fall under the GNU General Public Licence which is a free, copyleft license for software and other kinds of works. It guarantees end users the freedom to run, study, share, and modify the software.
* The website should be created by using Java JDK 11, Maven and JavaFx. Since there will be no commercial release there should be no problem with the licences.
* Database should be collected to a MySQL Server which is an open-source relational database management system (RDBMS).
* In case of picture inclusion the format should be jpeg or npg.
 
## List of Requirements
* R01 - Easy to operate
* R02 - Child-friendly display
* R03 - Save scores to database (MySQL)
* R04 - Retrieve data from database
* R05 - Contains 4 games - 2048, Snake, Tic-Tac-Toe, Mastermind
* R06 - Tic-Tac-Toe has an TicTacToe or a 2 people version

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