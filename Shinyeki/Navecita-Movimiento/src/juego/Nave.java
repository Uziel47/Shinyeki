package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Nave 
{
	// Variables de instancia
	double x;
	double y;
	double angulo;
	Image img1;
	Image img2;
	
	public Nave(int x, int y) 
	{
		this.x = x;
		this.y = y;
	
		img1 = Herramientas.cargarImagen("nave.png");
		img2 = Herramientas.cargarImagen("nave2.png");
	}
	
	public void dibujarse(Entorno entorno)
	{
//		entorno.dibujarTriangulo(this.x, this.y, 50, 30, this.angulo, Color.yellow);
	
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA))
			entorno.dibujarImagen(img1, this.x, this.y, this.angulo, 0.3);
		else
			entorno.dibujarImagen(img2, this.x, this.y, this.angulo, 0.3);
	}

	public void girar(double modificador) 
	{
		this.angulo = this.angulo + modificador;
	}
	
	public void moverAdelante() {
		this.x += Math.cos(this.angulo)*2;
		this.y += Math.sin(this.angulo)*2;
	}
}
