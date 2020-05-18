package com.spaceinvaders.model.element;

import com.spaceinvaders.model.element.IElementsVisitor;

public interface IElementVisited {
    void accept(IElementsVisitor visitor);
}
