public class Ball {

    public Paddle man, ai, ball;
    private double vx = -150;
    private double vy = 150;

    Ball(Paddle man, Paddle ai, Paddle ball) {
        this.man = man;
        this.ai = ai;
        this.ball = ball;
    }

    public void update(double dt) {
        if (vx < 0) {
            if (this.ball.x <= this.man.x + this.man.width && this.ball.y >= this.man.y && this.ball.y <= this.man.y + this.man.height) {
                this.vx *= -1;
            }
        } else if (vx >= 0) {
            if (this.ball.x + this.ball.width >= this.ai.x && this.ball.y >= this.ai.y && this.ball.y <= this.ai.y + this.ai.height) {
                this.vx *= -1;
            }
        }

        if (vy >= 0) {
            if (this.ball.y + this.ball.height >= Const.SCREEN_HEIGHT - Const.INSET_BOTTOM) {
                this.vy *= -1;
            }
        } else if (vy < 0) {
            if (this.ball.y <= Const.INSET_TOP) {
                this.vy *= -1;
            }
        }


        if (this.ball.x == this.man.x + this.man.width + Const.HZ_PADDING) {
            if (this.ball.y < this.man.y && this.ball.y > this.man.y + this.man.height) {
                System.out.println("Missed");
            }
        }

        this.ball.x += vx*dt;
        this.ball.y += vy*dt;
    }

}
