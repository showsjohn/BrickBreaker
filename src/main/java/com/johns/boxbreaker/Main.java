package com.johns.boxbreaker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main implements ApplicationListener {
    Texture backgroundTexture;;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    GameObjectList gameObjectList;
    //Sound dropSound;
    //Music music;


    @Override
    public void create() {
        backgroundTexture = new Texture("./src/main/resources/sprites/background.png");
        SpriteGameObject bucket = new SpriteGameObject("./src/main/resources/sprites/bucket.png");
        SpriteGameObject drop = new SpriteGameObject("./src/main/resources/sprites/drop.png");
        gameObjectList = new GameObjectList();
        gameObjectList.Add(bucket);
        gameObjectList.Add(drop);

        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(16, 9);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }


    @Override
    public void render() {
        // organize code into three methods
        input();
        logic();
        draw();
    }

    private void input() {

    }

    private void logic() {

    }


    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        spriteBatch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight);
        gameObjectList.draw(spriteBatch);
        spriteBatch.end();
    }


    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}
}
