import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   static UnsortedDateList unsorted = new UnsortedDateList();
   static SortedDateList sorted = new SortedDateList();
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( ); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

    private void openFile( ) {
       JFileChooser chooser;
       int          status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    private void readSource(File chosenFile) {
       String chosenFileName = chosenFile.getAbsolutePath();
       TextFileInput inFile = new TextFileInput(chosenFileName);
       jframe.setLayout(new GridLayout(1, 2));
       TextArea rawDates = new TextArea();
       TextArea sortedDates = new TextArea();
       jframe.getContentPane().add(rawDates);
       jframe.getContentPane().add(sortedDates);
       
       String line = inFile.readLine();
       /* read every line from the input file */
       while (line != null) {
          /* convert each line to tokens and record valid dates */
          StringTokenizer tokens = new StringTokenizer(line, ",");
          while (tokens.hasMoreTokens()) {
             String inStr = tokens.nextToken();
             if (validDate(inStr)) {
                Date212 date = new Date212(inStr);
                unsorted.add(date);
                sorted.add(date);
             }
          }
          line = inFile.readLine();
       }
       rawDates.append("Unsorted Dates: " + "\n");
       rawDates.append(unsorted.toString());
       sortedDates.append("Sorted Dates: " + "\n");
       sortedDates.append(sorted.toString());
     jframe.setVisible(true);
   }
   
    public static boolean validDate(String date) {
       if (date.length() == 8) {
          for (int i = 0; i < 8; i++) {
             if (!Character.isDigit(date.charAt(i))) {
                return false;
             }
          }
          int month = Integer.parseInt(date.substring(4, 6));
          if (month <= 0 || month > 12) {
             return false;
          }
          int day = Integer.parseInt(date.substring(6, 8));
          if (day <= 0 || day > 31) {
             return false;
          }
          return true;
       }
       return false;
    }    
}