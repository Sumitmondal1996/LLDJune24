package com.scaler.lldjun24.DesignPattern.Factory;

import com.scaler.lldjun24.DesignPattern.Factory.components.Button;
import com.scaler.lldjun24.DesignPattern.Factory.components.Menu;
import com.scaler.lldjun24.DesignPattern.Factory.components.WindowsButton;
import com.scaler.lldjun24.DesignPattern.Factory.components.WindowsMenu;

public class WindowsUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }
}
