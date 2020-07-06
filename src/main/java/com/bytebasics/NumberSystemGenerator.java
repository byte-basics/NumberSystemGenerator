package com.bytebasics;

public class NumberSystemGenerator {

    public String generateSingleDigitValueString(int numberBase) {
        checkIfValidNumberBase(numberBase);
        return generateSingleDigitString(numberBase);
    }

    private void checkIfValidNumberBase(int numberBase) {
        checkNumberBaseLowerBound(numberBase);
        checkNumberBaseUpperBound(numberBase);
    }

    private void checkNumberBaseLowerBound(int numberBase) {
        int validNumberBaseLowerBound = 2;
        if(numberBase < validNumberBaseLowerBound) {
            throw new IllegalArgumentException("Number base argument "  + numberBase +
                    " is less than the lower bound of this program: "
                    + validNumberBaseLowerBound);
        }
    }

    private void checkNumberBaseUpperBound(int numberBase) {
        int validNumberBaseUpperBound = 36;
        if(numberBase > validNumberBaseUpperBound) {
            throw new IllegalArgumentException("Number base argument "  + numberBase +
                    " is greater than the upper bound of this program: "
                    + validNumberBaseUpperBound);
        }
    }

    private String generateSingleDigitString(int numberBase) {
        StringBuilder builder = new StringBuilder();
        for(int  i = 0; i < numberBase; i++) {
            if(i > 9) {
                builder.append(convertNumberGreaterThan9ToChar(i));
            } else {
                builder.append(i);
            }
            builder.append(" ");
        }
        return convertBuilderToStringAndRemoveLastCharacter(builder);
    }

    private char convertNumberGreaterThan9ToChar(int num) {
        int letterAInAscii = 65;
        num = num - 10; // Need to subtract 10 as want 10 to be A, 11 B etc
        return (char)(letterAInAscii + num);
    }

    private String convertBuilderToStringAndRemoveLastCharacter(StringBuilder sb) {
        return sb.substring(0, sb.length() - 1);
    }

    public String generateColumnValues(int numberBase) {
        checkIfValidNumberBase(numberBase);
        return generateColumnValueString(numberBase);
    }

    private String generateColumnValueString(int numberBase) {
        int numRequiredColumnValues = 5;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRequiredColumnValues; i++) {
            builder.append((int)Math.pow(numberBase, i));
            builder.append(" ");
        }
        return convertBuilderToStringAndRemoveLastCharacter(builder);
    }
}
