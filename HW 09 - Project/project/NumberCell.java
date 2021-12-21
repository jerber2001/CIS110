public class NumberCell implements Cell {
    
    public int value;
    public int xPos;
    public int yPos;
    
    public void PlaceCellsOnBoard() {
        
    }
    public NumberCell(int v, int x, int y) {
        value = v;
        xPos = x;
        yPos = y;
    }
    
    public void draw() {
        
    }
    
    public void reactToClick() {
        
    }
    

    public int getX() {
        return xPos;
    }
    

    public int getY() {
        return yPos;
    }
    
    public void setX(int x) {
        this.xPos = x;
    }
    

    public void setY(int y) {
        this.xPos = y;
    }
    

    public int getValue() {
        return value;
    }
    
    public void setValue(int v) {
        this.value = v;
    }
}