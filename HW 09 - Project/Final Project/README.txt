How to Run Game:
Command Line Arg: java Game


Steps of Game

	1. Start and Setup of Game
		○ Board generates the grid 
		○ Game.FirstClick - first click that clears cells and generates bombs an
		○ Game creates BombCells and NumberCells to be used later
			§ BombCells created with random number generator for coordinates
			§ NumberCells created with random number generator for coordinates
            (blank cells value == 0)
		○ BombCells Creation inter
			§ Math.random iterates and creates random digits for the 10 mines. If
            the same cell location is selected, then another unique cell is 
            generated. isBomb boolean to indicate status
			§ alreadyRevealed Boolean value is set false
		○ NumberCells Creation
			§ countAdjacent(): Goes through the 9x9 array, and at each cell
            determines if surrouding cells have bombs. An int counter in NumberCells
            keeps track of adjacent. Checks adjacent with [i-1][j-1] through [i][j]
            through [i+1][j+1].  
				- If the index boundaries are incorrect, then it does not include
                into sum
				
			§ Assigns Cell.value to # of adjacent mines
			§ ?**Would using linked nodes make sense here or just indexing ? 
			§ ClickedAlready Boolean value is set false
		○ Surrounding cells of the first clicked cell are checked. If surrouding
        cell has value other than 0, then stop checking. Use CheckSurroundingCells()
        to check surrounding cells until boundaries have values or if index is out
        of bounds [0,9]. 
		○ ?**Recursive function with base case being !=0 or boundaries [0,9], and
        return statement checking each of the 8 surrounding. Use an isRevealed
        booelan to set cells if they are already revealed. 
		
		
	2. Duration of Game
		○ Player clicks on a given cell that is not yet revealed its content. If the
        cell is a bomb, player loses. If the cell is blank, use Check surounding
        cells until all surouding cells are numbers. If the cell is a number, then
        keep it as such. 
			§ ?**How would we change the appearance of the cell? If statements
            indicating what specific square to draw at the location? Or 
		○ Each click indicates a round of the game. 
		
	3. Ending Result of Game
If the isRevealed boolean is true for every single square, then the player has won.

** I also realized that the icon i used for the mine are actually flags, but to clear 

Java Files:

Board.java - Establishes a board that has cell array
BombCell.java - Class that implements the Cell Interface
Cell.java - Cell interface that provides for all cells in array
Game.java - Game has most of the functionalities of Minesweeper
NumberCell.java - Class that implements the Cell Interface with 0 being a 
blank space, 1-8 for number cells and 9 as a bomb

Image Files:

cell0.png
cell1.png
cell2.png
cell3.png
cell4.png
cell5.png
cell6.png
cell7.png
cell8.png
grid.png
grid1.png
mine.png