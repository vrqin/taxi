package com.poctalk.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class NumberUtils {
    private static AtomicInteger seqNumber = new AtomicInteger();
    private static AtomicLong voiceDataId = new AtomicLong();

    public NumberUtils() {
    }

    public static int getNextSeqNumber() {
        return seqNumber.incrementAndGet();
    }

    public static long getNextVoiceDataId() {
        return voiceDataId.incrementAndGet();
    }

    public static void main(String[] args) {
    }
}
