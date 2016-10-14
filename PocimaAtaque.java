/**
 *sub-clase de Pocima que simula una pocima que aumenta el Ataque
 *@author Bruno Torres
 */
public class PocimaAtaque extends Pocima{

	/**
	 *Metodo que aumenta el Ataque del monstruo en la que se usa la pocima
	 *@param mn Monstruo
	 */
	@Override
	public void usarPocima(Monstruo mn){
		mn.recibirAtaque(mn.getAtaque()*.10f);
	}
}