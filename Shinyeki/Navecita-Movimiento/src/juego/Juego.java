package juego;

import java.awt.Color;

import entorno.*;


public class Juego extends InterfaceJuego
{
	private Entorno entorno;
	// otras variables del juego aqui
	Nave nave;
	
	Juego()
	{
		// Inicializa el objeto entorno, pero aun no lo inicia.
		entorno = new Entorno(this, "Navecitas - Versión 0.01", 800, 600);
		nave = new Nave(100, 100);
		
		
		/* 
		 * Es fundamental que recién al final del constructor de la clase Juego se 
		 * inicie el objeto entorno de la siguiente manera.
		 */
		entorno.iniciar();
	}

	/*
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		if (entorno.estaPresionada(entorno.TECLA_DERECHA))
			nave.girar(Herramientas.radianes(1));

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
			nave.girar(Herramientas.radianes(-1));

		if (entorno.estaPresionada(entorno.TECLA_ARRIBA))
			nave.moverAdelante();
		
		nave.dibujarse(entorno);

		entorno.cambiarFont("Arial", 18, Color.white);
		entorno.escribirTexto("El angulo es: " + nave.angulo, 500, 100);
		entorno.escribirTexto("posicion en x:" + nave.x, 500, 150);
		entorno.escribirTexto("posicion en y:" + nave.y, 500, 200);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{		
		Juego juego = new Juego();
	}
}
