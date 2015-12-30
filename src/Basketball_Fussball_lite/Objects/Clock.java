package Objects; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 

import javax.swing.JLabel; 
import javax.swing.Timer; 



public   class  Clock {
	
	Timer timer  ;

	
	int sek  =0;

	
	int min  ;

	
	int gameTime  ;

	
	
	private ActionListener timerEvent  = new ActionListener() {
		   public void actionPerformed( ActionEvent e ) {
			  if(sek == 60){
				  sek = 0;
				  min--;
			  }
			  if (min == 0){
				  // ToDo Ring bell or play Jingel				  
			  }
		  }
		};

	
	
	public Clock  (int m_gameMin){
		this.timer = new Timer(100, timerEvent);
		this.min = m_gameMin;
		this.gameTime = m_gameMin;
	
		this.timer = new Timer(100, timerEvent);
		this.min = m_gameMin;
		this.gameTime = m_gameMin;
	}

	
	
	public Clock  (int m_gameMin, ActionListener m_timerEvent){
		this.timer = new Timer(100, m_timerEvent);
		this.min = m_gameMin;
		this.gameTime = m_gameMin;
	
		this.timer = new Timer(100, m_timerEvent);
		this.min = m_gameMin;
		this.gameTime = m_gameMin;
	}

	
	
	
	public String getGameTime  (){
		return "" + min + ":" +(60-sek);
	}

	
	
	public ActionListener getTimer  (){
		return this.timerEvent;
	}

	
	public void startTimer  (){
		this.timer.start();
	}

	
	public void stopTimer  (){
		this.timer.stop();
	}

	
	public void resetTimer  (){
		this.sek= 0;
		this.min = this.gameTime;
		this.timer.restart();
	}


}
