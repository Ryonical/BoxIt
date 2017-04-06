import java.util.*;
/**
 * This is the opposing AI.
 * 
 * @Ryan Keeler
 * @BoxIt
 */
public class AI
{
    //when not to buy
    public final int PLARBIN_CURSE = 13;
    public final int THORBY_CURSE = 12;
    public final int SANEZA_CURSE = 11;
    public final int STEEL_CURSE = 10;
    public final int PLASTIC_CURSE = 9;
    public final int CARDBOARD_CURSE = 8;
    
    public final int RESEARCH_CHECK = 2;
    public final double RESEARCH_BOX_CHECK = 1.5;
    public final int BOX_NUM = 7;
    public final int FOLD_NUM = 5;
    public final int EFFECT_NUM = 15;
    //when to sell
    public final double[] WHEN_TO_SELL;
    public final double PAPER_SELL = 0.13;
    public final double CARDBOARD_SELL = 1.35;
    public final double PLASTIC_SELL = 5.30;
    public final double STEEL_SELL = 12.00;
    public final double SANEZA_SELL = 12.00;
    public final double THORBY_SELL = 35.00;
    public final double PLARBIN_SELL = 32.00;
    
    public final double FOLD_TWO_COST = .5;//the cost for the second cost
    public final double FOLD_THREE_COST = 1;//the cost for the third cost
    public final double FOLD_FOUR_COST = 3;//the cost for the fourth cost
    public final double FOLD_FIVE_COST = 7;//the cost for the fifth cost
    
    public final double[] FOLD_COST;
    
    
    //this is the multiplyer of the folds
    public final double FOLD_TWO_BONUS = 1.25;
    public final double FOLD_THREE_BONUS = 1.5;
    public final double FOLD_FOUR_BONUS = 1.75;
    public final double FOLD_FIVE_BONUS = 2;
    
    public final double[] FOLD_MULT;
    
    BoxIt box;
    private ArrayList<Box> myStock;
    private ArrayList<Double> myRandom;
    private String[] myEffectArray;
    private String myCurrentEffect;
    private double myMola;
    private int myMaxBuy;
    private double myResearchCost;
    private int myTypeBuy;
    private double myResearchTypeCost;
    private double myFoldMoneyMake;
    private int myFoldMoneyPick;
    private double myMoneyMake;
    private int myMoneyPick;
    private boolean canGo;
    /**
    * This constructs.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public AI(BoxIt boxy)
    {
        box = boxy;
        myEffectArray = new String[EFFECT_NUM];
        //sets myEffectArray
        myEffectArray[0] = "No Paper";
        myEffectArray[1] = "A new way of growing trees has been found CARDBOARD IS HALF THE PRICE";
        myEffectArray[2] = "A huge deposit of oil has been found PLASTIC AND PLARBIN ARE HALF THE PRICE";
        myEffectArray[3] = "A new way of turning energy into iron has been found STEEL IS HALF THE PRICE";
        myEffectArray[4] = "Sterilazation is now better around the world SANEZA IS HALF THE PRICE";
        myEffectArray[5] = "It is international thorby week THORBY IS HALF THE PRICE";
        myEffectArray[6] = "A new carbon baised entity has been found and the world celebrates PLARBIN IS HALF THE PRICE";
        myEffectArray[7] = "No Paper";
        myEffectArray[8] = "The world is notising a lack of trees CARDBOARD IS TWICE THE PRICE";
        myEffectArray[9] = "Oil is running low PLASTIC AND PLARBIN ARE TWICE THE PRICE";
        myEffectArray[10] = "The world is low on iron STEEL IS TWICE THE PRICE";
        myEffectArray[11] = "A new disease has been found SANEZA IS TWICE THE PRICE";
        myEffectArray[12] = "The public has realized that thorby sucks THORBY IS TWICE THE PRICE";
        myEffectArray[13] = "An endling has died the world vows to have a smaller carbon footprint PLARBIN IS TWICE THE PRICE";
        myEffectArray[14] = "Nothing is going on";
        myCurrentEffect = "";
        WHEN_TO_SELL = new double[BOX_NUM];
        WHEN_TO_SELL[0] = PAPER_SELL;
        WHEN_TO_SELL[1] = CARDBOARD_SELL;
        WHEN_TO_SELL[2] = PLASTIC_SELL;
        WHEN_TO_SELL[3] = STEEL_SELL;
        WHEN_TO_SELL[4] = SANEZA_SELL;
        WHEN_TO_SELL[5] = THORBY_SELL;
        WHEN_TO_SELL[6] = PLARBIN_SELL;
        FOLD_COST = new double[FOLD_NUM];
        FOLD_COST[0] = 0;
        FOLD_COST[1] = FOLD_TWO_COST;
        FOLD_COST[2] = FOLD_THREE_COST;
        FOLD_COST[3] = FOLD_FOUR_COST;
        FOLD_COST[4] = FOLD_FIVE_COST;
        
        FOLD_MULT = new double[FOLD_NUM];
        FOLD_MULT[0] = 1;
        FOLD_MULT[1] = FOLD_TWO_BONUS;
        FOLD_MULT[2] = FOLD_THREE_BONUS;
        FOLD_MULT[3] = FOLD_FOUR_BONUS;
        FOLD_MULT[4] = FOLD_FIVE_BONUS;
        myStock = box.getStock();
        myMola = 0;
        myResearchCost = box.getResearchCost();
        myMaxBuy = box.getMaxBuy();
        myTypeBuy = box.getTypeBuy();
        myResearchTypeCost = box.getResearchTypeCost();
        myFoldMoneyMake = 0.0;
        myFoldMoneyPick = -1;
        myMoneyMake = 0.0;
        myMoneyPick = -1;
  
        canGo = false;
    }
    
    /**
    * This decides which move to make.
    * @pre none
    * @pram none
    * @return none
    * @post myPick
    */
    public void makeMove()
    {
        myRandom = box.getRandom();
        canGo = true;
        myStock = box.getStock();
        myCurrentEffect = box.getEffect();
        myFoldMoneyMake = 0.0;
        myFoldMoneyPick = -1;
        myMoneyMake = 0.0;
        myMoneyPick = -1;
        myMola = box.getMola();
        
        //this finds the most efficeant thing to buy
        for(int i = 0; i < EFFECT_NUM / 2 && canGo; i++)
        {
            if(myCurrentEffect == myEffectArray[i] && myResearchTypeCost >= i && myMola >= myStock.get(i).getCost() * myMaxBuy)
            {
                box.setType(i);
                box.buy(myMaxBuy);
                canGo = false;
            }//ends if
        }//ends for
        
        //this is to research box
        if(myMola >= myResearchTypeCost * RESEARCH_BOX_CHECK && canGo)
        {
            box.researchType();
            myResearchTypeCost = box.getResearchTypeCost();
            myTypeBuy = box.getTypeBuy();
            canGo = false;
        }//ends if
        
        //this is to sell
        for(int i = 0; i < BOX_NUM && canGo; i ++)
        {
            if(myMoneyMake < myStock.get(i).getTotalSell() && myStock.get(i).getSell(1) + myRandom.get(i) >= WHEN_TO_SELL[i])
            {
                myMoneyMake = myStock.get(i).getTotalSell();
                myMoneyPick = i;
            }//ends if
        }//ends for
        if(myMoneyPick != -1 && canGo)
        {
            box.setType(myMoneyPick);
            box.sell(myMaxBuy);
            canGo = false;
        }//ends if
        
        //this is to fold
        for(int i = BOX_NUM - 1; i >= 0 && canGo; i--)
        {
            if(myStock.get(i).getAmount() >= myMaxBuy)
            {
                for(int j = 0; j < FOLD_NUM; j++)
                {
                    //this checks to see the ratio of folding prices and finds the best I think
                    if(myFoldMoneyMake < (myStock.get(i).getSell(i) * FOLD_MULT[j]) / (myStock.get(i).getCost() + FOLD_COST[j]))
                    {
                        myFoldMoneyMake = (myStock.get(i).getSell(i) * FOLD_MULT[j]) / (myStock.get(i).getCost() + FOLD_COST[j]);
                        myFoldMoneyPick = j;
                    }
                }//ends if
                //this folds the one that has been picked
                if(canGo && myFoldMoneyPick != -1 && myTypeBuy >= i)
                {
                    if(myMola >= myMaxBuy * FOLD_COST[myFoldMoneyPick])
                    {
                        box.setType(i);
                        box.fold(myFoldMoneyPick + 1);
                        canGo = false;
                    }//ends if
                    else
                    {
                        box.setType(i);
                        box.fold(1);
                        canGo = false;
                    }//ends if
                }//ends if
                else if(canGo)
                {
                    box.setType(i);
                    box.fold(1);
                    canGo = false;
                }//ends else
            }
        }//ends for
        
        //this is to buy
        for(int i = BOX_NUM - 1; i >= 0 && canGo; i--)
        {
            if(myTypeBuy >= i)
            {
                if(myEffectArray[BOX_NUM + i] != myCurrentEffect)
                {
                    if(myMola >= myStock.get(i).getCost() * myMaxBuy)
                    {
                        box.setType(i);
                        box.buy(myMaxBuy);
                        canGo = false;
                    }
                }
            }//ends if
        }//ends for
        
        //this is to basic research
        if(myMola >= myResearchCost * RESEARCH_CHECK && canGo)
        {
            box.research();
            myResearchCost = box.getResearchCost();
            myMaxBuy = box.getMaxBuy();
            canGo = false;
        }//ends if
        //these are the last things to go mostly to be used in the biggineing
        //buys
        if(canGo && myMola >= myStock.get(0).getCost())
        {
            box.setType(0);
            box.buy(myMaxBuy);
            canGo = false;
        }//ends if
        //folds
        else if(canGo && myStock.get(0).getAmount() > 0)
        {
            box.setType(0);
            box.fold(1);
            canGo = false;
        }//ends else if
        //sells
        else if(canGo)
        {
            box.setType(0);
            box.sell(myMaxBuy);
            canGo = false;
        }//ends if
    }//ends makeMove
}//ends AI
