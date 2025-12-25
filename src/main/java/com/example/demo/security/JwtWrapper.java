package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class JwsWrapper implements Jws<Claims> {

    private final Jws<Claims> delegate;

    public JwsWrapper(Jws<Claims> delegate) {
        this.delegate = delegate;
    }

    public Claims getPayload() {
        return delegate.getBody();
    }

    @Override
    public Claims getBody() {
        return delegate.getBody();
    }

    @Override
    public String getSignature() {
        return delegate.getSignature();
    }

    @Override
    public String getAlgorithm() {
        return delegate.getAlgorithm();
    }

    @Override
    public String getHeader() {
        return delegate.getHeader();
    }
}
