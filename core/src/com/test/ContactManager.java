package com.test;

import com.badlogic.gdx.physics.box2d.*;

public class ContactManager implements ContactListener {


    @Override
    public void beginContact(Contact contact) {
        Fixture f1 = contact.getFixtureA();
        Fixture f2 = contact.getFixtureB();
        ContactData d1 = null;
        ContactData d2 = null;

        if(f1.getUserData() instanceof ContactData) {
            d1 = (ContactData) f1.getUserData();
        }
        if(f2.getUserData() instanceof ContactData) {
            d2 = (ContactData) f2.getUserData();
        }

        if(d1 != null && d2 != null) {
            // Hit by bullet //
            if(d1.getShooter() != d2.getShooter()) {
                if(d1.isBullet() && !d2.isBullet()) {
                    d2.getShooter().hitBy(d1.getBullet());

                }  if(d2.isBullet() && !d1.isBullet()) {
                    d1.getShooter().hitBy(d2.getBullet());
                    // Jamais utilisé normalement
                }
            }
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
