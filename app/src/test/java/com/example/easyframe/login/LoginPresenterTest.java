package com.example.easyframe.login;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoginPresenterTest {

    @Test
    public void getLoginCallbackSuccessWhenViewAttached() {
        LoginPresenter presenter = new LoginPresenter();
        RecordingLoginView view = new RecordingLoginView();

        presenter.attachView(null, view);
        presenter.getLogin();

        assertEquals(1, view.loginSuccessCount);
    }

    @Test
    public void resultDoesNotCallbackAfterViewDetached() {
        LoginPresenter presenter = new LoginPresenter();
        RecordingLoginView view = new RecordingLoginView();

        presenter.attachView(null, view);
        presenter.detachView();
        presenter.result();

        assertEquals(0, view.loginSuccessCount);
    }

    private static class RecordingLoginView implements LoginView {
        private int loginSuccessCount;

        @Override
        public void loginSuccess() {
            loginSuccessCount++;
        }

        @Override
        public void showLoading() {
        }

        @Override
        public void dismiss() {
        }

        @Override
        public void loadEmpty(int type, String content) {
        }
    }
}
