
/**
 * This will hold info about the box.
 * 
 * @Ryan Keeler 
 * @BoxIt
 */
public class Box
{
    //the amount of folds possible
    public final int FOLD_COUNT = 5;
    //an integer value assigned to each box type such as paper being 0
    private int myValue;
    //the amount of unfolded boxes I hold
    private int myAmountUnfolded;
    //the amount of each fold of this box that I have such as fold 2 has x amount...
    private int myAmount[];
    //fold sell bonus for all folds
    private double myMult[] = new double[FOLD_COUNT];
    //name of this box
    private String myName;
    //cost of box
    private double myCost;
    //sell price of box
    private double mySell;
    //amount it can change by
    private double myChange;
    /**
    * This is the constructor.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public Box(int value, String name, double cost, 
    double sell, double change, int amount, double mult2,
    double mult3, double mult4, double mult5)
    {
        myValue = value;
        myAmountUnfolded = amount;
        //to set all of myAmount to Zero
        myAmount = new int[FOLD_COUNT];
        for(int i = 0; i < FOLD_COUNT; i++)
        {
            myAmount[i] = 0;
        }//ends for
        myMult[0] = 1;
        myMult[1] = mult2;
        myMult[2] = mult3;
        myMult[3] = mult4;
        myMult[4] = mult5;
        myName = name;
        myCost = cost;
        mySell = sell;
        myChange = change;
    }//ends constructer
    
    /**
    * This will remove the stock up to the amount given.
    * @pre none
    * @pram the amount to be sold.
    * @return none
    * @post myAmount
    */
    public void sellStock(int amount)
    {
        //goes through and removes an amount from the stock starting at the lowest fold
        for(int i = 0; i < FOLD_COUNT; i++)
        {
            //checks to see if you can sell any of this type
            if(myAmount[i] > 0)
            {
                //if you have more than you are selling
                if(amount <= myAmount[i])
                {
                    //removes amount from stock
                    myAmount[i] -= amount;
                    //shows that there are no more to sell
                    amount = 0;
                }//ends if
                //if you will have left overs after selling
                else
                {
                    //removes the number sold from amount to keep track
                    amount -= myAmount[i];
                    //shows that all of this type were sold
                    myAmount[i] = 0;
                }//ends else
            }//ends if
        }//ends for
    }//ends clearStock
    
    /**
    * This will return mySell * myMult[i]
    * @pre none
    * @pram a value which represents which multiplier is being requested
    * @return mySell * myMult[i]
    * @post none
    */
    public double getSell(int i)
    {
        return mySell * myMult[i];
    }//ends getSell
    
    /**
    * This will return the amount the sold boxes are worth.
    * @pre none
    * @pram amount, randomizedPrice (the price that it is being sold at)
    * @return sellAmount
    * @post none
    */
    public double getAmountSell(int amount, double randomizedPrice)
    {
        double sellAmount = 0;
        int currentLeft = amount;
        //to multiply by the randomized price
        int amountSold = 0;
        //goes through and counts how much everything is worth
        for(int i = 0; i < FOLD_COUNT; i++)
        {
            //checks to see if you can sell any of this type
            if(myAmount[i] > 0)
            {
                //if you have more than you are selling
                if(currentLeft <= myAmount[i])
                {
                    //removes amount from stock
                    sellAmount += getSell(i) * currentLeft;
                    //adds amount sold
                    amountSold += currentLeft;
                    //shows that there are no more to sell
                    currentLeft = 0;
                }//ends if
                //if you will have left overs after selling
                else
                {
                    //removes the number sold from amount to keep track
                    currentLeft -= myAmount[i];
                    //adds amount sold
                    amountSold += myAmount[i];
                    //adds the price of the amount sold
                    sellAmount += mySell * myMult[i] * myAmount[i];
                }//ends else
            }//ends if
        }//ends for
        //calculates the total price when adding in randomized price
        sellAmount += randomizedPrice * amountSold;
        return sellAmount;
    }//ends getAmountSell
    
    /**
    * This will return myAmountUnfolded.
    * @pre none
    * @pram none
    * @return myAmountUnfolded
    * @post none
    */
    public int getAmount()
    {
        return myAmountUnfolded;
    }//ends getAmount
    
    /**
    * This will set myAmountUnfolded.
    * @pre none
    * @pram the amount of unfolded being set
    * @return none
    * @post myAmountUnfolded
    */
    public void setAmount(int amount)
    {
        myAmountUnfolded = amount;
    }//ends setAmount
    
    /**
    * This will return how many folded boxes there are.
    * @pre none
    * @pram none
    * @return myAmountFold total
    * @post none
    */
    public int getTotalFolded()
    {
        return myAmount[0] + myAmount[1] + myAmount[2] + myAmount[3] + myAmount[4];
    }//ends GetAmountFold
    
    /**
    * This will return how much everything is worth.
    * @pre none
    * @pram none
    * @return myAmountFold total * the sell price multiplier
    * @post none
    */
    public double getTotalSell()
    {
        return (myAmount[0] * getSell(0)) + (myAmount[1] * getSell(1)) + 
        (myAmount[2] * getSell(2)) + (myAmount[3] * getSell(3)) + 
        (myAmount[4] * getSell(4));
    }//ends GetAmountFold
    
    /**
    * This will return myAmount.
    * @pre none
    * @pram a value representing which amount is being requested
    * @return myAmountFold
    * @post none
    */
    public int getFold(int pick)
    {
        return myAmount[pick];
    }//ends GetAmountFold
    
    /**
    * This will set myAmountFold.
    * @pre none
    * @pram which fold is being picked, how many to fold
    * @return none
    * @post myAmountFold
    */
    public void setFold(int pick,int amount)
    {
        myAmount[pick] = amount;
    }//ends setAmountFold
    
    /**
    * This gets the value.
    * @pre none
    * @pram none
    * @return myValue
    * @post none
    */
    public int getValue()
    {
        return myValue;
    }//ends getValue
    
    /**
    * This gets the name.
    * @pre none
    * @pram none
    * @return myName
    * @post none
    */
    public String getName()
    {
        return myName;
    }//ends getName
    
    /**
    * This gets the cost.
    * @pre none
    * @pram none
    * @return myCost
    * @post none
    */
    public double getCost()
    {
        return myCost;
    }//ends getName
    
    /**
    * This will return a string.
    * @pre none
    * @pram none
    * @return string
    * @post none
    */
    @Override
    public String toString()
    {
        return myName + System.lineSeparator() + myAmountUnfolded + myAmount[0] + myAmount[1] + myAmount[2] + 
        myAmount[3] + myAmount[4] +System.lineSeparator() + myValue + System.lineSeparator() + myCost +
        System.lineSeparator() + mySell + System.lineSeparator() +myChange;
    }//ends toString
}//ends box
