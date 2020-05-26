package java_project.game.wrongPicture;

import java.util.ArrayList;

import javax.swing.ImageIcon;

class ImageObject {
	private ImageIcon imgIcon; //�̹��� ������
	private ArrayList<PointObject> pointList; //���� ��ǥ��� �迭
	private String imgPath; //�̹��� ���� ���
	
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
