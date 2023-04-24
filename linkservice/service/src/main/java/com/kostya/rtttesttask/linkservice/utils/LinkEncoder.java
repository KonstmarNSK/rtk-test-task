package com.kostya.rtttesttask.linkservice.utils;

import java.util.Optional;

public final class LinkEncoder {
    private LinkEncoder() {}

    private static final char[] alphabet = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',

            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',

            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '_'
    };


    /**
     * Encodes given long using the alphabet.
     *
     * @param linkNumber number to encode
     * @param maxLength maximum length of resulting string
     * @return empty Optional if given number doesn't fit in maxLength, non-empty Optional otherwise
     */
    public static Optional<String> encode(Long linkNumber, int maxLength) {
        StringBuilder sb = new StringBuilder(maxLength);

        if(linkNumber < 0) {
            sb.append('-');
            linkNumber = -linkNumber;
        }

        long rest = linkNumber;

        while (rest != 0) {
            int idx = (int) (rest % alphabet.length);
            rest /= alphabet.length;

            sb.append(alphabet[idx]);

            if (sb.length() > maxLength) {
                return Optional.empty();
            }
        }

        return Optional.of(sb.toString());
    }
}
