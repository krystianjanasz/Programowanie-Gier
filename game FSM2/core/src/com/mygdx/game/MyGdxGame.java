package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	public Player player;
	public Guard guard;

	Texture playerRec;
	Texture guardRec;

	@Override
	public void create () {
		batch = new SpriteBatch();
		playerRec= new Texture("player2.png");
		guardRec= new Texture("guard2.png");
		player=new Player(playerRec);

		guard=new Guard(guardRec);
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor( 0, (float) 0.95, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(player.getTexture(), player.x, player.y);
		batch.draw(guard.getTexture(), guard.x, guard.y);
		batch.end();
	}

	private void update(){
		player.update(Gdx.graphics.getDeltaTime());
		guard.update(Gdx.graphics.getDeltaTime(),player.x,player.y);

		if(player.intersects(guard))
		{
			System.out.println("Kolizja!");
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
