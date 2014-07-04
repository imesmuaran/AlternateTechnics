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
        //timer = 60;
    }

    @Override
    public void updateEntity()
    {
        if (!worldObj.isRemote && check(xCoord,yCoord,zCoord) == 0) {

            worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.fence);

        } else if (!worldObj.isRemote && check(xCoord,yCoord,zCoord) == 1 ) {

            worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.planks);

        } /*else if (timer > 0) {

            timer--;

        } else {

            timer = -1;

        } */
    }

    private int check(int x, int y, int z)
    {
        if (worldObj.getBlock(x,y + 1,z) == BlockLoader.verticalConveyor && worldObj.getBlock(x,y - 1,z) == BlockLoader.verticalConveyor) {
            return 0;

        } else if (worldObj.getBlock(x,y + 1,z) == BlockLoader.verticalConveyor && worldObj.getBlock(x,y - 1,z) != BlockLoader.verticalConveyor) {

            return 1;

        } else if (worldObj.getBlock(x,y - 1,z) == BlockLoader.verticalConveyor && worldObj.getBlock(x,y + 1,z) != BlockLoader.verticalConveyor) {

            return 1;

        } else {
            return 1;
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
