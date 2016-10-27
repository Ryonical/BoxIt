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
    private Scanner inFileInt = null;
    private Scanner inFileDouble = null;

    //vars
    private ArrayList <Integer> mySaveInt;
    private ArrayList <Double> mySaveDouble;

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
        }catch(Exception e)
        {
            System.out.println(e);
        }

        box = box2;
        mySaveInt = new ArrayList<Integer>();
        mySaveDouble = new ArrayList<Double>();
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
        int countBool = 0;
        //the input for ints
        box.setMaxBuy(mySaveInt.get(countInt));
        countInt++;
        
        //the input for doubles
        box.setMola(mySaveDouble.get(countDouble));
        countDouble++;
    }//ends load
}//ends Save
