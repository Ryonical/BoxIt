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
    public final int BOX_NUM = 7;
    public final int FOLD_COUNT = 5;
    //to save
    FileWriter fileInt;
    FileWriter fileDouble;
    FileWriter fileBox;
    FileWriter fileString;
    
    //arraylist
    private ArrayList <String> mySaveInt;
    private ArrayList <String> mySaveDouble;
    private ArrayList <String> mySaveBox;
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
            fileBox = new FileWriter("saves//saveBox.txt");
            fileString = new FileWriter("saves//saveString.txt");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        box = box2;
        mySaveInt = new ArrayList<String>();
        mySaveDouble = new ArrayList<String>();
        mySaveBox = new ArrayList<String>();
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
        for(int i = 0; i < BOX_NUM; i++)
        {
            mySaveDouble.add(box.getCosts(i));
        }//ends for
        //box
            //saves for paper
        minimize(0);
            //saves for cardboard
        minimize(1);
            //saves for plastic
        minimize(2);
            //saves for steel
        minimize(3);
            //saves for saneza
        minimize(4);
            //saves for thorby
        minimize(5);
            //saves for plarbin
        minimize(6);
        //string
        mySaveString.add(box.getDay());
        mySaveString.add(box.getMonth());
        mySaveString.add(box.getEffect().replaceAll(" ", "_"));
    }//ends getStats
    
    
    /**
    * This will simplify the saving prosess.
    * pre none
    * pram j
    * return none
    * post none
    */
    public void minimize(int j)
    {   
        mySaveBox.add(box.getBoxAmount(j));
        for(int i = 1; i <= FOLD_COUNT; i++)
        {
            mySaveBox.add(Integer.toString(box.getFold(i, j)));
        }//ends for
    }
    
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
            for(int i = 0; i < mySaveBox.size(); i++)
            {
                fileBox.write((mySaveBox.get(i) + System.lineSeparator()));
            }//ends for
            fileBox.close();
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
