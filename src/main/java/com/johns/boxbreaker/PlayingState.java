package com.johns.boxbreaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayingState extends GameState {
    Texture backgroundTexture;
    Texture gameOver;
    Ball ball;
    float ballLossTimeOut;
    boolean inCoolDown;
    int lives = 3;

    @Override
    public void create() {
        super.create();
        Gdx.input.setCursorCatched(true);
        backgroundTexture = new Texture(Gdx.files.internal("assets/sprites/background.jpg"));
        gameOver = new Texture(Gdx.files.internal("assets/sprites/gameover.png"));
        Paddle paddle = new Paddle("assets/sprites/paddles_and_balls.png");

        int factor = 6;

        for (int i = 0; i < Gdx.graphics.getWidth() / (32 *factor) /*width / size of bricks*/; i++) {
            Brick brick = new Brick("assets/sprites/bricks.png", COLOR.red);
            brick.setPosition(i*32*factor, 664);
            gameObjectList.Add(brick);
        }

        for (int i = 0; i < Gdx.graphics.getWidth() / (32 * factor) /*width / size of bricks*/; i++) {
            Brick brick = new Brick("assets/sprites/bricks.png", COLOR.purple);
            brick.setPosition(i*32*factor, 784);
            gameObjectList.Add(brick);
        }



        ball = new Ball("assets/sprites/paddles_and_balls.png");
        gameObjectList.Add(ball);
        gameObjectList.Add(paddle);


        // remains at bottom of method to ensure all contained objects are created
        gameObjectList.create();
    }

    @Override
    public void logic() {
        super.logic();
        if (ball.getPosition().y < 0 && !inCoolDown)
        {
            ballLossTimeOut = 3f;
            inCoolDown = true;
            lives-=1;
        }

        if(inCoolDown)
        {
            ballLossTimeOut -= ball.deltaTime;
            if(ballLossTimeOut <= 0)
            {
                ball.reset();
                inCoolDown = false;
            }
        }


    }

    public void draw(SpriteBatch spriteBatch)
    {
        super.draw(spriteBatch);
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        if(lives > 0)
        {
            spriteBatch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            gameObjectList.draw(spriteBatch);
        }
        else {
            spriteBatch.draw(gameOver, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        }

        spriteBatch.end();
    }


}
