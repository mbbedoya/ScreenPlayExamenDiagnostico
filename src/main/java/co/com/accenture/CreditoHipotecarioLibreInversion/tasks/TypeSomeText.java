package co.com.accenture.CreditoHipotecarioLibreInversion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class TypeSomeText implements Task {

	private String word;

	private Target target;
	private String text;

	public TypeSomeText(Target target, String text) {

		this.target = target;
		this.text = text;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(GoToWithoutClick.the(target));
		actor.attemptsTo(Enter.theValue(text).into(target));
	}

	public static TypeSomeText on(Target target, String text) {

		return Tasks.instrumented(TypeSomeText.class, target, text);
	}

}
