/**
 *sub-clase de Pocima que simula una pocima que aumenta la Vida
 *@author Bruno Torres
 */
public class PocimaVida extends Pocima{

	/**
	 *Metodo que aumenta la Vida del monstruo en la que se usa la pocima
	 *@param mn Monstruo
	 */
	@Override
	public void usarPocima(Monstruo mn){
		Double tmp = (double)mn.hp;
		tmp = tmp * .20; 
		mn.recibirHp(tmp.intValue());
	}
}