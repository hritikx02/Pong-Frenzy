public class AI {

    public Manual man;
    public Paddle ball;

    AI(Manual man, Paddle ball) {
        this.man = man;
        this.ball = ball;
    }

    public void update(double dt) {
        man.update(dt);
        if(ball.y<man.paddle.y)
            man.moveUp(dt);
        else if (ball.y+ball.height > man.paddle.y+man.paddle.height) {
            man.moveDown(dt);
        }
    }

}
