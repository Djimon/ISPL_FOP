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

public class Create_New_MainWindow {
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
	
	public void _Create_New_MainWindow(int h, int w, String option,List<String> usedSports)	
	{
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
	
	public Create_New_MainWindow(int h, int w, String option,List<String> usedSports)
	{
		_Create_New_MainWindow(h, w, option, usedSports);
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
	
	

}
