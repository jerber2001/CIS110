public class BombCell implements Cell{
    
    public int value; 
    public int xPos;
    public int yPos;
    
    //Interface Implementation


    public void PlaceCellsOnBoard() {
        
    }
    
    //Constructor
    
    public BombCell(int v, int x, int y) {
        this.value = v; 
        this.xPos = x;
        this.yPos = y;
    }
    
    public BombCell (Point position) {
        
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
    
    public int getValue() {
        return value;
    }
    
    public void setX(int x) {
        this.xPos = x;
    }
    

    public void setY(int y) {
        this.yPos = y;
    }
    
    public void setValue(int v) {
        this.value = v;
    }
    

    
}