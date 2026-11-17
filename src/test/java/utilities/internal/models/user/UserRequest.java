package utilities.internal.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;

    public String address;

    public String city;

    public String state;

    public String country;

    public String postcode;

    public String phone;

    public String dob;

    public String email;

    public String password;
}
