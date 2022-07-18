package modelo;

import java.util.ArrayList;

public class Mano extends Mazo {

	public Mano() {
		this.cartas = new ArrayList<>();
	}
	
	public int valorMano() {
		int suma=0;
		for (Carta carta : cartas) {
			suma=suma+carta.getValor();			
		}
		return suma;
	}
	
	public int valorManoVisibles() {
		int suma=0;
		for (Carta carta : cartas) {
			if (carta.isVisible()) {
		}
			suma=suma+carta.getValor();			
		}
		return suma;
	}
	
	public void descubrir() {
		for (Carta carta : cartas) {
			carta.setVisible(true);
		}
	}
	
	public boolean finDeJuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
		
		// Podriamos ahorrarnos el if anterior con la siguiente sentencia.
		// return valorMano()>=21;
		
	}

	@Override
	public String toString() {
		return "Valor de la mano:" + valorMano() + "\n"+ super.toString();
	}
	
	public void pedirCarta(Mazo m) {
		if (!finDeJuego()) {
		Carta c = m.solicitarCarta();
		this.cartas.add(c);
		}
	}
		
		public void pedirCarta(Mazo m, boolean visible) {
			if (!finDeJuego()) {
				Carta c = m.solicitarCarta();
				c.setVisible(visible);
				this.cartas.add(c);
			}
		}
}
