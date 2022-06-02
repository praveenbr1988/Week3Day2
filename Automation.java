package week3Day2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation extends MultipleLanguage implements Language, TestTool {

	public static void main(String[] args) {
		Automation a  = new Automation();
		a.selenium();
		a.java();
		a.ruby();
		a.python();
	}

	public void selenium() {
		System.out.println("selenium");
	}

	public void java() {
		System.out.println("java");
	}

	@Override
	public void ruby() {
		System.out.println("ruby");
	}

}
