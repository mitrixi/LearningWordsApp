package com.learningwordsapp.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class UUIDGenerator {

    public static byte[] createUUID() {

        UUID uuid = UUID.randomUUID();
        byte[] uuidByte = new byte[16];

        ByteBuffer.wrap(uuidByte)
                .order(ByteOrder.BIG_ENDIAN)
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());

        return uuidByte;
    }

    public static String getUuidFromByteArray(byte[] binaryUUID) {
        if (binaryUUID.length != 16) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        long msl = 0;
        for (; i < 8; i++) {
            msl = (msl << 8) | (binaryUUID[i] & 0xFF);
        }
        long lsl = 0;
        for (; i < 16; i++) {
            lsl = (lsl << 8) | (binaryUUID[i] & 0xFF);
        }
        return new UUID(msl, lsl).toString();
    }
}
