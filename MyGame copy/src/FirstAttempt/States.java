package FirstAttempt;
import java.awt.Image;
import java.awt.Toolkit;
public class States {
		private int xCoord;
		private int yCoord;
		private int width;
		private int height;
		private Image img;
		
		public States() {
			setxCoord(10);
			setyCoord(10);
			setWidth(100);
			setHeight(100);
			setImg("files/asfalt-light.png");
			
		}
		
		public States(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
		}
		
			// TODO Auto-generated method stub
			
		public int getxCoord() {
			return xCoord;
		}

		public void setxCoord(int xCoord) {
			this.xCoord = xCoord;
		}

		public int getyCoord() {
			return yCoord;
		}

		public void setyCoord(int yCoord) {
			this.yCoord = yCoord;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}


		public void setImg(String imgpath) {
			this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
		}
		//.intersects
		
	}

