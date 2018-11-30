
public class RecursionLinkedList {
	private Node head;
	private static char UNDEF = Character.MIN_VALUE;

	/**
	 * ���Ӱ� ������ ��带 ����Ʈ�� ó������ ����
	 */
	private void linkFirst(char element) {
		head = new Node(element, head); // ���� ������ ��忡 element�� �ְ� head�� ����.
	}

	/**
	 * ���� (1) �־��� Node x�� ���������� ����� Node�� �������� ���Ӱ� ������ ��带 ����
	 *
	 * @param element
	 *            ������
	 * @param x
	 *            ���
	 */
	
	private void linkLast(char element, Node x) { 
		if (x.next == null) { // ������尡 null�̸� ��, ���� ��ġ�� ����̸�
			// ���� ���ҷ� ����
			Node node = new Node(element, null); // �� ��带 �����ϰ�
			x.next = node; // x.next�� ����
			
		} else {
			linkLast(element, x.next); // x.next�� null �� �� ���� �ݺ�
			// ���� ��� �湮 recursion
		}
	}
	
	
	/**
	 * ���� Node�� ���� Node�� ���Ӱ� ������ ��带 ����
	 *
	 * @param element
	 *            ����
	 * @param pred
	 *            �������
	 */
	private void linkNext(char element, Node pred) {
		Node next = pred.next;
		pred.next = new Node(element, next);
	}

	/**
	 * ����Ʈ�� ù��° ���� ����(����)
	 *
	 * @return ù��° ������ ������
	 */
	private char unlinkFirst() {
		Node x = head;
		char element = x.item;
		head = head.next;
		x.item = UNDEF;
		x.next = null;
		return element;
	}

	/**
	 * ����Node�� ���� Node���� ����(����)
	 *
	 * @param pred
	 *            �������
	 * @return ��������� ������
	 */
	private char unlinkNext(Node pred) {
		Node x = pred.next;
		Node next = x.next;
		char element = x.item;
		x.item = UNDEF;
		x.next = null;
		pred.next = next;
		return element;
	}

	/**
	 * ���� (2) x��忡�� index��ŭ ������ Node ��ȯ
	 */
	private Node node(int index, Node x) {
		// ä���� ���, index�� �ٿ����鼭 ���� ��� �湮
		if (index == 0) // index�� 0 �� ��� ��� �̵��� ������ ������ Node x�� ��ȯ.
			return x;
		else {
			index--; // index�� 0�� �ƴϸ� ��ĭ �̵��ؾ� �ϹǷ� index 1 ����
			return node(index, x.next); // ���ҵ� index�� x.next���� �ٽ� ����.
		}
	}

	/**
	 * ���� (3) ���κ��� �������� ����Ʈ�� ��� ���� ��ȯ
	 */
	private int length(Node x) { // ������
		// ä���� ���, recusion ���
		if(x == null) // �ش� node�� null �̸� 0
			return 0;
		else
			return length(x.next) + 1; // ���� ���� �̵��ϰ� +1 �Ͽ� length �޼ҵ� �ٽ� ����.
	}

	/**
	 * ���� (4) ���κ��� �����ϴ� ����Ʈ�� ���� ��ȯ
	 */
	private String toString(Node x) {
		// ä���� ���, recusion ���
		if (x == null) // x��尡 null �̸� null String ��ȯ.
			return "";
		else
			return x.item + " " + toString(x.next); // x��忡 ����ִ� element�� �� �տ� �߰��ϰ�,
		// ���� ������ �ٽ� ����.
	}

	/**
	 * ���� ����� ���� ������ ����Ʈ�� �������� �Ųٷ� ���� ex)��尡 [s]->[t]->[r]�� ��, reverse ���� ��
	 * [r]->[t]->[s]
	 * 
	 * @param x
	 *            ���� ���
	 * @param pred
	 *            �������� ���� ���
	 */
	private void reverse(Node x, Node pred) {
		// ä���� ���, recuison ���
	}

	/**
	 * ���Ҹ� ����Ʈ�� �������� �߰�
	 */
	public boolean add(char element) {
		if (head == null) {
			linkFirst(element); // ù ���� head�� null �ϰ�� linkFirst ����
		} else {
			linkLast(element, head);
		}
		return true;
	}

	/**
	 * ���Ҹ� �־��� index ��ġ�� �߰�
	 *
	 * @param index
	 *            ����Ʈ���� �߰��� ��ġ
	 * @param element
	 *            �߰��� ������
	 */
	public void add(int index, char element) {
		if (!(index >= 0 && index <= size()))
			throw new IndexOutOfBoundsException("" + index);
		if (index == 0)
			linkFirst(element);
		else
			linkNext(element, node(index - 1, head)); // (b, node(2, head));
	}

	/**
	 * ����Ʈ���� index ��ġ�� ���� ��ȯ
	 */
	public char get(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);
		return node(index, head).item;
	}

	/**
	 * ����Ʈ���� index ��ġ�� ���� ����
	 */
	public char remove(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);
		if (index == 0) {
			return unlinkFirst();
		}
		return unlinkNext(node(index - 1, head));
	}

	/**
	 * ����Ʈ�� �Ųٷ� ����
	 */
	public void reverse() {
		reverse(head, null);
	}

	/**
	 * ����Ʈ�� ���� ���� ��ȯ
	 */
	public int size() {
		return length(head);
	}

	@Override
	public String toString() {
		if (head == null)
			return "[]";
		return "[ " + toString(head) + "]";
	}

	/**
	 * ����Ʈ�� ���� �ڷᱸ��
	 */
	private static class Node {
		char item;
		Node next;

		Node(char element, Node next) {
			this.item = element;
			this.next = next;
		}
	}
}