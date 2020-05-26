package java_project.game.wrongPicture;

import java.awt.Point;

class PointObject {
	private Point point;
	private int x;
	private int y;
	private boolean chk =false;
	
	public PointObject(Point point, boolean chk) {
		this.point =point;
		this.chk =chk;
	}
	
	public PointObject(int x, int y, boolean chk) {
		this.x =x;
		this.y =y;
		this.chk =chk;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setChk(boolean chk) {
		this.chk =chk;
	}
	
	public boolean getChk() {
		return chk;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
