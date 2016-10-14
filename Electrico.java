/**
* @author: Davacas
* Clase que contiene un método abstracto de ataque y uno que calcula un multiplicador elemental.
*/
public abstract class Electrico extends Monstruo{
	/**
	* Método que calcula el daño elemental de acuerdo al enemigo que sea vaya a atacar.
	* @param elemento Objeto de la clase "Monstruo" que representa al enemigo que se atacará.
	*/
	public float multiplicadorElemental(Monstruo elemento){
		if (elemento instanceof Agua)
			return 2.0f;
		else if (elemento instanceof Hierba || elemento instanceof Electrico)
			return 0.5f;
		else if (elemento instanceof Fuego)
			return 1.0f;
		return 0.0f; //Para que no chille el compilador.
	}
	/**
	* Método que calcula e inflinge daño a un enemigo.
	* @param enemigo Objeto de la clase "Monstruo" que representa al enemigo que se atacará.
	*/
	@Override
	public void ataque1(Monstruo enemigo){
		float damage;
		
		if ((damage = (this.ataque - enemigo.defensa)*multiplicadorElemental(enemigo)) <= 0)
			damage = 0;

		enemigo.hp -= damage;
		System.out.println("¡"+enemigo.apodo+" pierde "+damage+" puntos de vida por el ataque de "+this.apodo+"!");
	}
}