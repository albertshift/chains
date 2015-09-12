import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class MissingNumber {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<Integer>();

		for (int i = -3000; i != 7001; ++i) {
			arr.add(i);
		}

		SecureRandom random = new SecureRandom();

		int i = random.nextInt(10000);

		//System.out.println("size = " + arr.size());
		//System.out.println("i = " + i);

		int missingNum = arr.remove(i);

		System.out.println("missingNum = " + missingNum);

		int m = findMissingNumber(arr.toArray(new Integer[0]));

		System.out.println("m = " + m);

	}

	public static int findMissingNumberByAlex(Integer[] input) {

		int k = 0;
		for (int i = -3000; i != 7001; ++i, ++k) {

			if (i != input[k]) {
				return i;
			}

		}

		throw new RuntimeException("No missing number");
	}

	
	public static int findMissingNumber(Integer[] input) {
    int length = input.length;
    int start = input[0];
    int end = input[length - 1];

    int sum = 0;

    for (int k = start; k <= end; k++) {
           sum += k;
    }

    for (int i = 0; i < input.length; i++) {

           sum = sum - input[i];

    }

    return sum;
}
	
	public static int findMissingNumberOld(Integer[] input) {

		int missingNumber = 0;
		for (int i = 0; i < input.length; i++) {
			
			missingNumber = missingNumber ^ input[i];
			
		}
		
		return missingNumber;
		
		/*
		int length = input.length;
		int start = input[0];

		int sum = start;

		// calculate sum of elements starting from 'start'
		for (int k = 0; k < length; k++) {
			sum += (sum + 1);
		}
		System.out.println(sum);

		for (int i = 0; i < input.length; i++) {

			if (input[i] == null) {
				continue;
			}

			sum = sum - input[i];

		}

		return sum;
		*/
	}

}
