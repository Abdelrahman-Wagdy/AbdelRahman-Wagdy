package browserActions;

import driverSingleton.driverSingleton;
import org.openqa.selenium.*;

public class browserActions {
    public static WebDriver getDriver(){
        return driverSingleton.getDriver();
    }

    public static void setDriver(String type){
        driverSingleton.setDriver(type);
    }
    public static void navigate(String url){
        getDriver().get(url);
    }
    public static void quit(){
        getDriver().quit();
    }
    public static String getUrl(){
        return getDriver().getCurrentUrl();
    }
    private static boolean elementExist(String findElementBy,String element){
        if (findElementBy.equalsIgnoreCase("xpath")){
            try{
                getDriver().findElement(By.xpath(element));
                return true;
            } catch (NoSuchElementException e){
                return false;
            }
        } else if(findElementBy.equalsIgnoreCase("id")){
            try{
                getDriver().findElement(By.id(element));
                return true;
            } catch (NoSuchElementException e){
                return false;
            }
        } else if(findElementBy.equalsIgnoreCase("name")){
            try{
                getDriver().findElement(By.name(element));
                return true;
            } catch (NoSuchElementException e){
                return false;
            }
        }
        return false;
    }
    public static WebElement getElement(String findElementBy,String element){
        if(elementExist(findElementBy, element)){
            if (findElementBy.equalsIgnoreCase("xpath")){
                return getDriver().findElement(By.xpath(element));
            }else if(findElementBy.equalsIgnoreCase("id")){
                return getDriver().findElement(By.id(element));
            }else if(findElementBy.equalsIgnoreCase("name")){
                return getDriver().findElement(By.name(element));
            }
        }
        return null;
    }
    public static boolean locatedCenter(String findElementBy,String value){
        WebElement element = getElement(findElementBy, value);
        if(getWindowXSize() / (elementXLocation(element) + objectWidth(element)/2) == 2){
            System.out.println("Center");
            return true;
        }
        return false;
    }
    public static int objectWidth(WebElement element){
        return element.getSize().getWidth();
    }
    public static int elementXLocation(WebElement element){
        Point point = element.getLocation();
        return point.getX();
    }
    public static int elementYLocation(WebElement element){
        Point point = element.getLocation();
        return point.getY();
    }
    public static int getWindowXSize(){
        return getDriver().manage().window().getSize().getWidth();
    }
    public static int getWindowYSize(){
        return getDriver().manage().window().getSize().getHeight();
    }
    public static void close(){
        getDriver().quit();
    }
}
