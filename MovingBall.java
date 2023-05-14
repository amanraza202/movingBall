import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingBall extends JPanel implements ActionListener {
    private JButton forbtn;
    private JButton backbtn;
    private int x = 0;
    private int y = 0;
    private int xSpeed = 100;
    private int ySpeed = 100;

    public MovingBall() {
        Timer timer = new Timer(10, this);
        timer.start();
        forbtn = new JButton("Move");
        forbtn.setBounds(100, 100, 100, 30);
        add(forbtn);
        backbtn = new JButton("Direction");
        backbtn.setBounds(200, 100, 100, 30);
        add(backbtn);
        forbtn.addActionListener(this);
        backbtn.addActionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == forbtn) {
            if (x < 0 || x > getWidth() - 50) {
                xSpeed = -xSpeed;
            }
            if (y < 0 || y > getHeight() - 50) {
                ySpeed = -ySpeed;
            }
            x += xSpeed;
            y += ySpeed;
            repaint();
        }
        else{
            if(e.getSource()==backbtn){
                if(x>0 || x<getWidth()-50){
                    xSpeed=-xSpeed;
                    }
                if(y>0 || y< getHeight() -50){
                    ySpeed=-ySpeed;
                }  
                x += xSpeed;
                y += ySpeed;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        MovingBall panel = new MovingBall();
        frame.add(panel);
        frame.setVisible(true);
    }
}
