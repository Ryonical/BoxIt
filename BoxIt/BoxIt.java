import java.util.*;
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
    * This construct.
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
//         }//ends while
        
        while(myMola > 0)
        {
            System.out.println("What would you like to buy?");
            myAnswer = in.nextLine();
            word(myAnswer);
            System.out.println("How many?");
            myIntAnswer = in.nextInt();
            for(int i = 0; i < myIntAnswer; i++)
            {
                if(myType != BOX_NUM + 1)
                {
                    buy(myAnswer);
                }//ends if
            }
            for(int i = 0; i < BOX_NUM; i++)
            {
                System.out.println("You have " + myStock.get(i).getAmount() + " " + myStock.get(i).getName());
            }//ends for
            System.out.println("You have " + myMola + " mola");
        }//ends while
        
    }//ends game
    
    
    /**
    * This construct.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void buy(String word)
    {
        if(myType != BOX_NUM + 1)
        {
            if(word.equals(myStock.get(0).getName()) && myMola >= PAPER_COST)
            {
                myMola -= PAPER_COST;
                myStock.get(0).setAmount(myStock.get(0).getAmount() + 1);
            }//ends if
            
            if(word.equals(myStock.get(1).getName()) && myMola >= CARDBOARD_COST)
            {
                myMola -= CARDBOARD_COST;
                myStock.get(1).setAmount(myStock.get(1).getAmount() + 1);
            }//ends if
        }//ends if
    }//ends buy
    
    
    /**
    * This construct.
    * @pre none
    * @pram none
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
    * This construct.
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
    }
}//ends BoxIt