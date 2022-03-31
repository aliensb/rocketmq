package org.apache.rocketmq.test.client;

import org.apache.rocketmq.common.protocol.RequestCode;
import org.apache.rocketmq.common.protocol.header.namesrv.GetRouteInfoRequestHeader;
import org.apache.rocketmq.common.protocol.route.TopicRouteData;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

import com.alibaba.fastjson.JSON;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 描述
 *
 * @author tom@fiture.com
 * @date 2022/3/28
 */
public class GetAllHandler extends SimpleChannelInboundHandler<RemotingCommand> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        GetRouteInfoRequestHeader requestHeader = new GetRouteInfoRequestHeader();
        requestHeader.setTopic("TopicTest1111");

        RemotingCommand request =
            RemotingCommand.createRequestCommand(RequestCode.GET_ROUTEINFO_BY_TOPIC, requestHeader);
        ctx.channel().writeAndFlush(request);
        super.channelActive(ctx);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RemotingCommand msg) throws Exception {
        System.out.println(JSON.toJSONString(msg));
        if (msg.getCode() == 0) {
            System.out.println("请求成功");
            System.out.println(JSON.toJSONString(JSON.parseObject(msg.getBody(), TopicRouteData.class),true));
        }else{
            System.out.println("请求失败");
        }
    }
}
