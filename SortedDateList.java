
public class SortedDateList extends DateList {
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
   
   public void add(Date212 d) {
      DateNode temp = new DateNode(d);
      DateNode pre = this.first;
      while (pre.next != null && pre.next.date.compareTo(d) < 0) {
         pre = pre.next;
      }
      temp.next = pre.next;
      pre.next = temp;
      this.length++;

   } // method add(Date212)
   
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
