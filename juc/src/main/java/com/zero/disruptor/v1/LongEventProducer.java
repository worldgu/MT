package com.zero.disruptor.v1;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @ClassName LongEventProducer
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 23:18
 * @Version 1.0
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer){
        long sequence = ringBuffer.next();

        try {
            LongEvent event = ringBuffer.get(sequence);
            event.setValue(buffer.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }

    }
}
