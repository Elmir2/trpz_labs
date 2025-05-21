package org.example.visitor;

abstract class BrowserResource {
    public abstract void accept(ResourceVisitor visitor);
}

