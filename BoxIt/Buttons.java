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
    public final int BUTTON_NUM = 15;
    //vars   
    private JButton jbtPaper;
    private JButton jbtCardboard;
    private JButton jbtPlastic;
    private JButton jbtSteel;
    private JButton jbtSaneza;
    private JButton jbtThorby;
    private JButton jbtPlarbin;
    private JButton jbtBuy1;
    private JButton jbtSell1;
    private JButton jbtBuy10;
    private JButton jbtSell10;
    private JButton jbtBuy100;
    private JButton jbtSell100;
    private JButton jbtBuyMax;
    private JButton jbtSellMax;
    
    
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
        jbtBuy1 = new JButton("Buy 1");
        jbtSell1 = new JButton("Sell 1");
        jbtBuy10 = new JButton("Buy 10");
        jbtSell10 = new JButton("Sell 10");
        jbtBuy100 = new JButton("Buy 100");
        jbtSell100 = new JButton("Sell 100");
        jbtBuyMax = new JButton("Buy Max");
        jbtSellMax = new JButton("Sell Max");
        screen1();
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
        jpButtons.add(jbtBuy1);
        jpButtons.add(jbtSell1);
        jpButtons.add(jbtBuy10);
        jpButtons.add(jbtSell10);
        jpButtons.add(jbtBuy100);
        jpButtons.add(jbtSell100);
        jpButtons.add(jbtBuyMax);
        jpButtons.add(jbtSellMax);
        
        //this starts the game
        box.createBoxes();
        box.randomizePrices();
        game.addButtons(getButtons());
        screen1();
        output();
        //picks paper
        jbtPaper.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(0);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtPaper
        
        //picks cardboard
        jbtCardboard.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(1);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtCardboard
        
        //picks plastic
        jbtPlastic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(2);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtPlastic
        
        //picks steel
        jbtSteel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(3);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtSteel
        
        //picks saneza
        jbtSaneza.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(4);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtSaneza
        
        //picks thorby
        jbtThorby.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(5);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtThorby
        
        //picks plarbin
        jbtPlarbin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.setType(6);
                output();
                screen2();
            }//ends actionPerformed
        });//ends jbtPlarbin
        
        //buys 1
        jbtBuy1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(1);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtBuy1
        //sells 1
        jbtSell1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(1);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtSell1
        
        //buys 10
        jbtBuy10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(10);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtBuy1
        //sells 1
        jbtSell10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(10);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtSell10
        
        //buys 100
        jbtBuy100.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(100);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtBuy100
        //sells 1
        jbtSell100.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(100);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtSell100
        
        //buys Max
        jbtBuyMax.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(999999999);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtBuyMax
        //sells Max
        jbtSellMax.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(999999999);
                output();
                screen1();
            }//ends actionPerformed
        });//ends jbtSellMax=
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
        JButton[] buttons = new JButton[BUTTON_NUM];
        buttons[0] = jbtPaper;
        buttons[1] = jbtCardboard;
        buttons[2] = jbtPlastic;
        buttons[3] = jbtSteel;
        buttons[4] = jbtSaneza;
        buttons[5] = jbtThorby;
        buttons[6] = jbtPlarbin;
        buttons[7] = jbtBuy1;
        buttons[8] = jbtSell1;
        buttons[9] = jbtBuy10;
        buttons[10] = jbtSell10;
        buttons[11] = jbtBuy100;
        buttons[12] = jbtSell100;
        buttons[13] = jbtBuyMax;
        buttons[14] = jbtSellMax;
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
        
        String[] output = new String [8];
        output [0] = "You have $" + Double.toString(box.getMola()) + " Mola";
        output [1] = box.getRandom0();
        output [2] = box.getRandom1();
        output [3] = box.getRandom2();
        output [4] = box.getRandom3();
        output [5] = box.getRandom4();
        output [6] = box.getRandom5();
        output [7] = box.getRandom6();
        
       
        game.refresh(output);
    }//ends output
    
    /**
    * This will show the first screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void screen1()
    {
        jbtPaper.setVisible(true);
        jbtCardboard.setVisible(true);
        jbtPlastic.setVisible(true);
        jbtSteel.setVisible(true);
        jbtSaneza.setVisible(true);
        jbtThorby.setVisible(true);
        jbtPlarbin.setVisible(true);
        jbtBuy1.setVisible(false);
        jbtSell1.setVisible(false);
        jbtBuy10.setVisible(false);
        jbtSell10.setVisible(false);
        jbtBuy100.setVisible(false);
        jbtSell100.setVisible(false);
        jbtBuyMax.setVisible(false);
        jbtSellMax.setVisible(false);
    }//ends screen1
    
    /**
    * This will show the first screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void screen2()
    {
        jbtPaper.setVisible(false);
        jbtCardboard.setVisible(false);
        jbtPlastic.setVisible(false);
        jbtSteel.setVisible(false);
        jbtSaneza.setVisible(false);
        jbtThorby.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtBuy1.setVisible(true);
        jbtSell1.setVisible(true);
        jbtBuy10.setVisible(true);
        jbtSell10.setVisible(true);
        jbtBuy100.setVisible(true);
        jbtSell100.setVisible(true);
        jbtBuyMax.setVisible(true);
        jbtSellMax.setVisible(true);
    }//ends screen2
}//ends Buttons
