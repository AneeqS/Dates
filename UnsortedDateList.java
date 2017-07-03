
public class UnsortedDateList extends DateList {
   /** First node in linked list - dummy node */
   private DateNode first = new DateNode(null);

   /** Last node in linked list */
   private DateNode last = first;

   /** Number of data items in the list. */
   private int length = 0;

   /**
    * Gets the number of data values currently stored in this LinkedList.
    * 
    * @return the number of elements in the list.
    */

   public int getLength() {
      return length;
   }

   /**
    * Appends a String data element to this LinkedList.
    * 
    * @param data
    *            the data element to be appended.
    */
   public void add(Date212 d) {
      DateNode temp = new DateNode(d);
      this.last.next = temp;
      this.last = temp;
      this.length++;

   } // method append(Date212)
   
   public String toString() {
      String result = "";
      DateNode cur = this.first.next;
      while (cur != null) {
         result += cur.date.toString() + "\n";
         cur = cur.next;
      }
      return result;
   }
}
