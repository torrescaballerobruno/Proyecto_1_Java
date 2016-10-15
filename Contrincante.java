import java.util.ArrayList; 
import java.util.Scanner;

/**
*@author Davacas
* Clase que almacena los datos de un contrincante y sus métodos.
*/
public class Contrincante{
	ArrayList <Monstruo> monstruo = new ArrayList <Monstruo>();
	ArrayList <Pocima> pocima = new ArrayList <Pocima>();
	Scanner sc = new Scanner(System.in);
	String nombre;
	Monstruo monstruo_actual;
	int pocimasVida = 2;
	int pocimasAtaque = 2;
	int pocimasDefensa = 2;
	int derrotados = 0;

	/**
	*Método que permite sacar un monstruo de la batalla.
	*/
	public void guardarMonstruo(){
		if (monstruo_actual.estado.equals("Fuera de combate"))
			monstruo_actual.estado = ("Fuera de combate");
		else
			monstruo_actual.estado = "ok";
		System.out.println(monstruo_actual.apodo+" ya no está en la pelea. Tienes estos monstruos:");
		listarMonstruo();
		System.out.print("¿A quién quieres meter en la pelea? Escribe su número de acuerdo a la lista: ");
		elegirMonstruo();
			
	}

	/**
	*Método que permite elegir un monstruo en plena batalla. Se manda a llamar automáticamente bajo circunstancias específicas.
	*/
	public void elegirMonstruo(){	
		int id;
		Scanner sc = new Scanner(System.in);	
		Monstruo m;

		while (true)
		{
			id = sc.nextInt();			
			m = monstruo.get(id-1);
			if (m.estado.equals("Fuera de combate"))
			{
				System.out.println("No puedes llamar a "+m.apodo+" a la pelea porque está fuera de combate.");
				System.out.print("Intenta con otro monstruo: ");
			}
			else
			{
				monstruo_actual = m;
				System.out.println("¡"+monstruo_actual.apodo+" entra al combate!");
				return;
			}
			
		}
	}

	/**
	*Método que permite usar una pócima sobre el monstruo con el que actualmente se está peleando.
	*/
	public void usarPocima(){
		
		Pocima p;
		int opc;
		System.out.println("¿Qué tipo de pócima deseas utilizar?");
		System.out.println("1) +Vida "+pocimasVida+"/2");
		System.out.println("2) +Ataque "+pocimasAtaque+"/2");
		System.out.println("3) +Defensa "+pocimasDefensa+"/2");

		opc = sc.nextInt();
		switch (opc)
		{
			case 1:
				for (int i = 0; i < pocima.size(); i ++)
				{
					p = pocima.get(i);
					if (p instanceof PocimaVida)
					{
						p.usarPocima(monstruo_actual);
						pocima.remove(i);
						pocimasVida -= 1;
						return;
					}
					else
						System.out.println("nope");
				}
				System.out.println("¡Ya no tienes pócimas de vida! Pierdes tu turno.");
				return;

			case 2:
				for (int i = 0; i < pocima.size(); i ++)
				{
					p = pocima.get(i);
					if (p instanceof PocimaAtaque)
					{
						p.usarPocima(monstruo_actual);						
						pocima.remove(i);
						pocimasAtaque -= 1;
						return;
					}
				}
				System.out.println("¡Ya no tienes pócimas de ataque! Pierdes tu turno.");
				return;

			case 3:
				for (int i = 0; i < pocima.size(); i ++)
				{
					p = pocima.get(i);
					if (p instanceof PocimaDefensa)
					{
						p.usarPocima(monstruo_actual);
						pocima.remove(i);
						pocimasDefensa -= 1;
						return;
					}
				}
				System.out.println("¡Ya no tienes pócimas de defensa! Pierdes tu turno.");
				return;
		}
	}

	/**
	*Método que permite listar todos los monstruos disponibles en el equipo.
	*/
	public void listarMonstruo(){
		Monstruo m;

		System.out.println("# | Nombre | Nivel | HP | Estado");
		for (int i = 0; i < monstruo.size(); i ++)
		{
			m = monstruo.get(i);
			System.out.println((i+1)+" | "+m.apodo+" | "+m.nivel+" | "+m.hp+" | "+m.estado);
		}
	}
}