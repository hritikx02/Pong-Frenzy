import java.awt.event.KeyEvent;

public class Manual {

    public Paddle paddle;
    public Keylistener kl;

    Manual(Paddle paddle, Keylistener kl) {
        this.paddle = paddle;
        this.kl = kl;
    }

    Manual(Paddle paddle) {
        this.paddle = paddle;
        this.kl = null;
    }

    public void update(double dt) {
        if(kl!=null) {
            if(kl.isKeyPressed(KeyEvent.VK_DOWN))
                moveDown(dt);
            else if(kl.isKeyPressed(KeyEvent.VK_UP))
                moveUp(dt);
        }
    }

    public void moveDown(double dt) {
        int paddlePosition = paddle.y + (int)(Const.PADDLE_SPEED * dt);
        int maxY = Const.SCREEN_HEIGHT - paddle.height - Const.INSET_BOTTOM;

        if (paddlePosition <= maxY) {
            paddle.y = paddlePosition;
        }
    }

    public void moveUp(double dt) {
        int paddlePosition = paddle.y - (int)(Const.PADDLE_SPEED * dt);
        int minY = Const.INSET_TOP;

        if (paddlePosition >= minY) {
            paddle.y = paddlePosition;
        }
    }

}
