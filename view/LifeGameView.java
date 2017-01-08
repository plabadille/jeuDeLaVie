package view;

/**
 * JFrame Class of gameLife
 *
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */
import controller.ButtonObserver;
import controller.PanelGameConstants;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import model.gameEngine.GameConstants;
import model.sea.Sea;

/**
 * Main window of the game
 */
public class LifeGameView extends JFrame {

    private final static int WIDTH = 950;
    private final static int HEIGHT = 600;

    public LifeGameView() {
        initGUILifeGame();
    }

    public void initGUILifeGame() {

        this.setTitle("Life game : Shark vs Sardine !");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);

        //observer
        ButtonObserver bo = new ButtonObserver();
        //panel
        GameConstants gc = new GameConstants();
        PanelGame pg = new PanelGame(gc);
        //gameButton
        PanelGameButtons pgb = new PanelGameButtons(bo);
        //gameConstants panel
        PanelGameConstants pgc = new PanelGameConstants();

        //setting layout
        this.setLayout(new BorderLayout());
        this.getContentPane().add(pg, BorderLayout.CENTER);
        this.getContentPane().add(pgc, BorderLayout.EAST);
        this.getContentPane().add(pgb, BorderLayout.SOUTH);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    //getter

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
    

}
