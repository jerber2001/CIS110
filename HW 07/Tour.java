/**
 * Name: Jerry Cai
 * Pennkey: jycai
 * Execution: java Tour 
 *
 * Description: Tour an object that takes points and draws lines between using nodes
 * 
**/
public class Tour implements TourInterface {
    
    //Object Declaration
    private Node head;
    private Node lastNode;
    
    public static void main(String[] args) {
        TourInterface test = new Tour();
        //Defines points to be passed
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);
        
        test.insertInOrder(a);
        test.insertInOrder(b);
        test.insertInOrder(c);
        test.insertInOrder(d);
        
        test.toString();
        
        test.draw(a);
        test.size();
        test.distance();

        
    }
    
    public Tour() {
        this.head = null;
        this.lastNode = null;
    }
    
    /**
    * Return a string representation of points in the tour, in order
    * @return string representation of points in the tour, in order
    */
    
    /*  Inputs: None
    *   Output: String value of the the points of the shape
    *   Description: Prints out the point coordinates associated with the shape
    */
    public String toString() {
        //null condition test
        if (head == null) {
            return "";
        }
        
        //Takes each node and point and prints out coordinates
        String output = "";
        Node curr = head;
        while (curr != null) {
            output += curr.point.toString();
            curr = curr.next;
        }
        return output;
    }
    
    /**
    * Draws the tour
    * @param p draws any edge whose start or end point is p in a different color
    */
    
    /*   Inputs: Point p
    *   Output: None
    *   Description: Draws the lines between points associated
    */
    public void draw(Point p) {
        Node curr = head;
        Point i = curr.point;
        Point f = curr.next.point;
        
        // Iterates through the nodes and determines color of line
        while (curr.next != null) {
            i = curr.point;
            f = curr.next.point;
            if (i.equals(p) || f.equals(p)) {
                PennDraw.setPenColor(PennDraw.RED);
            } else {
                PennDraw.setPenColor(PennDraw.BLACK);
            }
            
            //draws the line of initial ot final point
            i.drawTo(f);
            curr = curr.next;
        }
        
    }
    
    /**
    * Returns the number of points in the tour
    * @return the number of points in the tour
    */
    
    /*   Inputs: None
    *   Output: Integer counter -1 
    *   Description: Gives the number of points in tour
    */
    public int size() {
        if (head == null) {
            return 0;
        }
        Node curr = head;
        int counter = 0;
        while (curr != null) {
            curr = curr.next;
            counter++;
        }
        return counter - 1;
    }
    
    /**
    * Returns the total length of the tour
    * @return the total length of the tour
    */
    
    /*   Inputs: None
    *   Output: Double 
    *   Description:
    */
    public double distance() {
        if (head == null) {
            return 0;
        }
        Node curr = head;
        double totalDistance = 0;
        while (curr.next != null) {
            
            totalDistance += curr.point.distanceTo(curr.next.point);
            curr = curr.next;
        }
        return totalDistance;
    }
    
    /**
    * Insert p at the end of the tour; does nothing if p is null
    * @param p the point to add to the tour
    */
    
    /*   Inputs:
    *   Output:
    *   Description:
    */
    //What values do i put into Node()?
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public void insertInOrder(Point p) {
        if (head == null) {
            lastNode = new Node(p);
            head = new Node(lastNode, p);
        } else {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(this.lastNode, p);
        }
        
    }
    
    /**
    * Insert p after the point to which it is closest; does nothing if p is null
    * @param p the point to add to the tour
    */
    
    /*   Inputs: Point p
    *   Output: none
    *   Description: Looks at point amongst shape closest to p and draws minimal
    * distance line
    */
    
    public void insertNearest(Point p) {
        Node curr = head;
        if (curr == null) {
            insertInOrder(p);
            return;
        }
        
        //for loop to find closest node
        
        double minDistance = Double.MAX_VALUE;
        Node minPointNode = new Node(p);
        while (curr != null) {
            if (curr.point.distanceTo(p) < minDistance) {
                minDistance = curr.point.distanceTo(p);
                minPointNode = curr;
            }
            curr = curr.next;
        }
        
        //insert node after minpoint
        
        Node newNode = new Node(minPointNode.next, p);
        minPointNode.next = newNode;
        
        return;
    }
    
    /**
    * Insert p where it will cause the shortest detour; does nothing if p is null
    * @param p the point to add to the tour
    */
    
    /*   Inputs Point p
    *   Output: none
    *   Description: Inserts node in linked list at location where the line 
    * distance between the 2 points are minimized
    */ 
    public void insertSmallest(Point p) {
        Node curr = head;
        //While Loop through each node: test distance
        if (curr == null) {
            insertInOrder(p);
            return;
        }
        
        //for loop to find closest node
        
        double minDistance = Double.MAX_VALUE;
        double sp = 0;
        double pt = 0;
        double e = 0;
        double difference = 0;
        Node newNode = new Node(p);
        Node minDistanceNodeKeeper = new Node(p);
        
        while (curr.next != null) {
            //inserts the new node after the current
            
            sp = curr.point.distanceTo(p);
            pt = curr.next.point.distanceTo(p);
            e = curr.point.distanceTo(curr.next.point);
            difference = (sp + pt) - e;
            
            //compares distance
            if (difference < minDistance) {
                minDistanceNodeKeeper = curr;
                minDistance = difference;
            }
            curr = curr.next;
        }
        newNode.next = minDistanceNodeKeeper.next;
        minDistanceNodeKeeper.next = newNode;
        
        return;
    }
    
}
