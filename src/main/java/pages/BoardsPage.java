package pages;
import dto.Board;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardsPage extends BasePage {

    public BoardsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[text()='Create new board']")
    WebElement btnCreateNewBoard;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    WebElement inputBoardTitle;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    WebElement buttonCreateBoardSubmit;

    @FindBy(xpath = "//a[@class='board-tile mod-light-background']")
    WebElement firstBoard;

    @FindBy(xpath = "//span[@class='QMKgZFIlTLiEJN']")
    WebElement popUpMessageBoardDelete;

   // public void openFirstBoard(){
     //   clickWait(firstBoard, 3);
    //}

    public boolean validateUrl() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("boards"));

    }
    public void createNewBoard(Board board) {
        clickWait(btnCreateNewBoard, 10);
        inputBoardTitle.sendKeys(board.getBoardTitle());
        clickWait(buttonCreateBoardSubmit,10);
    }

   public void setBtnCreateNewBoardNegative(Board board){
       clickWait(btnCreateNewBoard, 3);
       inputBoardTitle.sendKeys(board.getBoardTitle());
   }

   public boolean buttonCreateIsNotClicable(){
        return  new WebDriverWait(driver, Duration.ofSeconds(3))
                .until((ExpectedConditions.not(ExpectedConditions
                        .elementToBeClickable(buttonCreateBoardSubmit))));

   }

   public boolean validatePopUpMessage(String text){
        return validateTextInElementWait(popUpMessageBoardDelete,text,5);
   }


}
