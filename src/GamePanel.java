import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    Wonka wonka;
    Timer fps;
    int frameCount = 0;
    int startFrameCount = 0;
    
    public GamePanel() {
        wonka = new Wonka(GameJump.WIDTH / 2, 400, 378 / 3, 720 / 3);
        fps = new Timer(1000 / 60, this);
        fps.start();
    }
    
    public void paintComponent(Graphics g) {
        g.setColor( Color.BLACK );
        g.fillRect( 0, 0, GameJump.WIDTH, GameJump.HEIGHT);
        
        wonka.update(frameCount);
        wonka.draw( g );
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
       int keyPressed = e.getKeyCode();
       
       if( keyPressed == KeyEvent.VK_LEFT) {
           wonka.xSpeed = -15;
       } else if( keyPressed == KeyEvent.VK_RIGHT) {
           wonka.xSpeed = 15;
       } else if( keyPressed == KeyEvent.VK_UP) {
           wonka.jump();
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        
        if( keyPressed == KeyEvent.VK_LEFT || ( keyPressed == KeyEvent.VK_RIGHT)) {
            wonka.xSpeed = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        frameCount++;
        repaint();
    }
}
