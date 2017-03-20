
/**
 * This will hold info about the box.
 * 
 * @Ryan Keeler 
 * @BoxIt
 */
public class Box
{
    private int myValue;
    private int myAmountUnfolded;
    private int myAmountFold1;
    private int myAmountFold2;
    private int myAmountFold3;
    private int myAmountFold4;
    private int myAmountFold5;
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
        myAmountFold1 = 0;
        myAmountFold2 = 0;
        myAmountFold3 = 0;
        myAmountFold4 = 0;
        myAmountFold5 = 0;
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
    * This will return myAmountFold1.
    * @pre none
    * @pram none
    * @return myAmountFold1
    * @post none
    */
    public int getFold1()
    {
        return myAmountFold1;
    }//ends GetAmountFold1
    
    /**
    * This will set myAmountFold1.
    * @pre none
    * @pram none
    * @return none
    * @post myAmountFold1
    */
    public void setFold1(int amount)
    {
        myAmountFold1 = amount;
    }//ends setAmountFold1
    
    /**
    * This will return myAmountFold2.
    * @pre none
    * @pram none
    * @return myAmountFold2
    * @post none
    */
    public int getFold2()
    {
        return myAmountFold2;
    }//ends GetAmountFold2
    
    /**
    * This will set myAmountFold2.
    * @pre none
    * @pram none
    * @return none
    * @post myAmountFold2
    */
    public void setFold2(int amount)
    {
        myAmountFold2 = amount;
    }//ends setAmountFold2
    
    /**
    * This will return myAmountFold3.
    * @pre none
    * @pram none
    * @return myAmountFold3
    * @post none
    */
    public int getFold3()
    {
        return myAmountFold3;
    }//ends GetAmountFold3
    
    /**
    * This will set myAmountFold3.
    * @pre none
    * @pram none
    * @return none
    * @post myAmountFold3
    */
    public void setFold3(int amount)
    {
        myAmountFold3 = amount;
    }//ends setAmountFold3
    
    /**
    * This will return myAmountFold4.
    * @pre none
    * @pram none
    * @return myAmountFold4
    * @post none
    */
    public int getFold4()
    {
        return myAmountFold4;
    }//ends GetAmountFold4
    
    /**
    * This will set myAmountFold4.
    * @pre none
    * @pram none
    * @return none
    * @post myAmountFold4
    */
    public void setFold4(int amount)
    {
        myAmountFold4 = amount;
    }//ends setAmountFold4
    
    /**
    * This will return myAmountFold5.
    * @pre none
    * @pram none
    * @return myAmountFold5
    * @post none
    */
    public int getFold5()
    {
        return myAmountFold5;
    }//ends GetAmountFold5
    
    /**
    * This will set myAmountFold5.
    * @pre none
    * @pram none
    * @return none
    * @post myAmountFold5
    */
    public void setFold5(int amount)
    {
        myAmountFold5 = amount;
    }//ends setAmountFold5
    
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
        return myName + System.lineSeparator() + myAmountUnfolded + myAmountFold1 + myAmountFold2 + myAmountFold3 + 
        myAmountFold4 + myAmountFold5 +System.lineSeparator() + myValue + System.lineSeparator() + myCost +
        System.lineSeparator() + mySell + System.lineSeparator() +myChange;
    }//ends toString
}//ends box
