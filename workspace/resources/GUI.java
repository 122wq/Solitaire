package resources;
import javax.imageio.ImageIO;
import javax.sql.rowset.FilteredRowSet;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Stack;


public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	Solitaire game;
   public GUI(Solitaire game){
	   this.game= game;
        //Create and set up the window.
       setTitle("Solitaire");
       setSize(1016,602);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   //make it not resizeable so it won't mess up the layout
	   setResizable(false);
		
       // this supplies the background
       	try {
		System.out.println(getClass().toString());
		Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
		setContentPane(new ImagePanel(blackImg));

       	}catch(IOException e) {
    	   e.printStackTrace();
       	}
		setLayout(new GridBagLayout());// set the layout
    	GridBagConstraints c = new GridBagConstraints();// special class used to configure how items should fit into the container.
	   	//getContentPane().setLayout(new GridLayout(2,1));
		//the four panels where cards will be
	   	JPanel panel = new JPanel();
	   	c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.15;
		c.ipady = 200;
        c.gridx = 0;
        c.gridy = 0;
	   	panel.setBorder(BorderFactory.createTitledBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, Color.RED), "Card Pile"));
	   	//panel.setSize(new Dimension(200,165));
	   	panel.setOpaque(false);
	   	add(panel,c);
	   
	   	JPanel panel2 = new JPanel();
	   	c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.25;
        c.gridx = 1;
        c.gridy = 0;
	   	panel2.setBorder(BorderFactory.createTitledBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLUE), "Card selection pile"));
	   	//panel2.setSize(new Dimension(250,165));
	   	//panel2.setLocation(200,0);
	   	panel2.setOpaque(false);
	   	add(panel2,c);

	   	JPanel panel3 = new JPanel();
	   	c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.6;
        c.gridx = 2;
        c.gridy = 0;
	   	panel3.setBorder(BorderFactory.createTitledBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN), "Card sorted piles"));
	   	//panel3.setSize(new Dimension(550,165));
	   	//panel3.setLocation(450,0);
	   	panel3.setOpaque(false);
	   	add(panel3,c);

		JPanel panel4 = new JPanel();
	   	c.fill = GridBagConstraints.HORIZONTAL;
	   	c.weightx = 0.5;
		c.ipady = 350;
        c.gridx = 0;
        c.gridy = 2;
		c.gridwidth = 3;
	   	panel4.setBorder(BorderFactory.createTitledBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.YELLOW), "Playing field"));
	   	//panel4.setSize(new Dimension(1000,400));
	   	//panel4.setLocation(0,165);
	   	panel4.setOpaque(false);
	   	add(panel4,c);

	   
       
       	/*******
        * This is just a test to make sure images are being read correctly on your machine. Please replace
        * once you have confirmed that the card shows up properly. The code below should allow you to play the solitare
        * game once it's fully created.
        */
		/*Card card = new Card(2, Card.Suit.Diamonds);
		card.setPreferredSize(new Dimension(100,100));
       	System.out.println(card);
       	panel2.add(card);*/
	   	Stack<Card> s1 = new Stack<>();
	   	s1.push(new Card(1, Card.Suit.Diamonds));
	   	s1.push(new Card(2, Card.Suit.Clubs));
		s1.push(new Card(4, Card.Suit.Hearts));
	   	panel3.add(drawPile(s1));
    	this.setVisible(true);
    }

	//here’s the function definition 

   	public JLayeredPane drawPile(Stack<Card> stackIn) {
    	Object cards[];

   		cards = stackIn.toArray(); //please note we convert this stack to an array so that we can iterate through it backwards while drawing. You’ll need to cast each element inside cards to a <Card> in order to use the methods to adjust their position
		JLayeredPane layerPane = new JLayeredPane();
		layerPane.setPreferredSize(new Dimension(500,500));
		for (int i = 0; i < cards.length; i++)
		{
			((Card)cards[i]).setBounds(i * 10, i * 10, 80, 100);
			layerPane.add((Component) cards[i], i);
		}
		return layerPane;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

