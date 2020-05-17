package com.p1ut0nium.animaliumcompat.client.render.entity;

import com.p1ut0nium.animaliumcompat.client.model.ModelBear;
import com.p1ut0nium.animaliumcompat.entities.EntityBear;
import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBear extends RenderLiving<EntityBear> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MODID + ":textures/entity/bear.png");

	public RenderBear(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelBear(), 0.5F);
    }

	@Override
	protected void preRenderCallback(EntityBear entity, float partialTickTime) {
		GlStateManager.scale(1.5F, 1.5F, 1.5F);
		GlStateManager.rotate(180F, 0F, 1F, 0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBear entity) {
		return TEXTURE;
	}
}
