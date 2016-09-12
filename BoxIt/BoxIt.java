import java.util.*;
/**
 * This is the bulk of BoxIt.
 * 
 * @Ryan Keeler
 * @BoxIt
 */
public class BoxIt
{
    //input
    Scanner in = new Scanner(System.in);
    //prices
    public final double PAPERPRICE = .2;//This is the base price of paper
    public final double PAPERCHANGE = .05;//This is how much the paper value can change
    public final double CARDBOARDPRICE = 1;//This is the base price of cardboard
    public final double CARDBOARDCHANGE = .2;//This is how much the cardboard value can change
    public final double PLASTICPRICE = 1.5;//This is the base price of plastic
    public final double PLASTICCHANGE = .3;//This is how much the plastic value can change
    
    //money
    private double myMoney;//This is how much money you have
    
    //player name
    private String myName;
    /**
    * This construct.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public BoxIt()
    {
        myMoney = 0;
    }
    
    public void game()
    {
        System.out.println("What is your name");
        myName = in.next();
        System.out.println(myName);
    }
}//ends BoxIt