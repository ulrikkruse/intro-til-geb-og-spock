/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

baseUrl = "http://www.globalsqa.com/"

atCheckWaiting = true

waiting {
	timeout = 30
	includeCauseInMessage = true
}

reportOnTestFailureOnly = true
reportsDir = new File("build/geb-reports")
downloadsMappe = System.getProperty('user.home') + '/Downloads/nine_demo/'

environments {
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}

	// run via “./gradlew chromeHeadlessTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chromeHeadless {
		driver = {
			ChromeOptions o = new ChromeOptions()
			o.addArguments('headless')
			new ChromeDriver(o)
		}
	}

	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		atCheckWaiting = 30
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities()
        // make Selenium WebDriver scroll to bottom instead of top - this prevents many non-clickable errors:
        // https://github.com/SeleniumHQ/selenium/issues/1202
        desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1)
        // download indstillinger
        FirefoxProfile firefoxProfile = new FirefoxProfile()
        desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile)
        firefoxProfile.setPreference("browser.download.folderList", 2)
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false)
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false)
        firefoxProfile.setPreference("browser.download.dir", downloadsMappe)
        firefoxProfile.setPreference("browser.download.downloadDir", downloadsMappe)
        firefoxProfile.setPreference("browser.download.defaultFolder", downloadsMappe)
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain" )
        FirefoxOptions options = new FirefoxOptions(desiredCapabilities)
        options.setHeadless(true)
        def firefoxDriver = new FirefoxDriver(options)
        // maksimer vinduet og sæt det til en høj opløsning for at undgå situationer hvor elementer ikke kan ses
        firefoxDriver.manage().window().maximize()
        firefoxDriver.manage().window().setSize(new Dimension(1920, 1080))
        firefoxDriver
    }
}

// To run the tests with all browsers just run “./gradlew test”