
/**
 * This will hold info about the box.
 * 
 * @Ryan Keeler 
 * @BoxIt
 */
public class Box
{
    private int myValue;
    private int myAmount;
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
    public Box(int value, String name, double cost, double sell, double change)
    {
        myValue = value;
        myAmount = 0;
        myName = name;
        myCost = cost;
        mySell = sell;
        myChange = change;
    }//ends constructer
    
    /**
    * This will return getSell.
    * @pre none
    * @pram none
    * @return mySell
    * @post none
    */
    public double getSell()
    {
        return mySell;
    }//ends setSell
    
    /**
    * This will return myAmount.
    * @pre none
    * @pram none
    * @return myAmount
    * @post none
    */
    public int getAmount()
    {
        return myAmount;
    }//ends setSell
    
    /**
    * This will set myAmount.
    * @pre none
    * @pram none
    * @return myAmount
    * @post none
    */
    public void setAmount(int amount)
    {
        myAmount = amount;
    }//ends setSell
    
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
}//ends box
