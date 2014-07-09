package com.imesmuaran.alternatetechnics.tileentities;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TEVerticalConveyor extends TileEntity
{
    public int timer;

    public TEVerticalConveyor()
    {
        ;
    }

    @Override
    public void updateEntity()
    {
        if (!worldObj.isRemote && check(xCoord,yCoord,zCoord) == false) {
            //worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.fence);
            //worldObj.setBlock(xCoord - 1, yCoord, zCoord, Blocks.fence);
            if (worldObj.getBlockMetadata(xCoord,yCoord + 1,zCoord) == 2 || worldObj.getBlockMetadata(xCoord,yCoord + 1,zCoord) == 3 ||
                worldObj.getBlockMetadata(xCoord,yCoord + 1,zCoord) == 2 || worldObj.getBlockMetadata(xCoord,yCoord - 1,zCoord) == 3 ||
                worldObj.getBlockMetadata(xCoord,yCoord + 1,zCoord) == 15 || worldObj.getBlockMetadata(xCoord,yCoord - 1,zCoord) == 15) {

                worldObj.setBlockMetadataWithNotify(xCoord,yCoord,zCoord, 15, 3);
            } else {
                worldObj.setBlockMetadataWithNotify(xCoord,yCoord,zCoord, 14, 3);
            }
        } else if (!worldObj.isRemote && check(xCoord,yCoord,zCoord)) {
            //worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.planks);
            //worldObj.setBlock(xCoord - 1, yCoord, zCoord, Blocks.planks);
        }
    }

    private boolean check(int x, int y, int z)
    {
        if (worldObj.getBlock(x,y + 1,z) == BlockLoader.verticalConveyor && worldObj.getBlock(x,y - 1,z) == BlockLoader.verticalConveyor) {
            return false;
        } else {
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
