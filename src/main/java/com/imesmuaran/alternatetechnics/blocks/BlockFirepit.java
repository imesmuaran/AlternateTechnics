package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.tileentities.TEFirepit;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;



public class BlockFirepit extends BlockContainer implements ITileEntityProvider{
	
	public BlockFirepit() {
		super(Material.wood);
		setBlockName("firepit");
		setCreativeTab(AlternateTechnics.tabAT);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TEFirepit();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	// It is not opaque
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	//It is not rendered normally
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}
