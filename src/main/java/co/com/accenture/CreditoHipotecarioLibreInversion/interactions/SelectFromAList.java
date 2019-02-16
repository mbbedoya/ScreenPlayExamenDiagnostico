package co.com.accenture.CreditoHipotecarioLibreInversion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFromAList implements Interaction {

	private String elementInTheList;
	private Target target;

	public SelectFromAList(Target target, String elementInTheList) {

		this.target = target;
		this.elementInTheList = elementInTheList;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		target.resolveFor(actor).selectByVisibleText(elementInTheList);
	}

	public static SelectFromAList aElement(Target target, String elementInTheList) {

		return Tasks.instrumented(SelectFromAList.class, target, elementInTheList);

	}
}
