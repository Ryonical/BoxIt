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
    //prices
        //paper
    public final double PAPER_SELL = .1;//This is the base price of paper
    public final double PAPER_COST = .05;//This is the base cost of paper
    public final double PAPER_CHANGE = 0.05;//This is how much the paper value can change
        //cardboard
    public final double CARDBOARD_SELL = 1.25;//This is the base price of cardboard
    public final double CARDBOARD_COST = 1;//This is the base cost of cardboard
    public final double CARDBOARD_CHANGE = .2;//This is how much the cardboard value can change
        //plastic
    public final double PLASTIC_SELL = 5;//This is the base price of plastic
    public final double PLASTIC_COST = 3;//This is the base cost of plastic
    public final double PLASTIC_CHANGE = 0.25;//This is how much the plastic value can change
        //steel
    public final double STEEL_SELL = 10;//This is the base price of steel
    public final double STEEL_COST = 6;//This is the base cost of steel
    public final double STEEL_CHANGE = 2.5;//This is how much the steel value can change
        //sabeza
    public final double SANEZA_SELL = 7.5;//This is the base price of saneza
    public final double SANEZA_COST = 4.5;//This is the base cost of saneza
    public final double SANEZA_CHANGE = 1.75;//This is how much the saneza value can change
        //thorby
    public final double THORBY_SELL = 20;//This is the base price of thorby
    public final double THORBY_COST = 30;//This is the base cost of thorby
    public final double THORBY_CHANGE = 15;//This is how much the thorby value can change
        //plarbin
    public final double PLARBIN_SELL = 30;//This is the base price of plarbin
    public final double PLARBIN_COST = 15;//This is the base cost of plarbin
    public final double PLARBIN_CHANGE = 5.0;//This is how much the plarbin value can change
    //keeps track of how many boxes there are
    public final int BOX_NUM = 7;
    //research finals
    public final double RESEARCH_INCREASE = 1.5;
    //final answers
    public final String YES = "y";
    public final String BOX_BUILD = "build a box";
    public final String SAVE = "save";
    public final String EXIT = "exit";
    
    //gives random chance
    public final double FIFTY_FIFTY = .5;
    //what you have in stock
    public ArrayList <Box> myStock;
    //money
    private double myMola;//This is how much mola you have
    //is the int value of the box type
    private int myType;
    //this is research related
    private double myResearchCost;
    private int myMaxBuy;
    private double myResearchTypeCost;
    private int myTypeBuy;
    //random prices
    private ArrayList<Double> myRandom;
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
        myMola = 0.50;
        myType = 0;
        myResearchCost = 5.0;
        myMaxBuy = 10;
        myResearchTypeCost = 15;
        myTypeBuy = 0;
        myRandom = new ArrayList<Double>();
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
                    //         System.out.println("What is your name");
                    //         myName = in.nextLine();
                    //         System.out.println("Are you sure that " + myName + " will be your name y/n");
                    //         myAnswer = in.nextLine();
                    //         while(!myAnswer.equals(YES))
                    //         {
                    //             System.out.println("Ok name yourself again");
                    //             myName = in.nextLine();
                    //             System.out.println("Are you sure that " + myName + " will be your name y/n");
                    //             myAnswer = in.nextLine();
                    //         }//ends while
                    //         
                    //         
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
        if(i > myMaxBuy)
        {
            i = myMaxBuy;
        }//ends if
        if(myMola >= myStock.get(myType).getCost() * i && myType != BOX_NUM + 1)
        {
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + i);
            myMola -= myStock.get(myType).getCost() * i;
        }//ends if
        else if (myType != BOX_NUM + 1)
        {
            i = (int)(myMola / myStock.get(myType).getCost());
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + i);
            myMola -= myStock.get(myType).getCost() * i;
        }//ends else if
        round();
        randomizePrices();
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
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() - i);
            myMola += (myStock.get(myType).getSell() + myRandom.get(myType)) * i;
        }//ends if
        else if (myType != BOX_NUM + 1)
        {
            i = myStock.get(myType).getAmount();
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() - i);
            myMola += (myStock.get(myType).getSell() + myRandom.get(myType)) * i;
        }//ends else if
        round();
        randomizePrices();
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
    * This randomizes the prices.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void randomizePrices()
    {
        //this randomizes prices and rounds them
        myRandom.set(0, Math.random() * PAPER_CHANGE);
        myRandom.set(1, Math.random() * CARDBOARD_CHANGE);
        myRandom.set(2, Math.random() * PLASTIC_CHANGE);
        myRandom.set(3, Math.random() * STEEL_CHANGE);
        myRandom.set(4, Math.random() * SANEZA_CHANGE);
        myRandom.set(5, Math.random() * THORBY_CHANGE);
        myRandom.set(6, Math.random() * PLARBIN_CHANGE);
        //this desides if it is positive or negative
        for(int i = 0; i < BOX_NUM; i++)
        {
            
            if(Math.random() < FIFTY_FIFTY)
            {
                myRandom.set(i, -myRandom.get(i));
            }//ends if
            myRandom.set(i, Math.round(myRandom.get(i) * 100) / 100.0);
        }//ends for
    }//ends randomizePrices
    
    /**
    * This allowes you to buy more boxes at a time.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void research()
    {
        if(myMola >= myResearchCost)
        {
            myMaxBuy++;
            myMola -= myResearchCost;
            myResearchCost *= RESEARCH_INCREASE;
            myResearchCost = Math.round(myResearchCost * 1000) / 1000;
            round();
        }//ends if
    }//ends research
    
    /**
    * This allowes you to buy more boxe types.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void researchType()
    {
        if(myMola >= myResearchTypeCost && myTypeBuy < BOX_NUM)
        {
            myTypeBuy++;
            myMola -= myResearchTypeCost;
            myResearchTypeCost *= RESEARCH_INCREASE;
            myResearchTypeCost = Math.round(myResearchTypeCost * 100) / 100;
            round();
        }//ends if
    }//ends research
    
    /**
    * This creates the boxes at the begginging of the game.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void createBoxes()
    {
        //this constructs the boxes
        myStock.add(new Box(0, "paper", PAPER_COST, PAPER_SELL, PAPER_CHANGE));
        myStock.add(new Box(1, "cardboard", CARDBOARD_COST, CARDBOARD_SELL, CARDBOARD_CHANGE));
        myStock.add(new Box(2, "plastic", PLASTIC_COST, PLASTIC_SELL, PLASTIC_CHANGE));
        myStock.add(new Box(3, "steel", STEEL_COST, STEEL_SELL, STEEL_CHANGE));
        myStock.add(new Box(4, "saneza", SANEZA_COST, SANEZA_SELL, SANEZA_CHANGE));
        myStock.add(new Box(5, "thorby", THORBY_COST, THORBY_SELL, THORBY_CHANGE));
        myStock.add(new Box(6, "plarbin", PLARBIN_COST, PLARBIN_SELL, PLARBIN_CHANGE));
        //this adds box_num null places to myRandom so it will have the spaces
        for(int i = 0; i < BOX_NUM; i++)
        {
            myRandom.add(null);
        }//ends fort
    }//ends createBoxes
    
    /**
    * This gets myMola.
    * @pre none
    * @pram none
    * @return myMola
    * @post none
    */
    public double getMola()
    {
        return myMola;
    }//ends getMola
    
    /**
    * This sets myMola.
    * @pre none
    * @pram none
    * @return none
    * @post myMola
    */
    public void setMola(double mola)
    {
        myMola = mola;
    }//ends getMola
    
    /**
    * This gets myStock 0 amount.
    * @pre none
    * @pram none
    * @return a part of my stock
    * @post none
    */
    public Box getPaper()
    {
        return myStock.get(0);
    }//ends getMola
    
    /**
    * This sets myStock 0 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of my stock
    */
    public void setPaper(Box stock)
    {
        myStock.get(0);
    }//ends getMola
    
    /**
    * This sets myType.
    * @pre none
    * @pram none
    * @return none
    * @post myType
    */
    public void setType(int type)
    {
        if(type <= myTypeBuy)
        {
            myType = type;
        }//ends if
    }//ends setType
    
    /**
    * This gets myRandom0.
    * @pre none
    * @pram none
    * @return myRandom0
    * @post none
    */
    public String getRandom0()
    {
        return myStock.get(0).getName() + " sells for "  + (Math.round((myStock.get(0).getSell() + myRandom.get(0)) * 100)/ 100.0);
    }//ends getRandom0
    
    /**
    * This gets myRandom1.
    * @pre none
    * @pram none
    * @return myRandom1
    * @post none
    */
    public String getRandom1()
    {
        return myStock.get(1).getName() + " sells for "  + (Math.round((myStock.get(1).getSell() + myRandom.get(1)) * 100)/ 100.0);
    }//ends getRandom1
    
    /**
    * This gets myRandom2.
    * @pre none
    * @pram none
    * @return myRandom2
    * @post none
    */
    public String getRandom2()
    {
        return myStock.get(2).getName() + " sells for "  + (Math.round((myStock.get(2).getSell() + myRandom.get(2)) * 100)/ 100.0);
    }//ends getRandom2
    
    /**
    * This gets myRandom3.
    * @pre none
    * @pram none
    * @return myRandom3
    * @post none
    */
    public String getRandom3()
    {
        return myStock.get(3).getName() + " sells for "  + (Math.round((myStock.get(3).getSell() + myRandom.get(3)) * 100)/ 100.0);
    }//ends getRandom3
    
    /**
    * This gets myRandom4.
    * @pre none
    * @pram none
    * @return myRandom4
    * @post none
    */
    public String getRandom4()
    {
        return myStock.get(4).getName() + " sells for "  + (Math.round((myStock.get(4).getSell() + myRandom.get(4)) * 100)/ 100.0);
    }//ends getRandom4
    
    /**
    * This gets myRandom5.
    * @pre none
    * @pram none
    * @return myRandom5
    * @post none
    */
    public String getRandom5()
    {
        return myStock.get(5).getName() + " sells for "  + (Math.round((myStock.get(5).getSell() + myRandom.get(5)) * 100)/ 100.0);
    }//ends getRandom5
    
    /**
    * This gets myRandom6.
    * @pre none
    * @pram none
    * @return myRandom6
    * @post none
    */
    public String getRandom6()
    {
        return myStock.get(6).getName() + " sells for "  + (Math.round((myStock.get(6).getSell() + myRandom.get(6)) * 100)/ 100.0);
    }//ends getRandom6
    
    /**
    * This gets myResearchCost.
    * @pre none
    * @pram none
    * @return myResearchCost
    * @post none
    */
    public double getResearchCost()
    {
        return myResearchCost;
    }//ends getResearchCost
    
    /**
    * This gets myResearchTypeCost.
    * @pre none
    * @pram none
    * @return myResearchTypeCost
    * @post none
    */
    public double getResearchTypeCost()
    {
        return myResearchTypeCost;
    }//ends getResearchTypeCost
    
    /**
    * This gets myTypeBuy.
    * @pre none
    * @pram none
    * @return myTypeBuy
    * @post none
    */
    public int getTypeBuy()
    {
        return myTypeBuy;
    }//ends myTypeBuy
    
    /**
    * This gets myMaxBuy.
    * @pre none
    * @pram none
    * @return myMaxBuy
    * @post none
    */
    public int getMaxBuy()
    {
        return myMaxBuy;
    }//ends myMaxBuy
    
    /**
    * This sets myMaxBuy.
    * @pre none
    * @pram none
    * @return none
    * @post myMaxBuy
    */
    public void setMaxBuy(int buy)
    {
        myMaxBuy = buy;
    }//ends myMaxBuy
}//ends BoxIt