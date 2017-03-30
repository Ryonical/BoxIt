import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class GameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameScreen extends JFrame
{
    JPanel myButtonPanel;
    private int height;
    private int width;
    
    /**
    * This will construct.
    * pre none
    * pram none
    * return none
    * post none
    */
    public GameScreen()
    {
        super("Box It");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        height = 343;
        width = 1275;
        setSize(width, height);
        setLocation(200, 300);
    }//ends contructer
    
    /**
    * This will show the screen.
    * pre none
    * pram none
    * return none
    * post none
    */
    public void showScreen()
    {
        setVisible(true);
    }//ends showScreen
    
    /**
    * This will add the text.
    * pre none
    * pram text
    * return none
    * post none
    */
    public void addText(String ... text)
    {
        for(String current : text)
        {
            JLabel thing;
            thing = new JLabel(current);
            thing.setAlignmentX(CENTER_ALIGNMENT);
            add(thing);
        }//ends forEach
    }//ends addText
    
    /**
    * This will add the buttons.
    * pre none
    * pram button
    * return none
    * post none
    */
    public void addButtons(JButton[] button)
    {
        myButtonPanel = new JPanel();
        myButtonPanel.setLayout(new BoxLayout(myButtonPanel, BoxLayout.X_AXIS));
        for(JButton current : button)
        {
            myButtonPanel.add(current);
        }//ends forEach
        add(myButtonPanel);
    }//edns addButtons
    
    /**
    * This will refresh the screen.
    * pre none
    * pram updatedText
    * return none
    * post none
    */
    public void refresh(String[]  updatedText)
    {
        getContentPane().removeAll();
        addText(updatedText);
        add(myButtonPanel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }//ends refresh
}//ends GameScreen
