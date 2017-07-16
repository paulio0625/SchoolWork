public class BoardGame implements Comparable {
   private String title;
   private int maxPlayers;
   
   public BoardGame (String titleIn, int playersIn) {
      title = titleIn;
      maxPlayers = playersIn;
   }//end BoardGame.
   
   public String toString () {
      return title + " [max. " + maxPlayers + " players]";
   }//toString.

   public int compareTo(Object o){
      int result = 0;

      BoardGame other = (BoardGame) o;

      if (maxPlayers < other.maxPlayers){result = -1;}//end if.
      else if (maxPlayers > other.maxPlayers){result = 1;}//end else if.

      if(result == 0){
         if(title.charAt(0) < other.title.charAt(0)){result = -1;}//end if.
         else if(title.charAt(0) > other.title.charAt(0)){result = 1;}//end else if.
      }//end if.

      return result;
   }//end compareTo.
}//end class.