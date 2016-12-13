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
    public final int BUTTON_NUM = 27;
    ImageIcon paperPic;
    ImageIcon cardPic;
    ImageIcon lockedCardPic;
    ImageIcon plasticPic;
    ImageIcon lockedPlasticPic;
    ImageIcon steelPic;
    ImageIcon lockedSteelPic;
    ImageIcon sanezaPic;
    ImageIcon lockedSanezaPic;
    ImageIcon thorbyPic;
    ImageIcon lockedThorbyPic;
    ImageIcon plarbinPic;
    ImageIcon lockedPlarbinPic;
    //buttons for starting
    private JButton jbtTutorialYes;
    private JButton jbtTutorialNo;
    private JButton jbtTutorialPaper;
    private JButton jbtTutorialBuy;
    //buttons for playing 
    private JButton jbtPaper;
    private JButton jbtCardboard;
    private JButton lockedJbtCardboard;
    private JButton jbtPlastic;
    private JButton lockedJbtPlastic;
    private JButton jbtSteel;
    private JButton lockedJbtSteel;
    private JButton jbtSaneza;
    private JButton lockedJbtSaneza;
    private JButton jbtThorby;
    private JButton lockedJbtThorby;
    private JButton jbtPlarbin;
    private JButton lockedJbtPlarbin;
    private JButton jbtResearch;
    private JButton jbtResearchBox;
    private JButton jbtBuy1;
    private JButton jbtSell1;
    private JButton jbtBuy10;
    private JButton jbtSell10;
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
        paperPic = new ImageIcon("SmallZoomedPaper.png");
        cardPic = new ImageIcon("Cardboard.png");
        lockedCardPic = new ImageIcon("LockedCardboard.png");
        plasticPic = new ImageIcon("Plastic.png");
        lockedPlasticPic = new ImageIcon("LockedPlastic.png");
        steelPic = new ImageIcon("Steel.png");
        lockedSteelPic = new ImageIcon("LockedSteel.png");
        sanezaPic = new ImageIcon("Saneza.png");
        lockedSanezaPic = new ImageIcon("LockedSaneza.png");
        thorbyPic = new ImageIcon("Thorby.png");
        lockedThorbyPic = new ImageIcon("LockedThorby.png");
        plarbinPic = new ImageIcon("Plarbin.png");
        lockedPlarbinPic = new ImageIcon("LockedPlarbin.png");
        //starting buttons
        jbtTutorialYes = new JButton("Yes");
        jbtTutorialNo = new JButton("No");
        jbtTutorialPaper = new JButton(paperPic);
        jbtTutorialBuy = new JButton("I will make 2 paper knife");
        //game buttons
        jbtPaper = new JButton(paperPic);
        jbtCardboard = new JButton(cardPic);
        lockedJbtCardboard = new JButton(lockedCardPic);
        jbtPlastic = new JButton(plasticPic);
        lockedJbtPlastic = new JButton(lockedPlasticPic);
        jbtSteel = new JButton(steelPic);
        lockedJbtSteel = new JButton(lockedSteelPic);
        jbtSaneza = new JButton(sanezaPic);
        lockedJbtSaneza = new JButton(lockedSanezaPic);
        jbtThorby = new JButton(thorbyPic);
        lockedJbtThorby = new JButton(lockedThorbyPic);
        jbtPlarbin = new JButton(plarbinPic);
        lockedJbtPlarbin = new JButton(lockedPlarbinPic);
        jbtResearch = new JButton("Research");
        jbtResearchBox = new JButton("Research Box");
        jbtBuy1 = new JButton("Buy 1");
        jbtSell1 = new JButton("Sell 1");
        jbtBuy10 = new JButton("Buy 10");
        jbtSell10 = new JButton("Sell 10");
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
        jpButtons.add(jbtTutorialYes);
        jpButtons.add(jbtTutorialNo);
        jpButtons.add(jbtTutorialPaper);
        jpButtons.add(jbtTutorialBuy);
        //main buttons
        jpButtons.add(jbtPaper);
        jpButtons.add(jbtCardboard);
        jpButtons.add(lockedJbtCardboard);
        jpButtons.add(jbtPlastic);
        jpButtons.add(lockedJbtPlastic);
        jpButtons.add(jbtSteel);
        jpButtons.add(lockedJbtSteel);
        jpButtons.add(jbtSaneza);
        jpButtons.add(lockedJbtSaneza);
        jpButtons.add(jbtThorby);
        jpButtons.add(lockedJbtThorby);
        jpButtons.add(jbtPlarbin);
        jpButtons.add(lockedJbtPlarbin);
        jpButtons.add(jbtResearch);
        jpButtons.add(jbtResearchBox);
        jpButtons.add(jbtBuy1);
        jpButtons.add(jbtSell1);
        jpButtons.add(jbtBuy10);
        jpButtons.add(jbtSell10);
        jpButtons.add(jbtBuyMax);
        jpButtons.add(jbtSellMax);
        jpButtons.add(jbtSave);
        jpButtons.add(jbtLoad);
        
        //this starts the game
        box.createBoxes();
        box.randomizePrices();
        game.addButtons(getButtons());
        startScreen();
        outputStartTutorial();
        
        
        
        //starting button
        //picks Paper Airplane
        jbtTutorialYes.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputTutorialYes();
                pickStartTutorial();
            }//ends actionPerformed
        });//ends jbtTutorialYes
        
        //picks Paper Box
        jbtTutorialNo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtTutorialNo
        
        //picks Paper Football
        jbtTutorialPaper.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputTutorialYes();
            }//ends actionPerformed
        });//ends jbtTutorialPaper
        
        //picks Paper Knife
        jbtTutorialBuy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outputTutorialYes();
            }//ends actionPerformed
        });//ends jbtTutorialBuy
        
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                    sellScreen();
                }//ends if
                else
                {
                    pickScreen();
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
                pickScreen();
            }//ends actionPerformed
        });//ends jbtResearch
        
        //researches a new box
        jbtResearchBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.researchType();
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtResearchBox
        
        //buys 1
        jbtBuy1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(1);
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtBuy1
        //sells 1
        jbtSell1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(1);
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtSell1
        
        //buys 10
        jbtBuy10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(10);
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtBuy1
        //sells 1
        jbtSell10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(10);
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtSell10
        
        //buys Max
        jbtBuyMax.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.buy(999999999);
                outputx();
                pickScreen();
            }//ends actionPerformed
        });//ends jbtBuyMax
        //sells Max
        jbtSellMax.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                box.sell(999999999);
                outputx();
                pickScreen();
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
                pickScreen();
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
        buttons[i++] = jbtTutorialYes;
        buttons[i++] = jbtTutorialNo;
        buttons[i++] = jbtTutorialPaper;
        buttons[i++] = jbtTutorialBuy;
        buttons[i++] = jbtPaper;
        buttons[i++] = jbtCardboard;
        buttons[i++] = lockedJbtCardboard;
        buttons[i++] = jbtPlastic;
        buttons[i++] = lockedJbtPlastic;
        buttons[i++] = jbtSteel;
        buttons[i++] = lockedJbtSteel;
        buttons[i++] = jbtSaneza;
        buttons[i++] = lockedJbtSaneza;
        buttons[i++] = jbtThorby;
        buttons[i++] = lockedJbtThorby;
        buttons[i++] = jbtPlarbin;
        buttons[i++] = lockedJbtPlarbin;
        buttons[i++] = jbtResearch;
        buttons[i++] = jbtResearchBox;
        buttons[i++] = jbtBuy1;
        buttons[i++] = jbtSell1;
        buttons[i++] = jbtBuy10;
        buttons[i++] = jbtSell10;
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
    public void outputStartTutorial()
    {
        int i = 0;
        String[] output = new String [1];
        output [i++] = "Would you like to go through the tutorial";
        game.refresh(output);
    }//ends output
    
    /**
    * This will output the starting words.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void outputTutorialYes()
    {
        int i = 0;
        String[] output = new String [4];
        output [i++] = "OK get ready to get your learn on.";
        output [i++] = "What you do now is buy some paper";
        output [i++] = "Paper is the first tier of boxes you can make.";
        output [i++] = "Click the box under this text";
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
        String[] output = new String [11];
        output [i++] = "The date is " + box.getTheDay();
        output [i++] = "You have $" + Double.toString(box.getMola()) + " Mola";
        output [i++] = box.getRandom0() + " and you have " + box.getPaperAmount();
        output [i++] = box.getRandom1() + " and you have " + box.getCardboardAmount();
        output [i++] = box.getRandom2() + " and you have " + box.getPlasticAmount();
        output [i++] = box.getRandom3() + " and you have " + box.getSteelAmount();
        output [i++] = box.getRandom4() + " and you have " + box.getSanezaAmount();
        output [i++] = box.getRandom5() + " and you have " + box.getThorbyAmount();
        output [i++] = box.getRandom6() + " and you have " + box.getPlarbinAmount();
        output [i++] = "Your research cost is " + Double.toString(box.getResearchCost()) +
        " and your new type costs " + box.getResearchTypeCost();
        output [i++] = "You can buy " + Integer.toString(box.getMaxBuy()) + " things at a time.";
        
       
        game.refresh(output);
    }//ends output
    
    /**
    * This will show the first 2 buttons screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void startScreenTrue()
    {   
        jbtTutorialYes.setVisible(true);
        jbtTutorialNo.setVisible(true);
    }//ends startScreenTrue
    
    /**
    * This will not show the first 2 buttons screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void startScreenFalse()
    {   
        jbtTutorialYes.setVisible(false);
        jbtTutorialNo.setVisible(false);
    }//ends startScreenFalse
    
    /**
    * This will show tutorial paper.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void paperTrue()
    {   
        jbtTutorialPaper.setVisible(true);
    }//ends paperTrue
    
    /**
    * This will not show tutorial paper.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void paperFalse()
    {   
        jbtTutorialPaper.setVisible(false);
    }//ends paperFalse
    
    /**
    * This will show tutorial buy.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void buyTrue()
    {   
        jbtTutorialBuy.setVisible(true);
    }//ends buyTrue
    
    /**
    * This will not show tutorial buy.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void buyFalse()
    {   
        jbtTutorialBuy.setVisible(false);
    }//ends buyFalse
    
    /**
    * This will show the picking buttons screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void pickScreenTrue()
    {   
        jbtPaper.setVisible(true);
        showCardboard();
        showPlastic();
        showSteel();
        showSaneza();
        showThorby();
        showPlarbin();
        jbtResearch.setVisible(true);
        jbtResearchBox.setVisible(true);
    }//ends pickScreenTrue
    
    /**
    * This will not show the picking buttons screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void pickScreenFalse()
    {   
        lockedJbtCardboard.setVisible(false);
        lockedJbtPlastic.setVisible(false);
        lockedJbtSteel.setVisible(false);
        lockedJbtSaneza.setVisible(false);
        lockedJbtThorby.setVisible(false);
        lockedJbtPlarbin.setVisible(false);
        lockedJbtPlarbin.setVisible(false);
        
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
    }//ends pickScreenFalse
    
    /**
    * This will show the selling buttons screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void sellScreenTrue()
    {   
        jbtBuy1.setVisible(true);
        jbtSell1.setVisible(true);
        jbtBuy10.setVisible(true);
        jbtSell10.setVisible(true);
        jbtBuyMax.setVisible(true);
        jbtSellMax.setVisible(true);
    }//ends sellScreentTrue
    
    /**
    * This will not show the selling buttons screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void sellScreenFalse()
    {   
        jbtBuy1.setVisible(false);
        jbtSell1.setVisible(false);
        jbtBuy10.setVisible(false);
        jbtSell10.setVisible(false);
        jbtBuyMax.setVisible(false);
        jbtSellMax.setVisible(false);
    }//ends sellScreenFalse
    
    /**
    * This will show the first screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void startScreen()
    {   
        startScreenTrue();
        paperFalse();
        buyFalse();
        pickScreenFalse();
        sellScreenFalse();
        jbtSave.setVisible(false);
        jbtLoad.setVisible(true);
    }//ends screen1
    
    /**
    * This will show the first part of the tutorial.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void pickStartTutorial()
    {   
        startScreenFalse();
        paperTrue();
        buyFalse();
        pickScreenFalse();
        sellScreenFalse();
        jbtSave.setVisible(false);
        jbtLoad.setVisible(false);
    }//ends pickStartTutorial
    
    /**
    * This will show the first part of the tutorial.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void pickBuyTutorial()
    {   
        startScreenFalse();
        paperFalse();
        buyTrue();
        pickScreenFalse();
        sellScreenFalse();
        jbtSave.setVisible(false);
        jbtLoad.setVisible(false);
    }//ends pickStartTutorial
    
    /**
    * This will show the pick screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void pickScreen()
    {
        startScreenFalse();
        paperFalse();
        buyFalse();
        pickScreenTrue();
        sellScreenFalse();
        jbtSave.setVisible(true);
        jbtLoad.setVisible(false);
    }//ends pickScreen
    
    /**
    * This will show the sell screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void sellScreen()
    {
        startScreenFalse();
        paperFalse();
        buyFalse();
        pickScreenFalse();
        sellScreenTrue();
        jbtSave.setVisible(true);
        jbtLoad.setVisible(false);
    }//ends sellScreen
    
    /**
    * This will show the proper cardboard.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showCardboard()
    {
        if(box.getTypeBuy() >= 1)
        {
            jbtCardboard.setVisible(true);
            lockedJbtCardboard.setVisible(false);
        }//ends if
        else
        {
            jbtCardboard.setVisible(false);
            lockedJbtCardboard.setVisible(true);
        }//ends else
    }//ends showCardboard
    
    /**
    * This will show the proper plastic.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showPlastic()
    {
        if(box.getTypeBuy() >= 2)
        {
            jbtPlastic.setVisible(true);
            lockedJbtPlastic.setVisible(false);
        }
        else
        {
            jbtPlastic.setVisible(false);
            lockedJbtPlastic.setVisible(true);
        }
    }//ends showPlastic
    
    /**
    * This will show the proper steel.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showSteel()
    {
        if(box.getTypeBuy() >= 3)
        {
            jbtSteel.setVisible(true);
            lockedJbtSteel.setVisible(false);
        }
        else
        {
            jbtSteel.setVisible(false);
            lockedJbtSteel.setVisible(true);
        }
    }//ends showSteel
    
    /**
    * This will show the proper saneza.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showSaneza()
    {
        if(box.getTypeBuy() >= 4)
        {
            jbtSaneza.setVisible(true);
            lockedJbtSaneza.setVisible(false);
        }
        else
        {
            jbtSaneza.setVisible(false);
            lockedJbtSaneza.setVisible(true);
        }
    }//ends showSaneza
    
    /**
    * This will show the proper thorby.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showThorby()
    {
        if(box.getTypeBuy() >= 5)
        {
            jbtThorby.setVisible(true);
            lockedJbtThorby.setVisible(false);
        }
        else
        {
            jbtThorby.setVisible(false);
            lockedJbtThorby.setVisible(true);
        }
    }//ends showThorby
    
    /**
    * This will show the proper plarbin.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showPlarbin()
    {
        if(box.getTypeBuy() >= 6)
        {
            jbtPlarbin.setVisible(true);
            lockedJbtPlarbin.setVisible(false);
        }
        else
        {
            jbtPlarbin.setVisible(false);
            lockedJbtPlarbin.setVisible(true);
        }
    }//ends showThorby
}//ends Buttons
