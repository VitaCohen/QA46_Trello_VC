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


public class BoardsTests extends AppManager {
    @BeforeMethod(alwaysRun = true)
    public void login(Method method) {
        User user = User.builder().
                email("cohen0402@gmail.com")
                .password("336152541")
                .build();
        logger.info("start method --> " + method.getName()
                + "whis data user" + user);
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test(groups = {"smoke"})
    public void createNewPositiveTest() {
        Board board = Board.builder().boardTitle(generateString(5))
                .build();
        new BoardsPage(getDriver()).createNewBoard(board);
        Assert.assertTrue(new MyBoardPage(getDriver())
                .validateBoardName(board.getBoardTitle(), 10));

    }

    @Test
    public void createNewNegativeTest() {
        Board board = Board.builder().boardTitle("")
                .build();
        new BoardsPage(getDriver()).setBtnCreateNewBoardNegative(board);
        Assert.assertTrue(new BoardsPage(getDriver()).buttonCreateIsNotClicable());

    }

}
