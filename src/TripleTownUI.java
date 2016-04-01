import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Dec 08 14:16:42 EST 2011
 */



/**
 * @author Bradley Chelsey
 */
public class TripleTownUI extends JFrame {
	TTBoard myboard = new TTBoard();
	
	public TripleTownUI() {
		myboard.init();
		initComponents();
	}
	
	/*private void buttonStashActionPerformed(ActionEvent e) {
		// TODO add your code here
	}*/
	
	private String whichImage(int n) {
		if(n == 1) {
			return "/img/grass.png";
		}
		if(n == 2) {
			return "/img/bush.png";
		}
		if(n == 3) {
			return "/img/tree.png";
		}
		if(n == 4) {
			return "/img/house1.png";
		}
		if(n == 5) {
			return "/img/house2.png";
		}
		if(n == 6) {
			return "/img/house3.png";
		}
		if(n == 7) {
			return "/img/house4.png";
		}
		if(n == 8) {
			return "/img/house5.png";
		}
		
		if(n == -1) {
			return "/img/bear.png";
		}
		if(n == -2) {
			return "/img/grave.png";
		}
		if(n == -3) {
			return "/img/church.png";
		}
		if(n == -4) {
			return "/img/cathedral.png";
		}
		if(n == -5) {
			return "/img/asgeir.png";
		}
		return "";
	}
	
	private Image scaleImg(int n) {
		String imgPath = whichImage(n);
		Image img = new ImageIcon(getClass().getResource(imgPath)).getImage();
		Image newImg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		return newImg;
	}
	
	private void updateButtons() {
		button00.setIcon(new ImageIcon(scaleImg(myboard.board[0][0])));
		button01.setIcon(new ImageIcon(scaleImg(myboard.board[0][1])));
		button02.setIcon(new ImageIcon(scaleImg(myboard.board[0][2])));
		button03.setIcon(new ImageIcon(scaleImg(myboard.board[0][3])));
		button04.setIcon(new ImageIcon(scaleImg(myboard.board[0][4])));
		button05.setIcon(new ImageIcon(scaleImg(myboard.board[0][5])));
		
		button10.setIcon(new ImageIcon(scaleImg(myboard.board[1][0])));
		button11.setIcon(new ImageIcon(scaleImg(myboard.board[1][1])));
		button12.setIcon(new ImageIcon(scaleImg(myboard.board[1][2])));
		button13.setIcon(new ImageIcon(scaleImg(myboard.board[1][3])));
		button14.setIcon(new ImageIcon(scaleImg(myboard.board[1][4])));
		button15.setIcon(new ImageIcon(scaleImg(myboard.board[1][5])));
		
		button20.setIcon(new ImageIcon(scaleImg(myboard.board[2][0])));
		button21.setIcon(new ImageIcon(scaleImg(myboard.board[2][1])));
		button22.setIcon(new ImageIcon(scaleImg(myboard.board[2][2])));
		button23.setIcon(new ImageIcon(scaleImg(myboard.board[2][3])));
		button24.setIcon(new ImageIcon(scaleImg(myboard.board[2][4])));
		button25.setIcon(new ImageIcon(scaleImg(myboard.board[2][5])));

		button30.setIcon(new ImageIcon(scaleImg(myboard.board[3][0])));
		button31.setIcon(new ImageIcon(scaleImg(myboard.board[3][1])));
		button32.setIcon(new ImageIcon(scaleImg(myboard.board[3][2])));
		button33.setIcon(new ImageIcon(scaleImg(myboard.board[3][3])));
		button34.setIcon(new ImageIcon(scaleImg(myboard.board[3][4])));
		button35.setIcon(new ImageIcon(scaleImg(myboard.board[3][5])));
		
		button40.setIcon(new ImageIcon(scaleImg(myboard.board[4][0])));
		button41.setIcon(new ImageIcon(scaleImg(myboard.board[4][1])));
		button42.setIcon(new ImageIcon(scaleImg(myboard.board[4][2])));
		button43.setIcon(new ImageIcon(scaleImg(myboard.board[4][3])));
		button44.setIcon(new ImageIcon(scaleImg(myboard.board[4][4])));
		button45.setIcon(new ImageIcon(scaleImg(myboard.board[4][5])));
		
		button50.setIcon(new ImageIcon(scaleImg(myboard.board[5][0])));
		button51.setIcon(new ImageIcon(scaleImg(myboard.board[5][1])));
		button52.setIcon(new ImageIcon(scaleImg(myboard.board[5][2])));
		button53.setIcon(new ImageIcon(scaleImg(myboard.board[5][3])));
		button54.setIcon(new ImageIcon(scaleImg(myboard.board[5][4])));
		button55.setIcon(new ImageIcon(scaleImg(myboard.board[5][5])));
		
		int hold = myboard.holding;
		String imgPath = whichImage(hold);
		Image holdingImg = new ImageIcon(getClass().getResource(imgPath)).getImage();
		Image newImg = holdingImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		holdingLabel.setIcon(new ImageIcon(newImg));
		
		int score = myboard.points;
		scoreLabel.setText("Score: " + score);
		System.out.println("You're currently holding: " + hold);
		System.out.println("Your current score: " + score + "\n");
	}
	
	private void play(int x, int y, JButton button) {
		try {
			Point move = new Point(x,y);
			myboard.playerMove(move);
			myboard.moveBears();
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	
	private void button00ActionPerformed(ActionEvent e) {
		play(0,0,button00);
	}
	private void button01ActionPerformed(ActionEvent e) {
		play(0,1,button01);
	}
	private void button02ActionPerformed(ActionEvent e) {
		play(0,2,button02);
	}
	private void button03ActionPerformed(ActionEvent e) {
		play(0,3,button03);
	}
	private void button04ActionPerformed(ActionEvent e) {
		play(0,4,button04);
	}
	private void button05ActionPerformed(ActionEvent e) {
		play(0,5,button05);
	}
	
	private void button10ActionPerformed(ActionEvent e) {
		play(1,0,button10);
	}
	private void button11ActionPerformed(ActionEvent e) {
		play(1,1,button11);
	}
	private void button12ActionPerformed(ActionEvent e) {
		play(1,2,button12);
	}
	private void button13ActionPerformed(ActionEvent e) {
		play(1,3,button13);
	}
	private void button14ActionPerformed(ActionEvent e) {
		play(1,4,button14);
	}
	private void button15ActionPerformed(ActionEvent e) {
		play(1,5,button15);
	}
	
	private void button20ActionPerformed(ActionEvent e) {
		play(2,0,button20);
	}
	private void button21ActionPerformed(ActionEvent e) {
		play(2,1,button21);
	}
	private void button22ActionPerformed(ActionEvent e) {
		play(2,2,button22);
	}
	private void button23ActionPerformed(ActionEvent e) {
		play(2,3,button23);
	}
	private void button24ActionPerformed(ActionEvent e) {
		play(2,4,button24);
	}
	private void button25ActionPerformed(ActionEvent e) {
		play(2,5,button25);
	}
	
	private void button30ActionPerformed(ActionEvent e) {
		play(3,0,button30);
	}
	private void button31ActionPerformed(ActionEvent e) {
		play(3,1,button31);
	}
	private void button32ActionPerformed(ActionEvent e) {
		play(3,2,button32);
	}
	private void button33ActionPerformed(ActionEvent e) {
		play(3,3,button33);
	}
	private void button34ActionPerformed(ActionEvent e) {
		play(3,4,button34);
	}
	private void button35ActionPerformed(ActionEvent e) {
		play(3,5,button35);
	}
	
	private void button40ActionPerformed(ActionEvent e) {
		play(4,0,button40);
	}
	private void button41ActionPerformed(ActionEvent e) {
		play(4,1,button41);
	}
	private void button42ActionPerformed(ActionEvent e) {
		play(4,2,button42);
	}
	private void button43ActionPerformed(ActionEvent e) {
		play(4,3,button43);
	}
	private void button44ActionPerformed(ActionEvent e) {
		play(4,4,button44);
	}
	private void button45ActionPerformed(ActionEvent e) {
		play(4,5,button45);
	}
	
	private void button50ActionPerformed(ActionEvent e) {
		play(5,0,button50);
	}
	private void button51ActionPerformed(ActionEvent e) {
		play(5,1,button51);
	}
	private void button52ActionPerformed(ActionEvent e) {
		play(5,2,button52);
	}
	private void button53ActionPerformed(ActionEvent e) {
		play(5,3,button53);
	}
	private void button54ActionPerformed(ActionEvent e) {
		play(5,4,button54);
	}
	private void button55ActionPerformed(ActionEvent e) {
		play(5,5,button55);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Bradley Chelsey
		//buttonStash = new JButton();
		
		int hold = myboard.holding;
		String imgPath = whichImage(hold);
		Image holdingImg = new ImageIcon(getClass().getResource(imgPath)).getImage();
		Image newImg = holdingImg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		holdingLabel = new JLabel("Holding", new ImageIcon(newImg), JLabel.LEFT);
		holdingLabel.setHorizontalTextPosition(JLabel.LEFT);
		scoreLabel = new JLabel();
		
		button00 = new JButton();
		button01 = new JButton();
		button02 = new JButton();
		button03 = new JButton();
		button04 = new JButton();
		button05 = new JButton();
		
		button10 = new JButton();
		button11 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		button14 = new JButton();
		button15 = new JButton();
		
		button20 = new JButton();
		button21 = new JButton();
		button22 = new JButton();
		button23 = new JButton();
		button24 = new JButton();
		button25 = new JButton();
		
		button30 = new JButton();
		button31 = new JButton();
		button32 = new JButton();
		button33 = new JButton();
		button34 = new JButton();
		button35 = new JButton();
		
		button40 = new JButton();
		button41 = new JButton();
		button42 = new JButton();
		button43 = new JButton();
		button44 = new JButton();
		button45 = new JButton();
		
		button50 = new JButton();
		button51 = new JButton();
		button52 = new JButton();
		button53 = new JButton();
		button54 = new JButton();
		button55 = new JButton();

		//======== this ========
		setTitle("Triple Town");
		Container contentPane = getContentPane();

		//---- button00 ----
		button00.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button00ActionPerformed(e);
			}
		});

		//---- button01 ----
		button01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button01ActionPerformed(e);
			}
		});

		//---- button02 ----
		button02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button02ActionPerformed(e);
			}
		});

		//---- button03 ----
		button03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button03ActionPerformed(e);
			}
		});

		//---- button04 ----
		button04.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button04ActionPerformed(e);
			}
		});

		//---- button05 ----
		button05.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button05ActionPerformed(e);
			}
		});

		//---- button10 ----
		button10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button10ActionPerformed(e);
			}
		});

		//---- button11 ----
		button11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button11ActionPerformed(e);
			}
		});

		//---- button12 ----
		button12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button12ActionPerformed(e);
			}
		});
		
		//---- button13 ----
		button13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button13ActionPerformed(e);
			}
		});
		
		//---- button14 ----
		button14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button14ActionPerformed(e);
			}
		});
		
		//---- button15 ----
		button15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button15ActionPerformed(e);
			}
		});
		
		//---- button20 ----
		button20.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button20ActionPerformed(e);
			}
		});

		//---- button21 ----
		button21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button21ActionPerformed(e);
			}
		});

		//---- button22 ----
		button22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button22ActionPerformed(e);
			}
		});
		
		//---- button23 ----
		button23.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button23ActionPerformed(e);
			}
		});
		
		//---- button24 ----
		button24.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button24ActionPerformed(e);
			}
		});
		
		//---- button25 ----
		button25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button25ActionPerformed(e);
			}
		});

		//---- button30 ----
		button30.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button30ActionPerformed(e);
			}
		});

		//---- button31 ----
		button31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button31ActionPerformed(e);
			}
		});

		//---- button32 ----
		button32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button32ActionPerformed(e);
			}
		});
		
		//---- button33 ----
		button33.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button33ActionPerformed(e);
			}
		});
		
		//---- button34 ----
		button34.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button34ActionPerformed(e);
			}
		});
		
		//---- button35 ----
		button35.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button35ActionPerformed(e);
			}
		});
		
		//---- button40 ----
		button40.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button40ActionPerformed(e);
			}
		});

		//---- button41 ----
		button41.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button41ActionPerformed(e);
			}
		});

		//---- button42 ----
		button42.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button42ActionPerformed(e);
			}
		});
		
		//---- button43 ----
		button43.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button43ActionPerformed(e);
			}
		});
		
		//---- button44 ----
		button44.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button44ActionPerformed(e);
			}
		});
		
		//---- button45 ----
		button45.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button45ActionPerformed(e);
			}
		});
		
		//---- button50 ----
		button50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button50ActionPerformed(e);
			}
		});

		//---- button51 ----
		button51.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button51ActionPerformed(e);
			}
		});

		//---- button52 ----
		button52.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button52ActionPerformed(e);
			}
		});
		
		//---- button53 ----
		button53.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button53ActionPerformed(e);
			}
		});
		
		//---- button54 ----
		button54.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button54ActionPerformed(e);
			}
		});
		
		//---- button55 ----
		button55.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button55ActionPerformed(e);
			}
		});
		
		updateButtons();
		
		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(holdingLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
							.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE,80, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button00, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button01, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button02, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button03, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button04, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button05, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button10, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button11, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button12, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button13, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button14, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button15, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button20, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button21, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button22, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button23, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button24, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button25, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button30, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button31, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button32, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button33, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button34, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button35, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button40, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button41, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button42, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button43, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button44, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button45, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button50, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button51, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button52, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button53, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button54, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button55, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(holdingLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(scoreLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addContainerGap()
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button00, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button01, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button02, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button03, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button04, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button05, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button10, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button11, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button12, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button13, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button14, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button15, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button20, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button21, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button22, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button23, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button24, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button25, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button30, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button31, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button32, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button33, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button34, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button35, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button40, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button41, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button42, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button43, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button44, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button45, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button50, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button51, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button52, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button53, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button54, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(button55, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Bradley Chelsey
	//private JButton buttonStash;
	
	private JLabel holdingLabel;
	private JLabel scoreLabel;
	
	private JButton button00;
	private JButton button01;
	private JButton button02;
	private JButton button03;
	private JButton button04;
	private JButton button05;
	
	private JButton button10;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JButton button14;
	private JButton button15;

	private JButton button20;
	private JButton button21;
	private JButton button22;
	private JButton button23;
	private JButton button24;
	private JButton button25;
	
	private JButton button30;
	private JButton button31;
	private JButton button32;
	private JButton button33;
	private JButton button34;
	private JButton button35;

	private JButton button40;
	private JButton button41;
	private JButton button42;
	private JButton button43;
	private JButton button44;
	private JButton button45;
	
	private JButton button50;
	private JButton button51;
	private JButton button52;
	private JButton button53;
	private JButton button54;
	private JButton button55;
	
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}