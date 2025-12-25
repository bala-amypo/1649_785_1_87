package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;

public class JwsWrapper implements Jws<Claims> {

    private final Jws<Claims> delegate;

    public JwsWrapper(Jws<Claims> delegate) {
        this.delegate = delegate;
    }

    // Extra method that your tests use:
    public Claims getPayload() {
        return delegate.getBody();
    }

    // ---- Methods required by Jws<Claims> ----

    @Override
    public JwsHeader getHeader() {
        return delegate.getHeader();
    }

    @Override
    public Claims getBody() {
        return delegate.getBody();
    }

    @Override
    public String getSignature() {
        return delegate.getSignature();
    }
}
