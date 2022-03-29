package org.apache.rocketmq.test.client;

import org.apache.rocketmq.remoting.netty.NettyDecoder;
import org.apache.rocketmq.remoting.netty.NettyEncoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * 描述
 *
 * @author tom@fiture.com
 * @date 2022/3/28
 */
public class GetAll {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap=new Bootstrap();
        NioEventLoopGroup group=new NioEventLoopGroup();
        bootstrap.group(group)
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyEncoder());
                        ch.pipeline().addLast(new NettyDecoder());
                        ch.pipeline().addLast(new IdleStateHandler(0, 0, 120));
                        ch.pipeline().addLast(new GetAllHandler());
                }
            }).connect("127.0.0.1",9876).sync();

    }
}
