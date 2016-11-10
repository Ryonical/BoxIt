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
    public final int STARTING_AMOUNT = 0;
        //paper
    public final double PAPER_SELL = .1;//This is the base price of paper
    public final double PAPER_COST = .05;//This is the base cost of paper
    public final double PAPER_CHANGE = 0.05;//This is how much the paper value can change
    public final int PAPER_STARTING_AMOUNT = 5;
        //cardboard
    public final double CARDBOARD_SELL = 1.25;//This is the base price of cardboard
    public final double CARDBOARD_COST = 1;//This is the base cost of cardboard
    public final double CARDBOARD_CHANGE = .2;//This is how much the cardboard value can change
        //plastic
    public final double PLASTIC_SELL = 5;//This is the base price of plastic
    public final double PLASTIC_COST = 3;//This is the base cost of plastic
    public final double PLASTIC_CHANGE = 0.5;//This is how much the plastic value can change
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
    public final double RESEARCH_TYPE_INCREASE = 4.0;
    //final answers
    public final String YES = "y";
    public final String BOX_BUILD = "build a box";
    public final String SAVE = "save";
    public final String EXIT = "exit";
    //gives random chance
    public final double FIFTY_FIFTY = .5;
    //this is myDate finals
    public final int SHOPING_TIME_SMALL = 7;
    public final int SHOPING_TIME_BIG = 28;
    public final int DAYS_IN_YEAR = 365;
    public final int JAN_END = 31;
    public final int FEB_END = 59;
    public final int MARCH_END = 90;
    public final int APRIL_END = 120;
    public final int MOTHERS_DAY = 128;
    public final int MAY_END = 151;
    public final int FATHERS_DAY = 170;
    public final int JUNE_END = 181;
    public final int JULY_END = 212;
    public final int AUG_END = 243;
    public final int SEP_END = 273;
    public final int OCT_END = 304;
    public final int THANKSGIVING = 328;
    public final int NOV_END = 334;
    public final int CRISTMAS = 359;
    public final int DEC_END = 365;
    //what you have in stock
    public ArrayList <Box> myStock;
    //this is the myDate
    private int myDate;
    private String myMonth;
    private String myDay;
    private double myHolidayBonus;
    //money
    private double myMola;//This is how much mola you have
    private double myTotalMola;//this is how much mola you have ever had
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
            myDate++;
        }//ends if
        else
        {
            myDate = 1;
        }//ends else
        //this rotates the day forward
        if(myDay.equals("Sunday"))
        {
            myDay = "Monday";
        }//ends if
        else if(myDay.equals("Monday"))
        {
            myDay = "Tuesday";
        }//ends else if
        else if(myDay.equals("Tuesday"))
        {
            myDay = "Wendsday";
        }//ends else if
        else if(myDay.equals("Wendsday"))
        {
            myDay = "Thursday";
        }//ends else if
        else if(myDay.equals("Thursday"))
        {
            myDay = "Friday";
        }//ends else if
        else if(myDay.equals("Friday"))
        {
            myDay = "Saturday";
        }//ends else if
        else if(myDay.equals("Saturday"))
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
            if(myDate <= CRISTMAS && myDate > (CRISTMAS - SHOPING_TIME_BIG))
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
        if(myMola >= (myResearchCost + PAPER_COST))
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
        if(myMola >= (myResearchTypeCost + PAPER_COST) && myTypeBuy < BOX_NUM)
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
        myStock.add(new Box(0, "paper", PAPER_COST, PAPER_SELL, PAPER_CHANGE, PAPER_STARTING_AMOUNT));
        myStock.add(new Box(1, "cardboard", CARDBOARD_COST, CARDBOARD_SELL, CARDBOARD_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(2, "plastic", PLASTIC_COST, PLASTIC_SELL, PLASTIC_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(3, "steel", STEEL_COST, STEEL_SELL, STEEL_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(4, "saneza", SANEZA_COST, SANEZA_SELL, SANEZA_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(5, "thorby", THORBY_COST, THORBY_SELL, THORBY_CHANGE, STARTING_AMOUNT));
        myStock.add(new Box(6, "plarbin", PLARBIN_COST, PLARBIN_SELL, PLARBIN_CHANGE, STARTING_AMOUNT));
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
            return myDay + ", January, " + (myDate);
        }//ends if
        else if(myDate <= FEB_END)
        {
            return myDay + ", Febuary, " + (myDate - JAN_END);
        }//ends else if
        else if(myDate <= MARCH_END)
        {
            return myDay + ", March, " + (myDate - FEB_END);
        }//ends else if
        else if(myDate <= APRIL_END)
        {
            return myDay + ", April, " + (myDate - MARCH_END);
        }//ends else if
        else if(myDate <= MAY_END)
        {
            return myDay + ", May, " + (myDate - APRIL_END);
        }//ends else if
        else if(myDate <= JUNE_END)
        {
            return myDay + ", June, " + (myDate - MAY_END);
        }//ends else if
        else if(myDate <= JULY_END)
        {
            return myDay + ", July, " + (myDate - JUNE_END);
        }//ends else if
        else if(myDate <= AUG_END)
        {
            return myDay + ", August, " + (myDate - JULY_END);
        }//ends else if
        else if(myDate <= SEP_END)
        {
            return myDay + ", September, " + (myDate - AUG_END);
        }//ends else if
        else if(myDate <= OCT_END)
        {
            return myDay + ", October, " + (myDate - SEP_END);
        }//ends else if
        else if(myDate <= NOV_END)
        {
            return myDay + ", November, " + (myDate - OCT_END);
        }//ends else if
        else if(myDate <= DEC_END)
        {
            return myDay + ", December, " + (myDate - NOV_END);
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
    }//ends getMola
    
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
    }//ends getMola
    
    /**
    * This gets myDate.
    * @pre none
    * @pram none
    * @return myDate
    * @post none
    */
    public int getDate()
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
    public void setDate(int date)
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
    * This gets myStock 0 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getPaperAmount()
    {
        return myStock.get(0).getAmount();
    }//ends getPaperAmount
    
    /**
    * This sets myStock 0 amount.
    * @pre none
    * @pram none
    * @return none
    * @post a part of myAmount
    */
    public void setPaperAmount(int stock)
    {
        myStock.get(0).setAmount(stock);
    }//ends setPaperAmount
    
    /**
    * This gets myStock 1 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getCardboardAmount()
    {
        return myStock.get(1).getAmount();
    }//ends getCardboardAmount
    
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
    * This gets myStock 2 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getPlasticAmount()
    {
        return myStock.get(2).getAmount();
    }//ends getPlasticAmount
    
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
    * This gets myStock 3 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getSteelAmount()
    {
        return myStock.get(3).getAmount();
    }//ends getSteelAmount
    
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
    * This gets myStock 4 amount.
    * @pre none
    * @pram none
    * @return a part of myAmount
    * @post none
    */
    public int getSanezaAmount()
    {
        return myStock.get(4).getAmount();
    }//ends getSanezaAmount
    
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