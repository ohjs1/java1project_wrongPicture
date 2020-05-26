package java_project.game.wrongPicture;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Init {

	public Init(ImageObject[] imgObj, int level, 
			ArrayList<PointObject> pointList, Functions f, JLabel origin, JLabel copy) {
		
		pointList.removeAll(pointList); //포인트객체 배열 초기화
		
		String[] paths = new String[2];
		
		if(level == 1) {
			pointList.add( new PointObject(179, 256, false) );
			pointList.add( new PointObject(117, 509, false) );
			pointList.add( new PointObject(775, 423, false) );
			paths[0] ="../java_project/src/img/1_origin.jpg";
			paths[1] ="../java_project/src/img/1_copy.jpg";
			
		} else if(level == 2) {
			pointList.add( new PointObject(129, 238, false) );
			paths[0] ="../java_project/src/img/2_origin.jpg";
			paths[1] ="../java_project/src/img/2_copy.jpg";
			
		} else if(level == 3) {
			pointList.add( new PointObject(342, 348, false) );
			pointList.add( new PointObject(173, 259, false) );
			pointList.add( new PointObject(15, 67, false) );
			pointList.add( new PointObject(598, 185, false) );
			pointList.add( new PointObject(567, 726, false) );
			paths[0] ="../java_project/src/img/3_origin.jpg";
			paths[1] ="../java_project/src/img/3_copy.jpg";
			
		} else if(level == 4) {
			paths[0] ="../java_project/src/img/4_origin.jpg";
			paths[1] ="../java_project/src/img/4_copy.jpg";
			pointList.add( new PointObject(539, 332, false) );
			
		} else if(level == 5) {
			paths[0] ="../java_project/src/img/5_origin.jpg";
			paths[1] ="../java_project/src/img/5_copy.jpg";
			pointList.add( new PointObject(133, 86, false) );
			pointList.add( new PointObject(692, 164, false) );
			pointList.add( new PointObject(402, 345, false) );
			pointList.add( new PointObject(476, 612, false) );
			pointList.add( new PointObject(604, 332, false) );
			
		} else if(level == 6) {
			paths[0] ="../java_project/src/img/6_origin.jpg";
			paths[1] ="../java_project/src/img/6_copy.jpg";
			pointList.add( new PointObject(15, 401, false) );
			pointList.add( new PointObject(56, 644, false) );
			pointList.add( new PointObject(338, 544, false) );
			pointList.add( new PointObject(786, 395, false) );
		}

		imgObj[0] =new ImageObject(paths[0]);
		imgObj[1] =new ImageObject( pointList, paths[1] );
		
		ImageIcon originImgIcon =imgObj[0].getImageIcon();
		ImageIcon copyImgIcon =imgObj[1].getImageIcon();
		
		f.imgSetting(originImgIcon, origin);
		f.imgSetting(copyImgIcon, copy);
		
		System.out.println("생성된 정답 사이즈 : " + pointList.size());
		GUI.RESULT_LB.setText("남은 정답 : " + pointList.size());
		Functions.SCORE_SIZE =pointList.size();
		GUI.RESULT_LB.setText("남은 정답 : " + Functions.SCORE_SIZE);
	}
}
