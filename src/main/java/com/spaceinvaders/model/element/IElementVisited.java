package com.spaceinvaders.model.element;

public interface IElementVisited {
    void accept(IElementsVisitor visitor);
}
