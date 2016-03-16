package com.tw.Library.Formats;

public class InformalNameFormat implements Format {
    @Override
    public String value(String firstName,String lastName) {
        return String.format("%s %s",firstName,lastName);
    }
}
