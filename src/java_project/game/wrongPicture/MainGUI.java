package java_project.game.wrongPicture;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class GUI extends JFrame {
	static JLabel SCORE_LB =new JLabel("Score 0");
	static JLabel HPBAR_LB =new JLabel("HP 100");
	static JLabel LEVEL_LB =new JLabel("LEVEL 1");
	static JLabel RESULT_LB =new JLabel("�������� : 0");
	static int TIME =0;
	static int SCORE =0;
	static int LEVEL =1;
	static int LAST_LEVEL =6;
	
	JLabel timeLB =new JLabel("TIME 60");
	JButton startBTN =new JButton("���� ����");
	JButton exitBTN =new JButton("���� ����");
	JLabel originImgLB =null;
	JLabel copyImgLB =null;
	

	public GUI() {
		super("Ʋ���׸� ã�� GAME!");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);  
		setSize(1920, 1080);

		
		
		//������� ��ġ�� ũ�� ����
		Dimension dis =Toolkit.getDefaultToolkit().getScreenSize(); //��ũ���� ����� ���ؿ�
		int center =((int)dis.getWidth()/2) - 130; //��ũ���� ������� �������� ������/2��ŭ ���� ��� ��ġ�ϰԵ�
		
		SCORE_LB.setBounds(130, 50, 320, 70);
		SCORE_LB.setFont(new Font("a��������", 50, 50));
		
		timeLB.setBounds(center, 50, 260, 70);
		timeLB.setFont(new Font("a��������", 50, 50));
		
		HPBAR_LB.setBounds(1630, 50, 260, 70);
		HPBAR_LB.setFont(new Font("a��������", 50, 50));
		
		LEVEL_LB.setBounds(center+50, 90, 260, 70);
		LEVEL_LB.setFont(new Font("a��������", 25, 25));
		
		startBTN.setBounds(130, (int)dis.getHeight()-130, 320, 70);
		startBTN.setFont(new Font("a��������", 70, 55));
		startBTN.setBorderPainted(false);
		startBTN.setContentAreaFilled(false);
		startBTN.setFocusPainted(false);
		
		
		RESULT_LB.setBounds(430, (int)dis.getHeight()-130, 260, 70);
		RESULT_LB.setFont(new Font("a��������", 35, 35));
		
		exitBTN.setBounds((int)dis.getWidth()-450, (int)dis.getHeight()-130, 320, 70);
		exitBTN.setFont(new Font("a��������", 70, 55));
		exitBTN.setBorderPainted(false);
		exitBTN.setContentAreaFilled(false);
		exitBTN.setFocusPainted(false);
		
		ImageIcon originIcon =new ImageObject("../java_project/origin.jpg").getImageIcon();
		originImgLB =new JLabel(originIcon);
		originImgLB.setBounds(100, 150, 803, 754);
		
		ImageIcon copyIcon =new ImageObject("../java_project/copy.jpg").getImageIcon();
		copyImgLB =new JLabel(copyIcon);
		copyImgLB.setBounds(953, 150, 803, 754);
		
		
		//�ǳڿ� ���̱�
		add(SCORE_LB);
		add(timeLB);
		add(HPBAR_LB);
		add(LEVEL_LB);
		add(startBTN);
		add(exitBTN);
		add(originImgLB);
		add(copyImgLB);
		add(RESULT_LB);
		
		this.setResizable(false); //â ������ ���� �Ұ�
		setVisible(true);
		
		//GUI END=================================================
		
		
		//Listener Start==========================================
		ImageObject[] imgObj =new ImageObject[2];
		ArrayList<PointObject> pointList =new ArrayList<PointObject>();
		Functions f =new Functions(); 
		
		startBTN.addActionListener(new ActionListener() { //���� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				new Init(imgObj, LEVEL, pointList, f, originImgLB, copyImgLB);
				
				f.start(timeLB);
				startBTN.setEnabled(false);
			}
		}); 
		
		exitBTN.addActionListener((e) -> { //���� ����
			System.exit(0);
		});
		
		Graphics g =copyImgLB.getGraphics();
		copyImgLB.addMouseListener(new MouseAdapter() { //���콺 Ŭ�� �̺�Ʈ
			@Override
			public void mouseClicked(MouseEvent e) {
				Point savePoint =e.getPoint();
				//Point point, ImageObject[] imgObj, JLabel origin, JLabel copy, Graphics g
				f.answer(savePoint, imgObj, originImgLB, copyImgLB, g);
//				System.out.println(savePoint);
			}
		});
		
	}
}
public class MainGUI {

	public static void main(String[] args) {
		new GUI();
	}

}
