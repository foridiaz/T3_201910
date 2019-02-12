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
	 * Relación de cola/pila en lista simplemente encadenada
	 */
	private Nodo<T> siguiente;
	
	//Método Constructor
	public Nodo (T pElemento)
	{
		//Para construir un nodo es necesario conocer el elemento de entrada, si es primero o ultimo.
		elemento= pElemento;
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
	 * método encargado de retornar el elemento almacenado en el nodo. 
	 */
	public T darElemento()
	{
		return elemento;
	}

	/**
	 * método que retorna el siguiente nodo. 
	 */
	public Nodo<T> darSiguiente()
	{
		return siguiente;
	}
	
	/**
	 * método para enqueue un nuevo elemento estando en el último nodo. 
	 *@param  nuevoUltimo tiene inicializacion primero= false, ultimo =true
	 */
	public void enqueue(T elemento)
	{
		Nodo<T> nuevoUltimo= new Nodo(elemento);
		nuevoUltimo.setSiguiente(siguiente); //el siguiente nodo al último es el primero, por lo tanto se añade inicialmente
		setSiguiente(nuevoUltimo); //el nodo primero tiene como nuevo anterior el nuevo nodo		
	}

	/**
	 * método para dequeue el primer elemento estando en el último elemento. 
	 *@return elemento retorna el elemento T del nodo eliminado.
	 */
	public T dequeue()
	{
		T elElemento = siguiente.darElemento();
		setSiguiente(siguiente.darSiguiente()); //se elimina la relación del último con el antiguo primero.
		return elElemento;
	}




}
