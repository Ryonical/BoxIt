
/**
 * This is the opposing AI.
 * 
 * @Ryan Keeler
 * @BoxIt
 */
public class AI
{
    public final int PLARBIN_CURSE = 13;
    public final int THORBY_CURSE = 12;
    public final int SANEZA_CURSE = 11;
    public final int STEEL_CURSE = 10;
    public final int PLASTIC_CURSE = 9;
    public final int CARDBOARD_CURSE = 8;
    
    public final int RESEARCH_CHECK = 2;
    public final int BOX_NUM = 7;
    public final int EFFECT_NUM = 15;
    BoxIt box = new BoxIt();
    private String[] myEffectArray;
    private String myCurrentEffect;
    private int myMola;
    private int myMaxBuy;
    private double myResearchCost;
    private double myTypeBuy;
    private int myResearchTypeCost;
    /**
    * This constructs.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public AI()
    {
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
        myMola = 0;
        myMaxBuy = 10;
        myResearchCost = 5;
        myTypeBuy = 0;
        myResearchTypeCost = 15;
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
        myCurrentEffect = box.getEffect();
        //this finds the moste efficeant thing to buy
        for(int i = 0; i < EFFECT_NUM / 2; i++)
        {
            if(myCurrentEffect == myEffectArray[i] && myResearchTypeCost >= i)
            {
                box.setType(i);
                box.buy(myMaxBuy);
            }//ends if
        }//ends for
        if(myMola >= myTypeBuy * RESEARCH_CHECK)
        {
            box.researchType();
            myTypeBuy = box.getResearchTypeCost();
            myResearchTypeCost = box.getTypeBuy();
        }//ends if
        else if(myMola >= myResearchCost * RESEARCH_CHECK)
        {
            box.research();
            myResearchCost = box.getResearchCost();
            myMaxBuy = box.getMaxBuy();
        }//ends else if
        else if(myResearchTypeCost >= 6 && myEffectArray[PLARBIN_CURSE] != myCurrentEffect)
        {
            box.setType(6);
            box.buy(myMaxBuy);
        }//ends else if
    }
}//ends AI
