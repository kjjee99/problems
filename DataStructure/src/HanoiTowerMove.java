
public class HanoiTowerMove {

	public void Move(int num, char from, char by, char to) {
		if(num == 1) {
			System.out.println("원반1을  "+from+"에서  "+to+"로 이동");
		}
		else {
			Move(num-1, from, to, by);
			System.out.println("원반"+num+"을(를) "+from+"에서 "+to+"로 이동");
			Move(num-1, by, from, to);
		}
	}
	
	public static void main(String[] args) {
		HanoiTowerMove htm = new HanoiTowerMove();
		htm.Move(3, 'A', 'B', 'C');
		return;
	}

}
