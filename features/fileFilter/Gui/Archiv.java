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

public class Archiv {
		
	private static void openFile(String sports) 
	{
		JFileChooser fileChooser;
		
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
		//TODO: rethink: doppelte initialisierung
		original(sports);
		
	}
	
}
