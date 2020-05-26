package java_project.game.wrongPicture;

import java.util.ArrayList;

import javax.swing.ImageIcon;

class ImageObject {
	private ImageIcon imgIcon; //이미지 아이콘
	private ArrayList<PointObject> pointList; //정답 좌표담긴 배열
	private String imgPath; //이미지 파일 경로
	
	public ImageObject(ArrayList<PointObject> pointList, String imgPath) {
		this.pointList =pointList;
		this.imgPath =imgPath;
	}
	
	public ImageObject(String imgPath) {
		this.imgPath =imgPath;
	}
	
	public ArrayList<PointObject> getPoint() {
		return pointList;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	
	public ImageIcon getImageIcon() {
		imgIcon =new ImageIcon(imgPath);
		return imgIcon;
	}
}
