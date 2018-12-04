package FirstAttempt;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import sun.audio.*;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.util.ArrayList;
public class MyCanvas extends Canvas implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Goodguy linkr = new Goodguy(100,100,85,61,"files/supermanflyingr.png");
	Goodguy linkl = new Goodguy(200,200,85,61,"files/supermanflyingl.png");
	Goodguy linku = new Goodguy(200,200,85,61,"files/supermanflyingup.png");
	Goodguy linkd = new Goodguy(200,200,85,61,"files/supermanflyingdown.png");
	Goodguy usmap = new Goodguy(0,0,1200,800,"files/usmap.png");
	LinkedList badguys = new LinkedList();
	int[][] coords = new int[100][5];
	int[] repeat = new int[100];
	String[] state = new String[100];
	int c;
	ArrayList states = new ArrayList( );
	int score = 100;
	Font myFont = new Font ("Comic Sans", 1, 35);
	Font endfont = new Font ("Comic Sans", 1, 100);
	boolean correct;
	boolean start = true;
	boolean lose = false;
	int[] repeatnew = new int[60]; 
	boolean contains = IntStream.of(repeatnew).anyMatch(x -> x == c);
	String[] capital = new String[100];
	boolean music;
	String[] bird = new String[100];
	boolean restart=false;
	boolean reallose = false;
	int countdown = 770;
	boolean instructions;
	
	public MyCanvas() {
		
		this.setSize(1200,800);
		this.addKeyListener(this);
	if(lose) {
		playIt("files/silent.wav");

	}else {
		playIt("files/Jeopardy.wav");

	}
			
			
			Random rand = new Random();
			c = rand.nextInt(50)-1;
			int winwidth = this.getWidth();
			int winheight = this.getHeight();
			
			
		state[0] = "Washington";
		coords[0][1] = 60;
		coords[0][2] = 0;
		coords[0][3] = 160;
		coords[0][4] = 80;	
		repeat[0] = 1;
		capital[0] = "Olympia";
		states.add(state[0]);
		
		state[1] = "Oregon";
		coords[1][1] = 40;
		coords[1][2] = 60;
		coords[1][3] = 140;
		coords[1][4] = 180;
		repeat[1] = 1;
		capital[1] = "Salem";
		states.add(state[1]);
		//north
		state[2] = "California";
		coords[2][1] = 0;
		coords[2][2] = 160;
		coords[2][3] = 60;
		coords[2][4] = 440;
		repeat[2] = 1;
		capital[2] = "Sacramento";
		states.add(state[2]);
		//south
		state[3] = "California";
		coords[3][1] = 80;
		coords[3][2] = 360;
		coords[3][3] = 140;
		coords[3][4] = 440;
		repeat[3] = 1;
		capital[3] = "Sacramento";
		states.add(state[3]);
		state[4] = "Nevada";
		coords[4][1] = 80;
		coords[4][2] = 180;
		coords[4][3] = 160;
		coords[4][4] = 360;
		repeat[4] = 1;
		capital[4] = "Carson City";
		states.add(state[4]);
		
		//northidaho
		state[5] = "Idaho";
		coords[5][1] = 180;
		coords[5][2] = 20;
		coords[5][3] = 220;
		coords[5][4] = 120;
		repeat[5] = 1;
		capital[5] = "Boise";
		states.add(state[5]);
		
		//southidaho
		state[6] = "Idaho";
		coords[6][1] = 160;
		coords[6][2] = 120;
		coords[6][3] = 240;
		coords[6][4] = 200;
		repeat[6] = 1;
		capital[6] = "Boise";
		states.add(state[6]);
		//montana
		state[7] = "Montana";
		coords[7][1] = 200;
		coords[7][2] = 20;
		coords[7][3] = 400;
		coords[7][4] = 140;
		repeat[7] = 1;
		capital[7] = "Helena";
		states.add(state[7]);
		//wyoming
		state[8] = "Wyoming";
		coords[8][1] = 280;
		coords[8][2] = 140;
		coords[8][3] = 400;
		coords[8][4] = 260;
		repeat[8] = 1;
		capital[8] = "Cheyenne";
		states.add(state[8]);
		
		//colorado
		state[9] = "Colorado";
		coords[9][1] = 300;
		coords[9][2] = 260;
		coords[9][3] = 420;
		coords[9][4] = 360;
		repeat[9] = 1;
		capital[9] = "Denver";
		states.add(state[9]);
		
		//arizona
		state[10] = "Arizona";
		coords[10][1] = 160;
		coords[10][2] = 360;
		coords[10][3] = 260;
		coords[10][4] = 500;
		repeat[10] = 1;
		capital[10] = "Phoenix";
		states.add(state[10]);
		
		//utah
		state[11] = "Utah";
		coords[11][1] = 200;
		coords[11][2] = 220;
		coords[11][3] = 280;
		coords[11][4] = 340;
		repeat[11] = 1;
		capital[11] = "Salt Lake City";
		states.add(state[11]);
		
		//newmexico
		state[12] = "New Mexico";
		coords[12][1] = 280;
		coords[12][2] = 360;
		coords[12][3] = 400;
		coords[12][4] = 500;
		repeat[12] = 1;
		bird[12] = "Roadrunner";
		states.add(state[12]);
		
		//northdakota
		state[13] = "North Dakota";
		coords[13][1] = 420;
		coords[13][2] = 60;
		coords[13][3] = 560;
		coords[13][4] = 120;
		repeat[13] = 1;
		bird[13] = "Meadowlark";
		states.add(state[13]);
		//southdakota
		state[14] = "South Dakota";
		coords[14][1] = 420;
		coords[14][2] = 120;
		coords[14][3] = 560;
		coords[14][4] = 200;
		repeat[14] = 1;
		bird[14] = "Pheasant";
		states.add(state[14]);
		//nebraska
		state[15] = "Nebraska";
		coords[15][1] = 420;
		coords[15][2] = 200;
		coords[15][3] = 560;
		coords[15][4] = 280;
		repeat[15] = 1;
		bird[15] = "Meadowlark";
		states.add(state[15]);
		//kansas
		state[16] = "Kansas";
		coords[16][1] = 440;
		coords[16][2] = 280;
		coords[16][3] = 580;
		coords[16][4] = 380;
		repeat[16] = 1;
		bird[16] = "Meadowlark";
		states.add(state[16]);
		//oklahoma
		state[17] = "Oklahoma";
		coords[17][1] = 480;
		coords[17][2] = 380;
		coords[17][3] = 600;
		coords[17][4] = 460;
		repeat[17] = 1;
		bird[17] = "Wild Turkey";
		states.add(state[17]);
		//texas starting at northern border of louisiana and going down to southern end
		state[18] = "Texas";
		coords[18][1] = 320;
		coords[18][2] = 520;
		coords[18][3] = 620;
		coords[18][4] = 580;
		repeat[18] = 1;
		capital[18] = "Austin";
		states.add(state[18]);
		
		//southern tip of texas
		state[19] = "Texas";
		coords[19][1] = 440;
		coords[19][2] = 580;
		coords[19][3] = 600;
		coords[19][4] = 660;
		repeat[19] = 1;
		capital[19] = "Austin";
		states.add(state[19]);
		
		//northern tip of texas
		state[20] = "Texas";
		coords[20][1] = 420;
		coords[20][2] = 400;
		coords[20][3] = 480;
		coords[20][4] = 500;
		repeat[20] = 1;
		capital[20] = "Austin";
		states.add(state[20]);
		
		//texas north of louisiana
	
		state[21] = "Texas";
		coords[21][1] = 480;
		coords[21][2] = 460;
		coords[21][3] = 620;
		coords[21][4] = 520;
		repeat[21] = 1;
		capital[21] = "Austin";
		states.add(state[21]);
		
		//louisiana
		state[22] = "Louisiana";
		coords[22][1] = 620;
		coords[22][2] = 480;
		coords[22][3] = 700;
		coords[22][4] = 560;
		repeat[22] = 1;
		capital[22] = "Baton Rouge";
		states.add(state[22]);
		//arkansas
		state[23] = "Arkansas";
		coords[23][1] = 600;
		coords[23][2] = 380;
		coords[23][3] = 680;
		coords[23][4] = 480;
		repeat[23] = 1;
		capital[23] = "Little Rock";
		states.add(state[23]);
		//missouri
		state[24] = "Missouri";
		coords[24][1] = 600;
		coords[24][2] = 300;
		coords[24][3] = 680;
		coords[24][4] = 380;
		repeat[24] = 1;
		capital[24] = "Jefferson City";
		states.add(state[24]);
		//iowa
		state[25] = "Iowa";
		coords[25][1] = 580;
		coords[25][2] = 200;
		coords[25][3] = 660;
		coords[25][4] = 280;
		repeat[25] = 1;
		capital[25] = "Des Moines";
		states.add(state[25]);
		//minnesota
		state[26] = "Minnesota";
		coords[26][1] = 560;
		coords[26][2] = 60;
		coords[26][3] = 640;
		coords[26][4] = 180;
		repeat[26] = 1;
		capital[26] = "St Paul";
		states.add(state[26]);
		//wisconsin
		state[27] = "Wisconsin";
		coords[27][1] = 660;
		coords[27][2] = 120;
		coords[27][3] = 720;
		coords[27][4] = 200;
		repeat[27] = 1;
		capital[27] = "Madison";
		states.add(state[27]);
		//michigan
		state[28] = "Michigan";
		coords[28][1] = 760;
		coords[28][2] = 140;
		coords[28][3] = 840;
		coords[28][4] = 220;
		repeat[28] = 1;
		capital[28] = "Lansing";
		states.add(state[28]);
		//ohio
		state[29] = "Ohio";
		coords[29][1] = 820;
		coords[29][2] = 240;
		coords[29][3] = 880;
		coords[29][4] = 280;
		repeat[29] = 1;
		capital[29] = "Columbus";
		states.add(state[29]);
		//indiana
		state[30] = "Indiana";
		coords[30][1] = 760;
		coords[30][2] = 240;
		coords[30][3] = 800;
		coords[30][4] = 320;
		repeat[30] = 1;
		capital[30] = "Indianapolis";
		states.add(state[30]);
		//illinois
		state[31] = "Illinois";
		coords[31][1] = 700;
		coords[31][2] = 240;
		coords[31][3] = 740;
		coords[31][4] = 340;
		repeat[31] = 1;
		capital[31] = "Springfield";
		states.add(state[31]);
		//kentucky
		state[32] = "Kentucky";
		coords[32][1] = 740;
		coords[32][2] = 340;
		coords[32][3] = 860;
		coords[32][4] = 360;
		repeat[32] = 1;
		capital[32] = "Frankfort";
		states.add(state[32]);
		//tennessee
		state[33] = "Tennessee";
		coords[33][1] = 720;
		coords[33][2] = 380;
		coords[33][3] = 860;
		coords[33][4] = 400;
		repeat[33] = 1;
		capital[33] = "Nashville";
		states.add(state[33]);
		//alabama
		state[34] = "Alabama";
		coords[34][1] = 760;
		coords[34][2] = 440;
		coords[34][3] = 820;
		coords[34][4] = 520;
		repeat[34] = 1;
		capital[34] = "Montgomery";
		states.add(state[34]);
		//mississippi
		state[35] = "Mississippi";
		coords[35][1] = 700;
		coords[35][2] = 440;
		coords[35][3] = 740;
		coords[35][4] = 540;
		repeat[35] = 1;
		states.add(state[35]);
		//florida
		state[36] = "Florida";
		coords[36][1] = 780;
		coords[36][2] = 540;
		coords[36][3] = 960;
		coords[36][4] = 660;
		repeat[36] = 1;
		states.add(state[36]);
		//georgia
		state[37] = "Georgia";
		coords[37][1] = 840;
		coords[37][2] = 460;
		coords[37][3] = 900;
		coords[37][4] = 520;
		repeat[37] = 1;
		states.add(state[37]);
		//south carolina
		state[38] = "South Carolina";
		coords[38][1] = 900;
		coords[38][2] = 420;
		coords[38][3] = 940;
		coords[38][4] = 460;
		repeat[38] = 1;
		states.add(state[38]);
		//north carolina
		state[39] = "North Carolina";
		coords[39][1] = 880;
		coords[39][2] = 380;
		coords[39][3] = 1000;
		coords[39][4] = 380;
		repeat[39] = 1;
		states.add(state[39]);
		//virginia
		state[40] = "Virginia";
		coords[40][1] = 940;
		coords[40][2] = 320;
		coords[40][3] = 960;
		coords[40][4] = 340;
		repeat[40] = 1;
		states.add(state[40]);
		//westvirginia
		state[41] = "West Virginia";
		coords[41][1] = 880;
		coords[41][2] = 300;
		coords[41][3] = 900;
		coords[41][4] = 320;
		repeat[41] = 1;
		states.add(state[41]);
		//pennsylvania
		state[42] = "Pennsylvania";
		coords[42][1] = 900;
		coords[42][2] = 200;
		coords[42][3] = 1000;
		coords[42][4] = 240;
		repeat[42] = 1;
		states.add(state[42]);
		//newyork
		state[43] = "New York";
		coords[43][1] = 920;
		coords[43][2] = 120;
		coords[43][3] = 1020;
		coords[43][4] = 200;
		repeat[43] = 1;
		states.add(state[43]);
		//maine
		state[44] = "Maine";
		coords[44][1] = 1080;
		coords[44][2] = 20;
		coords[44][3] = 1140;
		coords[44][4] = 120;
		repeat[44] = 1;
		states.add(state[44]);
		//new hampshire
		state[45] = "New Hampshire";
		coords[45][1] = 1060;
		coords[45][2] = 100;
		coords[45][3] = 1060;
		coords[45][4] = 140;
		repeat[45] = 1;
		states.add(state[45]);
		//vermont
		state[46] = "Vermont";
		coords[46][1] = 1040;
		coords[46][2] = 100;
		coords[46][3] = 1040;
		coords[46][4] = 140;
		repeat[46] = 1;
		states.add(state[46]);
		//massachusetts
		state[47] = "Massachusetts";
		coords[47][1] = 1040;
		coords[47][2] = 160;
		coords[47][3] = 1100;
		coords[47][4] = 180;
		repeat[47] = 1;
		states.add(state[47]);
		//rhodeisland
		state[48] = "Rhode Island";
		coords[48][1] = 1060;
		coords[48][2] = 180;
		coords[48][3] = 1080;
		coords[48][4] = 200;
		repeat[48] = 1;
		states.add(state[48]);
		//connecticut
		state[49] = "Connecticut";
		coords[49][1] = 1040;
		coords[49][2] = 180;
		coords[49][3] = 1060;
		coords[49][4] = 200;
		repeat[49] = 1;
		states.add(state[49]);
		//newjersey
		state[50] = "New Jersey";
		coords[50][1] = 1020;
		coords[50][2] = 220;
		coords[50][3] = 1020;
		coords[50][4] = 260;
		repeat[50] = 1;
		states.add(state[50]);
		//delaware
		state[51] = "Delaware";
		coords[51][1] = 1000;
		coords[51][2] = 260;
		coords[51][3] = 1020;
		coords[51][4] = 280;
		repeat[51] = 1;
		states.add(state[51]);
		//maryland
		state[52] = "Maryland";
		coords[52][1] = 940;
		coords[52][2] = 260;
		coords[52][3] = 1000;
		coords[52][4] = 300;
		repeat[52] = 1;
		states.add(state[52]);
		//alaska
		state[53] = "Alaska";
		coords[53][1] = 0;
		coords[53][2] = 520;
		coords[53][3] = 200;
		coords[53][4] = 680;
		repeat[53] = 1;
		states.add(state[53]);
		//hawaii
		state[54] = "Hawaii";
		coords[54][1] = 240;
		coords[54][2] = 580;
		coords[54][3] = 400;
		coords[54][4] = 680;
		repeat[54] = 1;
		states.add(state[54]);
	}
	
	public void playIt(String filename) {
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
		
	
	
	public void paint(Graphics g) {
		g.setFont(myFont);
		g.drawImage(usmap.getImg(), usmap.getxCoord(), usmap.getyCoord(), usmap.getWidth(), usmap.getHeight(), this);
		g.drawString("Press space to start", 300, 300);
		g.drawString("Press i for instructions", 300, 400);
		if(instructions) {
			g.drawString("Navigate the superman with the arrow keys", 300, 500);
			g.drawString("Select the state with the space bar", 300, 550);
			g.drawString("The faster you select, the higher the score!", 300, 600);
		}
		if(start==false) {
			g.drawImage(usmap.getImg(), usmap.getxCoord(), usmap.getyCoord(), usmap.getWidth(), usmap.getHeight(), this);
			g.drawImage(linkr.getImg(), linkr.getxCoord(), linkr.getyCoord(), linkr.getWidth(), linkr.getHeight(), this);
		
		//g.drawString(Integer.toString(linkr.getxCoord())+ ','+ Integer.toString(linkr.getyCoord()), 200, 200); 
		g.drawString("Score "+Integer.toString(score), 550, 30);
		g.drawString("Find "+state[c], 800, 30);
		countdown--;
		int t=countdown/16;
		//g.drawString(String.valueOf(t), 400, 400);
		if(c<12||(c>17&&c<35)) {
			g.drawString("Did You Know? : " + state[c] +"'s capital is " +capital[c]+"!", 0, 760);
		}
		if(c>11&&c<18) {
			g.drawString("Did You Know? : " + state[c] +"'s state bird is the " +bird[c]+"!", 0, 760);
		}
		
		if(c==54) {
			g.drawString("Did You Know? : Barack Obama was born in Hawaii!" ,0, 760);
		}
		
		if(correct==true) {
			g.drawString("Correct!", 800, 70);
			
		}else if(correct==false) {
			g.drawString("Incorrect", 800, 70);
		}else {
			g.drawString("Good Luck", 800, 60);
		}
		if(states.size() == 0 ) {
			lose=true;
			g.drawString("You Win!", 300, 300);
		}
		if(score<-500) {
			g.setFont(endfont);
			g.drawString("Game Over", 300, 300);
			lose = true;
			reallose=true;
		}
		if(states.size()==52) {
			g.setFont(myFont);
			g.drawString("You can do it", 200, 20);
		}
		if(states.size()==50) {
			g.setFont(myFont);
			g.drawString("Keep going", 200, 20);
		}
		if(states.size()==5) {
			g.setFont(myFont);
			g.drawString("Almost there!", 200, 20);
		}
		if(states.size()<1) {
			g.setFont(endfont);
			g.drawString("You Win", 300, 300);
			lose = true;
			reallose = true;
		}
		if(reallose==false) {
			g.drawString("Press r to Play Again", 300, 300);
		}
		}
		
		/*for(int i = 0; i< badguys.size(); i++) {
			States bg = (States) badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
		}*/
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		
		if (lose == false) {
		if(e.getKeyCode()==73) {
			instructions=true;
		}
		if (e.getKeyCode()==32) {
		if(start) {
				start = false;
			}
				if (c==2 && linkr.getxCoord()>=coords[3][1]&&linkr.getxCoord()<=coords[3][3] && linkr.getyCoord()>=coords[3][2]&&linkr.getyCoord()<=coords[3][4]) {
					System.out.println("Correct");
					states.remove(state[2]);
					states.remove(state[3]);
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if (c==3 && linkr.getxCoord()>=coords[2][1]&&linkr.getxCoord()<=coords[2][3] && linkr.getyCoord()>=coords[2][2]&&linkr.getyCoord()<=coords[2][4]) {
					System.out.println("Correct");
					states.remove(state[2]);
					states.remove(state[3]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if (c==3 && linkr.getxCoord()>=coords[3][1]&&linkr.getxCoord()<=coords[3][3] && linkr.getyCoord()>=coords[3][2]&&linkr.getyCoord()<=coords[3][4]) {
					System.out.println("Correct");
					states.remove(state[2]);
					states.remove(state[3]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if (c==2 && linkr.getxCoord()>=coords[2][1]&&linkr.getxCoord()<=coords[2][3] && linkr.getyCoord()>=coords[2][2]&&linkr.getyCoord()<=coords[2][4]) {
					System.out.println("Correct");
					states.remove(state[2]);
					states.remove(state[3]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if(c==5 && linkr.getxCoord()>=coords[6][1]&&linkr.getxCoord()<=coords[6][3] && linkr.getyCoord()>=coords[6][2]&&linkr.getyCoord()<=coords[6][4]) {
					
					System.out.println("Correct");
					states.remove(state[5]);
					states.remove(state[6]);
		
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if(c==6 && linkr.getxCoord()>=coords[5][1]&&linkr.getxCoord()<=coords[5][3] && linkr.getyCoord()>=coords[5][2]&&linkr.getyCoord()<=coords[5][4]) {
					
					System.out.println("Correct");
					states.remove(state[5]);
					states.remove(state[6]);
				
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if(c==6 && linkr.getxCoord()>=coords[6][1]&&linkr.getxCoord()<=coords[6][3] && linkr.getyCoord()>=coords[6][2]&&linkr.getyCoord()<=coords[6][4]) {
					
					System.out.println("Correct");
					states.remove(state[5]);
					states.remove(state[6]);
				
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if(c==5 && linkr.getxCoord()>=coords[5][1]&&linkr.getxCoord()<=coords[5][3] && linkr.getyCoord()>=coords[5][2]&&linkr.getyCoord()<=coords[5][4]) {
					
					System.out.println("Correct");
					states.remove(state[5]);
					states.remove(state[6]);
				
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if((c==19||c==20||c==21) && linkr.getxCoord()>=coords[18][1]&&linkr.getxCoord()<=coords[18][3] && linkr.getyCoord()>=coords[18][2]&&linkr.getyCoord()<=coords[18][4]) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
		
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if((c==18||c==20||c==21) && linkr.getxCoord()>=coords[19][1]&&linkr.getxCoord()<=coords[19][3] && linkr.getyCoord()>=coords[19][2]&&linkr.getyCoord()<=coords[19][4] ) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
		
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}else if((c==18||c==19||c==21) && linkr.getxCoord()>=coords[20][1]&&linkr.getxCoord()<=coords[20][3] && linkr.getyCoord()>=coords[20][2]&&linkr.getyCoord()<=coords[20][4] ) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
				
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}else if((c==18||c==19||c==20) && linkr.getxCoord()>=coords[21][1]&&linkr.getxCoord()<=coords[21][3] && linkr.getyCoord()>=coords[21][2]&&linkr.getyCoord()<=coords[21][4] ) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}else if(c==18 && linkr.getxCoord()>=coords[18][1]&&linkr.getxCoord()<=coords[18][3] && linkr.getyCoord()>=coords[18][2]&&linkr.getyCoord()<=coords[18][4] ) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if(c==19 && linkr.getxCoord()>=coords[19][1]&&linkr.getxCoord()<=coords[19][3] && linkr.getyCoord()>=coords[19][2]&&linkr.getyCoord()<=coords[19][4] ) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}else if(c==20 && linkr.getxCoord()>=coords[20][1]&&linkr.getxCoord()<=coords[20][3] && linkr.getyCoord()>=coords[20][2]&&linkr.getyCoord()<=coords[20][4] ) {
					
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if(c==21 && linkr.getxCoord()>=coords[21][1]&&linkr.getxCoord()<=coords[21][3] && linkr.getyCoord()>=coords[21][2]&&linkr.getyCoord()<=coords[21][4] ) {
				
					System.out.println("Correct");
					states.remove(state[18]);
					states.remove(state[19]);
					states.remove(state[20]);
					states.remove(state[21]);
					
					while(states.contains(state[c])==false) {
						Random rand1 = new Random();
						c = rand1.nextInt(54);
					}
					score=score+countdown;
					correct=true;
					repeat[c]=2;
				}
				else if (linkr.getxCoord()>=coords[c][1]&&linkr.getxCoord()<=coords[c][3] && linkr.getyCoord()>=coords[c][2]&&linkr.getyCoord()<=coords[c][4]) {
						System.out.println("Correct");
						states.remove(state[c]);
						while(states.contains(state[c])==false) {
							Random rand1 = new Random();
							c = rand1.nextInt(54);
						}
						score=score+countdown;
						correct=true;
						repeat[c]=2;
				}else {
					score=score-100;
					System.out.println("Incorrect");
					correct=false;
				}
				if (reallose=true) {
					if(e.getKeyCode()==82) {
						lose=false;
						start=true;
					}
				}
		}
		
		
		}
		
		repaint();
		linkr.moveIt(e.getKeyCode());
		linkl.moveIt(e.getKeyCode());
		linku.moveIt(e.getKeyCode());
		linkd.moveIt(e.getKeyCode());
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
