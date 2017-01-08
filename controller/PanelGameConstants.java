
package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class JPanel Display game constants settings
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */
public class PanelGameConstants extends JPanel{
    
    public PanelGameConstants()
    {
        initJPanel();
        initTextField();
    }
    
    public void initTextField(){
             
    //add textfields & labels
        //sea width
        JLabel seaWidthLabel = new JLabel("Sea width int : ");
        JTextField seaWidthText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(seaWidthLabel);
        this.add(seaWidthText);
        //sea length
        JLabel seaLengthLabel = new JLabel("Sea length int : ");
        JTextField seaLengthText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(seaLengthLabel);
        this.add(seaLengthText);
        //seaSardineNumber
        JLabel seaSardineNumberLabel = new JLabel("Sea # sardine(s) int : ");
        JTextField seaSardineNumberText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(seaSardineNumberLabel);
        this.add(seaSardineNumberText);
        //seaSharkNumber
        JLabel seaSharkNumberLabel = new JLabel("Sea # shark(s) int : ");
        JTextField seaSharkNumberText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(130, 30));
        this.add(seaSharkNumberLabel);
        this.add(seaSharkNumberText); 
        //sardineDeathAge
        JLabel sardineDeathAgeLabel = new JLabel("Sardine death age int : ");
        JTextField sardineDeathAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sardineDeathAgeLabel);
        this.add(sardineDeathAgeText); 
        //sardineSpawnAge
        JLabel sardineSpawnAgeLabel = new JLabel("Sardine spawn age int : ");
        JTextField sardineSpawnAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sardineSpawnAgeLabel);
        this.add(sardineSpawnAgeText); 
        //sardineSpawnRatio
        JLabel sardineSpawnRatioLabel = new JLabel("Sardine spawn ratio int : ");
        JTextField sardineSpawnRatioText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(130, 30));
        this.add(sardineSpawnRatioLabel);
        this.add(sardineSpawnRatioText);
        //sharkDeathAge
        JLabel sharkDeathAgeLabel = new JLabel("Shark death age int : ");
        JTextField sharkDeathAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkDeathAgeLabel);
        this.add(sharkDeathAgeText);        
        //sharkStarvingTime
        JLabel sharkStarvingTimeLabel = new JLabel("Shark starving time int : ");
        JTextField sharkStarvingTimeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkStarvingTimeLabel);
        this.add(sharkStarvingTimeText);        
        //sharkSpawnAge
        JLabel sharkSpawnAgeLabel = new JLabel("Shark spawn age int : ");
        JTextField sharkSpawnAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkSpawnAgeLabel);
        this.add(sharkSpawnAgeText);       
        //sharkSpawnRatio
        JLabel sharkSpawnRatioLabel = new JLabel("Shark spawn ratio int : ");
        JTextField sharkSpawnRatioText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkSpawnRatioLabel);
        this.add(sharkSpawnRatioText);
        //sharkIsYoung
        JLabel sharkIsYoungLabel = new JLabel("Shark is Young strategy int : ");
        JTextField sharkIsYoungText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkIsYoungLabel);
        this.add(sharkIsYoungText);
        //sharkIsTeenager
        JLabel sharkIsTeenagerLabel = new JLabel("Shark is Teenager strategy int : ");
        JTextField sharkIsTeenagerText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkIsTeenagerLabel);
        this.add(sharkIsTeenagerText);
        //sharkIsAdult
        JLabel sharkIsAdultLabel = new JLabel("Shark is Adult strategy int : ");
        JTextField sharkIsAdultText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkIsAdultLabel);
        this.add(sharkIsAdultText);
        
    }
    public void initJPanel(){
        this.setLayout(new GridLayout(14, 3, 10, 10));
        this.setBackground(Color.LIGHT_GRAY);
    }
}
