package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class FlipVerFilter implements Filter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  // 
	    	  Color c = original.get(i, j);
	    	  processed.set(i, original.height() - 1 - j, c);
	    	  
	      }
	    }
		
		return processed;
	}

}
