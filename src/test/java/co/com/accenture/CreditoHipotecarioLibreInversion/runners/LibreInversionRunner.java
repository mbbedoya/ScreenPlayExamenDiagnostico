package co.com.accenture.CreditoHipotecarioLibreInversion.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features",
        tags= {"@SentTheFormWithGoodInformation"},
        glue="co.com.accenture.CreditoHipotecarioLibreInversion.stepdefinitions",
        snippets=SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = false,
        plugin = {"json:reportJson/cucumber.json"})

public class LibreInversionRunner {}

