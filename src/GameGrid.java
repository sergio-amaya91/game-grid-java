import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {

    public void run(){
        SecureRandom oRand = new SecureRandom();
        LinkedList oLinkedList= new LinkedList();
        int iPlayerMoves = 0;


        //difficulty setting
        int iWallChance = 10;

        //creating the game grid
        int [][] aiGrid = new int[10][10];

        for(int y = 0; y < aiGrid[0].length; y++){
            for(int x = 0; x< aiGrid.length; x++){
                int iChance = oRand.nextInt(100);
                if (iChance < iWallChance) {
                    aiGrid[x][y] = 1;
                }
                else{
                    aiGrid[x][y] = 0;
                }
            }
        }

        //starting the game
        aiGrid[0][0] = 0;
        int iUserRow = 0;
        int iUserCol = 0;
        Scanner scn = new Scanner(System.in);

        boolean exit = false;

        while(exit == false){
            //user prompt
            System.out.println("Which Direction to move?(Enter 1 or 2)");
            System.out.println("1. Down");
            System.out.println("2. Right");
            int iMovement = scn.nextInt();

            //movement mechanic
            if (iMovement == 1){
                iUserRow += 1;

            }else if(iMovement == 2) {
                iUserCol += 1;
            }else{
                System.out.println("Enter 1 or 2");}

            oLinkedList.addHeadNode(iUserCol, iUserRow);


            iPlayerMoves++;





            //lose condition
            if(aiGrid[iUserCol][iUserRow] == 1){
                System.out.println("You lose");
                exit = true;
                }

            //win condition
            if(iUserCol == 9 || iUserRow == 9){
                System.out.println("You Win!");
                exit = true;
            }


        }
        //Tracking player moves
        aiGrid[0][0] = 8;
        while(true){
            Node oNode = oLinkedList.getHeadNode();
            if (oNode == null){
                break;
            }
            aiGrid[oNode.xPosition][oNode.yPosition]=8;
            oLinkedList.removeHeadNode();

        }


        //set to unique value to player position
        aiGrid[iUserCol][iUserRow] = 3;

        //print the game grid and Player Position
        for(int y = 0; y < aiGrid[0].length; y++) {
            for (int x = 0; x < aiGrid.length; x++) {
                //look for unique position and Print X
                if(aiGrid[x][y] == 3)
                    System.out.print("X ");
                else
                    System.out.print(aiGrid[x][y]+ " ");


            }
            System.out.println();
        }
        System.out.println("Player moves: "+ iPlayerMoves);





    }
}
