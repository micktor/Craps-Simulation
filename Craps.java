/**
 *
 * This program simulates the playing of craps
 * Author: Mark Mileyev
 *
 */
import java.util.*;
import java.io.*;

class Craps {
    
    public static void main(String[] args){
        //Initial prompt
        System.out.println("How many chips do you want?");
        
        Scanner input = new Scanner(System.in);
        
        int chips = input.nextInt();
        
        System.out.println("Enter bet.");
        
        int bet = input.nextInt();
        
        while(true){
            
            System.out.println("Hit return to roll the dice");
            
            Scanner ent = new Scanner(System.in);
            
            String enter;
            enter = ent.nextLine();
            
            if(enter.equals("")){
                Random rand = new Random();
                
                int dice1 = rand.nextInt(6) + 1;
                int dice2 = rand.nextInt(6) + 1;
                int rollTotal = dice1 + dice2;
                
                System.out.println("Roll is: " + dice1 +", "+ dice2);
                
                if(rollTotal == 7){
                    chips = chips + bet;
                    System.out.println("You won! You now have: "+ chips);
                    System.out.println("Enter bet.");
                    
                    bet = input.nextInt();
                    continue;
                }
                if(rollTotal == 11){
                    chips = chips + bet;
                    System.out.println("You won! You now have: "+ chips);
                    System.out.println("Enter bet.");
                    
                    bet = input.nextInt();
                    continue;
                }
                
                if(rollTotal == 2){
                    chips = chips - bet;
                    System.out.println("You lost! You now have: "+ chips);
                    //Checking for broke boys
                    if (chips == 0){
                        System.out.println("BUSTO!!!");
                        System.exit(0);
                    }
                    System.out.println("Enter bet.");
                    
                    bet = input.nextInt();
                    continue;
                }
                if(rollTotal == 3){
                    chips = chips - bet;
                    System.out.println("You lost! You now have: "+ chips);
                    if (chips == 0){
                        System.out.println("BUSTO!!!");
                        System.exit(0);
                    }
                    System.out.println("Enter bet.");
                    
                    bet = input.nextInt();
                    continue;
                }
                if(rollTotal == 12){
                    chips = chips - bet;
                    System.out.println("You lost! You now have: "+ chips);
                    if (chips == 0){
                        System.out.println("BUSTO!!!");
                        System.exit(0);
                    }
                    System.out.println("Enter bet.");
                    
                    bet = input.nextInt();
                    continue;
                }
                //If not an immediate win or loss
                if (rollTotal == 4 || rollTotal == 5 || rollTotal == 6 || rollTotal == 8 || rollTotal == 9 || rollTotal == 10){
                    int point = rollTotal;
                    System.out.println("The point is: "+ point);
                    while(true){
                        
                        System.out.println("Hit return to roll the dice");
                        String enter2;
                        enter2 = ent.nextLine();
                        
                        if(enter2.equals("")){
                            
                            dice1 = rand.nextInt(6) + 1;
                            dice2 = rand.nextInt(6) + 1;
                            rollTotal = dice1 + dice2;
                            
                            System.out.println("Roll is: " + dice1 +", "+ dice2);
                            
                            if(rollTotal==7){
                                chips = chips - bet;
                                System.out.println("You lost! You now have: "+ chips);
                                if (chips == 0){
                                    System.out.println("BUSTO!!!");
                                    System.exit(0);
                                }
                                System.out.println("Enter bet.");
                                
                                bet = input.nextInt();
                                break;
                            }
                            if(rollTotal==point){
                                chips = chips + bet;
                                System.out.println("You won! You now have: "+ chips);
                                System.out.println("Enter bet.");
                                
                                bet = input.nextInt();
                                break;
                            }
                        }
                    }
                }
                continue;
            }
        }
    }
}

