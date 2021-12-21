/**
 * Name: Jerry Cai
 * Pennkey: jycai
 * Execution: java BombCell
 *
 * Description: Creates class that implements the Cell interface
**/
public class BombCell implements Cell{
    
    public int value;
    public int xPos;
    public int yPos;
    
    public boolean revealed;
    
    //Interface Implementation
    
    /**
     * Inputs: None
     * Outputs: 
     * Description: TODO
    */
    
    //Constructor
    public BombCell(int v, int x, int y) {
        this.value = v;
        this.xPos = x;
        this.yPos = y;
    }
    
    public BombCell (Point position) {
    }
    
    /**
     * Inputs: 
     * Outputs: 
     * Description: Helps draw the bomb cell
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
     * Inputs: None
     * Outputs: integer
     * Description: get value attribute
    */
    public int getValue() {
        return value;
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
     * Description: Sets Y Value
    */
    public void setY(int y) {
        this.yPos = y;
    }
    
    /**
     * Inputs: int value
     * Outputs: None
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
