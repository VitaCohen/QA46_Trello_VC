package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class BoardsTests extends AppManager {
    @BeforeMethod
    public void login(){
        User user = User.builder().
                email("cohen0402@gmail.com")
                .password("336152541")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewPositiveTest(){
        Board board = Board.builder().boardTitle("123q")
                .build();
        new BoardsPage(getDriver()).createNewBoard();
    }

}
