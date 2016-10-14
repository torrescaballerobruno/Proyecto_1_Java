/**
 *Subclase Flaaffy que es un monstruo especifico de tipo Electrico
 *@author Bruno Torres
 */
public class Squirtle extends Agua{
	private final String nombreMonstruo="Squirtle";
	private final int hpBase=18;
	private final int ataqueBase=18;
	private final int defensaBase=12;
	private final int velocidadBase=15;
	public final String ataqueClase="Pistola agua";
	
	/**
	 *Constructor de la clase Pikachu 
	 *@param nombre String
	 *@param nivel int
	 */
	public Squirtle(String nombre, int nivel){
		
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
		
		if ((damage = (this.ataque - enemigo.defensa)*1.5f*multiplicadorElemental(enemigo)) <= 0)
			damage = 0;

		enemigo.hp -= damage;
		System.out.println(this.apodo+" uso pistola agua. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}