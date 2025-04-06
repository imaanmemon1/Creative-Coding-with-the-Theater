import org.code.theater.*;
import org.code.media.*;

/**
 * Represents the royal ball scene with animated guests
 * Handles drawing all visual elements and managing guest arrivals
 */
public class BallScene extends Scene {
  private Guest[] guests;
  private int guestCount;
  private int happinessLevel;

  /**
   * Creates a new ball scene with specified guests
   * guests Array of Guest objects to animate
   */
  public BallScene(Guest[] guests) {
    this.guests = guests;
    this.guestCount = 0;
    this.happinessLevel = 0;
  }

  /**
   * Animates guests entering the ballroom one by one
   * @precondition guests array must be initialized
   * @postcondition All guests have entered and stats are updated
   */
  public void greetGuests() {
    for (int index = 0; index < guests.length; index++) {
      for (int x = 0; x < 300; x += 20) {
        drawImage(guests[index].getImage(), x, guests[index].getY(), guests[index].getSize()); 
        drawBackgroundStats();
      } 
      
      guestCount++;
      happinessLevel += 10;
      
      drawBackgroundStats();
      playSound("magical-twinkle-242245.wav");
    }     
  }

  /**
   * Draws animated dance floor effects
   */
  public void drawDanceFloor() {
    for (int h = 0; h < 100; h += 10) {
      for (int y = 320; y < 360; y += 10) {
        drawDanceFloorEffects(h);
        drawGuestNames(y);
      }
    }
  }
  
  /**
   * Draws static background elements
   */
  public void drawBackground() {
    pause(0.2);
    drawImage("ballroom.png", 0, 0, 500);
    drawBallroomElements();
    drawImage("sofia.png", 150, 250, 100);
    
    setTextHeight(9);
    drawText("Happiness:", 240, 255);
    drawText("Guests:", 240, 270);
    drawText("Royal Ball", 240, 225);
  }
  
  /**
   * Main scene creation method
   */
  public void createScene() {
    pause(1);
    greetGuests();
    drawDanceFloor();
  }
  /**
   * Draws decorative ballroom elements
   */
  private void drawBallroomElements() {
    int[][] elements = { {232, 210, 95, 80}, {236, 215, 85, 15}, {236, 240, 85, 40} };

    for (int row = 0; row < elements.length; row++) {
      if (row == 0) {
        setFillColor("gold");
      }
      else {
        removeStrokeColor();
        setFillColor("purple");
      }
      drawRectangle(elements[row][0], elements[row][1], elements[row][2], elements[row][3]);
    }
  }

  /**
   * Displays guest names on the dance floor
   */
  private void drawGuestNames(int y) {
    for (int index = 0; index < guests.length; index++) {
      setTextHeight(8);
      drawText(guests[index].getName(), 295, y);
      y += 20;
    }
  }

  /**
   * Draws animated purple rectangles for dance floor
   */
  private void drawDanceFloorEffects(int height) {
    setFillColor("purple");
    drawRectangle(290, 305, 70, height);
  }

  /** 
   * Updates happiness display 
   */
  private void showHappiness() {
    drawText("" + happinessLevel, 290, 255);
  }
  
  /** 
   * Updates guest count display 
   */
  private void showGuestCount() {
    drawText("" + guestCount, 278, 270);
  }

  /** Redraws background with updated stats */
  private void drawBackgroundStats() {
    drawBackground();
    showGuestCount();
    showHappiness();
  }
}