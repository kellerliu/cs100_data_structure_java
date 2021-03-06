import java.util.*;

//New extend class for MapMarkovModel


public class MapMarkovModel extends AbstractModel {

	private String myString;
	private Random myRandom;
	public static final int DEFAULT_COUNT = 100;
	private Map<String, ArrayList<String>> myMap;
	private int prek = -1;

	public MapMarkovModel() {

		myRandom = new Random(1234);
		myMap = new HashMap<String, ArrayList<String>>();
	}

	public void initialize(Scanner s) {
		double start = System.currentTimeMillis();
		int count = readChars(s);
		double end = System.currentTimeMillis();
		double time = (end - start) / 1000.0;
		super.messageViews("#read: " + count + " chars in: " + time + " secs");
	}

	protected int readChars(Scanner s) {
		myString = s.useDelimiter("\\Z").next();
		s.close();
		return myString.length();
	}

	public void process(Object o) {
		String temp = (String) o;
		String[] nums = temp.split("\\s+");
		int k = Integer.parseInt(nums[0]);
		int numLetters = DEFAULT_COUNT;
		if (nums.length > 1) {
			numLetters = Integer.parseInt(nums[1]);
		}
		clear();
		map(k, numLetters);
	}

	public void map(int k, int numLetters) {
		int start = myRandom.nextInt(myString.length() - k + 1);
		String str = myString.substring(start, start + k);
		String wrapAroundString = myString + myString.substring(0, k);
		StringBuilder build = new StringBuilder();

		double stime = System.currentTimeMillis();

		if (k != prek) {
			myMap.clear();
			for (int i = 0; i < myString.length(); i++) {
				String kgram = wrapAroundString.substring(i, i + k);
				if (!myMap.containsKey(kgram)) {
					myMap.put(kgram, new ArrayList<String>());
				}
				String followingkgram = kgram.substring(1)
						+ wrapAroundString.charAt(i + k);
				ArrayList<String> kgramList = myMap.get(kgram);
				kgramList.add(followingkgram);
			}
			prek = k;
		}

		for (int j = 0; j < numLetters; j++) {
			ArrayList<String> mapList = myMap.get(str);
			int pick = myRandom.nextInt(mapList.size());
			str = mapList.get(pick);
			build.append(str.charAt(k - 1));
		}
		double etime = System.currentTimeMillis();
		double time = (etime - stime) / 1000.0;
		this.messageViews("time to generate: " + time);
		this.notifyViews(build.toString());
	}

}
