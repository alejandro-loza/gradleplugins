package com.training.gradleplugins.auth


import com.google.common.base.Optional
import com.training.gradleplugins.core.User
import com.yammer.dropwizard.auth.AuthenticationException
import com.yammer.dropwizard.auth.Authenticator
import com.yammer.dropwizard.auth.basic.BasicCredentials

public class ExampleAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if (  "nomicka@clickonero.com".equalsIgnoreCase(credentials.getUsername()) &&"secreto".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername(), null))
        }
        return Optional.absent()
    }
}
