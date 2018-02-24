import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by cowlog on 18-2-24.
 * ExecutionGUI
 */
public class ExecutionGUI extends JFrame{
    public ExecutionGUI(){
        setLayout(new BorderLayout());
        add(new Draw(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        ExecutionGUI frame = new ExecutionGUI();
        frame.setSize(300, 300);
        frame.setTitle("刽子手");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);

    }
}

class Draw extends JPanel{
    public void drawFunction() {
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(15,245,60, 30);//底部半椭圆

        g.drawLine(45,245,45,20);//杆子
        g.drawLine(45,20,180,20);
        g.drawLine(180,20,180,50);

        g.drawOval(165, 50, 30, 30);//人头
        g.drawLine(180,80,180,130);//身体
        g.drawLine(180,130,150,160);//下肢左
        g.drawLine(180,130,210,160);//下肢右

        //上肢 左 右
        g.drawLine((int) (180-15*Math.sin(Math.PI/4)),(int) (80-15+15*Math.cos(Math.PI/4)),130,110);
        g.drawLine((int) (180+15*Math.sin(Math.PI/4)),(int) (80-15+15*Math.cos(Math.PI/4)),230,110);

    }
}
