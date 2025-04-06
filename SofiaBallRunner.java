import org.code.theater.*;
import org.code.media.*;

public class SofiaBallRunner {
  /**
   * Enter to the royal ball
   * @param Command line arguments 
   * @precondition Image files must exist in project 
   * @postcondition Animation plays showing guests arriving at the royal ball
   */
  public static void main(String[] args) {
    Guest[] guests = { 
      new RoyalGuest("Princess Amber", "amber.png"), 
      new RoyalGuest("Prince James", "james.png"), 
      new GenericGuest() 
    };

    BallScene myScene = new BallScene(guests);
    myScene.createScene();
    Theater.playScenes(myScene);
  }
}