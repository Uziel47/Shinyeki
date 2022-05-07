package juego;

import java.awt.*;

import entorno.Entorno;

public class Geometria {
	
	double x;
	double y;
	double ancho;
	double alto;
	double angulo;
	double radio;
	Circulo circulo;
	
	
	public Geometria(double x,double y,double w,double h)
		{
			this.x = x;
			this.y = y;
			this.ancho = w;
			this.alto = h;
			double radio = 50;
			Point c = centroPantalla();
			circulo = new Circulo(c.x,c.y,radio);
		}

	public Point centroPantalla()
		{
			Point centro;
					
			centro = new Point();
			centro.x = (int) (this.x + this.ancho/2);
			centro.y = (int) (this.y + this.alto/2);
			//System.out.println(centro.x +","+centro.y);
			
			return centro;
		}
	
	public void dibujarseEnPantalla (Entorno entorno)
		{
			Color colorMikasa = new Color(255,255,255);
			Color direccionamiento = new Color (0,255,0);
			
			entorno.dibujarCirculo(circulo.x,circulo.y,50, colorMikasa);		
			entorno.dibujarTriangulo(this.circulo.x,this.circulo.y - this.radio,50,20,this.angulo,direccionamiento);
		}
	
	public void girar(double modificador) 
		{
			this.angulo = this.angulo + modificador;
		}
	
	public void moverAdelante() 
		{
			this.circulo.x += Math.cos(this.angulo)*4;
			this.circulo.y += Math.sin(this.angulo)*4;
		}
			

	public void moverAtras()
		{
			this.circulo.x += Math.cos(this.angulo)*(-4);
			this.circulo.y += Math.sin(this.angulo)*(-4);
			
		}
	
	public void chocaConAncho (double ancho)
		{
			if (this.circulo.x >= ancho)
				{
					double resultado =this.circulo.x - this.ancho;
					this.circulo.x = this.circulo.x - resultado;
				}
		}
	
	public void chocaConAlto (double alto)
		{
			if(this.circulo.y >= alto)
				{
					double resultado = this.circulo.y - this.alto;
					this.circulo.y = this.circulo.y - resultado;
				}
		}
	
	public void chocaConXnegativo (double x)
	{
		if(this.circulo.x <= x)
			{
				double resultado = this.circulo.x  - this.x;
				this.circulo.x = this.circulo.x - resultado;
			}
	}
	
	public void chocaConYnegativo (double y)
	{
		if(this.circulo.y <= y)
			{
				double resultado = this.circulo.y - this.y;
				this.circulo.y = this.circulo.y - resultado;
			}
	}
	
	public void colisionObstaculo(Obstaculos e)
		{
			Point p1 = new Point();        //puntos x,y de mikasa.
			Point p2 = new Point();			//puntos x,y de algún objeto.
			
			p2.x = (int) this.circulo.x;    //como siempre usamos las x e y
			p2.y = (int) this.circulo.y;    //del circulo de mikasa.
			
			p1.x = (int) e.x;
			p1.y = (int) e.y;
						
			double a = p2.x - p1.x;
			double b = p2.y - p1.y;
			double absoluto = Math.sqrt(a*a + b*b); //se calcula la distancia haciendo el absoluto de los dos puntos.
			
			if(absoluto < this.circulo.radio + e.radio )
				{
					double resultado = (this.circulo.radio + e.radio) - absoluto;
					resultado = resultado/2;
					this.circulo.x = this.circulo.x - resultado;
					this.circulo.y = this.circulo.y - resultado;
					//System.out.println("SE ESTÁN TOCANDO");
				}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
