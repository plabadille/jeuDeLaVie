package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import controller.ButtonObserver;

public class PanelGameButtons extends JPanel implements ActionListener {
	
	protected ButtonObserver observer;
	protected final static String[] BUTTONS = new String[] {
        "run", "quick run", "exit"
    };
	
	public PanelGameButtons(ButtonObserver observer) {
		super();
		this.observer = observer;

		this.setLayout(new GridLayout(3,1));

        for (int i = 0; i < BUTTONS.length ; i++) {	
            JButton b = new JButton(BUTTONS[i]);
            b.addActionListener(this);
            add(b);
        }
	}
	
	public void actionPerformed(ActionEvent e) {
		String c = ((JButton) e.getSource()).getText();
        switch (c) {
            case "run":
                this.observer.normalRun(c);
                break;
            case "quick run":
                this.observer.quickRun(c);
                break;
            case "exit":
                this.observer.exit(c);
                break;
        }
	}

}