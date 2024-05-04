package Exceptions;

public class CountryNotSupported extends Exception {
    public CountryNotSupported(String countryCode) {
        super("Country: "+countryCode+" is not Supported");
    }
}
