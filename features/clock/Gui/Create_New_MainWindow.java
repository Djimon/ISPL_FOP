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
