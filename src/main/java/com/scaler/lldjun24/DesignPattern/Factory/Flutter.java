package com.scaler.lldjun24.DesignPattern.Factory;

public class Flutter {
    void refreshUi()
    {
        System.out.println("Refreshing UI from Flutter Class");
    }

    void setTheme()
    {
        System.out.println("Setting theme from Flutter Class");
    }

    UIFactory getFactory(String platform)
    {
        if(platform.equals("Windows"))
        {
            return new WindowsUIFactory();
        }

        else if(platform.equals("IOS"))
        {
            return new IOSUIFactory();
        }
        return null;
    }
}
