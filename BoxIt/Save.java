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
public class Save
{
    //to save
    FileWriter fileInt;
    FileWriter fileDouble;
    FileWriter fileAmount;
    FileWriter fileString;
    
    //arraylist
    private ArrayList <String> mySaveInt;
    private ArrayList <String> mySaveDouble;
    private ArrayList <String> mySaveAmount;
    private ArrayList <String> mySaveString;
    
    //classes
    BoxIt box;
    /**
    * This will construct .
    * pre none
    * pram none
    * return none
    * post all
    */
    public Save(BoxIt box2)
    {
        try
        {
            fileInt = new FileWriter("saves//saveInt.txt");
            fileDouble = new FileWriter("saves//saveDouble.txt");
            fileAmount = new FileWriter("saves//saveAmount.txt");
            fileString = new FileWriter("saves//saveString.txt");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        box = box2;
        mySaveInt = new ArrayList<String>();
        mySaveDouble = new ArrayList<String>();
        mySaveAmount = new ArrayList<String>();
        mySaveString = new ArrayList<String>();
    }
    
    /**
    * This will get the info that needs to be saved.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void getStats()
    {
        //ints
        mySaveInt.add(Integer.toString(box.getMaxBuy()));
        mySaveInt.add(Integer.toString(box.getTypeBuy()));
        mySaveInt.add(Integer.toString(box.getCoolDown()));
        //doubles
        mySaveDouble.add(Double.toString(box.getMola()));
        mySaveDouble.add(Double.toString(box.getTotalMola()));
        mySaveDouble.add(Double.toString(box.getResearchCost()));
        mySaveDouble.add(Double.toString(box.getResearchTypeCost()));
        mySaveDouble.add(Double.toString(box.getDate()));
        mySaveDouble.add(box.getCosts(0));
        mySaveDouble.add(box.getCosts(1));
        mySaveDouble.add(box.getCosts(2));
        mySaveDouble.add(box.getCosts(3));
        mySaveDouble.add(box.getCosts(4));
        mySaveDouble.add(box.getCosts(5));
        mySaveDouble.add(box.getCosts(6));
        //box
        mySaveAmount.add(box.getBoxAmount(0));
        mySaveAmount.add(box.getBoxAmount(1));
        mySaveAmount.add(box.getBoxAmount(2));
        mySaveAmount.add(box.getBoxAmount(3));
        mySaveAmount.add(box.getBoxAmount(4));
        mySaveAmount.add(box.getBoxAmount(5));
        mySaveAmount.add(box.getBoxAmount(6));
        //string
        mySaveString.add(box.getDay());
        mySaveString.add(box.getMonth());
        mySaveString.add(box.getEffect());
    }//ends getStats
    
    /**
    * This will save everything that needs to be saved.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void save()
    {        
        try
        {
            //to save ints
            for(int i = 0; i < mySaveInt.size(); i++)
            {
                fileInt.write((mySaveInt.get(i) + System.lineSeparator()));
            }//ends for
            fileInt.close();
            //to save doubles
            for(int i = 0; i < mySaveDouble.size(); i++)
            {
                fileDouble.write((mySaveDouble.get(i) + System.lineSeparator()));
            }//ends for
            fileDouble.close();
            //to save boxes
            for(int i = 0; i < mySaveAmount.size(); i++)
            {
                fileAmount.write((mySaveAmount.get(i) + System.lineSeparator()));
            }//ends for
            fileAmount.close();
            //to save string
            for(int i = 0; i < mySaveString.size(); i++)
            {
                fileString.write((mySaveString.get(i) + System.lineSeparator()));
            }//ends for
            fileString.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }//ends catch
    }//ends save
}//ends Save
