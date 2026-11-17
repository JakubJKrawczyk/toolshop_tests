package utilities.internal.models.contact;

import utilities.internal.models.user.UserResponse;

public class ContactResponseFull extends ContactResponseAuthenticated{

    public UserResponse user;

    public ContactReplyResponse[] replies;
}
