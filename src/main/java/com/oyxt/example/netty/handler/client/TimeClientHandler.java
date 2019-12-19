package com.oyxt.example.netty.handler.client;

import com.oyxt.example.netty.bean.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author 20190712713
 * @date 2019/12/19 15:33
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         * 使用ByteBuf来实现
         *   ByteBuf m = (ByteBuf) msg;

            try {
                long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
                System.out.println(new Date(currentTimeMillis));
                ctx.close();
            } finally {
                m.release();
            }
         */

        UnixTime unixTime = (UnixTime) msg;
        System.out.println(unixTime);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
