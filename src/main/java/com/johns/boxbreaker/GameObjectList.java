package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class GameObjectList implements GameLoopable {
    List<GameLoopable> objectList;

    public GameObjectList()
    {
        objectList = new ArrayList<>();
    }

    public void Add(GameLoopable obj)
    {
        objectList.add(obj);
    }

    public void Remove(GameLoopable obj)
    {
        objectList.remove(obj);
    }

    @Override
    public void input() {
        for (GameLoopable obj: objectList)
        {
            obj.input();
        }
    }

    @Override
    public void update() {
        for (GameLoopable obj: objectList)
        {
            obj.update();
        }
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        for (GameLoopable obj: objectList)
        {
            obj.draw(spriteBatch);
        }
    }
}
