import org.code.theater.*;
import org.code.media.*;

public class GenericGuest extends Guest {
  public GenericGuest() {
    super("genericGuest.png");
  }
  
  public String getName() {
    return "Noble Guest";
  }

  public int getY() {
    return 250;
  }

  public int getSize() {
    return 100;
  }
}