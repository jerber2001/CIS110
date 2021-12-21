/**
 * Name: Jerry Cai
 * Pennkey: jycai
 * Execution: java NumberCell
 *
 * Description: Creates class that implements the Cell interface
**/
public class NumberCell implements Cell {
    
    private int value;
    private int xPos;
    private int yPos;
    private boolean revealed;
    
    private boolean alreadyClicked;
    
    //Constructor
    public NumberCell(int v, int x, int y) {
        value = v;
        xPos = x;
        yPos = y;
    }
    
    /**
     * Inputs: None
     * Outputs: None
     * Description: Helps draw the Number cell
    */
    public void draw() {
    }
    
    /**
     * Inputs: None
     * Outputs: None
     * Description: Getter function for X value
    */
    public int getX() {
        return xPos;
    }
    
    /**
     * Inputs: None
     * Outputs: None
     * Description: Getter function for Y value
    */
    public int getY() {
        return yPos;
    }
    
    /**
     * Inputs: Integer
     * Outputs: None
     * Description: Sets X value
    */
    public void setX(int x) {
        this.xPos = x;
    }
    
    /**
     * Inputs: Integer
     * Outputs: None
     * Description: Sets Y value
    */
    public void setY(int y) {
        this.xPos = y;
    }
    
    /**
     * Inputs: None
     * Outputs: integer
     * Description: get value attribute
    */
    public int getValue() {
        return value;
    }
    
    /**
     * Inputs: int value
     * Outputs:
     * Description: sets the value
    */
    public void setValue(int v) {
        this.value = v;
    }
    
    /**
     * Inputs: None
     * Outputs: None
     * Description: Boolean for revealled cell
    */
    public void setRevealed() {
        this.revealed = true;
    }
    
    /**
     * Inputs: None
     * Outputs: Boolean
     * Description: boolean of whether the cell is revealed
    */
    public boolean returnRevealed() {
        return revealed;
    }
}
