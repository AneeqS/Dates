public class Date212 implements Comparable<Date212> {
   private int year;
   private int month;
   private int day;

   public Date212(int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
   }

   public Date212(String date) {
      this.year = Integer.parseInt(date.substring(0, 4));
      this.month = Integer.parseInt(date.substring(4, 6));
      this.day = Integer.parseInt(date.substring(6, 8));
   }

   @Override
   public int compareTo(Date212 other) {
      if (this.year < other.year) {
         return -1;
      } else if (this.year > other.year) {
         return 1;
      }
      if (this.month < other.month) {
         return -1;
      } else if (this.month > other.month) {
         return 1;
      }
      if (this.day < other.day) {
         return -1;
      } else if (this.day > other.day) {
         return 1;
      }
      return 0;
   }

   public String toString() {
      String result = "";
      result += this.month < 10 ? "0" + this.month : this.month;
      result += "/" + (this.day < 10 ? "0" + this.day : this.day);
      result += "/" + this.year;
      return result;
   }
}
