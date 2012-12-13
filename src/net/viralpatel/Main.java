package net.viralpatel;

import net.viralpatel.annotations.DefaultStringValue;
import net.viralpatel.annotations.Key;

interface LoginConstants extends Constants {
	   @DefaultStringValue("Wellcome to my super app")
	   @Key("appDescription")
	   String appDescription();

	   @DefaultStringValue("Ok")
	   @Key("okButtonLabel")
	   String okButtonLabel();
}

public class Main {
	public static void main(String[] args) {
		LoginConstants constants = DynamicProperty.create(LoginConstants.class);
		System.out.println(constants.appDescription());
		System.out.println(constants.okButtonLabel());
	}
}
