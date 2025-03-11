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
    public final int STARTING_AMOUNT = 0;//this is how many boxes you have to start with except paper
        //paper
    public final double PAPER_BASE_COST = 0.05;//This is the base price of paper
    public final double PAPER_SELL = 0.1;//This is the base sell price of paper
    public final double PAPER_CHANGE = 0.05;//This is how much the paper value can change
    public final int PAPER_STARTING_AMOUNT = 10;//this is how many paper boxes you have at the start
        //cardboard
    public final double CARDBOARD_BASE_COST = 1;//This is the base price of cardboard
    public final double CARDBOARD_SELL = 1.25;//This is the base price of cardboard
    public final double CARDBOARD_CHANGE = 0.2;//This is how much the cardboard value can change
        //plastic
    public final double PLASTIC_BASE_COST = 3;//This is the base price of plastic
    public final double PLASTIC_SELL = 5;//This is the base price of plastic
    public final double PLASTIC_CHANGE = 0.5;//This is how much the plastic value can change
        //steel
    public final double STEEL_BASE_COST = 6;//This is the base price of steel
    public final double STEEL_SELL = 10;//This is the base price of steel
    public final double STEEL_CHANGE = 2.5;//This is how much the steel value can change
        //sabeza
    public final double SANEZA_BASE_COST = 5;//This is the base price of saneza
    public final double SANEZA_SELL = 9;//This is the base price of saneza
    public final double SANEZA_CHANGE = 4;//This is how much the saneza value can change
        //thorby
    public final double THORBY_BASE_COST = 20;//This is the base price of thorby
    public final double THORBY_SELL = 25;//This is the base price of thorby
    public final double THORBY_CHANGE = 15;//This is how much the thorby value can change
        //plarbin
    public final double PLARBIN_BASE_COST = 15;//This is the base price of plarbin
    public final double PLARBIN_SELL = 30;//This is the base price of plarbin
    public final double PLARBIN_CHANGE = 5.0;//This is how much the plarbin value can change
    //this is the price of the folds
    public final double FOLD_TWO_COST = .5;//the cost for the second fold
    public final double FOLD_THREE_COST = 1;//the cost for the third fold
    public final double FOLD_FOUR_COST = 3;//the cost for the fourth fold
    public final double FOLD_FIVE_COST = 7;//the cost for the fifth fold
    //this is the multiplyer of the folds
    public final double FOLD_TWO_BONUS = 1.25;
    public final double FOLD_THREE_BONUS = 1.5;
    public final double FOLD_FOUR_BONUS = 1.75;
    public final double FOLD_FIVE_BONUS = 2;
    //keeps track of how many boxes there are
    public final int BOX_NUM = 7;//this is how many box types there are
    //keeps track of how many folds there are
    public final int FOLD_NUM = 5;
    //research finals
    public final double RESEARCH_INCREASE = 2;//this is how much the price to reserch is multiplied each time
    public final double RESEARCH_TYPE_INCREASE = 4.0;//this is the multiplyer for getting a new box
    //gives random chance
    public final double FIFTY_FIFTY = .5;//this is the chance that a price will be up or down
    public final double RANDOM_EVENT = 100;//this is the chance of something happening
    //this is myDate finals
    public final int SHOPING_TIME_SMALL = 7;//this is how long a short holliday lasts
    public final int SHOPING_TIME_MED = 14;
    public final int SHOPING_TIME_BIG = 28;//this is how long a big holliday lasts
    public final int DAYS_IN_YEAR = 365;//how many days there are in a year
    public final int JAN_END = 31;//when january ends
    public final int FEB_END = 59;//when febuary ends
    public final int MARCH_END = 90;// when march ends
    public final int APRIL_END = 120;//when april ends
    public final int MOTHERS_DAY = 128;//when mothers day is
    public final int MAY_END = 151;//when may ends
    public final int FATHERS_DAY = 170;//when fathers day is
    public final int JUNE_END = 181;//when june ends
    public final int JULY_END = 212;//when july ends
    public final int AUG_END = 243;//when august ends
    public final int SEP_END = 273;//when september ends
    public final int HALLOWEEN = 304;//when halloween is
    public final int OCT_END = 304;//when october endsd
    public final int THANKSGIVING = 328;//when thatksgiving is
    public final int NOV_END = 334;//when november ends
    public final int CHRISTMAS = 359;//when christmas is
    public final int DEC_END = 365;//when the year ends
    //random events
    public final int WEEK = 7;//this is the amount of days in a week
    //good chances
    public final int CARDBOARD_GOOD_CHANCE = 1;//the number picked if cardboard gets a bonus
    public final int PLASTIC_GOOD_CHANCE = 2;//the number picked if plastic gets a bonus
    public final int STEEL_GOOD_CHANCE = 3;//the number picked if steel gets a bonus
    public final int SANEZA_GOOD_CHANCE = 4;//the number picked if saneza gets a bonus
    public final int THORBY_GOOD_CHANCE = 5;//the number picked if thorby gets a bonus
    public final int CARBON_GOOD_CHANCE = 6;//the number picked if plarbon gets a bonus
    //bad chances
    public final int CARDBOARD_BAD_CHANCE = 7;//the number picked if cardboard gets a disivantage
    public final int PLASTIC_BAD_CHANCE = 8;//the number picked if plastic gets a disivantage
    public final int STEEL_BAD_CHANCE = 9;//the number picked if steel gets a disivantage
    public final int SANEZA_BAD_CHANCE = 10;//the number picked if saneza gets a disivantage
    public final int THORBY_BAD_CHANCE = 11;//the number picked if thorby gets a disivantage
    public final int CARBON_BAD_CHANCE = 12;//the number picked if plarbon gets a disivantage
    //costs
    private double myPaperCost;//This is the cost of paper
    private double myCardboardCost;//This is the cost of cardboard
    private double myPlasticCost;//This is the cost of plastic
    private double mySteelCost;//This is the cost of steel
    private double mySanezaCost;//This is the cost of saneza
    private double myThorbyCost;//This is the cost of thorby
    private double myPlarbinCost;//This is the cost of plarbin
    //what you have in stock
    private ArrayList <Box> myStock;//this is what you have in stock
    //this is the myDate
    private double myDate;//this holds the date
    private String myMonth;//this holds the month
    private String myDay;//this holds the day of the week
    private double myHolidayBonus;//this is a multiplyer for holidays
    //money
    private double myMola;//This is how much mola you have
    private double myTotalMola;//this is how much mola you have ever had
    //is the int value of the box type
    private int myType;//this is the type that is selected
    //this is research related
    private double myResearchCost;//this is the cost to reserch
    private int myMaxBuy;//this is the max boxes you can buy at a time
    private double myResearchTypeCost;//this is the cost to reserch the next teir
    private int myTypeBuy;//this is the max tier you can buy
    //randoms
    private ArrayList<Double> myRandom;//this is the list of random prices
    private int myCurrentEffect;//this picks what will happen
    private int myEventCoolDown;//this is the cooldown for the effect
    private String myCurrentThing;//this is the current effect
    /**
    * This is the constructor.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public BoxIt()
    {
        //sets initial cost
        myPaperCost = PAPER_BASE_COST;
        myCardboardCost = CARDBOARD_BASE_COST;
        myPlasticCost = PLASTIC_BASE_COST;
        mySteelCost = STEEL_BASE_COST;
        mySanezaCost = SANEZA_BASE_COST;
        myThorbyCost = THORBY_BASE_COST;
        myPlarbinCost = PLARBIN_BASE_COST;
        //creates the stock list
        myStock = new ArrayList<Box>();
        //sets date
        myDate = 0;
        myMonth = "January";
        myDay = "Monday";
        myHolidayBonus = 1;
        //sets base values
        myMola = 0.0;
        myType = 0;
        myResearchCost = 5.0;
        myMaxBuy = 10;
        myResearchTypeCost = 15;
        myTypeBuy = 0;
        //creates the list of prices
        myRandom = new ArrayList<Double>();
        //sets no event as active
        myCurrentEffect = 0;
        //allows event
        myEventCoolDown = 0;
        myCurrentThing = "";
    }//ends constructer
    
    /**
    * This buys.
    * @pre none
    * @pram how many being purchaced
    * @return none
    * @post myStock
    */
    public void buy(int i)
    {
        //this lowers how many you buy to the max number you can have if you want more
        if(i > myMaxBuy)
        {
            i = myMaxBuy;
        }//ends if
        //this is if you can afford all of them
        if(myMola >= myStock.get(myType).getCost() * i && myType != BOX_NUM + 1)
        {
            //adds boxes in
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + i);
            //subtracts money
            myMola -= myStock.get(myType).getCost() * i;
        }//ends if
        //this is if you can't afford all of them
        else if (myType != BOX_NUM + 1)
        {
            //calculates how many you can buy
            i = (int)(myMola / myStock.get(myType).getCost());
            //adds boxes in
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + i);
            //subtracts money
            myMola -= myStock.get(myType).getCost() * i;
        }//ends else if
        //this readys for the next day
        round();
        randomizePrices();
        addDay();
    }//ends buy
    
    /**
    * This fold the box that you choose.
    * @pre pick must be between 1 and 5, and sufficient stock and currency (myMola) must exist
    * @pram pick - the choice of which fold is selected
    * @return none
    * @post The number of folded boxes is updated, stock is reduced, and mola is deducted
    */
    public void foldSelector(int pick)
    {
        if(pick > 0)
        {
            //a value that you can set as the max without changing anything
            int quantity = myStock.get(myType).getAmount();
            //this limits the amount you can buy based off of myMaxBuy/the amount of reserch you have done
            if(quantity > myMaxBuy)
            {
                quantity = myMaxBuy;
            }//ends if
            //this is the free fold
            if(pick == 1)
            {
                //folds quantity boxes for free
                foldBoxes(quantity, 0, 0);
            }//ends if
            //this is the cheapest fold
            else if(pick == 2)
            {
                //folds up to quantity boxes for fold two cost or until out of mola
                foldBoxes(quantity, 1, FOLD_TWO_COST);
            }//ends else if
            //this is the moderatly expencive fold
            else if(pick == 3)
            {
                //folds up to quantity boxes for fold three cost or until out of mola
                foldBoxes(quantity, 2, FOLD_THREE_COST);
            }//ends else if
            //this is the expencive fold
            else if(pick == 4)
            {
                //folds up to quantity boxes for fold four cost or until out of mola
                foldBoxes(quantity, 3, FOLD_FOUR_COST);
            }//ends else if
            //this is the very end game fold
            else if(pick == 5)
            {
                //folds up to quantity boxes for fold five cost or until out of mola
                foldBoxes(quantity, 4, FOLD_FIVE_COST);
            }//ends else if
            //preform daily operations
            round();
            randomizePrices();
            addDay();
        }//ends if
        
    }//ends fold
    
    /**
    * This will help fold the boxes.
    * @pre none
    * @pram amount, foldType, boxCost
    * @return none
    * @post boxes are folded
    */
    private void foldBoxes(int amount, int foldType, double boxCost)
    {
        if(myMola >= (amount * boxCost))
        {
            //adds folded boxes
            myStock.get(myType).setFold(foldType, myStock.get(myType).getFold(foldType) + amount);
            //removes the folded boxes from your stock after they are folded
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() - amount);
            //subtracts money spent
            myMola -= (myMaxBuy * boxCost);
        }//ends if
        else
        {
            //this buys one at a time
            for(int i = 0; i < amount && myMola >= boxCost;i++)
            {
                //adds folded box
                myStock.get(myType).setFold(foldType,myStock.get(myType).getFold(foldType) + 1);
                //removes the folded box from your stock after it is folded
                myStock.get(myType).setAmount(myStock.get(myType).getAmount() - 1);
                //subtracts the cost of one fold
                myMola -= boxCost;
            }//ends for
        }//ends else
    }//ends foldBoxes
    
    /**
    * This will sell the boxes.
    * @pre none
    * @pram amount to sell
    * @return none
    * @post myMola, myStock
    */
    public void sell(int amount)
    {
        //sets the maximum value of amount to myMaxBuy
        if(amount > myMaxBuy)
        {
            amount = myMaxBuy;
        }//ends if
        //how much you are selling is worth
        double profit = 0;
        //calls get amount sell which gets the sell price for the amount being sold
        profit = myStock.get(myType).getAmountSell(amount, myRandom.get(myType));
        //adds profit to current mola
        myMola += profit;
        //adds profit to total mola
        myTotalMola += profit;
        myStock.get(myType).sellStock(amount);
        //this readys for the next day
        round();
        randomizePrices();
        addDay();
    }//ends sell
    
    /**
    * This will be a random event.
    * @pre none
    * @pram none
    * @return myCurrentThing
    * @post MycurrentThing
    */
    public String randomEvent()
    {
        //checks to see if an event can happen
        if(myEventCoolDown <= 0)
        {
            //selects a value indicating the event
            int myCurrentEffect = (int)(Math.random() * RANDOM_EVENT);
            //if something good happens for cardboard
            if(myCurrentEffect == CARDBOARD_GOOD_CHANCE)
            {
                //cheeper Cardboard
                myCardboardCost /= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(1);
                //sets event text
                myCurrentThing = "A new way of growing trees has been found CARDBOARD IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == PLASTIC_GOOD_CHANCE)
            {
                //cheeper Plastic and plarbin
                myPlasticCost /= 2;
                myPlarbinCost /= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(7);
                //sets event text
                myCurrentThing = "A huge deposit of oil has been found PLASTIC AND PLARBIN ARE HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == STEEL_GOOD_CHANCE)
            {
                //cheeper Steel
                mySteelCost /= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(3);
                //sets event text
                myCurrentThing = "A new way of turning energy into iron has been found STEEL IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == SANEZA_GOOD_CHANCE)
            {
                //cheeper Saneza
                mySanezaCost /= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(4);
                //sets event text
                myCurrentThing = "Sterilization is now better around the world SANEZA IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == THORBY_GOOD_CHANCE)
            {
                //cheeper Cardboard
                myThorbyCost /= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(5);
                //sets event text
                myCurrentThing = "It is international thorby week THORBY IS HALF THE PRICE";
            }//ends else if
            else if (myCurrentEffect == CARBON_GOOD_CHANCE)
            {
                //cheeper Plarbin
                myPlarbinCost /= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(6);
                //sets event text
                myCurrentThing = "A new carbon baised entity has been found and the world celebrates PLARBIN IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == CARDBOARD_BAD_CHANCE)
            {
                //more expensive Cardboard
                myCardboardCost *= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(1);
                //sets event text
                myCurrentThing = "The world is noticing a lack of trees CARDBOARD IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == PLASTIC_BAD_CHANCE)
            {
                //more expensive Plastic and Plarbin
                myPlasticCost *= 2;
                myPlarbinCost *= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(7);
                //sets event text
                myCurrentThing = "Oil is running low PLASTIC AND PLARBIN ARE TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == STEEL_BAD_CHANCE)
            {
                //more expensive Steel
                mySteelCost *= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(3);
                //sets event text
                myCurrentThing = "The world is low on iron STEEL IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == SANEZA_BAD_CHANCE)
            {
                //more expensive Saneza
                mySanezaCost *= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(4);
                //sets event text
                myCurrentThing = "A new disease has been found SANEZA IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == THORBY_BAD_CHANCE)
            {
                //more expensive Thorby
                myThorbyCost *= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(5);
                //sets event text
                myCurrentThing = "The public has realized that thorby sucks THORBY IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == CARBON_BAD_CHANCE)
            {
                //more expensive Plarbin
                myPlarbinCost *= 2;
                //week cool down
                myEventCoolDown = WEEK;
                //resets all other prices
                resetPrices(6);
                //sets event text
                myCurrentThing = "An endling has died the world vows to have a smaller carbon footprint PLARBIN IS TWICE THE PRICE";
            }//ends else if
            else
            {
                //resets all prices
                resetPrices(8);
                //sets event text
                myCurrentThing = "Nothing is going on";
            }//ends else
        }//ends if
        //returns event text
        return myCurrentThing;
    }//ends randomEvent
    
    /**
    * This will reset the prices that arn't changed.
    * @pre none
    * @pram a value of 0-8 indicating which setting must be reset
    * @return none
    * @post myCosts
    */
    public void resetPrices(int i)
    {
        //not currently used but resets all but Paper
        if(i == 0)
        {
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends if
        //resets all  but Cardboard
        else if(i == 1)
        {
            myPaperCost = PAPER_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        //resets all  but Plastic
        else if(i == 2)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        //resets all  but Steel
        else if(i == 3)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        //resets all  but Saneza
        else if(i == 4)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        //resets all  but Thorby
        else if(i == 5)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        //resets all  but Plarbin
        else if(i == 6)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
        }//ends else if
        //resets all  but Plastic and Plarbin
        else if(i == 7)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
        }//ends else if
        //resets all prices
        else if(i == 8)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
    }//ends resetPrice
    
    /**
    * This will add a myDay.
    * @pre none
    * @pram none
    * @return none
    * @post myDay, myMonth, myDate, myCurrentThing
    */
    public void addDay()
    {
        //this will add to the date
        if(myDate <= DAYS_IN_YEAR)
        {
            //you get two actions per day
            myDate+=0.5;
            //this subtracts a day for myEventCoolDown
            if(myDate == (int)myDate && myEventCoolDown > 0)
            {
                myEventCoolDown--;
            }//ends if
        }//ends if
        else
        {
            //if the year ticks over
            myDate = 1;
        }//ends else
        //this rotates the day forward
        if(myDay.equals("Sunday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Monday";
        }//ends if
        else if(myDay.equals("Monday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Tuesday";
        }//ends else if
        else if(myDay.equals("Tuesday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Wendsday";
        }//ends else if
        else if(myDay.equals("Wendsday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Thursday";
        }//ends else if
        else if(myDay.equals("Thursday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Friday";
        }//ends else if
        else if(myDay.equals("Friday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Saturday";
        }//ends else if
        else if(myDay.equals("Saturday") && (myDate - (int)myDate) == 0)
        {
            myDay = "Sunday";
        }//ends else if
        //this rotates the month
        if(myDate <= JAN_END)
        {
            myHolidayBonus = 1;
            myCurrentThing = randomEvent();
            myMonth = "January";
        }//ends if
        else if(myDate <= FEB_END)
        {
            myMonth = "Febuary";
            myCurrentThing = randomEvent();
        }//ends else if
        else if(myDate <= MARCH_END)
        {
            myMonth = "March";
            myCurrentThing = randomEvent();
        }//ends else if
        else if(myDate <= APRIL_END)
        {
            myMonth = "April";
            myCurrentThing = randomEvent();
        }//ends else if
        else if(myDate <= MAY_END)
        {
            //this is for a holiday
            if(myDate <= MOTHERS_DAY && myDate > (MOTHERS_DAY - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 2;
                myCurrentThing = "Mothers Day everything gives up to 2 times the profit";
                myEventCoolDown = SHOPING_TIME_SMALL;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = randomEvent();
            }//ends else
            myMonth = "May";
        }//ends else if
        else if(myDate <= JUNE_END)
        {
            //this is for a holiday
            if(myDate <= FATHERS_DAY && myDate > (FATHERS_DAY - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 1.5;
                myCurrentThing = "Fathers Day everything gives up to 1.5 times the profit";
                myEventCoolDown = SHOPING_TIME_SMALL;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = randomEvent();
            }//ends else
            myMonth = "June";
        }//ends else if
        else if(myDate <= JULY_END)
        {
            myMonth = "July";
            myCurrentThing = randomEvent();
        }//ends else if
        else if(myDate <= AUG_END)
        {
            myMonth = "August";
            myCurrentThing = randomEvent();
        }//ends else if
        else if(myDate <= SEP_END)
        {
            myMonth = "September";
            myCurrentThing = randomEvent();
        }//ends else if
        else if(myDate <= OCT_END)
        {
            //this is for a holiday
            if(myDate <= HALLOWEEN && myDate > (HALLOWEEN - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 3;
                myCurrentThing = "Halloween";
                myEventCoolDown = SHOPING_TIME_MED;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = randomEvent();
            }//ends else
            myMonth = "October";
        }//ends else if
        else if(myDate <= NOV_END)
        {
            //this ends Halloween
            myHolidayBonus = 1;
            myCurrentThing = randomEvent();
            //this is for a holiday
            if(myDate <= THANKSGIVING && myDate > (THANKSGIVING - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 2;
                myCurrentThing = "Thanksgiving everything gives up to 2 times the profit";
                myEventCoolDown = SHOPING_TIME_SMALL;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = randomEvent();
            }//ends else
            myMonth = "November";
        }//ends else if
        else if(myDate <= DEC_END)
        {
            //this is for a holiday
            if(myDate <= CHRISTMAS && myDate > (CHRISTMAS - SHOPING_TIME_BIG))
            {
                myHolidayBonus = 6;
                myCurrentThing = "Cristmas everything gives up to 6 times the profit";
                myEventCoolDown = SHOPING_TIME_BIG;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = randomEvent();
            }//ends else
            myMonth = "December";
        }//ends else if
    }//ends add myDay
    
    /**
    * This will round myMola.
    * @pre none
    * @pram none
    * @return none
    * @post myMola
    */
    public void round()
    {
        //rounds to the 0.00
        myMola = (double)Math.round(myMola * 10000) / 10000;
        //also rounds the total to keep it in line
        roundTotal();
    }//ends round
    
    /**
    * This will round myTotalMola.
    * @pre none
    * @pram none
    * @return none
    * @post myTotalMola
    */
    public void roundTotal()
    {
        //rounds to the 0.00
        myTotalMola = (double)Math.round(myTotalMola * 10000) / 10000;
    }//ends round
    
    /**
    * This randomizes the prices.
    * @pre none
    * @pram none
    * @return none
    * @post myRandom
    */
    public void randomizePrices()
    {
        //this randomizes prices based on holiday bonus and normal variable prices
        myRandom.set(0, Math.random() * (PAPER_CHANGE * myHolidayBonus));
        myRandom.set(1, Math.random() * (CARDBOARD_CHANGE * myHolidayBonus));
        myRandom.set(2, Math.random() * (PLASTIC_CHANGE * myHolidayBonus));
        myRandom.set(3, Math.random() * (STEEL_CHANGE * myHolidayBonus));
        myRandom.set(4, Math.random() * (SANEZA_CHANGE * myHolidayBonus));
        myRandom.set(5, Math.random() * (THORBY_CHANGE * myHolidayBonus));
        myRandom.set(6, Math.random() * (PLARBIN_CHANGE * myHolidayBonus));
        //this desides if it is positive or negative for each box type
        for(int i = 0; i < BOX_NUM; i++)
        {
            //also factors in if it is a holiday and guerentees positive if it is
            if(Math.random() < FIFTY_FIFTY && myHolidayBonus == 1)
            {
                myRandom.set(i, -myRandom.get(i));
            }//ends if
            //rounds the prices
            myRandom.set(i, Math.round(myRandom.get(i) * 100) / 100.0);
        }//ends for
    }//ends randomizePrices
    
    /**
    * This allowes you to buy more boxes at a time.
    * @pre none
    * @pram none
    * @return none
    * @post myMaxBuy, myMola
    */
    public void research()
    {
        //checks to make sure that you can afford it and prevents soft locking by also adding the price of one paper which is guerenteed not to lose money
        if(myMola >= (myResearchCost + myPaperCost))
        {
            //increases how much you can buy
            myMaxBuy++;
            //takes money spent
            myMola -= myResearchCost;
            //increases fututre cost of research
            myResearchCost += RESEARCH_INCREASE;
            //rounds the research cost
            myResearchCost = Math.round(myResearchCost * 1000) / 1000;
            round();
        }//ends if
    }//ends research
    
    /**
    * This allowes you to buy more box types.
    * @pre none
    * @pram none
    * @return none
    * @post myTypeBuy. myResearchTypeCost, myMola
    */
    public void researchType()
    {
        //checks to make sure that you can afford it and it exists while preventing soft locking by also adding the price of one paper which is guerenteed not to lose money
        if(myMola >= (myResearchTypeCost + myPaperCost) && myTypeBuy < BOX_NUM - 1)
        {
            //allows you to buy a new box
            myTypeBuy++;
            //takes money spent
            myMola -= myResearchTypeCost;
            //increases futur cost of research
            myResearchTypeCost *= RESEARCH_TYPE_INCREASE;
            //rounds the research cost
            myResearchTypeCost = Math.round(myResearchTypeCost * 100) / 100;
            round();
        }//ends if
    }//ends research
    
    /**
    * This creates the boxes at the begginging of the game.
    * @pre none
    * @pram none
    * @return none
    * @post all boxes created
    */
    public void createBoxes()
    {
        //this constructs the boxes
        myStock.add(new Box(0, "paper", PAPER_BASE_COST, PAPER_SELL, PAPER_CHANGE, PAPER_STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        myStock.add(new Box(1, "cardboard", CARDBOARD_BASE_COST, CARDBOARD_SELL, CARDBOARD_CHANGE, STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        myStock.add(new Box(2, "plastic", PLASTIC_BASE_COST, PLASTIC_SELL, PLASTIC_CHANGE, STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        myStock.add(new Box(3, "steel", STEEL_BASE_COST, STEEL_SELL, STEEL_CHANGE, STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        myStock.add(new Box(4, "saneza", SANEZA_BASE_COST, SANEZA_SELL, SANEZA_CHANGE, STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        myStock.add(new Box(5, "thorby", THORBY_BASE_COST, THORBY_SELL, THORBY_CHANGE, STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        myStock.add(new Box(6, "plarbin", PLARBIN_BASE_COST, PLARBIN_SELL, PLARBIN_CHANGE, STARTING_AMOUNT,
        FOLD_TWO_BONUS, FOLD_THREE_BONUS, FOLD_FOUR_BONUS, FOLD_FIVE_BONUS));
        //this adds box_num places to myRandom so it will have the spaces for what it needs
        for(int i = 0; i < BOX_NUM; i++)
        {
            myRandom.add(null);
        }//ends fort
    }//ends createBoxes
    
    /**
    * This gets the day.
    * @pre none
    * @pram none
    * @return the date
    * @post none
    */
    public String getTheDay()
    {
        if(myDate <= JAN_END)
        {
            return myDay + ", January, " + ((int)myDate);
        }//ends if
        else if(myDate <= FEB_END)
        {
            return myDay + ", Febuary, " + ((int)myDate - JAN_END);
        }//ends else if
        else if(myDate <= MARCH_END)
        {
            return myDay + ", March, " + ((int)myDate - FEB_END);
        }//ends else if
        else if(myDate <= APRIL_END)
        {
            return myDay + ", April, " + ((int)myDate - MARCH_END);
        }//ends else if
        else if(myDate <= MAY_END)
        {
            return myDay + ", May, " + ((int)myDate - APRIL_END);
        }//ends else if
        else if(myDate <= JUNE_END)
        {
            return myDay + ", June, " + ((int)myDate - MAY_END);
        }//ends else if
        else if(myDate <= JULY_END)
        {
            return myDay + ", July, " + ((int)myDate - JUNE_END);
        }//ends else if
        else if(myDate <= AUG_END)
        {
            return myDay + ", August, " + ((int)myDate - JULY_END);
        }//ends else if
        else if(myDate <= SEP_END)
        {
            return myDay + ", September, " + ((int)myDate - AUG_END);
        }//ends else if
        else if(myDate <= OCT_END)
        {
            return myDay + ", October, " + ((int)myDate - SEP_END);
        }//ends else if
        else if(myDate <= NOV_END)
        {
            return myDay + ", November, " + ((int)myDate - OCT_END);
        }//ends else if
        else if(myDate <= DEC_END)
        {
            return myDay + ", December, " + ((int)myDate - NOV_END);
        }//ends else if
        return myDay + ", January, 1";
    }//ends getTheDay
    
    /**
    * This gets the price of each box.
    * @pre none
    * @pram a number representing which box price was requested
    * @return the requested price amount
    * @post none
    */
    public double getPrice(int i)
    {
        //if paper requested
        if(i == 0)
        {
            return myPaperCost;
        }//ends if
        //if cardboard requested
        else if(i == 1)
        {
            return myCardboardCost;
        }//ends else if
        //if plastic requested
        else if(i == 2)
        {
            return myPlasticCost;
        }//ends else if
        //if steel requested
        else if(i == 3)
        {
            return mySteelCost;
        }//ends else if
        //if saneza requested
        else if(i == 4)
        {
            return mySanezaCost;
        }//ends else if
        //if thorby requested
        else if(i == 5)
        {
            return myThorbyCost;
        }//ends else if
        //if plarbin requested
        else if(i == 6)
        {
            return myPlarbinCost;
        }//ends else if
        //failure state
        return -1;
    }//ends getPrice
    
    /**
    * This gets the folds amounts.
    * @pre none
    * @pram fold, type
    * @return the requested fold amount
    * @post none
    */
    public int getFold(int fold, int type)
    {
        return myStock.get(type).getFold(fold);
    }//ends getFold
    
    /**
    * This sets the folds amounts.
    * @pre none
    * @pram fold, type
    * @return none
    * @post myStock
    */
    public void setFold(int type, int fold, int amount)
    {
        myStock.get(type).setFold(fold, amount);
    }//ends getFold
    
    /**
    * This gets the total fold amounts.
    * @pre none
    * @pram type
    * @return the requested fold
    * @post none
    */
    public int getTotalFold(int type)
    {
        return myStock.get(type).getTotalFolded();
    }//ends getTotalFold
    
    /**
    * This gets myRandom.
    * @pre none
    * @pram none
    * @return myRandom
    * @post none
    */
    public ArrayList<Double> getRandom()
    {
        return myRandom;
    }//ends getRandom
    
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
    * @pram what it is setting mola as
    * @return none
    * @post myMola
    */
    public void setMola(double mola)
    {
        myMola = mola;
    }//ends getMola
    
    /**
    * This gets myTotalMola.
    * @pre none
    * @pram none
    * @return myTotalMola
    * @post none
    */
    public double getTotalMola()
    {
        return myTotalMola;
    }//ends getTotalMola
    
    /**
    * This sets myTotalMola.
    * @pre none
    * @pram what it is setting total mola as
    * @return none
    * @post myTotalMola
    */
    public void setTotalMola(double mola)
    {
        myTotalMola = mola;
    }//ends getTotalMola
    
    /**
    * This gets myCurrentEffect.
    * @pre none
    * @pram none
    * @return myCurrentEffect
    * @post none
    */
    public double getCurrentEffect()
    {
        return myCurrentEffect;
    }//ends getCurrentEffect
    
    /**
    * This sets myCurrentEffect.
    * @pre none
    * @pram whatever effect is being set as active
    * @return none
    * @post myCurrentEffect
    */
    public void setCurrentEffect(int effect)
    {
        myCurrentEffect = effect;
    }//ends getMola
    
    /**
    * This gets myDate.
    * @pre none
    * @pram none
    * @return myDate
    * @post none
    */
    public double getDate()
    {
        return myDate;
    }//ends getDate
    
    /**
    * This sets myDate.
    * @pre none
    * @pram what the date is being set as
    * @return none
    * @post myDate
    */
    public void setDate(double date)
    {
        myDate = date;
    }//ends setPaperAmount
    
    /**
    * This gets myMonth.
    * @pre none
    * @pram none
    * @return myMonth
    * @post none
    */
    public String getMonth()
    {
        return myMonth;
    }//ends getMonth
    
    /**
    * This sets myMonth.
    * @pre none
    * @pram what the month is being set as
    * @return none
    * @post myMonth
    */
    public void setMonth(String month)
    {
        myMonth = month;
    }//ends setMonth
    
    /**
    * This gets myDay.
    * @pre none
    * @pram none
    * @return myDay
    * @post none
    */
    public String getDay()
    {
        return myDay;
    }//ends getDay
    
    /**
    * This sets myDay.
    * @pre none
    * @pram the day that is being set
    * @return none
    * @post myDay
    */
    public void setDay(String day)
    {
        myDay = day;
    }//ends setDay
    
    /**
    * This gets myCoolDown.
    * @pre none
    * @pram none
    * @return myCoolDown
    * @post none
    */
    public int getCoolDown()
    {
        return myEventCoolDown;
    }//ends getCoolDow
    
    /**
    * This sets myCoolDown.
    * @pre none
    * @pram the cooldown for events
    * @return none
    * @post myCoolDown
    */
    public void setCoolDown(int coolDown)
    {
        myEventCoolDown = coolDown;
    }//ends setCoolDown
    
    /**
    * This gets myCurrentThing.
    * @pre none
    * @pram none
    * @return myCurrentThing
    * @post none
    */
    public String getEffect()
    {
        return myCurrentThing;
    }//ends getEfgect
    
    /**
    * This sets myCurrentThing.
    * @pre none
    * @pram the effect being set
    * @return none
    * @post myCurrentThing
    */
    public void setEffect(String effect)
    {
        myCurrentThing = effect;
    }//ends setEffect
    
    /**
    * This gets myCosts.
    * @pre none
    * @pram a value requesting the requested cost
    * @return cost of requested box
    * @post none
    */
    public String getCosts(int i)
    {
        if(i == 0)
        {
            return Double.toString(myPaperCost);
        }//ends if
        else if(i == 1)
        {
            return Double.toString(myCardboardCost);
        }//ends else if
        else if(i == 2)
        {
            return Double.toString(myPlasticCost);
        }//ends else if
        else if(i == 3)
        {
            return Double.toString(mySteelCost);
        }//ends else if
        else if(i == 4)
        {
            return Double.toString(mySanezaCost);
        }//ends else if
        else if(i == 5)
        {
            return Double.toString(myThorbyCost);
        }//ends else if
        else if(i == 6)
        {
            return Double.toString(myPlarbinCost);
        }//ends else if
        return "NO BREAKING MY GAME";
    }//ends getCosts
    
    /**
    * This sets myCosts.
    * @pre none
    * @pram which box is selected, then the value it is being set as
    * @return myDay
    * @post my box cost
    */
    public void setCosts(int i, double amount)
    {
        if(i == 0)
        {
            myPaperCost = amount;
        }//ends if
        else if(i == 1)
        {
            myCardboardCost = amount;
        }//ends else if
        else if(i == 2)
        {
            myPlasticCost = amount;
        }//ends else if
        else if(i == 3)
        {
            mySteelCost = amount;
        }//ends else if
        else if(i == 4)
        {
            mySanezaCost = amount;
        }//ends else if
        else if(i == 5)
        {
             myThorbyCost = amount;
        }//ends else if
        else if(i == 6)
        {
            myPlarbinCost = amount;
        }//ends else if
    }//ends setCosts
    
    /**
    * This gets myStock 0 amount.
    * @pre none
    * @pram which amount is being requested
    * @return a part of myAmount
    * @post none
    */
    public String getBoxAmount(int num)
    {
        if(num == 0)
        {
            return Integer.toString(myStock.get(0).getAmount());
        }//ends if
        else if(num == 1)
        {
            return Integer.toString(myStock.get(1).getAmount());
        }//ends else if
        else if(num == 2)
        {
            return Integer.toString(myStock.get(2).getAmount());
        }//ends else if
        else if(num == 3)
        {
            return Integer.toString(myStock.get(3).getAmount());
        }//ends else if
        else if(num == 4)
        {
            return Integer.toString(myStock.get(4).getAmount());
        }//ends else if
        else if(num == 5)
        {
            return Integer.toString(myStock.get(5).getAmount());
        }//ends else if
        else if(num == 6)
        {
            return Integer.toString(myStock.get(6).getAmount());
        }//ends else if
        return "NO BREAKING MY GAME";
    }//ends getBoxAmount
    
    /**
    * This sets myStock 0 amount.
    * @pre none
    * @pram the box selcted, the amount which is being set
    * @return none
    * @post a part of myAmount
    */
    public void setBoxAmount(int num,int stock)
    {
        myStock.get(num).setAmount(stock);
    }//ends setBoxAmount
    
    /**
    * This sets myType.
    * @pre none
    * @pram which type is selected
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
    * This gets the text for how much a box sells for.
    * @pre none
    * @pram a value which represents which box is requested
    * @return myRandomi
    * @post none
    */
    public String getRandomText(int i)
    {
        return myStock.get(i).getName() + " sells for $"  + (Math.round((myStock.get(i).getSell(0) + myRandom.get(i)) * 100)/ 100.0);
    }//ends getRandomText
    
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
    * This sets myResearchCost.
    * @pre none
    * @pram what the cost is being set as
    * @return none
    * @post myResearchCost
    */
    public void setResearchCost(double cost)
    {
        myResearchCost = cost;
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
    * This sets myResearchTypeCost.
    * @pre none
    * @pram what the research cost is being set as
    * @return none
    * @post myResearchTypeCost
    */
    public void setResearchTypeCost(double cost)
    {
        myResearchTypeCost = cost;
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
    }//ends getTypeBuy
    
    /**
    * This sets myTypeBuy.
    * @pre none
    * @pram what myTypeBuy is being set as
    * @return none
    * @post myTypeBuy
    */
    public void setTypeBuy(int buy)
    {
        myTypeBuy = buy;
    }//ends setTypeBuy
    
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
    }//ends getMaxBuy
    
    /**
    * This sets myMaxBuy.
    * @pre none
    * @pram what myMaxBuy is being set as.
    * @return none
    * @post myMaxBuy
    */
    public void setMaxBuy(int buy)
    {
        myMaxBuy = buy;
    }//ends setMaxBuy
    
    /**
    * This gets myStock.
    * @pre none
    * @pram none
    * @return myStock
    * @post none
    */
    public ArrayList<Box> getStock()
    {
        return myStock;
    }//ends getMaxBuy
}//ends BoxIt