/**
 *Subclase Flaaffy que es un monstruo especifico de tipo Electrico
 *@author Bruno Torres
 */
public class Flaaffy extends Electrico{
	private final String nombreMonstruo="Flaaffy";
	private final int hpBase=20;
	private final int ataqueBase=15;
	private final int defensaBase=15;
	private final int velocidadBase=10;
	public final String ataqueClase="Derrivo";
	
	/**
	 *Constructor de la clase Pikachu 
	 *@param nombre String
	 *@param nivel int
	 */
	public Flaaffy(String nombre, int nivel){
		
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
		System.out.println(this.apodo+" uso Derrivo. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}