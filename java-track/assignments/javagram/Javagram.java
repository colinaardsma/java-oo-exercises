package javagram;

import javagram.filters.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {
	
	private static Filter filter = null;
	private static Scanner in;
	private static Picture picture = null;
	private static String[] baseParts = {System.getProperty("user.dir"), "images"};
	private static String dir = String.join(File.separator, baseParts);
	private static Picture processed = null;
	private static String fileName = "";
	
	public static void main(String[] args) {
		
		 in = new Scanner(System.in);

		//get filename
		getFilename();

		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		do {
			applyFilter(); //apply filter
			saveUndoExit();	//save/undo/exit
		} while (fileName.equals("undo"));

		try {
			if (fileName.equals("exit")) {
				System.out.println("Image not saved");
			} else {
				File folder = new File(dir);
				File[] listOfFiles = folder.listFiles();

				for (File file : listOfFiles) {
				    if (file.isFile()) {
				    	boolean outerLoop = true;
				    	do {
				    		if (fileName.equals(file.getName())) {
				    			System.out.println("Overwrite " + file.getName() + "?");
				    			boolean innerLoop = true;
				    			do {
				    				String response = in.next();
				    				if (response.equals("y")) {
				    					innerLoop = false;
				    					outerLoop = false;
				    					savePicture();
				    				} else if (response.equals("n")) {
				    					innerLoop = false;
				    					saveUndoExit();	//save/undo/exit
				    				} else {
				    					System.out.println("Please enter 'y' or 'n'");
				    					//reprompt
				    				}
				    			} while (innerLoop);
// TODO - stop else if from running when overwriting file (should only fire on new filename)
				    		} else if (!fileName.equals(file.getName())) {
				    			savePicture(); //runs even if overwriting existing file?
				    			outerLoop = false;
				    		}
				    	} while (outerLoop);
				    }
				}

			}	
		} finally {
			// close input scanner
			in.close();	
			System.exit(0);
		}

	}
	
	private static Filter displayFilterMenu(Scanner in) {
		do {
			try{
				System.out.println("Choose a filter:");
				System.out.println("1. Red Filter");
				System.out.println("2. Green Filter");
				System.out.println("3. Blue Filter");
				System.out.println("4. Greyscale Filter");
				System.out.println("5. Negative Filter");

				int filterChoice = in.nextInt();	
				
				// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
				filter = getFilter(filterChoice);
				if (filter == null) { 
					throw new NullPointerException();
				}
			} catch (NullPointerException e) {
				System.out.println("Invalid selection. Please choose again.");
			}
		} while(filter == null);
		return filter;
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int i) {
		
		// TODO - create some more filters, and add logic to return the appropriate one
		if(i == 1) {
			return new RedFilter();
		} else if(i == 2) {
			return new GreenFilter();
		} else if(i == 3) {
			return new BlueFilter();
		} else if (i == 4) {
			return new GreyscaleFilter();
		} else if (i == 5) {
			return new NegativeFilter();
		}
		return null;
	}
	
	private static Picture getFilename() {
		// Create the base path for images		
		String relPath;
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();
				
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		return picture;
	}
	
	private static void applyFilter() {
		// TODO - prompt user for filter and validate input		
		filter = displayFilterMenu(in);
		
		// filter and display image
		processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
	}
	
	private static String saveUndoExit() {
		// save image, if desired
		System.out.println("Save image to (relative to " + dir + ")");
		System.out.println("Type 'exit' to quit w/o saving");
		System.out.println("Type 'undo' to undo filter:");
		
		fileName = in.next();
		return fileName;
	}
	
	private static void savePicture() {
		String absFileName = dir + File.separator + fileName;
		processed.save(absFileName);
		System.out.println("Image saved to " + absFileName);
	}
	
	

}