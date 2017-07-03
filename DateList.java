
// DateList.java
// 
// This version uses three instance variables,
// a pointer to the first node, a pointer to
// the last node, and length, to make our
// append and getLength methods more efficient
// than the would be if our only instance
// variable were a pointer to the first node.
//
// This version uses a dummy first node.  Hence
// it needs less decision-making than it would
// need if a dummy first node were not used.
//

/**
 * Encapsulates a linked list of <code>Date212</code>.
 */
public abstract class DateList {

   /** First node in linked list - dummy node */
   private DateNode first = new DateNode(null);

   /** Last node in linked list */
   private DateNode last = first;

   /** Number of data items in the list. */
   private int length = 0;
} // class DateList
