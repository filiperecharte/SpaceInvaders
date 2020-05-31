package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.collisions.CollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Test;
import com.spaceinvaders.model.wall.DefaultWallCreator;

import static org.junit.Assert.*;

public class CollideableVisitorTest {

    private Arena arena;
    private Shot shot;
    private CollideableVisitor collideableVisitor;

    @Test
    public void visitFragmentTest() {
        arena= new Arena(new Position(0, 0), new Size(10, 15),"FFFFFF");
        arena.addElement((new DefaultWallCreator()).build(new Position(15, 23)));

        collideableVisitor = new CollideableVisitor(arena,new Shot(new Position(3, 5), new Size(1, 1),"WeakShot","WeakShotImg"));
        collideableVisitor.visit(arena.getWalls().get(0).getFragments().get(3));

        assertEquals(23, arena.getWalls().get(0).getFragments().size());

    }


}
