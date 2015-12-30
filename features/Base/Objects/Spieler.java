package Objects;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spieler {
	
	private JPanel l = new JPanel(new BorderLayout());
	private JPanel gButtons = new JPanel(new GridLayout(1,4));
	
	private Dimension d = new Dimension(50,10);
	
	private JButton compPasses = new JButton("Vollständige Pässe:");
	private int i_compPasses = 0;
	private JButton incompPasses = new JButton("Unvollständige Pässe:");
	private int i_incompPasses = 0;
	private JButton assists = new JButton("Vorlagen:");
	private int i_assists = 0;
	private JButton goals = new JButton("Tore:");
	private int i_goals = 0;
	
	private JLabel playerCount = new JLabel();
	
	public int getI_compPasses() {
		return i_compPasses;
	}
	public void setI_compPasses(int i_compPasses) {
		this.i_compPasses = i_compPasses;
	}
	public int getI_incompPasses() {
		return i_incompPasses;
	}
	public void setI_incompPasses(int i_incompPasses) {
		this.i_incompPasses = i_incompPasses;
	}
	public int getI_assists() {
		return i_assists;
	}
	public void setI_assists(int i_assists) {
		this.i_assists = i_assists;
	}
	public int getI_goals() {
		return i_goals;
	}
	public void setI_goals(int i_goals) {
		this.i_goals = i_goals;
	}
	
	
	public Spieler(String player){
		playerCount.setText(player);
		this.l.add(playerCount, BorderLayout.NORTH);
		
		
		this.compPasses.addActionListener(this.al_compPasses);
		this.incompPasses.addActionListener(this.al_incompPasses);
		this.assists.addActionListener(this.al_assists);
		this.goals.addActionListener(this.al_goals);
		
		this.compPasses.setSize(d);
		this.incompPasses.setSize(d);
		this.assists.setSize(d);
		this.goals.setSize(d);
		
		this.gButtons.add(this.compPasses);
		this.gButtons.add(this.incompPasses);
		this.gButtons.add(this.assists);
		this.gButtons.add(this.goals);
		
		this.l.add(this.gButtons, BorderLayout.WEST);
	}
	
	//ActionListener***************************************
			private ActionListener al_compPasses = new ActionListener() {
				  @Override public void actionPerformed( ActionEvent e ) {
					  //ToDO
					  i_compPasses++;
					  Object source = e.getSource();
					  if (source instanceof JButton) {
							JButton button = (JButton) source;
							button.setText("Vollständige Pässe:" + i_compPasses);
							button.revalidate();
					  }
				  }
				};



			private ActionListener al_incompPasses = new ActionListener() {
				  @Override public void actionPerformed( ActionEvent e ) {
					  //ToDO
					  i_incompPasses++;
					  Object source = e.getSource();
					  if (source instanceof JButton) {
							JButton button = (JButton) source;
							button.setText("Unvollständige Pässe:" + i_incompPasses);
							button.revalidate();
					  }
				  }
				};
				
			private ActionListener al_assists = new ActionListener() {
				  @Override public void actionPerformed( ActionEvent e ) {
					  //ToDO
					  i_assists++;
					  Object source = e.getSource();
					  if (source instanceof JButton) {
							JButton button = (JButton) source;
							button.setText("Vorlagen:" + i_assists);
							button.revalidate();
					  }
				  }
				};
				
			private ActionListener al_goals = new ActionListener() {
				  @Override public void actionPerformed( ActionEvent e ) {
					  //ToDO
					  i_goals++;
					  Object source = e.getSource();
					  if (source instanceof JButton) {
							JButton button = (JButton) source;
							button.setText("Tore:" + i_goals);
							button.revalidate();
					  }	
				  }
				};
			//ActionListener***************************************
			public JPanel getPlayer(){
				return this.l;
			}
			
}