package model.data_structures;

/** Clase que permite el almacenamiento de objetos genéricos en colas y filas
 *  Implementa los métodos necesarios para ambas estructuras de datos ()
 */
public class Nodo<T> 
{
	//Atributos

	/**
	 * objeto genérico almacenado por el nodo. 
	 */
	private T elemento;

	/**
	 * booleano que determina si el nodo ocupa la posición especial primero. 
	 */
	private boolean primero;

	/**
	 * booleano que determina si el nodo ocupa la posición especial último.
	 */
	private boolean ultimo;

	/**
	 * Relación de cola/pila en lista doblemente encadenada
	 */
	private Nodo<T> siguiente;
	
	/**
	 * Relación de cola/pila en lista doblemente encadenada
	 */
	private Nodo<T> anterior;

	//Método Constructor
	public Nodo (T pElemento, boolean pPrimero, boolean pUltimo)
	{
		//Para construir un nodo es necesario conocer el elemento de entrada, si es primero o ultimo.
		elemento= pElemento;
		primero = pPrimero;
		ultimo  = pUltimo;
		anterior = null; //El nodo siguiente no es contruido pero debe ser inmediatamente asignado
		siguiente = null; //El nodo siguiente no es contruido pero debe ser inmediatamente asignado
	}

	//Métodos del nodo

	/**
	 * método encargado de reasignar el nodo siguiente. 
	 */
	public void setSiguiente(Nodo<T> nuevoSiguiente)
	{
		siguiente =nuevoSiguiente;
	}
	
	/**
	 * método encargado de reasignar el nodo siguiente. 
	 */
	public void setAnterior(Nodo<T> nuevoAnterior)
	{
		siguiente =nuevoAnterior;
	}

	/**
	 * método que determina si este nodo es el primero. 
	 */
	public boolean esPrimero()
	{
		return primero;
	}

	/**
	 * método que retorna el siguiente nodo. 
	 */
	public Nodo<T> darSiguiente()
	{
		return siguiente;
	}
	
	/**
	 * método que retorna el siguiente nodo. 
	 */
	public Nodo<T> darAnterior()
	{
		return anterior;
	}

	/**
	 * método que retorna el siguiente nodo. 
	 */
	public void setPrimero(boolean pPrimero)
	{
		primero = pPrimero;
	}
	
	/**
	 * método que retorna el siguiente nodo. 
	 */
	public void setUltimo(boolean pUltimo)
	{
		ultimo = pUltimo;
	}

	/**
	 * método recursivo para enqueue un nuevo elemento. 
	 *@param  nuevoUltimo tiene inicializacion primero= false, ultimo =true
	 */
	public void enqueue(Nodo<T> nuevoUltimo)
	{
		if(ultimo)
		{
			nuevoUltimo.setSiguiente(siguiente); //el siguiente nodo al último es el primero, por lo tanto se añade inicialmente
			nuevoUltimo.setAnterior(this); //el nodo actual es el nuevo anterior al nuevo nodo
			siguiente.setAnterior(nuevoUltimo); //el nodo primero tiene como nuevo anterior el nuevo nodo
			setSiguiente(nuevoUltimo);
			ultimo = false; //se actualiza el estado del nodo
		}
		else
		{
			siguiente.enqueue(nuevoUltimo);
		}
	}

	/**
	 * método recursivo para dequeue un nuevo elemento. 
	 */
	public void dequeue()
	{
		
		if(siguiente.esPrimero())
		{
			siguiente.darSiguiente().setPrimero(true);//se actualiza el estado del segundo nodo a primero
			siguiente.setAnterior(anterior); //el anterior es el nuevo anterior del segundo nodo  
			anterior.setSiguiente(siguiente); //se elimina la relación del último con el antiguo primero.
		}
		else
		{
			siguiente.dequeue();
		}
	}




}
