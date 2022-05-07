package juego;

import java.awt.Color;

import entorno.Entorno;

public class Slider {
	
	private double x;
	private double y;
	private int ancho;
	private int alto;
	
	private double factorDesplazamiento;
	
	public Slider(double x, double y, int ancho, int alto, double f) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.factorDesplazamiento = f;
	}
	
	public void dibujar(Entorno e) {
		e.dibujarRectangulo(x, y, ancho, alto, 0, Color.WHITE);
	}
	
	public void moverIzquierda() {
		x -= factorDesplazamiento;
	}
	
	public void moverDerecha() {
		x += factorDesplazamiento;
	}
	

}
