package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.lang.reflect.Method;

import static utils.RandomUtils.*;

public class DeleteBoardTests extends AppManager {

    BoardsPage boardsPage;

    @BeforeMethod
    public void login(Method method) {
        User user = User.builder().
                email("cohen0402@gmail.com")
                .password("336152541")
                .build();
        logger.info("start method --> " + method.getName()
                + "whis data user" + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder().boardTitle(generateString(6)).build();
        boardsPage.createNewBoard(board);
        //new MyBoardPage(getDriver()).goToBoardsPage();


    }


    @Test(groups = {"smoke"})
    public void deleteFirstBoardTestPositive() {
        //boardsPage.openFirstBoard();
        new MyBoardPage(getDriver()).deleteBoard();
        Assert.assertTrue(boardsPage.validatePopUpMessage("Board deleted."));
    }


}
