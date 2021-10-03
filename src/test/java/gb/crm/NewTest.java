package gb.crm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewTest {

    public static ChromeOptions options;
    public static WebDriver driver;
    public static Actions actions;
    private static final String URL = "https://crm.geekbrains.space";
    //    --------Login----------------
    private static final String idLog = "prependedInput";
    private static final String idPass = "prependedInput2";
    private static final String LOGIN = "Applanatest1";
    private static final String PASS = "Student2020!";
    //    -------find project --------------------
    private static final String projectSelect = "//div[@id='main-menu']/ul/li/a";
    private static final String projectSpan = "//span[.='Мои проекты']";
    private static final String projectAdd = "//a[@title='Создать проект']";
    private static final String projectEq = "Проекты";
    //    ---------textarea-------------
    private static final String nameArea = "//input[@name='crm_project[name]']";
    private static final String nameKey = "test347875";
    //  -----------form selector---------------------------
    private static final String organisationElement = "//span[.='Укажите организацию']";
    private static final String organisationSelect = "//div[.='12323142342134']";
    private static final String bsElement = "//select[@name='crm_project[businessUnit]']";
    private static final String bsSelector = "Research & Development";
    private static final String curatorElement = "//select[@name='crm_project[curator]']";
    private static final String curatorSelector = "Амелин Владимир";
    private static final String rpElement = "//select[@name='crm_project[rp]']";
    private static final String rpSelector = "Авласёнок Денис";
    private static final String managerElement = "//select[@name='crm_project[manager]']";
    private static final String managerSelector = "Исаева Анастасия";
    private static final String buttonSaveAndClose = "//button[contains(., 'Сохранить и закрыть')]";


    @BeforeAll
    static void before() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions().addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);
        actions = new Actions(driver);
    }

    @AfterAll
    static void after() {
        driver.quit();
    }

    @Test
    void name() {
        login();
        testNewProject();
        testForm();
    }

    public void login() {
        driver.findElement(By.id(idLog)).sendKeys(LOGIN);
        driver.findElement(By.id(idPass)).sendKeys(PASS, Keys.ENTER);
    }

    public void testForm() {
        driver.findElement(By.xpath(nameArea)).sendKeys(nameKey);

        driver.findElement(By.xpath(organisationElement)).click();
        driver.findElement(By.xpath(organisationSelect)).click();

        Select subdivisionSelect = new Select(
                driver.findElement(By.xpath(bsElement)));
        subdivisionSelect.selectByVisibleText(bsSelector);

        Select curatorSelect = new Select(
                driver.findElement(By.xpath(curatorElement)));
        curatorSelect.selectByVisibleText(curatorSelector);

        Select rpSelect = new Select(
                driver.findElement(By.xpath(rpElement)));
        rpSelect.selectByVisibleText(rpSelector);

        Select managerSelect = new Select(
                driver.findElement(By.xpath(managerElement)));
        managerSelect.selectByVisibleText(managerSelector);

        driver.findElement(By.xpath(buttonSaveAndClose)).click();
    }

     public void testNewProject() {
        List<WebElement> navMenuElements = driver.findElements(By.xpath(projectSelect));
        WebElement element = navMenuElements.stream().filter(
                e -> e.getText().equals(projectEq)).findFirst().get();

        actions.moveToElement(element).build().perform();
        driver.findElement(By.xpath(projectSpan)).click();
        driver.findElement(By.xpath(projectAdd)).click();
    }
}

