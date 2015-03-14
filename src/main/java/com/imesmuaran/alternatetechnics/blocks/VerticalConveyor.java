package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.reference.Reference;
import com.imesmuaran.alternatetechnics.tileentities.TEVerticalConveyor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class VerticalConveyor extends BlockContainer
{
    public VerticalConveyor(Material material)
    {
        super(material);
        setHardness(2.0F);
        setStepSound(Block.soundTypeMetal);
        setBlockName("verticalConveyor");
        this.setCreativeTab(AlternateTechnics.tabAT);
        setHarvestLevel("pickaxe",0);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    //** Metadata depending on rotation **//

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = determineOrientation(par1World, par2, par3, par4, par5EntityLivingBase);
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
    }

    public static int determineOrientation(World par0World, int par1, int par2, int par3, EntityLivingBase par4EntityLivingBase) {
        if (MathHelper.abs((float)par4EntityLivingBase.posX - (float)par1) < 2.0F && MathHelper.abs((float)par4EntityLivingBase.posZ - (float)par3) < 2.0F) {
            double d0 = par4EntityLivingBase.posY + 1.82D - (double)par4EntityLivingBase.yOffset;

            if (d0 - (double)par2 > 2.0D) {
                return 1;
            }

            if ((double)par2 - d0 > 0.0D) {
                return 0;
            }
        }
        int l = MathHelper.floor_double((double)(par4EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }

    //** Textures **//

    @SideOnly(Side.CLIENT)
    protected IIcon sideIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon convIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon transIcon;

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (meta == 2 || meta == 3) {
            return side == 2 ? this.sideIcon : (side == 3 ? this.sideIcon : this.convIcon);
        } else if (meta == 4 || meta == 5) {
            return side == 4 ? this.sideIcon : (side == 5 ? this.sideIcon : this.convIcon);
        } else if (meta == 15) {
            return side == 2 ? this.sideIcon : (side == 3 ? this.sideIcon : this.transIcon);
        } else if (meta == 14) {
            return side == 4 ? this.sideIcon : (side == 5 ? this.sideIcon : this.transIcon);
        } else {
            return side == 2 ? this.sideIcon : (side == 3 ? this.sideIcon : this.convIcon);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister var1)
    {
        sideIcon = var1.registerIcon(Reference.MOD_ID + ":" + "verticalConveyor_side");
        convIcon = var1.registerIcon(Reference.MOD_ID + ":" + "verticalConveyor");
        transIcon = var1.registerIcon(Reference.MOD_ID + ":" + "verticalConveyor_v2");
    }


    public TileEntity createNewTileEntity(World world, int var1)
    {
        return new TEVerticalConveyor();
    }

}
