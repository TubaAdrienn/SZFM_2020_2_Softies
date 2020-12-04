# Test Report

## Main page - Adrienn Tuba

### **Manual Tests**
* Test 1: 
  * Tests whether the Mastermind image leads to the right Rules page
  * Test successful
* Test 2: 
  * Tests whether the 2048 image leads to the right Rules page
  * Test successful
* Test 3: 
  * Tests whether the Tic-Tac-Toe image leads to the right Rules page
  * Test successful
* Test 4: 
  * Tests whether the Snake image leads to the right Rules page
  * Test successful

## Rules page - Adrienn Tuba

### **Manual Tests**
* Test 1:
  * Tests whether every rule belongs to the right game
  * Test successful
* Test 2: 
  * Tests whether play button reacts to click and starts game
  * Test successful
* Test 3:
  * Tests whether textfield accepts name and saves it
  * Test successful

## Tic-Tac-Toe - Adrienn Tuba

### **Junit Tests**

* Test testGameStateIsOverTest():
  * Tests whether the method gives the right boolean if the game is over
  * Successful test
* Test testGameIsWinningStateTest():
  * Tests whether the method gives the right boolean if the game is in winning state
  * Successful test
* Test moveIsAppliableTest():
  * Tests whether a move is appliable to a current gamestate
  * Successful test 
* Test applyMoveTest():
  * Tests whether the move after being appliad, gives back the right gamestate
  * Successful test

### **Manual Tests**
* Test 1:
  * Tests whether every cell reacts to click, display the right character
  * Test successful
* Test 2: 
  * Tests whether back button reacts to click and goes back to rules page
  * Test successful
* Test 3:
  * Tests whether AIv1 button reacts to click and sets the game against AI
  * Test successful
* Test 4: 
  * Tests whether 1v1 button reacts to click and sets new game
  * Test successful
  
## Tic-Tac-Toe - Adrienn Tuba

### **Junit Tests**
//Adding content

### **Manual Tests**
* Test 1:
  * Tests whether every cell display the right character and right color
  * Test successful
* Test 2:
  * Tests whether back button reacts to click and goes back to rules page
  * Test successful
* Test 3:
  * Tests whether New Game button reacts to click and restart the game
  * Test successful
* Test 4:
  * Tests whether generate new cells with the arrow keys
  * Test successful
* Test 5:
  * Tests whether cells collapse in the specified way
  * Test successful
  
### Snake - Anna Egyed

### **Junit Tests**

* Test checkIfCellNotOver(): (1)
  * Tests whether there is cell to step.
  * Test successful.
* Test checkIfCellNotOver(): (2)
  * Tests whether there is no cell to step.
  * Test successful.

* Test checkIfNotSelfTest(): (1)
  * Tests whether the next cell is itself.
  * Test successful.
* Test checkIfNotSelfTest():  (2)
  * Tests whether the next cell is not itself.
  * Test successful.
  
* Test canMakeStepTest(): (1)
    * Tests whether snake is able to mak a step out of the gamestate.
    * Test successful.
* Test canMakeStepTest(): (2)    
    * Tests whether snake is able turn right, where move is appliable.
    * Test successful.
* Test canMakeStepTest(): (3) 
    * Tests whether the snake can make a step where its body is.
    * Test successful.

* Test generateSnakeTest():
    * Tests whether snake is generated.
    * Test successful.

* Test generateFoodTest():
    * Tests whether food is generated.
    * Test successful.

* Test moveSnakeUPTest():
    * Test whether the snake moves to the direction "up".
    * Test successful.

* Test moveSnakeDOWNTest():
    * Test whether the snake moves to the direction "down".
    * Test successful.

* Test moveSnakeLEFTTest():
    * Test whether the snake moves to the direction "down".
    * Test successful.
    
* Test moveSnakeRIGHTTest():
    * Test whether the snake moves to the direction "down".
    * Test successful.
* Test decreseCellsTest():
* Test isOverSelfCollapsedTest():
* Test isOverOutOfBoardTest():

### **Manual Tests**

* Test 1: 
* Test 2: