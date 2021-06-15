public class ListArr {
	
	static int LISTLEN = 100;
	private int[] pList = new int[LISTLEN];
	private int numOfData;
	private int curPosition;			//커서 확인
	
	
	public ListArr() {		//리스트 초기화
		numOfData = 0;		//데이터 입력값 개수
		curPosition = -1;	//커서 위치
	}
	
	public void LInsert(int data) {		//리스트에 데이터 삽입
		
		if(numOfData >= LISTLEN) {		//리스트 용량 초과시
			System.out.println("save unavailable");
			return;
		}
		
		pList[numOfData] = data;		//데이터 저장
		numOfData++;					//데이터 개수 증가
	}
	
	public void LRemove(int data) {		//리스트 데이터 삭제
		int rpos = 0;
		int num = numOfData;
		int i = 0;
		
		int[] arr = pList;
		
		for(i = rpos; i<num-1; i++) {
			if(data == pList[i])
				pList[i] = pList[i+1];
		}
		
		numOfData--;
		rpos = curPosition;
		pList = arr;
		return;
	}
	
	public void LAdd(int index, int data) {		//리스트 중간에 데이터 추가
		
	}
	
	public int LFind(int data) {				//리스트 데이터 찾기
		int index = 0;
		
		return index;
	}
	
	public int[] LGet() {						//리스트 반환
		return pList;
	}
	
	public int LCount(int[] list) {				//리스트 데이터 개수
		return numOfData;
	}
	
	
	public static void main(String[] args) {
		int[] list;
		ListArr la = new ListArr();
		
		//데이터 삽입
		la.LInsert(11);
		la.LInsert(11);
		la.LInsert(22);
		la.LInsert(22);
		la.LInsert(33);
		la.LInsert(423);

		//리스트 저장
		list = la.LGet();
		
		System.out.println("현재 데이터의 수 : "+la.LCount(list));
		
		//리스트 데이터 삭제
		la.LRemove(22);
		la.LRemove(22);
		
		//리스트 데이터 추가
		la.LAdd(2, 55);
		
		//리스트 데이터 찾기
		la.LFind(33);
		
		
		//리스트 출력
		for(int i = 0; i < la.LCount(list); i++)
			System.out.println(list[i]);
		
		System.out.print("현재 데이터의 수 : "+la.LCount(list));
		
		System.out.println();
		return;
	}

}
