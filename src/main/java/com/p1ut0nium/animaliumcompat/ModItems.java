package com.p1ut0nium.animaliumcompat;

import java.util.ArrayList;
import java.util.List;

import com.p1ut0nium.animaliumcompat.items.ItemBearClawPaxel;
import com.p1ut0nium.animaliumcompat.items.ItemDogPeltBoots;
import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	public static Item WILD_DOG_PELT, BEAR_MEAT, BEAR_MEAT_COOKED, BEAR_CLAW, BEAR_CLAW_PAXEL, DOG_PELT_BOOTS;
	
	public static void init() {
	WILD_DOG_PELT = new Item().setCreativeTab(Animalium.TAB);
	WILD_DOG_PELT.setRegistryName(Constants.MODID, "wild_dog_pelt").setUnlocalizedName(Constants.MODID + ".wild_dog_pelt");

	BEAR_MEAT = new ItemFood(3, 0.3F, true).setCreativeTab(Animalium.TAB);
	BEAR_MEAT.setRegistryName(Constants.MODID, "bear_meat").setUnlocalizedName(Constants.MODID + ".bear_meat");

	BEAR_MEAT_COOKED = new ItemFood(8, 0.8F, true).setCreativeTab(Animalium.TAB);
	BEAR_MEAT_COOKED.setRegistryName(Constants.MODID, "bear_meat_cooked").setUnlocalizedName(Constants.MODID + ".bear_meat_cooked");

	BEAR_CLAW = new Item().setCreativeTab(Animalium.TAB);
	BEAR_CLAW.setRegistryName(Constants.MODID, "bear_claw").setUnlocalizedName(Constants.MODID + ".bear_claw");

	BEAR_CLAW_PAXEL = new ItemBearClawPaxel(Animalium.TOOL_BEAR_CLAW_PAXEL);
	BEAR_CLAW_PAXEL.setRegistryName(Constants.MODID, "bear_claw_paxel").setUnlocalizedName(Constants.MODID + ".bear_claw_paxel");

	DOG_PELT_BOOTS = new ItemDogPeltBoots();
	DOG_PELT_BOOTS.setRegistryName(Constants.MODID, "dog_boots").setUnlocalizedName(Constants.MODID + ".dog_boots");
	}
	
	@Mod.EventBusSubscriber(modid = Constants.MODID)
	public static class RegistrationHandlerItems {
		public static final List<Item> ITEMS = new ArrayList<Item>();

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] items = {
					WILD_DOG_PELT,
					BEAR_MEAT,
					BEAR_MEAT_COOKED,
					BEAR_CLAW,
					BEAR_CLAW_PAXEL,
					DOG_PELT_BOOTS
					};
			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
