package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import controller.ButtonObserver;
/**
 * Class JPanel Display game button
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

public class PanelGameButtons extends JPanel implements ActionListener {
	
	protected ButtonObserver observer;
	protected final static String[] BUTTONS = new String[] {
        "run", "quick run", "exit"
    };
        private final static int WIDTH_BUTTON = 80;
        private final static int HEIGHT_BUTTON = 30;
	
	public PanelGameButtons(ButtonObserver observer) {
		super();
		this.observer = observer;

		this.setLayout(new GridLayout(1,1,10,10));

            for (String BUTTONS1 : BUTTONS) {
                JButton b = new JButton(BUTTONS1);
                b.addActionListener(this);
                b.setMaximumSize(new Dimension(WIDTH_BUTTON, HEIGHT_BUTTON));
                add(b);
            }
	}
	
        @Override
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