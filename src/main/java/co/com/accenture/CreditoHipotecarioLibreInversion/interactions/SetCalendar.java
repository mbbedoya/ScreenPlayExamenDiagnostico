package co.com.accenture.CreditoHipotecarioLibreInversion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import java.util.regex.Pattern;

public class SetCalendar implements Interaction {

	private String date;
	private Target calendar;
	private Target yearOption;
	private Target monthOption;
	private Target dayOption;

	public SetCalendar(String date, Target calendar, Target yearOption, Target monthOption, Target dayOption) {

		this.date = date;
		this.calendar = calendar;
		this.yearOption = yearOption;
		this.dayOption = dayOption;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		String[] partesDeFechaEnCadena = date.split(Pattern.quote("/"));

		String day = partesDeFechaEnCadena[0];

		String month = partesDeFechaEnCadena[1];

		String year = partesDeFechaEnCadena[2];
		
		actor.attemptsTo(Click.on(calendar));

		actor.attemptsTo(SelectFromAList.aElement(yearOption, year));
		
		actor.attemptsTo(SelectFromAList.aElement(monthOption, month));

		actor.attemptsTo(SelectFromAList.aElement(dayOption, day));
	}

	public SetCalendar date() {

		return Tasks.instrumented(SetCalendar.class);
	}

}
