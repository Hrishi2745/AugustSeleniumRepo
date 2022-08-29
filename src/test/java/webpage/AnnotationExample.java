package webpage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationExample {
  @Test
  public void testMethod() 
  {
	  System.out.println("Test Method");
  }
  @BeforeSuite
  public void beforeSuiteMethod()
  {
	  System.out.println("BeforeSuite Method");
  }
  @BeforeTest
  public void beforeTestMethod()
  {
	  System.out.println("BeforeTest Method");
  }
  @BeforeClass
  public void beforeClassMethod()
  {
	  System.out.println("BeforeClass Method");
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("Before Method");
  }
  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("After Method");
  }
  @AfterClass
  public void afterClassMethod()
  {
	  System.out.println("AfterClass Method");
  }
  @AfterTest
  public void afterTestMethod()
  {
	  System.out.println("AfterTest Method");
  }
  @AfterSuite
  public void afterSuiteMethod()
  {
	  System.out.println("AfterSuite Method");
  }
}
