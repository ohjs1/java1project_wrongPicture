package java_project.game.wrongPicture;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Functions {
	private boolean endgame =false;
	
	public void imgCreated(ImageIcon imgIcon, JFrame frame) {
		frame.add(new JLabel(imgIcon));
		frame.setVisible(true);
//		System.out.println("imgcreated!!");
	}
	
	public void imgSetting(ImageIcon imgIcon, JLabel label) {
		label.setIcon(imgIcon);
		label.setVisible(true);
//		System.out.println("imgSetting ++ LABEL ++");
	}

	public void answer(Point point, ImageObject[] imgObj, JLabel origin, JLabel copy, Graphics g) {
		//마우스가 클릭된 좌표 point와 정답배열포인트객체가들어있는  배열
		ArrayList<PointObject> resultPoint =imgObj[1].getPoint(); //정답 포인트 좌표 가져옴
		int size =50; //비교할 좌표 크기
		
		for(int i=0; i<resultPoint.size(); i++) {
			int originX =(int)resultPoint.get(i).getX();
			int originY =(int)resultPoint.get(i).getY();
			
			if(((point.getX() <= originX+size) && (point.getX() >= originX-size)) 
				&& ((point.getY() <= originY+size) && (point.getY() >= originY-size))) {
					drawOX(copy, originX, originY, true, g); //정답 체크!
//					System.out.println(i+1 + "번째 정답");
					
					if( scoreChk(resultPoint.size(), i, resultPoint.size()) ) {
						if(GUI.LEVEL == GUI.LAST_LEVEL) {
							System.out.println("게임 끝!");
							GUI.SCORE =score;
							System.out.println("총점 :" + score);
							if(!endgame) {
								new ResultGUI();
								endgame =true;
								break;
							}
						}
						System.out.println(GUI.LEVEL + " 스테이지로!");
						GUI.LEVEL_LB.setText("LEVEL " + GUI.LEVEL);
						nextStage(imgObj, GUI.LEVEL, resultPoint, this, origin, copy);
					}
					break;
				
			} else if( (i == resultPoint.size()-1) ) { 
				drawOX(copy, (int)point.getX(), (int)point.getY(), false, g);
//				System.out.println(resultPoint.size()-1 + " : " + resultPoint.get(i).getChk());
				hpChk(g); //hp 체크!
				break;
			} 
		}
	}
	
	public void drawOX(JLabel label, int x, int y, boolean ox, Graphics g) {
		Image O =new ImageIcon("../java_project/src/img/ox/o.png").getImage();
		Image X =new ImageIcon("../java_project/src/img/ox/x.png").getImage();
		
		if(ox) {
			g.drawImage(O, x-20, y-20, label);
		} else {
			g.drawImage(X, x-20, y-20, label);
		}
	}
	
	int hp =100;
	public void hpChk(Graphics g) {
		if(hp > 10) {
			hp -=10;
			GUI.HPBAR_LB.setText("체력 : " + hp);
		} else {
			System.out.println("게임 패배!");
			GUI.SCORE =score;
			System.out.println("총점 :" + score);
			GUI.HPBAR_LB.setText("체력 : " + 0);
			if(!endgame) {
				new ResultGUI();
				endgame =true;
			}
			g.dispose(); //그래픽 자원 반환
		}
	}
	
	int[] arrScore = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	int beforeStageScore =0;
	int score =0;
	public static int SCORE_SIZE; //정답 크기
	
	public boolean scoreChk(int size, int j, int result) {
		for(int i=0; i<size; i++) {
			if(arrScore[i] == j) {
				score +=10;
				GUI.SCORE_LB.setText("점수" + score);
				System.out.println("score : " + score);
				SCORE_SIZE -=1;
				GUI.RESULT_LB.setText("남은 정답 : " + SCORE_SIZE);
				arrScore[i]++;
				if(size*10 == (score - beforeStageScore) ) {
					GUI.LEVEL +=1;
					beforeStageScore =score;
					resetArrScore(); //체크용 변수 초기화
					System.out.println("전단계 스코어: " + (score - beforeStageScore));
					return true;
				}
				break;
			}
		}
		return false;
	}
	
	public void resetArrScore() {
		for(int i=0; i<arrScore.length; i++) {
			arrScore[i] =i;
		}
	}
	
	public void nextStage(ImageObject[] imgObj, int LEVEL, ArrayList<PointObject> resultPoint,
			Functions f, JLabel originImgLB, JLabel copyImgLB) {
		new Init(imgObj, LEVEL, resultPoint, this, originImgLB, copyImgLB);
	}
	
	public void start(JLabel timeLB) {
		new Timer(timeLB).start();
	}
	
	class Timer extends Thread {
	private JLabel timeLB;
	
	public Timer(JLabel timeLB) {
		this.timeLB =timeLB;
	}
	
	
	@Override
	public void run() { //시간체크 쓰레드
		GUI.TIME =60;
			while(true) {
				if(GUI.TIME <= 0 || endgame == true || hp < 10) break;
				try {
					timeLB.setText("TIME " + GUI.TIME);
					Thread.sleep(1000);
					GUI.TIME -=1;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("남은 시간 " + GUI.TIME);
			timeLB.setText("TIME " + 0);
			GUI.SCORE =score;
			if(!endgame) {
				new ResultGUI();
				endgame =true;
			}
			System.out.println("타이머 끝");
		}
		
	}
}
