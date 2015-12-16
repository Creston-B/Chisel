package team.chisel.client.render.type;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import team.chisel.api.render.BlockRenderType;
import team.chisel.api.render.IBlockRenderType;
import team.chisel.api.render.IChiselTexture;
import team.chisel.api.render.TextureSpriteCallback;
import team.chisel.client.render.ctx.CTMBlockRenderContext;
import team.chisel.client.render.texture.ChiselTextureCTM;
import team.chisel.common.util.EnumConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Block RenderType for CTM
 */
@BlockRenderType("CTM")
public class BlockRenderTypeCTM implements IBlockRenderType {

    @Override
    public IChiselTexture makeTexture(EnumWorldBlockLayer layer, TextureSpriteCallback... sprites){
        return new ChiselTextureCTM(this, layer, sprites);
    }

    @Override
    public CTMBlockRenderContext getBlockRenderContext(IBlockAccess world, BlockPos pos){
        List<EnumConnection> connections = new ArrayList<EnumConnection>();
        for (EnumConnection connection : EnumConnection.values()) {
            if (connection.isValid(pos, world)) {
                connections.add(connection);
            }
        }
        return new CTMBlockRenderContext(connections);
    }

    @Override
    public int getQuadsPerSide(){
        return 4;
    }
    
    @Override
    public int requiredTextures() {
        return 2;
    }
}
