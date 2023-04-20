package com.test;

public class DamageText {

    private String text;
    private float lifeTime;

    private float currentLifeTime;

    public DamageText(String text, float lifeTime) {
        this.text = text;
        this.lifeTime = lifeTime;
        currentLifeTime = 0;

    }
}
