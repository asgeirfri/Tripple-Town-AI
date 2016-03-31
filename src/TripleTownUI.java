import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
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
	
	private void updateButtons() {
		String button00Point = "" + myboard.board[0][0];
		button00.setText(button00Point);
		String button01Point = "" + myboard.board[0][1];
		button01.setText(button01Point);
		String button02Point = "" + myboard.board[0][2];
		button02.setText(button02Point);
		String button03Point = "" + myboard.board[0][3];
		button03.setText(button03Point);
		String button04Point = "" + myboard.board[0][4];
		button04.setText(button04Point);
		String button05Point = "" + myboard.board[0][5];
		button05.setText(button05Point);
		
		String button10Point = "" + myboard.board[1][0];
		button10.setText(button10Point);
		String button11Point = "" + myboard.board[1][1];
		button11.setText(button11Point);
		String button12Point = "" + myboard.board[1][2];
		button12.setText(button12Point);
		String button13Point = "" + myboard.board[1][3];
		button13.setText(button13Point);
		String button14Point = "" + myboard.board[1][4];
		button14.setText(button14Point);
		String button15Point = "" + myboard.board[1][5];
		button15.setText(button15Point);
		
		String button20Point = "" + myboard.board[2][0];
		button20.setText(button20Point);
		String button21Point = "" + myboard.board[2][1];
		button21.setText(button21Point);
		String button22Point = "" + myboard.board[2][2];
		button22.setText(button22Point);
		String button23Point = "" + myboard.board[2][3];
		button23.setText(button23Point);
		String button24Point = "" + myboard.board[2][4];
		button24.setText(button24Point);
		String button25Point = "" + myboard.board[2][5];
		button25.setText(button25Point);
		
		String button30Point = "" + myboard.board[3][0];
		button30.setText(button30Point);
		String button31Point = "" + myboard.board[3][1];
		button31.setText(button31Point);
		String button32Point = "" + myboard.board[3][2];
		button32.setText(button32Point);
		String button33Point = "" + myboard.board[3][3];
		button33.setText(button33Point);
		String button34Point = "" + myboard.board[3][4];
		button34.setText(button34Point);
		String button35Point = "" + myboard.board[3][5];
		button35.setText(button35Point);
		
		String button40Point = "" + myboard.board[4][0];
		button40.setText(button40Point);
		String button41Point = "" + myboard.board[4][1];
		button41.setText(button41Point);
		String button42Point = "" + myboard.board[4][2];
		button42.setText(button42Point);
		String button43Point = "" + myboard.board[4][3];
		button43.setText(button43Point);
		String button44Point = "" + myboard.board[4][4];
		button44.setText(button44Point);
		String button45Point = "" + myboard.board[4][5];
		button45.setText(button45Point);
		
		String button50Point = "" + myboard.board[5][0];
		button50.setText(button50Point);
		String button51Point = "" + myboard.board[5][1];
		button51.setText(button51Point);
		String button52Point = "" + myboard.board[5][2];
		button52.setText(button52Point);
		String button53Point = "" + myboard.board[5][3];
		button53.setText(button53Point);
		String button54Point = "" + myboard.board[5][4];
		button54.setText(button54Point);
		String button55Point = "" + myboard.board[5][5];
		button55.setText(button55Point);
		
		int holding = myboard.holding;
		int score = myboard.points;
		System.out.println("You're currently holding: " + holding);
		System.out.println("Your current score: " + score + "\n");
	}
	
	private void button00ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(0,0);
			myboard.playerMove(move);
			String temp = "" + myboard.board[0][0];
			myboard.moveBears();
			button00.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button01ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(0,1);
			myboard.playerMove(move);
			String temp = "" + myboard.board[0][1];
			myboard.moveBears();
			button01.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button02ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(0,2);
			myboard.playerMove(move);
			String temp = "" + myboard.board[0][2];
			myboard.moveBears();
			button02.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button03ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(0,3);
			myboard.playerMove(move);
			String temp = "" + myboard.board[0][3];
			myboard.moveBears();
			button03.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button04ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(0,4);
			myboard.playerMove(move);
			String temp = "" + myboard.board[0][4];
			myboard.moveBears();
			button04.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button05ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(0,5);
			myboard.playerMove(move);
			String temp = "" + myboard.board[0][5];
			myboard.moveBears();
			button05.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	
	private void button10ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(1,0);
			myboard.playerMove(move);
			String temp = "" + myboard.board[1][0];
			myboard.moveBears();
			button10.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button11ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(1,1);
			myboard.playerMove(move);
			String temp = "" + myboard.board[1][1];
			myboard.moveBears();
			button11.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button12ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(1,2);
			myboard.playerMove(move);
			String temp = "" + myboard.board[1][2];
			myboard.moveBears();
			button12.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button13ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(1,3);
			myboard.playerMove(move);
			String temp = "" + myboard.board[1][3];
			myboard.moveBears();
			button13.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button14ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(1,4);
			myboard.playerMove(move);
			String temp = "" + myboard.board[1][4];
			myboard.moveBears();
			button14.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button15ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(1,5);
			myboard.playerMove(move);
			String temp = "" + myboard.board[1][5];
			myboard.moveBears();
			button15.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	
	private void button20ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(2,0);
			myboard.playerMove(move);
			String temp = "" + myboard.board[2][0];
			myboard.moveBears();
			button20.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button21ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(2,1);
			myboard.playerMove(move);
			String temp = "" + myboard.board[2][1];
			myboard.moveBears();
			button21.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button22ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(2,2);
			myboard.playerMove(move);
			String temp = "" + myboard.board[2][2];
			myboard.moveBears();
			button22.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button23ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(2,3);
			myboard.playerMove(move);
			String temp = "" + myboard.board[2][3];
			myboard.moveBears();
			button23.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button24ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(2,4);
			myboard.playerMove(move);
			String temp = "" + myboard.board[2][4];
			myboard.moveBears();
			button24.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button25ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(2,5);
			myboard.playerMove(move);
			String temp = "" + myboard.board[2][5];
			myboard.moveBears();
			button25.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	
	private void button30ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(3,0);
			myboard.playerMove(move);
			String temp = "" + myboard.board[3][0];
			myboard.moveBears();
			button30.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button31ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(3,1);
			myboard.playerMove(move);
			String temp = "" + myboard.board[3][1];
			myboard.moveBears();
			button31.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button32ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(3,2);
			myboard.playerMove(move);
			String temp = "" + myboard.board[3][2];
			myboard.moveBears();
			button32.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button33ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(3,3);
			myboard.playerMove(move);
			String temp = "" + myboard.board[3][3];
			myboard.moveBears();
			button33.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button34ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(3,4);
			myboard.playerMove(move);
			String temp = "" + myboard.board[3][4];
			myboard.moveBears();
			button34.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button35ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(3,5);
			myboard.playerMove(move);
			String temp = "" + myboard.board[3][5];
			myboard.moveBears();
			button35.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	
	private void button40ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(4,0);
			myboard.playerMove(move);
			String temp = "" + myboard.board[4][0];
			myboard.moveBears();
			button40.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button41ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(4,1);
			myboard.playerMove(move);
			String temp = "" + myboard.board[4][1];
			myboard.moveBears();
			button41.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button42ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(4,2);
			myboard.playerMove(move);
			String temp = "" + myboard.board[4][2];
			myboard.moveBears();
			button42.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button43ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(4,3);
			myboard.playerMove(move);
			String temp = "" + myboard.board[4][3];
			myboard.moveBears();
			button43.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button44ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(4,4);
			myboard.playerMove(move);
			String temp = "" + myboard.board[4][4];
			myboard.moveBears();
			button44.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button45ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(4,5);
			myboard.playerMove(move);
			String temp = "" + myboard.board[4][5];
			myboard.moveBears();
			button45.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	
	private void button50ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(5,0);
			myboard.playerMove(move);
			String temp = "" + myboard.board[5][0];
			myboard.moveBears();
			button50.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button51ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(5,1);
			myboard.playerMove(move);
			String temp = "" + myboard.board[5][1];
			myboard.moveBears();
			button51.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button52ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(5,2);
			myboard.playerMove(move);
			String temp = "" + myboard.board[5][2];
			myboard.moveBears();
			button52.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button53ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(5,3);
			myboard.playerMove(move);
			String temp = "" + myboard.board[5][3];
			myboard.moveBears();
			button53.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button54ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(5,4);
			myboard.playerMove(move);
			String temp = "" + myboard.board[5][4];
			myboard.moveBears();
			button51.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}
	private void button55ActionPerformed(ActionEvent e) {
		try {
			Point move = new Point(5,5);
			myboard.playerMove(move);
			String temp = "" + myboard.board[5][5];
			myboard.moveBears();
			button55.setText(temp);
		}
		catch (RuntimeException r) {
			System.out.println("Invalid move.");
		}
		updateButtons();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Bradley Chelsey
		//buttonStash = new JButton();
		
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
		setTitle("Tic Tac Toe");
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