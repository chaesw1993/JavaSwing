package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @ Date : 2015.07.30
 * @ Author : Chae S W
 * @ Story : 로또(Swing) 예제
 */
public class LottoUI extends JFrame implements ActionListener{
	/**
	 * serialVersionUID 는 시리얼 번호로 클래스 구분 식별번호이다.
	 */
	private static final long serialVersionUID = 1L;
	
	//필드 ---- 클래스 필드는 초기화하면 안됨
	Lotto lotto;
	JButton btn;
	JPanel panelNorth, panelSouth;
	ImageIcon icon;
	List<JButton> btns;

	// UI : User Interface - 사용자화면
	// 생성자
	public LottoUI() {
		// 로또 화면에 들어갈 부품 만들기 (객체의 생성자)
		setTitle("로또 번호 추첨");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		btn = new JButton("로또 번호 추첨");

		// 만들어진 부품(객체)들을 큰 객체(프레임 객체)에 조립하기
		btn.addActionListener(this);	// this 는 큰객체인 프레임을 가르킴
		panelNorth.add(btn);
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
		setBounds(300, 400, 1200, 300);	// 화면에서 x좌표, y좌표, 가로, 세로길이
		setVisible(true);
	}
	
	// 멤버 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btns.size()==0) {
			JButton tmp = new JButton();
			for (int i = 0; i < 6; i++) {
				tmp = new JButton();
				btns.add(tmp);
				panelSouth.add(tmp);
			}
		}
		// 6개의 랜덤숫자를 만들고
		lotto.setLotto();
		int[] arr = lotto.getLotto();
		// 6개의 버튼 객체에 아이콘(이미지)를 붙인다.
		for (int i = 0; i < arr.length; i++) {
			btns.get(i).setIcon(getIcon(arr[i]));
		}
	}
	
	// 메소드가 복잡성을 이룰 때, 이를 간소화 하기위해서 ALT SHIFT M으로 메소드 리팩토링을 하는데
	// 지금 상황은 이 리팩토링을 먼저하고 나중에 그 메소드를 완성하는 기법

	private Icon getIcon(int i) {	
		String imgPath = "src/images/"+Integer.toString(i)+".gif";
		return new ImageIcon(imgPath);
	}
}
