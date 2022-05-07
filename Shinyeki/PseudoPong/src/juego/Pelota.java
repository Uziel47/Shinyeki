package juego;

import java.awt.Color;

import entorno.Entorno;

public class Pelota {
	
	private double x;
	private double y;
	private double velocidad;
	private double angulo;
	private int radio;
	
	public Pelota(double x, double y, double velocidad, double angulo, int radio) {
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.angulo = angulo;
		this.radio = radio;
	}

	public void mover() {
		y += velocidad * Math.sin(angulo);
		x += velocidad * Math.cos(angulo);
	}
	
	//FIXME
	public boolean chocasteCon(Entorno e) {
		return x <= radio || y <= radio || x >= e.ancho() - radio || y >= e.alto() - radio;		
	}
	
	public void cambiarTrayectoria() {
		angulo += Math.PI/2;
	}
	
	public void acelerar() {
		velocidad += 0.05;
	}
	
	public void dibujar(Entorno e) {
		e.dibujarCirculo(x, y, 2 * radio, Color.CYAN);
	}

	// FIXME
	public boolean chocasteCon(Slider slider) {
		return false;
	}

}
