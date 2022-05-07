package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	private Entorno entorno;
	private Pelota pelota;
	private Slider slider;
		
	public Juego() {
		entorno = new Entorno(this, "Juego - V0.01", 800, 600);
	
		pelota = new Pelota(50, 50, 1, Math.PI/4, 50);
		slider = new Slider(entorno.ancho()/2, entorno.alto() - 10, 200, 20, 2);
		
		entorno.iniciar();
	}

	public void tick() {
	

		pelota.dibujar(entorno);
		slider.dibujar(entorno);


		pelota.mover();
		
		if (pelota.chocasteCon(entorno)) {
			pelota.cambiarTrayectoria();
		}
		
		//TODO
		if (pelota.chocasteCon(slider)) {
			pelota.cambiarTrayectoria();
		}
		
		if (entorno.estaPresionada('s')) {
			pelota.acelerar();
		}
		
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			slider.moverIzquierda();
		}
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			slider.moverDerecha();
		}
		
				
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
