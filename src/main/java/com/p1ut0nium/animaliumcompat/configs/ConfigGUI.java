package com.p1ut0nium.animaliumcompat.configs;

import java.util.ArrayList;
import java.util.List;

import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class ConfigGUI extends GuiConfig {
	public static final String MOD_ID = Constants.MODID;

	public ConfigGUI(GuiScreen parent) {
		super(parent, getElements(), MOD_ID, MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.INSTANCE.CONFIG.toString()));
	}

	private static List<IConfigElement> getElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		for (String category : ConfigHandler.INSTANCE.usedCategories)
			list.add(new ConfigElement(ConfigHandler.INSTANCE.CONFIG.getCategory(category.toLowerCase())));
		return list;
	}
}