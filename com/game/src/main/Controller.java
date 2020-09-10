package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Controller 
{
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	private LinkedList<Enemy> e = new LinkedList<Enemy>();
	
	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();
	
	Random r = new Random();
	EntityA enta;
	EntityB entb;
	Bullet TempBullet;
	Enemy TempEnemy;
	private Game game;
	Textures tex;
	
	public Controller(Textures tex, Game game)
	{
		this.tex = tex;
		this.game = game;
	}

	public void createEnemy(int enemy_count)
	{
		for(int i = 0; i< enemy_count; i++)
		{
			addEntity(new Enemy(r.nextInt(640), -10, tex, this, game));
		}
	}
	
	public void tick()
	{
		for(int i = 0; i < ea.size(); i++)
		{
			enta = ea.get(i);
			
			enta.tick();
		}
		
		for(int i = 0; i < eb.size(); i++)
		{
			entb = eb.get(i);
			
			entb.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < ea.size(); i++)
		{
			enta = ea.get(i);
			
			enta.render(g);
		}
		
		for(int i = 0; i < eb.size(); i++)
		{
			entb = eb.get(i);
			
			entb.render(g);
		}
	}
	
	public void addEntity(EntityA block)
	{
		ea.add(block);
	}
	
	public void removeEntity(EntityA block)
	{
		ea.remove(block); 
	} 
	
	public void addEntity(EntityB block)
	{
		eb.add(block);
	}
	
	public void removeEntity(EntityB block)
	{
		eb.remove(block);
	}
	
	public LinkedList<EntityA> getEa() {
		return ea;
	}

	public LinkedList<EntityB> getEb() {
		return eb;
	}
}
