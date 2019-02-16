package co.com.accenture.CreditoHipotecarioLibreInversion.stepdefinitions;

/**
 * @author michael.bedoya.cano
 */

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import co.com.accenture.CreditoHipotecarioLibreInversion.interactions.SelectFromAList;
import co.com.accenture.CreditoHipotecarioLibreInversion.questions.TheMessage;
import co.com.accenture.CreditoHipotecarioLibreInversion.tasks.GoTo;
import co.com.accenture.CreditoHipotecarioLibreInversion.tasks.GoToWithoutClick;
import co.com.accenture.CreditoHipotecarioLibreInversion.tasks.OpenTheBrowser;
import co.com.accenture.CreditoHipotecarioLibreInversion.tasks.TypeSomeText;
import co.com.accenture.CreditoHipotecarioLibreInversion.userinterfaces.AVillasHomePage;
import co.com.accenture.CreditoHipotecarioLibreInversion.userinterfaces.CreditoHipotecarioLibreInversionPage;
import co.com.accenture.CreditoHipotecarioLibreInversion.userinterfaces.PuntosPorTodoPage;
import co.com.accenture.CreditoHipotecarioLibreInversion.utils.FieldName;
import co.com.accenture.CreditoHipotecarioLibreInversion.utils.GetdatafromExcel;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class LibreInversionStepDefinition {

	@Managed(driver = "chrome")
	private WebDriver hisBrowser;
	private Actor michael = Actor.named("Michael");
	private AVillasHomePage aVillasHomePage;
	private GetdatafromExcel dataFile = new GetdatafromExcel();
	private ArrayList<ArrayList<String>> listOfData;
	private final int NUMBEROFTHESHEET = 0;

	@Before
	public void setUp() {
		dataFile.obtenerDatosExcel(NUMBEROFTHESHEET);
		listOfData = dataFile.getListaDeFilas();
		hisBrowser.manage().window().maximize();
		michael.can(BrowseTheWeb.with(hisBrowser));

	}

	@Given("^I am in the form page$")
	public void iAmInTheFormPage() throws Exception {
		michael.wasAbleTo(OpenTheBrowser.on(aVillasHomePage),
				GoToWithoutClick.the(AVillasHomePage.CREDITO_HIPOTECARIO_MENU),
				GoTo.the(AVillasHomePage.CREDITO_HIPOTECARIO_LIBRE_INVERSION_OPTION),
				GoTo.the(CreditoHipotecarioLibreInversionPage.SABER_MAS_BUTTON));
	}

	@When("^I click the form buttom to send it$")
	public void iClickTheFormButtomToSendIt() throws Exception {
		michael.attemptsTo(GoTo.the((PuntosPorTodoPage.ENVIAR_BUTTON)));
	}

	@Then("^I hopo to see the massege \"([^\"]*)\"$")
	public void iHopoToSeeTheMassege(String TypeDocumentmessage) throws Exception {
		michael.should(seeThat(TheMessage.of(PuntosPorTodoPage.DOCUMENT_MESSAGE), equalTo(TypeDocumentmessage)));
	}

	@Then("^the message \"([^\"]*)\" below to the field$")
	public void theMessageBelowToTheField(String NumberDocumentmessage) throws Exception {
		michael.should(seeThat(TheMessage.of(PuntosPorTodoPage.DOCUMENT_NUMBER_MESSAGE),
				containsString(NumberDocumentmessage)));

	}

	@When("^I type the information  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void iTypeTheInformation(String firstName, String cellPhone, String email) throws Exception {
		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.FIRST_NAME_FIELD, firstName));
		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.CELL_PHONE_FIELD, cellPhone));
		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.EMAIL_FIELD, email));
		michael.attemptsTo(GoTo.the((PuntosPorTodoPage.ENVIAR_BUTTON)));
	}

	@Then("^I hopo to see the massege \"([^\"]*)\" for the email field$")
	public void iHopoToSeeTheMassegeForTheEmailField(String emailWrongMessage) throws Exception {
		michael.should(seeThat(TheMessage.of(PuntosPorTodoPage.EMAIL_MESSAGE), containsString(emailWrongMessage)));
	}

	@Then("^the message \"([^\"]*)\" for the cell phone field$")
	public void theMessageForTheCellPhoneField(String cellPhoneWrongMessage) throws Exception {
		michael.should(
				seeThat(TheMessage.of(PuntosPorTodoPage.CELL_PHONE_MESSAGE), containsString(cellPhoneWrongMessage)));
	}

	@When("^I type the information completed for the (\\d+)$")
	public void iTypeTheInformationCompletedForThe(int numberOfTheUser) throws Exception {

		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.ID_FIELD,
				listOfData.get(numberOfTheUser).get(FieldName.ID_NUMBER.getValue())));
		michael.attemptsTo(
				SelectFromAList.aElement(PuntosPorTodoPage.TYPE_OF_ID, listOfData.get(numberOfTheUser).get(0)));
		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.FIRST_NAME_FIELD, listOfData.get(numberOfTheUser).get(2)));
		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.LAST_NAME_FIELD, listOfData.get(numberOfTheUser).get(3)));

		// michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.DATE_FIELD,listOfData.get(numberOfTheUser).get(4)));

		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.CELL_PHONE_FIELD, listOfData.get(numberOfTheUser).get(5)));
		michael.attemptsTo(TypeSomeText.on(PuntosPorTodoPage.EMAIL_FIELD, listOfData.get(numberOfTheUser).get(6)));
		michael.attemptsTo(GoTo.the((PuntosPorTodoPage.ENVIAR_BUTTON)));
	}

	@Then("^I hopo to see the massege \"([^\"]*)\" in the next page$")
	public void iHopoToSeeTheMassegeInTheNextPage(String arg1) throws Exception {

	}

}
