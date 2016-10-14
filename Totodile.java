/**
 *Subclase Totodile que es un monstruo especifico de tipo Agua
 *@author Bruno Torres
 */
public class Totodile extends Agua{
	private final String nombreMonstruo="Totodile";
	private final int hpBase=23;
	private final int ataqueBase=20;
	private final int defensaBase=12;
	private final int velocidadBase=12;
	public final String ataqueClase="Hidrobomba";
	
	/**
	 *Constructor de la clase Pikachu 
	 *@param nombre String
	 *@param nivel int
	 */
	public Totodile(String nombre, int nivel){
		
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
		
		if ((damage = (this.ataque - enemigo.defensa)*1.3f*multiplicadorElemental(enemigo)) <= 0)
			damage = 0;

		enemigo.hp -= damage;
		System.out.println(this.apodo+" uso Hidrobomba. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}