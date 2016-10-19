package javagram;

import javagram.filters.*;
import java.io.File;
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

	public static void main(String[] args) {

		in = new Scanner(System.in);

		// get filename
		getFilename();
		
		// show filter list and get user input
		applyFilter();
		
		boolean exitSwitch = false;
		do {
			saveUndoExitMenu();	// save/undo/exit prompt and get user input

			switch (fileName) {
			case "undo": // undo filter choice (revert to original image)
				applyFilter(); // apply filter
				break;
				
			case "filter":
				applyFilterAgain(); // go back to filter menu and apply another filter
				break;

			case "exit": // exit
				System.out.println("Image not saved");
				in.close();	
				System.exit(0);
				exitSwitch = true;
				break;

			default:
				if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png")) { // confirm file ends with .jpg or .png
					System.out.println("Filename must end in .jpg or .png");
					fileName = "";
					break;
				} else {
					if (fileExists()) {
						overwriteLoop(); // if file exists run overwrite loop (y, n, invalid input check)
					} else { // save and exit
						savePicture();
						in.close();	
						System.exit(0);
						exitSwitch = true;
						break;
					}
				}
			}
		} while (!exitSwitch);
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

	private static Filter displayFilterMenu(Scanner in) {
		do {
			try{
				System.out.println("Choose a filter:");
				System.out.println("1. Red Filter");
				System.out.println("2. Green Filter");
				System.out.println("3. Blue Filter");
				System.out.println("4. Greyscale Filter");
				System.out.println("5. Negative Filter");
				System.out.println("6. Rotate CW");
				System.out.println("7. Flip Horizontal");
				System.out.println("8. Flip Vertical");

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
		} else if (i == 6) {
			return new RotateFilter();
		} else if (i == 7) {
			return new FlipHorFilter();
		} else if (i == 8) {
			return new FlipVerFilter();
		}
		return null;
	}

	private static void applyFilter() {
		// TODO - prompt user for filter and validate input		
		filter = displayFilterMenu(in);

		// filter and display image
		processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");
	}

	private static void applyFilterAgain() {
		// TODO - prompt user for filter and validate input		
		filter = displayFilterMenu(in);

		// filter and display image
		processed = filter.process(processed);
		processed.show();

		System.out.println("Image successfully filtered");
	}

	
	private static String saveUndoExitMenu() {
		// save image, if desired
		System.out.println("Save image to (relative to " + dir + ")");
		System.out.println("Type 'exit' to quit w/o saving");
		System.out.println("Type 'undo' to undo filter");
		System.out.println("Type 'filter' to return to filter menu and apply another filter:");

		fileName = in.next();
		return fileName;
	}
	
	private static boolean fileExists() {
		File folder = new File(dir); // create file object of dir
		File[] listOfFiles = folder.listFiles(); //create list of files in dir

		for (File file : listOfFiles) { // loop through files
			if (file.isFile()) { // confirm file is a file (not a folder)
				if (fileName.equals(file.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static void overwriteLoop() {
		System.out.println("Overwrite " + fileName + "?"); // prompt user for input
		boolean loop = false;
		String response = "";
		do {
			response = in.next(); // scanner String variable
			loop = false;
			switch(response) {
			case "y":
				savePicture();
				in.close();	
				System.exit(0);
				break;

			case "n":
				break;

			default:
				System.out.println("Please enter 'y' or 'n'"); // input validation
				response = "";
				loop = true;
				break;
			}
		} while (loop);

// TODO - stop else if from running when overwriting file (should only fire on new filename)
	}
	
	private static void savePicture() {
		absFileName = dir + File.separator + fileName;
		processed.save(absFileName);
		System.out.println("Image saved to " + absFileName);
	}

}