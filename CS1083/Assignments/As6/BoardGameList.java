/**
 This class represents a doubly linked list of board games;
 NOTE: You may NOT use the java.util.LinkedList class.
 @author 
**/
public class BoardGameList {
   /**
    The first node in the list.
   **/
   private GameNode firstNode;

   /**
    The last node in the list.
   **/
   private GameNode lastNode;

   /**
    The number of games in the list.
   **/
   private int numGames;

   /**
    Creates an empty list.
   **/
   public BoardGameList() {
      firstNode = new GameNode(null);
      lastNode = new GameNode(null);
      numGames = 0;
   }//end BoardGameList

   /**
    Adds a new node representing the specified board game at
    the appropriate position in the list; proper ordering of the
    board games must be maintained (i.e. they must always be 
    sorted in ascending order).
    @param gameIn The board game to be included in the new node.
   **/
   public void add(BoardGame gameIn) {
      GameNode node = new GameNode(gameIn);

      if(numGames == 0){
         firstNode = node;
         lastNode = node;
         numGames++;
      }//end if.
      else{
         if (lastNode.game.compareTo(gameIn) == -1){
            lastNode.next = node;
            node.previous = lastNode;
            lastNode = node;
            numGames++;
         }//end if.
         else if(firstNode.game.compareTo(gameIn) == 1){
            firstNode.previous = node;
            node.next = firstNode;
            firstNode = node;
            numGames++;
         }//end else if.
         else{
            int pos = 1;
            GameNode current = firstNode.next;

            while(pos < numGames){
               if (node.game.compareTo(current.game) == -1) {
                  node.next = current;
                  node.previous = current.previous;
                  current.previous.next = node;
                  current.previous = node;
                  numGames++;
                  break;
               }//end if.

               pos++;
               current = current.next;
            }//end while.
         }//end else.
      }//end else
   }//end add.

   /**
    Remove from this list a node containing the specified board game.
    @param gameIn The game to be removed.
    @throws ???(you decide on the Exception) if not found.
   **/
   public void remove(BoardGame gameIn) {
      if (firstNode==null) {
         throw new java.util.NoSuchElementException("The game: " + gameIn.toString() + " does not exist.");
      }//end if.
      else {
         int pos = 0;
         GameNode current = firstNode;

         while(pos != numGames){
            if (current.game.compareTo(gameIn) == 0){
               if (current.previous == null){
                  firstNode = firstNode.next;
                  numGames--;
                  break;
               }//end if.
               else if (current.next == null){
                  lastNode = lastNode.previous;
                  numGames--;
                  break;
               }//end else if.
               else {
                  current.next.previous = current.previous;
                  current.previous.next = current.next;
                  numGames--;
                  break;
               }//end else.
            }//end if.
            pos++;
            current = current.next;

            if(pos == numGames){
               pos = -1;
               break;
            }//end if
         }//end while.
         if (pos == -1){
            throw new java.util.NoSuchElementException("The game: " + gameIn + " does not exist.");
         }//end if.
      }//end else.
   }//end remove.

   /**
    Returns the number of games currently stored in the list.
    @return the number of games
   **/
   public int getNumGames() {
      return  numGames;
   }//end getNumGames
   
   /**
    Creates and returns an array containing all of the BoardGames 
    in this list, in ascending order.
    @return the list as an array
   **/
   public BoardGame[] getListAsArray() {
      int pos = 0;
      GameNode current = firstNode;

      BoardGame[] arr = new BoardGame[numGames];
      while (pos < numGames){
         arr[pos] = current.game;
         current = current.next;
         pos++;
      }//end while.

      return arr;
   }//end getListAsArray
   
   /**
    Creates and returns an array containing all of the BoardGames 
    in this list, in descending order.
    @return the list (in reverse order) as an array
   **/
   public BoardGame[] getReversedListAsArray() {
      int pos = numGames-1;
      GameNode current = firstNode;

      BoardGame[] arr = new BoardGame[numGames];
      while (0 <= pos){
         arr[pos] = current.game;
         current = current.next;
         pos--;
      }//end while.

      return arr;
   }//end getReversedListAsArray.

   /**
    An inner class that represents a node in the board game list;
    the public variables are accessed by the BoardGameList class.
   **/
   private class GameNode {
      /**
       The BoardGame referenced by this node.
      **/
      public BoardGame game;

      /**
       The next node in the list.
      **/
      public GameNode next;

      /**
       The previous node in the list.
      **/
      public GameNode previous;

      /**
       Creates a node.
       @param gameIn The board game to be represented by this node.
      **/
      public GameNode (BoardGame gameIn) {
         game = gameIn;
         next = null;
         previous = null;
      }//end GameNode
      
   }//end GameNode class
}//end class
