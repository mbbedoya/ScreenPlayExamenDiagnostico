package co.com.accenture.CreditoHipotecarioLibreInversion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/informacion-general-personas/puntos-por-todo/")
public class PuntosPorTodoPage extends PageObject {

	public static final Target ENVIAR_BUTTON = Target.the("The button to send the form").located(By.xpath(
			"//*[@id=\"layoutContainers\"]/div[1]/div[5]/div/div/section/div[2]/div[2]/div[5]/div/section/div/form/div[10]/button"));

	public static final Target DOCUMENT_MESSAGE = Target.the("The button to send the form").located(By.xpath(
			"//*[@id=\"layoutContainers\"]/div[1]/div[5]/div/div/section/div[2]/div[2]/div[5]/div/section/div/form/div[1]/span"));

	public static final Target DOCUMENT_NUMBER_MESSAGE = Target.the("The button to send the form").located(By.xpath(
			"//*[@id=\"layoutContainers\"]/div[1]/div[5]/div/div/section/div[2]/div[2]/div[5]/div/section/div/form/div[2]/span[4]"));

	public static final Target FIRST_NAME_FIELD = Target.the("The field to the first name")
			.located(By.id("primerNombre"));

	public static final Target CELL_PHONE_FIELD = Target.the("The field to Cell phone").located(By.id("campoCelular"));

	public static final Target EMAIL_FIELD = Target.the("The field to Email").located(By.id("campoCorreo"));

	public static final Target EMAIL_MESSAGE = Target.the("The message of the wrong email").located(By.xpath(
			"//*[@id=\"layoutContainers\"]/div[1]/div[5]/div/div/section/div[2]/div[2]/div[5]/div/section/div/form/div[9]/span[2]"));

	public static final Target CELL_PHONE_MESSAGE = Target.the("The message of the wrong email").located(By.xpath(
			"//*[@id=\"layoutContainers\"]/div[1]/div[5]/div/div/section/div[2]/div[2]/div[5]/div/section/div/form/div[8]/span[2]"));

	public static final Target DATE_FIELD = Target.the("The filed to establish the date")
			.located(By.id("campoFecha"));

	public static final Target TYPE_OF_ID = Target.the("the button to display the type id field")
			.located(By.name("selectTipoDocumento"));

	public static final Target ID_FIELD = Target.the("the field to fill the id").located(By.id("numeroIdentificacion"));

	public static final Target LAST_NAME_FIELD = Target.the("The field to the last name")
			.located(By.id("primerApellido"));

	
}
