public class ListArr {
	
	static int LISTLEN = 100;
	private Object[] pList = new Object[LISTLEN];
	private int numOfData;
	
	
	public ListArr() {		//리스트 초기화
		numOfData = 0;		//데이터 입력값 개수
	}
	
	public void LInsert(Object data) {		//리스트에 데이터 삽입
		
		if(numOfData >= LISTLEN) {		//리스트 용량 초과시
			System.out.println("save unavailable");
			return;
		}
		
		pList[numOfData] = data;		//데이터 저장
		numOfData++;					//데이터 개수 증가
	}
	
	public void LRemove(Object data) {		//리스트 데이터 삭제
		Object[] arr = pList;
		
		for(int i = 0; i<numOfData-1; i++) {
			if(data == pList[i]) {
				pList[i] = pList[i+1];
				while(i+1 != numOfData) {
					i++;
					pList[i] = pList[i+1];
				}
			}
		}
		
		numOfData--;
		pList = arr;
		return;
	}
	
	public void LAdd(int index, Object data) {		//리스트 중간에 데이터 추가
		for(int i = numOfData; i > index; i--) {
			pList[i] = pList[i-1];
		}
		
		pList[index] = data;
		numOfData++;
		return;
	}
	
	public void LFind(Object data) {				//리스트 데이터 찾기
		int index = -1;
		
		for(int i = 0; i < numOfData; i++) {
			if(pList[i] == data)
				index = i + 1;
		}
		if(index == -1)
			System.out.println(data+"가 존재하지 않습니다.");
		else
			System.out.println(data+"의 위치는 "+index);
	}
	
	public Object[] LGet() {						//리스트 반환
		return pList;
	}
	
	public int LCount(Object[] list) {				//리스트 데이터 개수
		return numOfData;
	}
	
	
	public static void main(String[] args) {
		Object[] list;
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
		la.LFind(44);
		
		//리스트 출력
		System.out.println("List");
		for(int i = 0; i < la.LCount(list); i++)
			System.out.print(list[i]+" ");
		System.out.println();
		
		System.out.print("현재 데이터의 수 : "+la.LCount(list));
		
		System.out.println();
		return;
	}

}
