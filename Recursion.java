
public class Recursion {
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		System.out.println(recursiveAnt(10));
	}

	public static int fibonacci(int n) {
		if (n <= 1) // n이 1보다 같거나 작을 경우
			return n; // n을 return
		else
			return fibonacci(n - 1) + fibonacci(n - 2); // 아닐경우 이전, 이전전 의 수를 더하여
		//피보나치 수열을 완성

	}

	public static String recursiveAnt(int n) {
		if (n == 1) { // n==1 일 경우 1을 return
			return "1";
		} else {
			return makeResult(recursiveAnt(n - 1)); // makeResult는 n=10일 경우 makeResult("1") 부터 9번 실행
		}
	}

	public static String makeResult(String previous) {
		if (previous != "22") { // 시작이 "22"라면 이 수열은 22, 22, 22 ... 로 더이상 늘어나지 않음.

			String makedSequence = "";
			char tempChar = previous.charAt(0); // 초기값 1 하나.
			int cnt = 1; // cnt는 1부터 시작 (증가하는 수)

			for (int a = 1; a < previous.length(); a++) { // 이전 string의 길이만큼 반복
				if (tempChar == previous.charAt(a))
					cnt++; // 111... 처럼 같은 수가 반복 될 때마다 cnt 증가
				else {
					makedSequence += tempChar; // 같은 수가 나오다가 다른 수가 나올 경우에 tempChar을 붙히고
					makedSequence += cnt; // cnt를 붙힌다.
					cnt = 1; // 모든 과정을 마친 후 cnt를 1로 초기화.
					
					tempChar = previous.charAt(a); // tempChar를 이전 스트링의 a번째 char로 초기화.					
				}
			}
			makedSequence += tempChar; // tempChar에 저장된 이전 스트링의 a번째 char를 붙히고.
			makedSequence += cnt; // 카운팅 된 수를 붙힌다.
			
			return makedSequence; // 완성된 수열을 return한다.
		}
		return null;
	}

}
