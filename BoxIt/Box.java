
/**
 * This will hold info about the box.
 * 
 * @Ryan Keeler 
 * @BoxIt
 */
public class Box
{
    public final int FOLD_COUNT = 5;
    private int myValue;
    private int myAmountUnfolded;
    private int myAmount[];
    private double myMult2;
    private double myMult3;
    private double myMult4;
    private double myMult5;
    private String myName;
    private double myCost;
    private double mySell;
    private double myChange;
    /**
    * This construct.
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
        myMult2 = mult2;
        myMult3 = mult3;
        myMult4 = mult4;
        myMult5 = mult5;
        myName = name;
        myCost = cost;
        mySell = sell;
        myChange = change;
    }//ends constructer
    
    /**
    * This will clear the stock.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void clearStock()
    {
        for(int i = 0; i < FOLD_COUNT; i++)
        {
            myAmount[i] = 0;
        }//ends for
    }//ends clearStock
    
    /**
    * This will return mySell.
    * @pre none
    * @pram none
    * @return mySell
    * @post none
    */
    public double getSell(int i)
    {
        if(i == 1)
        {
            return mySell;
        }//ends if
        else if(i == 2)
        {
            return mySell * myMult2;
        }//ends else if
        else if(i == 3)
        {
            return mySell * myMult3;
        }//ends else if
        else if(i == 4)
        {
            return mySell * myMult4;
        }//ends else if
        else if(i == 5)
        {
            return mySell * myMult5;
        }//ends else if
        return -1;
    }//ends getSell
    
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
    * @pram none
    * @return none
    * @post myAmountUnfolded
    */
    public void setAmount(int amount)
    {
        myAmountUnfolded = amount;
    }//ends setAmount
    
    /**
    * This will return myAmountFold.
    * @pre none
    * @pram none
    * @return myAmountFold
    * @post none
    */
    public int getTotalFolded()
    {
        return myAmount[0] + myAmount[1] + myAmount[2] + myAmount[3] + myAmount[4];
    }//ends GetAmountFold
    
    /**
    * This will return myAmountFold.
    * @pre none
    * @pram none
    * @return myAmountFold
    * @post none
    */
    public double getTotalSell()
    {
        return (myAmount[0] * mySell) + (myAmount[1] * mySell * myMult2) + 
        (myAmount[2] * mySell * myMult3) + (myAmount[3] * mySell * myMult4) + 
        (myAmount[4] * mySell * myMult5);
    }//ends GetAmountFold
    
    /**
    * This will return myAmountFold.
    * @pre none
    * @pram none
    * @return myAmountFold
    * @post none
    */
    public int getFold(int pick)
    {
        return myAmount[pick-1];
    }//ends GetAmountFold
    
    /**
    * This will set myAmountFold.
    * @pre none
    * @pram none
    * @return none
    * @post myAmountFold
    */
    public void setFold(int pick,int amount)
    {
        myAmount[pick-1] = amount;
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
