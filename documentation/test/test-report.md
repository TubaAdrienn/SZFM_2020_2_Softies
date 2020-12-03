# Test Report

## Main page

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

## Rules page

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

## Tic-Tac-Toe

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
  
## Tic-Tac-Toe

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