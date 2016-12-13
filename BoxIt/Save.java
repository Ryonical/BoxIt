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
            fileInt = new FileWriter("saveInt.txt");
            fileDouble = new FileWriter("saveDouble.txt");
            fileAmount = new FileWriter("saveAmount.txt");
            fileString = new FileWriter("saveString.txt");
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
        //doubles
        mySaveDouble.add(Double.toString(box.getMola()));
        mySaveDouble.add(Double.toString(box.getTotalMola()));
        mySaveDouble.add(Double.toString(box.getResearchCost()));
        mySaveDouble.add(Double.toString(box.getResearchTypeCost()));
        mySaveDouble.add(Double.toString(box.getDate()));
        //box
        mySaveAmount.add(Integer.toString(box.getPaperAmount()));
        mySaveAmount.add(Integer.toString(box.getCardboardAmount()));
        mySaveAmount.add(Integer.toString(box.getPlasticAmount()));
        mySaveAmount.add(Integer.toString(box.getSteelAmount()));
        mySaveAmount.add(Integer.toString(box.getSanezaAmount()));
        mySaveAmount.add(Integer.toString(box.getThorbyAmount()));
        mySaveAmount.add(Integer.toString(box.getPlarbinAmount()));
        //string
        mySaveString.add(box.getDay());
        mySaveString.add(box.getMonth());
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
