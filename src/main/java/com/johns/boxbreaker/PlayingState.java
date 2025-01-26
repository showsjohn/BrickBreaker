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
        gameObjectList.Add(paddle);

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
        //spriteBatch.draw(backgroundTexture, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
        gameObjectList.draw(spriteBatch);
        spriteBatch.end();
    }


}
