import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;


public class Spy {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			spyCandidat(line);
		}
		
	}
	
	public static void spyCandidat(String line) {
		
		//String line = "5 1 2 6 3 5";
		
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		
		BitSet bitSet = new BitSet();
		int c = 0;
		int n = 0;
		int prev = 0;
		
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			
			int i = Integer.parseInt(token);
			
			switch(c) {
			
				case 0:
					n = i;
					break;
					
				case 1:
					break;
					
				default: {
					int diff = Math.abs(prev - i);
					if (diff < 1 || diff > n || bitSet.get(diff)) {
						bitSet.clear();
						break;
					}
					bitSet.set(diff);
				}
					
			}
			
			prev = i;
			c++;
		}
		
		if (bitSet.isEmpty()) {
			System.out.println("Not a Candidate ");
		}
		else {
			System.out.println("Candidate");
		}
		
	}
	
}
