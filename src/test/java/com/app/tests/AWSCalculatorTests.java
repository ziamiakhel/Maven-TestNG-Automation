
package com.app.tests;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.app.pages.AwsCalculatorPage;
import com.app.utilities.TestBase;

public class AWSCalculatorTests extends TestBase {

	AwsCalculatorPage calculator = new AwsCalculatorPage();

	@Test(priority = 0, description = "Monthly bill should be $0.00 by default")
	public void defaultMonthlyBillTest() {
		assertTrue(calculator.isAt());
		assertEquals(0.0, calculator.getMonthlyBillAmount());
	}

	@Test(priority = 1)
	public void addedEc2DefaultValuesTest() {
		calculator.addEc2.click();
		assertTrue(calculator.description.getAttribute("value").isEmpty());
		assertEquals(1, calculator.getIntanceCount());
		assertEquals(100, Integer.parseInt(calculator.usageCount.getAttribute("value")));
		assertEquals(calculator.getUsageOption(), "% Utilized/Month");
		assertEquals(calculator.ec2Type.getText(), "Linux on t1.micro");
		assertEquals(calculator.billingOption.getText(), "On-Demand (No Contract)");
		assertEquals(calculator.getMonthlyCost(), 14.64);
		double servicesTabMonthlyCost = calculator.getMonthlyCost();
		calculator.billLabel.click();
		double billTabMonthlyCost= Double.parseDouble(calculator.monthlyBillCostBeforeDiscounts.getAttribute("value"));
		assertEquals(servicesTabMonthlyCost, billTabMonthlyCost);
		calculator.services.click();
	}

	@Test(priority = 2)
	public void clearFormTest() {
		calculator.clearForm.click();
		assertTrue(calculator.checkClearAlert());

		/*
		 * Verify alert is displayed and text is " Please Confirm Are you sure you want
		 * to clear all entries in this form
		 */
		String popupText = calculator.confirmDialog.getText();

		assertTrue(popupText.contains("Please Confirm")
				&& popupText.contains("Are you sure you want to clear all entries in this service form?"));
		calculator.OK.click();
		//System.out.println(calculator.isEC2InstancesTableClear());
		
		assertEquals(calculator.isEC2InstancesTableClear(), true);
	}

}
