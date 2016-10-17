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
	private static String absFileName = "";
	private static boolean fileExists = false;

	public static void main(String[] args) {

		in = new Scanner(System.in);

		//get filename
		getFilename();
		
//		saveLoop();
		
		boolean exitSwitch = false;
		do {
			saveUndoExitMenu();	// save/undo/exit prompt

			switch (fileName) {
			case "undo":
				undoLoop();
				break;

			case "exit":
				System.out.println("Image not saved");
				in.close();	
				System.exit(0);
				exitSwitch = true;
				break;

			default:
				while (!fileName.endsWith(".jpg") && !fileName.endsWith(".png")) {
					System.out.println("Error: filename must end in .jpg or .png");
				}
				break;
			}
		} while (!exitSwitch);
		
		undoLoop();
		saveExitLoop();
		fileExists();
		overwriteLoop();	
		
		
		System.out.println("out of loop");

		//		} finally {
		System.out.println("in finally");
		// close input scanner
		in.close();	
		System.exit(0);
		//		}

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

	private static String saveUndoExitMenu() {
		// save image, if desired
		System.out.println("Save image to (relative to " + dir + ")");
		System.out.println("Type 'exit' to quit w/o saving");
		System.out.println("Type 'undo' to undo filter:");

		fileName = in.next();
		return fileName;
	}
	
	private static void undoLoop() {
		do {
			applyFilter(); // apply filter
			saveUndoExitMenu();	// save/undo/exit prompt
		} while (fileName.equals("undo"));
	}

	private static void saveExitLoop() {
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			while (!fileName.endsWith(".jpg") && !fileName.endsWith(".png")) {
				System.out.println("Error: filename must end in .jpg or .png");
				saveLoop();	// save/undo/exit prompt
			}
		}
	}
	
	

	private static void fileExists() {
		File folder = new File(dir); // create file object of dir
		File[] listOfFiles = folder.listFiles(); //create list of files in dir

		for (File file : listOfFiles) { // loop through files
			if (file.isFile()) { // confirm file is a file (not a folder)
//				System.out.println(file.getName());
				if (fileName.equals(file.getName())) {
					fileExists = true;
				}
			}
		}
	}
	
	private static void saveLoop() {
		undoLoop();
		saveExitLoop();
		fileExists();
		overwriteLoop();
	}	
	
	private static void overwriteLoop() {
		do { // outer loop (filename check loop)
			if (fileExists) { // if filename entered is in file list
				System.out.println("Overwrite " + fileName + "?"); // prompt user for input
				boolean innerLoop = true; // inner loop repeat variable
				do { // inner loop (overwrite loop)
					String response = in.next(); // scanner String variable
					if (response.equals("y")) { // overwrite file
						savePicture(); // save
						innerLoop = false; // exit inner loop (overwrite loop)
						//									outerLoop = false; // exit outer loop (filename check loop)
						//				    					stopLoop = true;
					} else if (response.equals("n")) { // do not overwrite file
						fileExists = false;
						innerLoop = false; // exit inner loop (overwrite loop)
						
						saveLoop();	// save/undo/exit prompt
						
					} else {
						System.out.println("Please enter 'y' or 'n'"); // input validation
						// reprompt
					}
				} while (innerLoop);
				// TODO - stop else if from running when overwriting file (should only fire on new filename)
			} else if (fileName != "exit") {
				savePicture(); // runs even if overwriting existing file?
			}
		} while (absFileName.isEmpty());
	}
	
	private static void savePicture() {
		absFileName = dir + File.separator + fileName;
		processed.save(absFileName);
		System.out.println("Image saved to " + absFileName);
	}

}