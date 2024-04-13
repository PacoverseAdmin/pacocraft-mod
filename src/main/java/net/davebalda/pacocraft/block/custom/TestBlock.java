package net.davebalda.pacocraft.block.custom;

import net.minecraft.world.level.block.Block;

public class TestBlock extends Block {

    public TestBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public float getSpeedFactor() {
        return super.getSpeedFactor() + 30;
    }
}
