package com.scaler.lldjun24.DesignPattern.Factory;

import com.scaler.lldjun24.DesignPattern.Factory.components.Button;
import com.scaler.lldjun24.DesignPattern.Factory.components.IOSButton;
import com.scaler.lldjun24.DesignPattern.Factory.components.IOSMenu;
import com.scaler.lldjun24.DesignPattern.Factory.components.Menu;

public class IOSUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
