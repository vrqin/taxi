package com.speedtalk;

import org.apache.mina.core.session.IoSession;

/**
 * 当有一段时间没有接收到服务端的数据时，
 * 可以重载该类的readIdle()，实现具体操作。
 * 1、必须调用OrderClientHandler的setReaderIdle(ReaderIdleHandler r)
 * 2、超时时间通过<b>ClientConnector的setReadIdle(int seconds)设置</b>
 *
 * @author chen
 */
public abstract class ReaderIdleHandler {
    public abstract void readIdle(IoSession session);
}
