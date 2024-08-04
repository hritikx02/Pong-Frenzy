import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    public Graphics2D g2;
    public Keylistener keyListener = new Keylistener();
    public Paddle playerOne, ai, ball;
    public Manual manual;
    public Ball b1;
    public AI aiCon;

    public Window() {

        this.setSize(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle(Const.SCREEN_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Insets top = getInsets();
        Const.INSET_TOP = this.getInsets().top;
        Const.INSET_BOTTOM = this.getInsets().bottom;

        g2 = (Graphics2D) this.getGraphics();
        this.addKeyListener(keyListener);

        playerOne = new Paddle(Const.HZ_PADDING, Const.VT_PADDING, Const.PADDLE_WIDTH, Const.PADDLE_HEIGHT, Const.PADDLE_COLOR_P1);
        ai = new Paddle(Const.SCREEN_WIDTH-Const.HZ_PADDING-Const.PADDLE_WIDTH, Const.VT_PADDING, Const.PADDLE_WIDTH, Const.PADDLE_HEIGHT, Const.PADDLE_COLOR_AI);
        ball = new Paddle(Const.SCREEN_WIDTH/2 - Const.BALL_RADIUS/2,Const.SCREEN_HEIGHT/2 - Const.BALL_RADIUS/2, Const.BALL_RADIUS,Const.BALL_RADIUS, Const.BALL_COLOR);

        manual = new Manual(playerOne, keyListener);
        b1 = new Ball(playerOne, ai, ball);
        aiCon = new AI(new Manual(ai), ball);
    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage, 0, 0, this);

        manual.update(dt);
        aiCon.update(dt);
        b1.update(dt);

//        System.out.println(Const.INSET_BOTTOM + "    " + Const.INSET_TOP);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        g2.setColor(Color.WHITE);
        g2.drawLine(Const.SCREEN_WIDTH/2, 0, Const.SCREEN_WIDTH/2, Const.SCREEN_HEIGHT);

        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);
    }

    @Override
    public void run() {
        double lastFrameTime=0;
        while(true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                //
            }
        }
    }
}
