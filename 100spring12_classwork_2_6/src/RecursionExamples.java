import java.io.File;

import javax.swing.JFileChooser;

public class RecursionExamples {

	public boolean isPowerOfTwo(int n) {
		System.out.println("isPowerOfTwo called for n=" + n);

		if (n == 1) {
			System.out.println("isPowerOfTwo RETURNING TRUE n=1");
			return true; // 1 is 2 to the 0th power
		}
		if (n % 2 != 0) {
			// if n is not a multiple of two, it
			// can't be a power of two
			// (n % 2) is the remainder when n/2
			System.out.println("isPowerOfTwo RETURNING FALSE n=" + n);
			return false;
		}
		// we know at this point 2 divides n evenly
		// LOOK AT THIS LINE CAREFULLY!
		boolean result = isPowerOfTwo(n / 2);
		System.out.println("isPowerOfTwo RETURNING " + result + " n=" + n);
		return result;
	}

	public int findPowerOfTwo(int n) {
		if (n == 1) {
			return 0;
		}

		if (n % 2 != 0) {
			return -1;
		}
		int power = findPowerOfTwo(n / 2);
		if (power == -1) {
			return -1;
		}

		power++;
		return power;
	}

	public File getADirectory() {
		JFileChooser ourOpenChooser = new JFileChooser(System.getProperties()
				.getProperty("user.dir"));
		ourOpenChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		ourOpenChooser.setAcceptAllFileFilterUsed(false);
		int action = ourOpenChooser.showOpenDialog(null);
		if (action == JFileChooser.APPROVE_OPTION) {
			return ourOpenChooser.getSelectedFile();
		}
		return null;
	}

	public static long THRESHOLD = 1000000L; // one million bytes

//	public void findBig(File dir, String tab) {
//		File[] dirContents = dir.listFiles();
//		System.out.println(tab + "**:" + dir.getPath());
//		for (File f : dirContents) {
//			if (f.isDirectory()) {
//				findBig(f, tab + "\t");
//			} else {
//				if (f.length() > THRESHOLD) {
//					System.out
//							.printf("%s%s%8d\n", tab, f.getName(), f.length());
//				}
//			}
//		}
//	}

	public File findBig(File dir) {
		File[] dirContents = dir.listFiles();
		System.out.println("\t**:" + dir.getPath());
		File biggestFill= null;
		for (File f : dirContents) {
			if (f.isDirectory()) {
				return findBig(f);
			} else {
				if (f.length() > THRESHOLD) {
					return f;
				}
			}
		}
		return biggestFill;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		RecursionExamples ex = new RecursionExamples();
		//int numToTest = 60;
		// if(ex.isPowerOfTwo(numToTest)) {
		// System.out.println(numToTest + " is a power of 2");
		// } else {
		// System.out.println(numToTest + " is a NOT power of 2");
		// }

		//System.out.println(numToTest + " is 2 to the power of "
		//		+ ex.findPowerOfTwo(numToTest));

		File selectedDirectory = ex.getADirectory();
		 ex.findBig(selectedDirectory);
	}

}
