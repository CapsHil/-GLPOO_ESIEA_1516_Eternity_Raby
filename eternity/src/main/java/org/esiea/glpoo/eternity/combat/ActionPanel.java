package org.esiea.glpoo.eternity.combat;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ActionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JScrollPane scroll;
	JTextArea zoneText;
	BoutonPanel boutonPanel;
	
	public ActionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.setPreferredSize(getPreferredSize());
		
		this.zoneText = new JTextArea();
		this.zoneText.setEditable(false);
		this.zoneText.setMargin(new Insets(10, 10, 10, 10));
		
		this.boutonPanel = new BoutonPanel();
		
		this.scroll = new JScrollPane(zoneText);
        this.scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add Textarea in to middle panel
        this.add(this.scroll);	
		this.add(this.boutonPanel);
	}
	
	@Override
	public Dimension getPreferredSize() { // Preferred size of the component
		return new Dimension(800, 150);
	}
	
	public void printText(String txt) {
		this.zoneText.append(txt);
		this.zoneText.setCaretPosition(this.zoneText.getDocument().getLength());
	}
	
	public void printlnText(String txt) {
		this.zoneText.append(txt);
		this.zoneText.append("\r\n");
		this.zoneText.setCaretPosition(this.zoneText.getDocument().getLength());
	}
	
	public void setBoutonListener(EventListener l) {
		this.boutonPanel.setListener(l);
	}
	
	public void setConsoleListener(MouseListener l) {
		this.zoneText.addMouseListener(l);
	}

}
