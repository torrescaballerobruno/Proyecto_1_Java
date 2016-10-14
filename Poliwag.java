/**
 *Subclase Poliwag que es un monstruo especifico de tipo Agua
 *@author Bruno Torres
 */
public class Poliwag extends Agua{
	private final String nombreMonstruo="Poliwag";
	private final int hpBase=15;
	private final int ataqueBase=10;
	private final int defensaBase=10;
	private final int velocidadBase=10;
	public final String ataqueClase="Hidrochorro";
	
	/**
	 *Constructor de la clase Poliwag
	 *@param nombre String
	 *@param nivel int
	 */
	public Poliwag(String nombre, int nivel){
		
		this.nivel=nivel;
		this.estado="ok";
		this.ataque=nivel*ataqueBase;
		this.defensa=nivel*defensaBase;
		this.velocidad=nivel*velocidadBase;
		this.hp=nivel*hpBase;

		if(nombre !=null)
			this.apodo=nombre;
		else
			this.apodo=nombreMonstruo;
	}

	/**
	 *Método que calcula e inflinge daño a un enemigo.
	 *@param enemigo Monstruo
	 */
	@Override
	public void ataque2(Monstruo enemigo){
		float damage;
		
		if ((damage = (this.ataque - enemigo.defensa)*0.6f*multiplicadorElemental(enemigo)) <= 0)
			damage = 0;

		enemigo.hp -= damage;
		System.out.println(this.apodo+" uso Hidrochorro. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}