
public class RecursionLinkedList {
	private Node head;
	private static char UNDEF = Character.MIN_VALUE;

	/**
	 * 새롭게 생성된 노드를 리스트의 처음으로 연결
	 */
	private void linkFirst(char element) {
		head = new Node(element, head); // 최초 생성된 노드에 element를 넣고 head로 지정.
	}

	/**
	 * 과제 (1) 주어진 Node x의 마지막으로 연결된 Node의 다음으로 새롭게 생성된 노드를 연결
	 *
	 * @param element
	 *            데이터
	 * @param x
	 *            노드
	 */
	
	private void linkLast(char element, Node x) { 
		if (x.next == null) { // 다음노드가 null이면 즉, 끝에 위치한 노드이면
			// 다음 원소로 연결
			Node node = new Node(element, null); // 새 노드를 생성하고
			x.next = node; // x.next에 연결
			
		} else {
			linkLast(element, x.next); // x.next가 null 일 때 까지 반복
			// 다음 노드 방문 recursion
		}
	}
	
	
	/**
	 * 이전 Node의 다음 Node로 새롭게 생성된 노드를 연결
	 *
	 * @param element
	 *            원소
	 * @param pred
	 *            이전노드
	 */
	private void linkNext(char element, Node pred) {
		Node next = pred.next;
		pred.next = new Node(element, next);
	}

	/**
	 * 리스트의 첫번째 원소 해제(삭제)
	 *
	 * @return 첫번째 원소의 데이터
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
	 * 이전Node의 다음 Node연결 해제(삭제)
	 *
	 * @param pred
	 *            이전노드
	 * @return 다음노드의 데이터
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
	 * 과제 (2) x노드에서 index만큼 떨어진 Node 반환
	 */
	private Node node(int index, Node x) {
		// 채워서 사용, index를 줄여가면서 다음 노드 방문
		if (index == 0) // index가 0 일 경우 노드 이동이 끝났기 때문에 Node x를 반환.
			return x;
		else {
			index--; // index가 0이 아니면 한칸 이동해야 하므로 index 1 감소
			return node(index, x.next); // 감소된 index로 x.next부터 다시 실행.
		}
	}

	/**
	 * 과제 (3) 노드로부터 끝까지의 리스트의 노드 갯수 반환
	 */
	private int length(Node x) { // 헤드부터
		// 채워서 사용, recusion 사용
		if(x == null) // 해당 node가 null 이면 0
			return 0;
		else
			return length(x.next) + 1; // 다음 노드로 이동하고 +1 하여 length 메소드 다시 실행.
	}

	/**
	 * 과제 (4) 노드로부터 시작하는 리스트의 내용 반환
	 */
	private String toString(Node x) {
		// 채워서 사용, recusion 사용
		if (x == null) // x노드가 null 이면 null String 반환.
			return "";
		else
			return x.item + " " + toString(x.next); // x노드에 들어있는 element를 맨 앞에 추가하고,
		// 다음 노드부터 다시 실행.
	}

	/**
	 * 현재 노드의 이전 노드부터 리스트의 끝까지를 거꾸로 만듬 ex)노드가 [s]->[t]->[r]일 때, reverse 실행 후
	 * [r]->[t]->[s]
	 * 
	 * @param x
	 *            현재 노드
	 * @param pred
	 *            현재노드의 이전 노드
	 */
	private void reverse(Node x, Node pred) {
		// 채워서 사용, recuison 사용
	}

	/**
	 * 원소를 리스트의 마지막에 추가
	 */
	public boolean add(char element) {
		if (head == null) {
			linkFirst(element); // 첫 노드라서 head가 null 일경우 linkFirst 실행
		} else {
			linkLast(element, head);
		}
		return true;
	}

	/**
	 * 원소를 주어진 index 위치에 추가
	 *
	 * @param index
	 *            리스트에서 추가될 위치
	 * @param element
	 *            추가될 데이터
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
	 * 리스트에서 index 위치의 원소 반환
	 */
	public char get(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);
		return node(index, head).item;
	}

	/**
	 * 리스트에서 index 위치의 원소 삭제
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
	 * 리스트를 거꾸로 만듬
	 */
	public void reverse() {
		reverse(head, null);
	}

	/**
	 * 리스트의 원소 갯수 반환
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
	 * 리스트에 사용될 자료구조
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