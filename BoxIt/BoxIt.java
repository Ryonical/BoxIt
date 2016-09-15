import java.util.Scanner;
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
    public final double PAPERCOST = .05;//This is the base cost of paper
    public final double PAPERCHANGE = .05;//This is how much the paper value can change
    public final double CARDBOARDPRICE = 1;//This is the base price of cardboard
    public final double CARDBOARDCOST = 1;//This is the base cost of cardboard
    public final double CARDBOARDCHANGE = .2;//This is how much the cardboard value can change
    public final double PLASTICPRICE = 1.5;//This is the base price of plastic
    public final double PLASTICCHANGE = .3;//This is how much the plastic value can change
    public final double STEELPRICE = 4;//This is the base price of steel
    public final double STEELCHANGE = .7;//This is how much the steel value can change
    //final answers
    public final char YES = 'y';
    
    //money
    private double myMoney;//This is how much money you have
    
    //player name
    private String myName;
    
    //input
    private String myAnswer; 
    /**
    * This construct.
    * @pre none
    * @pram none
    * @return none
    * @post all
    */
    public BoxIt()
    {
        myMoney = 10;
        myName = " ";
        myAnswer = " ";
    }//ends constructer
    
    public void game()
    {
        System.out.println("What is your name");
        myName = in.nextLine();
        System.out.println("Are you sure that " + myName + " will be your name y/n");
        myAnswer = in.nextLine();
        while(myAnswer.charAt(0) != YES)
        {
            System.out.println("Ok name yourself again");
            myName = in.nextLine();
            System.out.println("Are you sure that " + myName + " will be your name y/n");
            myAnswer = in.nextLine();
        }//ends while
        
        
        System.out.println("sucsess, " + myName);
        while(myMoney > 0)
        {
        	System.out.println();
        }//ends while
        
    }//ends game
}//ends BoxIt