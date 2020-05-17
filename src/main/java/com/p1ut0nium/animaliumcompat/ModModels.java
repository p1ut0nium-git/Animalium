package com.p1ut0nium.animaliumcompat;

import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Constants.MODID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class ModModels {
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(ModItems.WILD_DOG_PELT, 0, new ModelResourceLocation(Constants.MODID + ":wild_dog_pelt", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DOG_PELT_BOOTS, 0, new ModelResourceLocation(Constants.MODID + ":dog_boots", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BEAR_MEAT, 0, new ModelResourceLocation(Constants.MODID + ":bear_meat", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BEAR_MEAT_COOKED, 0, new ModelResourceLocation(Constants.MODID + ":bear_meat_cooked", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BEAR_CLAW, 0, new ModelResourceLocation(Constants.MODID + ":bear_claw", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BEAR_CLAW_PAXEL, 0, new ModelResourceLocation(Constants.MODID + ":bear_claw_paxel", "inventory"));
	}
}
