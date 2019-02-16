package co.com.accenture.CreditoHipotecarioLibreInversion.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/productos/credito-hipotecario/credito-hipotecario-libre-inversion/")
public class CreditoHipotecarioLibreInversionPage extends PageObject{

	public static final Target SABER_MAS_BUTTON = Target.the("The button to get  Credito Hipotecario form")
			.located(By.xpath("//*[@id=\"layoutContainers\"]/div[8]/div/div/section/div[2]/section/div[2]/div/a"));
}
