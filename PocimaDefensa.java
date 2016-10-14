/**
 *sub-clase de Pocima que simula una pocima que aumenta la defensa
 *@author Bruno Torres
 */
public class PocimaDefensa extends Pocima{

	/**
	 *Metodo que aumenta la Defensa del monstruo en la que se usa la pocima
	 *@param mn Monstruo
	 */
	@Override
	public void usarPocima(Monstruo mn){
		mn.recibirDefensa(mn.getDefensa()*.15f);
	}
}