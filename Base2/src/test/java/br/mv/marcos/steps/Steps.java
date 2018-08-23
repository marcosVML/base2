package br.mv.marcos.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
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

	@Dado("^que seleciono o projeto$")
	public void queAcessoOMenuDeReportIssue() throws Throwable {
		driver.findElement(By.xpath("//select[@name='project_id']")).click();
		driver.findElement(By.xpath("//option[@value='73']")).click();

	}

	@Dado("^acesso o menu de Report Issue$")
	public void selecionoOProjeto() throws Throwable {
		driver.findElement(By.xpath("//a[@href='/bug_report_page.php']")).click();
	}

	@Quando("^realizo o preenchimento de todo formulario do bug$")
	public void realizoOPreenchimentoDeTodoFormularioDoBug() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='bug_report.php']")));
		driver.findElement(By.xpath("//option[@value='33']")).click();
		driver.findElement(By.xpath("//option[@value='78']")).click();
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys("teste automatico");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("teste automatico descrisão");
		driver.findElement(By.xpath("//textarea[@name='steps_to_reproduce']")).sendKeys("teste automatico passos");
	}

	@Quando("^submeto o formulario$")
	public void submetoOFormulario() throws Throwable {
		driver.findElement(By.xpath("//input[@class='button']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='left']")));
		


	}

	@Então("^consigo visualizar o formulario no painel de bugs$")
	public void consigoVisualizarOFormularioNoPainelDeBugs() throws Throwable {
		String texto = driver.findElement(By.xpath("//td[@class='left']")).getText();
		Assert.assertEquals("teste automatico", texto);
	}
	
	@Dado("^acesso o menu de View Issues$")
	public void acessoOMenuDeViewIssues() throws Throwable {
		driver.findElement(By.xpath("//a[@href='/view_all_bug_page.php']")).click();

	}

	@Quando("^seleciono um bug da lista$")
	public void selecionoUmBugDaLista() throws Throwable {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("teste automatico");
		driver.findElement(By.xpath("//input[@class='button-small']")).click();
		String texto = driver.findElement(By.xpath("//td[@class='left']")).getText();
		Assert.assertEquals("teste automatico", texto);

	}
	
	@Quando("^seleciono um bug da lista para excluir$")
	public void selecionoUmBugDaListaParaExcluir() throws Throwable {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("teste automatico editado");
		driver.findElement(By.xpath("//input[@class='button-small']")).click();
		String texto = driver.findElement(By.xpath("//td[@class='left']")).getText();
		Assert.assertEquals("teste automatico editado", texto);
	}

	@Quando("^edito este bug$")
	public void editoEsteBug() throws Throwable {
		driver.findElement(By.xpath("//a[starts-with(@href, 'bug_update_page.php?')]")).click();		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='bug_update.php']")));
		driver.findElement(By.xpath("//option[@value='33']")).click();
		driver.findElement(By.xpath("//option[@value='78']")).click();
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys(" editado");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(" editado");
		driver.findElement(By.xpath("//textarea[@name='steps_to_reproduce']")).sendKeys(" editado");
		driver.findElement(By.xpath("//input[@class='button']")).click();
	}

	@Então("^consigo visualizar o bug alterado no formulario$")
	public void consigoVisualizarOBugAlteradoNoFormulario() throws Throwable {
		driver.findElement(By.xpath("//a[@href='/view_all_bug_page.php']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("teste automatico editado");
		driver.findElement(By.xpath("//input[@class='button-small']")).click();
		String texto = driver.findElement(By.xpath("//td[@class='left']")).getText();
		Assert.assertEquals("teste automatico editado", texto);

	}
	
	@Quando("^excluo o bug$")
	public void excluo() throws Throwable {
		driver.findElement(By.xpath("//a[starts-with(@href, '/view.php?')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete']")));
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete Issues']")));
		driver.findElement(By.xpath("//input[@value='Delete Issues']")).click();

	}

	@Então("^não consigo visualizar o bug na lista de bugs$")
	public void nãoConsigoVisualizarOBugNaListaDeBugs() throws Throwable {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("teste automatico");
		driver.findElement(By.xpath("//input[@class='button-small']")).click();
		String texto = driver.findElement(By.xpath("//td[@class='left']")).getText();
		Assert.assertEquals(" ", texto);
	}

	@After
	public void fecharBrowser() {
		driver.quit();
	}
}
