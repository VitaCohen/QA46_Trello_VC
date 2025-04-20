package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage {

    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;

    @FindBy(xpath = "//button[@aria-label='Show menu']")
    // @FindBy(xpath = "//button[@aria-label = 'Меню']")
    WebElement btnMenuDots;

    @FindBy(xpath = "//*[text()='Close board']")
    WebElement btnCloseBoard;

    @FindBy(xpath = "//button[@data-testid='popover-close-board-confirm']")
    WebElement btnCloseBoardConfirm;

    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;

    @FindBy(xpath = "//*[text()='Delete']")
    WebElement btnDeleteConfirm;

    public boolean validateBoardName(String text, int time) {
        return validateTextInElementWait(boardName, text, time);
    }

    public void deleteBoard() {
        clickWait(btnMenuDots, 5);
        clickWait(btnCloseBoard, 5);
        clickWait(btnCloseBoardConfirm, 5);
        pause(5);
        clickWait(btnMenuDots, 5);
        clickWait(btnDeleteBoard, 5);
        clickWait(btnDeleteConfirm, 5);


    }

//    public void goToBoardsPage(){
//        driver.get("https://trello.com/u/cohen0402/boards");
//    }

}
