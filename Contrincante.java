import java.util.ArrayList; 
import java.util.Scanner;

/**
*@author Davacas
* Clase que almacena los datos de un contrincante y sus métodos.
*/
public class Contrincante{
	ArrayList <Monstruo> monstruo = new ArrayList<Monstruo>();
	ArrayList <Pocima> pocima = new ArrayList<Pocima>();
	Scanner sc = new Scanner(System.in);
	String nombre;
	Monstruo monstruo_actual;

	/**
	*Método que permite sacar un monstruo de la batalla.
	*/
	public void guardarMonstruo(){
		monstruo_actual.estado = "ok";
		System.out.println(monstruo_actual+" ya no está en la pelea. Tienes estos monstruos:");
		listarMonstruo();
		System.out.print("¿A quién quieres meter en la pelea? Escribe su nombre: ");
		elegirMonstruo();		
	}

	/**
	*Método que permite elegir un monstruo en plena batalla. Se manda a llamar automáticamente bajo circunstancias específicas.
	*/
	public void elegirMonstruo(){	
		String apodo;
		Scanner sc = new Scanner(System.in);	
		Monstruo m;

		while (true)
		{
			apodo = sc.nextLine();			
			for (int i = 0; i < monstruo.size(); i ++)
			{
				m = monstruo.get(i);
				if (m.apodo.equals(apodo) && !(m.estado.equals("Fuera de combate")))
				{
					monstruo_actual = m;
					monstruo_actual.apodo = "En combate.";
					System.out.println("¡"+apodo+" entra al combate!");
					return;
				}
			}
			System.out.println("No puedes llamar a "+apodo+" a la pelea. (Tal vez está fuera de combate o no existe)");
			System.out.print("Intenta con el nombre de otro monstruo: ");
		}
	}

	/**
	*Método que permite usar una pócima sobre el monstruo con el que actualmente se está peleando.
	*/
	public void usarPocima(){
		int pocimasVida = 2;
		int pocimasAtaque = 2;
		int pocimasDefensa = 2;
		Pocima p;
		int opc;
		System.out.println("¿Qué tipo de pócima deseas utilizar?");
		System.out.println("1) +Vida "+pocimasVida+"/2");
		System.out.println("2) +Ataque"+pocimasAtaque+"/2");
		System.out.println("3) +Defensa"+pocimasDefensa+"/2");

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

		System.out.println("| Nombre | Nivel | HP | Estado\n");
		for (int i = 0; i < monstruo.size(); i ++)
		{
			m = monstruo.get(i);
			System.out.println(m.apodo+" | "+m.nivel+" | "+m.hp+" | "+m.estado);
		}
	}
}