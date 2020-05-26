package java_project.game.wrongPicture;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ResultGUI extends JFrame {
	JLabel scoreLB =new JLabel();
	JLabel timeLB =new JLabel("���� �ð� : 0");
	JLabel hpLB =new JLabel("HP 70");
	MainGUI dialog;
	public ResultGUI() {
		super("���â");
		setSize(710, 640);
		Dimension dis =Toolkit.getDefaultToolkit().getScreenSize();
		this.setResizable(false); //â ������ ���� �Ұ�
		setLocation((int)dis.getWidth()/2-400, (int)dis.getHeight()/2-300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		scoreLB.setBounds(130, 100, 370, 70);
		scoreLB.setFont(new Font("a��������", 370, 70));
		add(scoreLB);
		
		timeLB.setBounds(130, 270, 650, 70);
		timeLB.setFont(new Font("a��������", 650, 70));
		add(timeLB);
		
		hpLB.setBounds(130, 400, 650, 70);
		hpLB.setFont(new Font("a��������", 650, 50));
		add(hpLB);
		
		scoreLB.setText("���� : " + GUI.SCORE);
		timeLB.setText("���� �ð� : " + GUI.TIME);
		hpLB.setText(GUI.HPBAR_LB.getText());
		setVisible(true);
	}
}
