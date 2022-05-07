package juego;

	import java.awt.*;

import entorno.Entorno;

public class Obstaculos 
	{
		double x;
		double y;
		double radio;
		Circulo obstaculo;
		
		public Obstaculos(double x,double y,double radio)
			{
				this.x = x;
				this.y = y;
				this.radio = radio;
				obstaculo = new Circulo(this.x,this.y,this.radio);
			}
		
		public void dibujarseEnPantalla (Entorno entorno)
		{
			Color color = new Color(255,0,255);
			entorno.dibujarCirculo(this.x, this.y, this.radio, color);
		}
		
	}
