package javagram.filters;

import javagram.Picture;

public class UndoFilter implements Filter {

	public Picture process(Picture original) {      
		return original;
	}

}
