package GENERIC_LIBERARY;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Date_click {
	Logger log = LogManager.getLogger();

	// year_month_date year_list arrow_webelement date_list
	public void Year_month_date(String r, List<WebElement> ye, WebElement arrow, List<WebElement> element) {
		int a = 0;

		int year = Integer.parseInt(r.split(" ")[0].trim());
		for (int i = 0; i < ye.size(); i++) {

			int y = Integer.parseInt(ye.get(i).getText().split(" ")[1].trim());
			if (year == y) {
				String month = (r.split(" ")[1].trim());
				for (int j = 0; j <= 12; j++) {

					String m = (ye.get(j).getText().split(" ")[0].trim());
					if (month.equals(m)) {
						int date = Integer.parseInt(r.split(" ")[2].trim());
						for (int k = 0; k < element.size(); k++) {
							int d = Integer.parseInt(ye.get(k).getText().split(" ")[1].trim());
							if (d == date) {
								element.get(k).click();
								if (element.get(k).isSelected()) {
									log.info("SUCCESSFULLY SELECTED THE DATE " + r);
								} else {
									log.error(r + "IS NOT SELECTED IN WIDGET");
								}
								a++;
								break;
							}
						}
						if (a == 1) {
							break;
						}
					}
					arrow.click();
				}
				if (a == 1) {
					break;
				}
			}
			arrow.click();
		}
	}

// month_date year_list arrow_webelement date_list
	public void month_date(String r, List<WebElement> ye, WebElement arrow, List<WebElement> element) {
		int a = 0;

		String month = (r.split(" ")[1].trim());
		for (int j = 0; j <= 12; j++) {
			String m = (ye.get(j).getText().split(" ")[0].trim());
			if (month.equals(m)) {
				int date = Integer.parseInt(r.split(" ")[2].trim());
				for (int k = 0; k < element.size(); k++) {
					int d = Integer.parseInt(ye.get(k).getText().split(" ")[1].trim());
					if (d == date) {
						element.get(k).click();
						if (element.get(k).isSelected()) {
							log.info("SUCCESSFULLY SELECTED THE DATE " + r);
						} else {
							log.error(r + "IS NOT SELECTED IN WIDGET");
						}

						a++;
						break;
					}
				}
				if (a == 1) {
					break;
				}
			}
			arrow.click();
		}

	}
}
