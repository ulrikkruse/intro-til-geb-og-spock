/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/

import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

baseUrl = "http://www.globalsqa.com/"

waiting {
    timeout = 30
    includeCauseInMessage = true
}

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
        atCheckWaiting = 1
        driver = {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities()
            desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1)
            FirefoxOptions options = new FirefoxOptions(desiredCapabilities)
            options.setHeadless(true)
            def firefoxDriver = new FirefoxDriver(options)
            firefoxDriver.manage().window().maximize()
            firefoxDriver.manage().window().setSize(new Dimension(1920, 1080))
            firefoxDriver
        }
    }
}

// To run the tests with all browsers just run “./gradlew test”
