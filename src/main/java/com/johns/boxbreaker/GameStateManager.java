package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Dictionary;
import java.util.Hashtable;

public class GameStateManager implements GameLoopable
{
    GameState currentState;
    Dictionary<String, GameState> gameStates;

    public GameStateManager()
    {
        gameStates = new Hashtable<>();
        currentState = null;
    }

    public void AddGameState(String gameStateName, GameState gameState)
    {
        gameStates.put(gameStateName, gameState);
    }

    public GameState GetGameState(String gameStateName)
    {
        if(gameStates.get(gameStateName) != null)
        {
            return gameStates.get(gameStateName);
        }

        return null;
    }

    public void SwitchTo(String gameStateName)
    {
        currentState = GetGameState(gameStateName);
    }



    public void create()
    {
        currentState.create();
    }


    public void resize(int width, int height) {
        currentState.resize(width, height);
    }


    public void input()
    {
        currentState.input();
    }


    public void logic()
    {
        currentState.logic();
    }


    public void draw(SpriteBatch spriteBatch)
    {
        currentState.draw(spriteBatch);
    }

}
