package lab13;
import java.util.*;
import java.io.*;
public class lin_lab13 {
	ArrayList<Integer> input_file_values = new ArrayList<Integer>();
	public void readData(String filename) {
		try {
			String inn;
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while ((inn = input.readLine()) != null) {
				Integer input_value = Integer.parseInt(inn);
				input_file_values.add(input_value);
			}
			input.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	public long getTotalCount() {
		return input_file_values.stream().count();
		
	}
	public long getOddCount() {
		return input_file_values.stream().filter(x -> x % 2 == 1).count();
	}
	public long getEvenCount() {
		return input_file_values.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount() {
		return input_file_values.stream().filter(x -> x > 5).distinct().count();
	}
	public Integer[] getResult1() {
		return input_file_values.stream().filter(x -> x > 5).filter(x -> x < 50).filter(x -> x % 2 == 0).sorted().toArray(Integer[]:: new);
	}
	public Integer[] getResult2() {
		return input_file_values.stream().limit(50).map(x -> x*x).map( x -> 3 * x).toArray(Integer[]::new);
	}
	public Integer[] getResult3() {
		return input_file_values.stream().filter(x -> x % 2  == 1).map( x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
