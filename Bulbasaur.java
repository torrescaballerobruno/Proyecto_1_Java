/**
 *Subclase Bulbasaur que es un monstruo especifico de tipo Hierba
 *@author Bruno Torres
 */
public class Bulbasaur extends Hierba{
	private final String nombreMonstruo="Bulbasaur";
	private final int hpBase=23;
	private final int ataqueBase=18;
	private final int defensaBase=16;
	private final int velocidadBase=20;
	public final String ataqueClase="Polvo veneno";
	
	/**
	 *Constructor de la clase Bulbasaur
	 *@param nombre String
	 *@param nivel int
	 */
	public Bulbasaur(String nombre, int nivel){
		
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
		
		System.out.println(this.apodo+" uso polvo veneno. ¡"+enemigo.apodo+" queda paralizado !");
		enemigo.estado="paralizado";
	}
}