package com.test;

public class ContactData {

    private Entity shooter;
    private boolean isBullet = false;
    private Bullet bullet;

    public ContactData(Entity shooter) {
        this.shooter = shooter;
    }

    public ContactData(Bullet bullet) {
        this.shooter = bullet.shooter;
        this.bullet = bullet;
        isBullet = true;
    }

    public Entity getShooter() {
        return shooter;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public boolean isBullet() {
        return isBullet;
    }
}
