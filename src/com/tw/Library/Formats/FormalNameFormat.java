package com.tw.Library.Formats;

public class FormalNameFormat implements Format {
    @Override
    public String value(String firstName, String lastName) {
        return String.format("%s, %s", lastName, firstName);
    }
}
