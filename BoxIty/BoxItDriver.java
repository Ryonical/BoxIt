
/**
 * This drives the program.
 * 
 * @Ryan Keeler
 * @BoxIt
 */
public class BoxItDriver
{
    /**
    * This will run the program.
    * @pre none
    * @pram none
    * @return none
    * @post none
    */
    public static void main(String[] args)
    {
        BoxIt box = new BoxIt();
        GameScreen game = new GameScreen();
        Buttons button = new Buttons(box, game);
        button.startScreen();
        button.activate();
        game.showScreen();
    }//ends main
}//ends BoxItDriver