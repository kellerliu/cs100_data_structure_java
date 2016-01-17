import java.util.*;

public class WordMarkovModel extends AbstractModel {

	private String myString;
	private String[] myWordArray;
	private Random myRandom;
	private Map<WordNgram, ArrayList<WordNgram>> myMap;
	public static final int DEFAULT_COUNT = 100;
	private int pren = -1;
	private String preString = "";

	public WordMarkovModel() {

		myRandom = new Random(1234);
		myMap = new HashMap<WordNgram, ArrayList<WordNgram>>();
		// myMap = new TreeMap<WordNgram, ArrayList<WordNgram>>();

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
		int n = Integer.parseInt(nums[0]);
		int numWords = DEFAULT_COUNT;
		if (nums.length > 1) {
			numWords = Integer.parseInt(nums[1]);
		}
		clear();
		WordMarkov(n, numWords);
	}

	public void WordMarkov(int k, int numWords) {
		myWordArray = myString.split("\\s+");
		int j = myWordArray.length;
		String[] wrapAroundWords = new String[j + k];
		System.arraycopy(myWordArray, 0, wrapAroundWords, 0, j);
		String build = "";
		ArrayList<WordNgram> seedList;
		int start = myRandom.nextInt(myWordArray.length - k + 1);
		WordNgram nwords = new WordNgram(myWordArray, start, k);
		double stime = System.currentTimeMillis();

		for (int i = 0; i < k; i++) {
			wrapAroundWords[j + i] = myWordArray[i];
		}

		if ((k != pren) || (myString != preString)) {
			myMap.clear();
			for (int i = 0; i < j; i++) {
				WordNgram ngram = new WordNgram(wrapAroundWords, i, k);
				if (!myMap.containsKey(ngram))
					myMap.put(ngram, new ArrayList<WordNgram>());
				WordNgram nextngram = new WordNgram(wrapAroundWords, i + 1, k);
				ArrayList<WordNgram> ngramList = myMap.get(ngram);
				ngramList.add(nextngram);
			}
			pren = k;
			preString = myString;
		}

		for (int t = 0; t < numWords; t++) {
			seedList = myMap.get(nwords);
			int pick = myRandom.nextInt(seedList.size());
			nwords = seedList.get(pick);
			build += nwords.wordAt(k - 1)+" ";
			
		}

		double etime = System.currentTimeMillis();
		double time = (etime - stime) / 1000.0;
		this.messageViews("time to generate: " + time);
		System.out.println("number of keys: " + myMap.size()
				+ "; time to generate: " + time);
		this.notifyViews(build);

	}

}
