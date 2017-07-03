public class DateNode {
   Date212 date;
   DateNode next;
   
   public DateNode(Date212 d) {
      this.date = d;
      this.next = null;
   }
   
   public String toString() {
      return this.date.toString();
   }
}
