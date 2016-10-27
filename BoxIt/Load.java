import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * This will drive world clicker 2.
 * 
 * @Ryan Keeler
 * @World Of Dlicker
 */
public class Load
{
    //to save
    private File fileInt = null;
    private File fileDouble = null;
    private File fileAmount = null;
    private Scanner inFileInt = null;
    private Scanner inFileDouble = null;
    private Scanner inFileAmount = null;

    //vars
    private ArrayList <Integer> mySaveInt;
    private ArrayList <Double> mySaveDouble;
    private ArrayList <Integer> mySaveAmount;

    //classes
    BoxIt box;
    /**
     * This will construct.
     * pre none
     * pram none
     * return none
     * post all
     */
    public Load(BoxIt box2)
    {
        try
        {
            fileInt = new File("saveInt.txt");
            inFileInt = new Scanner(fileInt);
            fileDouble = new File("saveDouble.txt");
            inFileDouble = new Scanner(fileDouble);
            fileAmount = new File("saveAmount.txt");
            inFileAmount = new Scanner(fileAmount);
        }catch(Exception e)
        {
            System.out.println(e);
        }

        box = box2;
        mySaveInt = new ArrayList<Integer>();
        mySaveDouble = new ArrayList<Double>();
        mySaveAmount = new ArrayList<Integer>();
    }//ends constructer

    /**
     * This will read everything.
     * pre none
     * pram none
     * return none
     * post none
     */
    public void reader()
    {
        try
        {
            //ints
            if(fileInt != null)
            {
                while(inFileInt.hasNext())
                {
                    mySaveInt.add(Integer.valueOf(inFileInt.nextInt()).intValue());
                }//ends while
            }//ends if
            //doubles
            if(fileDouble != null)
            {
                while(inFileDouble.hasNext())
                {
                    mySaveDouble.add(Double.valueOf(inFileDouble.nextDouble()).doubleValue());
                }//ends while
            }//ends if
            //boxes
            if(fileAmount != null)
            {
                while(inFileAmount.hasNext())
                {
                    mySaveAmount.add(Integer.valueOf(inFileAmount.nextInt()).intValue());
                }//ends while
            }//ends if            
        }//ends try
        catch(Exception e)
        {
            System.out.println(e);
        }//ends catch
    }//ends reader
    
    /**
     * This will save everything that needs to be saved.
     * pre none
     * pram none
     * return none
     * post none
     */
    public void load()
    {
        //so I can add vars later
        int countInt = 0;
        int countDouble = 0;
        int countAmount = 0;
        //the input for ints
        box.setMaxBuy(mySaveInt.get(countInt));
        countInt++;
        
        //the input for doubles
        box.setMola(mySaveDouble.get(countDouble));
        countDouble++;
        
        //the input for boxes
        box.setPaperAmount(mySaveAmount.get(countAmount));
        countAmount++;
        box.setCardboardAmount(mySaveAmount.get(countAmount));
        countAmount++;
        box.setPlasticAmount(mySaveAmount.get(countAmount));
        countAmount++;
        box.setSteelAmount(mySaveAmount.get(countAmount));
        countAmount++;
        box.setSanezaAmount(mySaveAmount.get(countAmount));
        countAmount++;
        box.setThorbyAmount(mySaveAmount.get(countAmount));
        countAmount++;
        box.setPlarbinAmount(mySaveAmount.get(countAmount));
        countAmount++;
    }//ends load
}//ends Save
