package com.imesmuaran.alternatetechnics.tileentities;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVerticalConveyor extends TileEntity
{
    public int timer;

    public TileEntityVerticalConveyor()
    {

    }

    @Override
    public void updateEntity()
    {
        if (!worldObj.isRemote && check(xCoord,yCoord,zCoord) == false) {

            worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.fence);

        } else if (!worldObj.isRemote && check(xCoord,yCoord,zCoord)) {

            worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.planks);

        }
    }

    private boolean check(int x, int y, int z)
    {
        if (worldObj.getBlock(x,y + 1,z) == BlockLoader.verticalConveyor && worldObj.getBlock(x,y - 1,z) == BlockLoader.verticalConveyor) {

            worldObj.setBlockMetadataWithNotify(x,y,z, 1, 3);
            return false;

        } else {

            worldObj.setBlockMetadataWithNotify(x,y,z, 2, 3);
            return true;

        }
    }

    //** Load and Save **//

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("Timer", (short)timer);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        timer = compound.getShort("Timer");
    }

}
