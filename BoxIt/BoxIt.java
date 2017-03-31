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
    public final double PAPER_SELL = 0.1;//This is the base price of paper
    public final double PAPER_CHANGE = 0.05;//This is how much the paper value can change
    public final int PAPER_STARTING_AMOUNT = 10;//this is how many paper boxes you have
        //cardboard
    public final double CARDBOARD_BASE_COST = 1;//This is the base price of paper
    public final double CARDBOARD_SELL = 1.25;//This is the base price of cardboard
    public final double CARDBOARD_CHANGE = 0.2;//This is how much the cardboard value can change
    public final double CARDBOARD_BASE_CHANCE = 1;//this is the base price of carbon
        //plastic
    public final double PLASTIC_BASE_COST = 3;//This is the base price of paper
    public final double PLASTIC_SELL = 5;//This is the base price of plastic
    public final double PLASTIC_CHANGE = 0.5;//This is how much the plastic value can change
        //steel
    public final double STEEL_BASE_COST = 6;//This is the base price of paper
    public final double STEEL_SELL = 10;//This is the base price of steel
    public final double STEEL_CHANGE = 2.5;//This is how much the steel value can change
        //sabeza
    public final double SANEZA_BASE_COST = 5;//This is the base price of paper
    public final double SANEZA_SELL = 9;//This is the base price of saneza
    public final double SANEZA_CHANGE = 4;//This is how much the saneza value can change
        //thorby
    public final double THORBY_BASE_COST = 20;//This is the base price of paper
    public final double THORBY_SELL = 25;//This is the base price of thorby
    public final double THORBY_CHANGE = 15;//This is how much the thorby value can change
        //plarbin
    public final double PLARBIN_BASE_COST = 15;//This is the base price of paper
    public final double PLARBIN_SELL = 30;//This is the base price of plarbin
    public final double PLARBIN_CHANGE = 5.0;//This is how much the plarbin value can change
    //this is the price of the folds
    public final double FOLD_TWO_COST = .5;//the cost for the second cost
    public final double FOLD_THREE_COST = 1;//the cost for the third cost
    public final double FOLD_FOUR_COST = 3;//the cost for the fourth cost
    public final double FOLD_FIVE_COST = 7;//the cost for the fifth cost
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
    public final int HALLOWEEN = 304;
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
    private int myTypeBuy;//this is the max teir you can buy
    //randoms
    private ArrayList<Double> myRandom;//this is the list of random prices
    private int myCurrentEffect;//this picks what will happen
    private int myEventCoolDown;//this is the cooldown for the effect
    private String myCurrentThing;//this is the current effect
    /**
    * This constructs.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public BoxIt()
    {
        myPaperCost = PAPER_BASE_COST;
        myCardboardCost = CARDBOARD_BASE_COST;
        myPlasticCost = PLASTIC_BASE_COST;
        mySteelCost = STEEL_BASE_COST;
        mySanezaCost = SANEZA_BASE_COST;
        myThorbyCost = THORBY_BASE_COST;
        myPlarbinCost = PLARBIN_BASE_COST;
        myStock = new ArrayList<Box>();
        myDate = 1;
        myMonth = "January";
        myDay = "Monday";
        myHolidayBonus = 1;
        myMola = 0.0;
        myType = 0;
        myResearchCost = 5.0;
        myMaxBuy = 10;
        myResearchTypeCost = 15;
        myTypeBuy = 0;
        myRandom = new ArrayList<Double>();
        myCurrentEffect = 0;
        myEventCoolDown = 0;
        myCurrentThing = "";
    }//ends constructer
    
    /**
    * This buys.
    * @pre none
    * @pram i
    * @return none
    * @post none
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
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + i);
            myMola -= myStock.get(myType).getCost() * i;
        }//ends if
        //this is if you can't afford all of them
        else if (myType != BOX_NUM + 1)
        {
            i = (int)(myMola / myStock.get(myType).getCost());
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() + i);
            myMola -= myStock.get(myType).getCost() * i;
        }//ends else if
        //this readys for the next day
        round();
        randomizePrices();
        addDay();
    }//ends buy
    
    /**
    * This fold the box that you choose.
    * @pre none
    * @pram pick, quantity
    * @return none
    * @post none
    */
    public void fold(int pick)
    {
        int quantity = myStock.get(myType).getAmount();
        //this limits the amount you can buy based off of myMaxBuy/the amount of reserch you have done
        if(quantity > myMaxBuy)
        {
            quantity = myMaxBuy;
        }//ends if
        //this is the free fold
        if(pick == 1)
        {
            myStock.get(myType).setFold(1, myStock.get(myType).getFold(1) + quantity);
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() - quantity);
        }//ends if
        //this is the cheapest fold
        else if(pick == 2)
        {
            //this limits the amount you can buy based off mola
            if((myMola * quantity) >= (quantity * FOLD_TWO_COST))
            {
                myStock.get(myType).setFold(2, myStock.get(myType).getFold(2) + quantity);
                myStock.get(myType).setAmount(myStock.get(myType).getAmount() - quantity);
                myMola -= (myMaxBuy * FOLD_TWO_COST);
            }//ends if
            else
            {
                //this buys one at a time
                for(int i = 0; i < quantity;i++)
                {
                    if(myMola >= FOLD_TWO_COST)
                    {
                        myStock.get(myType).setFold(2, myStock.get(myType).getFold(2) + 1);
                        myStock.get(myType).setAmount(myStock.get(myType).getAmount() - 1);
                        myMola -= FOLD_TWO_COST;
                    }//ends if
                }//ends for
            }//ends if
        }//ends else if
        //this is the moderatly expencive fold
        else if(pick == 3)
        {
            //this limits the amount you can buy based off mola
            if((myMola * quantity) >= (quantity * FOLD_THREE_COST))
            {
                myStock.get(myType).setFold(3, myStock.get(myType).getFold(3) + quantity);
                myStock.get(myType).setAmount(myStock.get(myType).getAmount() - quantity);
                myMola -= (myMaxBuy * FOLD_THREE_COST);
            }//ends if
            else
            {
                //this buys one at a time
                for(int i = 0; i < quantity;i++)
                {
                    if(myMola >= FOLD_TWO_COST)
                    {
                        myStock.get(myType).setFold(3, myStock.get(myType).getFold(3) + 1);
                        myStock.get(myType).setAmount(myStock.get(myType).getAmount() - 1);
                        myMola -= FOLD_THREE_COST;
                    }//ends if
                }//ends for
            }//ends if
        }//ends else if
        //this is the expencive fold
        else if(pick == 4)
        {
            //this limits the amount you can buy based off mola
            if((myMola * quantity) >= (quantity * FOLD_FOUR_COST))
            {
                myStock.get(myType).setFold(4,myStock.get(myType).getFold(4) + quantity);
                myStock.get(myType).setAmount(myStock.get(myType).getAmount() - quantity);
                myMola -= (myMaxBuy * FOLD_FOUR_COST);
            }//ends if
            else
            {
                //this buys one at a time
                for(int i = 0; i < quantity;i++)
                {
                    if(myMola >= FOLD_TWO_COST)
                    {
                        myStock.get(myType).setFold(4, myStock.get(myType).getFold(4) + 1);
                        myStock.get(myType).setAmount(myStock.get(myType).getAmount() - 1);
                        myMola -= FOLD_FOUR_COST;
                    }//ends if
                }//ends for
            }//ends if
        }//ends else if
        //this is the very end game fold
        else if(pick == 5)
        {
            //this limits the amount you can buy based off mola
            if((myMola * quantity) >= (quantity * FOLD_FIVE_COST))
            {
                myStock.get(myType).setFold(5, myStock.get(myType).getFold(5) + quantity);
                myStock.get(myType).setAmount(myStock.get(myType).getAmount() - quantity);
                myMola -= (myMaxBuy * FOLD_FIVE_COST);
            }//ends if
            else
            {
                //this buys one at a time
                for(int i = 0; i < quantity;i++)
                {
                    if(myMola >= FOLD_TWO_COST)
                    {
                        myStock.get(myType).setFold(5,myStock.get(myType).getFold(5) + 1);
                        myStock.get(myType).setAmount(myStock.get(myType).getAmount() - 1);
                        myMola -= FOLD_FIVE_COST;
                    }//ends if
                }//ends forr
            }//ends if
        }//ends else if
        round();
        randomizePrices();
        addDay();
    }//ends fold
    
    /**
    * This will sell the boxes.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void sell(int i)
    {
        //this is if you ask to sell less than you have
        if(i <= myStock.get(myType).getAmount() && myType != BOX_NUM + 1)
        {
            //this is to subtract the items
            for(int j = 1; j <= FOLD_NUM; j++)
            {
                myStock.get(myType).setFold(j, myStock.get(myType).getFold(j) - i);
            }//ends for
            //this is to add the mola
            for(int j = 1; j <= FOLD_NUM; j++)
            {
                 myMola += (myStock.get(myType).getSell(j) + myRandom.get(myType)) * i;
            }//ends for
            //this is to add to the total mola counter
            for(int j = 1; j <= FOLD_NUM; j++)
            {
                 myTotalMola += (myStock.get(myType).getSell(j) + myRandom.get(myType)) * i;
            }//ends for
        }//ends if
        //this is if you want to sell more than you have
        else if (myType != BOX_NUM + 1)
        {
            //this is to sell the fold
            for(int j = 1; j <= FOLD_NUM; j++)
            {
                i = myStock.get(myType).getFold(j);
                myStock.get(myType).setFold(j ,myStock.get(myType).getFold(j) - i);
                myMola += (myStock.get(myType).getSell(j) + myRandom.get(myType)) * i;
                myTotalMola += (myStock.get(myType).getSell(j) + myRandom.get(myType)) * i;
            }//ends for
        }//ends else if
        //this readys for the next day
        round();
        roundTotal();
        randomizePrices();
        addDay();
    }//ends sell
    
    /**
    * This will be a random event.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public String randomEvent()
    {
        if(myEventCoolDown <= 0)
        {
            int myCurrentEffect = (int)(Math.random() * RANDOM_EVENT);
            if(myCurrentEffect == CARDBOARD_GOOD_CHANCE)
            {
                myCardboardCost /= 2;
                myEventCoolDown = WEEK;
                resetPrices(1);
                myCurrentThing = "A new way of growing trees has been found CARDBOARD IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == PLASTIC_GOOD_CHANCE)
            {
                myPlasticCost /= 2;
                myPlarbinCost /= 2;
                myEventCoolDown = WEEK;
                resetPrices(7);
                myCurrentThing = "A huge deposit of oil has been found PLASTIC AND PLARBIN ARE HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == STEEL_GOOD_CHANCE)
            {
                mySteelCost /= 2;
                myEventCoolDown = WEEK;
                resetPrices(3);
                myCurrentThing = "A new way of turning energy into iron has been found STEEL IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == SANEZA_GOOD_CHANCE)
            {
                mySanezaCost /= 2;
                myEventCoolDown = WEEK;
                resetPrices(4);
                myCurrentThing = "Sterilazation is now better around the world SANEZA IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == THORBY_GOOD_CHANCE)
            {
                myThorbyCost /= 2;
                myEventCoolDown = WEEK;
                resetPrices(5);
                myCurrentThing = "It is international thorby week THORBY IS HALF THE PRICE";
            }//ends else if
            else if (myCurrentEffect == CARBON_GOOD_CHANCE)
            {
                myPlarbinCost /= 2;
                myEventCoolDown = WEEK;
                resetPrices(6);
                myCurrentThing = "A new carbon baised entity has been found and the world celebrates PLARBIN IS HALF THE PRICE";
            }//ends else if
            else if(myCurrentEffect == CARDBOARD_BAD_CHANCE)
            {
                myCardboardCost *= 2;
                myEventCoolDown = WEEK;
                resetPrices(1);
                myCurrentThing = "The world is notising a lack of trees CARDBOARD IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == PLASTIC_BAD_CHANCE)
            {
                myPlasticCost *= 2;
                myPlarbinCost *= 2;
                myEventCoolDown = WEEK;
                resetPrices(7);
                myCurrentThing = "Oil is running low PLASTIC AND PLARBIN ARE TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == STEEL_BAD_CHANCE)
            {
                mySteelCost *= 2;
                myEventCoolDown = WEEK;
                resetPrices(3);
                myCurrentThing = "The world is low on iron STEEL IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == SANEZA_BAD_CHANCE)
            {
                mySanezaCost *= 2;
                myEventCoolDown = WEEK;
                resetPrices(4);
                myCurrentThing = "A new disease has been found SANEZA IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == THORBY_BAD_CHANCE)
            {
                myThorbyCost *= 2;
                myEventCoolDown = WEEK;
                resetPrices(5);
                myCurrentThing = "The public has realized that thorby sucks THORBY IS TWICE THE PRICE";
            }//ends else if
            else if(myCurrentEffect == CARBON_BAD_CHANCE)
            {
                myPlarbinCost *= 2;
                myEventCoolDown = WEEK;
                resetPrices(6);
                myCurrentThing = "An endling has died the world vows to have a smaller carbon footprint PLARBIN IS TWICE THE PRICE";
            }//ends else if
            else
            {
                resetPrices(8);
                myCurrentThing = "Nothing is going on";
            }//ends else
        }//ends if
        return myCurrentThing;
    }//ends randomEvent
    
    /**
    * This will reset the prices that arn't changed.
    * @pre none
    * @pram none
    * @return none
    * @post myCosts
    */
    public void resetPrices(int i)
    {
        if(i == 0)
        {
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends if
        else if(i == 1)
        {
            myPaperCost = PAPER_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        else if(i == 2)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        else if(i == 3)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        else if(i == 4)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        else if(i == 5)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myPlarbinCost = PLARBIN_BASE_COST;
        }//ends else if
        else if(i == 6)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            myPlasticCost = PLASTIC_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
        }//ends else if
        else if(i == 7)
        {
            myPaperCost = PAPER_BASE_COST;
            myCardboardCost = CARDBOARD_BASE_COST;
            mySteelCost = STEEL_BASE_COST;
            mySanezaCost = SANEZA_BASE_COST;
            myThorbyCost = THORBY_BASE_COST;
        }//ends else if
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
    * @post myDay, myMonth, myDate
    */
    public void addDay()
    {
        //this will add to the date
        if(myDate <= DAYS_IN_YEAR)
        {
            myDate+=0.5;
            //this subtracts a day for myEventCoolDown
            if(myDate == (int)myDate && myEventCoolDown > 0)
            {
                myEventCoolDown--;
            }//ends if
        }//ends if
        else
        {
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
            myCurrentThing = "Nothing is going on";
            myMonth = "January";
        }//ends if
        else if(myDate <= FEB_END)
        {
            myMonth = "Febuary";
        }//ends else if
        else if(myDate <= MARCH_END)
        {
            myMonth = "March";
        }//ends else if
        else if(myDate <= APRIL_END)
        {
            myMonth = "April";
        }//ends else if
        else if(myDate <= MAY_END)
        {
            //this is for a holiday
            if(myDate <= MOTHERS_DAY && myDate > (MOTHERS_DAY - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 2;
                myCurrentThing = "Mothers Day everything gives 2 times the profit";
                myEventCoolDown = SHOPING_TIME_SMALL;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = "Nothing is going on";
            }//ends else
            myMonth = "May";
        }//ends else if
        else if(myDate <= JUNE_END)
        {
            //this is for a holiday
            if(myDate <= FATHERS_DAY && myDate > (FATHERS_DAY - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 1.5;
                myCurrentThing = "Fathers Day everything gives 1.5 times the profit";
                myEventCoolDown = SHOPING_TIME_SMALL;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = "Nothing is going on";
            }//ends else
            myMonth = "June";
        }//ends else if
        else if(myDate <= JULY_END)
        {
            myMonth = "July";
        }//ends else if
        else if(myDate <= AUG_END)
        {
            myMonth = "August";
        }//ends else if
        else if(myDate <= SEP_END)
        {
            myMonth = "September";
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
                myCurrentThing = "Nothing is going on";
            }//ends else
            myMonth = "October";
        }//ends else if
        else if(myDate <= NOV_END)
        {
            //this ends Halloween
            myHolidayBonus = 1;
            myCurrentThing = "Nothing is going on";
            //this is for a holiday
            if(myDate <= THANKSGIVING && myDate > (THANKSGIVING - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 2;
                myCurrentThing = "Thanksgiving everything gives 2 times the profit";
                myEventCoolDown = SHOPING_TIME_SMALL;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
                myCurrentThing = "Nothing is going on";
            }//ends else
            myMonth = "November";
        }//ends else if
        else if(myDate <= DEC_END)
        {
            //this is for a holiday
            if(myDate <= CHRISTMAS && myDate > (CHRISTMAS - SHOPING_TIME_BIG))
            {
                myHolidayBonus = 6;
                myCurrentThing = "Cristmas everything gives 6 times the profit";
                myEventCoolDown = SHOPING_TIME_BIG;
                resetPrices(8);
            }//ends if
            else
            {
                myHolidayBonus = 1;
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
        myMola = (double)Math.round(myMola * 10000) / 10000;
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
        myTotalMola = (double)Math.round(myTotalMola * 10000) / 10000;
    }//ends round
    
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
        myRandom.set(0, Math.random() * (PAPER_CHANGE * myHolidayBonus));
        myRandom.set(1, Math.random() * (CARDBOARD_CHANGE * myHolidayBonus));
        myRandom.set(2, Math.random() * (PLASTIC_CHANGE * myHolidayBonus));
        myRandom.set(3, Math.random() * (STEEL_CHANGE * myHolidayBonus));
        myRandom.set(4, Math.random() * (SANEZA_CHANGE * myHolidayBonus));
        myRandom.set(5, Math.random() * (THORBY_CHANGE * myHolidayBonus));
        myRandom.set(6, Math.random() * (PLARBIN_CHANGE * myHolidayBonus));
        //this desides if it is positive or negative
        for(int i = 0; i < BOX_NUM; i++)
        {
            if(Math.random() < FIFTY_FIFTY && myHolidayBonus == 1)
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
        if(myMola >= (myResearchCost + myPaperCost))
        {
            myMaxBuy++;
            myMola -= myResearchCost;
            myResearchCost += RESEARCH_INCREASE;
            myResearchCost = Math.round(myResearchCost * 1000) / 1000;
            round();
        }//ends if
    }//ends research
    
    /**
    * This allowes you to buy more box types.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public void researchType()
    {
        if(myMola >= (myResearchTypeCost + myPaperCost) && myTypeBuy < BOX_NUM)
        {
            myTypeBuy++;
            myMola -= myResearchTypeCost;
            myResearchTypeCost *= RESEARCH_TYPE_INCREASE;
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
        //this adds box_num null places to myRandom so it will have the spaces
        for(int i = 0; i < BOX_NUM; i++)
        {
            myRandom.add(null);
        }//ends fort
    }//ends createBoxes
    
    /**
    * This gets the day.
    * @pre none
    * @pram none
    * @return String
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
    * @pram none
    * @return the requested price amount
    * @post none
    */
    public double getPrice(int i)
    {
        if(i == 0)
        {
            return myPaperCost;
        }//ends if
        else if(i == 1)
        {
            return myCardboardCost;
        }//ends else if
        else if(i == 2)
        {
            return myPlasticCost;
        }//ends else if
        else if(i == 3)
        {
            return mySteelCost;
        }//ends else if
        else if(i == 4)
        {
            return mySanezaCost;
        }//ends else if
        else if(i == 5)
        {
            return myThorbyCost;
        }//ends else if
        else if(i == 6)
        {
            return myPlarbinCost;
        }//ends else if
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
    * @post none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
    * @return myDay
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
    * @pram none
    * @return myDay
    * @post none
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
    * @pram none
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
    * @pram none
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
        return myStock.get(0).getName() + " sells for $"  + (Math.round((myStock.get(0).getSell(1) + myRandom.get(0)) * 100)/ 100.0);
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
        return myStock.get(1).getName() + " sells for $"  + (Math.round((myStock.get(1).getSell(1) + myRandom.get(1)) * 100)/ 100.0);
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
        return myStock.get(2).getName() + " sells for $"  + (Math.round((myStock.get(2).getSell(1) + myRandom.get(2)) * 100)/ 100.0);
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
        return myStock.get(3).getName() + " sells for $"  + (Math.round((myStock.get(3).getSell(1) + myRandom.get(3)) * 100)/ 100.0);
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
        return myStock.get(4).getName() + " sells for $"  + (Math.round((myStock.get(4).getSell(1) + myRandom.get(4)) * 100)/ 100.0);
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
        return myStock.get(5).getName() + " sells for $"  + (Math.round((myStock.get(5).getSell(1) + myRandom.get(5)) * 100)/ 100.0);
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
        return myStock.get(6).getName() + " sells for $"  + (Math.round((myStock.get(6).getSell(1) + myRandom.get(6)) * 100)/ 100.0);
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
    * This sets myResearchCost.
    * @pre none
    * @pram none
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
    * @pram none
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
    * @pram none
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
    * @pram none
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