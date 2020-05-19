package com.learningwordsapp.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class UUIDUtil {

    public static byte[] createByteUUID() {

        UUID uuid = UUID.randomUUID();
        byte[] uuidByte = new byte[16];

        ByteBuffer.wrap(uuidByte)
                .order(ByteOrder.BIG_ENDIAN)
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits());

        return uuidByte;
    }


}
