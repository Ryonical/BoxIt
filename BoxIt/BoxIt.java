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
    public final double PAPER_SELL = .1;//This is the base price of paper
    public final double PAPER_CHANGE = 0.05;//This is how much the paper value can change
    public final int PAPER_STARTING_AMOUNT = 5;//this is how many paper boxes you have
        //cardboard
    public final double CARDBOARD_SELL = 1.25;//This is the base price of cardboard
    public final double CARDBOARD_CHANGE = .2;//This is how much the cardboard value can change
    public final double CARDBOARD_BASE_CHANCE = 1;//this is the base price of carbon
        //plastic
    public final double PLASTIC_SELL = 5;//This is the base price of plastic
    public final double PLASTIC_CHANGE = 0.5;//This is how much the plastic value can change
        //steel
    public final double STEEL_SELL = 10;//This is the base price of steel
    public final double STEEL_CHANGE = 2.5;//This is how much the steel value can change
        //sabeza
    public final double SANEZA_SELL = 7.5;//This is the base price of saneza
    public final double SANEZA_CHANGE = 1.75;//This is how much the saneza value can change
        //thorby
    public final double THORBY_SELL = 20;//This is the base price of thorby
    public final double THORBY_CHANGE = 15;//This is how much the thorby value can change
        //plarbin
    public final double PLARBIN_SELL = 30;//This is the base price of plarbin
    public final double PLARBIN_CHANGE = 5.0;//This is how much the plarbin value can change
    //keeps track of how many boxes there are
    public final int BOX_NUM = 7;//this is how many box types there are
    //research finals
    public final double RESEARCH_INCREASE = 2;//this is how much the price to reserch is multiplied each time
    public final double RESEARCH_TYPE_INCREASE = 4.0;//this is the multiplyer for getting a new box
    //gives random chance
    public final double FIFTY_FIFTY = .5;//this is the chance that a price will be up or down
    public final double RANDOM_EVENT = 100;//this is the chance of something happening
    //this is myDate finals
    public final int SHOPING_TIME_SMALL = 7;//this is how long a short holliday lasts
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
    public final int OCT_END = 304;//when october endsd
    public final int THANKSGIVING = 328;//when thatksgiving is
    public final int NOV_END = 334;//when november ends
    public final int CHRISTMAS = 359;//when christmas is
    public final int DEC_END = 365;//when the year ends
    //random events
    public final int WEEK = 7;
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
    //base costs
    private double myPaperCost;//This is the base cost of paper
    private double myCardboardCost;//This is the base cost of cardboard
    private double myPlasticCost;//This is the base cost of plastic
    private double mySteelCost;//This is the base cost of steel
    private double mySanezaCost;//This is the base cost of saneza
    private double myThorbyCost;//This is the base cost of thorby
    private double myPlarbinCost;//This is the base cost of plarbin
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
    private String myCurrentThing;
    /**
    * This constructs.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public BoxIt()
    {
        myPaperCost = .05;
        myCardboardCost = 1;
        myPlasticCost = 3;
        mySteelCost = 6;
        mySanezaCost = 4.5;
        myThorbyCost = 20;
        myPlarbinCost = 15;
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
    * @pram none
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
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() - i);
            myMola += (myStock.get(myType).getSell() + myRandom.get(myType)) * i;
            myTotalMola += (myStock.get(myType).getSell() + myRandom.get(myType)) * i;
        }//ends if
        //this is if you want to sell more than you have
        else if (myType != BOX_NUM + 1)
        {
            i = myStock.get(myType).getAmount();
            myStock.get(myType).setAmount(myStock.get(myType).getAmount() - i);
            myMola += (myStock.get(myType).getSell() + myRandom.get(myType)) * i;
            myTotalMola += (myStock.get(myType).getSell() + myRandom.get(myType)) * i;
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
            myCardboardCost = 1;
            myPlasticCost = 3;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
            myPlarbinCost = 15;
        }//ends if
        else if(i == 1)
        {
            myPaperCost = .05;
            myPlasticCost = 3;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
            myPlarbinCost = 15;
        }//ends else if
        else if(i == 2)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
            myPlarbinCost = 15;
        }//ends else if
        else if(i == 3)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            myPlasticCost = 3;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
            myPlarbinCost = 15;
        }//ends else if
        else if(i == 4)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            myPlasticCost = 3;
            mySteelCost = 6;
            myThorbyCost = 20;
            myPlarbinCost = 15;
        }//ends else if
        else if(i == 5)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            myPlasticCost = 3;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myPlarbinCost = 15;
        }//ends else if
        else if(i == 6)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            myPlasticCost = 3;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
        }//ends else if
        else if(i == 7)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
        }//ends else if
        else if(i == 8)
        {
            myPaperCost = .05;
            myCardboardCost = 1;
            myPlasticCost = 3;
            mySteelCost = 6;
            mySanezaCost = 4.5;
            myThorbyCost = 20;
            myPlarbinCost = 15;
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
            }//ends if
            else
            {
                myHolidayBonus = 1;
            }//ends else
            myMonth = "May";
        }//ends else if
        else if(myDate <= JUNE_END)
        {
            //this is for a holiday
            if(myDate <= FATHERS_DAY && myDate > (FATHERS_DAY - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 1.5;
            }//ends if
            else
            {
                myHolidayBonus = 1;
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
            myMonth = "October";
        }//ends else if
        else if(myDate <= NOV_END)
        {
            //this is for a holiday
            if(myDate <= THANKSGIVING && myDate > (THANKSGIVING - SHOPING_TIME_SMALL))
            {
                myHolidayBonus = 2;
            }//ends if
            else
            {
                myHolidayBonus = 1;
            }//ends else
            myMonth = "November";
        }//ends else if
        else if(myDate <= DEC_END)
        {
            //this is for a holiday
            if(myDate <= CHRISTMAS && myDate > (CHRISTMAS - SHOPING_TIME_BIG))
            {
                myHolidayBonus = 6;
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
        myStock.add(new Box(0, "paper", myPaperCost, PAPER_SELL, PAPER_CHANGE, PAPER_STARTING_AMOUNT));
        myStock.add(new Box(1, "cardboard", myCardboardCost, CARDBOARD_SELL, CARDBOARD_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(2, "plastic", myPlasticCost, PLASTIC_SELL, PLASTIC_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(3, "steel", mySteelCost, STEEL_SELL, STEEL_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(4, "saneza", mySanezaCost, SANEZA_SELL, SANEZA_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(5, "thorby", myThorbyCost, THORBY_SELL, THORBY_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(6, "plarbin", myPlarbinCost, PLARBIN_SELL, PLARBIN_CHANGE, STARTING_AMOUNT));
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
        return "ERROR";
    }//ends getTheDay
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends getPaperAmount
    
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
    }//ends setPaperAmount
    
    /**
    * This sets myStock 1 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setCardboardAmount(int stock)
    {
        myStock.get(1).setAmount(stock);
    }//ends setCardboardAmount
    
    /**
    * This sets myStock 2 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setPlasticAmount(int stock)
    {
        myStock.get(2).setAmount(stock);
    }//ends setPlasticAmount
    
    /**
    * This sets myStock 3 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setSteelAmount(int stock)
    {
        myStock.get(3).setAmount(stock);
    }//ends setSteelAmount
    
    /**
    * This sets myStock 4 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setSanezaAmount(int stock)
    {
        myStock.get(4).setAmount(stock);
    }//ends setSanezaAmount
    
    /**
    * This gets myStock 5 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getThorbyAmount()
    {
        return myStock.get(5).getAmount();
    }//ends getThorbyAmount
    
    /**
    * This sets myStock 5 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setThorbyAmount(int stock)
    {
        myStock.get(5).setAmount(stock);
    }//ends setThorbyAmount
    
    /**
    * This gets myStock 6 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getPlarbinAmount()
    {
        return myStock.get(6).getAmount();
    }//ends getPlarbinAmount
    
    /**
    * This sets myStock 6 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setPlarbinAmount(int stock)
    {
        myStock.get(6).setAmount(stock);
    }//ends setPlarbinAmount
    
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
        return myStock.get(0).getName() + " sells for $"  + (Math.round((myStock.get(0).getSell() + myRandom.get(0)) * 100)/ 100.0);
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
        return myStock.get(1).getName() + " sells for $"  + (Math.round((myStock.get(1).getSell() + myRandom.get(1)) * 100)/ 100.0);
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
        return myStock.get(2).getName() + " sells for $"  + (Math.round((myStock.get(2).getSell() + myRandom.get(2)) * 100)/ 100.0);
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
        return myStock.get(3).getName() + " sells for $"  + (Math.round((myStock.get(3).getSell() + myRandom.get(3)) * 100)/ 100.0);
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
        return myStock.get(4).getName() + " sells for $"  + (Math.round((myStock.get(4).getSell() + myRandom.get(4)) * 100)/ 100.0);
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
        return myStock.get(5).getName() + " sells for $"  + (Math.round((myStock.get(5).getSell() + myRandom.get(5)) * 100)/ 100.0);
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
        return myStock.get(6).getName() + " sells for $"  + (Math.round((myStock.get(6).getSell() + myRandom.get(6)) * 100)/ 100.0);
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
    }//ends myTypeBuy
    
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