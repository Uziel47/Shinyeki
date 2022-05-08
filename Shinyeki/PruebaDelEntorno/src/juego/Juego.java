package juego;


import java.awt.*;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	double x;
	double y;
	double alto;
	double ancho;
	Geometria geo;
	Obstaculos objeto1;
	Obstaculos objeto2;
	Obstaculos objeto3;
	Obstaculos objeto4;
	
	public Juego() {
		// Inicializa el objeto entorno
		this.ancho = 1000;
		this.alto = 700;
		this.x = 0;
		this.y = 0;
		
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo N - Apellido1 - Apellido2 -Apellido3 - V0.01",1000,700);
		
		// Inicializar lo que haga falta para el juego
		// ...
		
		/////////////////Objetos en el juego/////////////////////
		objeto1 = new Obstaculos(200,200,50);
		objeto2 = new Obstaculos(800,200,50);
		objeto3 = new Obstaculos(200,500,50);
		objeto4 = new Obstaculos(800,500,50);
		////////////////////////////////////////////////////////
		
		////////////////////Mikasa///////////////////////////////
		geo = new Geometria(this.x,this.y,this.ancho,this.alto);
		////////////////////////////////////////////////////////

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() 
		{
			// Procesamiento de un instante de tiempo
			// ...
		
		///////////Colisiones con los obstaculos del juego/////////////////
		geo.colisionObstaculo(objeto1);
		geo.colisionObstaculo(objeto2);
		geo.colisionObstaculo(objeto3);
		geo.colisionObstaculo(objeto4);
		//////////////////////////////////////////////////////////////////
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA))
			geo.girar(Math.PI/180);  //radianes
			geo.chocaConAncho(this.ancho);


			
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
			geo.girar(Math.PI/180*(-1)); //radianes 
			geo.chocaConXnegativo(this.x);

			
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA))
			geo.moverAdelante();
			geo.chocaConYnegativo(this.y);

			
		if(entorno.estaPresionada(entorno.TECLA_ABAJO))
			geo.moverAtras();
			geo.chocaConAlto(this.alto);

		
		entorno.cambiarFont("Arial", 18, Color.white);
		//entorno.escribirTexto("angulo: " + geo.angulo, 500, 100);
		entorno.escribirTexto("coordenada x: " +geo.circulo.x, 500, 100);
		entorno.escribirTexto("coordenada y: " +geo.circulo.y, 500, 150);
		
		
		///////////cosas en la ventana actualizandose constantemente//////////////////
		geo.dibujarseEnPantalla(entorno);
		objeto1.dibujarseEnPantalla(entorno);
		objeto2.dibujarseEnPantalla(entorno);
		objeto3.dibujarseEnPantalla(entorno);
		objeto4.dibujarseEnPantalla(entorno);
		}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
