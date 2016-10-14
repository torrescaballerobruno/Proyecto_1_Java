/**
 *Subclase Jolteon que es un monstruo especifico de tipo Electrico
 *@author Bruno Torres
 */
public class Jolteon extends Electrico{
	private final String nombreMonstruo="Jolteon";
	private final int hpBase=22;
	private final int ataqueBase=18;
	private final int defensaBase=17;
	private final int velocidadBase=20;
	public final String ataqueClase="Colmillo rayo";
	
	/**
	 *Constructor de la clase Pikachu 
	 *@param nombre String
	 *@param nivel int
	 */
	public Jolteon(String nombre, int nivel){
		
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
		System.out.println(this.apodo+" uso colmillo rayo. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}