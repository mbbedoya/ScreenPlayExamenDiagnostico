package co.com.accenture.CreditoHipotecarioLibreInversion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.avvillas.com.co/wps/portal/avvillas/")
public class AVillasHomePage extends PageObject {

	public static final Target CREDITO_HIPOTECARIO_MENU = Target.the("The option to open  Credito Hipotecario menu")
			.located(By.id("MenuCreditoHipotecario"));

	public static final Target CREDITO_HIPOTECARIO_LIBRE_INVERSION_OPTION = Target.the("The option to open Libre Inversion option")
			.located(By.id("MenuCreditoHipotecarioLibreInversion"));
}


