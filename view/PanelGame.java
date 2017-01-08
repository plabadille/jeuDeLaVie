package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.gameEngine.GameConstants;
import model.sea.Sea;

/**
 * Class JPanel Display sea,shark and sardine
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

public class PanelGame extends JPanel{
    
    private boolean[][]gameboard;
    private Dimension gameBoardSize = null;
    //private Dimension gameBoardWidth
    private static final int BLOCK_SIZE = 10;
    
    
	public PanelGame(GameConstants gc){
            initPanel();
            this.setSize(gc.getSeaLenght(), gc.getSeaWidth());
           
            gameBoardSize = new Dimension(getSize().width/BLOCK_SIZE-2, getSize().height/BLOCK_SIZE-2);
             System.out.println("size largeur : "+getSize().height);
            //gameboard = new boolean[80][60];
            
            
            
        }
        
        public void initPanel(){
            
            //tmp
            this.setBackground(Color.DARK_GRAY);
        }
        
        public void paintComponent(Graphics g){
            
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            
            for(int i=0; i<=gameBoardSize.width;i++){
                g.drawLine(((i*BLOCK_SIZE)+BLOCK_SIZE), BLOCK_SIZE, (i*BLOCK_SIZE)+BLOCK_SIZE, BLOCK_SIZE + (BLOCK_SIZE*gameBoardSize.height));
            }
            for (int i=0; i<=gameBoardSize.height; i++) {
                g.drawLine(BLOCK_SIZE, ((i*BLOCK_SIZE)+BLOCK_SIZE), BLOCK_SIZE*(gameBoardSize.width+1), ((i*BLOCK_SIZE)+BLOCK_SIZE));
            }
            
        }
}