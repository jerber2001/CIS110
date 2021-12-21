/**********************************************************************
 *  readme template                                                   
 *  Traveling Salesperson Problem
 **********************************************************************/

Name: Jerry Cai
PennKey: jycai
Hours to complete assignment (optional): 12


/**********************************************************************
 *  Please list all help, collaboration, and outside resources
 *  you used here. 
 *
 *  If you did not get any help in outside of TA office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/


 *  "I did not receive any help outside of TA office hours.  I
 *  did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/

 I took the distance from the given point and used the distance method between
 each of the respective points in the linked list. I incorporaed a while loop 
 to search through each of the nodes, and if else loop to find the minimum
 value. A new node was created with reference pointing to former curr.next
 and the curr.next is redefined. 

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/

The differences were implementing 3 doubles to find the diffeences between 
points on the nodes, and minimizing the length of these lines. Using the 
while loop and if/else statements we are able to find the insertion point. 

/**********************************************************************
 *  Fill in the distances computed by your heuristics.                
 **********************************************************************/

data file        order     nearest     smallest      extra credit
-----------------------------------------------------------------------
tsp10.txt         2586.7    1566.1      1655.7
tsp100.txt        25547     7389.9      4887.2
tsp1000.txt       3.2769e+05 27869      17266
usa13509.txt      3.9108e+06 77450      45075




 
 /**********************************************************************
 *  Why is it a good idea to repeat the first Node at the end of the
 *  Tour?
 **********************************************************************/

 Because it acts as a circular linkedlist 

 
/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/


 
 
 
/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/



 
/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

Figuring out the initial interface implementation, building the utility 
functions and understanding the class/object interactions. Lastly buildingd
the smallest Distance. 


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

 
 
 
