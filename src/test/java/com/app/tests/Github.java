package com.app.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.app.utilities.BrowserUtils;
import com.app.utilities.TestBase;

public class Github extends TestBase {

	@Test
	public void getAllLinks() {
		driver.get("https://github.com/");
		System.out.println(BrowserUtils.getElementsTexts(By.tagName("a")));
		driver.get("https://doordash.com/");
		System.out.println(BrowserUtils.getElementsTexts(By.tagName("a")));
	}
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//
//		List<String> linkTexts = new ArrayList<>();
//
//		for (WebElement link : links) {
//			if (!link.getText().isEmpty()) {
//				linkTexts.add(link.getText());
//
//			}
//		}
//		System.out.println(linkTexts);
//	}

	
}
