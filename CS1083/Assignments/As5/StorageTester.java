/**
 *@author Paul Armstrong, 3537294
 **/

import java.util.Scanner;

public class StorageTester{
    private static char[][] cave;
    private static int size = 0;
    private static int xPosStart = 0;
    private static int yPosStart = 0;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimentions of the cave");
        int row = sc.nextInt();
        int column = sc.nextInt();

        cave = new char[row][column];
        create(cave);

        for(int i = 0; i < cave[0].length; i++){
            if(cave[0][i] == '0'){
                size++;
                xPosStart = i;
                cave[yPosStart][xPosStart] = '2';
                break;
            }
        }

        System.out.println("The area of the cavern is: " + area(yPosStart, xPosStart));
    }//end main.

    public static int area(int yPos, int txPos){
        if((xPos < (cave[yPos].length-1)) && (cave[yPos][xPos+1] == '0')){
            size++;
            cave[yPos][xPos+1] = '2';
            area(yPos, xPos+1);
        }
        if((xPos > 0) && (cave[yPos][xPos-1] == '0')){
            size++;
            cave[yPos][xPos-1] = '2';
            area(yPos, xPos-1);
        }
        if((yPos > 0) && (cave[yPos-1][xPos] == '0')){
            size++;
            cave[yPos-1][xPos] = '2';
            area(yPos-1, xPos);
        }
        if((yPos < (cave.length-1)) && (cave[yPos+1][xPos] == '0')){
            size++;
            cave[yPos+1][xPos] = '2';
            area(yPos+1, xPos);
        }

        return size;
    }//end area.

    public static void create(char[][] cave){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < cave.length; i++){
            String num = sc.nextLine();
            for(int x = 0; x < num.length(); x++){
                cave[i][x] = num.charAt(x);
            }
        }
    }
}//end class.