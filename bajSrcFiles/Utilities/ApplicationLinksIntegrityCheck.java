package Utilities;

import org.testng.annotations.Test;

public class ApplicationLinksIntegrityCheck extends TestBase {

	@Test
	public static void ApplicationLinksIntegrityCheckTest() {

		try {
			Utils.brokenLinksTest();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
