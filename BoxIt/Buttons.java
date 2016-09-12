import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.lang.String.*;
import java.text.DecimalFormat;
import java.io.*;
/**
 * This is the buttos.
 * 
 * @Ryan Keeler
 * @BoxIt
 */
public class Buttons
{
    public final int BUTTON_NUM = 13;
    //vars   
    private JButton jbtSell;
    
    /**
    * This will be the buttons.
    * pre none
    * pram none
    * return none
    * post all
    */
    public Buttons()
    {
        jbtSell = new JButton("Sell");
    }
    
    
    /**
    * This will be the buttons.
    * pre none
    * pram none
    * return none
    * post all
    */
    public void activate()
    {
        //to remove the exess numbers off the monster health
        DecimalFormat format = new DecimalFormat("0.#");
        
        
        Buttons frame = new Buttons();
        
        //adds buttons
        JPanel jpButtons = new JPanel();
        jpButtons.setLayout(new FlowLayout());
        jpButtons.add(jbtSell);
        
        //reads in for easteregg
        firstEgg.read();
        
        //attacks
        jbtSell.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                
            }//ends actionPerformed
        });//ends jbtSell
    }
}//ends Buttons
