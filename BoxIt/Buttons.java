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
    public final int BUTTON_NUM = 23;
    //buttons for starting
    private JButton jbtPaperAirplane;
    private JButton jbtPaperBox;
    private JButton jbtPaperFootball;
    private JButton jbtPaperKnife;
    //buttons for playing  
    private JButton jbtPaper;
    private JButton jbtCardboard;
    private JButton jbtPlastic;
    private JButton jbtSteel;
    private JButton jbtSaneza;
    private JButton jbtThorby;
    private JButton jbtPlarbin;
    private JButton jbtResearch;
    private JButton jbtResearchBox;
    private JButton jbtBuy1;
    private JButton jbtSell1;
    private JButton jbtBuy10;
    private JButton jbtSell10;
    private JButton jbtBuy100;
    private JButton jbtSell100;
    private JButton jbtBuyMax;
    private JButton jbtSellMax;
    private JButton jbtSave;
    private JButton jbtLoad;
    
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
        //starting buttons
        jbtPaperAirplane = new JButton("I will make a paper airplane");
        jbtPaperBox = new JButton("I will make a paper box");
        jbtPaperFootball = new JButton("I will make a paper football");
        jbtPaperKnife = new JButton("I will make a paper knife");
        //game buttons
        jbtPaper = new JButton("Paper");
        jbtCardboard = new JButton("Cardboard");
        jbtPlastic = new JButton("Plastic");
        jbtSteel = new JButton("Steel");
        jbtSaneza = new JButton("Saneza");
        jbtThorby = new JButton("Thorby");
        jbtPlarbin = new JButton("Plarbin");
        jbtResearch = new JButton("Research");
        jbtResearchBox = new JButton("Research Box");
        jbtBuy1 = new JButton("Buy 1");
        jbtSell1 = new JButton("Sell 1");
        jbtBuy10 = new JButton("Buy 10");
        jbtSell10 = new JButton("Sell 10");
        jbtBuy100 = new JButton("Buy 100");
        jbtSell100 = new JButton("Sell 100");
        jbtBuyMax = new JButton("Buy Max");
        jbtSellMax = new JButton("Sell Max");
        jbtSave = new JButton("Save");
        jbtLoad = new JButton("Load");
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
        //starting buttons
        jpButtons.add(jbtPaperAirplane);
        jpButtons.add(jbtPaperBox);
        jpButtons.add(jbtPaperFootball);
        jpButtons.add(jbtPaperKnife);
        //main buttons
        jpButtons.add(jbtPaper);
        jpButtons.add(jbtCardboard);
        jpButtons.add(jbtPlastic);
        jpButtons.add(jbtSteel);
        jpButtons.add(jbtSaneza);
        jpButtons.add(jbtThorby);
        jpButtons.add(jbtPlarbin);
        jpButtons.add(jbtResearch);
        jpButtons.add(jbtResearchBox);
        jpButtons.add(jbtBuy1);
        jpButtons.add(jbtSell1);
        jpButtons.add(jbtBuy10);
        jpButtons.add(jbtSell10);
        jpButtons.add(jbtBuy100);
        jpButtons.add(jbtSell100);
        jpButtons.add(jbtBuyMax);
        jpButtons.add(jbtSellMax);
        jpButtons.add(jbtSave);
        jpButtons.add(jbtLoad);
        
        //this starts the game
        box.createBoxes();
        box.randomizePrices();
        game.addButtons(getButtons());
        screen1();
        output1();
        
        
        
        //starting button
        //picks Paper Airplane
        jbtPaperAirplane.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputFail();
                screenFail();
            }//ends actionPerformed
        });//ends jbtPaperAirplane
        
        //picks Paper Box
        jbtPaperBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtPaperBox
        
        //picks Paper Football
        jbtPaperFootball.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputFail();
                screenFail();
            }//ends actionPerformed
        });//ends jbtPaperFootball
        
        //picks Paper Knife
        jbtPaperKnife.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputFail();
                screenFail();
            }//ends actionPerformed
        });//ends jbtPaperKnife
        
        //game buttons
        //picks paper
        jbtPaper.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 0)
                {
                    box.setType(0);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtPaper
        
        //picks cardboard
        jbtCardboard.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 1)
                {
                    box.setType(1);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtCardboard
        
        //picks plastic
        jbtPlastic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 2)
                {
                    box.setType(2);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtPlastic
        
        //picks steel
        jbtSteel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 3)
                {
                    box.setType(3);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtSteel
        
        //picks saneza
        jbtSaneza.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 4)
                {
                    box.setType(4);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtSaneza
        
        //picks thorby
        jbtThorby.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 5)
                {
                    box.setType(5);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtThorby
        
        //picks plarbin
        jbtPlarbin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(box.getTypeBuy() >= 6)
                {
                    box.setType(6);
                    outputx();
                    screeny();
                }//ends if
                else
                {
                    screenx();
                }//ends else
            }//ends actionPerformed
        });//ends jbtPlarbin
        
        //researches
        jbtResearch.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.research();
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtResearch
        
        //researches a new box
        jbtResearchBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.researchType();
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtResearchBox
        
        //buys 1
        jbtBuy1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(1);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtBuy1
        //sells 1
        jbtSell1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(1);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtSell1
        
        //buys 10
        jbtBuy10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(10);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtBuy1
        //sells 1
        jbtSell10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(10);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtSell10
        
        //buys 100
        jbtBuy100.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(100);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtBuy100
        //sells 1
        jbtSell100.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(100);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtSell100
        
        //buys Max
        jbtBuyMax.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(999999999);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtBuyMax
        //sells Max
        jbtSellMax.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(999999999);
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtSellMax
        
        //saves
        jbtSave.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Save save = new Save(box);
                save.getStats();
                save.save();
            }//ends actionPerformed
        });//ends jbtSave
        
        //Loads
        jbtLoad.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Load load = new Load(box);
                load.reader();
                load.load();
                outputx();
                screenx();
            }//ends actionPerformed
        });//ends jbtLoad
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
        int i = 0;
        JButton[] buttons = new JButton[BUTTON_NUM];
        buttons[i++] = jbtPaperAirplane;
        buttons[i++] = jbtPaperBox;
        buttons[i++] = jbtPaperFootball;
        buttons[i++] = jbtPaperKnife;
        buttons[i++] = jbtPaper;
        buttons[i++] = jbtCardboard;
        buttons[i++] = jbtPlastic;
        buttons[i++] = jbtSteel;
        buttons[i++] = jbtSaneza;
        buttons[i++] = jbtThorby;
        buttons[i++] = jbtPlarbin;
        buttons[i++] = jbtResearch;
        buttons[i++] = jbtResearchBox;
        buttons[i++] = jbtBuy1;
        buttons[i++] = jbtSell1;
        buttons[i++] = jbtBuy10;
        buttons[i++] = jbtSell10;
        buttons[i++] = jbtBuy100;
        buttons[i++] = jbtSell100;
        buttons[i++] = jbtBuyMax;
        buttons[i++] = jbtSellMax;
        buttons[i++] = jbtSave;
        buttons[i++] = jbtLoad;
        
        return buttons;
    }//getButtons
    
    /**
    * This will output the starting words.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void output1()
    {
        int i = 0;
        String[] output = new String [1];
        output [i++] = "You have a one square foot peace of paper what would you like to do with it?";
        game.refresh(output);
    }//ends output
    
    /**
    * This will output the starting words.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void outputFail()
    {
        int i = 0;
        String[] output = new String [0];
        game.refresh(output);
    }//ends output
    
    /**
    * This will output.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void outputx()
    {
        int i = 0;
        String[] output = new String [10];
        output [i++] = "You have $" + Double.toString(box.getMola()) + " Mola";
        output [i++] = box.getRandom0();
        output [i++] = box.getRandom1();
        output [i++] = box.getRandom2();
        output [i++] = box.getRandom3();
        output [i++] = box.getRandom4();
        output [i++] = box.getRandom5();
        output [i++] = box.getRandom6();
        output [i++] = "Your research cost is " + Double.toString(box.getResearchCost()) +
        " and your new type costs " + box.getResearchTypeCost();
        output [i++] = "You can buy " + Integer.toString(box.getMaxBuy()) + " things at a time.";
        
       
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
        jbtPaperAirplane.setVisible(true);
        jbtPaperBox.setVisible(true);
        jbtPaperFootball.setVisible(true);
        jbtPaperKnife.setVisible(true);
        jbtPaper.setVisible(false);
        jbtCardboard.setVisible(false);
        jbtPlastic.setVisible(false);
        jbtSteel.setVisible(false);
        jbtSaneza.setVisible(false);
        jbtThorby.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtResearch.setVisible(false);
        jbtResearchBox.setVisible(false);
        jbtBuy1.setVisible(false);
        jbtSell1.setVisible(false);
        jbtBuy10.setVisible(false);
        jbtSell10.setVisible(false);
        jbtBuy100.setVisible(false);
        jbtSell100.setVisible(false);
        jbtBuyMax.setVisible(false);
        jbtSellMax.setVisible(false);
        jbtSave.setVisible(false);
        jbtLoad.setVisible(true);
    }//ends screen1
    
    /**
    * This will show the first screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void screenFail()
    {   
        jbtPaperAirplane.setVisible(false);
        jbtPaperBox.setVisible(false);
        jbtPaperFootball.setVisible(false);
        jbtPaperKnife.setVisible(false);
        jbtPaper.setVisible(false);
        jbtCardboard.setVisible(false);
        jbtPlastic.setVisible(false);
        jbtSteel.setVisible(false);
        jbtSaneza.setVisible(false);
        jbtThorby.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtResearch.setVisible(false);
        jbtResearchBox.setVisible(false);
        jbtBuy1.setVisible(false);
        jbtSell1.setVisible(false);
        jbtBuy10.setVisible(false);
        jbtSell10.setVisible(false);
        jbtBuy100.setVisible(false);
        jbtSell100.setVisible(false);
        jbtBuyMax.setVisible(false);
        jbtSellMax.setVisible(false);
        jbtSave.setVisible(false);
        jbtLoad.setVisible(false);
    }//ends screen1
   
    
    /**
    * This will show the first screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void screenx()
    {
        jbtPaperAirplane.setVisible(false);
        jbtPaperBox.setVisible(false);
        jbtPaperFootball.setVisible(false);
        jbtPaperKnife.setVisible(false);
        jbtPaper.setVisible(true);
        jbtCardboard.setVisible(true);
        jbtPlastic.setVisible(true);
        jbtSteel.setVisible(true);
        jbtSaneza.setVisible(true);
        jbtThorby.setVisible(true);
        jbtPlarbin.setVisible(true);
        jbtResearch.setVisible(true);
        jbtResearchBox.setVisible(true);
        jbtBuy1.setVisible(false);
        jbtSell1.setVisible(false);
        jbtBuy10.setVisible(false);
        jbtSell10.setVisible(false);
        jbtBuy100.setVisible(false);
        jbtSell100.setVisible(false);
        jbtBuyMax.setVisible(false);
        jbtSellMax.setVisible(false);
        jbtSave.setVisible(true);
        jbtLoad.setVisible(false);
    }//ends screenx
    
    /**
    * This will show the first screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void screeny()
    {
        jbtPaperAirplane.setVisible(false);
        jbtPaperBox.setVisible(false);
        jbtPaperFootball.setVisible(false);
        jbtPaperKnife.setVisible(false);
        jbtPaper.setVisible(false);
        jbtCardboard.setVisible(false);
        jbtPlastic.setVisible(false);
        jbtSteel.setVisible(false);
        jbtSaneza.setVisible(false);
        jbtThorby.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtPlarbin.setVisible(false);
        jbtResearch.setVisible(false);
        jbtResearchBox.setVisible(false);
        jbtBuy1.setVisible(true);
        jbtSell1.setVisible(true);
        jbtBuy10.setVisible(true);
        jbtSell10.setVisible(true);
        jbtBuy100.setVisible(true);
        jbtSell100.setVisible(true);
        jbtBuyMax.setVisible(true);
        jbtSellMax.setVisible(true);
        jbtSave.setVisible(true);
        jbtLoad.setVisible(false);
    }//ends screeny
}//ends Buttons
