package com.p1ut0nium.animaliumcompat.proxy;

import com.p1ut0nium.animaliumcompat.client.render.entity.RenderBear;
import com.p1ut0nium.animaliumcompat.client.render.entity.RenderPiranha;
import com.p1ut0nium.animaliumcompat.client.render.entity.RenderWildDog;
import com.p1ut0nium.animaliumcompat.entities.EntityBear;
import com.p1ut0nium.animaliumcompat.entities.EntityPiranha;
import com.p1ut0nium.animaliumcompat.entities.EntityWildDog;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityPiranha.class, RenderPiranha::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityWildDog.class, RenderWildDog::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, RenderBear::new);
	}
}