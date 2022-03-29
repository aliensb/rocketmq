package org.apache.rocketmq.test.client;

import org.apache.rocketmq.common.protocol.RequestCode;
import org.apache.rocketmq.common.protocol.header.GetAllTopicConfigResponseHeader;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

import com.alibaba.fastjson.JSON;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 描述
 *
 * @author tom@fiture.com
 * @date 2022/3/28
 */
public class GetAllHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        RemotingCommand command=RemotingCommand.createRequestCommand(RequestCode.GET_UNIT_TOPIC_LIST,null);
        ctx.channel().writeAndFlush(command);
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(JSON.toJSONString(msg));
        super.channelRead(ctx, msg);
    }
}
