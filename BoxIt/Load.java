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
    private File fileBox = null;
    private File fileString = null;
    private Scanner inFileInt = null;
    private Scanner inFileDouble = null;
    private Scanner inFileBox = null;
    private Scanner inFileString = null;

    //vars
    private ArrayList <Integer> mySaveInt;
    private ArrayList <Double> mySaveDouble;
    private ArrayList <Integer> mySaveBox;
    private ArrayList <String> mySaveString;
    
    private String myEffect;
    public final int STRIMG_NUM = 3;

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
            fileInt = new File("saves//saveInt.txt");
            inFileInt = new Scanner(fileInt);
            fileDouble = new File("saves//saveDouble.txt");
            inFileDouble = new Scanner(fileDouble);
            fileBox = new File("saves//saveBox.txt");
            inFileBox = new Scanner(fileBox);
            fileString = new File("saves//saveString.txt");
            inFileString = new Scanner(fileString);
        }catch(Exception e)
        {
            System.out.println(e);
        }

        box = box2;
        mySaveInt = new ArrayList<Integer>();
        mySaveDouble = new ArrayList<Double>();
        mySaveBox = new ArrayList<Integer>();
        mySaveString = new ArrayList<String>();
        myEffect = "";
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
        int i = 0;
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
            if(fileBox != null)
            {
                while(inFileBox.hasNext())
                {
                    mySaveBox.add(Integer.valueOf(inFileBox.nextInt()).intValue());
                }//ends while
            }//ends if    
            //string
            if(fileString != null)
            {
                while(inFileString.hasNext())
                {
                    if(i < STRIMG_NUM)
                    {
                        mySaveString.add(inFileString.next());
                    }//ends if
                    else
                    {
                        myEffect = myEffect + " " +mySaveString.add(inFileString.next());
                    }
                }//ends while
                mySaveString.add(myEffect);
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
        int countBox = 0;
        int countString = 0;
        
        //the input for ints
        box.setMaxBuy(mySaveInt.get(countInt));
        countInt++;
        box.setTypeBuy(mySaveInt.get(countInt));
        countInt++;
        box.setCoolDown(mySaveInt.get(countInt));
        countInt++;
        
        
        //the input for doubles
        box.setMola(mySaveDouble.get(countDouble));
        countDouble++;
        box.setTotalMola(mySaveDouble.get(countDouble));
        countDouble++;
        box.setResearchCost(mySaveDouble.get(countDouble));
        countDouble++;
        box.setResearchTypeCost(mySaveDouble.get(countDouble));
        countDouble++;
        box.setDate(mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(0, mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(1, mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(2, mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(3, mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(4, mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(5, mySaveDouble.get(countDouble));
        countDouble++;
        box.setCosts(6, mySaveDouble.get(countDouble));
        countDouble++;
        
        //the input for boxes
        box.setBoxAmount(0, mySaveBox.get(countBox));
        countBox++;
        box.setBoxAmount(1, mySaveBox.get(countBox));
        countBox++;
        box.setBoxAmount(2, mySaveBox.get(countBox));
        countBox++;
        box.setBoxAmount(3, mySaveBox.get(countBox));
        countBox++;
        box.setBoxAmount(4, mySaveBox.get(countBox));
        countBox++;
        box.setBoxAmount(5, mySaveBox.get(countBox));
        countBox++;
        box.setBoxAmount(6, mySaveBox.get(countBox));
        countBox++;
        //the input for strings
        box.setDay(mySaveString.get(countString));
        countString++;
        box.setMonth(mySaveString.get(countString));
        countString++;
        box.setEffect(mySaveString.get(countString).replaceAll("_", " "));
        countString++;
    }//ends load
}//ends Save
