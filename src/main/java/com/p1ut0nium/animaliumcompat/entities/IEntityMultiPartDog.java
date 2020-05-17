package com.p1ut0nium.animaliumcompat.entities;

import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public interface IEntityMultiPartDog
{
    World getWorld();

    boolean attackEntityFromPart(EntityDogPart dogPart, DamageSource source, float damage);

}