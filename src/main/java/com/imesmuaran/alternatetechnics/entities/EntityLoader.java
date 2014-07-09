package com.imesmuaran.alternatetechnics.entities;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityLoader {

    public static void EntityLoader() {

        EntityRegistry.registerModEntity(EntityDroid.class, "EntityDroid", 0, AlternateTechnics.instance, 80, 3, true);

    }

}
