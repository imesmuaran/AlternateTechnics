package com.imesmuaran.alternatetechnics.tileentities;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEWaterwheelBase extends TileEntity {

    public TEWaterwheelBase() {
        int[][] pattern = {{0,1,1,1,0},
                           {1,0,2,0,1},
                           {1,2,3,2,1},
                           {1,0,2,0,1},
                           {0,1,1,1,0}};
    }


    private boolean side() {
        if (worldObj.getBlock(xCoord + 1,yCoord,zCoord) == Blocks.fence) {

            return true;

        } else {

            return false;

        }
    }

    private boolean check() {
        for (int layer1 = 0; layer1 == 4; layer1++) {
            for (int layer2 =0; layer2 == 4; layer2++) {
                if (side() == true) {

                } else {

                }
                return true;

            }
        }
        return false;
    }

    //** Load and Save **//

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
    }

}
