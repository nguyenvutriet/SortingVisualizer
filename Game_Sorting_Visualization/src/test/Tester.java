package test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import view.SortingVisualizerView;

public class Tester {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			new SortingVisualizerView();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
