package com.imesmuaran.alternatetechnics.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigurationHandler
{

   public static Configuration configuration;

    public static void init(File configFile)
    {
        //Create Config File
        configuration = new Configuration(configFile);

        boolean statusLeben = false;

        try
        {
            //Load Config
            configuration.load();

            //Read Config
            statusLeben = configuration.get(Configuration.CATEGORY_GENERAL, "lebenExistent",true, "Ob Leben existiert").getBoolean(true);
        }
        catch (Exception e)
        {
            //Log Exception
        }
        finally
        {
            //Save Config
            if (configuration.hasChanged())
            {
                configuration.save();
            }

        }

        System.out.println(statusLeben);

    }
}
