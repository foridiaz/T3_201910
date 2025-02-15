package view;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;

public class MovingViolationsManagerView 
{
	public MovingViolationsManagerView() {
		
	}
	
	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Taller 3----------------------");
		System.out.println("1. Cree una nueva coleccion de infracciones en movimiento");
		System.out.println("2. Dar estadisticas diarias de las infracciones");
		System.out.println("3. Dar ultimos n infracciones que terminaron en accidente");
		System.out.println("4. Salir");
		System.out.println("Digite el n�mero de opci�n para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
	
	public void printDailyStatistics(IQueue<VODaylyStatistic> dailyStatistics) {
		System.out.println("Se encontraron "+ dailyStatistics.size() + " elementos");
		int vez=0; 
		for (VODaylyStatistic dayStatistic : dailyStatistics) 
		{
			System.out.println(dayStatistic.darFecha()+"- accidentes:"+dayStatistic.darAccidente()+",	infracciones:"	+dayStatistic.darInfracciones()+",	multas totales:"+dayStatistic.darTotalFineAMT() );;
			vez++; 
			if(vez==dailyStatistics.size()){
				break; 
			}
		}
	}
	
	public void printMovingViolations(IStack<VOMovingViolations> violations) {
		System.out.println("Se encontraron "+ violations.size() + " elementos");
		for (VOMovingViolations violation : violations) 
		{
			System.out.println(violation.objectId() + " " 
								+ violation.getTicketIssueDate() + " " 
								+ violation.getLocation()+ " " 
								+ violation.getViolationDescription());
		}
	}
	
	public void printMensage(String mensaje) {
		System.out.println(mensaje);
	}
}
