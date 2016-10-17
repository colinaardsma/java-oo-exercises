package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class NegativeFilter implements Filter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newR = 255 - r;
	          int newG = 255 - g;
	          int newB = 255 - b;
	          
	          processed.set(i, j, new Color(newR, newG, newB));
	    	  
	      }
	    }
		
		return processed;
	}

}
