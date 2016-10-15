import java.util.Random;
/**
* @author: Davacas
* Clase que contiene un método abstracto de ataque y uno que calcula un multiplicador elemental.
*/
public abstract class Electrico extends Monstruo{
	public final String ataqueElemento="Impactrueno";
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
		
		if(estado.equals("ok") && !enemigo.estado.equals("Fuera de combate")){
				Random rnd = new Random();
			if(1 < ( (int)(rnd.nextDouble() * 5.0+1) ) ) {
				if ((damage = (this.ataque - enemigo.defensa)*multiplicadorElemental(enemigo)) <= 0)
					damage = 0;

				if(!enemigo.estado.equals("Fuera de combate")){
					enemigo.recibirDaño((int)damage);
					System.out.println(this.apodo+" uso "+ataqueElemento+". ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
				}else
					System.out.println("El enemigo esta muerto :v");
			}else{
				System.out.println(this.apodo+" fallo en su ataque.");
			}
		}else if(estado.equals("paralizado")){
			contParalizado++;
			if(contParalizado==2){
				estado="ok";
				contParalizado=0;
			}
		}else if (estado.equals("Fuera de combate")){
			System.out.println(this.apodo+" no puede continuar");
		}
	}
}