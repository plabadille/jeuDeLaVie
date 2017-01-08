
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
    
    private JTextField seaWidthText,seaLengthText,seaSardineNumberText, seaSharkNumberText, sardineDeathAgeText, sardineSpawnAgeText, sardineSpawnRatioText, sharkDeathAgeText,
            sharkStarvingTimeText,sharkSpawnAgeText, sharkSpawnRatioText, sharkIsYoungText, sharkIsTeenagerText, sharkIsAdultText;
    private JLabel seaWidthLabel,seaLengthLabel, seaSardineNumberLabel, seaSharkNumberLabel, sardineDeathAgeLabel,sardineSpawnAgeLabel,sardineSpawnRatioLabel, sharkDeathAgeLabel,
            sharkStarvingTimeLabel,sharkSpawnAgeLabel, sharkSpawnRatioLabel, sharkIsYoungLabel,sharkIsTeenagerLabel,sharkIsAdultLabel;
    
    public PanelGameConstants()
    {
        initJPanel();
        initTextField();
    }
    
    public void initTextField(){
             
    //add textfields & labels
        //sea width
        seaWidthLabel = new JLabel("Sea width int : ");
        seaWidthText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(seaWidthLabel);
        this.add(seaWidthText);
        //sea length
        seaLengthLabel = new JLabel("Sea length int : ");
        seaLengthText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(seaLengthLabel);
        this.add(seaLengthText);
        //seaSardineNumber
        seaSardineNumberLabel = new JLabel("Sea # sardine(s) int : ");
        seaSardineNumberText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(seaSardineNumberLabel);
        this.add(seaSardineNumberText);
        //seaSharkNumber
        seaSharkNumberLabel = new JLabel("Sea # shark(s) int : ");
        seaSharkNumberText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(130, 30));
        this.add(seaSharkNumberLabel);
        this.add(seaSharkNumberText); 
        //sardineDeathAge
        sardineDeathAgeLabel = new JLabel("Sardine death age int : ");
        sardineDeathAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sardineDeathAgeLabel);
        this.add(sardineDeathAgeText); 
        //sardineSpawnAge
        sardineSpawnAgeLabel = new JLabel("Sardine spawn age int : ");
        sardineSpawnAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sardineSpawnAgeLabel);
        this.add(sardineSpawnAgeText); 
        //sardineSpawnRatio
        sardineSpawnRatioLabel = new JLabel("Sardine spawn ratio int : ");
        sardineSpawnRatioText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(130, 30));
        this.add(sardineSpawnRatioLabel);
        this.add(sardineSpawnRatioText);
        //sharkDeathAge
        sharkDeathAgeLabel = new JLabel("Shark death age int : ");
        sharkDeathAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkDeathAgeLabel);
        this.add(sharkDeathAgeText);        
        //sharkStarvingTime
        sharkStarvingTimeLabel = new JLabel("Shark starving time int : ");
        sharkStarvingTimeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkStarvingTimeLabel);
        this.add(sharkStarvingTimeText);        
        //sharkSpawnAge
        sharkSpawnAgeLabel = new JLabel("Shark spawn age int : ");
        sharkSpawnAgeText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkSpawnAgeLabel);
        this.add(sharkSpawnAgeText);       
        //sharkSpawnRatio
        sharkSpawnRatioLabel = new JLabel("Shark spawn ratio int : ");
        sharkSpawnRatioText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkSpawnRatioLabel);
        this.add(sharkSpawnRatioText);
        //sharkIsYoung
        sharkIsYoungLabel = new JLabel("Shark is Young strategy int : ");
        sharkIsYoungText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkIsYoungLabel);
        this.add(sharkIsYoungText);
        //sharkIsTeenager
        sharkIsTeenagerLabel = new JLabel("Shark is Teenager strategy int : ");
        sharkIsTeenagerText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkIsTeenagerLabel);
        this.add(sharkIsTeenagerText);
        //sharkIsAdult
        sharkIsAdultLabel = new JLabel("Shark is Adult strategy int : ");
        sharkIsAdultText = new JTextField();
        seaWidthText.setPreferredSize(new Dimension(60, 30));
        this.add(sharkIsAdultLabel);
        this.add(sharkIsAdultText);
        
    }
    public void initJPanel(){
        this.setLayout(new GridLayout(14, 3, 10, 10));
        this.setBackground(Color.LIGHT_GRAY);
    }


}
