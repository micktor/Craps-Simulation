/**
 *
 * This program simulates the playing of craps and calculates the probability of winning
 * Author: Mark Mileyev
 *
 */
import java.util.*;
import java.io.*;

class SimCraps {
    public static void main(String[] args){
        //Convert arg to an Int
        int testes=Integer.parseInt(args[0]);
        
        Random rand = new Random();
        
        int wins = 0;
        int losses = 0;
        //Run however many times arg
        for (int i=0;i<testes;i++){
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            int rollTotal = dice1 + dice2;
            
            if(rollTotal == 7){
                wins++;
            }
            if(rollTotal == 11){
                wins++;
            }
            
            if(rollTotal == 2){
                losses++;
            }
            if(rollTotal == 3){
                losses++;
            }
            if(rollTotal == 12){
                losses++;
            }
            //If not an immediate win or loss
            if (rollTotal == 4 || rollTotal == 5 || rollTotal == 6 || rollTotal == 8 || rollTotal == 9 || rollTotal == 10){
                int point = rollTotal;
                while(true){
                    dice1 = rand.nextInt(6) + 1;
                    dice2 = rand.nextInt(6) + 1;
                    rollTotal = dice1 + dice2;
                    if(rollTotal==7){
                        losses++;
                        break;
                    }
                    if(rollTotal==point){
                        wins++;
                        break;
                    }
                }
            }
        }
        //Output the probability of winning
        System.out.println((float)wins / testes);
        
}
}