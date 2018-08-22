package br.mv.marcos.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Steps {

	private WebDriver driver;

	@Dado("^que eu acesso a aplicação$")
	public void queEuAcessoAAplicação() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://mantis-prova.base2.com.br./login_page.php");

	}

	@Quando("^informo o usuario \"([^\"]*)\"$")
	public void informoOUsuario(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(arg1);

	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arg1);

	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
		driver.findElement(By.className("button")).click();

	}

	@Então("^vejo o painel$")
	public void vejoOPainel() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='italic']")));
		String texto = driver.findElement(By.xpath("//span[@class='italic']")).getText();
		Assert.assertEquals("marcos.lopes", texto);
		driver.findElement(By.xpath("//a[@href='/logout_page.php']")).click();

	}
	
	@Então("^vejo a mensagem \"([^\"]*)\"$")
	public void vejoAMensagem(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//font[@color='red']")));
		String texto = driver.findElement(By.xpath("//font[@color='red']")).getText();
		Assert.assertEquals(arg1, texto);
		
	}
	@After
	public void fecharBrowser() {
		driver.quit();
	}
}
