package Week4Day1;



		import java.time.Duration;
		import java.util.List;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;

		import io.github.bonigarcia.wdm.WebDriverManager;

		public class FindNumberofFrames {

			public static void main(String[] args) throws InterruptedException {
				int count = 0;

				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();

				driver.get("http://leafground.com/pages/frame.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				List<WebElement> outerFrame = driver.findElements(By.tagName("iframe"));
				count = count + outerFrame.size();
				System.out.println("Before For Loop" + count);
				for (int i = 0; i < outerFrame.size(); i++) {
					driver.switchTo().frame(i);
					List<WebElement> InnerFrame = driver.findElements(By.tagName("iframe"));
					count = count + InnerFrame.size();
					driver.switchTo().defaultContent();

				}

				System.out.println("Total Number of iframe in the screen :"  +count);
			}
		

	}

