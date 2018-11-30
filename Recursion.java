
public class Recursion {
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
		System.out.println(recursiveAnt(10));
	}

	public static int fibonacci(int n) {
		if (n <= 1) // n�� 1���� ���ų� ���� ���
			return n; // n�� return
		else
			return fibonacci(n - 1) + fibonacci(n - 2); // �ƴҰ�� ����, ������ �� ���� ���Ͽ�
		//�Ǻ���ġ ������ �ϼ�

	}

	public static String recursiveAnt(int n) {
		if (n == 1) { // n==1 �� ��� 1�� return
			return "1";
		} else {
			return makeResult(recursiveAnt(n - 1)); // makeResult�� n=10�� ��� makeResult("1") ���� 9�� ����
		}
	}

	public static String makeResult(String previous) {
		if (previous != "22") { // ������ "22"��� �� ������ 22, 22, 22 ... �� ���̻� �þ�� ����.

			String makedSequence = "";
			char tempChar = previous.charAt(0); // �ʱⰪ 1 �ϳ�.
			int cnt = 1; // cnt�� 1���� ���� (�����ϴ� ��)

			for (int a = 1; a < previous.length(); a++) { // ���� string�� ���̸�ŭ �ݺ�
				if (tempChar == previous.charAt(a))
					cnt++; // 111... ó�� ���� ���� �ݺ� �� ������ cnt ����
				else {
					makedSequence += tempChar; // ���� ���� �����ٰ� �ٸ� ���� ���� ��쿡 tempChar�� ������
					makedSequence += cnt; // cnt�� ������.
					cnt = 1; // ��� ������ ��ģ �� cnt�� 1�� �ʱ�ȭ.
					
					tempChar = previous.charAt(a); // tempChar�� ���� ��Ʈ���� a��° char�� �ʱ�ȭ.					
				}
			}
			makedSequence += tempChar; // tempChar�� ����� ���� ��Ʈ���� a��° char�� ������.
			makedSequence += cnt; // ī���� �� ���� ������.
			
			return makedSequence; // �ϼ��� ������ return�Ѵ�.
		}
		return null;
	}

}
