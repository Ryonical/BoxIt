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
public class Buttons extends JFrame
{
    public final int BUTTON_NUM = 2;
    //vars   
    private JButton jbtPaper;
    private JButton jbtCardboard;
    private JButton jbtPlastic;
    private JButton jbtSteel;
    private JButton jbtSaneza;
    private JButton jbtThorby;
    private JButton jbtPlarbin;
    private JButton jbtBuy;
    private JButton jbtSell;
    
    
    //The real BoxIt
    BoxIt box;
    
    //for output
    GameScreen game;
    /**
    * This will be the buttons.
    * pre none
    * pram none
    * return none
    * post all
    */
    public Buttons(BoxIt box2, GameScreen game2)
    {
        box = box2;
        game = game2;
        jbtPaper = new JButton("Paper");
        jbtCardboard = new JButton("Cardboard");
        jbtPlastic = new JButton("Plastic");
        jbtSteel = new JButton("Steel");
        jbtSaneza = new JButton("Saneza");
        jbtThorby = new JButton("Thorby");
        jbtPlarbin = new JButton("Plarbin");
        jbtBuy = new JButton("Buy");
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
        
        
        Buttons frame = new Buttons(box, game);
        
        //adds buttons
        JPanel jpButtons = new JPanel();
        jpButtons.setLayout(new FlowLayout());
        jpButtons.add(jbtPaper);
        jpButtons.add(jbtCardboard);
        jpButtons.add(jbtPlastic);
        jpButtons.add(jbtSteel);
        jpButtons.add(jbtSaneza);
        jpButtons.add(jbtThorby);
        jpButtons.add(jbtPlarbin);
        jpButtons.add(jbtBuy);
        jpButtons.add(jbtSell);
        
        
        //picks paper
        jbtPaper.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(0);
                output();
            }//ends actionPerformed
        });//ends jbtPaper
        
        //picks cardboard
        jbtCardboard.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(1);
                output();
            }//ends actionPerformed
        });//ends jbtCardboard
        
        //picks plastic
        jbtPlastic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(2);
                output();
            }//ends actionPerformed
        });//ends jbtPlastic
        
        //picks steel
        jbtSteel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(3);
                output();
            }//ends actionPerformed
        });//ends jbtSteel
        
        //picks saneza
        jbtSaneza.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(4);
                output();
            }//ends actionPerformed
        });//ends jbtSaneza
        
        //picks thorby
        jbtThorby.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(5);
                output();
            }//ends actionPerformed
        });//ends jbtThorby
        
        //picks plarbin
        jbtPlarbin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(6);
                output();
            }//ends actionPerformed
        });//ends jbtPlarbin
        
        //buys
        jbtBuy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(1);
                output();
            }//ends actionPerformed
        });//ends jbtBuy
        //sells
        jbtSell.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(1);
                output();
            }//ends actionPerformed
        });//ends jbtSell
    }
    
    /**
    * This will get the buttons.
    * pre none
    * pram none
    * return none
    * post buttons[]
    */
    public JButton[] getButtons()
    {
        JButton[] buttons = new JButton[9];
        buttons[0] = jbtPaper;
        buttons[1] = jbtCardboard;
        buttons[2] = jbtPlastic;
        buttons[3] = jbtSteel;
        buttons[4] = jbtSaneza;
        buttons[5] = jbtThorby;
        buttons[6] = jbtPlarbin;
        buttons[7] = jbtBuy;
        buttons[8] = jbtSell;
        return buttons;
    }//getButtons
    
    /**
    * This will output.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void output()
    {
        
        String[] output = new String [1];
        output [0] = Double.toString(box.getMola());
        
       
       game.refresh(output);
    }//ends output
}//ends Buttons
