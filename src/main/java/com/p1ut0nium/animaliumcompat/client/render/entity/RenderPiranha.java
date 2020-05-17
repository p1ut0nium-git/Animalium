package com.p1ut0nium.animaliumcompat.client.render.entity;

import com.p1ut0nium.animaliumcompat.client.model.ModelPiranha;
import com.p1ut0nium.animaliumcompat.entities.EntityPiranha;
import com.p1ut0nium.animaliumcompat.reference.Constants;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPiranha extends RenderLiving<EntityPiranha> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MODID + ":textures/entity/piranha.png");

	public RenderPiranha(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelPiranha(), 0.5F);
    }

	@Override
	protected void preRenderCallback(EntityPiranha entity, float f) {
		if (entity.isGrounded() && !entity.isLeaping()) {
			GlStateManager.translate(0F, 0.5F, 0F);
			GlStateManager.rotate(90F, 0F, 0F, 1F);
			GlStateManager.translate(-0.7F, 0.7F, 0F);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPiranha entity) {
		return TEXTURE;
	}
}
