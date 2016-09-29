import java.util.*;
import java.text.DecimalFormat;
import java.math.*;
/**
 * This is the bulk of BoxIt.
 * 
 * @Ryan Keeler
 * @BoxIt
 */
public class BoxIt
{
    //input
    Scanner in = new Scanner(System.in);
    //prices
        //paper
    public final double PAPER_SELL = .2;//This is the base price of paper
    public final double PAPER_COST = .05;//This is the base cost of paper
    public final double PAPER_CHANGE = .05;//This is how much the paper value can change
        //cardboard
    public final double CARDBOARD_SELL = 3;//This is the base price of cardboard
    public final double CARDBOARD_COST = 1;//This is the base cost of cardboard
    public final double CARDBOARD_CHANGE = .2;//This is how much the cardboard value can change
        //plastic
    public final double PLASTIC_SELL = 10;//This is the base price of plastic
    public final double PLASTIC_COST = 3;//This is the base cost of plastic
    public final double PLASTIC_CHANGE = 0.25;//This is how much the plastic value can change
        //steel
    public final double STEEL_SELL = 20;//This is the base price of steel
    public final double STEEL_COST = 6;//This is the base cost of steel
    public final double STEEL_CHANGE = 2.5;//This is how much the steel value can change
        //sabeza
    public final double SANEZA_SELL = 15;//This is the base price of saneza
    public final double SANEZA_COST = 4.5;//This is the base cost of saneza
    public final double SANEZA_CHANGE = 1.75;//This is how much the saneza value can change
        //thorby
    public final double THORBY_SELL = 3;//This is the base price of thorby
    public final double THORBY_COST = 30;//This is the base cost of thorby
    public final double THORBY_CHANGE = 0.0;//This is how much the thorby value can change
        //plarbin
    public final double PLARBIN_SELL = 50;//This is the base price of plarbin
    public final double PLARBIN_COST = 15;//This is the base cost of plarbin
    public final double PLARBIN_CHANGE = 7.5;//This is how much the plarbin value can change
    //keeps track of how many boxes there are
    public final int BOX_NUM = 7;
    
    //final answers
    public final String YES = "y";
    public final String BOX_BUILD = "build a box";
    public final String SAVE = "save";
    public final String EXIT = "exit";
    
    //what you have in stock
    public ArrayList <Box> myStock;
    //money
    private double myMola;//This is how much mola you have
    //player name
    private String myName;
    //company name
    private String myCompName;
    //is the int value of the box type
    private int myType;
    //input
    private String myAnswer;
    //int input
    private int myIntAnswer;
    /**
    * This constructs.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public BoxIt()
    {
        myStock = new ArrayList<Box>();
        createBoxes();
        myMola = 10;
        myName = " ";
        myCompName = " ";
        myType = 0;
        myAnswer = " ";
        myIntAnswer = 0;
    }//ends constructer
    
    /**
    * This is the main game.
    * @pre none
    * @pram none
    * @return none
    * @post most
    */
    public void game()
    {
        createBoxes();
        System.out.println("What is your name");
        myName = in.nextLine();
        System.out.println("Are you sure that " + myName + " will be your name y/n");
        myAnswer = in.nextLine();
        while(!myAnswer.equals(YES))
        {
            System.out.println("Ok name yourself again");
            myName = in.nextLine();
            System.out.println("Are you sure that " + myName + " will be your name y/n");
            myAnswer = in.nextLine();
        }//ends while
        
        
                    //         System.out.println("sucsess, " + myName);
                    //         System.out.println("You have 1\" of paper what do you want do do with it?");
                    //         System.out.println("build a box, make a paper airplane, start a paper football company");
                    //         myAnswer = in.nextLine();
                    //         while(!myAnswer.equals(BOX_BUILD))
                    //         {
                    //             System.out.println("YOU WILL FAIL NOOB DO SOMETHING ELSE!");
                    //             myAnswer = in.nextLine();
                    //         }//ends while
                    //         System.out.println("Good Choice");
                    //         System.out.println("You go to sell it and you find a person who needs it so badly.\n" + 
                    //         "They offer to pay you 10 moola and you accept.\nYou probaly will never be so lucky again.\n" +
                    //         "You now have started your company what would you like to call it?");
                            
                    //         myCompName = in.nextLine();
                    //         System.out.println("Are you sure that " + myCompName + " will be your company name y/n");
                    //         myAnswer = in.nextLine();
                    //         while(!myAnswer.equals(YES))
                    //         {
                    //             System.out.println("Ok name your company again");
                    //             myCompName = in.nextLine();
                    //             System.out.println("Are you sure that " + myCompName + " will be your company name y/n");
                    //             myAnswer = in.nextLine();
                    //       }//ends while
        
        while(true)
        {
            System.out.println("What would you like to buy?");
            myAnswer = in.next();
            word(myAnswer);
            System.out.println("How many?");
            try
            {
                myIntAnswer = in.nextInt();
            }//try
            catch(Exception e)
            {
                myIntAnswer = 0;
            }//catch
            for(int i = 0; i < myIntAnswer; i++)
            {
                if(myType != BOX_NUM + 1)
                {
                    buy();
                }//ends if
            }//ends for
            output();
            System.out.println("Would you like to sell?");
            myAnswer = in.next();
            word(myAnswer);
            System.out.println("How Many");
            try
            {
                myIntAnswer = in.nextInt();
            }//try
            catch(Exception e)
            {
                myIntAnswer = 0;
            }//catch
            sell(myIntAnswer);
            output();
        }//ends while
        
    }//ends game
    
    
    /**
    * This buys.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void buy(int i)
    {
        if()
        {
            
        }//ends if 
        if(myType != BOX_NUM + 1 && myMola >= myStock.get(myType).getCost())
        {
            myMola -= myStock.get(myType).getCost();
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + 1);
        }//ends if
        round();
    }//ends buy
    
    /**
    * This will sell the boxes.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void sell(int i)
    {
        if(i <= myStock.get(myType).getAmount() && myType != BOX_NUM + 1)
        {
            myStock.get(myType).setAmount(0);
            myMola = myStock.get(myType).getSell() * i;
        }//ends if
        else if (myType != BOX_NUM + 1)
        {
            i = myStock.get(myType).getAmount();
            myStock.get(myType).setAmount(0);
            myMola = myStock.get(myType).getSell() * 1;
        }//ends else if
        
    }//ends sell
    
    /**
    * This will round myMola.
    * @pre none
    * @pram none
    * @return none
    * @post myMola
    */
    public void round()
    {
        myMola = (double)Math.round(myMola * 10000) / 10000;
    }//ends round
    
    /**
    * This checks to see if this is a recognized word.
    * @pre none
    * @pram word
    * @return none
    * @post none
    */
    public void word(String word)
    {
        boolean found = false;
        for(int i = 0; i < BOX_NUM; i++)
        {
            if(myStock.get(i).getName().equals(word))
            {
                myType = i;
                found = true;
            }//ends if
            else if(!found)
            {
                myType = BOX_NUM + 1;
            }//ends else if
        }//ends for
    }//ends word
   
    /**
    * This outputs.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void output()
    {
        for(int i = 0; i < BOX_NUM; i++)
        {
            System.out.println("You have " + myStock.get(i).getAmount() + " " + myStock.get(i).getName());
        }//ends for
        System.out.println("You have " + myMola + " mola");
    }
    
    /**
    * This creates the boxes at the begginging of the game.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void createBoxes()
    {
        myStock.add(new Box(0, "paper", PAPER_COST, PAPER_SELL, PAPER_CHANGE));
        myStock.add(new Box(1, "cardboard", CARDBOARD_COST, CARDBOARD_SELL, CARDBOARD_CHANGE));
        myStock.add(new Box(2, "plastic", PLASTIC_COST, PLASTIC_SELL, PLASTIC_CHANGE));
        myStock.add(new Box(3, "steel", STEEL_COST, STEEL_SELL, STEEL_CHANGE));
        myStock.add(new Box(4, "saneza", SANEZA_COST, SANEZA_SELL, SANEZA_CHANGE));
        myStock.add(new Box(5, "thorby", THORBY_COST, THORBY_SELL, THORBY_CHANGE));
        myStock.add(new Box(6, "plarbin", PLARBIN_COST, PLARBIN_SELL, PLARBIN_CHANGE));
    }//ends createBoxes
}//ends BoxIt