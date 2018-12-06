package com.alipay.api.internal.util.codec;


public class Base64 implements BinaryEncoder, BinaryDecoder {
    static final int CHUNK_SIZE = 76;
    /*  51 */   static final byte[] CHUNK_SEPARATOR = "\r\n".getBytes();
    static final int BASELENGTH = 255;
    static final int LOOKUPLENGTH = 64;
    static final int EIGHTBIT = 8;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    static final int FOURBYTE = 4;
    static final int SIGN = -128;
    static final byte PAD = 61;
    /*  95 */   private static byte[] base64Alphabet = new byte['ÿ'];
    /*  96 */   private static byte[] lookUpBase64Alphabet = new byte[64];


    static {
        /* 100 */
        for (int i = 0; i < 255; i++) {
            /* 101 */
            base64Alphabet[i] = -1;

        }
        /* 103 */
        for (int i = 90; i >= 65; i--) {
            /* 104 */
            base64Alphabet[i] = (byte) (i - 65);

        }
        /* 106 */
        for (int i = 122; i >= 97; i--) {
            /* 107 */
            base64Alphabet[i] = (byte) (i - 97 + 26);

        }
        /* 109 */
        for (int i = 57; i >= 48; i--) {
            /* 110 */
            base64Alphabet[i] = (byte) (i - 48 + 52);

        }

        /* 113 */
        base64Alphabet[43] = 62;
        /* 114 */
        base64Alphabet[47] = 63;

        /* 116 */
        for (int i = 0; i <= 25; i++) {
            /* 117 */
            lookUpBase64Alphabet[i] = (byte) (65 + i);

        }

        /* 120 */
        int i = 26;
        for (int j = 0; i <= 51; j++) {
            /* 121 */
            lookUpBase64Alphabet[i] = (byte) (97 + j);

            /* 120 */
            i++;

        }

        /* 124 */
        int i = 52;
        for (int j = 0; i <= 61; j++) {
            /* 125 */
            lookUpBase64Alphabet[i] = (byte) (48 + j);

            /* 124 */
            i++;

        }

        /* 128 */
        lookUpBase64Alphabet[62] = 43;
        /* 129 */
        lookUpBase64Alphabet[63] = 47;

    }


    private static boolean isBase64(byte octect) {
        /* 133 */
        if (octect == 61) {
            /* 134 */
            return true;

        }
        /* 136 */
        return base64Alphabet[octect] != -1;

    }


    public static boolean isArrayByteBase64(byte[] arrayOctect) {
        /* 152 */
        arrayOctect = discardWhitespace(arrayOctect);

        /* 154 */
        int length = arrayOctect.length;
        /* 155 */
        if (length == 0) {
            /* 158 */
            return true;

        }
        /* 160 */
        for (int i = 0; i < length; i++) {
            /* 161 */
            if (!isBase64(arrayOctect[i])) {
                /* 162 */
                return false;

            }

        }
        /* 165 */
        return true;

    }


    public static byte[] encodeBase64(byte[] binaryData) {
        /* 176 */
        return encodeBase64(binaryData, false);

    }


    public static byte[] encodeBase64Chunked(byte[] binaryData) {
        /* 187 */
        return encodeBase64(binaryData, true);

    }


    public static byte[] encodeBase64(byte[] binaryData, boolean isChunked) {
        /* 231 */
        int lengthDataBits = binaryData.length * 8;
        /* 232 */
        int fewerThan24bits = lengthDataBits % 24;
        /* 233 */
        int numberTriplets = lengthDataBits / 24;
        /* 234 */
        byte[] encodedData = null;
        /* 235 */
        int encodedDataLength = 0;
        /* 236 */
        int nbrChunks = 0;

        /* 238 */
        if (fewerThan24bits != 0) {
            /* 240 */
            encodedDataLength = (numberTriplets + 1) * 4;

        } else {
            /* 243 */
            encodedDataLength = numberTriplets * 4;

        }

        /* 249 */
        if (isChunked) {
            /* 251 */
            nbrChunks = CHUNK_SEPARATOR.length == 0 ? 0 : (int) Math.ceil(encodedDataLength / 76.0F);

            /* 253 */
            encodedDataLength += nbrChunks * CHUNK_SEPARATOR.length;

        }

        /* 256 */
        encodedData = new byte[encodedDataLength];

        /* 258 */
        byte k = 0;
        byte l = 0;
        byte b1 = 0;
        byte b2 = 0;
        byte b3 = 0;

        /* 260 */
        int encodedIndex = 0;
        /* 261 */
        int dataIndex = 0;
        /* 262 */
        int i = 0;
        /* 263 */
        int nextSeparatorIndex = 76;
        /* 264 */
        int chunksSoFar = 0;

        /* 267 */
        for (i = 0; i < numberTriplets; i++) {
            /* 268 */
            dataIndex = i * 3;
            /* 269 */
            b1 = binaryData[dataIndex];
            /* 270 */
            b2 = binaryData[(dataIndex + 1)];
            /* 271 */
            b3 = binaryData[(dataIndex + 2)];

            /* 275 */
            l = (byte) (b2 & 0xF);
            /* 276 */
            k = (byte) (b1 & 0x3);

            /* 278 */
            byte val1 = (b1 & 0xFFFFFF80) == 0 ? (byte) (b1 >> 2) : (byte) (b1 >> 2 ^ 0xC0);

            /* 280 */
            byte val2 = (b2 & 0xFFFFFF80) == 0 ? (byte) (b2 >> 4) : (byte) (b2 >> 4 ^ 0xF0);

            /* 282 */
            byte val3 = (b3 & 0xFFFFFF80) == 0 ? (byte) (b3 >> 6) : (byte) (b3 >> 6 ^ 0xFC);

            /* 285 */
            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];

            /* 289 */
            encodedData[(encodedIndex + 1)] = lookUpBase64Alphabet[(val2 | k << 4)];

            /* 291 */
            encodedData[(encodedIndex + 2)] = lookUpBase64Alphabet[(l << 2 | val3)];

            /* 293 */
            encodedData[(encodedIndex + 3)] = lookUpBase64Alphabet[(b3 & 0x3F)];

            /* 295 */
            encodedIndex += 4;

            /* 298 */
            if (!isChunked)

                continue;
            /* 300 */
            if (encodedIndex == nextSeparatorIndex) {
                /* 301 */
                System.arraycopy(CHUNK_SEPARATOR, 0, encodedData, encodedIndex, CHUNK_SEPARATOR.length);

                /* 307 */
                chunksSoFar++;
                /* 308 */
                nextSeparatorIndex = 76 * (chunksSoFar + 1) + chunksSoFar * CHUNK_SEPARATOR.length;

                /* 311 */
                encodedIndex += CHUNK_SEPARATOR.length;

            }


        }

        /* 317 */
        dataIndex = i * 3;

        /* 319 */
        if (fewerThan24bits == 8) {
            /* 320 */
            b1 = binaryData[dataIndex];
            /* 321 */
            k = (byte) (b1 & 0x3);

            /* 324 */
            byte val1 = (b1 & 0xFFFFFF80) == 0 ? (byte) (b1 >> 2) : (byte) (b1 >> 2 ^ 0xC0);

            /* 326 */
            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];
            /* 327 */
            encodedData[(encodedIndex + 1)] = lookUpBase64Alphabet[(k << 4)];
            /* 328 */
            encodedData[(encodedIndex + 2)] = 61;
            /* 329 */
            encodedData[(encodedIndex + 3)] = 61;
            /* 330 */
        } else if (fewerThan24bits == 16) {
            /* 332 */
            b1 = binaryData[dataIndex];
            /* 333 */
            b2 = binaryData[(dataIndex + 1)];
            /* 334 */
            l = (byte) (b2 & 0xF);
            /* 335 */
            k = (byte) (b1 & 0x3);

            /* 337 */
            byte val1 = (b1 & 0xFFFFFF80) == 0 ? (byte) (b1 >> 2) : (byte) (b1 >> 2 ^ 0xC0);

            /* 339 */
            byte val2 = (b2 & 0xFFFFFF80) == 0 ? (byte) (b2 >> 4) : (byte) (b2 >> 4 ^ 0xF0);

            /* 342 */
            encodedData[encodedIndex] = lookUpBase64Alphabet[val1];
            /* 343 */
            encodedData[(encodedIndex + 1)] = lookUpBase64Alphabet[(val2 | k << 4)];

            /* 345 */
            encodedData[(encodedIndex + 2)] = lookUpBase64Alphabet[(l << 2)];
            /* 346 */
            encodedData[(encodedIndex + 3)] = 61;

        }

        /* 349 */
        if (isChunked) {
            /* 351 */
            if (chunksSoFar < nbrChunks) {
                /* 352 */
                System.arraycopy(CHUNK_SEPARATOR, 0, encodedData, encodedDataLength - CHUNK_SEPARATOR.length, CHUNK_SEPARATOR.length);

            }


        }

        /* 361 */
        return encodedData;

    }


    public static byte[] decodeBase64(byte[] base64Data) {
        /* 372 */
        base64Data = discardNonBase64(base64Data);

        /* 375 */
        if (base64Data.length == 0) {
            /* 376 */
            return new byte[0];

        }

        /* 379 */
        int numberQuadruple = base64Data.length / 4;
        /* 380 */
        byte[] decodedData = null;
        /* 381 */
        byte b1 = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte marker0 = 0;
        byte marker1 = 0;

        /* 385 */
        int encodedIndex = 0;
        /* 386 */
        int dataIndex = 0;

        /* 389 */
        int lastData = base64Data.length;

        /* 391 */
        while (base64Data[(lastData - 1)] == 61) {
            /* 392 */
            lastData--;
            if (lastData == 0) {
                /* 393 */
                return new byte[0];

            }

        }
        /* 396 */
        decodedData = new byte[lastData - numberQuadruple];

        /* 399 */
        for (int i = 0; i < numberQuadruple; i++) {
            /* 400 */
            dataIndex = i * 4;
            /* 401 */
            marker0 = base64Data[(dataIndex + 2)];
            /* 402 */
            marker1 = base64Data[(dataIndex + 3)];

            /* 404 */
            b1 = base64Alphabet[base64Data[dataIndex]];
            /* 405 */
            b2 = base64Alphabet[base64Data[(dataIndex + 1)]];

            /* 407 */
            if ((marker0 != 61) && (marker1 != 61)) {
                /* 409 */
                b3 = base64Alphabet[marker0];
                /* 410 */
                b4 = base64Alphabet[marker1];

                /* 412 */
                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                /* 413 */
                decodedData[(encodedIndex + 1)] = (byte) ((b2 & 0xF) << 4 | b3 >> 2 & 0xF);

                /* 415 */
                decodedData[(encodedIndex + 2)] = (byte) (b3 << 6 | b4);
                /* 416 */
            } else if (marker0 == 61) {
                /* 418 */
                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                /* 419 */
            } else if (marker1 == 61) {
                /* 421 */
                b3 = base64Alphabet[marker0];

                /* 423 */
                decodedData[encodedIndex] = (byte) (b1 << 2 | b2 >> 4);
                /* 424 */
                decodedData[(encodedIndex + 1)] = (byte) ((b2 & 0xF) << 4 | b3 >> 2 & 0xF);

            }

            /* 427 */
            encodedIndex += 3;

        }
        /* 429 */
        return decodedData;

    }


    static byte[] discardWhitespace(byte[] data) {
        /* 440 */
        byte[] groomedData = new byte[data.length];
        /* 441 */
        int bytesCopied = 0;

        /* 443 */
        for (int i = 0; i < data.length; i++) {
            /* 444 */
            switch (data[i]) {

                case 9:

                case 10:

                case 13:

                case 32:
                    /* 449 */
                    break;

                default:
                    /* 451 */
                    groomedData[(bytesCopied++)] = data[i];

            }

        }

        /* 455 */
        byte[] packedData = new byte[bytesCopied];

        /* 457 */
        System.arraycopy(groomedData, 0, packedData, 0, bytesCopied);

        /* 459 */
        return packedData;

    }


    static byte[] discardNonBase64(byte[] data) {
        /* 472 */
        byte[] groomedData = new byte[data.length];
        /* 473 */
        int bytesCopied = 0;

        /* 475 */
        for (int i = 0; i < data.length; i++) {
            /* 476 */
            if (isBase64(data[i])) {
                /* 477 */
                groomedData[(bytesCopied++)] = data[i];

            }

        }

        /* 481 */
        byte[] packedData = new byte[bytesCopied];

        /* 483 */
        System.arraycopy(groomedData, 0, packedData, 0, bytesCopied);

        /* 485 */
        return packedData;

    }


    public Object decode(Object pObject) throws DecoderException {
        /* 204 */
        if (!(pObject instanceof byte[])) {
            /* 205 */
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");

        }
        /* 207 */
        return decode((byte[]) (byte[]) pObject);

    }


    public byte[] decode(byte[] pArray) {
        /* 218 */
        return decodeBase64(pArray);

    }


    public Object encode(Object pObject) throws EncoderException {
        /* 504 */
        if (!(pObject instanceof byte[])) {
            /* 505 */
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");

        }

        /* 508 */
        return encode((byte[]) (byte[]) pObject);

    }


    public byte[] encode(byte[] pArray) {
        /* 519 */
        return encodeBase64(pArray, false);

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.codec.Base64
 * JD-Core Version:    0.6.0
 */