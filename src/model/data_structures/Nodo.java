package model.data_structures;

/** Clase que permite el almacenamiento de objetos gen�ricos en colas y filas
 *  Implementa los m�todos necesarios para ambas estructuras de datos
 */
public class Nodo<T> 
{
	//Atributos

	/**
	 * objeto gen�rico almacenado por el nodo. 
	 */
	private T elemento;
	
	/**
	 * booleano que determina si el nodo ocupa la posici�n especial primero. 
	 */
	private boolean primero;
	
	/**
	 * booleano que determina si el nodo ocupa la posici�n especial �ltimo.
	 */
	private boolean ultimo;
	
	/**
	 * Relaci�n de cola/pila en lista sencillamente encadenada
	 */
	private Nodo<T> siguiente;

	//M�todo Constructor
	public Nodo<T> (T pElemento, boolean pPrimero, boolean pUltimo)
	{
	 //Para construir un nodo es necesario conocer el elemento de entrada, si es primero o ultimo.
	 elemento= pElemento;
	 primero = pPrimero;
	 ultimo  = pUltimo;
	 siguiente = null; //El nodo siguiente no es contruido pero debe ser inmediatamente asignado
	}

	//M�todos del nodo

	/**
	 * m�todo encargado de reasignar el nodo siguiente. 
	 */
	public void setSiguiente(Nodo<T> nuevoSiguiente)
	{
	 siguiente =nuevoSiguiente;
	}

	/**
	 * m�todo que determina si este nodo es el primero. 
	 */
	public boolean esPrimero()
	{
	 return primero;
	}

	/**
	 * m�todo que retorna el siguiente nodo. 
	 */
	public boolean darSiguiente()
	{
	 return siguiente;
	}

	/**
	 * m�todo que retorna el siguiente nodo. 
	 */
	public void setPrimero(boolean pPrimero)
	{
	  primero = pPrimero;
	}

	/**
	 * m�todo recursivo para enqueue un nuevo elemento. 
	 *@param  nuevoUltimo tiene inicializacion primero= false, ultimo =true
	 */
	public void enqueue(Nodo<T> nuevoUltimo)
	{
	 if(ultimo)
	 {
	  nuevoUltimo.setSiguiente(siguiente); //el siguiente nodo al �ltimo es el primero, por lo tanto se a�ade inicialmente
	  setSiguiente(nuevoUltimo);
	  ultimo = false; //se actualiza el estado del nodo
	 }
	 else
	 {
	  siguiente.enqueue(nuevoUltimo);
	 }
	}

	/**
	 * m�todo recursivo para dequeue un nuevo elemento. 
	 */
	public void dequeue()
	{
		// ESTE METODO TIENE ORDEN N DE OPERACION, SERIA MAS RAPIDO SI FUERA DOBLEMENTE ENCADENADO PERO PUES HABRIA QUE CAMBIARLO TODO JAJAJ
	 if(siguiente.esPrimero())
	 {
	  siguiente.darSiguiente().setPrimero(true);//se actualiza el estado del segundo nodo a primero
	  setSiguiente(siguiente.darSiguiente()); //se elimina la relaci�n del �ltimo con el antiguo primero.
	 }
	 else
	 {
	  siguiente.dequeue();
	 }
	}

	/**
	 * objeto gen�rico almacenado por el nodo. 
	 */
	

}
