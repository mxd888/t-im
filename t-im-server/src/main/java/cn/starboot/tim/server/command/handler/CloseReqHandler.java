package cn.starboot.tim.server.command.handler;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.starboot.tim.common.ImChannelContext;
import cn.starboot.tim.common.command.TIMCommandType;
import cn.starboot.tim.common.exception.ImException;
import cn.starboot.tim.common.packet.ImPacket;
import cn.starboot.tim.common.packet.proto.ClosePacketProto;
import cn.starboot.tim.server.ImServerChannelContext;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by DELL(mxd) on 2021/12/25 14:48
 */
public class CloseReqHandler extends AbstractServerCmdHandler {

    private static final Logger log = LoggerFactory.getLogger(CloseReqHandler.class);

    @Override
    public TIMCommandType command() {
        return TIMCommandType.COMMAND_CLOSE_REQ;
    }

	@Override
    public ImPacket handler(ImPacket imPacket, ImServerChannelContext imChannelContext) throws InvalidProtocolBufferException {
        ClosePacketProto.ClosePacket closePacket = ClosePacketProto.ClosePacket.parseFrom(imPacket.getData());
        if (ObjectUtil.isEmpty(closePacket) || StrUtil.isEmpty(closePacket.getUserId())) {
            log.error("用户发送异常关闭请求，将其强行断开");
        }
        // 执行断开操作
        return null;
    }
}
