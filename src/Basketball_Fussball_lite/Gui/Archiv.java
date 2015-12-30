package Gui; 

import java.io.File; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.List; 

import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileFilter; 

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID; 

import Objects.Spieler; 

public  class  Archiv {
	
	
	/* TName.xsave:
	 * Siege,Niederlage,Pass_voll,Pass_fehl,Pass_jeSP,Tor_jeSP,
	 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
	 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
	 * Spielernummer-vollst_pass-fehl_pass-...; //erstes Spiel
	 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
	 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
	 * Spielernummer-vollst_pass-fehl_pass-...; // zweites Spiel
	 * ...
	 */
	
	private static String filepath;

	
	private static String lastOpenPath = filepath;

	

	public static void setFilepath(String filepath)
	{
		Archiv.filepath = filepath;
	}

	


	public static void save(List<Spieler> playerlist, String teamstats) throws Exception
	{
		
		if (playerlist == null) throw new Exception("Spielerliste nicht gefunden");
		else 
		{	
			String written = teamstats;
			String[] stats = written.split(",");
			int i_wGames = Integer.parseInt(stats[0]);
			int i_lGames = Integer.parseInt(stats[1]);
			int i_complPasses = Integer.parseInt(stats[2]);
			int i_incPasses = Integer.parseInt(stats[3]);
			int i_cPasspGame = Integer.parseInt(stats[4]);
			int i_goalspGames = Integer.parseInt(stats[5]);
			int i_goals = 0;
			written = "";
			for (int i=0; i<= playerlist.size() -1 ; i++)
			{
				written =  
				playerlist.get(i).getI_compPasses()+"-"+
				playerlist.get(i).getI_incompPasses()+"-"+
				playerlist.get(i).getI_assists()+"-"+
				playerlist.get(i).getI_goals()+
				",";
				
				i_goals += playerlist.get(i).getI_goals();
				i_complPasses += playerlist.get(i).getI_compPasses();
				i_incPasses += playerlist.get(i).getI_incompPasses();
			}
			
			i_goalspGames = ( i_goalspGames * (i_wGames + i_lGames -1) + i_goals) / (i_wGames + i_lGames) ;
			i_cPasspGame = (i_cPasspGame * (i_wGames+ i_lGames -1) + (i_complPasses) ) / (i_wGames + i_lGames);
			
			String saving =i_wGames + "," + i_lGames + "," + i_complPasses + "," + i_incPasses + "," + i_cPasspGame + "," + i_goalspGames + ",";
			saving += written + "; ";
		
			//TODO: implement concatenation 		
		
			saveToFile(saving,filepath);
		}
	}

	
	
	
	public static String[] loadSaves(String sport)
	{
		openFile(sport);
		//System.out.println(filepath);
		String saves = loadFromFile(filepath);
		String[] raw = saves.split(";");
		System.out.println("raw-split:");
		System.out.println(raw);
		// letztes Ergebnis auslesen:
	    return raw[raw.length-2].split(",");	
	    
	}

	
	
	public static List<Spieler> getPList(String[] players)
	{
		List <Spieler> playerlist = new ArrayList<Spieler>();
		for (int i=0; i<=players.length-2; i++)
		{
			String[][] splitted = new String[players.length-1][];
			splitted[i] =(players[i].split("-"));
			String spieler = Integer.toString(i+1);
			Spieler xPlayer = new Spieler(""+(i+1));
			playerlist.add(xPlayer);
			System.out.println(playerlist);
			playerlist.get(i).setI_compPasses(Integer.parseInt(splitted[i][0]));
			playerlist.get(i).setI_incompPasses(Integer.parseInt(splitted[i][0]));
			playerlist.get(i).setI_assists(Integer.parseInt(splitted[i][0]));
			playerlist.get(i).setI_goals(Integer.parseInt(splitted[i][0]));
		}
		return playerlist;
	}

	

	public static void saveToFile(String string, String filename)
	{
		try 
		{
            File newTextFile = new File(filename);
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(string);
            fw.close();
        } 
		catch (IOException iox) 
		{
            //do stuff with exception
            iox.printStackTrace();
        }
	}

	
	
	
	
	public static String loadFromFile(String filename)
	{
	    String content = null;
	    File file = new File(filename); //for ex foo.txt
	    FileReader reader = null;
	    try 
	    {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        reader.close();
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        if(reader !=null)
	        {
	        	try 
	        	{
	        		reader.close();
	        	} 
	        	catch (IOException e) 
	        	{
	        		// do stuff with exception
	        		e.printStackTrace();
	        	}
	        }
	    }
	    return content;
	}

	
	
	
	private static void openFile(String sports) {
		JFileChooser fileChooser = null;
		
		
		if (lastOpenPath != null && !lastOpenPath.equals("")) {
			fileChooser = new JFileChooser(lastOpenPath);
		} else {
			fileChooser = new JFileChooser();
		}
		
		FileFilter xsave = new FileFilter() 
		{
			@Override
			public String getDescription() 
			{
				return "Save file (*.xsave)";
			}

			@Override
			public boolean accept(File file) 
			{
				if (file.isDirectory()) 
				{
					return true;
				} else {
					return file.getName().toLowerCase().endsWith(".xsave");
				}
			}
		};
		
		FileFilter fsave = new FileFilter()
		{

			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) return true;
				else return file.getName().toLowerCase().endsWith(".fsave");
					
			}

			@Override
			public String getDescription() {
				return "Save file (*.fsave)";
			}
			
		};
		
		FileFilter bsave = new FileFilter()
		{
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) return true;
				else return file.getName().toLowerCase().endsWith(".bsave");	
			}
			@Override
			public String getDescription() {
				return "Save file (*.bsave)";
			}
		};

		FileFilter hsave = new FileFilter()
		{
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) return true;
				else return file.getName().toLowerCase().endsWith(".hsave");	
			}
			@Override
			public String getDescription() {
				return "Save file (*.hsave)";
			}
		};

		FileFilter rsave = new FileFilter()
		{
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) return true;
				else return file.getName().toLowerCase().endsWith(".rsave");	
			}
			@Override
			public String getDescription() {
				return "Save file (*.rsave)";
			}
		};

		FileFilter usave = new FileFilter()
		{
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) return true;
				else return file.getName().toLowerCase().endsWith(".usave");	
			}
			@Override
			public String getDescription() {
				return "Save file (*.usave)";
			}
		};

		switch (sports)
		{
		  case "Fussball": fileChooser.setFileFilter(fsave);
			  break;
		  case "Basketball": fileChooser.setFileFilter(bsave);
			  break;
		  case "Handball": fileChooser.setFileFilter(hsave);
			  break;
		  case "Rugby": fileChooser.setFileFilter(rsave);
			  break;
		  case "Ultimate": fileChooser.setFileFilter(usave);
			  break;
			  default: fileChooser.setFileFilter(xsave);
		}
	
		fileChooser.setDialogTitle("Open Save File");
		fileChooser.setAcceptAllFileFilterUsed(false);

		int userChoice = fileChooser.showOpenDialog(fileChooser);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			filepath = fileChooser.getSelectedFile().getAbsolutePath();
			lastOpenPath = fileChooser.getSelectedFile().getParent();
		
		}
	}


}
