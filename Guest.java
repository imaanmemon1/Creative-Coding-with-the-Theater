import org.code.theater.*;
import org.code.media.*;

public class Guest {
  private String image;

  public Guest(String image) {
    this.image = image;
  }
  
  public String getImage() {
    return image;
  }

  public String getName() {
    return "Guest";
  }

  public int getY() {
    return 250;
  }
  
  public int getSize() {
    return 100;
  }
}