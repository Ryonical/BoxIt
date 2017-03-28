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
    public final int BOX_NUM = 7;
    public final int FOLD_NUM = 5;
    public final int EFFECT_NUM = 15;
    //when to sell
    public final double[] WHEN_TO_SELL;
    public final double PAPER_SELL = 0.14;
    public final double CARDBOARD_SELL = 1.40;
    public final double PLASTIC_SELL = 5.40;
    public final double STEEL_SELL = 12.10;
    public final double SANEZA_SELL = 12.00;
    public final double THORBY_SELL = 35.00;
    public final double PLARBIN_SELL = 32.50;
    
    public final double FOLD_TWO_COST = .5;//the cost for the second cost
    public final double FOLD_THREE_COST = 1;//the cost for the third cost
    public final double FOLD_FOUR_COST = 3;//the cost for the fourth cost
    public final double FOLD_FIVE_COST = 7;//the cost for the fifth cost
    
    public final double[] FOLD;
    
    BoxIt box;
    private ArrayList<Box> myStock;
    private ArrayList<Double> myRandom;
    private String[] myEffectArray;
    private String myCurrentEffect;
    private int myMola;
    private int myMaxBuy;
    private double myResearchCost;
    private double myTypeBuy;
    private int myResearchTypeCost;
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
        FOLD = new double[FOLD_NUM];
        FOLD[0] = 0;
        FOLD[1] = FOLD_TWO_COST;
        FOLD[2] = FOLD_THREE_COST;
        FOLD[3] = FOLD_FOUR_COST;
        FOLD[4] = FOLD_FIVE_COST;
        
        myStock = box.getStock();
        myRandom = box.getRandom();
        myMola = 0;
        myMaxBuy = 10;
        myResearchCost = 5;
        myTypeBuy = 0;
        myResearchTypeCost = 15;
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
        canGo = true;
        myStock = box.getStock();
        myCurrentEffect = box.getEffect();
        myFoldMoneyMake = 0.0;
        myFoldMoneyPick = -1;
        myMoneyMake = 0.0;
        myMoneyPick = -1;
        
        //this finds the moste efficeant thing to buy
        for(int i = 0; i < EFFECT_NUM / 2 && canGo; i++)
        {
            if(myCurrentEffect == myEffectArray[i] && myResearchTypeCost >= i)
            {
                box.setType(i);
                box.buy(myMaxBuy);
                canGo = false;
            }//ends if}}
        }//ends for
        
        //this is to research
        if(myMola >= myTypeBuy * RESEARCH_CHECK && canGo)
        {
            box.researchType();
            myTypeBuy = box.getResearchTypeCost();
            myResearchTypeCost = box.getTypeBuy();
            canGo = false;
        }//ends if
        else if(myMola >= myResearchCost * RESEARCH_CHECK && canGo)
        {
            box.research();
            myResearchCost = box.getResearchCost();
            myMaxBuy = box.getMaxBuy();
            canGo = false;
        }//ends else if
        
        //this is to buy
        for(int i = BOX_NUM - 1; i >= 0; i++)
        {
            if(myResearchTypeCost >= i && myEffectArray[BOX_NUM + i] != myCurrentEffect)
            {
                box.setType(i);
                box.buy(myMaxBuy);
                canGo = false;
            }//ends if
        }//ends for
        
        //this is to fold
        for(int i = BOX_NUM - 1; i >= 0 && canGo; i++)
        {
            for(int j = 0; j < FOLD_NUM; j++)
            {
                //this checks to see the ratio of folding prices and finds the best I think
                if(myFoldMoneyMake < (myStock.get(i).getCost() + FOLD[j]) / (myStock.get(i).getSell(i) * myRandom.get(i)))
                {
                    myFoldMoneyMake = (myStock.get(i).getCost() + FOLD[j]) / (myStock.get(i).getSell(i) * myRandom.get(i));
                    myFoldMoneyPick = j;
                }
            }//ends if
            //this folds the one that has been picked
            if(myStock.get(i).getAmount() >= myMaxBuy && canGo)
            {
                box.setType(i);
                box.fold(myFoldMoneyPick);
                canGo = false;
            }//ends if
        }//ends for
        
        //this is to sell
        for(int i = 0; i < BOX_NUM && canGo; i ++)
        {
            if(myMoneyMake < myStock.get(i).getTotalSell())
            {
                myMoneyMake = myStock.get(i).getTotalSell();
                myMoneyPick = i;
            }//ends if
        }//ends for
        if(myMoneyPick != -1)
        {
            box.setType(myMoneyPick);
            box.sell(myMaxBuy);
            canGo = false;
        }//ends if
    }//ends makeMove
}//ends AI
