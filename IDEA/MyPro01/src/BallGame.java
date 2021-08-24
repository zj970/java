import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
    Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("image/desk.jpg");

    //画窗口的方法  会有懒加载问题
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, 100, 100, null);

    }

    //窗口加载
    void LaunchFrame() {
        setSize(300, 500);
        setLocation(50, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        BallGame game = new BallGame();
        game.LaunchFrame();
        //game.Paint();
    }

}
