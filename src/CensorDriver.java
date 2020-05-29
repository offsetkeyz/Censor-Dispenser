import java.io.IOException;

public class CensorDriver {

   public static void main(String[] args) {
      String[] keyWords = {"great", "month", "francine"};
      try {
         Censor firstCensor = new Censor("email_one.txt", keyWords);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}
