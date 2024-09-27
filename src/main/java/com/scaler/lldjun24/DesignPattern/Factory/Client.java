package com.scaler.lldjun24.DesignPattern.Factory;

import com.scaler.lldjun24.DesignPattern.Factory.components.Button;
import com.scaler.lldjun24.DesignPattern.Factory.components.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.getFactory("IOS");
        Button button= uiFactory.createButton();
        button.showbutton();
        Menu menu= uiFactory.createMenu();
        menu.showMenu();
    }
}
