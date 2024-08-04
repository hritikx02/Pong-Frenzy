import java.awt.*;

public class Paddle {

    int x, y, width, height;
    Color color;

    Paddle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 15, 15);
    }


    // useless since it won't override in window update draw method
    public void drawBall(Graphics2D g2) {
        g2.setColor(Const.BALL_COLOR);
        g2.fillOval(Const.SCREEN_WIDTH/2 - Const.BALL_RADIUS/2,Const.SCREEN_HEIGHT/2 - Const.BALL_RADIUS/2, Const.BALL_RADIUS,Const.BALL_RADIUS);
    }
}
