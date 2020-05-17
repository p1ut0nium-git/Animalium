package com.p1ut0nium.animaliumcompat;

import com.p1ut0nium.animaliumcompat.configs.ConfigHandler;
import com.p1ut0nium.animaliumcompat.entities.EntityBear;
import com.p1ut0nium.animaliumcompat.entities.EntityNeutralBear;
import com.p1ut0nium.animaliumcompat.entities.EntityPiranha;
import com.p1ut0nium.animaliumcompat.entities.EntityWildDog;
import com.p1ut0nium.animaliumcompat.proxy.CommonProxy;
import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.MODVERSION, acceptableRemoteVersions="1.12.2",  guiFactory = "animalium.configs.ConfigGuiFactory", dependencies = "after:BiomesOPlenty")

public class Animalium {

	@Instance(Constants.MODID)
	public static Animalium INSTANCE;

	@SidedProxy(clientSide = Constants.CLIENTPROXY, serverSide = Constants.COMMONPROXY)
	public static CommonProxy PROXY;
	public static ToolMaterial TOOL_BEAR_CLAW_PAXEL = EnumHelper.addToolMaterial("BEAR_CLAW_PAXEL", 2, 1079, 8.0F, 4.0F, 14);
	public static ArmorMaterial ARMOR_DOG_PELT = EnumHelper.addArmorMaterial("ARMOR_DOG_PELT", "wild_dog_pelt", 19, new int[] { 2, 3, 2, 2 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F);

	public static CreativeTabs TAB = new CreativeTabs("animalium") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack (ModItems.BEAR_CLAW_PAXEL);
		}
	};

	@SuppressWarnings("deprecation")
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.INSTANCE.loadConfig(event);

		ModItems.init();
		ModRecipes.init();
		ModRecipes.registerSmelting();

		EntityRegistry.registerModEntity(getEntityResource("piranha"), EntityPiranha.class, "piranha", 1, this, 120, 1, true, -126, -48326583);
		EntitySpawnPlacementRegistry.setPlacementType(EntityPiranha.class, SpawnPlacementType.IN_WATER);

		EntityRegistry.registerModEntity(getEntityResource("wild_dog"), EntityWildDog.class, "wild_dog", 2, this, 120, 1, true, -310, -65179583);
		EntitySpawnPlacementRegistry.setPlacementType(EntityWildDog.class, SpawnPlacementType.ON_GROUND);

		EntityRegistry.registerModEntity(getEntityResource("bear"), EntityBear.class, "bear", 3, this, 120, 1, true, -3546547, -65179583);
		EntitySpawnPlacementRegistry.setPlacementType(EntityBear.class, SpawnPlacementType.ON_GROUND);

		EntityRegistry.registerModEntity(getEntityResource("bear_tamed"), EntityNeutralBear.class, "bear_tamed", 5, this, 120, 1, true, -3546547, -65179583);
		EntitySpawnPlacementRegistry.setPlacementType(EntityBear.class, SpawnPlacementType.ON_GROUND);

		PROXY.registerRenderers();

		for (Biome allBiomes : ForgeRegistries.BIOMES.getValues()) {
			if (BiomeDictionary.hasType(allBiomes, Type.WATER) || BiomeDictionary.hasType(allBiomes, Type.SWAMP))
				if(ConfigHandler.PIRANHA_SPAWN_PROBABILITY > 0 && ConfigHandler.PIRANHA_MIN_SPAWN_SIZE > 0 && ConfigHandler.PIRANHA_MAX_SPAWN_SIZE > 0)
					EntityRegistry.addSpawn(EntityPiranha.class, ConfigHandler.PIRANHA_SPAWN_PROBABILITY, ConfigHandler.PIRANHA_MIN_SPAWN_SIZE, ConfigHandler.PIRANHA_MAX_SPAWN_SIZE, EnumCreatureType.MONSTER, allBiomes);
			if (!BiomeDictionary.hasType(allBiomes, Type.WATER)) {
				if(ConfigHandler.WILD_DOG_SPAWN_PROBABILITY > 0 && ConfigHandler.WILD_DOG_MIN_SPAWN_SIZE > 0 && ConfigHandler.WILD_DOG_MAX_SPAWN_SIZE > 0)
					EntityRegistry.addSpawn(EntityWildDog.class, ConfigHandler.WILD_DOG_SPAWN_PROBABILITY, ConfigHandler.WILD_DOG_MIN_SPAWN_SIZE, ConfigHandler.WILD_DOG_MAX_SPAWN_SIZE, EnumCreatureType.MONSTER, allBiomes);
				if(ConfigHandler.BEAR_SPAWN_PROBABILITY > 0 && ConfigHandler.BEAR_MIN_SPAWN_SIZE > 0 && ConfigHandler.BEAR_MAX_SPAWN_SIZE > 0)
					EntityRegistry.addSpawn(EntityBear.class, ConfigHandler.BEAR_SPAWN_PROBABILITY, ConfigHandler.BEAR_MIN_SPAWN_SIZE, ConfigHandler.BEAR_MAX_SPAWN_SIZE, EnumCreatureType.MONSTER, allBiomes);
				}
		}
	}

	private static ResourceLocation getEntityResource(String entityName) {
		return new ResourceLocation(Constants.MODID, entityName);
	}

	@EventHandler
	public void posInit(FMLPostInitializationEvent event) {
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(ConfigHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(ModItems.DOG_PELT_BOOTS);
	}
}