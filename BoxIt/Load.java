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
    public final int FOLD_COUNT = 5;
    //to save
    private File fileInt = null;
    private File fileDouble = null;
    private File fileBox = null;
    private File fileString = null;
    private Scanner inFileInt = null;
    private Scanner inFileDouble = null;
    private Scanner inFileBox = null;
    private Scanner inFileString = null;
    //so I can add vars 
    private int countInt;
    private int countDouble;
    private int countBox;
    private int countString;

    //vars
    private ArrayList <Integer> mySaveInt;
    private ArrayList <Double> mySaveDouble;
    private ArrayList <Integer> mySaveBox;
    private ArrayList <String> mySaveString;
    
    private String myEffect;
    public final int STRIMG_NUM = 3;
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
        countInt = 0;
        countDouble = 0;
        countBox = 0;
        countString = 0;
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
    public void reader(BoxIt box2, int pick)
    {
        mySaveInt.clear();
        mySaveDouble.clear();
        mySaveBox.clear();
        mySaveString.clear();
        countInt = 0;
        countDouble = 0;
        countBox = 0;
        countString = 0;
        box = box2;
        if(pick == 1)
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
            } //ends catch
        }//ends if
        else
        {
            try
            {
                fileInt = new File("saves//saveIntAI.txt");
                inFileInt = new Scanner(fileInt);
                fileDouble = new File("saves//saveDoubleAI.txt");
                inFileDouble = new Scanner(fileDouble);
                fileBox = new File("saves//saveBoxAI.txt");
                inFileBox = new Scanner(fileBox);
                fileString = new File("saves//saveStringAI.txt");
                inFileString = new Scanner(fileString);
            }catch(Exception e)
            {
                System.out.println(e);
            } //ends catch
        }//ends else
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
            //paper
        minimize(0);
            //cardboard
        minimize(1);
            //plactic
        minimize(2);
            //steel
        minimize(3);
            //saneza
        minimize(4);
            //thorby
        minimize(5);
            //plarbin
        minimize(6);
        //the input for strings
        box.setDay(mySaveString.get(countString));
        countString++;
        box.setMonth(mySaveString.get(countString));
        countString++;
        box.setEffect(mySaveString.get(countString).replaceAll("_", " "));
        countString++;
    }//ends load
    
    /**
     * This will simplify the loading prosess.
     * pre none
     * pram j
     * return none
     * post none
     */
    public void minimize(int type)
    {
        box.setBoxAmount(type, mySaveBox.get(countBox));
        countBox++;
        for(int fold = 0; fold <= FOLD_COUNT-1; fold++)
        {
            box.setFold(type, fold, mySaveBox.get(countBox));
            countBox++;
        }//ends for
    }//ends fimimize
}//ends Save
