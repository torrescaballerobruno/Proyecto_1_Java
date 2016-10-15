import java.util.Random;
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
	public final String ataqueClase="Fuerza bruta";
	
	/**
	 *Constructor de la clase Totodile 
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

		if(!nombre.equals(""))
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
		if(estado.equals("ok") && !enemigo.estado.equals("Fuera de combate")){
				Random rnd = new Random();
			if(1 < ( (int)(rnd.nextDouble() * 5.0+1) ) ) {
				if ((damage = (this.ataque - enemigo.defensa)*1.3f*multiplicadorElemental(enemigo)) <= 0)
					damage = 0;

				if(!enemigo.estado.equals("Fuera de combate")){
					enemigo.recibirDaño((int)damage);
					System.out.println(this.apodo+" uso "+ataqueClase+". ¡"+enemigo.apodo+" pierde "+damage+" puntos de vida!");
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
