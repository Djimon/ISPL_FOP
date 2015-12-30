package Gui; 

import java.awt.BorderLayout; 
import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import java.awt.Point; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.ArrayList; 
import java.util.List; 

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JRadioButton; 



import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array; 

public   class  Create_New_MainWindow {
	
	private JFrame f ;

	
	private List<JRadioButton> cList = new ArrayList<JRadioButton>();

	
	private final JButton getStarted = new JButton("Statistik Starten");

	
	
	ActionListener al = new ActionListener() {
		   public void actionPerformed( ActionEvent e ) {
			  sportChosen();
		  }
		};

	

	ActionListener checkOnChecked = new ActionListener() {
		   public void actionPerformed( ActionEvent e ) {
			  JRadioButton rb = null;
			  Object source = e.getSource();
				if (source instanceof JRadioButton) {
					rb = (JRadioButton) source;
				}
					for(JRadioButton i:cList){
						  if(rb.getText() != i.getText()){
							  if(i.isSelected()){
								  i.setSelected(false);
								  i.revalidate();
							  }
						  }
				}		  
		  }
		};

			
	
	public Create_New_MainWindow(int h, int w, String option,List<String> usedSports){
		f = new JFrame(option);
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel rbPanel = new JPanel(new FlowLayout());
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize(w, h);
		Point p = new Point();
			  p.x = 950;
			  p.y = 400;
		f.setLocation(p);
		f.add(mainPanel);
		mainPanel.add(rbPanel, BorderLayout.CENTER);
		for (String s: usedSports){
			JRadioButton rb = this.Create_RadioButtons(s);
			rbPanel.add(rb);
			
		}
		
		this.getStarted.addActionListener(al);
		
		mainPanel.add(this.getStarted, BorderLayout.SOUTH);
	}

	
	
	public void setVisilbe(){
		this.f.setVisible( true );
	}

	
	
	private void redraw()
	{
	    f.revalidate();
	    f.repaint();
	    f.pack();
	}

	
	
	private JRadioButton Create_RadioButtons(String RB_Name){
		JRadioButton rb = new JRadioButton(RB_Name);
		rb.setText(RB_Name);
		rb.addActionListener(checkOnChecked);
		this.cList.add(rb);
		return rb;
	}

	

	
	private void sportChosen(){
		for(JRadioButton c: cList ){
			if(c.isSelected())
			{
				Create_New_GameClockWindow clock;
				f.setVisible(false);
				Create_New_StatistikWindow spSt = new Create_New_StatistikWindow(c.getText(), f);
				if(c.getText()=="Fussball"){
					clock = new Create_New_GameClockWindow(c.getText(),2,45,false);
					clock.setVisible();
				}
				
				if(c.getText()=="Basketball"){
					 clock = new Create_New_GameClockWindow(c.getText(),4,15,true);
					 clock.setVisible();
				}
			
				if(c.getText()=="Handball"){
					clock = new Create_New_GameClockWindow(c.getText(),2,30,false);
					clock.setVisible();
				}
			
				if(c.getText()=="Rugby"){
					 clock = new Create_New_GameClockWindow(c.getText(),2,40,true);
					 clock.setVisible();
				}

				if(c.getText()=="Ultimate"){
					 clock = new Create_New_GameClockWindow(c.getText(),0,90,false);
					 clock.setVisible();
				}
					 
				
			}
		}
	}


}
