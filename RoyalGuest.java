import org.code.theater.*;
import org.code.media.*;

public class RoyalGuest extends Guest {
  private String name;

  public RoyalGuest(String name, String image) {
    super(image);
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
}