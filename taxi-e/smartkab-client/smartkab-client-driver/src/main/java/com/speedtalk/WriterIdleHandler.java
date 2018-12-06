package com.speedtalk;

import org.apache.mina.core.session.IoSession;

/**
 * 当有一段时间没有向服务端发送数据时，
 * 可以重载该类的writerIdle()，实现具体操作。
 * 1、必须调用OrderClientHandler的setWriterIdle(WriterIdleHandler w)
 * 2、超时时间通过<b>ClientConnector的setWriteIdle(int seconds)设置</b>
 *
 * @author chen
 */
public abstract class WriterIdleHandler {
    public abstract void writerIdle(IoSession session);
}
