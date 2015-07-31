package swing;

import java.util.Arrays;

/*
 * @ Date : 2015.07.30
 * @ Author : Chae S W
 * @ Story : 로또(Swing) 예제
 */
public class Lotto {
	int[] lotto = new int[6];

	public int[] getLotto() {
		return lotto;
	}

	public void setLotto() {	// 로또는 외부에서 숫자를 주입받는것이 아니라 자체적으로 랜덤숫자를 발생시켜야 하므로 파라미터 X
		for (int i = 0; i < lotto.length; i++) {
			lotto[i]=0;		// 배열내부의 지역변수 6개를 초기화시킴
							/*
								lotto[0] = 0
								lotto[1] = 0 ..... lotto[5]=0 이것을 한방에
							*/
		}
		
		for (int i = 0; i < lotto.length; i++) {
			// 로또의 사이즈 6만큼 회전하면서 랜덤숫자 6개를 생성
			int randomNum = (int) (Math.random()*45 + 1);
			// 로또는 숫자 중복이 있어서는 안된다.
			// 나중에 나온 숫자가 먼저 나온 숫자와 같다면 그 숫자는 폐기하고 다시 돌아야 한다.
			// 이때 카운트숫자는 증가하면 안된다.
			boolean exist = false;		// 지변은 무조건 초기화를 시켜야한다.

			// for문 내부의 for문을 주어서(이중 for문)
			// 번호의 중복여부를 체크하고 만약 중복됐다면 회전 카운트(i값)를 1줄임
			for (int j = 0; j < lotto.length; j++) {
				if (randomNum == lotto[j]) {
					exist = true;
					break;
				}
			}
			if (exist) {
				i--;
				continue;
			} else{
				lotto[i] = randomNum;
			}
		}
		// 중복이 되지 않은 6개의 랜덤숫자가 배열에 담겼다면 그 배열의 숫자를 오름차순으로 정렬해야 함
		Arrays.sort(lotto);
		this.lotto = lotto;
	}
	
}
