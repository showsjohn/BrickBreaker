package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteGameObject extends Sprite implements GameLoopable
{
    public SpriteGameObject(String path)
    {
        super.setRegion(new Texture(path));
        super.setSize(1,1);
    }

    @Override
    public void input() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
    }

}
