package local.orenchi;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class SpeedTest {

	// debug variable
	static long allcounter;
	static int zerocounter;
	static int loopcounter;
	
	private static void recurseDecreasing(long cnt) {
		
		allcounter++;
		if (cnt == 0){
			zerocounter++;
			return;
		} else {
			recurseDecreasing(--cnt);
		}
	}
	private static boolean initCalc1() {
		for (int i=0;i<100;i++){
			for (int j=0;j<100;j++){
				recurseDecreasing(100000);
				loopcounter++;
			}
		}
		return true;
	}
	private static boolean initCalc2() {
		IntStream.range(0, 100).forEach(i -> {
			IntStream.range(0, 100).forEach(j -> {
				recurseDecreasing(100000);
				loopcounter++;
			});
		});
		return true;
	}
	
	public static void main(String[] args) {
		
		Instant start = Instant.now();
		System.out.println("Start!");
		allcounter=0;
		zerocounter=0;
		loopcounter=0;
		
		if (initCalc2()){
			System.out.println("End");
			Instant end = Instant.now();
			Duration elapse = Duration.between(start, end);
			System.out.println(elapse + "[s]");
			System.out.println("allcnt:"+allcounter+" zerocnt:"+zerocounter+" loopcnt:"+loopcounter);
		} else {
			System.out.println("Error!");
		}
	}

}
