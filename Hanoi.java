import java.util.Scanner;
public class Hanoi{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("How many floors do you want?");
        int floors = scan.nextInt();

        if (floors < 3){
            floors = 3;
            System.out.println("The minimum value is 3!");
        }
        
        int[] col1 = new int[floors];
        int[] col2 = new int[floors];
        int[] col3 = new int[floors];
        boolean win = false;

        // Fill first tower
        for(int i =floors-1,v=1; i>=0; i--,v++){
            col1[i] = v;
        }
        do{
            // Print towers
            for(int i=floors-1; i>=0;i--){
                System.out.print(col1[i]);
                System.out.print(col2[i]);
                System.out.print(col3[i]);
                System.out.println();
            }

            //Move statemant
            System.out.print("Move from: ");
            int from = scan.nextInt();
            System.out.print("Move to: ");
            int to = scan.nextInt();

            if(from == to || from > floors || to > floors){
                continue;
            }

            int moveValue = 0;
            int fromIndex = 0;
            int[] fromCol = new int[floors];
            int[] targetCol =  new int[floors];
            //Get floor
            switch(from){
                case 1:
                    fromCol = col1;
                    break;                        
                case 2:
                    fromCol = col2;
                    break;
                case 3:
                    fromCol = col3;
                    break;
            }
            for(int i=floors-1; i>=0; i--){
                if(fromCol[i] != 0){
                    moveValue = fromCol[i];
                }
                if(moveValue != 0){
                    fromIndex = i;
                    break;
                }
            }

            //Try put
            switch(to){
                case 1:
                    targetCol = col1;
                    break;                        
                case 2:
                    targetCol = col2;
                    break;
                case 3:
                    targetCol = col3;
                    break;
            }

            //search empty place
            for(int i=0;i<floors;i++){
                if(targetCol[i] == 0){
                    if(i== 0 || (i>0 && targetCol[i-1] > moveValue)){
                        targetCol[i] = moveValue;
                        fromCol[fromIndex] = 0;
                    }
                }
            }

            //win check
            int count2 = 0;
            int count3 = 0;
            for(int i=0;i<floors;i++){
                if(col2[i] != 0){
                    count2++;
                }
            }
            

            for(int i=0;i<floors;i++){
                if(col3[i] != 0){
                    count3++;
                }
            }
    

            if(count2 == floors || count3 == floors){
                win = true;
            }else{
                count2=0;
                count3=0;
            }


        }while(!win);


        // Print towers
        for(int j=floors-1; j>=0;j--){
            System.out.print(col1[j]);
            System.out.print(col2[j]);
            System.out.print(col3[j]);
            System.out.println();
        }
        System.out.println("You win!");


    }
}
