/**
 *Subclase Charmander que es un monstruo especifico de tipo Electrico
 *@author Bruno Torres
 */
public class Charmander extends Fuego{
	private final String nombreMonstruo="Charmander";
	private final int hpBase=21;
	private final int ataqueBase=16;
	private final int defensaBase=13;
	private final int velocidadBase=11;
	public final String ataqueClase="Lanzallamas";
	
	/**
	 *Constructor de la clase Charmander
	 *@param nombre String
	 *@param nivel int
	 */
	public Charmander(String nombre, int nivel){
		
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
		System.out.println(this.apodo+" uso lanzallamas. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}