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
    public void create()
    {
        for (GameLoopable obj: objectList)
        {
            obj.create();
        }
    }

    @Override
    public void input() {
        for (GameLoopable obj: objectList)
        {
            obj.input();
        }
    }

    @Override
    public void logic() {
        for (GameLoopable obj: objectList)
        {
            obj.logic();
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
