package com.p1ut0nium.animaliumcompat;

import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRecipes {
	
	public static IRecipe LEATHER, BEAR_CLAW_PAXEL, DOG_PELT_BOOTS;

	public static void init() {
		LEATHER = new ShapelessOreRecipe(getResource("recipe_pelt _to_leather"), new ItemStack(Items.LEATHER), new ItemStack(ModItems.WILD_DOG_PELT), new ItemStack(ModItems.WILD_DOG_PELT), new ItemStack(ModItems.WILD_DOG_PELT), new ItemStack(ModItems.WILD_DOG_PELT));
		LEATHER.setRegistryName(getResource(Constants.MODID + ":recipe_pelt _to_leather"));
		
		BEAR_CLAW_PAXEL = new ShapedOreRecipe(getResource("recipe_bear_claw_paxel"), new ItemStack(ModItems.BEAR_CLAW_PAXEL, 1, 0), "XXX", "XS ", "XS ", 'X', new ItemStack(ModItems.BEAR_CLAW), 'S', "stickWood");
		BEAR_CLAW_PAXEL.setRegistryName(getResource(Constants.MODID + ":recipe_bear_claw_paxel"));
		
		DOG_PELT_BOOTS = new ShapedOreRecipe(getResource("recipe_dog_pelt_boots"), new ItemStack(ModItems.DOG_PELT_BOOTS), "RPR", "PLP", "SPS", 'R', "dustRedstone", 'P', new ItemStack(ModItems.WILD_DOG_PELT), 'L', new ItemStack(Items.LEATHER_BOOTS), 'S', "slimeball");
		DOG_PELT_BOOTS.setRegistryName(getResource(Constants.MODID + ":recipe_dog_pelt_boots"));
	}

	@Mod.EventBusSubscriber(modid = Constants.MODID)
	public static class RegistrationHandlerRecipes {
		@SubscribeEvent
		public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
		@SuppressWarnings("unused")
		final IForgeRegistry<IRecipe> registry = event.getRegistry();
		event.getRegistry().registerAll(
				LEATHER,
				BEAR_CLAW_PAXEL,
				DOG_PELT_BOOTS
				);
		}
	}

	private static ResourceLocation getResource(String inName) {
		return new ResourceLocation(inName);
	}

	public static void registerSmelting() {
		GameRegistry.addSmelting(new ItemStack(ModItems.BEAR_MEAT), new ItemStack(ModItems.BEAR_MEAT_COOKED), 1F);
	}
}