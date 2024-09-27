package com.scaler.lldjun24.DesignPattern.Factory;

import com.scaler.lldjun24.DesignPattern.Factory.components.Button;
import com.scaler.lldjun24.DesignPattern.Factory.components.Menu;

public interface UIFactory {
    Button createButton();
    Menu createMenu();
}
