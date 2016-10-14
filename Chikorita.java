/**
 *Subclase Chikorita que es un monstruo especifico de tipo Hierba
 *@author Bruno Torres
 */
public class Chikorita extends Hierba{
	private final String nombreMonstruo="Chikorita";
	private final int hpBase=23;
	private final int ataqueBase=18;
	private final int defensaBase=16;
	private final int velocidadBase=20;
	public final String ataqueClase="Placaje";
	
	/**
	 *Constructor de la clase Chikorita
	 *@param nombre String
	 *@param nivel int
	 */
	public Chikorita(String nombre, int nivel){
		
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
		
		if ((damage = (this.ataque - enemigo.defensa)*1.2f*multiplicadorElemental(enemigo)) <= 0)
			damage = 0;

		enemigo.hp -= damage;
		System.out.println(this.apodo+" uso placaje. ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
	}
}