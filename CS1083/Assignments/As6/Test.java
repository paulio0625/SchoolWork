public class Test{
    public static void main(String[] args){
        BoardGame chess = new BoardGame("Chess", 2);
        BoardGame monopoly = new BoardGame("Monopoly", 8);
        BoardGame scrabble = new BoardGame("Scrabble", 4);
        BoardGame risk = new BoardGame("Risk", 6);
        BoardGame clue = new BoardGame("Clue", 6);
        BoardGame snakes = new BoardGame("Snakes and Ladders", 3);
        BoardGame battleship = new BoardGame("Battleship", 2);
        BoardGame jenga = new BoardGame("Jenga", 5);

        BoardGameList list = new BoardGameList();

        list.add(monopoly);
        list.add(chess);
        list.add(scrabble);
        list.add(risk);
        list.add(clue);

        BoardGame[] arr = list.getListAsArray();

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }//end for.

        System.out.println();

        list.remove(chess);
        list.remove(risk);
        list.remove(monopoly);

        arr = list.getListAsArray();

        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }//end for.

        System.out.println();

        list.add(snakes);
        list.add(jenga);
        list.add(battleship);

        arr = list.getListAsArray();

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }//end for.

        System.out.println();

        arr = list.getReversedListAsArray();

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }//end for.

        System.out.println();

        try {
            list.remove(risk);
        }//end try.
        catch (java.util.NoSuchElementException e){
            System.err.println(e.getMessage());
        }//end catch.

        System.out.println();

        System.out.println(list.getNumGames());
    }//end main
}//end class