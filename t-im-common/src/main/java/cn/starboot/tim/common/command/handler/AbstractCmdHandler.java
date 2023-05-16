package cn.starboot.tim.common.command.handler;

import cn.starboot.tim.common.ImChannelContext;
import cn.starboot.tim.common.command.TIMCommandType;
import cn.starboot.tim.common.packet.ImPacket;
import cn.starboot.tim.common.packet.proto.RespPacketProto;

/**
 * 抽象命令处理器
 * Created by DELL(mxd) on 2022/9/6 13:04
 */
public abstract class AbstractCmdHandler<C extends ImChannelContext> implements CmdHandler<C> {

	protected ImPacket getImPacket(ImChannelContext imChannelContext) {
		return getImPacket(imChannelContext, null);
	}

	protected ImPacket getImPacket(ImChannelContext imChannelContext,
								   TIMCommandType timCommandType) {
		return getImPacket(imChannelContext, timCommandType, null);
	}

	protected ImPacket getImPacket(ImChannelContext imChannelContext,
								   TIMCommandType timCommandType,
								   RespPacketProto.RespPacket.ImStatus imStatus) {
		return getImPacket(imChannelContext, timCommandType, imStatus, null);
	}

	protected ImPacket getImPacket(ImChannelContext imChannelContext,
								   TIMCommandType timCommandType,
								   RespPacketProto.RespPacket.ImStatus imStatus,
								   byte[] data) {
		return imChannelContext.getConfig().getImPacketFactory().createImPacket(timCommandType, imStatus, data);
	}

	protected boolean verify(boolean ...booleans) {
		boolean r = true;
		for (boolean b:
				booleans) {
			r = r && b;
		}
		return r;
	}
}
