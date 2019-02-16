package co.com.accenture.CreditoHipotecarioLibreInversion.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetdatafromExcel {
	private String nombreDelArchivo = "./src/test/resources/datadrive/DataDriveExcel.xlsx";

	ArrayList<ArrayList<String>> listaDeFilas = new ArrayList<ArrayList<String>>();
	private int filas;
	private int columnas;

	GetdatafromExcel(String rutaCompletaDelArchivoConNombre) {
		nombreDelArchivo = rutaCompletaDelArchivoConNombre;
	}

	public GetdatafromExcel() {

	}

	public void obtenerDatosExcel(int hoja) {

		try {

			FileInputStream archivoDeExcel = new FileInputStream(new File(nombreDelArchivo));
			Workbook archivoDeTrabajoExcel = new XSSFWorkbook(archivoDeExcel);
			Sheet tipoDeHoja = archivoDeTrabajoExcel.getSheetAt(hoja);
			Iterator<Row> iterator = tipoDeHoja.iterator();
			boolean ignorarPrmeraFila = false; // variable auxiliar para que tome los datos depues de la primera fila
			boolean noAlmacenarPrimeraFila = false;
			filas = tipoDeHoja.getPhysicalNumberOfRows();

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				columnas = currentRow.getPhysicalNumberOfCells();
				ArrayList<String> nuevaFila = new ArrayList<String>();

				// Se agrega este if-else para ignorar el alamcenamiento de los datos de la fila
				// 1
				if (ignorarPrmeraFila) {

					while (cellIterator.hasNext()) {

						String campoActual = null;
						Cell currentCell = cellIterator.next();
						currentCell.setCellType(Cell.CELL_TYPE_STRING);
						campoActual = currentCell.toString();

						if (campoActual.equals("") || campoActual.isEmpty() || campoActual == null) {
							System.out.println("---------------------------------------------------HAY UN CAMPO NULO");
						} else {
							System.out.println("---------------------------------\n" + campoActual);
							nuevaFila.add(campoActual);
						}

					}
				} else {
					ignorarPrmeraFila = true;
				}
				// Se agrega este if-else para evitar que se almacene la primera fila nula
				if (noAlmacenarPrimeraFila) {
					listaDeFilas.add(nuevaFila);
				} else {
					noAlmacenarPrimeraFila = true;
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void iniciarProcesamientoDeExcel(int obtenerElemento) {

		listaDeFilas.get(obtenerElemento);

	}

	public String getNombreDelArchivo() {
		return nombreDelArchivo;
	}

	public void setNombreDelArchivo(String fileName) {
		this.nombreDelArchivo = fileName;
	}

	public ArrayList<ArrayList<String>> getListaDeFilas() {
		return listaDeFilas;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void abrirArchivo(String nombreDelArchivo) {
		String archivoLocal = new String(nombreDelArchivo);

		try {
			Runtime.getRuntime().exec("cmd /c start" + archivoLocal);
		} catch (Exception e) {

		}
	}
}
