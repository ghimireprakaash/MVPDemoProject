package com.example.mvpdemo;

public class Presenter {
    private final User user;
    private final View view;

    public Presenter(View view) {
        user = new User();
        this.view = view;
    }

    public void emptyUsername(String msg){
        user.setUsername(msg);
        view.updateUsername(user.getUsername());
    }

    public void emptyUserEmail(String msg){
        user.setEmail(msg);
        view.updateUserEmail(user.getEmail());
    }

    public void updateUsername(String username){
        user.setUsername(username);
        view.updateUsername(user.getUsername());
    }

    public void updateUserEmail(String email){
        user.setEmail(email);
        view.updateUserEmail(user.getEmail());
    }

    interface View{
        void updateUsername(String name);
        void updateUserEmail(String email);
        void showProgressBar();
        void hideProgressBar();
    }
}
