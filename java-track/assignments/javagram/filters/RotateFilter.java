package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class RotateFilter implements Filter {

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.height(), original.width());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  // 
	    	  Color c = original.get(i, j);
	    	  processed.set(original.height() - 1 - j, i, c);
	    	  
	      }
	    }
		
		return processed;
	}

}
