package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayingState extends GameState {
    Texture backgroundTexture;

    @Override
    public void create() {
        super.create();
        backgroundTexture = new Texture("./src/main/resources/sprites/background.png");
        Paddle paddle = new Paddle("./src/main/resources/sprites/paddles_and_balls.png");

        for (int i = 0; i < 20; i++) {
            Brick brick = new Brick("./src/main/resources/sprites/bricks.png", COLOR.green);

            brick.setPosition(i*32*4, 400);

            gameObjectList.Add(brick);


        }

        for (int i = 0; i < 20; i++) {
            Brick brick = new Brick("./src/main/resources/sprites/bricks.png", COLOR.red);
            brick.setPosition(i*32*4, 16*4 + 400);

            gameObjectList.Add(brick);

        }
        gameObjectList.Add(paddle);
        for (int i = 0; i < 3; i++) {
            Ball ball = new Ball("./src/main/resources/sprites/paddles_and_balls.png");
            gameObjectList.Add(ball);

        }

        // remains at bottom of method to ensure all contained objects are created
        gameObjectList.create();
    }


    public void draw(SpriteBatch spriteBatch)
    {
        super.draw(spriteBatch);
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        gameObjectList.draw(spriteBatch);
        spriteBatch.end();
    }


}
